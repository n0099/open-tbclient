package d.b.c.b.d;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import d.b.c.b.f.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class h implements d.b.c.b.f.b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f65723a;

    /* renamed from: b  reason: collision with root package name */
    public long f65724b;

    /* renamed from: c  reason: collision with root package name */
    public final File f65725c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65726d;

    public h(File file, int i2) {
        this.f65723a = new LinkedHashMap(16, 0.75f, true);
        this.f65724b = 0L;
        this.f65725c = file;
        this.f65726d = i2;
    }

    public static int b(InputStream inputStream) throws Throwable {
        return (p(inputStream) << 24) | (p(inputStream) << 0) | 0 | (p(inputStream) << 8) | (p(inputStream) << 16);
    }

    public static String d(b bVar) throws Throwable {
        return new String(j(bVar, k(bVar)), "UTF-8");
    }

    public static void e(OutputStream outputStream, int i2) throws Throwable {
        outputStream.write((i2 >> 0) & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write((i2 >> 24) & 255);
    }

    public static void f(OutputStream outputStream, long j) throws Throwable {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void g(OutputStream outputStream, String str) throws Throwable {
        byte[] bytes = str.getBytes("UTF-8");
        f(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public static void i(List<d.b.c.b.d.a> list, OutputStream outputStream) throws Throwable {
        if (list != null) {
            e(outputStream, list.size());
            for (d.b.c.b.d.a aVar : list) {
                g(outputStream, aVar.a());
                g(outputStream, aVar.b());
            }
            return;
        }
        e(outputStream, 0);
    }

    @VisibleForTesting
    public static byte[] j(b bVar, long j) throws Throwable {
        long n = bVar.n();
        if (j >= 0 && j <= n) {
            int i2 = (int) j;
            if (i2 == j) {
                byte[] bArr = new byte[i2];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + n);
    }

    public static long k(InputStream inputStream) throws Throwable {
        return ((p(inputStream) & 255) << 0) | 0 | ((p(inputStream) & 255) << 8) | ((p(inputStream) & 255) << 16) | ((p(inputStream) & 255) << 24) | ((p(inputStream) & 255) << 32) | ((p(inputStream) & 255) << 40) | ((p(inputStream) & 255) << 48) | ((255 & p(inputStream)) << 56);
    }

    public static List<d.b.c.b.d.a> m(b bVar) throws Throwable {
        int b2 = b(bVar);
        if (b2 >= 0) {
            List<d.b.c.b.d.a> emptyList = b2 == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i2 = 0; i2 < b2; i2++) {
                emptyList.add(new d.b.c.b.d.a(d(bVar).intern(), d(bVar).intern()));
            }
            return emptyList;
        }
        throw new IOException("readHeaderList size=" + b2);
    }

    public static int p(InputStream inputStream) throws Throwable {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    @Override // d.b.c.b.f.b
    public synchronized b.a a(String str) {
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = this.f65723a.get(str);
        if (aVar == null) {
            return null;
        }
        File q = q(str);
        try {
            bVar = new b(new BufferedInputStream(c(q)), q.length());
        } catch (Throwable th) {
            th = th;
            bVar = null;
        }
        try {
            a a2 = a.a(bVar);
            if (!TextUtils.equals(str, a2.f65728b)) {
                q.c("%s: key=%s, found=%s", q.getAbsolutePath(), str, a2.f65728b);
                s(str);
                bVar.close();
                try {
                    bVar.close();
                } catch (Throwable unused) {
                }
                return null;
            }
            b.a b2 = aVar.b(j(bVar, bVar.n()));
            bVar.close();
            try {
                bVar.close();
            } catch (Throwable unused2) {
            }
            return b2;
        } catch (Throwable th2) {
            th = th2;
            q.c("%s: %s", q.getAbsolutePath(), th.toString());
            o(str);
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Throwable unused3) {
                }
            }
            return null;
        }
    }

    @VisibleForTesting
    public InputStream c(File file) throws Throwable {
        return new FileInputStream(file);
    }

    public final void h(String str, a aVar) {
        if (!this.f65723a.containsKey(str)) {
            this.f65724b += aVar.f65727a;
        } else {
            this.f65724b += aVar.f65727a - this.f65723a.get(str).f65727a;
        }
        this.f65723a.put(str, aVar);
    }

    @VisibleForTesting
    public OutputStream l(File file) throws Throwable {
        return new FileOutputStream(file);
    }

    public final void n() {
        if (this.f65724b < this.f65726d) {
            return;
        }
        if (q.f65775b) {
            q.a("Pruning old cache entries.", new Object[0]);
        }
        long j = this.f65724b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f65723a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (q(value.f65728b).delete()) {
                this.f65724b -= value.f65727a;
            } else {
                String str = value.f65728b;
                q.c("Could not delete cache entry for key=%s, filename=%s", str, r(str));
            }
            it.remove();
            i2++;
            if (((float) this.f65724b) < this.f65726d * 0.9f) {
                break;
            }
        }
        if (q.f65775b) {
            q.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f65724b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public synchronized void o(String str) {
        boolean delete = q(str).delete();
        s(str);
        if (!delete) {
            q.c("Could not delete cache entry for key=%s, filename=%s", str, r(str));
        }
    }

    public File q(String str) {
        return new File(this.f65725c, r(str));
    }

    public final String r(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public final void s(String str) {
        a remove = this.f65723a.remove(str);
        if (remove != null) {
            this.f65724b -= remove.f65727a;
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class b extends FilterInputStream {

        /* renamed from: e  reason: collision with root package name */
        public final long f65735e;

        /* renamed from: f  reason: collision with root package name */
        public long f65736f;

        public b(InputStream inputStream, long j) {
            super(inputStream);
            this.f65735e = j;
        }

        public long n() {
            return this.f65735e - this.f65736f;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f65736f++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = super.read(bArr, i2, i3);
            if (read != -1) {
                this.f65736f += read;
            }
            return read;
        }
    }

    public h(File file) {
        this(file, 5242880);
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f65727a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65728b;

        /* renamed from: c  reason: collision with root package name */
        public final String f65729c;

        /* renamed from: d  reason: collision with root package name */
        public final long f65730d;

        /* renamed from: e  reason: collision with root package name */
        public final long f65731e;

        /* renamed from: f  reason: collision with root package name */
        public final long f65732f;

        /* renamed from: g  reason: collision with root package name */
        public final long f65733g;

        /* renamed from: h  reason: collision with root package name */
        public final List<d.b.c.b.d.a> f65734h;

        public a(String str, String str2, long j, long j2, long j3, long j4, List<d.b.c.b.d.a> list) {
            this.f65728b = str;
            this.f65729c = "".equals(str2) ? null : str2;
            this.f65730d = j;
            this.f65731e = j2;
            this.f65732f = j3;
            this.f65733g = j4;
            this.f65734h = list;
        }

        public static a a(b bVar) throws Throwable {
            if (h.b(bVar) == 538247942) {
                return new a(h.d(bVar), h.d(bVar), h.k(bVar), h.k(bVar), h.k(bVar), h.k(bVar), h.m(bVar));
            }
            throw new IOException();
        }

        public static List<d.b.c.b.d.a> c(b.a aVar) {
            List<d.b.c.b.d.a> list = aVar.f65798i;
            return list != null ? list : d.b.c.b.e.c.h(aVar.f65797h);
        }

        public b.a b(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f65791b = bArr;
            aVar.f65792c = this.f65729c;
            aVar.f65793d = this.f65730d;
            aVar.f65794e = this.f65731e;
            aVar.f65795f = this.f65732f;
            aVar.f65796g = this.f65733g;
            aVar.f65797h = d.b.c.b.e.c.g(this.f65734h);
            aVar.f65798i = Collections.unmodifiableList(this.f65734h);
            return aVar;
        }

        public boolean d(OutputStream outputStream) {
            try {
                h.e(outputStream, 538247942);
                h.g(outputStream, this.f65728b);
                h.g(outputStream, this.f65729c == null ? "" : this.f65729c);
                h.f(outputStream, this.f65730d);
                h.f(outputStream, this.f65731e);
                h.f(outputStream, this.f65732f);
                h.f(outputStream, this.f65733g);
                h.i(this.f65734h, outputStream);
                outputStream.flush();
                return true;
            } catch (Throwable th) {
                q.c("%s", th.toString());
                return false;
            }
        }

        public a(String str, b.a aVar) {
            this(str, aVar.f65792c, aVar.f65793d, aVar.f65794e, aVar.f65795f, aVar.f65796g, c(aVar));
        }
    }

    @Override // d.b.c.b.f.b
    public synchronized void a() {
        if (!this.f65725c.exists()) {
            if (!this.f65725c.mkdirs()) {
                q.d("Unable to create cache dir %s", this.f65725c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f65725c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            long length = file.length();
            b bVar = new b(new BufferedInputStream(c(file)), length);
            try {
                a a2 = a.a(bVar);
                a2.f65727a = length;
                h(a2.f65728b, a2);
            } catch (Throwable unused) {
            }
            bVar.close();
        }
    }

    @Override // d.b.c.b.f.b
    public synchronized void a(String str, b.a aVar) {
        if (this.f65724b + aVar.f65791b.length > this.f65726d && aVar.f65791b.length > this.f65726d * 0.9f) {
            return;
        }
        File q = q(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(l(q));
            try {
                a aVar2 = new a(str, aVar);
                if (aVar2.d(bufferedOutputStream2)) {
                    bufferedOutputStream2.write(aVar.f65791b);
                    aVar2.f65727a = q.length();
                    h(str, aVar2);
                    n();
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable unused) {
                    }
                    return;
                }
                bufferedOutputStream2.close();
                q.c("Failed to write header for %s", q.getAbsolutePath());
                throw new IOException();
            } catch (Throwable unused2) {
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (!q.delete()) {
                    q.c("Could not clean up file %s", q.getAbsolutePath());
                }
            }
        } catch (Throwable unused4) {
        }
    }
}
