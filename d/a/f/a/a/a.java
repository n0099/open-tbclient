package d.a.f.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import d.a.c.e.q.g;
import d.a.c.e.q.h;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f39723a;

    /* renamed from: b  reason: collision with root package name */
    public static b f39724b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39725c;

    /* renamed from: d  reason: collision with root package name */
    public static g f39726d;

    /* renamed from: e  reason: collision with root package name */
    public static long f39727e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f39728f = new Handler(new C0523a());

    /* renamed from: d.a.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0523a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 100) {
                switch (i2) {
                    case 0:
                        if (a.f39726d != null) {
                            a.f39726d.c(a.f39725c, message.arg1);
                            g unused = a.f39726d = null;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        if (a.f39726d != null) {
                            if (d.a.c.e.p.f.d()) {
                                a.f39726d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                            } else {
                                a.f39726d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                            }
                            g unused2 = a.f39726d = null;
                            break;
                        }
                        break;
                    case 2:
                        if (a.f39726d != null) {
                            a.f39726d.error(message.what, h.a(R.string.voice_err_file_fail));
                            g unused3 = a.f39726d = null;
                            break;
                        }
                        break;
                    case 4:
                        if (a.f39726d != null) {
                            a.f39726d.b(message.arg1);
                            break;
                        }
                        break;
                    case 5:
                        if (a.f39726d != null) {
                            a.f39726d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                            g unused4 = a.f39726d = null;
                            break;
                        }
                        break;
                    case 6:
                        if (a.f39726d != null) {
                            a.f39726d.error(message.what, h.a(R.string.voice_err_init_fail));
                            g unused5 = a.f39726d = null;
                            break;
                        }
                        break;
                    case 7:
                        if (a.f39726d != null) {
                            a.f39726d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                            g unused6 = a.f39726d = null;
                            break;
                        }
                        break;
                    case 8:
                        if (a.f39726d != null) {
                            a.f39726d.error(message.what, h.a(R.string.voice_record_short_tip));
                            g unused7 = a.f39726d = null;
                            break;
                        }
                        break;
                    case 9:
                        if (a.f39726d != null) {
                            a.f39726d.a(message.arg1);
                            break;
                        }
                        break;
                    default:
                        if (a.f39726d != null) {
                            a.f39726d.error(message.what, h.a(R.string.voice_err_other));
                            g unused8 = a.f39726d = null;
                            break;
                        }
                        break;
                }
            } else if (a.f39726d != null) {
                a.f39726d.e();
            }
            int unused9 = a.f39723a = 0;
            return false;
        }
    }

    public static void e() {
        b bVar = f39724b;
        if (bVar != null) {
            bVar.cancel();
        }
        f39723a = 0;
    }

    public static boolean f(String str, int i2, g gVar) {
        if (System.currentTimeMillis() - f39727e < 1000) {
            return false;
        }
        f39727e = System.currentTimeMillis();
        if (f39723a == 0) {
            if (f39724b == null) {
                f39724b = new b(f39728f);
            }
            f39725c = str;
            f39726d = gVar;
            if (f39724b.i(str, i2)) {
                f39723a = 3;
                new Thread(f39724b).start();
                return true;
            }
            f39724b = null;
        }
        return false;
    }

    public static void g() {
        b bVar = f39724b;
        if (bVar != null) {
            bVar.j();
        }
        f39723a = 0;
    }
}
