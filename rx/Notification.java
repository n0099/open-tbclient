package rx;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes10.dex */
public final class Notification<T> {
    public static final Notification<Void> d = new Notification<>(Kind.OnCompleted, null, null);
    public final Kind a;
    public final Throwable b;
    public final T c;

    /* loaded from: classes10.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> a() {
        return (Notification<T>) d;
    }

    public Kind d() {
        return this.a;
    }

    public Throwable e() {
        return this.b;
    }

    public T f() {
        return this.c;
    }

    public boolean g() {
        if (j() && this.b != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (k() && this.c != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = d().hashCode();
        if (h()) {
            hashCode = (hashCode * 31) + f().hashCode();
        }
        if (g()) {
            return (hashCode * 31) + e().hashCode();
        }
        return hashCode;
    }

    public boolean i() {
        if (d() == Kind.OnCompleted) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (d() == Kind.OnError) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (d() == Kind.OnNext) {
            return true;
        }
        return false;
    }

    public Notification(Kind kind, T t, Throwable th) {
        this.c = t;
        this.b = th;
        this.a = kind;
    }

    public static <T> Notification<T> b(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> c(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.d() != d()) {
            return false;
        }
        T t = this.c;
        T t2 = notification.c;
        if (t != t2 && (t == null || !t.equals(t2))) {
            return false;
        }
        Throwable th = this.b;
        Throwable th2 = notification.b;
        if (th != th2 && (th == null || !th.equals(th2))) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(WebvttCueParser.CHAR_SPACE);
        sb.append(d());
        if (h()) {
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(f());
        }
        if (g()) {
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(e().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
