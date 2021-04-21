package d.b.f.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import d.b.c.e.q.g;
import d.b.c.e.q.h;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f43430a;

    /* renamed from: b  reason: collision with root package name */
    public static b f43431b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43432c;

    /* renamed from: d  reason: collision with root package name */
    public static g f43433d;

    /* renamed from: e  reason: collision with root package name */
    public static long f43434e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f43435f = new Handler(new C0608a());

    /* renamed from: d.b.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0608a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 100) {
                switch (i) {
                    case 0:
                        if (a.f43433d != null) {
                            a.f43433d.c(a.f43432c, message.arg1);
                            g unused = a.f43433d = null;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        if (a.f43433d != null) {
                            if (d.b.c.e.p.f.d()) {
                                a.f43433d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                            } else {
                                a.f43433d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                            }
                            g unused2 = a.f43433d = null;
                            break;
                        }
                        break;
                    case 2:
                        if (a.f43433d != null) {
                            a.f43433d.error(message.what, h.a(R.string.voice_err_file_fail));
                            g unused3 = a.f43433d = null;
                            break;
                        }
                        break;
                    case 4:
                        if (a.f43433d != null) {
                            a.f43433d.b(message.arg1);
                            break;
                        }
                        break;
                    case 5:
                        if (a.f43433d != null) {
                            a.f43433d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                            g unused4 = a.f43433d = null;
                            break;
                        }
                        break;
                    case 6:
                        if (a.f43433d != null) {
                            a.f43433d.error(message.what, h.a(R.string.voice_err_init_fail));
                            g unused5 = a.f43433d = null;
                            break;
                        }
                        break;
                    case 7:
                        if (a.f43433d != null) {
                            a.f43433d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                            g unused6 = a.f43433d = null;
                            break;
                        }
                        break;
                    case 8:
                        if (a.f43433d != null) {
                            a.f43433d.error(message.what, h.a(R.string.voice_record_short_tip));
                            g unused7 = a.f43433d = null;
                            break;
                        }
                        break;
                    case 9:
                        if (a.f43433d != null) {
                            a.f43433d.a(message.arg1);
                            break;
                        }
                        break;
                    default:
                        if (a.f43433d != null) {
                            a.f43433d.error(message.what, h.a(R.string.voice_err_other));
                            g unused8 = a.f43433d = null;
                            break;
                        }
                        break;
                }
            } else if (a.f43433d != null) {
                a.f43433d.e();
            }
            int unused9 = a.f43430a = 0;
            return false;
        }
    }

    public static void e() {
        b bVar = f43431b;
        if (bVar != null) {
            bVar.cancel();
        }
        f43430a = 0;
    }

    public static boolean f(String str, int i, g gVar) {
        if (System.currentTimeMillis() - f43434e < 1000) {
            return false;
        }
        f43434e = System.currentTimeMillis();
        if (f43430a == 0) {
            if (f43431b == null) {
                f43431b = new b(f43435f);
            }
            f43432c = str;
            f43433d = gVar;
            if (f43431b.i(str, i)) {
                f43430a = 3;
                new Thread(f43431b).start();
                return true;
            }
            f43431b = null;
        }
        return false;
    }

    public static void g() {
        b bVar = f43431b;
        if (bVar != null) {
            bVar.j();
        }
        f43430a = 0;
    }
}
