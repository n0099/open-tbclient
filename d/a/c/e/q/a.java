package d.a.c.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f39988a;

    /* renamed from: b  reason: collision with root package name */
    public static b f39989b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39990c;

    /* renamed from: d  reason: collision with root package name */
    public static c f39991d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f39992e = new Handler(new C0518a());

    /* renamed from: d.a.c.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0518a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 6) {
                        if (a.f39991d != null) {
                            a.f39991d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f39991d != null) {
                            a.f39991d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f39991d != null) {
                    a.f39991d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f39991d != null) {
                a.f39991d.c(a.f39990c, message.arg1);
            }
            int unused = a.f39988a = 0;
            c unused2 = a.f39991d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i2) {
        if (f39988a == 0) {
            b bVar = f39989b;
            if (bVar == null) {
                f39989b = new b(f39992e, i2);
            } else {
                bVar.k(i2);
            }
            f39990c = str;
            f39991d = cVar;
            f39989b.j(str);
            f39988a = 2;
            new Thread(f39989b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f39989b;
        if (bVar != null) {
            bVar.l();
        } else {
            f39988a = 0;
        }
    }
}
