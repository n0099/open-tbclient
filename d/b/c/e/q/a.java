package d.b.c.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42776a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42777b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42778c;

    /* renamed from: d  reason: collision with root package name */
    public static c f42779d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f42780e = new Handler(new C0579a());

    /* renamed from: d.b.c.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0579a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 6) {
                        if (a.f42779d != null) {
                            a.f42779d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f42779d != null) {
                            a.f42779d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f42779d != null) {
                    a.f42779d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f42779d != null) {
                a.f42779d.c(a.f42778c, message.arg1);
            }
            int unused = a.f42776a = 0;
            c unused2 = a.f42779d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i) {
        if (f42776a == 0) {
            b bVar = f42777b;
            if (bVar == null) {
                f42777b = new b(f42780e, i);
            } else {
                bVar.k(i);
            }
            f42778c = str;
            f42779d = cVar;
            f42777b.j(str);
            f42776a = 2;
            new Thread(f42777b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f42777b;
        if (bVar != null) {
            bVar.l();
        } else {
            f42776a = 0;
        }
    }
}
