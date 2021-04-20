package d.b.c.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42536a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42537b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42538c;

    /* renamed from: d  reason: collision with root package name */
    public static c f42539d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f42540e = new Handler(new C0560a());

    /* renamed from: d.b.c.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0560a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 6) {
                        if (a.f42539d != null) {
                            a.f42539d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f42539d != null) {
                            a.f42539d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f42539d != null) {
                    a.f42539d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f42539d != null) {
                a.f42539d.c(a.f42538c, message.arg1);
            }
            int unused = a.f42536a = 0;
            c unused2 = a.f42539d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i) {
        if (f42536a == 0) {
            b bVar = f42537b;
            if (bVar == null) {
                f42537b = new b(f42540e, i);
            } else {
                bVar.k(i);
            }
            f42538c = str;
            f42539d = cVar;
            f42537b.j(str);
            f42536a = 2;
            new Thread(f42537b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f42537b;
        if (bVar != null) {
            bVar.l();
        } else {
            f42536a = 0;
        }
    }
}
