package d.a.c0.k.f;

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
    public final File f39405e;

    /* renamed from: f  reason: collision with root package name */
    public final File f39406f;

    /* renamed from: g  reason: collision with root package name */
    public final File f39407g;

    /* renamed from: h  reason: collision with root package name */
    public final File f39408h;

    /* renamed from: i  reason: collision with root package name */
    public final int f39409i;
    public long j;
    public final int k;
    public Writer m;
    public int o;
    public long l = 0;
    public final LinkedHashMap<String, d> n = new LinkedHashMap<>(0, 0.75f, true);
    public long p = 0;
    public final ThreadPoolExecutor q = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> r = new CallableC0506a();

    /* renamed from: d.a.c0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC0506a implements Callable<Void> {
        public CallableC0506a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.m == null) {
                    return null;
                }
                a.this.K();
                if (a.this.I()) {
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
        public void write(int i2) {
        }
    }

    /* loaded from: classes2.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public final d f39411a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f39412b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f39413c;

        /* renamed from: d.a.c0.k.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0507a extends FilterOutputStream {
            public /* synthetic */ C0507a(c cVar, OutputStream outputStream, CallableC0506a callableC0506a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f39413c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f39413c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    c.this.f39413c = true;
                }
            }

            public C0507a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    c.this.f39413c = true;
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0506a callableC0506a) {
            this(dVar);
        }

        public void c() {
            a.this.u(this, false);
        }

        public OutputStream e(int i2) {
            FileOutputStream fileOutputStream;
            C0507a c0507a;
            if (i2 < 0 || i2 >= a.this.k) {
                throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + a.this.k);
            }
            synchronized (a.this) {
                if (this.f39411a.f39419d == this) {
                    if (!this.f39411a.f39418c) {
                        this.f39412b[i2] = true;
                    }
                    File n = this.f39411a.n(i2);
                    try {
                        fileOutputStream = new FileOutputStream(n);
                    } catch (FileNotFoundException unused) {
                        a.this.f39405e.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(n);
                        } catch (FileNotFoundException unused2) {
                            return a.t;
                        }
                    }
                    c0507a = new C0507a(this, fileOutputStream, null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0507a;
        }

        public void f() {
            if (this.f39413c) {
                a.this.u(this, false);
                a.this.H(this.f39411a.f39416a);
                return;
            }
            a.this.u(this, true);
        }

        public c(d dVar) {
            this.f39411a = dVar;
            this.f39412b = dVar.f39418c ? null : new boolean[a.this.k];
        }
    }

    /* loaded from: classes2.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f39416a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f39417b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f39418c;

        /* renamed from: d  reason: collision with root package name */
        public c f39419d;

        /* renamed from: e  reason: collision with root package name */
        public long f39420e;

        public /* synthetic */ d(a aVar, String str, CallableC0506a callableC0506a) {
            this(str);
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f39417b) {
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
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f39417b[i2] = Long.parseLong(strArr[i2]);
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

        public File k(int i2) {
            File file = a.this.f39405e;
            return new File(file, this.f39416a + "." + i2);
        }

        public File n(int i2) {
            File file = a.this.f39405e;
            return new File(file, this.f39416a + "." + i2 + ".tmp");
        }

        public d(String str) {
            this.f39416a = str;
            this.f39417b = new long[a.this.k];
        }
    }

    /* loaded from: classes2.dex */
    public final class e implements Closeable {

        /* renamed from: e  reason: collision with root package name */
        public final InputStream[] f39422e;

        public /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0506a callableC0506a) {
            this(str, j, inputStreamArr, jArr);
        }

        public InputStream c(int i2) {
            return this.f39422e[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f39422e) {
                d.a.c0.k.f.c.a(inputStream);
            }
        }

        public e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f39422e = inputStreamArr;
        }
    }

    public a(File file, int i2, int i3, long j) {
        this.f39405e = file;
        this.f39409i = i2;
        this.f39406f = new File(file, "journal");
        this.f39407g = new File(file, "journal.tmp");
        this.f39408h = new File(file, "journal.bkp");
        this.k = i3;
        this.j = j;
    }

    public static a q(File file, int i2, int i3, long j) {
        if (j > 0) {
            if (i3 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        t(file2, file3, false);
                    }
                }
                a aVar = new a(file, i2, i3, j);
                if (aVar.f39406f.exists()) {
                    try {
                        aVar.L();
                        aVar.J();
                        return aVar;
                    } catch (IOException e2) {
                        d.a.c0.n.d.b("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.z();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i2, i3, j);
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
        G();
        F(str);
        d dVar = this.n.get(str);
        if (dVar == null) {
            return null;
        }
        if (dVar.f39418c) {
            InputStream[] inputStreamArr = new InputStream[this.k];
            for (int i2 = 0; i2 < this.k; i2++) {
                try {
                    inputStreamArr[i2] = new FileInputStream(dVar.k(i2));
                } catch (FileNotFoundException unused) {
                    for (int i3 = 0; i3 < this.k && inputStreamArr[i3] != null; i3++) {
                        d.a.c0.k.f.c.a(inputStreamArr[i3]);
                    }
                    return null;
                }
            }
            this.o++;
            this.m.append((CharSequence) ("READ " + str + '\n'));
            if (I()) {
                this.q.submit(this.r);
            }
            return new e(this, str, dVar.f39420e, inputStreamArr, dVar.f39417b, null);
        }
        return null;
    }

    public final void E(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                substring = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.n.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i2, indexOf2);
            }
            d dVar = this.n.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.n.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f39418c = true;
                dVar.f39419d = null;
                dVar.i(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f39419d = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final void F(String str) {
        if (s.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final void G() {
        if (this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized boolean H(String str) {
        G();
        F(str);
        d dVar = this.n.get(str);
        if (dVar != null && dVar.f39419d == null) {
            for (int i2 = 0; i2 < this.k; i2++) {
                File k = dVar.k(i2);
                if (k.exists() && !k.delete()) {
                    throw new IOException("failed to delete " + k);
                }
                this.l -= dVar.f39417b[i2];
                dVar.f39417b[i2] = 0;
            }
            this.o++;
            this.m.append((CharSequence) ("REMOVE " + str + '\n'));
            this.n.remove(str);
            if (I()) {
                this.q.submit(this.r);
            }
            return true;
        }
        return false;
    }

    public final boolean I() {
        int i2 = this.o;
        return i2 >= 2000 && i2 >= this.n.size();
    }

    public final void J() {
        x(this.f39407g);
        Iterator<d> it = this.n.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f39419d != null) {
                next.f39419d = null;
                while (i2 < this.k) {
                    x(next.k(i2));
                    x(next.n(i2));
                    i2++;
                }
                it.remove();
            } else {
                while (i2 < this.k) {
                    this.l += next.f39417b[i2];
                    i2++;
                }
            }
        }
    }

    public final void K() {
        while (this.l > this.j) {
            H(this.n.entrySet().iterator().next().getKey());
        }
    }

    public final void L() {
        d.a.c0.k.f.b bVar = new d.a.c0.k.f.b(new FileInputStream(this.f39406f), d.a.c0.k.f.c.f39430a);
        try {
            String q = bVar.q();
            String q2 = bVar.q();
            String q3 = bVar.q();
            String q4 = bVar.q();
            String q5 = bVar.q();
            if (!"libcore.io.DiskLruCache".equals(q) || !"1".equals(q2) || !Integer.toString(this.f39409i).equals(q3) || !Integer.toString(this.k).equals(q4) || !"".equals(q5)) {
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
            int i2 = 0;
            while (true) {
                try {
                    E(bVar.q());
                    i2++;
                } catch (EOFException unused) {
                    this.o = i2 - this.n.size();
                    if (bVar.n()) {
                        M();
                    } else {
                        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f39406f, true), d.a.c0.k.f.c.f39430a));
                    }
                    d.a.c0.k.f.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            d.a.c0.k.f.c.a(bVar);
            throw th;
        }
    }

    public final synchronized void M() {
        Writer writer = this.m;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f39407g), d.a.c0.k.f.c.f39430a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f39409i));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.k));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.n.values()) {
            if (dVar.f39419d != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("DIRTY ");
                sb.append(dVar.f39416a);
                sb.append('\n');
                bufferedWriter.write(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CLEAN ");
                sb2.append(dVar.f39416a);
                sb2.append(dVar.a());
                sb2.append('\n');
                bufferedWriter.write(sb2.toString());
            }
        }
        bufferedWriter.close();
        if (this.f39406f.exists()) {
            t(this.f39406f, this.f39408h, true);
        }
        t(this.f39407g, this.f39406f, false);
        this.f39408h.delete();
        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f39406f, true), d.a.c0.k.f.c.f39430a));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.m == null) {
            return;
        }
        Iterator it = new ArrayList(this.n.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f39419d != null) {
                dVar.f39419d.c();
            }
        }
        K();
        this.m.close();
        this.m = null;
    }

    public synchronized void flush() {
        G();
        K();
        this.m.flush();
    }

    public final synchronized c p(String str, long j) {
        G();
        F(str);
        d dVar = this.n.get(str);
        if (j == -1 || (dVar != null && dVar.f39420e == j)) {
            if (dVar != null) {
                if (dVar.f39419d != null) {
                    return null;
                }
            } else {
                dVar = new d(this, str, null);
                this.n.put(str, dVar);
            }
            c cVar = new c(this, dVar, null);
            dVar.f39419d = cVar;
            Writer writer = this.m;
            writer.write("DIRTY " + str + '\n');
            this.m.flush();
            return cVar;
        }
        return null;
    }

    public final synchronized void u(c cVar, boolean z) {
        d dVar = cVar.f39411a;
        if (dVar.f39419d == cVar) {
            if (z && !dVar.f39418c) {
                for (int i2 = 0; i2 < this.k; i2++) {
                    if (cVar.f39412b[i2]) {
                        if (!dVar.n(i2).exists()) {
                            cVar.c();
                            return;
                        }
                    } else {
                        cVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.k; i3++) {
                File n = dVar.n(i3);
                if (z) {
                    if (n.exists()) {
                        File k = dVar.k(i3);
                        n.renameTo(k);
                        long j = dVar.f39417b[i3];
                        long length = k.length();
                        dVar.f39417b[i3] = length;
                        this.l = (this.l - j) + length;
                    }
                } else {
                    x(n);
                }
            }
            this.o++;
            dVar.f39419d = null;
            if (!dVar.f39418c && !z) {
                this.n.remove(dVar.f39416a);
                this.m.write("REMOVE " + dVar.f39416a + '\n');
                this.m.flush();
                if (this.l <= this.j || I()) {
                    this.q.submit(this.r);
                }
                return;
            }
            dVar.f39418c = true;
            this.m.write("CLEAN " + dVar.f39416a + dVar.a() + '\n');
            if (z) {
                long j2 = this.p;
                this.p = 1 + j2;
                dVar.f39420e = j2;
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
        d.a.c0.k.f.c.b(this.f39405e);
    }
}
