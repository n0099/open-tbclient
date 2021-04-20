package d.b.p.g.d;

import android.content.Context;
import d.b.p.g.b.b;
import d.b.p.g.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f65147a;

    /* renamed from: b  reason: collision with root package name */
    public C1765a f65148b;

    public a(Context context) {
        this.f65147a = context;
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
        return new File(this.f65147a.getApplicationInfo().dataDir);
    }

    public final File c() {
        return new File(b(), ".helios");
    }

    public synchronized C1765a d() {
        if (this.f65148b == null) {
            this.f65148b = new C1765a(".helios", null);
        }
        return this.f65148b;
    }

    /* renamed from: d.b.p.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C1765a {

        /* renamed from: a  reason: collision with root package name */
        public File f65149a;

        /* renamed from: b  reason: collision with root package name */
        public String f65150b;

        /* renamed from: c  reason: collision with root package name */
        public C1765a f65151c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65152d;

        public C1765a(String str, C1765a c1765a) {
            this.f65152d = false;
            this.f65150b = str;
            this.f65151c = c1765a;
            this.f65152d = false;
        }

        public void a() {
            b().mkdirs();
        }

        public File b() {
            File file;
            File file2 = this.f65149a;
            if (file2 != null) {
                return file2;
            }
            if (this.f65151c == null) {
                file = new File(a.this.b(), this.f65150b);
            } else {
                file = new File(this.f65151c.b(), this.f65150b);
            }
            this.f65149a = file;
            return file;
        }

        public String c() {
            return this.f65150b;
        }

        public File d(String str) {
            return new File(this.f65149a, str);
        }

        public C1765a e() {
            return this.f65151c;
        }

        public C1765a f(String str) {
            return new C1765a(str, this);
        }

        public String g(String str, boolean z) {
            return a.e(b(), str, "UTF-8", z);
        }

        public C1765a h(File file) {
            if (!this.f65152d) {
                ArrayList arrayList = new ArrayList();
                C1765a c1765a = this;
                do {
                    arrayList.add(c1765a.c());
                    c1765a = c1765a.e();
                } while (c1765a != null);
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    size--;
                    file = new File(file, (String) arrayList.get(size));
                }
                return new C1765a(file);
            }
            throw new IllegalStateException("isolate session is not support");
        }

        public boolean i(String str, String str2, boolean z) {
            return a.f(b(), str, str2, "UTF-8", z);
        }

        public C1765a(File file) {
            this.f65152d = false;
            this.f65152d = true;
            this.f65149a = file;
            this.f65150b = file.getName();
        }
    }
}
