package d.b.q.g.d;

import android.content.Context;
import d.b.q.g.b.b;
import d.b.q.g.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f64452a;

    /* renamed from: b  reason: collision with root package name */
    public C1752a f64453b;

    public a(Context context) {
        this.f64452a = context;
        c().mkdirs();
    }

    public static void a(File file) {
        file.mkdirs();
    }

    public static String e(File file, String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        a(file);
        File file2 = new File(file, str);
        FileInputStream fileInputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (z) {
                        byteArray = new b().a(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    c.b(fileInputStream);
                    c.b(byteArrayOutputStream);
                    return str3;
                } catch (Exception unused) {
                    fileInputStream2 = fileInputStream;
                    c.b(fileInputStream2);
                    c.b(byteArrayOutputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    c.b(fileInputStream);
                    c.b(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static boolean f(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        a(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream.write(new b().b(str2.getBytes(str3)));
                } else {
                    fileOutputStream.write(str2.getBytes(str3));
                }
                c.b(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                c.b(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                c.b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public File b() {
        return new File(this.f64452a.getApplicationInfo().dataDir);
    }

    public final File c() {
        return new File(b(), ".helios");
    }

    public synchronized C1752a d() {
        if (this.f64453b == null) {
            this.f64453b = new C1752a(".helios", null);
        }
        return this.f64453b;
    }

    /* renamed from: d.b.q.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C1752a {

        /* renamed from: a  reason: collision with root package name */
        public File f64454a;

        /* renamed from: b  reason: collision with root package name */
        public String f64455b;

        /* renamed from: c  reason: collision with root package name */
        public C1752a f64456c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64457d;

        public C1752a(String str, C1752a c1752a) {
            this.f64457d = false;
            this.f64455b = str;
            this.f64456c = c1752a;
            this.f64457d = false;
        }

        public void a() {
            b().mkdirs();
        }

        public File b() {
            File file;
            File file2 = this.f64454a;
            if (file2 != null) {
                return file2;
            }
            if (this.f64456c == null) {
                file = new File(a.this.b(), this.f64455b);
            } else {
                file = new File(this.f64456c.b(), this.f64455b);
            }
            this.f64454a = file;
            return file;
        }

        public String c() {
            return this.f64455b;
        }

        public File d(String str) {
            return new File(this.f64454a, str);
        }

        public C1752a e() {
            return this.f64456c;
        }

        public C1752a f(String str) {
            return new C1752a(str, this);
        }

        public String g(String str, boolean z) {
            return a.e(b(), str, "UTF-8", z);
        }

        public C1752a h(File file) {
            if (!this.f64457d) {
                ArrayList arrayList = new ArrayList();
                C1752a c1752a = this;
                do {
                    arrayList.add(c1752a.c());
                    c1752a = c1752a.e();
                } while (c1752a != null);
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    size--;
                    file = new File(file, (String) arrayList.get(size));
                }
                return new C1752a(file);
            }
            throw new IllegalStateException("isolate session is not support");
        }

        public boolean i(String str, String str2, boolean z) {
            return a.f(b(), str, str2, "UTF-8", z);
        }

        public C1752a(File file) {
            this.f64457d = false;
            this.f64457d = true;
            this.f64454a = file;
            this.f64455b = file.getName();
        }
    }
}
