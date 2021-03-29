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
    public static final Pattern f33476a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream p = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final File f33478c;

    /* renamed from: d  reason: collision with root package name */
    public final File f33479d;

    /* renamed from: e  reason: collision with root package name */
    public final File f33480e;

    /* renamed from: f  reason: collision with root package name */
    public final File f33481f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33482g;

    /* renamed from: h  reason: collision with root package name */
    public long f33483h;
    public final int i;
    public Writer k;
    public int m;
    public long j = 0;
    public final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    public long n = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadPoolExecutor f33477b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
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
    public final class C0377a {

        /* renamed from: b  reason: collision with root package name */
        public final b f33486b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f33487c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f33488d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f33489e;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0378a extends FilterOutputStream {
            public C0378a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0377a.this.f33488d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0377a.this.f33488d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0377a.this.f33488d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0377a.this.f33488d = true;
                }
            }
        }

        public C0377a(b bVar) {
            this.f33486b = bVar;
            this.f33487c = bVar.f33494d ? null : new boolean[a.this.i];
        }

        public OutputStream a(int i) {
            FileOutputStream fileOutputStream;
            C0378a c0378a;
            if (i < 0 || i >= a.this.i) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.i);
            }
            synchronized (a.this) {
                if (this.f33486b.f33495e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f33486b.f33494d) {
                    this.f33487c[i] = true;
                }
                File b2 = this.f33486b.b(i);
                try {
                    fileOutputStream = new FileOutputStream(b2);
                } catch (FileNotFoundException unused) {
                    a.this.f33478c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused2) {
                        return a.p;
                    }
                }
                c0378a = new C0378a(fileOutputStream);
            }
            return c0378a;
        }

        public void a() {
            if (this.f33488d) {
                a.this.a(this, false);
                a.this.b(this.f33486b.f33492b);
            } else {
                a.this.a(this, true);
            }
            this.f33489e = true;
        }

        public void b() {
            a.this.a(this, false);
        }
    }

    /* loaded from: classes6.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        public final String f33492b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f33493c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f33494d;

        /* renamed from: e  reason: collision with root package name */
        public C0377a f33495e;

        /* renamed from: f  reason: collision with root package name */
        public long f33496f;

        public b(String str) {
            this.f33492b = str;
            this.f33493c = new long[a.this.i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.i) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f33493c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return new File(a.this.f33478c, this.f33492b);
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f33493c) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            File file = a.this.f33478c;
            return new File(file, this.f33492b + ".tmp");
        }
    }

    public a(File file, int i, int i2, long j) {
        this.f33478c = file;
        this.f33482g = i;
        this.f33479d = new File(file, "journal");
        this.f33480e = new File(file, "journal.tmp");
        this.f33481f = new File(file, "journal.bkp");
        this.i = i2;
        this.f33483h = j;
    }

    private synchronized C0377a a(String str, long j) {
        i();
        d(str);
        b bVar = this.l.get(str);
        if (j == -1 || (bVar != null && bVar.f33496f == j)) {
            if (bVar == null) {
                bVar = new b(str);
                this.l.put(str, bVar);
            } else if (bVar.f33495e != null) {
                return null;
            }
            C0377a c0377a = new C0377a(bVar);
            bVar.f33495e = c0377a;
            Writer writer = this.k;
            writer.write("DIRTY " + str + '\n');
            this.k.flush();
            return c0377a;
        }
        return null;
    }

    public static a a(File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        a(file2, file3, false);
                    }
                }
                a aVar = new a(file, i, i2, j);
                if (aVar.f33479d.exists()) {
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
                a aVar2 = new a(file, i, i2, j);
                aVar2.g();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0377a c0377a, boolean z) {
        b bVar = c0377a.f33486b;
        if (bVar.f33495e != c0377a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f33494d) {
            for (int i = 0; i < this.i; i++) {
                if (!c0377a.f33487c[i]) {
                    c0377a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!bVar.b(i).exists()) {
                    c0377a.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.i; i2++) {
            File b2 = bVar.b(i2);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = bVar.a(i2);
                b2.renameTo(a2);
                long j = bVar.f33493c[i2];
                long length = a2.length();
                bVar.f33493c[i2] = length;
                this.j = (this.j - j) + length;
            }
        }
        this.m++;
        bVar.f33495e = null;
        if (bVar.f33494d || z) {
            bVar.f33494d = true;
            this.k.write("CLEAN " + bVar.f33492b + bVar.a() + '\n');
            if (z) {
                long j2 = this.n;
                this.n = 1 + j2;
                bVar.f33496f = j2;
            }
        } else {
            this.l.remove(bVar.f33492b);
            this.k.write("REMOVE " + bVar.f33492b + '\n');
        }
        this.k.flush();
        if (this.j > this.f33483h || h()) {
            this.f33477b.submit(this.o);
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
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.l.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.l.get(substring);
        if (bVar == null) {
            bVar = new b(substring);
            this.l.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.f33494d = true;
            bVar.f33495e = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.f33495e = new C0377a(bVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void d(String str) {
        if (f33476a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void e() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.f33479d), c.f33503a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f33482g).equals(a4) || !Integer.toString(this.i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    c(bVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.m = i - this.l.size();
                    if (bVar.b()) {
                        g();
                    } else {
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f33479d, true), c.f33503a));
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
        a(this.f33480e);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.f33495e == null) {
                while (i < this.i) {
                    this.j += next.f33493c[i];
                    i++;
                }
            } else {
                next.f33495e = null;
                while (i < this.i) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
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
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f33480e), c.f33503a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f33482g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.i));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.l.values()) {
            bufferedWriter.write(bVar.f33495e != null ? "DIRTY " + bVar.f33492b + '\n' : "CLEAN " + bVar.f33492b + bVar.a() + '\n');
        }
        bufferedWriter.close();
        if (this.f33479d.exists()) {
            a(this.f33479d, this.f33481f, true);
        }
        a(this.f33480e, this.f33479d, false);
        this.f33481f.delete();
        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f33479d, true), c.f33503a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int i = this.m;
        return i >= 2000 && i >= this.l.size();
    }

    private void i() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        while (this.j > this.f33483h) {
            b(this.l.entrySet().iterator().next().getKey());
        }
    }

    public C0377a a(String str) {
        return a(str, -1L);
    }

    public File a() {
        return this.f33478c;
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
        if (bVar != null && bVar.f33495e == null) {
            for (int i = 0; i < this.i; i++) {
                File a2 = bVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.j -= bVar.f33493c[i];
                bVar.f33493c[i] = 0;
            }
            this.m++;
            this.k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.l.remove(str);
            if (h()) {
                this.f33477b.submit(this.o);
            }
            return true;
        }
        return false;
    }

    public void c() {
        close();
        c.a(this.f33478c);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.k == null) {
            return;
        }
        Iterator it = new ArrayList(this.l.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f33495e != null) {
                bVar.f33495e.b();
            }
        }
        j();
        this.k.close();
        this.k = null;
    }
}
