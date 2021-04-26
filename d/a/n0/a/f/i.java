package d.a.n0.a.f;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static int f63424a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f63425b = true;

    public static void a(String str) {
        if (f63425b) {
            c(2, "BaiDuAbSDK", str, null);
        }
    }

    public static void b(String str) {
        if (f63425b) {
            c(5, "BaiDuAbSDK", str, null);
        }
    }

    public static void c(int i2, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i3 = f63424a;
            if (length >= i3) {
                if (i2 == 1) {
                    Log.v(str, str2.substring(0, i3));
                } else if (i2 == 2) {
                    Log.d(str, str2.substring(0, i3));
                } else if (i2 == 3) {
                    Log.i(str, str2.substring(0, i3));
                } else if (i2 == 4) {
                    Log.w(str, str2.substring(0, i3));
                } else if (i2 == 5) {
                    Log.e(str, str2.substring(0, i3));
                }
            } else if (i2 == 1) {
                Log.v(str, str2);
            } else if (i2 == 2) {
                Log.d(str, str2);
            } else if (i2 == 3) {
                Log.i(str, str2);
            } else if (i2 == 4) {
                Log.w(str, str2);
            } else if (i2 != 5) {
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
            if (i2 == 1) {
                Log.v(str, f2);
            } else if (i2 == 2) {
                Log.d(str, f2);
            } else if (i2 == 3) {
                Log.i(str, f2);
            } else if (i2 == 4) {
                Log.w(str, f2);
            } else if (i2 != 5) {
                Log.d(str, str2);
            } else {
                Log.e(str, f2);
            }
        }
    }

    public static void d(Throwable th) {
        if (f63425b) {
            c(2, "BaiDuAbSDK", "", th);
        }
    }

    public static void e(Throwable th) {
        if (f63425b) {
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
        f63425b = z;
    }
}
