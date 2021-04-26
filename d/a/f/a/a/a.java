package d.a.f.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import d.a.c.e.q.g;
import d.a.c.e.q.h;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f40674a;

    /* renamed from: b  reason: collision with root package name */
    public static b f40675b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40676c;

    /* renamed from: d  reason: collision with root package name */
    public static g f40677d;

    /* renamed from: e  reason: collision with root package name */
    public static long f40678e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f40679f = new Handler(new C0547a());

    /* renamed from: d.a.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0547a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 100) {
                switch (i2) {
                    case 0:
                        if (a.f40677d != null) {
                            a.f40677d.c(a.f40676c, message.arg1);
                            g unused = a.f40677d = null;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        if (a.f40677d != null) {
                            if (d.a.c.e.p.f.d()) {
                                a.f40677d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                            } else {
                                a.f40677d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                            }
                            g unused2 = a.f40677d = null;
                            break;
                        }
                        break;
                    case 2:
                        if (a.f40677d != null) {
                            a.f40677d.error(message.what, h.a(R.string.voice_err_file_fail));
                            g unused3 = a.f40677d = null;
                            break;
                        }
                        break;
                    case 4:
                        if (a.f40677d != null) {
                            a.f40677d.b(message.arg1);
                            break;
                        }
                        break;
                    case 5:
                        if (a.f40677d != null) {
                            a.f40677d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                            g unused4 = a.f40677d = null;
                            break;
                        }
                        break;
                    case 6:
                        if (a.f40677d != null) {
                            a.f40677d.error(message.what, h.a(R.string.voice_err_init_fail));
                            g unused5 = a.f40677d = null;
                            break;
                        }
                        break;
                    case 7:
                        if (a.f40677d != null) {
                            a.f40677d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                            g unused6 = a.f40677d = null;
                            break;
                        }
                        break;
                    case 8:
                        if (a.f40677d != null) {
                            a.f40677d.error(message.what, h.a(R.string.voice_record_short_tip));
                            g unused7 = a.f40677d = null;
                            break;
                        }
                        break;
                    case 9:
                        if (a.f40677d != null) {
                            a.f40677d.a(message.arg1);
                            break;
                        }
                        break;
                    default:
                        if (a.f40677d != null) {
                            a.f40677d.error(message.what, h.a(R.string.voice_err_other));
                            g unused8 = a.f40677d = null;
                            break;
                        }
                        break;
                }
            } else if (a.f40677d != null) {
                a.f40677d.e();
            }
            int unused9 = a.f40674a = 0;
            return false;
        }
    }

    public static void e() {
        b bVar = f40675b;
        if (bVar != null) {
            bVar.cancel();
        }
        f40674a = 0;
    }

    public static boolean f(String str, int i2, g gVar) {
        if (System.currentTimeMillis() - f40678e < 1000) {
            return false;
        }
        f40678e = System.currentTimeMillis();
        if (f40674a == 0) {
            if (f40675b == null) {
                f40675b = new b(f40679f);
            }
            f40676c = str;
            f40677d = gVar;
            if (f40675b.i(str, i2)) {
                f40674a = 3;
                new Thread(f40675b).start();
                return true;
            }
            f40675b = null;
        }
        return false;
    }

    public static void g() {
        b bVar = f40675b;
        if (bVar != null) {
            bVar.j();
        }
        f40674a = 0;
    }
}
