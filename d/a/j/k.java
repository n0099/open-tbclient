package d.a.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.util.DeviceId;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.j.d.a.g;
import d.a.j.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public Context f43913a;

    /* renamed from: b  reason: collision with root package name */
    public f f43914b;

    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(String str, int i2) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Os.chmod(str, i2);
                    return true;
                } catch (Exception e2) {
                    d.a.j.i.c.c(e2);
                    return false;
                }
            }
            return true;
        }
    }

    public k(Context context, f fVar) {
        this.f43913a = context;
        this.f43914b = fVar;
    }

    public static void g(String str, String str2) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            byte[] a2 = g.a();
            fileWriter.write(f.b.a(d.a.j.d.a.c.c(a2, a2, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    public static void l(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid2");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    public final j a(Context context) {
        List<e> h2 = this.f43914b.h(context);
        j jVar = null;
        if (h2 != null) {
            String str = com.baidu.fsg.face.base.b.c.f5540g;
            File filesDir = context.getFilesDir();
            if (!com.baidu.fsg.face.base.b.c.f5540g.equals(filesDir.getName())) {
                Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                str = filesDir.getName();
            }
            for (e eVar : h2) {
                if (!eVar.f43894d) {
                    File file = new File(new File(eVar.f43891a.dataDir, str), "libcuid.so");
                    if (file.exists() && (jVar = j.e(d.a.j.i.c.a(file))) != null) {
                        break;
                    }
                }
            }
        }
        return jVar;
    }

    public j b(String str) {
        j a2 = a(this.f43913a);
        if (a2 == null) {
            a2 = j.e(k("com.baidu.deviceid.v2"));
        }
        boolean j = j("android.permission.READ_EXTERNAL_STORAGE");
        if (a2 == null && j) {
            a2 = f();
        }
        if (a2 == null) {
            a2 = i();
        }
        boolean z = false;
        if (a2 == null && j) {
            z = true;
            a2 = n(m(""));
        }
        if (!z) {
            m("");
        }
        if (a2 != null) {
            a2.k();
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r0 == null) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r2 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0091, code lost:
        if (r2 == null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(j jVar) {
        boolean d2;
        boolean j;
        j n;
        String str;
        File file = new File(this.f43913a.getFilesDir(), "libcuid.so");
        String h2 = jVar.h();
        if (file.exists()) {
            j e2 = j.e(d.a.j.i.c.a(file));
            if (e2 != null) {
                if (e2.k()) {
                    h(e2.h());
                }
            }
            d2 = d();
            if (d2) {
                String k = k("com.baidu.deviceid.v2");
                if (!TextUtils.isEmpty(k)) {
                    j e3 = j.e(k);
                    if (e3 != null) {
                        if (e3.k()) {
                            e("com.baidu.deviceid.v2", e3.h());
                        }
                    }
                }
                e("com.baidu.deviceid.v2", h2);
            }
            j = j(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (j) {
                if (new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                    j f2 = f();
                    if (f2 != null) {
                        if (f2.k()) {
                            h2 = f2.h();
                        }
                    }
                }
                l(h2);
            }
            if (d2) {
                String k2 = k("bd_setting_i");
                if (j.c(TextUtils.isEmpty(k2) ? 0 : k2.length())) {
                    str = "O";
                } else {
                    str = j.d(k2) ? "0" : "0";
                }
                e("bd_setting_i", str);
            }
            if (j || !new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists() || (n = n(m(""))) == null || !n.k()) {
                return;
            }
            g(n.f43910b, n.f43909a);
            return;
        }
        h(h2);
        d2 = d();
        if (d2) {
        }
        j = j(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (j) {
        }
        if (d2) {
        }
        if (j) {
        }
    }

    public final boolean d() {
        return j("android.permission.WRITE_SETTINGS");
    }

    public final boolean e(String str, String str2) {
        try {
            return Settings.System.putString(this.f43913a.getContentResolver(), str, str2);
        } catch (Exception e2) {
            d.a.j.i.c.c(e2);
            return false;
        }
    }

    public final j f() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return j.e(d.a.j.i.c.a(file));
        }
        return null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @SuppressLint({"NewApi"})
    public final boolean h(String str) {
        int i2;
        File file;
        int i3 = (!DeviceId.sDataCuidInfoShable || Build.VERSION.SDK_INT >= 24) ? 0 : 1;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.f43913a.openFileOutput("libcuid.so", i3);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        d.a.j.i.c.c(e2);
                    }
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    if (i3 == 0 && DeviceId.sDataCuidInfoShable) {
                        i2 = 436;
                        file = new File(this.f43913a.getFilesDir(), "libcuid.so");
                    } else if (!DeviceId.sDataCuidInfoShable) {
                        i2 = 432;
                        file = new File(this.f43913a.getFilesDir(), "libcuid.so");
                    }
                    return a.a(file.getAbsolutePath(), i2);
                }
                return true;
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        d.a.j.i.c.c(e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            d.a.j.i.c.c(e4);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e5) {
                    d.a.j.i.c.c(e5);
                }
            }
            return false;
        }
    }

    public final j i() {
        return j.a(k("com.baidu.deviceid"), k("bd_setting_i"));
    }

    public final boolean j(String str) {
        return this.f43913a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public final String k(String str) {
        try {
            return Settings.System.getString(this.f43913a.getContentResolver(), str);
        } catch (Exception e2) {
            d.a.j.i.c.c(e2);
            return null;
        }
    }

    public final String m(String str) {
        return "0";
    }

    public final j n(String str) {
        String str2;
        String[] split;
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(Part.CRLF);
            }
            bufferedReader.close();
            byte[] a2 = g.a();
            split = new String(d.a.j.d.a.c.d(a2, a2, f.b.b(sb.toString().getBytes()))).split("=");
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (split != null && split.length == 2) {
            str2 = split[0];
            try {
                str3 = split[1];
            } catch (FileNotFoundException | IOException | Exception unused2) {
            }
            return j.a(str3, str2);
        }
        str2 = "";
        return j.a(str3, str2);
    }
}
