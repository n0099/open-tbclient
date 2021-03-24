package d.o.a.e.a.h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.PushManager;
import com.ss.android.socialbase.appdownloader.f.a.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.a.d;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: d.o.a.e.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1842a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66863f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f66864g;

        public RunnableC1842a(Context context, DownloadInfo downloadInfo, int i) {
            this.f66862e = context;
            this.f66863f = downloadInfo;
            this.f66864g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.f t = d.o.a.e.a.e.F().t();
            d.o.a.e.b.f.d i = d.o.a.e.b.g.a.l(this.f66862e).i(this.f66863f.c0());
            if (t == null && i == null) {
                return;
            }
            File file = new File(this.f66863f.F0(), this.f66863f.q0());
            if (file.exists()) {
                try {
                    PackageInfo i2 = d.o.a.e.a.d.i(this.f66863f, file);
                    if (i2 != null) {
                        String v0 = (this.f66864g == 1 || TextUtils.isEmpty(this.f66863f.v0())) ? i2.packageName : this.f66863f.v0();
                        if (t != null) {
                            t.b(this.f66863f.c0(), 1, v0, -3, this.f66863f.M());
                        }
                        if (i != null) {
                            i.a(1, this.f66863f, v0, "");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static final void a(d dVar, int i) throws IOException {
            int e2 = dVar.e();
            if (e2 == i) {
                return;
            }
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(e2) + ".");
        }
    }

    /* loaded from: classes7.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public InputStream f66876a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f66877b;

        /* renamed from: c  reason: collision with root package name */
        public int f66878c;

        public d(InputStream inputStream, boolean z) {
            c(inputStream, z);
        }

        public final int a(int i) throws IOException {
            if (i >= 0 && i <= 4) {
                int i2 = 0;
                if (this.f66877b) {
                    for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                        int read = this.f66876a.read();
                        if (read == -1) {
                            throw new EOFException();
                        }
                        this.f66878c++;
                        i2 |= read << i3;
                    }
                    return i2;
                }
                int i4 = i * 8;
                int i5 = 0;
                while (i2 != i4) {
                    int read2 = this.f66876a.read();
                    if (read2 == -1) {
                        throw new EOFException();
                    }
                    this.f66878c++;
                    i5 |= read2 << i2;
                    i2 += 8;
                }
                return i5;
            }
            throw new IllegalArgumentException();
        }

        public final void b() {
            InputStream inputStream = this.f66876a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                c(null, false);
            }
        }

        public final void c(InputStream inputStream, boolean z) {
            this.f66876a = inputStream;
            this.f66877b = z;
            this.f66878c = 0;
        }

        public final void d(int[] iArr, int i, int i2) throws IOException {
            while (i2 > 0) {
                iArr[i] = e();
                i2--;
                i++;
            }
        }

        public final int e() throws IOException {
            return a(4);
        }

        public final int[] f(int i) throws IOException {
            int[] iArr = new int[i];
            d(iArr, 0, i);
            return iArr;
        }

        public final void g() throws IOException {
            h(4);
        }

        public final void h(int i) throws IOException {
            if (i > 0) {
                long j = i;
                long skip = this.f66876a.skip(j);
                this.f66878c = (int) (this.f66878c + skip);
                if (skip != j) {
                    throw new EOFException();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e {
        public static PackageInfo a(@NonNull Context context, @NonNull File file, int i) {
            int i2;
            if (d.o.a.e.b.l.a.a(268435456) && (i2 = Build.VERSION.SDK_INT) >= 21 && i2 < 26) {
                try {
                    return b(file);
                } catch (Throwable th) {
                    f("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                    return g(context, file, i);
                }
            }
            return g(context, file, i);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:118:0x0144 */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
            r13 = r1.getInputStream(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
            r4 = r1;
            r5 = r2;
            r1 = null;
            r13 = r13;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static PackageInfo b(@NonNull File file) {
            ZipInputStream zipInputStream;
            FileInputStream fileInputStream;
            ZipFile zipFile;
            ZipInputStream zipInputStream2;
            ZipFile zipFile2;
            ZipEntry zipEntry;
            FileInputStream fileInputStream2;
            ZipInputStream zipInputStream3;
            ZipFile zipFile3;
            ZipInputStream zipInputStream4;
            int e2;
            long j;
            b bVar = null;
            bVar = null;
            String str = null;
            bVar = null;
            bVar = null;
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    FileInputStream fileInputStream3 = new FileInputStream(file);
                    try {
                        ZipInputStream zipInputStream5 = new ZipInputStream(fileInputStream3);
                        while (true) {
                            ZipEntry nextEntry = zipInputStream5.getNextEntry();
                            if (nextEntry == null) {
                                zipFile3 = null;
                                zipEntry = nextEntry;
                                fileInputStream = fileInputStream3;
                                zipInputStream4 = zipInputStream5;
                                zipInputStream3 = null;
                                break;
                            } else if (nextEntry.isDirectory()) {
                                try {
                                    zipInputStream5.closeEntry();
                                } catch (Throwable unused) {
                                }
                            } else if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                                zipFile3 = null;
                                zipEntry = nextEntry;
                                fileInputStream = fileInputStream3;
                                zipInputStream4 = zipInputStream5;
                                zipInputStream3 = zipInputStream5;
                                break;
                            } else {
                                zipInputStream5.closeEntry();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        zipFile = null;
                        fileInputStream = fileInputStream3;
                        zipInputStream = null;
                        try {
                            throw new com.ss.android.socialbase.appdownloader.f.a.c("throwable: " + th.getMessage() + th.toString());
                        } catch (Throwable th2) {
                            if (bVar != null) {
                                try {
                                    bVar.b();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Throwable unused4) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused5) {
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    ZipFile zipFile4 = new ZipFile(file);
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile4.entries();
                        ZipEntry zipEntry2 = null;
                        while (true) {
                            if (!entries.hasMoreElements()) {
                                zipInputStream2 = null;
                                zipFile2 = zipFile4;
                                zipEntry = zipEntry2;
                                fileInputStream2 = null;
                                break;
                            }
                            zipEntry2 = entries.nextElement();
                            if (!zipEntry2.isDirectory() && "AndroidManifest.xml".equals(zipEntry2.getName())) {
                                break;
                            }
                        }
                        fileInputStream = fileInputStream2;
                        zipInputStream4 = fileInputStream2;
                        zipFile3 = zipFile2;
                        zipInputStream3 = zipInputStream2;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                        zipFile = zipFile4;
                        zipInputStream = null;
                        throw new com.ss.android.socialbase.appdownloader.f.a.c("throwable: " + th.getMessage() + th.toString());
                    }
                }
                if (zipEntry != null) {
                    try {
                        if ("AndroidManifest.xml".equals(zipEntry.getName())) {
                            b bVar2 = new b();
                            try {
                                bVar2.c(zipInputStream3);
                                do {
                                    e2 = bVar2.e();
                                    if (e2 == 1) {
                                        throw new com.ss.android.socialbase.appdownloader.f.a.c("已达到END_DOCUMENT");
                                    }
                                } while (e2 != 2);
                                int i = bVar2.i();
                                String str2 = null;
                                String str3 = null;
                                for (int i2 = 0; i2 != i; i2++) {
                                    if (PushManager.APP_VERSION_NAME.equals(bVar2.a(i2))) {
                                        str2 = e(bVar2, i2);
                                    } else if (PushManager.APP_VERSION_CODE.equals(bVar2.a(i2))) {
                                        str = e(bVar2, i2);
                                    } else if ("package".equals(bVar2.a(i2))) {
                                        str3 = e(bVar2, i2);
                                    }
                                }
                                try {
                                    j = Long.parseLong(str);
                                } catch (com.ss.android.socialbase.appdownloader.f.a.c unused6) {
                                    j = -1;
                                }
                                if (j != -1) {
                                    PackageInfo packageInfo = new PackageInfo();
                                    packageInfo.versionName = str2;
                                    packageInfo.versionCode = (int) j;
                                    packageInfo.packageName = str3;
                                    if (zipInputStream4 != null) {
                                        try {
                                            zipInputStream4.closeEntry();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    try {
                                        bVar2.b();
                                    } catch (Throwable unused8) {
                                    }
                                    if (zipInputStream3 != null) {
                                        try {
                                            zipInputStream3.close();
                                        } catch (Throwable unused9) {
                                        }
                                    }
                                    if (zipFile3 != null) {
                                        try {
                                            zipFile3.close();
                                        } catch (Throwable unused10) {
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable unused11) {
                                        }
                                    }
                                    return packageInfo;
                                }
                                throw new com.ss.android.socialbase.appdownloader.f.a.c("versionCode获取失败: " + str);
                            } catch (Throwable th4) {
                                zipInputStream = zipInputStream3;
                                th = th4;
                                bVar = bVar2;
                                zipFile = zipFile3;
                                throw new com.ss.android.socialbase.appdownloader.f.a.c("throwable: " + th.getMessage() + th.toString());
                            }
                        }
                    } catch (Throwable th5) {
                        zipInputStream = zipInputStream3;
                        th = th5;
                        zipFile = zipFile3;
                    }
                }
                throw new com.ss.android.socialbase.appdownloader.f.a.c("没有找到AndroidManifest.xml entry");
            } catch (Throwable th6) {
                th = th6;
                zipInputStream = bVar;
                fileInputStream = zipInputStream;
                zipFile = fileInputStream;
            }
        }

        public static String c(int i) {
            return (i >>> 24) == 1 ? "android:" : "";
        }

        public static String d(Context context, PackageInfo packageInfo, String str) {
            ApplicationInfo applicationInfo;
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
                return null;
            }
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadLabel(context.getPackageManager()).toString();
            } catch (OutOfMemoryError e2) {
                f("getPackageInfo::fail_load_label", e2.getMessage());
                return null;
            }
        }

        public static String e(b bVar, int i) {
            int f2 = bVar.f(i);
            int g2 = bVar.g(i);
            if (f2 == 3) {
                return bVar.h(i);
            }
            return f2 == 2 ? String.format("?%s%08X", c(g2), Integer.valueOf(g2)) : (f2 < 16 || f2 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(g2), Integer.valueOf(f2)) : String.valueOf(g2);
        }

        public static void f(@NonNull String str, @NonNull String str2) {
            d.o.a.e.b.e.b p0 = d.o.a.e.b.g.d.p0();
            if (p0 == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", str2);
            } catch (JSONException unused) {
            }
            p0.a(str, jSONObject, null, null);
        }

        public static PackageInfo g(@NonNull Context context, @NonNull File file, int i) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                f("unzip_getpackagearchiveinfo", "packageManager == null");
                return null;
            }
            try {
                return packageManager.getPackageArchiveInfo(file.getPath(), i);
            } catch (Throwable th) {
                f("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
                return null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public int[] f66879a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f66880b;

        public static final int a(int[] iArr, int i) {
            int i2 = iArr[i / 4];
            return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
        }

        public static f b(d dVar) throws IOException {
            c.a(dVar, 1835009);
            int e2 = dVar.e();
            int e3 = dVar.e();
            int e4 = dVar.e();
            dVar.e();
            int e5 = dVar.e();
            int e6 = dVar.e();
            f fVar = new f();
            fVar.f66879a = dVar.f(e3);
            if (e4 != 0) {
                dVar.f(e4);
            }
            int i = (e6 == 0 ? e2 : e6) - e5;
            if (i % 4 == 0) {
                fVar.f66880b = dVar.f(i / 4);
                if (e6 != 0) {
                    int i2 = e2 - e6;
                    if (i2 % 4 == 0) {
                        dVar.f(i2 / 4);
                    } else {
                        throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
                    }
                }
                return fVar;
            }
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }

        public String c(int i) {
            int[] iArr;
            if (i < 0 || (iArr = this.f66879a) == null || i >= iArr.length) {
                return null;
            }
            int i2 = iArr[i];
            int a2 = a(this.f66880b, i2);
            StringBuilder sb = new StringBuilder(a2);
            while (a2 != 0) {
                i2 += 2;
                sb.append((char) a(this.f66880b, i2));
                a2--;
            }
            return sb.toString();
        }
    }

    /* loaded from: classes7.dex */
    public interface g {
        int c();

        String d();

        int f();
    }

    public static void a(DownloadInfo downloadInfo) {
        b(downloadInfo);
    }

    public static void b(DownloadInfo downloadInfo) {
        Context l = d.o.a.e.b.g.d.l();
        boolean z = true;
        if (((downloadInfo.d1() && !downloadInfo.R1()) || d.o.a.e.a.d.K(downloadInfo.R()) || TextUtils.isEmpty(downloadInfo.m0()) || !downloadInfo.m0().equals("application/vnd.android.package-archive")) && d.o.a.e.b.j.a.d(downloadInfo.c0()).b("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        d.o.a.e.b.g.d.w0().execute(new RunnableC1842a(l, downloadInfo, z ? d.o.a.e.a.d.d(l, downloadInfo.c0(), false) : 2));
    }

    /* loaded from: classes7.dex */
    public class b implements g {

        /* renamed from: a  reason: collision with root package name */
        public d f66865a;

        /* renamed from: c  reason: collision with root package name */
        public f f66867c;

        /* renamed from: e  reason: collision with root package name */
        public boolean f66869e;

        /* renamed from: f  reason: collision with root package name */
        public int f66870f;

        /* renamed from: g  reason: collision with root package name */
        public int f66871g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f66872h;
        public int i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f66866b = false;

        /* renamed from: d  reason: collision with root package name */
        public C1843a f66868d = new C1843a();

        /* renamed from: d.o.a.e.a.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C1843a {

            /* renamed from: a  reason: collision with root package name */
            public int[] f66873a = new int[32];

            /* renamed from: b  reason: collision with root package name */
            public int f66874b;

            /* renamed from: c  reason: collision with root package name */
            public int f66875c;

            public final void a() {
                this.f66874b = 0;
                this.f66875c = 0;
            }

            public final void b(int i) {
                int[] iArr = this.f66873a;
                int length = iArr.length;
                int i2 = this.f66874b;
                int i3 = length - i2;
                if (i3 <= i) {
                    int[] iArr2 = new int[(iArr.length + i3) * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    this.f66873a = iArr2;
                }
            }

            public final void c(int i, int i2) {
                if (this.f66875c == 0) {
                    g();
                }
                b(2);
                int i3 = this.f66874b;
                int i4 = i3 - 1;
                int[] iArr = this.f66873a;
                int i5 = iArr[i4];
                int i6 = i5 + 1;
                iArr[(i4 - 1) - (i5 * 2)] = i6;
                iArr[i4] = i;
                iArr[i4 + 1] = i2;
                iArr[i4 + 2] = i6;
                this.f66874b = i3 + 2;
            }

            public final int d() {
                int i = this.f66874b;
                if (i == 0) {
                    return 0;
                }
                return this.f66873a[i - 1];
            }

            public final boolean e() {
                int i;
                int[] iArr;
                int i2;
                int i3 = this.f66874b;
                if (i3 == 0 || (i2 = (iArr = this.f66873a)[i3 - 1]) == 0) {
                    return false;
                }
                int i4 = i2 - 1;
                int i5 = i - 2;
                iArr[i5] = i4;
                iArr[i5 - ((i4 * 2) + 1)] = i4;
                this.f66874b = i3 - 2;
                return true;
            }

            public final int f() {
                return this.f66875c;
            }

            public final void g() {
                b(2);
                int i = this.f66874b;
                int[] iArr = this.f66873a;
                iArr[i] = 0;
                iArr[i + 1] = 0;
                this.f66874b = i + 2;
                this.f66875c++;
            }

            public final void h() {
                int i = this.f66874b;
                if (i != 0) {
                    int i2 = i - 1;
                    int i3 = this.f66873a[i2] * 2;
                    if ((i2 - 1) - i3 != 0) {
                        this.f66874b = i - (i3 + 2);
                        this.f66875c--;
                    }
                }
            }
        }

        public b() {
            k();
        }

        public String a(int i) {
            int i2 = this.f66872h[j(i) + 1];
            return i2 == -1 ? "" : this.f66867c.c(i2);
        }

        public void b() {
            if (this.f66866b) {
                this.f66866b = false;
                this.f66865a.b();
                this.f66865a = null;
                this.f66867c = null;
                this.f66868d.a();
                k();
            }
        }

        public void c(InputStream inputStream) {
            b();
            if (inputStream != null) {
                this.f66865a = new d(inputStream, false);
            }
        }

        @Override // d.o.a.e.a.h.a.g
        public String d() {
            return "XML line #" + c();
        }

        public int e() throws h, IOException {
            if (this.f66865a != null) {
                try {
                    l();
                    return this.f66870f;
                } catch (IOException e2) {
                    b();
                    throw e2;
                }
            }
            throw new h("Parser is not opened.", this, null);
        }

        @Override // d.o.a.e.a.h.a.g
        public int f() {
            return -1;
        }

        public int f(int i) {
            return this.f66872h[j(i) + 3];
        }

        public int g(int i) {
            return this.f66872h[j(i) + 4];
        }

        public String h(int i) {
            int j = j(i);
            int[] iArr = this.f66872h;
            if (iArr[j + 3] == 3) {
                return this.f66867c.c(iArr[j + 2]);
            }
            int i2 = iArr[j + 4];
            return "";
        }

        public int i() {
            if (this.f66870f != 2) {
                return -1;
            }
            return this.f66872h.length / 5;
        }

        public final int j(int i) {
            if (this.f66870f == 2) {
                int i2 = i * 5;
                if (i2 < this.f66872h.length) {
                    return i2;
                }
                throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
            }
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }

        public final void k() {
            this.f66870f = -1;
            this.f66871g = -1;
            this.f66872h = null;
            this.i = -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x0172, code lost:
            throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void l() throws IOException {
            int e2;
            if (this.f66867c == null) {
                c.a(this.f66865a, 524291);
                this.f66865a.g();
                this.f66867c = f.b(this.f66865a);
                this.f66868d.g();
                this.f66866b = true;
            }
            int i = this.f66870f;
            if (i != 1) {
                k();
                while (true) {
                    if (this.f66869e) {
                        this.f66869e = false;
                        this.f66868d.h();
                    }
                    int i2 = 3;
                    if (i == 3 && this.f66868d.f() == 1 && this.f66868d.d() == 0) {
                        this.f66870f = 1;
                        return;
                    }
                    int e3 = i == 0 ? 1048834 : this.f66865a.e();
                    if (e3 == 524672) {
                        e2 = this.f66865a.e();
                        if (e2 < 8 || e2 % 4 != 0) {
                            break;
                        }
                        this.f66865a.f((e2 / 4) - 2);
                    } else if (e3 < 1048832 || e3 > 1048836) {
                        break;
                    } else if (e3 == 1048834 && i == -1) {
                        this.f66870f = 0;
                        return;
                    } else {
                        this.f66865a.g();
                        int e4 = this.f66865a.e();
                        this.f66865a.g();
                        if (e3 != 1048832 && e3 != 1048833) {
                            this.f66871g = e4;
                            if (e3 == 1048834) {
                                this.f66865a.e();
                                this.f66865a.e();
                                this.f66865a.g();
                                int e5 = this.f66865a.e();
                                this.i = e5;
                                this.i = (65535 & e5) - 1;
                                this.f66872h = this.f66865a.f((this.f66865a.e() & 65535) * 5);
                                while (true) {
                                    int[] iArr = this.f66872h;
                                    if (i2 < iArr.length) {
                                        iArr[i2] = iArr[i2] >>> 24;
                                        i2 += 5;
                                    } else {
                                        this.f66868d.g();
                                        this.f66870f = 2;
                                        return;
                                    }
                                }
                            } else if (e3 == 1048835) {
                                this.f66865a.e();
                                this.f66865a.e();
                                this.f66870f = 3;
                                this.f66869e = true;
                                return;
                            } else if (e3 == 1048836) {
                                this.f66865a.e();
                                this.f66865a.g();
                                this.f66865a.g();
                                this.f66870f = 4;
                                return;
                            }
                        } else if (e3 == 1048832) {
                            this.f66868d.c(this.f66865a.e(), this.f66865a.e());
                        } else {
                            this.f66865a.g();
                            this.f66865a.g();
                            this.f66868d.e();
                        }
                    }
                }
                throw new IOException("Invalid resource ids size (" + e2 + ").");
            }
        }

        @Override // d.o.a.e.a.h.a.g
        public int c() {
            return this.f66871g;
        }
    }
}
