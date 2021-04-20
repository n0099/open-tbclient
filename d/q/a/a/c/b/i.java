package d.q.a.a.c.b;

import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ f f68385a;

    public i(f fVar) {
        this.f68385a = fVar;
    }

    public final String a() {
        String f2;
        Parcel c2;
        String str = "";
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        f2 = this.f68385a.f("wifi");
        if (TextUtils.isEmpty(f2)) {
            return "";
        }
        obtain.writeInterfaceToken(f2);
        c2 = this.f68385a.c("wifi", "TRANSACTION_getConnectionInfo", obtain, obtain2);
        if (c2 != null) {
            try {
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    try {
                        Class<?> cls = Class.forName("android.net.wifi.WifiInfo");
                        Object obj = cls.getDeclaredField("CREATOR").get(cls);
                        Object invoke = obj.getClass().getMethod("createFromParcel", Parcel.class).invoke(obj, obtain2);
                        Field declaredField = cls.getDeclaredField("mMacAddress");
                        declaredField.setAccessible(true);
                        str = (String) declaredField.get(invoke);
                    } catch (Throwable th) {
                        b.c(th);
                    }
                }
            } catch (SecurityException unused) {
                return "";
            }
        }
        obtain2.recycle();
        obtain.recycle();
        return str;
    }
}
