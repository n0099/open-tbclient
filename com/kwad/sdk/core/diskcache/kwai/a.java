package com.kwad.sdk.core.diskcache.kwai;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class a implements Closeable {
    public static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream p = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final File f39371c;

    /* renamed from: d  reason: collision with root package name */
    public final File f39372d;

    /* renamed from: e  reason: collision with root package name */
    public final File f39373e;

    /* renamed from: f  reason: collision with root package name */
    public final File f39374f;

    /* renamed from: g  reason: collision with root package name */
    public final int f39375g;

    /* renamed from: h  reason: collision with root package name */
    public long f39376h;
    public final int i;
    public Writer k;
    public int m;
    public long j = 0;
    public final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    public long n = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f39370b = com.kwad.sdk.core.i.b.a();
    public final Callable<Void> o = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.kwai.a.1
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

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C1954a {

        /* renamed from: b  reason: collision with root package name */
        public final b f39377b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f39378c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f39379d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39380e;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1955a extends FilterOutputStream {
            public C1955a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C1954a.this.f39379d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C1954a.this.f39379d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C1954a.this.f39379d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C1954a.this.f39379d = true;
                }
            }
        }

        public C1954a(b bVar) {
            this.f39377b = bVar;
            this.f39378c = bVar.f39383d ? null : new boolean[a.this.i];
        }

        public OutputStream a(int i) {
            FileOutputStream fileOutputStream;
            C1955a c1955a;
            if (i < 0 || i >= a.this.i) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.i);
            }
            synchronized (a.this) {
                if (this.f39377b.f39384e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f39377b.f39383d) {
                    this.f39378c[i] = true;
                }
                File b2 = this.f39377b.b(i);
                try {
                    fileOutputStream = new FileOutputStream(b2);
                } catch (FileNotFoundException unused) {
                    a.this.f39371c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused2) {
                        return a.p;
                    }
                }
                c1955a = new C1955a(fileOutputStream);
            }
            return c1955a;
        }

        public void a() {
            if (this.f39379d) {
                a.this.a(this, false);
                a.this.c(this.f39377b.f39381b);
            } else {
                a.this.a(this, true);
            }
            this.f39380e = true;
        }

        public void b() {
            a.this.a(this, false);
        }
    }

    /* loaded from: classes7.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        public final String f39381b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f39382c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f39383d;

        /* renamed from: e  reason: collision with root package name */
        public C1954a f39384e;

        /* renamed from: f  reason: collision with root package name */
        public long f39385f;

        public b(String str) {
            this.f39381b = str;
            this.f39382c = new long[a.this.i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.i) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f39382c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return new File(a.this.f39371c, this.f39381b);
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f39382c) {
                sb.append(WebvttCueParser.CHAR_SPACE);
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            File file = a.this.f39371c;
            return new File(file, this.f39381b + ".tmp");
        }
    }

    /* loaded from: classes7.dex */
    public final class c implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        public final String f39386b;

        /* renamed from: c  reason: collision with root package name */
        public final long f39387c;

        /* renamed from: d  reason: collision with root package name */
        public final InputStream[] f39388d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f39389e;

        public c(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f39386b = str;
            this.f39387c = j;
            this.f39388d = inputStreamArr;
            this.f39389e = jArr;
        }

        public InputStream a(int i) {
            return this.f39388d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f39388d) {
                com.kwad.sdk.core.diskcache.kwai.c.a(inputStream);
            }
        }
    }

    public a(File file, int i, int i2, long j) {
        this.f39371c = file;
        this.f39375g = i;
        this.f39372d = new File(file, "journal");
        this.f39373e = new File(file, "journal.tmp");
        this.f39374f = new File(file, "journal.bkp");
        this.i = i2;
        this.f39376h = j;
    }

    private synchronized C1954a a(String str, long j) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (j == -1 || (bVar != null && bVar.f39385f == j)) {
            if (bVar == null) {
                bVar = new b(str);
                this.l.put(str, bVar);
            } else if (bVar.f39384e != null) {
                return null;
            }
            C1954a c1954a = new C1954a(bVar);
            bVar.f39384e = c1954a;
            Writer writer = this.k;
            writer.write("DIRTY " + str + '\n');
            this.k.flush();
            return c1954a;
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
                if (aVar.f39372d.exists()) {
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
    public synchronized void a(C1954a c1954a, boolean z) {
        b bVar = c1954a.f39377b;
        if (bVar.f39384e != c1954a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f39383d) {
            for (int i = 0; i < this.i; i++) {
                if (!c1954a.f39378c[i]) {
                    c1954a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!bVar.b(i).exists()) {
                    c1954a.b();
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
                long j = bVar.f39382c[i2];
                long length = a2.length();
                bVar.f39382c[i2] = length;
                this.j = (this.j - j) + length;
            }
        }
        this.m++;
        bVar.f39384e = null;
        if (bVar.f39383d || z) {
            bVar.f39383d = true;
            this.k.write("CLEAN " + bVar.f39381b + bVar.a() + '\n');
            if (z) {
                long j2 = this.n;
                this.n = 1 + j2;
                bVar.f39385f = j2;
            }
        } else {
            this.l.remove(bVar.f39381b);
            this.k.write("REMOVE " + bVar.f39381b + '\n');
        }
        this.k.flush();
        if (this.j > this.f39376h || h()) {
            this.f39370b.submit(this.o);
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
            bVar.f39383d = true;
            bVar.f39384e = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.f39384e = new C1954a(bVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e() {
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.f39372d), com.kwad.sdk.core.diskcache.kwai.c.a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f39375g).equals(a4) || !Integer.toString(this.i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.m = i - this.l.size();
                    if (bVar.b()) {
                        g();
                    } else {
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f39372d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
                    }
                    com.kwad.sdk.core.diskcache.kwai.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.diskcache.kwai.c.a(bVar);
            throw th;
        }
    }

    private void e(String str) {
        if (a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void f() {
        a(this.f39373e);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.f39384e == null) {
                while (i < this.i) {
                    this.j += next.f39382c[i];
                    i++;
                }
            } else {
                next.f39384e = null;
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
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f39373e), com.kwad.sdk.core.diskcache.kwai.c.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f39375g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.i));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.l.values()) {
            bufferedWriter.write(bVar.f39384e != null ? "DIRTY " + bVar.f39381b + '\n' : "CLEAN " + bVar.f39381b + bVar.a() + '\n');
        }
        bufferedWriter.close();
        if (this.f39372d.exists()) {
            a(this.f39372d, this.f39374f, true);
        }
        a(this.f39373e, this.f39372d, false);
        this.f39374f.delete();
        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f39372d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
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
        while (this.j > this.f39376h) {
            c(this.l.entrySet().iterator().next().getKey());
        }
    }

    public synchronized c a(String str) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (bVar == null) {
            return null;
        }
        if (bVar.f39383d) {
            InputStream[] inputStreamArr = new InputStream[this.i];
            for (int i = 0; i < this.i; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(bVar.a(i));
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.i && inputStreamArr[i2] != null; i2++) {
                        com.kwad.sdk.core.diskcache.kwai.c.a(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.m++;
            this.k.append((CharSequence) ("READ " + str + '\n'));
            if (h()) {
                this.f39370b.submit(this.o);
            }
            return new c(str, bVar.f39385f, inputStreamArr, bVar.f39382c);
        }
        return null;
    }

    public File a() {
        return this.f39371c;
    }

    public C1954a b(String str) {
        return a(str, -1L);
    }

    public synchronized void b() {
        i();
        j();
        this.k.flush();
    }

    public void c() {
        close();
        com.kwad.sdk.core.diskcache.kwai.c.a(this.f39371c);
    }

    public synchronized boolean c(String str) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (bVar != null && bVar.f39384e == null) {
            for (int i = 0; i < this.i; i++) {
                File a2 = bVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.j -= bVar.f39382c[i];
                bVar.f39382c[i] = 0;
            }
            this.m++;
            this.k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.l.remove(str);
            if (h()) {
                this.f39370b.submit(this.o);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.k == null) {
            return;
        }
        Iterator it = new ArrayList(this.l.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f39384e != null) {
                bVar.f39384e.b();
            }
        }
        j();
        this.k.close();
        this.k = null;
    }
}
