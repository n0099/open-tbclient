package d.a.l.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager;
import d.a.l.c.g;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f40554d = AppConfig.isDebug();

    /* renamed from: e  reason: collision with root package name */
    public static a f40555e;

    /* renamed from: a  reason: collision with root package name */
    public String f40556a;

    /* renamed from: b  reason: collision with root package name */
    public String f40557b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f40558c;

    public a() {
        d();
    }

    public static a b() {
        if (f40555e == null) {
            synchronized (a.class) {
                if (f40555e == null) {
                    f40555e = new a();
                }
            }
        }
        return f40555e;
    }

    public String a() {
        return this.f40557b;
    }

    public String c() {
        return this.f40556a;
    }

    public final void d() {
        this.f40558c = AppRuntime.getAppContext().getSharedPreferences(ChannelManager.PREFS_NAME, 0);
        f();
        e();
    }

    public final void e() {
        String g2 = g();
        this.f40557b = g2;
        if (!TextUtils.isEmpty(g2) || TextUtils.isEmpty(this.f40556a)) {
            return;
        }
        this.f40557b = this.f40556a;
        j();
    }

    public final void f() {
        String i2 = i();
        this.f40556a = i2;
        if (TextUtils.isEmpty(i2)) {
            this.f40556a = h();
        }
    }

    public final String g() {
        return this.f40558c.getString("channel", null);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0080 A[Catch: Exception -> 0x007c, TRY_LEAVE, TryCatch #4 {Exception -> 0x007c, blocks: (B:45:0x0078, B:49:0x0080), top: B:59:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h() {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        String str;
        InputStream inputStream2 = null;
        String str2 = null;
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open("channel");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                inputStream2 = inputStream;
                str = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            try {
                str2 = bufferedReader.readLine();
                inputStream.close();
                bufferedReader.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        if (f40554d) {
                            Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e3);
                            return str2;
                        }
                        return str2;
                    }
                }
                bufferedReader.close();
                return str2;
            } catch (Exception e4) {
                e = e4;
                String str3 = str2;
                inputStream2 = inputStream;
                str = str3;
                try {
                    if (f40554d) {
                        Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e5) {
                            if (f40554d) {
                                Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e5);
                            }
                            return str;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return str;
                } catch (Throwable th3) {
                    InputStream inputStream3 = inputStream2;
                    th = th3;
                    inputStream = inputStream3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                            if (f40554d) {
                                Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e6);
                            }
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            str = null;
            bufferedReader = null;
        } catch (Throwable th5) {
            bufferedReader = null;
            th = th5;
            inputStream = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
        android.util.Log.e(com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager.TAG, "readLastChannelFromRaw", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (d.a.l.a.a.f40554d == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (d.a.l.a.a.f40554d == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String i() {
        String str = null;
        try {
            InputStream openRawResource = AppRuntime.getAppContext().getResources().openRawResource(g.tnconfig);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
            try {
                str = bufferedReader.readLine();
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                if (f40554d) {
                    Log.e(ChannelManager.TAG, "readLastChannelFromRaw", e3);
                }
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (Exception e4) {
                    e = e4;
                }
            }
        } catch (Exception e5) {
            if (f40554d) {
                Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e5);
            }
        }
        return str;
    }

    public final void j() {
        this.f40558c.edit().putString("channel", this.f40557b).apply();
    }
}
