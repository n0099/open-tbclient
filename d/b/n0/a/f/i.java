package d.b.n0.a.f;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static int f65113a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f65114b = true;

    public static void a(String str) {
        if (f65114b) {
            c(2, "BaiDuAbSDK", str, null);
        }
    }

    public static void b(String str) {
        if (f65114b) {
            c(5, "BaiDuAbSDK", str, null);
        }
    }

    public static void c(int i, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i2 = f65113a;
            if (length >= i2) {
                if (i == 1) {
                    Log.v(str, str2.substring(0, i2));
                } else if (i == 2) {
                    Log.d(str, str2.substring(0, i2));
                } else if (i == 3) {
                    Log.i(str, str2.substring(0, i2));
                } else if (i == 4) {
                    Log.w(str, str2.substring(0, i2));
                } else if (i == 5) {
                    Log.e(str, str2.substring(0, i2));
                }
            } else if (i == 1) {
                Log.v(str, str2);
            } else if (i == 2) {
                Log.d(str, str2);
            } else if (i == 3) {
                Log.i(str, str2);
            } else if (i == 4) {
                Log.w(str, str2);
            } else if (i != 5) {
                Log.d(str, str2);
            } else {
                Log.e(str, str2);
            }
        }
        if (th != null) {
            String f2 = f(th);
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            if (i == 1) {
                Log.v(str, f2);
            } else if (i == 2) {
                Log.d(str, f2);
            } else if (i == 3) {
                Log.i(str, f2);
            } else if (i == 4) {
                Log.w(str, f2);
            } else if (i != 5) {
                Log.d(str, str2);
            } else {
                Log.e(str, f2);
            }
        }
    }

    public static void d(Throwable th) {
        if (f65114b) {
            c(2, "BaiDuAbSDK", "", th);
        }
    }

    public static void e(Throwable th) {
        if (f65114b) {
            c(4, "BaiDuAbSDK", "", th);
        }
    }

    public static String f(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter = null;
        try {
            StringWriter stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    stringWriter2.flush();
                    String stringWriter3 = stringWriter2.toString();
                    try {
                        stringWriter2.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    printWriter.close();
                    return stringWriter3;
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter = stringWriter2;
                    try {
                        th.printStackTrace();
                        return "";
                    } finally {
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        if (printWriter != null) {
                            printWriter.close();
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                printWriter = null;
            }
        } catch (Throwable th6) {
            th = th6;
            printWriter = null;
        }
    }

    public static void g(boolean z) {
        f65114b = z;
    }
}
