package d.a.f.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import d.a.c.e.q.g;
import d.a.c.e.q.h;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f43404a;

    /* renamed from: b  reason: collision with root package name */
    public static b f43405b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43406c;

    /* renamed from: d  reason: collision with root package name */
    public static g f43407d;

    /* renamed from: e  reason: collision with root package name */
    public static long f43408e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f43409f = new Handler(new C0579a());

    /* renamed from: d.a.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0579a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 100) {
                switch (i2) {
                    case 0:
                        if (a.f43407d != null) {
                            a.f43407d.c(a.f43406c, message.arg1);
                            g unused = a.f43407d = null;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        if (a.f43407d != null) {
                            if (d.a.c.e.p.f.d()) {
                                a.f43407d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                            } else {
                                a.f43407d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                            }
                            g unused2 = a.f43407d = null;
                            break;
                        }
                        break;
                    case 2:
                        if (a.f43407d != null) {
                            a.f43407d.error(message.what, h.a(R.string.voice_err_file_fail));
                            g unused3 = a.f43407d = null;
                            break;
                        }
                        break;
                    case 4:
                        if (a.f43407d != null) {
                            a.f43407d.b(message.arg1);
                            break;
                        }
                        break;
                    case 5:
                        if (a.f43407d != null) {
                            a.f43407d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                            g unused4 = a.f43407d = null;
                            break;
                        }
                        break;
                    case 6:
                        if (a.f43407d != null) {
                            a.f43407d.error(message.what, h.a(R.string.voice_err_init_fail));
                            g unused5 = a.f43407d = null;
                            break;
                        }
                        break;
                    case 7:
                        if (a.f43407d != null) {
                            a.f43407d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                            g unused6 = a.f43407d = null;
                            break;
                        }
                        break;
                    case 8:
                        if (a.f43407d != null) {
                            a.f43407d.error(message.what, h.a(R.string.voice_record_short_tip));
                            g unused7 = a.f43407d = null;
                            break;
                        }
                        break;
                    case 9:
                        if (a.f43407d != null) {
                            a.f43407d.a(message.arg1);
                            break;
                        }
                        break;
                    default:
                        if (a.f43407d != null) {
                            a.f43407d.error(message.what, h.a(R.string.voice_err_other));
                            g unused8 = a.f43407d = null;
                            break;
                        }
                        break;
                }
            } else if (a.f43407d != null) {
                a.f43407d.e();
            }
            int unused9 = a.f43404a = 0;
            return false;
        }
    }

    public static void e() {
        b bVar = f43405b;
        if (bVar != null) {
            bVar.cancel();
        }
        f43404a = 0;
    }

    public static boolean f(String str, int i2, g gVar) {
        if (System.currentTimeMillis() - f43408e < 1000) {
            return false;
        }
        f43408e = System.currentTimeMillis();
        if (f43404a == 0) {
            if (f43405b == null) {
                f43405b = new b(f43409f);
            }
            f43406c = str;
            f43407d = gVar;
            if (f43405b.i(str, i2)) {
                f43404a = 3;
                new Thread(f43405b).start();
                return true;
            }
            f43405b = null;
        }
        return false;
    }

    public static void g() {
        b bVar = f43405b;
        if (bVar != null) {
            bVar.j();
        }
        f43404a = 0;
    }
}
