package d.q.a.a.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ f f68384a;

    public h(f fVar) {
        this.f68384a = fVar;
    }

    public final String a() {
        return b("TRANSACTION_getDeviceId", "iphonesubinfo");
    }

    public final String b(String str, String str2) {
        String f2;
        Parcel c2;
        Context context;
        String str3 = "";
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        f2 = this.f68384a.f(str2);
        if (TextUtils.isEmpty(f2)) {
            return "";
        }
        obtain.writeInterfaceToken(f2);
        if (Build.VERSION.SDK_INT >= 23) {
            context = f.f68379d;
            obtain.writeString(context.getPackageName());
        }
        c2 = this.f68384a.c(str2, str, obtain, obtain2);
        if (c2 != null) {
            try {
                obtain2.readException();
                str3 = obtain2.readString();
            } catch (SecurityException unused) {
                return "";
            }
        }
        obtain2.recycle();
        obtain.recycle();
        return str3;
    }

    public final String c() {
        return b("TRANSACTION_getIccSerialNumber", "iphonesubinfo");
    }
}
