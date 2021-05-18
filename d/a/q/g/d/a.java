package d.a.q.g.d;

import android.content.Context;
import d.a.q.g.b.b;
import d.a.q.g.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f64367a;

    /* renamed from: b  reason: collision with root package name */
    public C1785a f64368b;

    public a(Context context) {
        this.f64367a = context;
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
        return new File(this.f64367a.getApplicationInfo().dataDir);
    }

    public final File c() {
        return new File(b(), ".helios");
    }

    public synchronized C1785a d() {
        if (this.f64368b == null) {
            this.f64368b = new C1785a(".helios", null);
        }
        return this.f64368b;
    }

    /* renamed from: d.a.q.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C1785a {

        /* renamed from: a  reason: collision with root package name */
        public File f64369a;

        /* renamed from: b  reason: collision with root package name */
        public String f64370b;

        /* renamed from: c  reason: collision with root package name */
        public C1785a f64371c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64372d;

        public C1785a(String str, C1785a c1785a) {
            this.f64372d = false;
            this.f64370b = str;
            this.f64371c = c1785a;
            this.f64372d = false;
        }

        public void a() {
            b().mkdirs();
        }

        public File b() {
            File file;
            File file2 = this.f64369a;
            if (file2 != null) {
                return file2;
            }
            if (this.f64371c == null) {
                file = new File(a.this.b(), this.f64370b);
            } else {
                file = new File(this.f64371c.b(), this.f64370b);
            }
            this.f64369a = file;
            return file;
        }

        public String c() {
            return this.f64370b;
        }

        public File d(String str) {
            return new File(this.f64369a, str);
        }

        public C1785a e() {
            return this.f64371c;
        }

        public C1785a f(String str) {
            return new C1785a(str, this);
        }

        public String g(String str, boolean z) {
            return a.e(b(), str, "UTF-8", z);
        }

        public C1785a h(File file) {
            if (!this.f64372d) {
                ArrayList arrayList = new ArrayList();
                C1785a c1785a = this;
                do {
                    arrayList.add(c1785a.c());
                    c1785a = c1785a.e();
                } while (c1785a != null);
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    size--;
                    file = new File(file, (String) arrayList.get(size));
                }
                return new C1785a(file);
            }
            throw new IllegalStateException("isolate session is not support");
        }

        public boolean i(String str, String str2, boolean z) {
            return a.f(b(), str, str2, "UTF-8", z);
        }

        public C1785a(File file) {
            this.f64372d = false;
            this.f64372d = true;
            this.f64369a = file;
            this.f64370b = file.getName();
        }
    }
}
