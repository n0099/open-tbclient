package d.a.c.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42550a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42551b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42552c;

    /* renamed from: d  reason: collision with root package name */
    public static c f42553d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f42554e = new Handler(new C0545a());

    /* renamed from: d.a.c.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0545a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 6) {
                        if (a.f42553d != null) {
                            a.f42553d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f42553d != null) {
                            a.f42553d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f42553d != null) {
                    a.f42553d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f42553d != null) {
                a.f42553d.c(a.f42552c, message.arg1);
            }
            int unused = a.f42550a = 0;
            c unused2 = a.f42553d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i2) {
        if (f42550a == 0) {
            b bVar = f42551b;
            if (bVar == null) {
                f42551b = new b(f42554e, i2);
            } else {
                bVar.k(i2);
            }
            f42552c = str;
            f42553d = cVar;
            f42551b.j(str);
            f42550a = 2;
            new Thread(f42551b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f42551b;
        if (bVar != null) {
            bVar.l();
        } else {
            f42550a = 0;
        }
    }
}
