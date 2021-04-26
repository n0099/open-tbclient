package d.a.b.a.a.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.sapi2.result.OneKeyLoginResult;
import d.a.b.a.a.a.a.c;
import d.a.b.a.a.a.a.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f39277b;

    /* renamed from: a  reason: collision with root package name */
    public Context f39278a;

    public a(Context context) {
        this.f39278a = context.getApplicationContext();
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f39277b == null) {
                synchronized (a.class) {
                    if (f39277b == null) {
                        f39277b = new a(context.getApplicationContext());
                    }
                }
            }
            aVar = f39277b;
        }
        return aVar;
    }

    public final i a(String str) {
        return new c(this.f39278a).c(str);
    }

    public Pair c(String str) {
        i a2 = a(str);
        long j = -1;
        if (a2.d()) {
            try {
                j = d.a.b.a.a.e.a.a(a2.f39275a);
                return new Pair(0, Long.valueOf(j));
            } catch (IllegalArgumentException unused) {
                return new Pair(Integer.valueOf((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL), Long.valueOf(j));
            }
        }
        return new Pair(Integer.valueOf(a2.f39276b), -1L);
    }
}
