1. Có thể move/dời class chứa hàm main sang nơi khác không? Vì sao?
  Có thể di chuyển class chứa hàm main sang một package khác, nhưng cần lưu ý lớp đó phải nằm trong package cha hoặc các package con của package đã khai báo. Nếu không có khai báo thì không thể nào chạy được.

2.Nghiên cứu @OneToOne, nó khác gì @ManyToOne?
  So sánh sự khác biệt
  
    .Số lượng thực thể liên quan:
      @OneToOne: Một đối tượng chỉ liên kết với duy nhất một đối tượng của bảng khác.
      @ManyToOne: Một đối tượng có thể liên kết với nhiều đối tượng của bảng khác.  
      
    .Sử dụng trong thực tế:
      @OneToOne: Dùng khi có mối quan hệ chặt chẽ và logic giữa hai thực thể, chẳng hạn như User và UserProfile.
      @ManyToOne: Dùng khi nhiều đối tượng thuộc về cùng một nhóm, ví dụ như nhiều Employee thuộc về một Department.
    
    .Cấu trúc bảng:
      @OneToOne: Hai bảng thường sử dụng chung một khóa chính hoặc một bảng sẽ chứa khóa ngoại tham chiếu tới bảng kia.
      @ManyToOne: Một bảng chứa khóa ngoại tham chiếu tới bảng chủ.
  
3. Nghiên cứu quan hệ 2 chiều (bidirectional relationship), chú ý mappedBy
   - Định nghĩa mappedBy:
      . mappedBy được sử dụng trên phía "nghịch đảo" (inverse side) của mối quan hệ. Nó chỉ ra rằng trường này không sở hữu mối quan hệ; thay vào đó, nó ánh xạ đến thuộc tính sở hữu trong thực thể đối tác.  mappedBy chỉ ra rằng mối quan hệ này được ánh xạ bởi thuộc tính cụ thể của thực thể khác và nó phải trùng tên với tên thuộc tính bên sở hữu.
  
  - Ví Dụ
    . Quan hệ 1-1 hai chiều
        ```java
      @Entity
  public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
  
      @OneToOne(mappedBy = "user") // "user" là tên thuộc tính bên UserProfile
      private UserProfile userProfile;
  }
  @Entity
  public class UserProfile {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
  
      @OneToOne
      @JoinColumn(name = "user_id") // Khóa ngoại lưu trữ trong bảng này
      private User user;
  }
