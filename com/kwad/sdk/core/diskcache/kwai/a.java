package com.kwad.sdk.core.diskcache.kwai;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
/* loaded from: classes3.dex */
public final class a implements Closeable {
    public static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream p = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        @Override // java.io.OutputStream
        public void write(int i2) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final File f57865c;

    /* renamed from: d  reason: collision with root package name */
    public final File f57866d;

    /* renamed from: e  reason: collision with root package name */
    public final File f57867e;

    /* renamed from: f  reason: collision with root package name */
    public final File f57868f;

    /* renamed from: g  reason: collision with root package name */
    public final int f57869g;

    /* renamed from: h  reason: collision with root package name */
    public long f57870h;

    /* renamed from: i  reason: collision with root package name */
    public final int f57871i;

    /* renamed from: k  reason: collision with root package name */
    public Writer f57873k;
    public int m;

    /* renamed from: j  reason: collision with root package name */
    public long f57872j = 0;
    public final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    public long n = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f57864b = com.kwad.sdk.core.i.b.a();
    public final Callable<Void> o = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.kwai.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.f57873k == null) {
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
    /* loaded from: classes3.dex */
    public final class C2081a {

        /* renamed from: b  reason: collision with root package name */
        public final b f57874b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f57875c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57876d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f57877e;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C2082a extends FilterOutputStream {
            public C2082a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C2081a.this.f57876d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C2081a.this.f57876d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    C2081a.this.f57876d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    C2081a.this.f57876d = true;
                }
            }
        }

        public C2081a(b bVar) {
            this.f57874b = bVar;
            this.f57875c = bVar.f57880d ? null : new boolean[a.this.f57871i];
        }

        public OutputStream a(int i2) {
            FileOutputStream fileOutputStream;
            C2082a c2082a;
            if (i2 < 0 || i2 >= a.this.f57871i) {
                throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + a.this.f57871i);
            }
            synchronized (a.this) {
                if (this.f57874b.f57881e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f57874b.f57880d) {
                    this.f57875c[i2] = true;
                }
                File b2 = this.f57874b.b(i2);
                try {
                    fileOutputStream = new FileOutputStream(b2);
                } catch (FileNotFoundException unused) {
                    a.this.f57865c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused2) {
                        return a.p;
                    }
                }
                c2082a = new C2082a(fileOutputStream);
            }
            return c2082a;
        }

        public void a() {
            if (this.f57876d) {
                a.this.a(this, false);
                a.this.c(this.f57874b.f57878b);
            } else {
                a.this.a(this, true);
            }
            this.f57877e = true;
        }

        public void b() {
            a.this.a(this, false);
        }
    }

    /* loaded from: classes3.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        public final String f57878b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f57879c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57880d;

        /* renamed from: e  reason: collision with root package name */
        public C2081a f57881e;

        /* renamed from: f  reason: collision with root package name */
        public long f57882f;

        public b(String str) {
            this.f57878b = str;
            this.f57879c = new long[a.this.f57871i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.f57871i) {
                throw b(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f57879c[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return new File(a.this.f57865c, this.f57878b);
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f57879c) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public File b(int i2) {
            File file = a.this.f57865c;
            return new File(file, this.f57878b + ".tmp");
        }
    }

    /* loaded from: classes3.dex */
    public final class c implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        public final String f57883b;

        /* renamed from: c  reason: collision with root package name */
        public final long f57884c;

        /* renamed from: d  reason: collision with root package name */
        public final InputStream[] f57885d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f57886e;

        public c(String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            this.f57883b = str;
            this.f57884c = j2;
            this.f57885d = inputStreamArr;
            this.f57886e = jArr;
        }

        public InputStream a(int i2) {
            return this.f57885d[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f57885d) {
                com.kwad.sdk.core.diskcache.kwai.c.a(inputStream);
            }
        }
    }

    public a(File file, int i2, int i3, long j2) {
        this.f57865c = file;
        this.f57869g = i2;
        this.f57866d = new File(file, "journal");
        this.f57867e = new File(file, "journal.tmp");
        this.f57868f = new File(file, "journal.bkp");
        this.f57871i = i3;
        this.f57870h = j2;
    }

    private synchronized C2081a a(String str, long j2) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (j2 == -1 || (bVar != null && bVar.f57882f == j2)) {
            if (bVar == null) {
                bVar = new b(str);
                this.l.put(str, bVar);
            } else if (bVar.f57881e != null) {
                return null;
            }
            C2081a c2081a = new C2081a(bVar);
            bVar.f57881e = c2081a;
            Writer writer = this.f57873k;
            writer.write("DIRTY " + str + '\n');
            this.f57873k.flush();
            return c2081a;
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
                if (aVar.f57866d.exists()) {
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
    public synchronized void a(C2081a c2081a, boolean z) {
        b bVar = c2081a.f57874b;
        if (bVar.f57881e != c2081a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f57880d) {
            for (int i2 = 0; i2 < this.f57871i; i2++) {
                if (!c2081a.f57875c[i2]) {
                    c2081a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                } else if (!bVar.b(i2).exists()) {
                    c2081a.b();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.f57871i; i3++) {
            File b2 = bVar.b(i3);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = bVar.a(i3);
                b2.renameTo(a2);
                long j2 = bVar.f57879c[i3];
                long length = a2.length();
                bVar.f57879c[i3] = length;
                this.f57872j = (this.f57872j - j2) + length;
            }
        }
        this.m++;
        bVar.f57881e = null;
        if (bVar.f57880d || z) {
            bVar.f57880d = true;
            this.f57873k.write("CLEAN " + bVar.f57878b + bVar.a() + '\n');
            if (z) {
                long j3 = this.n;
                this.n = 1 + j3;
                bVar.f57882f = j3;
            }
        } else {
            this.l.remove(bVar.f57878b);
            this.f57873k.write("REMOVE " + bVar.f57878b + '\n');
        }
        this.f57873k.flush();
        if (this.f57872j > this.f57870h || h()) {
            this.f57864b.submit(this.o);
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
            bVar.f57880d = true;
            bVar.f57881e = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.f57881e = new C2081a(bVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e() {
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.f57866d), com.kwad.sdk.core.diskcache.kwai.c.a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f57869g).equals(a4) || !Integer.toString(this.f57871i).equals(a5) || !"".equals(a6)) {
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
                        this.f57873k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57866d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
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
        a(this.f57867e);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.f57881e == null) {
                while (i2 < this.f57871i) {
                    this.f57872j += next.f57879c[i2];
                    i2++;
                }
            } else {
                next.f57881e = null;
                while (i2 < this.f57871i) {
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
        if (this.f57873k != null) {
            this.f57873k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57867e), com.kwad.sdk.core.diskcache.kwai.c.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write("1");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.f57869g));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.f57871i));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(StringUtils.LF);
        for (b bVar : this.l.values()) {
            bufferedWriter.write(bVar.f57881e != null ? "DIRTY " + bVar.f57878b + '\n' : "CLEAN " + bVar.f57878b + bVar.a() + '\n');
        }
        bufferedWriter.close();
        if (this.f57866d.exists()) {
            a(this.f57866d, this.f57868f, true);
        }
        a(this.f57867e, this.f57866d, false);
        this.f57868f.delete();
        this.f57873k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57866d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int i2 = this.m;
        return i2 >= 2000 && i2 >= this.l.size();
    }

    private void i() {
        if (this.f57873k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        while (this.f57872j > this.f57870h) {
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
        if (bVar.f57880d) {
            InputStream[] inputStreamArr = new InputStream[this.f57871i];
            for (int i2 = 0; i2 < this.f57871i; i2++) {
                try {
                    inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
                } catch (FileNotFoundException unused) {
                    for (int i3 = 0; i3 < this.f57871i && inputStreamArr[i3] != null; i3++) {
                        com.kwad.sdk.core.diskcache.kwai.c.a(inputStreamArr[i3]);
                    }
                    return null;
                }
            }
            this.m++;
            this.f57873k.append((CharSequence) ("READ " + str + '\n'));
            if (h()) {
                this.f57864b.submit(this.o);
            }
            return new c(str, bVar.f57882f, inputStreamArr, bVar.f57879c);
        }
        return null;
    }

    public File a() {
        return this.f57865c;
    }

    public C2081a b(String str) {
        return a(str, -1L);
    }

    public synchronized void b() {
        i();
        j();
        this.f57873k.flush();
    }

    public void c() {
        close();
        com.kwad.sdk.core.diskcache.kwai.c.a(this.f57865c);
    }

    public synchronized boolean c(String str) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (bVar != null && bVar.f57881e == null) {
            for (int i2 = 0; i2 < this.f57871i; i2++) {
                File a2 = bVar.a(i2);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.f57872j -= bVar.f57879c[i2];
                bVar.f57879c[i2] = 0;
            }
            this.m++;
            this.f57873k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.l.remove(str);
            if (h()) {
                this.f57864b.submit(this.o);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f57873k == null) {
            return;
        }
        Iterator it = new ArrayList(this.l.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f57881e != null) {
                bVar.f57881e.b();
            }
        }
        j();
        this.f57873k.close();
        this.f57873k = null;
    }
}
