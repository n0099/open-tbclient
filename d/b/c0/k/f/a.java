package d.b.c0.k.f;

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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
/* loaded from: classes2.dex */
public final class a implements Closeable {
    public static final Pattern s = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream t = new b();

    /* renamed from: e  reason: collision with root package name */
    public final File f42590e;

    /* renamed from: f  reason: collision with root package name */
    public final File f42591f;

    /* renamed from: g  reason: collision with root package name */
    public final File f42592g;

    /* renamed from: h  reason: collision with root package name */
    public final File f42593h;
    public final int i;
    public long j;
    public final int k;
    public Writer m;
    public int o;
    public long l = 0;
    public final LinkedHashMap<String, d> n = new LinkedHashMap<>(0, 0.75f, true);
    public long p = 0;
    public final ThreadPoolExecutor q = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> r = new CallableC0564a();

    /* renamed from: d.b.c0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC0564a implements Callable<Void> {
        public CallableC0564a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.m == null) {
                    return null;
                }
                a.this.L();
                if (a.this.H()) {
                    a.this.M();
                    a.this.o = 0;
                }
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* loaded from: classes2.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public final d f42595a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f42596b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42597c;

        /* renamed from: d.b.c0.k.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0565a extends FilterOutputStream {
            public /* synthetic */ C0565a(c cVar, OutputStream outputStream, CallableC0564a callableC0564a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f42597c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f42597c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    c.this.f42597c = true;
                }
            }

            public C0565a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    c.this.f42597c = true;
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0564a callableC0564a) {
            this(dVar);
        }

        public void c() {
            a.this.u(this, false);
        }

        public OutputStream e(int i) {
            FileOutputStream fileOutputStream;
            C0565a c0565a;
            if (i < 0 || i >= a.this.k) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.k);
            }
            synchronized (a.this) {
                if (this.f42595a.f42603d == this) {
                    if (!this.f42595a.f42602c) {
                        this.f42596b[i] = true;
                    }
                    File n = this.f42595a.n(i);
                    try {
                        fileOutputStream = new FileOutputStream(n);
                    } catch (FileNotFoundException unused) {
                        a.this.f42590e.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(n);
                        } catch (FileNotFoundException unused2) {
                            return a.t;
                        }
                    }
                    c0565a = new C0565a(this, fileOutputStream, null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0565a;
        }

        public void f() {
            if (this.f42597c) {
                a.this.u(this, false);
                a.this.I(this.f42595a.f42600a);
                return;
            }
            a.this.u(this, true);
        }

        public c(d dVar) {
            this.f42595a = dVar;
            this.f42596b = dVar.f42602c ? null : new boolean[a.this.k];
        }
    }

    /* loaded from: classes2.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f42600a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f42601b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42602c;

        /* renamed from: d  reason: collision with root package name */
        public c f42603d;

        /* renamed from: e  reason: collision with root package name */
        public long f42604e;

        public /* synthetic */ d(a aVar, String str, CallableC0564a callableC0564a) {
            this(str);
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f42601b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final IOException d(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void i(String[] strArr) {
            if (strArr.length == a.this.k) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.f42601b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        d(strArr);
                        throw null;
                    }
                }
                return;
            }
            d(strArr);
            throw null;
        }

        public File k(int i) {
            File file = a.this.f42590e;
            return new File(file, this.f42600a + "." + i);
        }

        public File n(int i) {
            File file = a.this.f42590e;
            return new File(file, this.f42600a + "." + i + ".tmp");
        }

        public d(String str) {
            this.f42600a = str;
            this.f42601b = new long[a.this.k];
        }
    }

    /* loaded from: classes2.dex */
    public final class e implements Closeable {

        /* renamed from: e  reason: collision with root package name */
        public final InputStream[] f42606e;

        public /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0564a callableC0564a) {
            this(str, j, inputStreamArr, jArr);
        }

        public InputStream c(int i) {
            return this.f42606e[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f42606e) {
                d.b.c0.k.f.c.a(inputStream);
            }
        }

        public e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f42606e = inputStreamArr;
        }
    }

    public a(File file, int i, int i2, long j) {
        this.f42590e = file;
        this.i = i;
        this.f42591f = new File(file, "journal");
        this.f42592g = new File(file, "journal.tmp");
        this.f42593h = new File(file, "journal.bkp");
        this.k = i2;
        this.j = j;
    }

    public static a q(File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        t(file2, file3, false);
                    }
                }
                a aVar = new a(file, i, i2, j);
                if (aVar.f42591f.exists()) {
                    try {
                        aVar.K();
                        aVar.J();
                        return aVar;
                    } catch (IOException e2) {
                        d.b.c0.n.d.b("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.z();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.M();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void t(File file, File file2, boolean z) {
        if (z) {
            x(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void x(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public c B(String str) {
        return p(str, -1L);
    }

    public synchronized e D(String str) {
        F();
        G(str);
        d dVar = this.n.get(str);
        if (dVar == null) {
            return null;
        }
        if (dVar.f42602c) {
            InputStream[] inputStreamArr = new InputStream[this.k];
            for (int i = 0; i < this.k; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(dVar.k(i));
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.k && inputStreamArr[i2] != null; i2++) {
                        d.b.c0.k.f.c.a(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.o++;
            this.m.append((CharSequence) ("READ " + str + '\n'));
            if (H()) {
                this.q.submit(this.r);
            }
            return new e(this, str, dVar.f42604e, inputStreamArr, dVar.f42601b, null);
        }
        return null;
    }

    public final void E(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
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
            d dVar = this.n.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.n.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f42602c = true;
                dVar.f42603d = null;
                dVar.i(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f42603d = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final void F() {
        if (this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final void G(String str) {
        if (s.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final boolean H() {
        int i = this.o;
        return i >= 2000 && i >= this.n.size();
    }

    public synchronized boolean I(String str) {
        F();
        G(str);
        d dVar = this.n.get(str);
        if (dVar != null && dVar.f42603d == null) {
            for (int i = 0; i < this.k; i++) {
                File k = dVar.k(i);
                if (k.exists() && !k.delete()) {
                    throw new IOException("failed to delete " + k);
                }
                this.l -= dVar.f42601b[i];
                dVar.f42601b[i] = 0;
            }
            this.o++;
            this.m.append((CharSequence) ("REMOVE " + str + '\n'));
            this.n.remove(str);
            if (H()) {
                this.q.submit(this.r);
            }
            return true;
        }
        return false;
    }

    public final void J() {
        x(this.f42592g);
        Iterator<d> it = this.n.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f42603d != null) {
                next.f42603d = null;
                while (i < this.k) {
                    x(next.k(i));
                    x(next.n(i));
                    i++;
                }
                it.remove();
            } else {
                while (i < this.k) {
                    this.l += next.f42601b[i];
                    i++;
                }
            }
        }
    }

    public final void K() {
        d.b.c0.k.f.b bVar = new d.b.c0.k.f.b(new FileInputStream(this.f42591f), d.b.c0.k.f.c.f42613a);
        try {
            String q = bVar.q();
            String q2 = bVar.q();
            String q3 = bVar.q();
            String q4 = bVar.q();
            String q5 = bVar.q();
            if (!"libcore.io.DiskLruCache".equals(q) || !"1".equals(q2) || !Integer.toString(this.i).equals(q3) || !Integer.toString(this.k).equals(q4) || !"".equals(q5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(q);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(q2);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(q4);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(q5);
                sb.append("]");
                throw new IOException(sb.toString());
            }
            int i = 0;
            while (true) {
                try {
                    E(bVar.q());
                    i++;
                } catch (EOFException unused) {
                    this.o = i - this.n.size();
                    if (bVar.n()) {
                        M();
                    } else {
                        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f42591f, true), d.b.c0.k.f.c.f42613a));
                    }
                    d.b.c0.k.f.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            d.b.c0.k.f.c.a(bVar);
            throw th;
        }
    }

    public final void L() {
        while (this.l > this.j) {
            I(this.n.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized void M() {
        Writer writer = this.m;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f42592g), d.b.c0.k.f.c.f42613a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.i));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.k));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.n.values()) {
            if (dVar.f42603d != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("DIRTY ");
                sb.append(dVar.f42600a);
                sb.append('\n');
                bufferedWriter.write(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CLEAN ");
                sb2.append(dVar.f42600a);
                sb2.append(dVar.a());
                sb2.append('\n');
                bufferedWriter.write(sb2.toString());
            }
        }
        bufferedWriter.close();
        if (this.f42591f.exists()) {
            t(this.f42591f, this.f42593h, true);
        }
        t(this.f42592g, this.f42591f, false);
        this.f42593h.delete();
        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f42591f, true), d.b.c0.k.f.c.f42613a));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.m == null) {
            return;
        }
        Iterator it = new ArrayList(this.n.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f42603d != null) {
                dVar.f42603d.c();
            }
        }
        L();
        this.m.close();
        this.m = null;
    }

    public synchronized void flush() {
        F();
        L();
        this.m.flush();
    }

    public final synchronized c p(String str, long j) {
        F();
        G(str);
        d dVar = this.n.get(str);
        if (j == -1 || (dVar != null && dVar.f42604e == j)) {
            if (dVar != null) {
                if (dVar.f42603d != null) {
                    return null;
                }
            } else {
                dVar = new d(this, str, null);
                this.n.put(str, dVar);
            }
            c cVar = new c(this, dVar, null);
            dVar.f42603d = cVar;
            Writer writer = this.m;
            writer.write("DIRTY " + str + '\n');
            this.m.flush();
            return cVar;
        }
        return null;
    }

    public final synchronized void u(c cVar, boolean z) {
        d dVar = cVar.f42595a;
        if (dVar.f42603d == cVar) {
            if (z && !dVar.f42602c) {
                for (int i = 0; i < this.k; i++) {
                    if (cVar.f42596b[i]) {
                        if (!dVar.n(i).exists()) {
                            cVar.c();
                            return;
                        }
                    } else {
                        cVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.k; i2++) {
                File n = dVar.n(i2);
                if (z) {
                    if (n.exists()) {
                        File k = dVar.k(i2);
                        n.renameTo(k);
                        long j = dVar.f42601b[i2];
                        long length = k.length();
                        dVar.f42601b[i2] = length;
                        this.l = (this.l - j) + length;
                    }
                } else {
                    x(n);
                }
            }
            this.o++;
            dVar.f42603d = null;
            if (!dVar.f42602c && !z) {
                this.n.remove(dVar.f42600a);
                this.m.write("REMOVE " + dVar.f42600a + '\n');
                this.m.flush();
                if (this.l <= this.j || H()) {
                    this.q.submit(this.r);
                }
                return;
            }
            dVar.f42602c = true;
            this.m.write("CLEAN " + dVar.f42600a + dVar.a() + '\n');
            if (z) {
                long j2 = this.p;
                this.p = 1 + j2;
                dVar.f42604e = j2;
            }
            this.m.flush();
            if (this.l <= this.j) {
            }
            this.q.submit(this.r);
            return;
        }
        throw new IllegalStateException();
    }

    public void z() {
        close();
        d.b.c0.k.f.c.b(this.f42590e);
    }
}
