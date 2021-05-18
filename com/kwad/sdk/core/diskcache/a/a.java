package com.kwad.sdk.core.diskcache.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f32130a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream p = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        @Override // java.io.OutputStream
        public void write(int i2) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final File f32132c;

    /* renamed from: d  reason: collision with root package name */
    public final File f32133d;

    /* renamed from: e  reason: collision with root package name */
    public final File f32134e;

    /* renamed from: f  reason: collision with root package name */
    public final File f32135f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32136g;

    /* renamed from: h  reason: collision with root package name */
    public long f32137h;

    /* renamed from: i  reason: collision with root package name */
    public final int f32138i;
    public Writer k;
    public int m;
    public long j = 0;
    public final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    public long n = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadPoolExecutor f32131b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> o = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.k == null) {
                    return null;
                }
                a.this.j();
                if (a.this.h()) {
                    a.this.g();
                    a.this.m = 0;
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C0361a {

        /* renamed from: b  reason: collision with root package name */
        public final b f32141b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f32142c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f32143d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32144e;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0362a extends FilterOutputStream {
            public C0362a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0361a.this.f32143d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0361a.this.f32143d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    C0361a.this.f32143d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    C0361a.this.f32143d = true;
                }
            }
        }

        public C0361a(b bVar) {
            this.f32141b = bVar;
            this.f32142c = bVar.f32149d ? null : new boolean[a.this.f32138i];
        }

        public OutputStream a(int i2) {
            FileOutputStream fileOutputStream;
            C0362a c0362a;
            if (i2 < 0 || i2 >= a.this.f32138i) {
                throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + a.this.f32138i);
            }
            synchronized (a.this) {
                if (this.f32141b.f32150e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f32141b.f32149d) {
                    this.f32142c[i2] = true;
                }
                File b2 = this.f32141b.b(i2);
                try {
                    fileOutputStream = new FileOutputStream(b2);
                } catch (FileNotFoundException unused) {
                    a.this.f32132c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused2) {
                        return a.p;
                    }
                }
                c0362a = new C0362a(fileOutputStream);
            }
            return c0362a;
        }

        public void a() {
            if (this.f32143d) {
                a.this.a(this, false);
                a.this.b(this.f32141b.f32147b);
            } else {
                a.this.a(this, true);
            }
            this.f32144e = true;
        }

        public void b() {
            a.this.a(this, false);
        }
    }

    /* loaded from: classes6.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        public final String f32147b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f32148c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f32149d;

        /* renamed from: e  reason: collision with root package name */
        public C0361a f32150e;

        /* renamed from: f  reason: collision with root package name */
        public long f32151f;

        public b(String str) {
            this.f32147b = str;
            this.f32148c = new long[a.this.f32138i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.f32138i) {
                throw b(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f32148c[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return new File(a.this.f32132c, this.f32147b);
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f32148c) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i2) {
            File file = a.this.f32132c;
            return new File(file, this.f32147b + ".tmp");
        }
    }

    public a(File file, int i2, int i3, long j) {
        this.f32132c = file;
        this.f32136g = i2;
        this.f32133d = new File(file, "journal");
        this.f32134e = new File(file, "journal.tmp");
        this.f32135f = new File(file, "journal.bkp");
        this.f32138i = i3;
        this.f32137h = j;
    }

    private synchronized C0361a a(String str, long j) {
        i();
        d(str);
        b bVar = this.l.get(str);
        if (j == -1 || (bVar != null && bVar.f32151f == j)) {
            if (bVar == null) {
                bVar = new b(str);
                this.l.put(str, bVar);
            } else if (bVar.f32150e != null) {
                return null;
            }
            C0361a c0361a = new C0361a(bVar);
            bVar.f32150e = c0361a;
            Writer writer = this.k;
            writer.write("DIRTY " + str + '\n');
            this.k.flush();
            return c0361a;
        }
        return null;
    }

    public static a a(File file, int i2, int i3, long j) {
        if (j > 0) {
            if (i3 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        a(file2, file3, false);
                    }
                }
                a aVar = new a(file, i2, i3, j);
                if (aVar.f32133d.exists()) {
                    try {
                        aVar.e();
                        aVar.f();
                        return aVar;
                    } catch (IOException e2) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.c();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i2, i3, j);
                aVar2.g();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0361a c0361a, boolean z) {
        b bVar = c0361a.f32141b;
        if (bVar.f32150e != c0361a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f32149d) {
            for (int i2 = 0; i2 < this.f32138i; i2++) {
                if (!c0361a.f32142c[i2]) {
                    c0361a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                } else if (!bVar.b(i2).exists()) {
                    c0361a.b();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.f32138i; i3++) {
            File b2 = bVar.b(i3);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = bVar.a(i3);
                b2.renameTo(a2);
                long j = bVar.f32148c[i3];
                long length = a2.length();
                bVar.f32148c[i3] = length;
                this.j = (this.j - j) + length;
            }
        }
        this.m++;
        bVar.f32150e = null;
        if (bVar.f32149d || z) {
            bVar.f32149d = true;
            this.k.write("CLEAN " + bVar.f32147b + bVar.a() + '\n');
            if (z) {
                long j2 = this.n;
                this.n = 1 + j2;
                bVar.f32151f = j2;
            }
        } else {
            this.l.remove(bVar.f32147b);
            this.k.write("REMOVE " + bVar.f32147b + '\n');
        }
        this.k.flush();
        if (this.j > this.f32137h || h()) {
            this.f32131b.submit(this.o);
        }
    }

    public static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z) {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void c(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i2);
        if (indexOf2 == -1) {
            substring = str.substring(i2);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.l.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i2, indexOf2);
        }
        b bVar = this.l.get(substring);
        if (bVar == null) {
            bVar = new b(substring);
            this.l.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.f32149d = true;
            bVar.f32150e = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.f32150e = new C0361a(bVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void d(String str) {
        if (f32130a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void e() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.f32133d), c.f32158a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f32136g).equals(a4) || !Integer.toString(this.f32138i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    c(bVar.a());
                    i2++;
                } catch (EOFException unused) {
                    this.m = i2 - this.l.size();
                    if (bVar.b()) {
                        g();
                    } else {
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f32133d, true), c.f32158a));
                    }
                    c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            c.a(bVar);
            throw th;
        }
    }

    private void f() {
        a(this.f32134e);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.f32150e == null) {
                while (i2 < this.f32138i) {
                    this.j += next.f32148c[i2];
                    i2++;
                }
            } else {
                next.f32150e = null;
                while (i2 < this.f32138i) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        if (this.k != null) {
            this.k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f32134e), c.f32158a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f32136g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f32138i));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.l.values()) {
            bufferedWriter.write(bVar.f32150e != null ? "DIRTY " + bVar.f32147b + '\n' : "CLEAN " + bVar.f32147b + bVar.a() + '\n');
        }
        bufferedWriter.close();
        if (this.f32133d.exists()) {
            a(this.f32133d, this.f32135f, true);
        }
        a(this.f32134e, this.f32133d, false);
        this.f32135f.delete();
        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f32133d, true), c.f32158a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int i2 = this.m;
        return i2 >= 2000 && i2 >= this.l.size();
    }

    private void i() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        while (this.j > this.f32137h) {
            b(this.l.entrySet().iterator().next().getKey());
        }
    }

    public C0361a a(String str) {
        return a(str, -1L);
    }

    public File a() {
        return this.f32132c;
    }

    public synchronized void b() {
        i();
        j();
        this.k.flush();
    }

    public synchronized boolean b(String str) {
        i();
        d(str);
        b bVar = this.l.get(str);
        if (bVar != null && bVar.f32150e == null) {
            for (int i2 = 0; i2 < this.f32138i; i2++) {
                File a2 = bVar.a(i2);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.j -= bVar.f32148c[i2];
                bVar.f32148c[i2] = 0;
            }
            this.m++;
            this.k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.l.remove(str);
            if (h()) {
                this.f32131b.submit(this.o);
            }
            return true;
        }
        return false;
    }

    public void c() {
        close();
        c.a(this.f32132c);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.k == null) {
            return;
        }
        Iterator it = new ArrayList(this.l.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f32150e != null) {
                bVar.f32150e.b();
            }
        }
        j();
        this.k.close();
        this.k = null;
    }
}
