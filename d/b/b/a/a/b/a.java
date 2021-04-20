package d.b.b.a.a.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.sapi2.result.OneKeyLoginResult;
import d.b.b.a.a.a.a.c;
import d.b.b.a.a.a.a.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f41929b;

    /* renamed from: a  reason: collision with root package name */
    public Context f41930a;

    public a(Context context) {
        this.f41930a = context.getApplicationContext();
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f41929b == null) {
                synchronized (a.class) {
                    if (f41929b == null) {
                        f41929b = new a(context.getApplicationContext());
                    }
                }
            }
            aVar = f41929b;
        }
        return aVar;
    }

    public final i a(String str) {
        return new c(this.f41930a).c(str);
    }

    public Pair c(String str) {
        i a2 = a(str);
        long j = -1;
        if (a2.d()) {
            try {
                j = d.b.b.a.a.e.a.a(a2.f41927a);
                return new Pair(0, Long.valueOf(j));
            } catch (IllegalArgumentException unused) {
                return new Pair(Integer.valueOf((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL), Long.valueOf(j));
            }
        }
        return new Pair(Integer.valueOf(a2.f41928b), -1L);
    }
}
