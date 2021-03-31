import java.util.Comparator;
import java.util.Objects;

public class ToStringHashCodeCompareTo implements Comparable {
    String name;
    String email;
    Integer phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToStringHashCodeCompareTo tshcc = (ToStringHashCodeCompareTo) o;
        return name.equals(tshcc.name) && email.equals(tshcc.email) && phoneNumber.equals(tshcc.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber);
        /* OR
        int hashValue = 11;
        hashValue = 31 * hashValue + name.hashCode();
        hashValue = 31 * hashValue + email.hashCode();
        hashValue = 31 * hashValue + phoneNumber.hashCode(); //or just phoneNumber
        return hashValue;
        */
    }

    @Override
    public int compareTo(Object o) {
        ToStringHashCodeCompareTo zo = (ToStringHashCodeCompareTo)o;

        int value = zo.name.compareTo(this.name);
        if(value != 0) return value;

        value = zo.email.compareTo(this.email);
        if(value != 0) return value;

        value = zo.phoneNumber.compareTo(this.phoneNumber);
        if(value != 0) return value;

        return 0;

    }
}
