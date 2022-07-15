package com.kwad.sdk.core.diskcache.kwai;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kwad.sdk.utils.o;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class a implements Closeable {
    public static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final OutputStream r = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    public final File c;
    public final File d;
    public final File e;
    public final File f;
    public final int g;
    public long h;
    public int i;
    public final int j;
    public Writer m;
    public int o;
    public long k = 0;
    public int l = 0;
    public final LinkedHashMap<String, b> n = new LinkedHashMap<>(0, 0.75f, true);
    public long p = 0;
    public final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.kwai.a.1
        public final AtomicInteger b = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.b.getAndIncrement());
        }
    });
    public final Callable<Void> q = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.m == null) {
                    return null;
                }
                a.this.l();
                a.this.m();
                if (a.this.j()) {
                    a.this.i();
                    a.this.o = 0;
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C0537a {
        public final b b;
        public final boolean[] c;
        public boolean d;
        public boolean e;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0538a extends FilterOutputStream {
            public C0538a(OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0538a(C0537a c0537a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0537a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0537a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0537a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0537a.this.d = true;
                }
            }
        }

        public C0537a(b bVar) {
            this.b = bVar;
            this.c = bVar.d ? null : new boolean[a.this.j];
        }

        public /* synthetic */ C0537a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        public final OutputStream a(int i) {
            FileOutputStream fileOutputStream;
            C0538a c0538a;
            synchronized (a.this) {
                if (this.b.e != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.d) {
                    this.c[0] = true;
                }
                File b = this.b.b(0);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException unused) {
                    a.this.c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException unused2) {
                        return a.r;
                    }
                }
                c0538a = new C0538a(this, fileOutputStream, (byte) 0);
            }
            return c0538a;
        }

        public final void a() {
            if (this.d) {
                a.this.a(this, false);
                a.this.c(this.b.b);
            } else {
                a.this.a(this, true);
            }
            this.e = true;
        }

        public final void b() {
            a.this.a(this, false);
        }
    }

    /* loaded from: classes5.dex */
    public final class b {
        public final String b;
        public final long[] c;
        public boolean d;
        public C0537a e;
        public long f;

        public b(String str) {
            this.b = str;
            this.c = new long[a.this.j];
        }

        public /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.j) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        public static IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i) {
            File file = a.this.c;
            return new File(file, this.b + i);
        }

        public final String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.c) {
                sb.append(WebvttCueParser.CHAR_SPACE);
                sb.append(j);
            }
            return sb.toString();
        }

        public final File b(int i) {
            File file = a.this.c;
            return new File(file, this.b + i + ".tmp");
        }
    }

    /* loaded from: classes5.dex */
    public final class c implements Closeable {
        public final String b;
        public final long c;
        public File[] d;
        public final InputStream[] e;
        public final long[] f;

        public c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = fileArr;
            this.e = inputStreamArr;
            this.f = jArr;
        }

        public /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        public final File a(int i) {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.e) {
                com.kwad.sdk.crash.utils.b.a(inputStream);
            }
        }
    }

    public a(File file, int i, int i2, long j, int i3) {
        this.c = file;
        this.g = i;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.j = i2;
        this.h = j;
        this.i = i3;
    }

    private synchronized C0537a a(String str, long j) {
        k();
        e(str);
        b bVar = this.n.get(str);
        if (bVar == null) {
            bVar = new b(this, str, (byte) 0);
            this.n.put(str, bVar);
        } else if (bVar.e != null) {
            return null;
        }
        C0537a c0537a = new C0537a(this, bVar, (byte) 0);
        bVar.e = c0537a;
        Writer writer = this.m;
        writer.write("DIRTY " + str + '\n');
        this.m.flush();
        return c0537a;
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, i, 1, j, Integer.MAX_VALUE);
    }

    public static a a(File file, int i, int i2, long j, int i3) {
        if (j > 0) {
            if (i3 > 0) {
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
                    a aVar = new a(file, i, i2, j, i3);
                    if (aVar.d.exists()) {
                        try {
                            aVar.g();
                            aVar.h();
                            aVar.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.d, true), com.kwad.sdk.crash.utils.a.a));
                            return aVar;
                        } catch (IOException e) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                            aVar.e();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i, i2, j, i3);
                    aVar2.i();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0537a c0537a, boolean z) {
        b bVar = c0537a.b;
        if (bVar.e != c0537a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.d) {
            for (int i = 0; i < this.j; i++) {
                if (!c0537a.c[i]) {
                    c0537a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!bVar.b(i).exists()) {
                    c0537a.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.j; i2++) {
            File b2 = bVar.b(i2);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = bVar.a(i2);
                b2.renameTo(a2);
                long j = bVar.c[i2];
                long length = a2.length();
                bVar.c[i2] = length;
                this.k = (this.k - j) + length;
                this.l++;
            }
        }
        this.o++;
        bVar.e = null;
        if (bVar.d || z) {
            bVar.d = true;
            this.m.write("CLEAN " + bVar.b + bVar.a() + '\n');
            if (z) {
                long j2 = this.p;
                this.p = 1 + j2;
                bVar.f = j2;
            }
        } else {
            this.n.remove(bVar.b);
            this.m.write("REMOVE " + bVar.b + '\n');
        }
        this.m.flush();
        if (this.k > this.h || this.l > this.i || j()) {
            this.b.submit(this.q);
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

    private void d(String str) {
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
                this.n.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.n.get(substring);
        if (bVar == null) {
            bVar = new b(this, substring, (byte) 0);
            this.n.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.d = true;
            bVar.e = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.e = new C0537a(this, bVar, (byte) 0);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public static void e(String str) {
        if (a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private void g() {
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.d), com.kwad.sdk.crash.utils.a.a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.g).equals(a4) || !Integer.toString(this.j).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.o = i - this.n.size();
                    com.kwad.sdk.crash.utils.b.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.a(bVar);
            throw th;
        }
    }

    private void h() {
        a(this.e);
        Iterator<b> it = this.n.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.e == null) {
                while (i < this.j) {
                    this.k += next.c[i];
                    this.l++;
                    i++;
                }
            } else {
                next.e = null;
                while (i < this.j) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (this.m != null) {
            com.kwad.sdk.crash.utils.b.a(this.m);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), com.kwad.sdk.crash.utils.a.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.j));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.n.values()) {
            bufferedWriter.write(bVar.e != null ? "DIRTY " + bVar.b + '\n' : "CLEAN " + bVar.b + bVar.a() + '\n');
        }
        com.kwad.sdk.crash.utils.b.a(bufferedWriter);
        if (this.d.exists()) {
            a(this.d, this.f, true);
        }
        a(this.e, this.d, false);
        this.f.delete();
        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), com.kwad.sdk.crash.utils.a.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        int i = this.o;
        return i >= 2000 && i >= this.n.size();
    }

    private void k() {
        if (this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        while (this.k > this.h) {
            c(this.n.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        while (this.l > this.i) {
            c(this.n.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized c a(String str) {
        k();
        e(str);
        b bVar = this.n.get(str);
        if (bVar == null) {
            return null;
        }
        if (bVar.d) {
            File[] fileArr = new File[this.j];
            InputStream[] inputStreamArr = new InputStream[this.j];
            for (int i = 0; i < this.j; i++) {
                try {
                    File a2 = bVar.a(i);
                    fileArr[i] = a2;
                    inputStreamArr[i] = new FileInputStream(a2);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.j && inputStreamArr[i2] != null; i2++) {
                        com.kwad.sdk.crash.utils.b.a(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.o++;
            this.m.append((CharSequence) ("READ " + str + '\n'));
            if (j()) {
                this.b.submit(this.q);
            }
            return new c(this, str, bVar.f, fileArr, inputStreamArr, bVar.c, (byte) 0);
        }
        return null;
    }

    public final File a() {
        return this.c;
    }

    public final synchronized long b() {
        return this.h;
    }

    public final C0537a b(String str) {
        return a(str, -1L);
    }

    public final synchronized int c() {
        return this.i;
    }

    public final synchronized boolean c(String str) {
        k();
        e(str);
        b bVar = this.n.get(str);
        if (bVar != null && bVar.e == null) {
            for (int i = 0; i < this.j; i++) {
                File a2 = bVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.k -= bVar.c[i];
                this.l--;
                bVar.c[i] = 0;
            }
            this.o++;
            this.m.append((CharSequence) ("REMOVE " + str + '\n'));
            this.n.remove(str);
            if (j()) {
                this.b.submit(this.q);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.m == null) {
            return;
        }
        Iterator it = new ArrayList(this.n.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.e != null) {
                bVar.e.b();
            }
        }
        l();
        m();
        com.kwad.sdk.crash.utils.b.a(this.m);
        this.m = null;
    }

    public final synchronized void d() {
        k();
        l();
        m();
        this.m.flush();
    }

    public final void e() {
        close();
        o.k(this.c);
    }
}
