package d.b.j.g;

import android.content.Context;
import d.b.j.d.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f64453a;

    /* renamed from: b  reason: collision with root package name */
    public C1740a f64454b;

    /* renamed from: d.b.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C1740a {

        /* renamed from: a  reason: collision with root package name */
        public File f64455a;

        /* renamed from: b  reason: collision with root package name */
        public String f64456b;

        /* renamed from: c  reason: collision with root package name */
        public C1740a f64457c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64458d;

        public C1740a(File file) {
            this.f64458d = false;
            this.f64458d = true;
            this.f64455a = file;
            this.f64456b = file.getName();
        }

        public C1740a(String str, C1740a c1740a) {
            this.f64458d = false;
            this.f64456b = str;
            this.f64457c = c1740a;
            this.f64458d = false;
        }

        public C1740a a(File file) {
            if (this.f64458d) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C1740a c1740a = this;
            do {
                arrayList.add(c1740a.h());
                c1740a = c1740a.i();
            } while (c1740a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                size--;
                file = new File(file, (String) arrayList.get(size));
            }
            return new C1740a(file);
        }

        public C1740a b(String str) {
            return new C1740a(str, this);
        }

        public String c(String str, boolean z) {
            return a.b(f(), str, "UTF-8", z);
        }

        public void d() {
            f().mkdirs();
        }

        public boolean e(String str, String str2, boolean z) {
            return a.d(f(), str, str2, "UTF-8", z);
        }

        public File f() {
            File file = this.f64455a;
            if (file != null) {
                return file;
            }
            File file2 = this.f64457c == null ? new File(a.this.a(), this.f64456b) : new File(this.f64457c.f(), this.f64456b);
            this.f64455a = file2;
            return file2;
        }

        public File g(String str) {
            return new File(this.f64455a, str);
        }

        public String h() {
            return this.f64456b;
        }

        public C1740a i() {
            return this.f64457c;
        }
    }

    public a(Context context) {
        this.f64453a = context;
        f().mkdirs();
    }

    public static String b(File file, String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        c(file);
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
                        byteArray = new c().b(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    d.b.j.i.c.b(fileInputStream);
                    d.b.j.i.c.b(byteArrayOutputStream);
                    return str3;
                } catch (Exception unused) {
                    fileInputStream2 = fileInputStream;
                    d.b.j.i.c.b(fileInputStream2);
                    d.b.j.i.c.b(byteArrayOutputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    d.b.j.i.c.b(fileInputStream);
                    d.b.j.i.c.b(byteArrayOutputStream);
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

    public static void c(File file) {
        file.mkdirs();
    }

    public static boolean d(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        c(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream.write(new c().a(str2.getBytes()));
                } else {
                    fileOutputStream.write(str2.getBytes(str3));
                }
                d.b.j.i.c.b(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                d.b.j.i.c.b(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                d.b.j.i.c.b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public File a() {
        return new File(this.f64453a.getApplicationInfo().dataDir);
    }

    public synchronized C1740a e() {
        if (this.f64454b == null) {
            this.f64454b = new C1740a(".cesium", null);
        }
        return this.f64454b;
    }

    public final File f() {
        return new File(a(), ".cesium");
    }
}
