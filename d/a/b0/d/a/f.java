package d.a.b0.d.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f39380a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39381b;

    public f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
        int type = activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
        this.f39380a = type;
        this.f39381b = (activeNetworkInfo == null || type != 0) ? 0 : activeNetworkInfo.getSubtype();
    }

    public boolean a() {
        return this.f39380a == 0;
    }

    public boolean b() {
        return d() == 1;
    }

    public final int c() {
        switch (this.f39381b) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
            default:
                return 4;
        }
    }

    public int d() {
        int i2 = this.f39380a;
        if (i2 != 0) {
            return i2 != 1 ? 0 : 1;
        }
        return c();
    }
}
