package d.a.c.e.p;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.devices.IDevices;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static h f39951a;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        public String f39952a;

        /* renamed from: b  reason: collision with root package name */
        public String f39953b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuilder f39954c;

        /* renamed from: d  reason: collision with root package name */
        public i f39955d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39956e = false;

        public a(String str, String str2, StringBuilder sb, i iVar) {
            this.f39952a = str;
            this.f39953b = str2;
            this.f39954c = sb;
            this.f39955d = iVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(Object... objArr) {
            boolean i2 = h.this.i(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.f39952a, this.f39954c);
            this.f39956e = i2;
            if (i2) {
                return null;
            }
            h.this.d(this.f39953b, "".getBytes(), this.f39954c);
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            if (this.f39954c.length() > 0) {
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                bdStatisticsManager.error("so", "load_" + this.f39952a + ".so", "", -9101, this.f39954c.toString(), new Object[0]);
            }
            i iVar = this.f39955d;
            if (iVar != null) {
                iVar.a(this.f39956e);
            }
        }
    }

    public static h f() {
        h hVar;
        h hVar2 = f39951a;
        if (hVar2 == null) {
            synchronized (h.class) {
                if (f39951a == null) {
                    f39951a = new h();
                }
                hVar = f39951a;
            }
            return hVar;
        }
        return hVar2;
    }

    public final boolean c(String str, StringBuilder sb) {
        String g2 = g(str);
        File file = new File(h(str));
        if (!file.exists()) {
            sb.append("false_file_null");
            return false;
        }
        File file2 = new File(g2);
        if (!file2.exists()) {
            sb.append("true_lib_null");
            return true;
        }
        String e2 = e(file);
        if (e2 != null && e2.equals(e(file2))) {
            sb.append("true_md5_equals");
            return true;
        }
        sb.append("false_md5_not_equals");
        file.delete();
        return false;
    }

    public final void d(String str, byte[] bArr, StringBuilder sb) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(str));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            d.a.c.e.m.a.d(fileOutputStream);
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            sb.append("-Error4:");
            sb.append(e.getClass().getName() + "-" + e.getMessage());
            sb.append("-");
            d.a.c.e.m.a.d(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.c.e.m.a.d(fileOutputStream2);
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    public final String e(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            ?? length = file.length();
            try {
                if (length > 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            String b2 = q.b(fileInputStream);
                            if (!StringUtils.isNull(b2)) {
                                b2 = b2.toLowerCase();
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                BdLog.d(e2.getMessage());
                            }
                            return b2;
                        } catch (Exception e3) {
                            e = e3;
                            BdLog.d(e.getMessage());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    BdLog.d(e4.getMessage());
                                }
                            }
                            return null;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e6) {
                                BdLog.d(e6.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = length;
            }
        }
        return null;
    }

    public final String g(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "lib" + File.separator + "lib" + str + ".so";
    }

    public final String h(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + com.baidu.fsg.face.base.b.c.f5743g + File.separator + "lib" + str + ".so";
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0121 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    public final boolean i(String str, String str2, StringBuilder sb) {
        Throwable th;
        ZipInputStream zipInputStream;
        IOException e2;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("lib");
        sb2.append(File.separator);
        sb2.append("x86");
        sb2.append(File.separator);
        sb2.append("lib");
        sb2.append(str2);
        ?? r4 = ".so";
        sb2.append(".so");
        arrayList.add(sb2.toString());
        arrayList.add("lib" + File.separator + IDevices.ABI_MIPS + File.separator + "lib" + str2 + ".so");
        arrayList.add("lib" + File.separator + "armeabi" + File.separator + "lib" + str2 + ".so");
        File file = new File(str);
        boolean z = false;
        if (file.exists()) {
            try {
                try {
                    zipInputStream = new ZipInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                break;
                            } else if (arrayList.contains(nextEntry.getName())) {
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    while (true) {
                                        try {
                                            int read = zipInputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        } catch (Exception unused) {
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            d.a.c.e.m.a.d(byteArrayOutputStream);
                                            throw th2;
                                        }
                                    }
                                    byteArrayOutputStream.flush();
                                    String h2 = h(str2);
                                    d(h2, byteArrayOutputStream.toByteArray(), sb);
                                    if (n(h2, sb)) {
                                        sb.append("-Succ5-");
                                        z = true;
                                        d.a.c.e.m.a.d(byteArrayOutputStream);
                                        break;
                                    }
                                } catch (Exception unused2) {
                                    byteArrayOutputStream = null;
                                } catch (Throwable th4) {
                                    byteArrayOutputStream = null;
                                    th2 = th4;
                                }
                                d.a.c.e.m.a.d(byteArrayOutputStream);
                            }
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        sb.append("-Error5:");
                        sb.append(e2.getClass().getName() + "-" + e2.getMessage());
                        sb.append("-");
                        d.a.c.e.m.a.c(zipInputStream);
                        return z;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    d.a.c.e.m.a.c(r4);
                    throw th;
                }
            } catch (IOException e4) {
                zipInputStream = null;
                e2 = e4;
            } catch (Throwable th6) {
                r4 = 0;
                th = th6;
                d.a.c.e.m.a.c(r4);
                throw th;
            }
            d.a.c.e.m.a.c(zipInputStream);
            return z;
        }
        return false;
    }

    public boolean j(String str, int i2) {
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            return false;
        }
        boolean z = false;
        for (int i3 = 0; i3 < i2; i3++) {
            z = l(str, sb);
            if (z) {
                break;
            }
        }
        if (!z) {
            String h2 = h(str);
            File file = new File(h2);
            if (file.exists()) {
                if (file.length() > 0) {
                    z = n(h2, sb);
                    if (z) {
                        sb.append("-Succ2-");
                    } else {
                        sb.append("-Error7-");
                    }
                } else {
                    sb.append("-Error6:soSize1-");
                }
            }
        }
        if (sb.length() > 0) {
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            bdStatisticsManager.error("so", "load_" + str + ".so", "", -9101, sb.toString(), new Object[0]);
        }
        return z;
    }

    public boolean k(String str, int i2, i iVar) {
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            return false;
        }
        boolean z = false;
        for (int i3 = 0; i3 < i2; i3++) {
            z = l(str, sb);
            if (z) {
                break;
            }
        }
        if (!z) {
            String h2 = h(str);
            File file = new File(h2);
            if (file.exists()) {
                if (file.length() > 0) {
                    z = n(h2, sb);
                    if (z) {
                        sb.append("-Succ2-");
                    } else {
                        sb.append("-Error7-");
                    }
                } else {
                    sb.append("-Error6:soSize1-");
                }
            } else {
                a aVar = new a(str, h2, sb, iVar);
                aVar.setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen()));
                aVar.execute(new Object[0]);
                return false;
            }
        }
        if (sb.length() > 0) {
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            bdStatisticsManager.error("so", "load_" + str + ".so", "", -9101, sb.toString(), new Object[0]);
        }
        return z;
    }

    public final boolean l(String str, StringBuilder sb) {
        boolean n = n(g(str), sb);
        if (n) {
            return n;
        }
        try {
            System.loadLibrary(str);
            sb.append("-Succ3-");
            return true;
        } catch (Throwable th) {
            sb.append("-Error3:");
            sb.append(th.getClass().getName() + "-" + th.getMessage());
            sb.append("-");
            return n;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(String str) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            return false;
        }
        boolean l = l(str, sb);
        if (!l) {
            BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "2", "exception", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            if (c(str, sb2)) {
                l = n(h(str), sb2);
                if (!l) {
                    new File(h(str)).delete();
                } else {
                    z = false;
                    BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "3", "exception", sb2.toString(), "copyfile", Boolean.valueOf(z));
                    if (z) {
                        StringBuilder sb3 = new StringBuilder();
                        boolean i2 = i(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, str, sb3);
                        BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "4", "exception", sb3.toString());
                        return i2;
                    }
                }
            }
            z = true;
            BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "3", "exception", sb2.toString(), "copyfile", Boolean.valueOf(z));
            if (z) {
            }
        }
        return l;
    }

    public final boolean n(String str, StringBuilder sb) {
        if (!new File(str).exists()) {
            sb.append("-Error1:");
            sb.append(str);
            sb.append("_FileNotFound-");
        } else {
            try {
                System.load(str);
                return true;
            } catch (Throwable th) {
                sb.append("-Error2:");
                sb.append(th.getClass().getName() + "-" + th.getMessage());
                sb.append("-");
            }
        }
        return false;
    }
}
