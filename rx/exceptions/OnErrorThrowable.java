package rx.exceptions;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.coc;
import com.baidu.tieba.vjc;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class OnErrorThrowable extends RuntimeException {
    public static final long serialVersionUID = -569558213262703934L;
    public final boolean hasValue;
    public final Object value;

    /* loaded from: classes2.dex */
    public static class OnNextValue extends RuntimeException {
        public static final long serialVersionUID = -3454462756050397899L;
        public final Object value;

        /* loaded from: classes2.dex */
        public static final class a {
            public static final Set<Class<?>> a = a();

            public static Set<Class<?>> a() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + renderValue(obj));
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th) {
                    obj = th.getMessage();
                }
            }
            this.value = obj;
        }

        public static String renderValue(Object obj) {
            if (obj == null) {
                return StringUtil.NULL_STRING;
            }
            if (a.a.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String b = coc.c().b().b(obj);
            if (b != null) {
                return b;
            }
            return obj.getClass().getName() + ".class";
        }

        public Object getValue() {
            return this.value;
        }
    }

    public OnErrorThrowable(Throwable th) {
        super(th);
        this.hasValue = false;
        this.value = null;
    }

    public static OnErrorThrowable from(Throwable th) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable b = vjc.b(th);
        if (b instanceof OnNextValue) {
            return new OnErrorThrowable(th, ((OnNextValue) b).getValue());
        }
        return new OnErrorThrowable(th);
    }

    public OnErrorThrowable(Throwable th, Object obj) {
        super(th);
        this.hasValue = true;
        if (!(obj instanceof Serializable)) {
            try {
                obj = String.valueOf(obj);
            } catch (Throwable th2) {
                obj = th2.getMessage();
            }
        }
        this.value = obj;
    }

    public static Throwable addValueAsLastCause(Throwable th, Object obj) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable b = vjc.b(th);
        if ((b instanceof OnNextValue) && ((OnNextValue) b).getValue() == obj) {
            return th;
        }
        vjc.a(th, new OnNextValue(obj));
        return th;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }
}
