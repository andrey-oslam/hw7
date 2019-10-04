import java.util.NoSuchElementException;
import java.util.function.Supplier;

/**
 * @author Andrey Oslam
 */

public class MyOptional<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private MyOptional(T data) {
        this.data = data;
    }

    boolean isPresent() {
        return data != null;
    }

    public T get() {
        if (data != null) {
            return data;
        } else {
            throw new NoSuchElementException("Error");
        }
    }

    static <T> MyOptional<T> of(T data) {
        if (data == null) {
            throw new NullPointerException("Error");
        } else
            return new MyOptional<>(data);
    }

    static <T> MyOptional<T> ofNullable(T data) {
        if (data != null) {
            return new MyOptional<T>(data);
        } else
            return empty();
    }

    public static <T> MyOptional<T> empty() {
        return new MyOptional<T>(null);
    }

    public T orElse(T data) {
        if (isPresent()) {
            return this.data;
        } else {
            return data;
        }
    }

    public boolean equals(Object obj) {
        if (!obj.equals(this.data)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        if (isPresent()) {
            return data.hashCode();
        } else
            return 0;
    }

    public void ifPresent(MyOptional<? super T> data) {
        if (isPresent()) {
            System.out.println(data);
            if (data == null) {
                throw new NullPointerException("The value=0");
            }
        }
    }

    public T orElseGet(Supplier<? extends T> other) {
        if (isPresent()) {
            return data;
        } else {
            if (other != null) {
                return (T) other.get();
            } else {
                throw new NullPointerException("Error");
            }
        }
    }
}

