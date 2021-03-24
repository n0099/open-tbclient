package d.b.j.g;

import android.content.Context;
import d.b.j.d.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f63752a;

    /* renamed from: b  reason: collision with root package name */
    public C1727a f63753b;

    /* renamed from: d.b.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C1727a {

        /* renamed from: a  reason: collision with root package name */
        public File f63754a;

        /* renamed from: b  reason: collision with root package name */
        public String f63755b;

        /* renamed from: c  reason: collision with root package name */
        public C1727a f63756c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63757d;

        public C1727a(File file) {
            this.f63757d = false;
            this.f63757d = true;
            this.f63754a = file;
            this.f63755b = file.getName();
        }

        public C1727a(String str, C1727a c1727a) {
            this.f63757d = false;
            this.f63755b = str;
            this.f63756c = c1727a;
            this.f63757d = false;
        }

        public C1727a a(File file) {
            if (this.f63757d) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C1727a c1727a = this;
            do {
                arrayList.add(c1727a.h());
                c1727a = c1727a.i();
            } while (c1727a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                size--;
                file = new File(file, (String) arrayList.get(size));
            }
            return new C1727a(file);
        }

        public C1727a b(String str) {
            return new C1727a(str, this);
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
            File file = this.f63754a;
            if (file != null) {
                return file;
            }
            File file2 = this.f63756c == null ? new File(a.this.a(), this.f63755b) : new File(this.f63756c.f(), this.f63755b);
            this.f63754a = file2;
            return file2;
        }

        public File g(String str) {
            return new File(this.f63754a, str);
        }

        public String h() {
            return this.f63755b;
        }

        public C1727a i() {
            return this.f63756c;
        }
    }

    public a(Context context) {
        this.f63752a = context;
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
        return new File(this.f63752a.getApplicationInfo().dataDir);
    }

    public synchronized C1727a e() {
        if (this.f63753b == null) {
            this.f63753b = new C1727a(".cesium", null);
        }
        return this.f63753b;
    }

    public final File f() {
        return new File(a(), ".cesium");
    }
}
