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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public final class a implements Closeable {
    public static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream p = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        @Override // java.io.OutputStream
        public void write(int i2) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final File f54236c;

    /* renamed from: d  reason: collision with root package name */
    public final File f54237d;

    /* renamed from: e  reason: collision with root package name */
    public final File f54238e;

    /* renamed from: f  reason: collision with root package name */
    public final File f54239f;

    /* renamed from: g  reason: collision with root package name */
    public final int f54240g;

    /* renamed from: h  reason: collision with root package name */
    public long f54241h;

    /* renamed from: i  reason: collision with root package name */
    public final int f54242i;
    public Writer k;
    public int m;

    /* renamed from: j  reason: collision with root package name */
    public long f54243j = 0;
    public final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    public long n = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f54235b = com.kwad.sdk.core.i.b.a();
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
    public final class C2093a {

        /* renamed from: b  reason: collision with root package name */
        public final b f54244b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f54245c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f54246d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54247e;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C2094a extends FilterOutputStream {
            public C2094a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C2093a.this.f54246d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C2093a.this.f54246d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    C2093a.this.f54246d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    C2093a.this.f54246d = true;
                }
            }
        }

        public C2093a(b bVar) {
            this.f54244b = bVar;
            this.f54245c = bVar.f54250d ? null : new boolean[a.this.f54242i];
        }

        public OutputStream a(int i2) {
            FileOutputStream fileOutputStream;
            C2094a c2094a;
            if (i2 < 0 || i2 >= a.this.f54242i) {
                throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + a.this.f54242i);
            }
            synchronized (a.this) {
                if (this.f54244b.f54251e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f54244b.f54250d) {
                    this.f54245c[i2] = true;
                }
                File b2 = this.f54244b.b(i2);
                try {
                    fileOutputStream = new FileOutputStream(b2);
                } catch (FileNotFoundException unused) {
                    a.this.f54236c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused2) {
                        return a.p;
                    }
                }
                c2094a = new C2094a(fileOutputStream);
            }
            return c2094a;
        }

        public void a() {
            if (this.f54246d) {
                a.this.a(this, false);
                a.this.c(this.f54244b.f54248b);
            } else {
                a.this.a(this, true);
            }
            this.f54247e = true;
        }

        public void b() {
            a.this.a(this, false);
        }
    }

    /* loaded from: classes7.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        public final String f54248b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f54249c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f54250d;

        /* renamed from: e  reason: collision with root package name */
        public C2093a f54251e;

        /* renamed from: f  reason: collision with root package name */
        public long f54252f;

        public b(String str) {
            this.f54248b = str;
            this.f54249c = new long[a.this.f54242i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.f54242i) {
                throw b(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f54249c[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return new File(a.this.f54236c, this.f54248b);
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f54249c) {
                sb.append(WebvttCueParser.CHAR_SPACE);
                sb.append(j2);
            }
            return sb.toString();
        }

        public File b(int i2) {
            File file = a.this.f54236c;
            return new File(file, this.f54248b + ".tmp");
        }
    }

    /* loaded from: classes7.dex */
    public final class c implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        public final String f54253b;

        /* renamed from: c  reason: collision with root package name */
        public final long f54254c;

        /* renamed from: d  reason: collision with root package name */
        public final InputStream[] f54255d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f54256e;

        public c(String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            this.f54253b = str;
            this.f54254c = j2;
            this.f54255d = inputStreamArr;
            this.f54256e = jArr;
        }

        public InputStream a(int i2) {
            return this.f54255d[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f54255d) {
                com.kwad.sdk.core.diskcache.kwai.c.a(inputStream);
            }
        }
    }

    public a(File file, int i2, int i3, long j2) {
        this.f54236c = file;
        this.f54240g = i2;
        this.f54237d = new File(file, "journal");
        this.f54238e = new File(file, "journal.tmp");
        this.f54239f = new File(file, "journal.bkp");
        this.f54242i = i3;
        this.f54241h = j2;
    }

    private synchronized C2093a a(String str, long j2) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (j2 == -1 || (bVar != null && bVar.f54252f == j2)) {
            if (bVar == null) {
                bVar = new b(str);
                this.l.put(str, bVar);
            } else if (bVar.f54251e != null) {
                return null;
            }
            C2093a c2093a = new C2093a(bVar);
            bVar.f54251e = c2093a;
            Writer writer = this.k;
            writer.write("DIRTY " + str + '\n');
            this.k.flush();
            return c2093a;
        }
        return null;
    }

    public static a a(File file, int i2, int i3, long j2) {
        if (j2 > 0) {
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
                a aVar = new a(file, i2, i3, j2);
                if (aVar.f54237d.exists()) {
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
                a aVar2 = new a(file, i2, i3, j2);
                aVar2.g();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C2093a c2093a, boolean z) {
        b bVar = c2093a.f54244b;
        if (bVar.f54251e != c2093a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f54250d) {
            for (int i2 = 0; i2 < this.f54242i; i2++) {
                if (!c2093a.f54245c[i2]) {
                    c2093a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                } else if (!bVar.b(i2).exists()) {
                    c2093a.b();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.f54242i; i3++) {
            File b2 = bVar.b(i3);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = bVar.a(i3);
                b2.renameTo(a2);
                long j2 = bVar.f54249c[i3];
                long length = a2.length();
                bVar.f54249c[i3] = length;
                this.f54243j = (this.f54243j - j2) + length;
            }
        }
        this.m++;
        bVar.f54251e = null;
        if (bVar.f54250d || z) {
            bVar.f54250d = true;
            this.k.write("CLEAN " + bVar.f54248b + bVar.a() + '\n');
            if (z) {
                long j3 = this.n;
                this.n = 1 + j3;
                bVar.f54252f = j3;
            }
        } else {
            this.l.remove(bVar.f54248b);
            this.k.write("REMOVE " + bVar.f54248b + '\n');
        }
        this.k.flush();
        if (this.f54243j > this.f54241h || h()) {
            this.f54235b.submit(this.o);
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
            bVar.f54250d = true;
            bVar.f54251e = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.f54251e = new C2093a(bVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e() {
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.f54237d), com.kwad.sdk.core.diskcache.kwai.c.a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f54240g).equals(a4) || !Integer.toString(this.f54242i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i2 = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i2++;
                } catch (EOFException unused) {
                    this.m = i2 - this.l.size();
                    if (bVar.b()) {
                        g();
                    } else {
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f54237d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
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
        a(this.f54238e);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.f54251e == null) {
                while (i2 < this.f54242i) {
                    this.f54243j += next.f54249c[i2];
                    i2++;
                }
            } else {
                next.f54251e = null;
                while (i2 < this.f54242i) {
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
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f54238e), com.kwad.sdk.core.diskcache.kwai.c.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write("1");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.f54240g));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.f54242i));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(StringUtils.LF);
        for (b bVar : this.l.values()) {
            bufferedWriter.write(bVar.f54251e != null ? "DIRTY " + bVar.f54248b + '\n' : "CLEAN " + bVar.f54248b + bVar.a() + '\n');
        }
        bufferedWriter.close();
        if (this.f54237d.exists()) {
            a(this.f54237d, this.f54239f, true);
        }
        a(this.f54238e, this.f54237d, false);
        this.f54239f.delete();
        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f54237d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
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
        while (this.f54243j > this.f54241h) {
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
        if (bVar.f54250d) {
            InputStream[] inputStreamArr = new InputStream[this.f54242i];
            for (int i2 = 0; i2 < this.f54242i; i2++) {
                try {
                    inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
                } catch (FileNotFoundException unused) {
                    for (int i3 = 0; i3 < this.f54242i && inputStreamArr[i3] != null; i3++) {
                        com.kwad.sdk.core.diskcache.kwai.c.a(inputStreamArr[i3]);
                    }
                    return null;
                }
            }
            this.m++;
            this.k.append((CharSequence) ("READ " + str + '\n'));
            if (h()) {
                this.f54235b.submit(this.o);
            }
            return new c(str, bVar.f54252f, inputStreamArr, bVar.f54249c);
        }
        return null;
    }

    public File a() {
        return this.f54236c;
    }

    public C2093a b(String str) {
        return a(str, -1L);
    }

    public synchronized void b() {
        i();
        j();
        this.k.flush();
    }

    public void c() {
        close();
        com.kwad.sdk.core.diskcache.kwai.c.a(this.f54236c);
    }

    public synchronized boolean c(String str) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (bVar != null && bVar.f54251e == null) {
            for (int i2 = 0; i2 < this.f54242i; i2++) {
                File a2 = bVar.a(i2);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.f54243j -= bVar.f54249c[i2];
                bVar.f54249c[i2] = 0;
            }
            this.m++;
            this.k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.l.remove(str);
            if (h()) {
                this.f54235b.submit(this.o);
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
            if (bVar.f54251e != null) {
                bVar.f54251e.b();
            }
        }
        j();
        this.k.close();
        this.k = null;
    }
}
