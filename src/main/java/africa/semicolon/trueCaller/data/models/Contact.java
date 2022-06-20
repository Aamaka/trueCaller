package africa.semicolon.trueCaller.data.models;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Contact {

    private int id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String phoneNumber;

    public Contact(String firstName, String phoneNumber) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }
}
