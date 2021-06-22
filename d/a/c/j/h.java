package d.a.c.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.util.io.Closeables;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class h {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42968d = a.f42956a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile h f42969e;

    /* renamed from: a  reason: collision with root package name */
    public long f42970a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f42971b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f42972c = 0;

    public static synchronized h d() {
        h hVar;
        synchronized (h.class) {
            if (f42969e == null) {
                f42969e = new h();
            }
            hVar = f42969e;
        }
        return hVar;
    }

    public int a() {
        try {
            Context appContext = AppRuntime.getAppContext();
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            if (packageInfo != null) {
                if (f42968d) {
                    Log.d(TitanDownloadService.TAG, "cur host version code = " + packageInfo.versionCode);
                }
                return packageInfo.versionCode;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    public long b() {
        if (a() > c()) {
            return -1L;
        }
        return this.f42970a;
    }

    public int c() {
        return this.f42972c;
    }

    public long e() {
        return this.f42971b;
    }

    public final File f() {
        File file = new File(AppRuntime.getAppContext().getCacheDir(), "titan_sandbox_cache");
        file.mkdirs();
        return new File(file, "update_v3.profile");
    }

    public void g() {
        DataInputStream dataInputStream;
        File f2 = f();
        if (f2.exists()) {
            DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(f2));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                this.f42970a = dataInputStream.readLong();
                this.f42971b = dataInputStream.readLong();
                this.f42972c = dataInputStream.readInt();
                Closeables.closeSafely(dataInputStream);
            } catch (IOException e3) {
                e = e3;
                dataInputStream2 = dataInputStream;
                e.printStackTrace();
                Closeables.closeSafely(dataInputStream2);
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                Closeables.closeSafely(dataInputStream2);
                throw th;
            }
        }
    }

    public void h(int i2) {
        this.f42972c = i2;
    }

    public void i(long j) {
        this.f42971b = j;
    }

    public void j(long j) {
        this.f42970a = j;
    }

    public void k() {
        File file;
        DataOutputStream dataOutputStream;
        if (f42968d) {
            Log.d(TitanDownloadService.TAG, "updateToFile value = " + toString());
        }
        File f2 = f();
        DataOutputStream dataOutputStream2 = null;
        try {
            file = File.createTempFile("titan", "profile", f2.getParentFile());
            try {
                try {
                    dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            e = e3;
            file = null;
        } catch (Throwable th2) {
            th = th2;
            file = null;
        }
        try {
            dataOutputStream.writeLong(this.f42970a);
            dataOutputStream.writeLong(this.f42971b);
            dataOutputStream.writeInt(this.f42972c);
            dataOutputStream.close();
            f2.delete();
            file.renameTo(f2);
            Closeables.closeSafely(dataOutputStream);
            if (file == null || !file.exists()) {
                return;
            }
        } catch (IOException e4) {
            e = e4;
            dataOutputStream2 = dataOutputStream;
            e.printStackTrace();
            Closeables.closeSafely(dataOutputStream2);
            if (file == null || !file.exists()) {
                return;
            }
            file.delete();
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream2 = dataOutputStream;
            Closeables.closeSafely(dataOutputStream2);
            if (file != null && file.exists()) {
                file.delete();
            }
            throw th;
        }
        file.delete();
    }

    public String toString() {
        return "[updateVersion = " + this.f42970a + ", lastUpdateTime = " + this.f42971b + ", hostVersionCode = " + this.f42972c + PreferencesUtil.RIGHT_MOUNT;
    }
}
