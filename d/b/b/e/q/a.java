package d.b.b.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42038a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42039b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42040c;

    /* renamed from: d  reason: collision with root package name */
    public static c f42041d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f42042e = new Handler(new C0541a());

    /* renamed from: d.b.b.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0541a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 6) {
                        if (a.f42041d != null) {
                            a.f42041d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f42041d != null) {
                            a.f42041d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f42041d != null) {
                    a.f42041d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f42041d != null) {
                a.f42041d.c(a.f42040c, message.arg1);
            }
            int unused = a.f42038a = 0;
            c unused2 = a.f42041d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i) {
        if (f42038a == 0) {
            b bVar = f42039b;
            if (bVar == null) {
                f42039b = new b(f42042e, i);
            } else {
                bVar.k(i);
            }
            f42040c = str;
            f42041d = cVar;
            f42039b.j(str);
            f42038a = 2;
            new Thread(f42039b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f42039b;
        if (bVar != null) {
            bVar.l();
        } else {
            f42038a = 0;
        }
    }
}
