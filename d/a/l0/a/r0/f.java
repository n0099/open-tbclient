package d.a.l0.a.r0;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.FileUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends d.a.l0.a.k2.f.c {

    /* renamed from: e  reason: collision with root package name */
    public static List<String> f48063e;

    /* renamed from: a  reason: collision with root package name */
    public Context f48064a;

    /* renamed from: b  reason: collision with root package name */
    public String f48065b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.l0.a.k2.f.d f48066c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.l0.a.k2.f.e f48067d;

    static {
        ArrayList arrayList = new ArrayList();
        f48063e = arrayList;
        arrayList.add("ascii");
        f48063e.add("base64");
        f48063e.add("binary");
        f48063e.add("hex");
        f48063e.add("utf-8");
        f48063e.add("utf8");
        f48063e.add("latin1");
        f48063e.add("ucs2");
        f48063e.add("ucs-2");
        f48063e.add("utf16le");
        f48063e.add("utf-16le");
    }

    public f(Context context, String str, @NonNull d.a.l0.a.k2.f.d dVar) {
        this.f48064a = context;
        this.f48065b = str;
        this.f48066c = dVar;
        this.f48067d = dVar.d();
    }

    public c A(String str, String str2) {
        c v = n.v(str, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (v != null) {
            return v;
        }
        c v2 = n.v(str2, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
        if (v2 != null) {
            return v2;
        }
        if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
            return d(-1, "fail permission denied, open " + str2);
        }
        String I = n.I(str);
        if (!this.f48066c.j(I, true)) {
            return d(-4, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
        }
        if (!n.R(str2)) {
            return d(-4, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
        }
        if (m(str2)) {
            return d(-1, n.D("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
        }
        String g2 = g(I);
        String g3 = g(str2);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
        }
        if (TextUtils.isEmpty(g3)) {
            return d(-1, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
        }
        File file = new File(g2);
        if (!file.exists()) {
            return d(-1, n.D("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
        }
        if (!g2.endsWith(".zip")) {
            return d(-1, "fail unzip failed");
        }
        if (!file.isFile()) {
            return d(-1, n.D("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
        }
        File file2 = new File(g3);
        if (!file2.exists()) {
            file2.mkdirs();
        } else if (file2.isFile()) {
            return d(-1, "fail unzip failed");
        }
        List<String> m = n.m(g3, true);
        if (!d.a.l0.t.d.T(g2, g3)) {
            return d(-1, "fail unzip failed");
        }
        if (str2.startsWith(a.USER_DATA_PATH)) {
            List<String> m2 = n.m(g3, true);
            ArrayList arrayList = new ArrayList(m2.size());
            long j = 0;
            for (String str3 : m2) {
                if (!m.contains(str3)) {
                    arrayList.add(str3);
                    j += n.x(str3);
                }
            }
            if (this.f48067d.a(j)) {
                n.g(arrayList);
                return d(-1, p());
            }
            this.f48067d.b(j);
        }
        return d(0, "ok");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x01b9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x01ac */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0160 A[Catch: all -> 0x01a8, Exception -> 0x01ab, TryCatch #5 {Exception -> 0x01ab, all -> 0x01a8, blocks: (B:54:0x0120, B:56:0x012a, B:58:0x0132, B:61:0x0144, B:63:0x014c, B:66:0x0150, B:68:0x0158, B:70:0x0160, B:72:0x0179, B:71:0x016b, B:78:0x018c), top: B:94:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016b A[Catch: all -> 0x01a8, Exception -> 0x01ab, TryCatch #5 {Exception -> 0x01ab, all -> 0x01a8, blocks: (B:54:0x0120, B:56:0x012a, B:58:0x0132, B:61:0x0144, B:63:0x014c, B:66:0x0150, B:68:0x0158, B:70:0x0160, B:72:0x0179, B:71:0x016b, B:78:0x018c), top: B:94:0x011e }] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c B(String str, Object obj, String str2, boolean z) {
        int length;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        String str3;
        BufferedWriter bufferedWriter;
        c n = n(str);
        if (n != null) {
            return n;
        }
        if (obj == null) {
            return d(-1, "The argument must be string or arrayBuffer");
        }
        int length2 = (a.USER_DATA_PATH + File.separator).length();
        if (!n.R(str)) {
            return d(-4, "fail permission denied, open " + str.substring(length2));
        }
        boolean z2 = obj instanceof byte[];
        String str4 = "utf-8";
        String str5 = str2;
        if (!z2) {
            boolean isEmpty = TextUtils.isEmpty(str2);
            str5 = str2;
            if (isEmpty) {
                str5 = "utf-8";
            }
        }
        boolean isEmpty2 = TextUtils.isEmpty(str5);
        ?? r14 = str5;
        if (!isEmpty2) {
            boolean equals = "binary".equals(str5.toLowerCase());
            String str6 = str5;
            if (equals) {
                str6 = "latin1";
            }
            boolean contains = f48063e.contains(str6.toLowerCase());
            r14 = str6;
            if (!contains) {
                return d(-1, "fail invalid encoding \"" + str6 + "\"");
            }
        }
        c h2 = h(str, false);
        if (h2 != null) {
            return h2;
        }
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str.substring(length2));
        }
        long j = 0;
        if (!z2) {
            String str7 = (String) obj;
            if (!TextUtils.isEmpty(str7)) {
                length = str7.getBytes().length;
                j = length;
                if (!this.f48066c.d().a(j)) {
                    return d(-1, p());
                }
                File file = new File(g2);
                if (file.exists() && file.isDirectory()) {
                    return d(-1, " fail illegal operation on a directory, open " + str);
                }
                long length3 = file.length();
                c d2 = d(0, "ok");
                BufferedWriter bufferedWriter2 = null;
                try {
                    try {
                        try {
                            if (!z2) {
                                if (!TextUtils.isEmpty((String) obj) && TextUtils.equals("base64", r14)) {
                                    byte[] decode = Base64.decode((String) obj, 2);
                                    FileOutputStream fileOutputStream3 = new FileOutputStream(file, z);
                                    fileOutputStream3.write(decode);
                                    fileOutputStream3.flush();
                                    fileOutputStream2 = fileOutputStream3;
                                } else {
                                    String[] s = n.s((String) obj, r14);
                                    try {
                                        if (s != null && s.length == 2) {
                                            str3 = s[0];
                                            str4 = s[1];
                                            bufferedWriter = new BufferedWriter(!TextUtils.isEmpty(str4) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str4.toLowerCase()));
                                            bufferedWriter.write(str3);
                                            bufferedWriter.flush();
                                            fileOutputStream2 = null;
                                            bufferedWriter2 = bufferedWriter;
                                        }
                                        bufferedWriter.write(str3);
                                        bufferedWriter.flush();
                                        fileOutputStream2 = null;
                                        bufferedWriter2 = bufferedWriter;
                                    } catch (Exception unused) {
                                        r14 = 0;
                                        bufferedWriter2 = bufferedWriter;
                                        d2 = d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
                                        fileOutputStream = r14;
                                        d.a.l0.t.d.d(bufferedWriter2);
                                        d.a.l0.t.d.d(fileOutputStream);
                                        return d2;
                                    } catch (Throwable th) {
                                        th = th;
                                        r14 = 0;
                                        bufferedWriter2 = bufferedWriter;
                                        d.a.l0.t.d.d(bufferedWriter2);
                                        d.a.l0.t.d.d(r14);
                                        throw th;
                                    }
                                    str3 = "";
                                    bufferedWriter = new BufferedWriter(!TextUtils.isEmpty(str4) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str4.toLowerCase()));
                                }
                            } else {
                                byte[] bArr = (byte[]) obj;
                                FileOutputStream fileOutputStream4 = new FileOutputStream(g2, z);
                                fileOutputStream4.write(bArr);
                                fileOutputStream4.flush();
                                fileOutputStream2 = fileOutputStream4;
                            }
                            if (z) {
                                this.f48067d.b(j);
                                fileOutputStream = fileOutputStream2;
                            } else {
                                this.f48067d.b(j - length3);
                                fileOutputStream = fileOutputStream2;
                            }
                        } catch (Exception unused2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception unused3) {
                    r14 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    r14 = 0;
                }
                d.a.l0.t.d.d(bufferedWriter2);
                d.a.l0.t.d.d(fileOutputStream);
                return d2;
            }
        }
        if (z2) {
            length = ((byte[]) obj).length;
            j = length;
        }
        if (!this.f48066c.d().a(j)) {
        }
    }

    public c C(boolean z, String str, Object obj, String str2) {
        String str3;
        if (z) {
            str3 = "filePath must be a string";
        } else {
            str3 = "fail permission denied, open " + str;
        }
        c v = n.v(str, str3, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return v != null ? v : B(str, obj, str2, false);
    }

    public c a(String str, boolean z) {
        c v = n.v(str, z ? "path must be a string" : n.C("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (v != null) {
            return v;
        }
        String I = n.I(str);
        if (!this.f48066c.j(I, true)) {
            return d(-4, n.C("fail no such file or directory ", "access", str, null));
        }
        String g2 = g(I);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        } else if (!new File(g2).exists()) {
            return d(-1, n.C("fail no such file or directory ", "access", str, null));
        } else {
            return d(0, "ok");
        }
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c v = n.v(str, n.C("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (v != null) {
            return v;
        }
        String I = n.I(str);
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return d(-1, "fail sdcard not mounted ");
        }
        c n = n(I);
        if (n != null) {
            return n;
        }
        if (obj == null) {
            return d(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
        }
        String g2 = g(I);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        File file = new File(g2);
        if (!file.exists()) {
            return d(-1, n.C("fail no such file or directory ", "open", str, null));
        }
        if (file.isDirectory()) {
            return d(-1, "fail illegal operation on a directory, open " + str);
        }
        return B(I, obj, str2, true);
    }

    public c c(String str, String str2, boolean z) {
        c v = n.v(str, "srcPath must be a string", " The argument must be string");
        if (v != null) {
            return v;
        }
        c v2 = n.v(str2, "destPath must be a string", " The argument must be string");
        if (v2 != null) {
            return v2;
        }
        String I = n.I(str);
        boolean z2 = true;
        if (!this.f48066c.j(I, true)) {
            return d(-4, n.C("fail no such file or directory ", "copyFile", str, null));
        }
        String I2 = n.I(str2);
        if (!n.R(I2)) {
            return d(-4, n.C("fail permission denied, open ", "copyFile", str2, null));
        }
        c n = n(I2);
        if (n != null) {
            return n;
        }
        String g2 = g(I);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        File file = new File(g2);
        if (file.exists() && file.isFile()) {
            c h2 = h(I2, false);
            if (h2 != null) {
                h2.f47943b = n.C("fail no such file or directory ", "copyFile", str2, null);
                return h2;
            } else if (I2.endsWith(File.separator)) {
                return d(-1, n.C("fail permission denied, ", "copyFile", str, str2));
            } else {
                String g3 = g(I2);
                if (TextUtils.isEmpty(g3)) {
                    return d(-1, "fail no such file or directory " + str2);
                }
                File file2 = new File(g3);
                if (file2.exists() && file2.isDirectory()) {
                    if (k(file2.listFiles())) {
                        return d(-1, n.C("fail permission denied, ", "copyFile", str, str2));
                    }
                    try {
                        file2.delete();
                    } catch (Exception unused) {
                        return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
                    }
                }
                long x = n.x(g2);
                z2 = (I.equals(I2) || I.startsWith(a.USER_DATA_PATH)) ? false : false;
                if (z2 && this.f48067d.a(x)) {
                    return d(-1, p());
                }
                c w = !I.equals(I2) ? w(I, I2) : d(0, "ok");
                if (z2 && w != null && w.f47942a == 0) {
                    this.f48067d.b(x);
                }
                return w;
            }
        }
        return d(-1, n.C("fail no such file or directory ", "copyFile", str, null));
    }

    public final c d(int i2, String str) {
        c cVar = new c();
        cVar.f47942a = i2;
        cVar.f47943b = str;
        return cVar;
    }

    public c e(String str) {
        c v = n.v(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (v != null) {
            return v;
        }
        String I = n.I(str);
        if (!this.f48066c.j(I, true)) {
            return d(-4, "fail file not exist");
        }
        String g2 = g(I);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        File file = new File(g2);
        if (!file.exists()) {
            return d(-1, "fail file not exist");
        }
        if (file.isDirectory()) {
            return d(-1, "fail " + str + " is directory");
        }
        c d2 = d(0, "ok");
        d2.f47946e = file.exists() ? file.length() : 0L;
        d2.f47948g = file.exists() ? d.a.l0.t.f.b(file, false) : null;
        return d2;
    }

    public final c f(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.f47942a = -1;
            cVar.f47943b = "fail no such file or directory " + str;
            return cVar;
        }
        String g2 = g(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.f47942a = -1;
            cVar2.f47943b = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(g2);
        if (!file.exists()) {
            c cVar3 = new c();
            cVar3.f47942a = -1;
            cVar3.f47943b = "fail no such file or directory " + str;
            return cVar3;
        } else if (!z || file.isFile()) {
            return null;
        } else {
            c cVar4 = new c();
            cVar4.f47942a = -1;
            cVar4.f47943b = "fail no such file or directory " + str;
            return cVar4;
        }
    }

    public final String g(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("bdfile://code")) {
            return str.startsWith(WebGLImageLoader.BDFILE) ? this.f48066c.i(str) : "";
        }
        if (this.f48065b.endsWith(File.separator)) {
            String str3 = this.f48065b;
            str2 = str3.substring(0, str3.length() - 1);
        } else {
            str2 = this.f48065b;
        }
        this.f48065b = str2;
        return this.f48065b + str.substring(13);
    }

    public final c h(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        } else if (g2.contains(File.separator)) {
            File file = new File(g2.substring(0, g2.lastIndexOf(File.separator)));
            if (z) {
                return null;
            }
            if (!file.exists() || (file.exists() && file.isFile())) {
                return d(-1, "fail no such file or directory " + str);
            }
            return null;
        } else {
            return null;
        }
    }

    public c i() {
        String f2 = this.f48066c.f();
        String g2 = g(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.m(g2, false)) {
            File file = new File(str);
            d dVar = new d();
            long j = 0;
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(f2) && absolutePath.startsWith(f2)) {
                dVar.filePath = this.f48066c.g(absolutePath);
            }
            if (file.exists()) {
                j = file.length();
            }
            dVar.size = j;
            arrayList.add(dVar);
        }
        c d2 = d(0, "ok");
        d2.f47947f = arrayList;
        return d2;
    }

    public final c j(String str, j jVar) {
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        File file = new File(g2);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e2) {
                e2.printStackTrace();
                return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
            }
        } else {
            try {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField(IAdRequestParam.OS);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(null);
                Object invoke = obj.getClass().getMethod("lstat", String.class).invoke(obj, file.getAbsolutePath());
                Field declaredField2 = invoke.getClass().getDeclaredField("st_atime");
                if (!declaredField2.isAccessible()) {
                    declaredField2.setAccessible(true);
                }
                jVar.lastAccessedTime = declaredField2.getLong(invoke);
                Field declaredField3 = invoke.getClass().getDeclaredField("st_mtime");
                if (!declaredField3.isAccessible()) {
                    declaredField3.setAccessible(true);
                }
                jVar.lastModifiedTime = declaredField3.getLong(invoke);
                Field declaredField4 = invoke.getClass().getDeclaredField("st_mode");
                if (!declaredField4.isAccessible()) {
                    declaredField4.setAccessible(true);
                }
                jVar.mode = declaredField4.getInt(invoke);
                Field declaredField5 = invoke.getClass().getDeclaredField("st_size");
                if (!declaredField5.isAccessible()) {
                    declaredField5.setAccessible(true);
                }
                jVar.size = declaredField5.getLong(invoke);
            } catch (Exception e3) {
                e3.printStackTrace();
                return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
            }
        }
        c d2 = d(0, "ok");
        d2.f47945d = jVar;
        d2.f47943b = "ok";
        return d2;
    }

    public final boolean k(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public final boolean l(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public final boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return l(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return l(str);
    }

    public final c n(String str) {
        c d2 = d(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return d2;
    }

    public c o(String str, boolean z, boolean z2) {
        String str2;
        boolean mkdir;
        if (z2) {
            str2 = "dirPath must be a string";
        } else {
            str2 = "fail permission denied, open " + str;
        }
        c v = n.v(str, str2, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (v != null) {
            return v;
        }
        c n = n(str);
        if (n != null) {
            return n;
        }
        if (!n.R(str)) {
            return d(-4, "fail permission denied, open " + str);
        }
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        c h2 = h(str, z);
        if (h2 != null) {
            return h2;
        }
        File file = new File(g2);
        if (file.exists()) {
            return d(-1, "fail file already exists " + str);
        }
        try {
            if (z) {
                mkdir = file.mkdirs();
            } else {
                mkdir = file.mkdir();
            }
            if (!mkdir) {
                return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
            }
            return d(0, "ok");
        } catch (Exception unused) {
            return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
        }
    }

    public final String p() {
        String l = d.a.l0.t.d.l(this.f48067d.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(l) || TextUtils.equals(l, FileUtils.UNKNOW)) ? "" : "");
    }

    public c q(String str, String str2, boolean z) {
        c v = n.v(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (v != null) {
            return v;
        }
        String I = n.I(str);
        if (!this.f48066c.j(I, true)) {
            return d(-1, "fail permission denied, open " + str);
        }
        c f2 = f(I, true);
        if (f2 != null) {
            f2.f47943b = n.C("fail no such file or directory ", "open", str, null);
            return f2;
        }
        boolean isEmpty = TextUtils.isEmpty(str2);
        if (!isEmpty) {
            str2 = str2.toLowerCase();
            if ("binary".equals(str2)) {
                str2 = "latin1";
            }
        }
        if (!isEmpty && !f48063e.contains(str2)) {
            return d(-1, "fail Error: Unknown encoding: " + str2);
        }
        String g2 = g(I);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        File file = new File(g2);
        byte[] bArr = new byte[0];
        c d2 = d(0, "ok");
        try {
            String str3 = "";
            if (TextUtils.isEmpty(str2)) {
                bArr = n.o(g2);
            } else if ("base64".equals(str2)) {
                bArr = n.o(g2);
                if (bArr.length != 0) {
                    str3 = Base64.encodeToString(bArr, 2);
                }
            } else if ("hex".equals(str2)) {
                str3 = n.l(g2);
            } else {
                str3 = r(new FileInputStream(file), str2);
            }
            if (TextUtils.isEmpty(str2)) {
                d2.f47949h = bArr;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str3);
                d2.f47944c = arrayList;
            }
            return d2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
        }
    }

    public final String r(FileInputStream fileInputStream, String str) {
        if (fileInputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(TextUtils.isEmpty(str) ? new InputStreamReader(fileInputStream) : new InputStreamReader(fileInputStream, str));
            char[] cArr = new char[1024];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    return sb.toString();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } finally {
            d.a.l0.t.d.d(fileInputStream);
        }
    }

    public c s(String str, boolean z) {
        c v = n.v(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (v != null) {
            return v;
        }
        String I = n.I(str);
        if (!n.S(I)) {
            return d(-4, "fail permission denied, open " + str);
        }
        String g2 = g(I);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        File file = new File(g2);
        if (!file.exists()) {
            return d(-1, "fail no such file or directory " + str);
        } else if (!file.isDirectory()) {
            return d(-1, "fail no such file or directory " + str);
        } else {
            File[] listFiles = file.listFiles();
            ArrayList arrayList = new ArrayList();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        arrayList.add(d.a.l0.t.d.q(file2.getAbsolutePath()));
                    }
                }
            }
            c d2 = d(0, "ok");
            d2.f47944c = arrayList;
            return d2;
        }
    }

    public c t(String str) {
        c v = n.v(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (v != null) {
            return v;
        }
        if (n(str) != null) {
            return d(-4, "fail file not exist");
        }
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        File file = new File(g2);
        if (file.exists() && !file.isDirectory()) {
            long x = n.x(g2);
            try {
                if (!file.delete()) {
                    return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
                }
                this.f48067d.b(-x);
                return d(0, "ok");
            } catch (Exception unused) {
                return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
            }
        }
        return d(-1, "fail file not exist");
    }

    public c u(String str, String str2, boolean z) {
        c v = n.v(str, z ? "oldPath must be a string" : n.C("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (v != null) {
            return v;
        }
        c v2 = n.v(str2, z ? "newPath must be a string" : n.C("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
        if (v2 != null) {
            return v2;
        }
        String I = n.I(str);
        c n = n(I);
        if (n != null) {
            n.f47943b = n.C("fail permission denied, ", "rename", str, str2);
            return n;
        }
        String I2 = n.I(str2);
        c n2 = n(I2);
        if (n2 != null) {
            n2.f47943b = n.C("fail permission denied, ", "rename", str, str2);
            return n2;
        }
        c f2 = f(I, false);
        if (f2 != null) {
            f2.f47943b = n.C("fail no such file or directory ", "rename", str, str2);
            return f2;
        } else if (n.R(I) && n.R(I2)) {
            c h2 = h(I2, false);
            if (h2 != null) {
                h2.f47943b = n.C("fail no such file or directory ", "rename", str, str2);
                return h2;
            }
            String g2 = g(I);
            if (TextUtils.isEmpty(g2)) {
                return d(-1, "fail no such file or directory " + str);
            }
            String g3 = g(I2);
            if (TextUtils.isEmpty(g3)) {
                return d(-1, "fail no such file or directory " + str2);
            }
            File file = new File(g2);
            File file2 = new File(g3);
            boolean exists = file2.exists();
            if (n.Q(file, file2) && (!file.isDirectory() || exists || !m(g3))) {
                try {
                    if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                        return d(-1, "fail rename failed");
                    }
                    return d(0, "ok");
                } catch (Exception unused) {
                    return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
                }
            }
            return d(-1, "fail rename failed");
        } else {
            return d(-4, n.C("fail permission denied, ", "rename", str, str2));
        }
    }

    public c v(String str, boolean z, boolean z2) {
        String str2;
        boolean i2;
        if (z2) {
            str2 = "dirPath must be a string";
        } else {
            str2 = "fail permission denied, open " + str;
        }
        c v = n.v(str, str2, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (v != null) {
            return v;
        }
        c n = n(str);
        if (n != null) {
            return n;
        }
        if (!n.S(str)) {
            return d(-4, "fail permission denied, open " + str);
        }
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str);
        }
        File file = new File(g2);
        if (file.exists() && !file.isFile()) {
            boolean k = k(file.listFiles());
            try {
                if (z || !k) {
                    if (!z) {
                        i2 = file.delete();
                    } else {
                        i2 = d.a.l0.t.d.i(file);
                    }
                    if (!i2) {
                        return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
                    }
                    return d(0, "ok");
                }
                return d(-1, "fail directory not empty ");
            } catch (Exception unused) {
                return d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
            }
        }
        return d(-1, "fail no such file or directory " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c w(String str, String str2) {
        FileOutputStream fileOutputStream;
        String g2 = g(str);
        String g3 = g(str2);
        FileInputStream fileInputStream = null;
        if (TextUtils.isEmpty(g2)) {
            return d(-1, n.C("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(g3)) {
            return d(-1, n.C("fail no such file or directory ", null, str2, null));
        }
        c d2 = d(0, "ok");
        try {
            File file = new File(g3);
            FileInputStream fileInputStream2 = new FileInputStream(new File(g2));
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    d.a.l0.t.d.d(fileInputStream2);
                    d.a.l0.t.d.d(fileOutputStream);
                    if (!TextUtils.isEmpty(str2)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str2);
                        d2.f47944c = arrayList;
                    } else {
                        d2.f47943b = com.baidu.pass.biometrics.face.liveness.b.b.g0;
                        d2.f47942a = -1;
                    }
                    return d2;
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        c d3 = d(-1, com.baidu.pass.biometrics.face.liveness.b.b.g0);
                        d.a.l0.t.d.d(fileInputStream);
                        d.a.l0.t.d.d(fileOutputStream);
                        if (!TextUtils.isEmpty("")) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(str2);
                            d2.f47944c = arrayList2;
                        } else {
                            d2.f47943b = com.baidu.pass.biometrics.face.liveness.b.b.g0;
                            d2.f47942a = -1;
                        }
                        return d3;
                    } catch (Throwable th) {
                        th = th;
                        d.a.l0.t.d.d(fileInputStream);
                        d.a.l0.t.d.d(fileOutputStream);
                        if (TextUtils.isEmpty("")) {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(str2);
                            d2.f47944c = arrayList3;
                        } else {
                            d2.f47943b = com.baidu.pass.biometrics.face.liveness.b.b.g0;
                            d2.f47942a = -1;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    d.a.l0.t.d.d(fileInputStream);
                    d.a.l0.t.d.d(fileOutputStream);
                    if (TextUtils.isEmpty("")) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public c x(String str, String str2, boolean z) {
        c v = n.v(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (v != null) {
            return v;
        }
        String I = n.I(str2);
        if (TextUtils.isEmpty(I)) {
            I = a.USER_DATA_PATH + File.separator + d.a.l0.t.d.q(str);
        }
        if (!I.startsWith(a.USER_DATA_PATH)) {
            return d(-1, n.C("fail permission denied, open ", null, str2, null));
        }
        if (!this.f48066c.l(str)) {
            return d(-4, "fail it is not a tempFilePath");
        }
        c h2 = h(I, false);
        if (h2 != null) {
            return h2;
        }
        c h3 = h(str, false);
        if (h3 != null) {
            return h3;
        }
        String g2 = g(I);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, "fail no such file or directory " + str2);
        }
        File file = new File(g2);
        if (!a.USER_DATA_PATH.equals(I) && (!file.exists() || !file.isDirectory())) {
            c f2 = f(str, true);
            if (f2 != null) {
                f2.f47943b = "fail no such file or directory ";
                return f2;
            }
            String g3 = g(str);
            if (TextUtils.isEmpty(g3)) {
                return d(-1, "fail no such file or directory " + str);
            }
            long x = n.x(g3);
            if (this.f48067d.a(x)) {
                return d(-1, p());
            }
            if (I.startsWith(a.USER_DATA_PATH) && !n.O(I) && !n.O(str)) {
                c h4 = h(I, false);
                if (h4 != null) {
                    return h4;
                }
                c n = n(I);
                if (n != null) {
                    return n;
                }
                c w = w(str, I);
                if (w != null && w.f47942a == 0) {
                    this.f48067d.b(x);
                    if (TextUtils.isEmpty(str)) {
                        return d(-1, n.C("fail no such file or directory ", null, str, null));
                    }
                    File file2 = new File(g3);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(I);
                    w.f47944c = arrayList;
                    w.f47943b = "ok";
                }
                return w;
            }
            return d(-1, n.C("fail permission denied, open ", null, str2, null));
        }
        return d(-1, n.C("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
    }

    public c y(String str, boolean z) {
        c v = n.v(str, z ? "path must be a string" : n.C("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (v != null) {
            return v;
        }
        if (!this.f48066c.l(str) && !this.f48066c.b(str)) {
            return d(-1, "fail permission denied, open " + str);
        }
        c f2 = f(str, false);
        if (f2 != null) {
            return f2;
        }
        j jVar = new j();
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, n.C("fail no such file or directory ", null, str, null));
        }
        File file = new File(g2);
        jVar.a(file.isDirectory());
        jVar.b(file.isFile());
        return j(str, jVar);
    }

    public c z(String str, boolean z) {
        c v = n.v(str, z ? "filePath must be a string" : n.C("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (v != null) {
            return v;
        }
        if (!n.S(str)) {
            return d(-4, n.C("fail permission denied, open ", null, str, null));
        }
        c f2 = f(str, false);
        if (f2 != null) {
            return f2;
        }
        c n = n(str);
        if (n != null) {
            return n;
        }
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return d(-1, n.C("fail no such file or directory ", null, str, null));
        }
        File file = new File(g2);
        if (file.isDirectory()) {
            return d(-1, n.C("fail operation not permitted ", "unlink", str, null));
        }
        long x = n.x(g2);
        try {
            if (file.delete()) {
                this.f48067d.b(-x);
                return d(0, "ok");
            }
            return d(-1, n.C(com.baidu.pass.biometrics.face.liveness.b.b.g0, null, str, null));
        } catch (Exception unused) {
            return d(-1, n.C(com.baidu.pass.biometrics.face.liveness.b.b.g0, null, str, null));
        }
    }
}
