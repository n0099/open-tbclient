package d.a.i0.a.a2.n;

import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.i0.a.v2.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f40615a = -1;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppConfigData f40616e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f40617f;

        public a(SwanAppConfigData swanAppConfigData, File file, String str) {
            this.f40616e = swanAppConfigData;
            this.f40617f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            Throwable th;
            if (this.f40616e == null) {
                return;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f40617f);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                fileOutputStream = null;
                th = th2;
            }
            try {
                fileOutputStream.write(SwanAppConfigData.s.call(this.f40616e));
                d.a.i0.t.d.d(fileOutputStream);
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                d.a.i0.t.d.d(fileOutputStream2);
            } catch (Throwable th3) {
                th = th3;
                d.a.i0.t.d.d(fileOutputStream);
                throw th;
            }
        }
    }

    public static boolean a() {
        if (f40615a == -1) {
            d.a.i0.a.c1.a.Z().getSwitch("swan_app_json_serialize", 0);
            f40615a = 0;
        }
        return f40615a == 1;
    }

    public static SwanAppConfigData b(String str) {
        return c(str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SwanAppConfigData c(String str, boolean z) {
        SwanAppConfigData call;
        System.currentTimeMillis();
        File file = new File(str, "app.json");
        FileInputStream fileInputStream = null;
        if (file.exists()) {
            String D = d.a.i0.t.d.D(file);
            File file2 = new File(str, "app_json_serialize3.kv");
            if (a() && !z && file2.exists()) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    try {
                        int available = fileInputStream2.available();
                        byte[] bArr = new byte[available];
                        if (available == fileInputStream2.read(bArr) && (call = SwanAppConfigData.t.call(bArr)) != null) {
                            call.m = D;
                            d.a.i0.t.d.d(fileInputStream2);
                            return call;
                        }
                        d.a.i0.t.d.d(fileInputStream2);
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                        d.a.i0.t.d.d(fileInputStream);
                        SwanAppConfigData c2 = SwanAppConfigData.c(D, file.getParentFile());
                        if (a()) {
                        }
                        return c2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        d.a.i0.t.d.d(fileInputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            SwanAppConfigData c22 = SwanAppConfigData.c(D, file.getParentFile());
            if (a()) {
                q.j(new a(c22, file2, str), "SwanAppConfigDataReader");
            }
            return c22;
        }
        return null;
    }
}
