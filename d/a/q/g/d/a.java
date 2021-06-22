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
    public Context f67917a;

    /* renamed from: b  reason: collision with root package name */
    public C1848a f67918b;

    public a(Context context) {
        this.f67917a = context;
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
        return new File(this.f67917a.getApplicationInfo().dataDir);
    }

    public final File c() {
        return new File(b(), ".helios");
    }

    public synchronized C1848a d() {
        if (this.f67918b == null) {
            this.f67918b = new C1848a(".helios", null);
        }
        return this.f67918b;
    }

    /* renamed from: d.a.q.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C1848a {

        /* renamed from: a  reason: collision with root package name */
        public File f67919a;

        /* renamed from: b  reason: collision with root package name */
        public String f67920b;

        /* renamed from: c  reason: collision with root package name */
        public C1848a f67921c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67922d;

        public C1848a(String str, C1848a c1848a) {
            this.f67922d = false;
            this.f67920b = str;
            this.f67921c = c1848a;
            this.f67922d = false;
        }

        public void a() {
            b().mkdirs();
        }

        public File b() {
            File file;
            File file2 = this.f67919a;
            if (file2 != null) {
                return file2;
            }
            if (this.f67921c == null) {
                file = new File(a.this.b(), this.f67920b);
            } else {
                file = new File(this.f67921c.b(), this.f67920b);
            }
            this.f67919a = file;
            return file;
        }

        public String c() {
            return this.f67920b;
        }

        public File d(String str) {
            return new File(this.f67919a, str);
        }

        public C1848a e() {
            return this.f67921c;
        }

        public C1848a f(String str) {
            return new C1848a(str, this);
        }

        public String g(String str, boolean z) {
            return a.e(b(), str, "UTF-8", z);
        }

        public C1848a h(File file) {
            if (!this.f67922d) {
                ArrayList arrayList = new ArrayList();
                C1848a c1848a = this;
                do {
                    arrayList.add(c1848a.c());
                    c1848a = c1848a.e();
                } while (c1848a != null);
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    size--;
                    file = new File(file, (String) arrayList.get(size));
                }
                return new C1848a(file);
            }
            throw new IllegalStateException("isolate session is not support");
        }

        public boolean i(String str, String str2, boolean z) {
            return a.f(b(), str, str2, "UTF-8", z);
        }

        public C1848a(File file) {
            this.f67922d = false;
            this.f67922d = true;
            this.f67919a = file;
            this.f67920b = file.getName();
        }
    }
}
