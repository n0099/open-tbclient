package d.r.a.a.c.b;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: d  reason: collision with root package name */
    public static Context f68526d;

    /* renamed from: a  reason: collision with root package name */
    public final Class f68527a;

    /* renamed from: b  reason: collision with root package name */
    public h f68528b;

    /* renamed from: c  reason: collision with root package name */
    public i f68529c;

    public f() {
        this.f68527a = g();
        this.f68528b = new h(this);
        this.f68529c = new i(this);
    }

    public /* synthetic */ f(byte b2) {
        this();
    }

    public static f d(Context context) {
        f fVar;
        f68526d = context;
        fVar = g.f68530a;
        return fVar;
    }

    public static Class g() {
        try {
            return Class.forName("android.os.ServiceManager");
        } catch (ClassNotFoundException e2) {
            b.c(e2);
            return null;
        }
    }

    public final Parcel c(String str, String str2, Parcel parcel, Parcel parcel2) {
        Object obj;
        int i;
        String f2 = f(str);
        if (f2 != null && str2 != null) {
            try {
                obj = this.f68527a.getDeclaredMethod("getService", String.class).invoke(null, str);
                try {
                    Field declaredField = Class.forName(f2 + "$Stub").getDeclaredField(str2);
                    declaredField.setAccessible(true);
                    i = declaredField.getInt(null);
                } catch (Throwable th) {
                    th = th;
                    b.c(th);
                    i = -1;
                    if (obj != null) {
                        try {
                            ((IBinder) obj).transact(i, parcel, parcel2, 0);
                        } catch (Throwable th2) {
                            b.c(th2);
                        }
                        return parcel2;
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = null;
            }
            if (obj != null && i >= 0) {
                ((IBinder) obj).transact(i, parcel, parcel2, 0);
                return parcel2;
            }
        }
        return null;
    }

    public final String f(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        String str2 = null;
        try {
            ((IBinder) this.f68527a.getDeclaredMethod("getService", String.class).invoke(null, str)).transact(1598968902, obtain, obtain2, 0);
            str2 = obtain2.readString();
        } finally {
            try {
                return str2;
            } finally {
            }
        }
        return str2;
    }
}
