package d.b.f.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import d.b.c.e.q.g;
import d.b.c.e.q.h;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f43166a;

    /* renamed from: b  reason: collision with root package name */
    public static b f43167b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43168c;

    /* renamed from: d  reason: collision with root package name */
    public static g f43169d;

    /* renamed from: e  reason: collision with root package name */
    public static long f43170e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f43171f = new Handler(new C0589a());

    /* renamed from: d.b.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0589a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 100) {
                switch (i) {
                    case 0:
                        if (a.f43169d != null) {
                            a.f43169d.c(a.f43168c, message.arg1);
                            g unused = a.f43169d = null;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        if (a.f43169d != null) {
                            if (d.b.c.e.p.f.d()) {
                                a.f43169d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                            } else {
                                a.f43169d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                            }
                            g unused2 = a.f43169d = null;
                            break;
                        }
                        break;
                    case 2:
                        if (a.f43169d != null) {
                            a.f43169d.error(message.what, h.a(R.string.voice_err_file_fail));
                            g unused3 = a.f43169d = null;
                            break;
                        }
                        break;
                    case 4:
                        if (a.f43169d != null) {
                            a.f43169d.b(message.arg1);
                            break;
                        }
                        break;
                    case 5:
                        if (a.f43169d != null) {
                            a.f43169d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                            g unused4 = a.f43169d = null;
                            break;
                        }
                        break;
                    case 6:
                        if (a.f43169d != null) {
                            a.f43169d.error(message.what, h.a(R.string.voice_err_init_fail));
                            g unused5 = a.f43169d = null;
                            break;
                        }
                        break;
                    case 7:
                        if (a.f43169d != null) {
                            a.f43169d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                            g unused6 = a.f43169d = null;
                            break;
                        }
                        break;
                    case 8:
                        if (a.f43169d != null) {
                            a.f43169d.error(message.what, h.a(R.string.voice_record_short_tip));
                            g unused7 = a.f43169d = null;
                            break;
                        }
                        break;
                    case 9:
                        if (a.f43169d != null) {
                            a.f43169d.a(message.arg1);
                            break;
                        }
                        break;
                    default:
                        if (a.f43169d != null) {
                            a.f43169d.error(message.what, h.a(R.string.voice_err_other));
                            g unused8 = a.f43169d = null;
                            break;
                        }
                        break;
                }
            } else if (a.f43169d != null) {
                a.f43169d.e();
            }
            int unused9 = a.f43166a = 0;
            return false;
        }
    }

    public static void e() {
        b bVar = f43167b;
        if (bVar != null) {
            bVar.cancel();
        }
        f43166a = 0;
    }

    public static boolean f(String str, int i, g gVar) {
        if (System.currentTimeMillis() - f43170e < 1000) {
            return false;
        }
        f43170e = System.currentTimeMillis();
        if (f43166a == 0) {
            if (f43167b == null) {
                f43167b = new b(f43171f);
            }
            f43168c = str;
            f43169d = gVar;
            if (f43167b.i(str, i)) {
                f43166a = 3;
                new Thread(f43167b).start();
                return true;
            }
            f43167b = null;
        }
        return false;
    }

    public static void g() {
        b bVar = f43167b;
        if (bVar != null) {
            bVar.j();
        }
        f43166a = 0;
    }
}
