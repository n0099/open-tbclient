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
    public Context f52648a;

    /* renamed from: b  reason: collision with root package name */
    public C1154a f52649b;

    /* renamed from: d.b.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C1154a {

        /* renamed from: a  reason: collision with root package name */
        public File f52650a;

        /* renamed from: b  reason: collision with root package name */
        public String f52651b;

        /* renamed from: c  reason: collision with root package name */
        public C1154a f52652c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52653d;

        public C1154a(File file) {
            this.f52653d = false;
            this.f52653d = true;
            this.f52650a = file;
            this.f52651b = file.getName();
        }

        public C1154a(String str, C1154a c1154a) {
            this.f52653d = false;
            this.f52651b = str;
            this.f52652c = c1154a;
            this.f52653d = false;
        }

        public C1154a a(File file) {
            if (this.f52653d) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C1154a c1154a = this;
            do {
                arrayList.add(c1154a.h());
                c1154a = c1154a.i();
            } while (c1154a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                size--;
                file = new File(file, (String) arrayList.get(size));
            }
            return new C1154a(file);
        }

        public C1154a b(String str) {
            return new C1154a(str, this);
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
            File file = this.f52650a;
            if (file != null) {
                return file;
            }
            File file2 = this.f52652c == null ? new File(a.this.a(), this.f52651b) : new File(this.f52652c.f(), this.f52651b);
            this.f52650a = file2;
            return file2;
        }

        public File g(String str) {
            return new File(this.f52650a, str);
        }

        public String h() {
            return this.f52651b;
        }

        public C1154a i() {
            return this.f52652c;
        }
    }

    public a(Context context) {
        this.f52648a = context;
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
        return new File(this.f52648a.getApplicationInfo().dataDir);
    }

    public synchronized C1154a e() {
        if (this.f52649b == null) {
            this.f52649b = new C1154a(".cesium", null);
        }
        return this.f52649b;
    }

    public final File f() {
        return new File(a(), ".cesium");
    }
}
