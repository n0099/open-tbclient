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
/* loaded from: classes4.dex */
public final class a implements Closeable {
    public static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream p = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        @Override // java.io.OutputStream
        public void write(int i2) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final File f55886c;

    /* renamed from: d  reason: collision with root package name */
    public final File f55887d;

    /* renamed from: e  reason: collision with root package name */
    public final File f55888e;

    /* renamed from: f  reason: collision with root package name */
    public final File f55889f;

    /* renamed from: g  reason: collision with root package name */
    public final int f55890g;

    /* renamed from: h  reason: collision with root package name */
    public long f55891h;

    /* renamed from: i  reason: collision with root package name */
    public final int f55892i;
    public Writer k;
    public int m;

    /* renamed from: j  reason: collision with root package name */
    public long f55893j = 0;
    public final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    public long n = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f55885b = com.kwad.sdk.core.i.b.a();
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
    /* loaded from: classes4.dex */
    public final class C2114a {

        /* renamed from: b  reason: collision with root package name */
        public final b f55894b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f55895c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f55896d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f55897e;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C2115a extends FilterOutputStream {
            public C2115a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C2114a.this.f55896d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C2114a.this.f55896d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    C2114a.this.f55896d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    C2114a.this.f55896d = true;
                }
            }
        }

        public C2114a(b bVar) {
            this.f55894b = bVar;
            this.f55895c = bVar.f55900d ? null : new boolean[a.this.f55892i];
        }

        public OutputStream a(int i2) {
            FileOutputStream fileOutputStream;
            C2115a c2115a;
            if (i2 < 0 || i2 >= a.this.f55892i) {
                throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + a.this.f55892i);
            }
            synchronized (a.this) {
                if (this.f55894b.f55901e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f55894b.f55900d) {
                    this.f55895c[i2] = true;
                }
                File b2 = this.f55894b.b(i2);
                try {
                    fileOutputStream = new FileOutputStream(b2);
                } catch (FileNotFoundException unused) {
                    a.this.f55886c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused2) {
                        return a.p;
                    }
                }
                c2115a = new C2115a(fileOutputStream);
            }
            return c2115a;
        }

        public void a() {
            if (this.f55896d) {
                a.this.a(this, false);
                a.this.c(this.f55894b.f55898b);
            } else {
                a.this.a(this, true);
            }
            this.f55897e = true;
        }

        public void b() {
            a.this.a(this, false);
        }
    }

    /* loaded from: classes4.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        public final String f55898b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f55899c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f55900d;

        /* renamed from: e  reason: collision with root package name */
        public C2114a f55901e;

        /* renamed from: f  reason: collision with root package name */
        public long f55902f;

        public b(String str) {
            this.f55898b = str;
            this.f55899c = new long[a.this.f55892i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.f55892i) {
                throw b(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f55899c[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return new File(a.this.f55886c, this.f55898b);
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f55899c) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public File b(int i2) {
            File file = a.this.f55886c;
            return new File(file, this.f55898b + ".tmp");
        }
    }

    /* loaded from: classes4.dex */
    public final class c implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        public final String f55903b;

        /* renamed from: c  reason: collision with root package name */
        public final long f55904c;

        /* renamed from: d  reason: collision with root package name */
        public final InputStream[] f55905d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f55906e;

        public c(String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            this.f55903b = str;
            this.f55904c = j2;
            this.f55905d = inputStreamArr;
            this.f55906e = jArr;
        }

        public InputStream a(int i2) {
            return this.f55905d[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f55905d) {
                com.kwad.sdk.core.diskcache.kwai.c.a(inputStream);
            }
        }
    }

    public a(File file, int i2, int i3, long j2) {
        this.f55886c = file;
        this.f55890g = i2;
        this.f55887d = new File(file, "journal");
        this.f55888e = new File(file, "journal.tmp");
        this.f55889f = new File(file, "journal.bkp");
        this.f55892i = i3;
        this.f55891h = j2;
    }

    private synchronized C2114a a(String str, long j2) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (j2 == -1 || (bVar != null && bVar.f55902f == j2)) {
            if (bVar == null) {
                bVar = new b(str);
                this.l.put(str, bVar);
            } else if (bVar.f55901e != null) {
                return null;
            }
            C2114a c2114a = new C2114a(bVar);
            bVar.f55901e = c2114a;
            Writer writer = this.k;
            writer.write("DIRTY " + str + '\n');
            this.k.flush();
            return c2114a;
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
                if (aVar.f55887d.exists()) {
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
    public synchronized void a(C2114a c2114a, boolean z) {
        b bVar = c2114a.f55894b;
        if (bVar.f55901e != c2114a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f55900d) {
            for (int i2 = 0; i2 < this.f55892i; i2++) {
                if (!c2114a.f55895c[i2]) {
                    c2114a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                } else if (!bVar.b(i2).exists()) {
                    c2114a.b();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.f55892i; i3++) {
            File b2 = bVar.b(i3);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = bVar.a(i3);
                b2.renameTo(a2);
                long j2 = bVar.f55899c[i3];
                long length = a2.length();
                bVar.f55899c[i3] = length;
                this.f55893j = (this.f55893j - j2) + length;
            }
        }
        this.m++;
        bVar.f55901e = null;
        if (bVar.f55900d || z) {
            bVar.f55900d = true;
            this.k.write("CLEAN " + bVar.f55898b + bVar.a() + '\n');
            if (z) {
                long j3 = this.n;
                this.n = 1 + j3;
                bVar.f55902f = j3;
            }
        } else {
            this.l.remove(bVar.f55898b);
            this.k.write("REMOVE " + bVar.f55898b + '\n');
        }
        this.k.flush();
        if (this.f55893j > this.f55891h || h()) {
            this.f55885b.submit(this.o);
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
            bVar.f55900d = true;
            bVar.f55901e = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.f55901e = new C2114a(bVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e() {
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.f55887d), com.kwad.sdk.core.diskcache.kwai.c.a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f55890g).equals(a4) || !Integer.toString(this.f55892i).equals(a5) || !"".equals(a6)) {
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
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f55887d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
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
        a(this.f55888e);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.f55901e == null) {
                while (i2 < this.f55892i) {
                    this.f55893j += next.f55899c[i2];
                    i2++;
                }
            } else {
                next.f55901e = null;
                while (i2 < this.f55892i) {
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
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f55888e), com.kwad.sdk.core.diskcache.kwai.c.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write("1");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.f55890g));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.f55892i));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(StringUtils.LF);
        for (b bVar : this.l.values()) {
            bufferedWriter.write(bVar.f55901e != null ? "DIRTY " + bVar.f55898b + '\n' : "CLEAN " + bVar.f55898b + bVar.a() + '\n');
        }
        bufferedWriter.close();
        if (this.f55887d.exists()) {
            a(this.f55887d, this.f55889f, true);
        }
        a(this.f55888e, this.f55887d, false);
        this.f55889f.delete();
        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f55887d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
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
        while (this.f55893j > this.f55891h) {
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
        if (bVar.f55900d) {
            InputStream[] inputStreamArr = new InputStream[this.f55892i];
            for (int i2 = 0; i2 < this.f55892i; i2++) {
                try {
                    inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
                } catch (FileNotFoundException unused) {
                    for (int i3 = 0; i3 < this.f55892i && inputStreamArr[i3] != null; i3++) {
                        com.kwad.sdk.core.diskcache.kwai.c.a(inputStreamArr[i3]);
                    }
                    return null;
                }
            }
            this.m++;
            this.k.append((CharSequence) ("READ " + str + '\n'));
            if (h()) {
                this.f55885b.submit(this.o);
            }
            return new c(str, bVar.f55902f, inputStreamArr, bVar.f55899c);
        }
        return null;
    }

    public File a() {
        return this.f55886c;
    }

    public C2114a b(String str) {
        return a(str, -1L);
    }

    public synchronized void b() {
        i();
        j();
        this.k.flush();
    }

    public void c() {
        close();
        com.kwad.sdk.core.diskcache.kwai.c.a(this.f55886c);
    }

    public synchronized boolean c(String str) {
        i();
        e(str);
        b bVar = this.l.get(str);
        if (bVar != null && bVar.f55901e == null) {
            for (int i2 = 0; i2 < this.f55892i; i2++) {
                File a2 = bVar.a(i2);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.f55893j -= bVar.f55899c[i2];
                bVar.f55899c[i2] = 0;
            }
            this.m++;
            this.k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.l.remove(str);
            if (h()) {
                this.f55885b.submit(this.o);
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
            if (bVar.f55901e != null) {
                bVar.f55901e.b();
            }
        }
        j();
        this.k.close();
        this.k = null;
    }
}
