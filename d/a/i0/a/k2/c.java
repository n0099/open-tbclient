package d.a.i0.a.k2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import d.a.i0.a.a2.e;
import d.a.i0.a.a2.f;
import d.a.i0.a.k;
import d.a.i0.a.k2.g.g;
import d.a.i0.a.q2.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends f {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43052e = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public static int f43053f = 1024;

    /* renamed from: g  reason: collision with root package name */
    public static int f43054g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static int f43055h = 1;

    /* renamed from: a  reason: collision with root package name */
    public g f43056a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43057b;

    /* renamed from: c  reason: collision with root package name */
    public final String f43058c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a<Long> f43059d;

    /* loaded from: classes3.dex */
    public class a implements c.a<Long> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.q2.c.a
        /* renamed from: a */
        public Long update() throws IllegalStateException {
            return Long.valueOf(c.this.e());
        }
    }

    public c(e eVar) {
        super(eVar);
        this.f43059d = new a();
        this.f43057b = b.t(eVar);
        this.f43058c = "aiapp_" + this.f43057b;
        d.a.i0.a.q2.d.f44059h.e(this.f43059d);
    }

    public static boolean b(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 512;
    }

    public static boolean c(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length > 3145728;
    }

    public int a(@NonNull String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.length() > Config.FULL_TRACE_LOG_LIMIT ? 2002 : 2000;
        }
        return 2001;
    }

    public void d(boolean z) {
        if (z) {
            g().edit().clear().commit();
        } else {
            g().edit().clear().apply();
        }
        d.a.i0.t.d.j(b.x(e.V()));
        d.a.i0.t.d.j(b.v(e.V()));
        d.a.i0.a.q2.d.f44059h.b();
    }

    public long e() {
        if (f43052e) {
            File c2 = g().c();
            Log.i("SwanAppStorage", this.f43057b + " exists = " + c2.exists() + " isFile = " + c2.isFile() + " path = " + c2.getPath() + " size = " + c2.length());
        }
        return g().d();
    }

    public String f(String str) {
        if (!TextUtils.isEmpty(str) && !str.endsWith(File.separator)) {
            int lastIndexOf = str.lastIndexOf(File.separator);
            int length = str.length();
            if (lastIndexOf != f43054g && length > lastIndexOf) {
                return str.substring(lastIndexOf + f43055h, length);
            }
        }
        return null;
    }

    public g g() {
        if (this.f43056a == null) {
            this.f43056a = new g(this.f43058c, false);
        }
        return this.f43056a;
    }

    public d.a.i0.a.k2.a h(@NonNull String str) {
        File file = new File(str);
        if (file.isFile()) {
            d.a.i0.a.k2.a aVar = new d.a.i0.a.k2.a();
            aVar.f(file.length());
            aVar.d(file.lastModified());
            return aVar;
        }
        return null;
    }

    public List<d.a.i0.a.k2.a> i() {
        String v = b.v(e.V());
        if (TextUtils.isEmpty(v)) {
            return null;
        }
        return k(v);
    }

    public List<d.a.i0.a.k2.a> j(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (f43052e) {
            Log.d("SwanAppStorage", "——> getSavedFileList: " + file.getAbsolutePath());
        }
        d.a.i0.a.k2.a aVar = new d.a.i0.a.k2.a();
        ArrayList arrayList = new ArrayList();
        if (file.isFile()) {
            aVar.e(file.getAbsolutePath());
            aVar.f(file.length());
            aVar.d(file.lastModified());
            arrayList.add(aVar);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<d.a.i0.a.k2.a> j = j(file2);
                if (j != null) {
                    arrayList.addAll(arrayList.size(), j);
                }
            }
        }
        return arrayList;
    }

    public List<d.a.i0.a.k2.a> k(@NonNull String str) {
        if (f43052e) {
            Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return j(file);
        }
        return null;
    }

    public final File l(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public boolean m(@NonNull String str, @NonNull String str2) {
        return (e() - ((long) g().getString(str, "").length())) + ((long) str2.length()) > n();
    }

    public long n() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0044 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0046 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0048 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0073 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x0012 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v7 */
    public String o(String str) {
        Object obj;
        Object obj2;
        Closeable closeable;
        String v = b.v(e.V());
        String str2 = "";
        if (TextUtils.isEmpty(v)) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                File l = l(v, f(str));
                FileInputStream fileInputStream2 = new FileInputStream(new File((String) str));
                try {
                    str = new FileOutputStream(l);
                    try {
                        byte[] bArr = new byte[f43053f];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            str.write(bArr, 0, read);
                            str.flush();
                        }
                        str2 = l.getAbsolutePath();
                        d.a.i0.t.d.d(fileInputStream2);
                        closeable = str;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        obj2 = str;
                        str = obj2;
                        if (f43052e) {
                            e.printStackTrace();
                            str = obj2;
                        }
                        d.a.i0.t.d.d(fileInputStream);
                        closeable = str;
                        d.a.i0.t.d.d(closeable);
                        return str2;
                    } catch (IOException e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        obj = str;
                        str = obj;
                        if (f43052e) {
                            e.printStackTrace();
                            str = obj;
                        }
                        d.a.i0.t.d.d(fileInputStream);
                        closeable = str;
                        d.a.i0.t.d.d(closeable);
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        d.a.i0.t.d.d(fileInputStream);
                        d.a.i0.t.d.d(str);
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    str = 0;
                } catch (IOException e5) {
                    e = e5;
                    str = 0;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            obj2 = null;
        } catch (IOException e7) {
            e = e7;
            obj = null;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
        }
        d.a.i0.t.d.d(closeable);
        return str2;
    }
}
