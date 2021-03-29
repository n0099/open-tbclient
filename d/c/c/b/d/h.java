package d.c.c.b.d;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import d.c.c.b.f.b;
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
/* loaded from: classes5.dex */
public class h implements d.c.c.b.f.b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f65698a;

    /* renamed from: b  reason: collision with root package name */
    public long f65699b;

    /* renamed from: c  reason: collision with root package name */
    public final File f65700c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65701d;

    public h(File file, int i) {
        this.f65698a = new LinkedHashMap(16, 0.75f, true);
        this.f65699b = 0L;
        this.f65700c = file;
        this.f65701d = i;
    }

    public static int b(InputStream inputStream) throws Throwable {
        return (p(inputStream) << 24) | (p(inputStream) << 0) | 0 | (p(inputStream) << 8) | (p(inputStream) << 16);
    }

    public static String d(b bVar) throws Throwable {
        return new String(j(bVar, k(bVar)), "UTF-8");
    }

    public static void e(OutputStream outputStream, int i) throws Throwable {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
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

    public static void i(List<d.c.c.b.d.a> list, OutputStream outputStream) throws Throwable {
        if (list != null) {
            e(outputStream, list.size());
            for (d.c.c.b.d.a aVar : list) {
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
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + n);
    }

    public static long k(InputStream inputStream) throws Throwable {
        return ((p(inputStream) & 255) << 0) | 0 | ((p(inputStream) & 255) << 8) | ((p(inputStream) & 255) << 16) | ((p(inputStream) & 255) << 24) | ((p(inputStream) & 255) << 32) | ((p(inputStream) & 255) << 40) | ((p(inputStream) & 255) << 48) | ((255 & p(inputStream)) << 56);
    }

    public static List<d.c.c.b.d.a> m(b bVar) throws Throwable {
        int b2 = b(bVar);
        if (b2 >= 0) {
            List<d.c.c.b.d.a> emptyList = b2 == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < b2; i++) {
                emptyList.add(new d.c.c.b.d.a(d(bVar).intern(), d(bVar).intern()));
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

    @Override // d.c.c.b.f.b
    public synchronized b.a a(String str) {
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = this.f65698a.get(str);
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
            if (!TextUtils.equals(str, a2.f65703b)) {
                q.c("%s: key=%s, found=%s", q.getAbsolutePath(), str, a2.f65703b);
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
        if (!this.f65698a.containsKey(str)) {
            this.f65699b += aVar.f65702a;
        } else {
            this.f65699b += aVar.f65702a - this.f65698a.get(str).f65702a;
        }
        this.f65698a.put(str, aVar);
    }

    @VisibleForTesting
    public OutputStream l(File file) throws Throwable {
        return new FileOutputStream(file);
    }

    public final void n() {
        if (this.f65699b < this.f65701d) {
            return;
        }
        if (q.f65748b) {
            q.a("Pruning old cache entries.", new Object[0]);
        }
        long j = this.f65699b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f65698a.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (q(value.f65703b).delete()) {
                this.f65699b -= value.f65702a;
            } else {
                String str = value.f65703b;
                q.c("Could not delete cache entry for key=%s, filename=%s", str, r(str));
            }
            it.remove();
            i++;
            if (((float) this.f65699b) < this.f65701d * 0.9f) {
                break;
            }
        }
        if (q.f65748b) {
            q.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.f65699b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
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
        return new File(this.f65700c, r(str));
    }

    public final String r(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public final void s(String str) {
        a remove = this.f65698a.remove(str);
        if (remove != null) {
            this.f65699b -= remove.f65702a;
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class b extends FilterInputStream {

        /* renamed from: e  reason: collision with root package name */
        public final long f65710e;

        /* renamed from: f  reason: collision with root package name */
        public long f65711f;

        public b(InputStream inputStream, long j) {
            super(inputStream);
            this.f65710e = j;
        }

        public long n() {
            return this.f65710e - this.f65711f;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f65711f++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f65711f += read;
            }
            return read;
        }
    }

    public h(File file) {
        this(file, 5242880);
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f65702a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65703b;

        /* renamed from: c  reason: collision with root package name */
        public final String f65704c;

        /* renamed from: d  reason: collision with root package name */
        public final long f65705d;

        /* renamed from: e  reason: collision with root package name */
        public final long f65706e;

        /* renamed from: f  reason: collision with root package name */
        public final long f65707f;

        /* renamed from: g  reason: collision with root package name */
        public final long f65708g;

        /* renamed from: h  reason: collision with root package name */
        public final List<d.c.c.b.d.a> f65709h;

        public a(String str, String str2, long j, long j2, long j3, long j4, List<d.c.c.b.d.a> list) {
            this.f65703b = str;
            this.f65704c = "".equals(str2) ? null : str2;
            this.f65705d = j;
            this.f65706e = j2;
            this.f65707f = j3;
            this.f65708g = j4;
            this.f65709h = list;
        }

        public static a a(b bVar) throws Throwable {
            if (h.b(bVar) == 538247942) {
                return new a(h.d(bVar), h.d(bVar), h.k(bVar), h.k(bVar), h.k(bVar), h.k(bVar), h.m(bVar));
            }
            throw new IOException();
        }

        public static List<d.c.c.b.d.a> c(b.a aVar) {
            List<d.c.c.b.d.a> list = aVar.i;
            return list != null ? list : d.c.c.b.e.c.h(aVar.f65770h);
        }

        public b.a b(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f65764b = bArr;
            aVar.f65765c = this.f65704c;
            aVar.f65766d = this.f65705d;
            aVar.f65767e = this.f65706e;
            aVar.f65768f = this.f65707f;
            aVar.f65769g = this.f65708g;
            aVar.f65770h = d.c.c.b.e.c.g(this.f65709h);
            aVar.i = Collections.unmodifiableList(this.f65709h);
            return aVar;
        }

        public boolean d(OutputStream outputStream) {
            try {
                h.e(outputStream, 538247942);
                h.g(outputStream, this.f65703b);
                h.g(outputStream, this.f65704c == null ? "" : this.f65704c);
                h.f(outputStream, this.f65705d);
                h.f(outputStream, this.f65706e);
                h.f(outputStream, this.f65707f);
                h.f(outputStream, this.f65708g);
                h.i(this.f65709h, outputStream);
                outputStream.flush();
                return true;
            } catch (Throwable th) {
                q.c("%s", th.toString());
                return false;
            }
        }

        public a(String str, b.a aVar) {
            this(str, aVar.f65765c, aVar.f65766d, aVar.f65767e, aVar.f65768f, aVar.f65769g, c(aVar));
        }
    }

    @Override // d.c.c.b.f.b
    public synchronized void a() {
        if (!this.f65700c.exists()) {
            if (!this.f65700c.mkdirs()) {
                q.d("Unable to create cache dir %s", this.f65700c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f65700c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            long length = file.length();
            b bVar = new b(new BufferedInputStream(c(file)), length);
            try {
                a a2 = a.a(bVar);
                a2.f65702a = length;
                h(a2.f65703b, a2);
            } catch (Throwable unused) {
            }
            bVar.close();
        }
    }

    @Override // d.c.c.b.f.b
    public synchronized void a(String str, b.a aVar) {
        if (this.f65699b + aVar.f65764b.length > this.f65701d && aVar.f65764b.length > this.f65701d * 0.9f) {
            return;
        }
        File q = q(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(l(q));
            try {
                a aVar2 = new a(str, aVar);
                if (aVar2.d(bufferedOutputStream2)) {
                    bufferedOutputStream2.write(aVar.f65764b);
                    aVar2.f65702a = q.length();
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
