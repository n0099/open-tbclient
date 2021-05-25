package d.a.j.g;

import android.content.Context;
import d.a.j.d.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f40217a;

    /* renamed from: b  reason: collision with root package name */
    public C0548a f40218b;

    /* renamed from: d.a.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0548a {

        /* renamed from: a  reason: collision with root package name */
        public File f40219a;

        /* renamed from: b  reason: collision with root package name */
        public String f40220b;

        /* renamed from: c  reason: collision with root package name */
        public C0548a f40221c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40222d;

        public C0548a(File file) {
            this.f40222d = false;
            this.f40222d = true;
            this.f40219a = file;
            this.f40220b = file.getName();
        }

        public C0548a(String str, C0548a c0548a) {
            this.f40222d = false;
            this.f40220b = str;
            this.f40221c = c0548a;
            this.f40222d = false;
        }

        public C0548a a(File file) {
            if (this.f40222d) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0548a c0548a = this;
            do {
                arrayList.add(c0548a.h());
                c0548a = c0548a.i();
            } while (c0548a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                size--;
                file = new File(file, (String) arrayList.get(size));
            }
            return new C0548a(file);
        }

        public C0548a b(String str) {
            return new C0548a(str, this);
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
            File file = this.f40219a;
            if (file != null) {
                return file;
            }
            File file2 = this.f40221c == null ? new File(a.this.a(), this.f40220b) : new File(this.f40221c.f(), this.f40220b);
            this.f40219a = file2;
            return file2;
        }

        public File g(String str) {
            return new File(this.f40219a, str);
        }

        public String h() {
            return this.f40220b;
        }

        public C0548a i() {
            return this.f40221c;
        }
    }

    public a(Context context) {
        this.f40217a = context;
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
        return new File(this.f40217a.getApplicationInfo().dataDir);
    }

    public synchronized C0548a e() {
        if (this.f40218b == null) {
            this.f40218b = new C0548a(".cesium", null);
        }
        return this.f40218b;
    }

    public final File f() {
        return new File(a(), ".cesium");
    }
}
