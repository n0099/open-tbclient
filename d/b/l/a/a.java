package d.b.l.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager;
import d.b.l.c.f;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f64706d = AppConfig.isDebug();

    /* renamed from: e  reason: collision with root package name */
    public static a f64707e;

    /* renamed from: a  reason: collision with root package name */
    public String f64708a;

    /* renamed from: b  reason: collision with root package name */
    public String f64709b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f64710c;

    public a() {
        d();
    }

    public static a b() {
        if (f64707e == null) {
            synchronized (a.class) {
                if (f64707e == null) {
                    f64707e = new a();
                }
            }
        }
        return f64707e;
    }

    public String a() {
        return this.f64709b;
    }

    public String c() {
        return this.f64708a;
    }

    public final void d() {
        this.f64710c = AppRuntime.getAppContext().getSharedPreferences(ChannelManager.PREFS_NAME, 0);
        f();
        e();
    }

    public final void e() {
        String g2 = g();
        this.f64709b = g2;
        if (!TextUtils.isEmpty(g2) || TextUtils.isEmpty(this.f64708a)) {
            return;
        }
        this.f64709b = this.f64708a;
        j();
    }

    public final void f() {
        String i = i();
        this.f64708a = i;
        if (TextUtils.isEmpty(i)) {
            this.f64708a = h();
        }
    }

    public final String g() {
        return this.f64710c.getString("channel", null);
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
                        if (f64706d) {
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
                    if (f64706d) {
                        Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e5) {
                            if (f64706d) {
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
                            if (f64706d) {
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

    public final String i() {
        InputStream openRawResource = AppRuntime.getAppContext().getResources().openRawResource(f.tnconfig);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
        try {
            try {
                String readLine = bufferedReader.readLine();
                try {
                    openRawResource.close();
                    bufferedReader.close();
                    return readLine;
                } catch (Exception e2) {
                    if (f64706d) {
                        Log.e(ChannelManager.TAG, "readLastChannelFromRaw", e2);
                        return readLine;
                    }
                    return readLine;
                }
            } catch (Throwable th) {
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (Exception e3) {
                    if (f64706d) {
                        Log.e(ChannelManager.TAG, "readLastChannelFromRaw", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            if (f64706d) {
                Log.e(ChannelManager.TAG, "readLastChannelFromRaw", e4);
            }
            try {
                openRawResource.close();
                bufferedReader.close();
            } catch (Exception e5) {
                if (f64706d) {
                    Log.e(ChannelManager.TAG, "readLastChannelFromRaw", e5);
                }
            }
            return null;
        }
    }

    public final void j() {
        this.f64710c.edit().putString("channel", this.f64709b).apply();
    }
}
