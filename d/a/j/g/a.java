package d.a.j.g;

import android.content.Context;
import d.a.j.d.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f44001a;

    /* renamed from: b  reason: collision with root package name */
    public C0607a f44002b;

    /* renamed from: d.a.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0607a {

        /* renamed from: a  reason: collision with root package name */
        public File f44003a;

        /* renamed from: b  reason: collision with root package name */
        public String f44004b;

        /* renamed from: c  reason: collision with root package name */
        public C0607a f44005c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f44006d;

        public C0607a(File file) {
            this.f44006d = false;
            this.f44006d = true;
            this.f44003a = file;
            this.f44004b = file.getName();
        }

        public C0607a(String str, C0607a c0607a) {
            this.f44006d = false;
            this.f44004b = str;
            this.f44005c = c0607a;
            this.f44006d = false;
        }

        public C0607a a(File file) {
            if (this.f44006d) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0607a c0607a = this;
            do {
                arrayList.add(c0607a.h());
                c0607a = c0607a.i();
            } while (c0607a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                size--;
                file = new File(file, (String) arrayList.get(size));
            }
            return new C0607a(file);
        }

        public C0607a b(String str) {
            return new C0607a(str, this);
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
            File file = this.f44003a;
            if (file != null) {
                return file;
            }
            File file2 = this.f44005c == null ? new File(a.this.a(), this.f44004b) : new File(this.f44005c.f(), this.f44004b);
            this.f44003a = file2;
            return file2;
        }

        public File g(String str) {
            return new File(this.f44003a, str);
        }

        public String h() {
            return this.f44004b;
        }

        public C0607a i() {
            return this.f44005c;
        }
    }

    public a(Context context) {
        this.f44001a = context;
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
                    d.a.j.i.c.b(fileInputStream);
                    d.a.j.i.c.b(byteArrayOutputStream);
                    return str3;
                } catch (Exception unused) {
                    fileInputStream2 = fileInputStream;
                    d.a.j.i.c.b(fileInputStream2);
                    d.a.j.i.c.b(byteArrayOutputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    d.a.j.i.c.b(fileInputStream);
                    d.a.j.i.c.b(byteArrayOutputStream);
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
                d.a.j.i.c.b(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                d.a.j.i.c.b(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                d.a.j.i.c.b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public File a() {
        return new File(this.f44001a.getApplicationInfo().dataDir);
    }

    public synchronized C0607a e() {
        if (this.f44002b == null) {
            this.f44002b = new C0607a(".cesium", null);
        }
        return this.f44002b;
    }

    public final File f() {
        return new File(a(), ".cesium");
    }
}
