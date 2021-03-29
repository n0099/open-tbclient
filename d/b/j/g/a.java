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
    public Context f63753a;

    /* renamed from: b  reason: collision with root package name */
    public C1728a f63754b;

    /* renamed from: d.b.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C1728a {

        /* renamed from: a  reason: collision with root package name */
        public File f63755a;

        /* renamed from: b  reason: collision with root package name */
        public String f63756b;

        /* renamed from: c  reason: collision with root package name */
        public C1728a f63757c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63758d;

        public C1728a(File file) {
            this.f63758d = false;
            this.f63758d = true;
            this.f63755a = file;
            this.f63756b = file.getName();
        }

        public C1728a(String str, C1728a c1728a) {
            this.f63758d = false;
            this.f63756b = str;
            this.f63757c = c1728a;
            this.f63758d = false;
        }

        public C1728a a(File file) {
            if (this.f63758d) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C1728a c1728a = this;
            do {
                arrayList.add(c1728a.h());
                c1728a = c1728a.i();
            } while (c1728a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                size--;
                file = new File(file, (String) arrayList.get(size));
            }
            return new C1728a(file);
        }

        public C1728a b(String str) {
            return new C1728a(str, this);
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
            File file = this.f63755a;
            if (file != null) {
                return file;
            }
            File file2 = this.f63757c == null ? new File(a.this.a(), this.f63756b) : new File(this.f63757c.f(), this.f63756b);
            this.f63755a = file2;
            return file2;
        }

        public File g(String str) {
            return new File(this.f63755a, str);
        }

        public String h() {
            return this.f63756b;
        }

        public C1728a i() {
            return this.f63757c;
        }
    }

    public a(Context context) {
        this.f63753a = context;
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
        return new File(this.f63753a.getApplicationInfo().dataDir);
    }

    public synchronized C1728a e() {
        if (this.f63754b == null) {
            this.f63754b = new C1728a(".cesium", null);
        }
        return this.f63754b;
    }

    public final File f() {
        return new File(a(), ".cesium");
    }
}
