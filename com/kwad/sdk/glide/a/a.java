package com.kwad.sdk.glide.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
/* loaded from: classes6.dex */
public final class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final File f35026b;

    /* renamed from: c  reason: collision with root package name */
    public final File f35027c;

    /* renamed from: d  reason: collision with root package name */
    public final File f35028d;

    /* renamed from: e  reason: collision with root package name */
    public final File f35029e;

    /* renamed from: f  reason: collision with root package name */
    public final int f35030f;

    /* renamed from: g  reason: collision with root package name */
    public long f35031g;

    /* renamed from: h  reason: collision with root package name */
    public final int f35032h;
    public Writer j;
    public int l;
    public long i = 0;
    public final LinkedHashMap<String, c> k = new LinkedHashMap<>(0, 0.75f, true);
    public long m = 0;

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f35025a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0405a());
    public final Callable<Void> n = new Callable<Void>() { // from class: com.kwad.sdk.glide.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.j == null) {
                    return null;
                }
                a.this.g();
                if (a.this.e()) {
                    a.this.d();
                    a.this.l = 0;
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.glide.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class ThreadFactoryC0405a implements ThreadFactory {
        public ThreadFactoryC0405a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: classes6.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        public final c f35035b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f35036c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35037d;

        public b(c cVar) {
            this.f35035b = cVar;
            this.f35036c = cVar.f35043f ? null : new boolean[a.this.f35032h];
        }

        public File a(int i) {
            File b2;
            synchronized (a.this) {
                if (this.f35035b.f35044g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f35035b.f35043f) {
                    this.f35036c[i] = true;
                }
                b2 = this.f35035b.b(i);
                if (!a.this.f35026b.exists()) {
                    a.this.f35026b.mkdirs();
                }
            }
            return b2;
        }

        public void a() {
            a.this.a(this, true);
            this.f35037d = true;
        }

        public void b() {
            a.this.a(this, false);
        }

        public void c() {
            if (this.f35037d) {
                return;
            }
            try {
                b();
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public File[] f35038a;

        /* renamed from: b  reason: collision with root package name */
        public File[] f35039b;

        /* renamed from: d  reason: collision with root package name */
        public final String f35041d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f35042e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f35043f;

        /* renamed from: g  reason: collision with root package name */
        public b f35044g;

        /* renamed from: h  reason: collision with root package name */
        public long f35045h;

        public c(String str) {
            this.f35041d = str;
            this.f35042e = new long[a.this.f35032h];
            this.f35038a = new File[a.this.f35032h];
            this.f35039b = new File[a.this.f35032h];
            StringBuilder sb = new StringBuilder(str);
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i = 0; i < a.this.f35032h; i++) {
                sb.append(i);
                this.f35038a[i] = new File(a.this.f35026b, sb.toString());
                sb.append(".tmp");
                this.f35039b[i] = new File(a.this.f35026b, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.f35032h) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f35042e[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f35038a[i];
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f35042e) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return this.f35039b[i];
        }
    }

    /* loaded from: classes6.dex */
    public final class d {

        /* renamed from: b  reason: collision with root package name */
        public final String f35047b;

        /* renamed from: c  reason: collision with root package name */
        public final long f35048c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f35049d;

        /* renamed from: e  reason: collision with root package name */
        public final File[] f35050e;

        public d(String str, long j, File[] fileArr, long[] jArr) {
            this.f35047b = str;
            this.f35048c = j;
            this.f35050e = fileArr;
            this.f35049d = jArr;
        }

        public File a(int i) {
            return this.f35050e[i];
        }
    }

    public a(File file, int i, int i2, long j) {
        this.f35026b = file;
        this.f35030f = i;
        this.f35027c = new File(file, "journal");
        this.f35028d = new File(file, "journal.tmp");
        this.f35029e = new File(file, "journal.bkp");
        this.f35032h = i2;
        this.f35031g = j;
    }

    private synchronized b a(String str, long j) {
        f();
        c cVar = this.k.get(str);
        if (j == -1 || (cVar != null && cVar.f35045h == j)) {
            if (cVar == null) {
                cVar = new c(str);
                this.k.put(str, cVar);
            } else if (cVar.f35044g != null) {
                return null;
            }
            b bVar = new b(cVar);
            cVar.f35044g = bVar;
            this.j.append((CharSequence) "DIRTY");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            b(this.j);
            return bVar;
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
                if (aVar.f35027c.exists()) {
                    try {
                        aVar.b();
                        aVar.c();
                        return aVar;
                    } catch (IOException e2) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.a();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j);
                aVar2.d();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b bVar, boolean z) {
        c cVar = bVar.f35035b;
        if (cVar.f35044g != bVar) {
            throw new IllegalStateException();
        }
        if (z && !cVar.f35043f) {
            for (int i = 0; i < this.f35032h; i++) {
                if (!bVar.f35036c[i]) {
                    bVar.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!cVar.b(i).exists()) {
                    bVar.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f35032h; i2++) {
            File b2 = cVar.b(i2);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = cVar.a(i2);
                b2.renameTo(a2);
                long j = cVar.f35042e[i2];
                long length = a2.length();
                cVar.f35042e[i2] = length;
                this.i = (this.i - j) + length;
            }
        }
        this.l++;
        cVar.f35044g = null;
        if (cVar.f35043f || z) {
            cVar.f35043f = true;
            this.j.append((CharSequence) "CLEAN");
            this.j.append(' ');
            this.j.append((CharSequence) cVar.f35041d);
            this.j.append((CharSequence) cVar.a());
            this.j.append('\n');
            if (z) {
                long j2 = this.m;
                this.m = 1 + j2;
                cVar.f35045h = j2;
            }
        } else {
            this.k.remove(cVar.f35041d);
            this.j.append((CharSequence) "REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence) cVar.f35041d);
            this.j.append('\n');
        }
        b(this.j);
        if (this.i > this.f35031g || e()) {
            this.f35025a.submit(this.n);
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

    @TargetApi(26)
    public static void a(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private void b() {
        com.kwad.sdk.glide.a.b bVar = new com.kwad.sdk.glide.a.b(new FileInputStream(this.f35027c), com.kwad.sdk.glide.a.c.f35057a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f35030f).equals(a4) || !Integer.toString(this.f35032h).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.l = i - this.k.size();
                    if (bVar.b()) {
                        d();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35027c, true), com.kwad.sdk.glide.a.c.f35057a));
                    }
                    com.kwad.sdk.glide.a.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.glide.a.c.a(bVar);
            throw th;
        }
    }

    @TargetApi(26)
    public static void b(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private void c() {
        a(this.f35028d);
        Iterator<c> it = this.k.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i = 0;
            if (next.f35044g == null) {
                while (i < this.f35032h) {
                    this.i += next.f35042e[i];
                    i++;
                }
            } else {
                next.f35044g = null;
                while (i < this.f35032h) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.j != null) {
            a(this.j);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35028d), com.kwad.sdk.glide.a.c.f35057a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f35030f));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f35032h));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (c cVar : this.k.values()) {
            bufferedWriter.write(cVar.f35044g != null ? "DIRTY " + cVar.f35041d + '\n' : "CLEAN " + cVar.f35041d + cVar.a() + '\n');
        }
        a(bufferedWriter);
        if (this.f35027c.exists()) {
            a(this.f35027c, this.f35029e, true);
        }
        a(this.f35028d, this.f35027c, false);
        this.f35029e.delete();
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35027c, true), com.kwad.sdk.glide.a.c.f35057a));
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
                this.k.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        c cVar = this.k.get(substring);
        if (cVar == null) {
            cVar = new c(substring);
            this.k.put(substring, cVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            cVar.f35043f = true;
            cVar.f35044g = null;
            cVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            cVar.f35044g = new b(cVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int i = this.l;
        return i >= 2000 && i >= this.k.size();
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        while (this.i > this.f35031g) {
            c(this.k.entrySet().iterator().next().getKey());
        }
    }

    public synchronized d a(String str) {
        f();
        c cVar = this.k.get(str);
        if (cVar == null) {
            return null;
        }
        if (cVar.f35043f) {
            for (File file : cVar.f35038a) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.l++;
            this.j.append((CharSequence) "READ");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            if (e()) {
                this.f35025a.submit(this.n);
            }
            return new d(str, cVar.f35045h, cVar.f35038a, cVar.f35042e);
        }
        return null;
    }

    public void a() {
        close();
        com.kwad.sdk.glide.a.c.a(this.f35026b);
    }

    public b b(String str) {
        return a(str, -1L);
    }

    public synchronized boolean c(String str) {
        f();
        c cVar = this.k.get(str);
        if (cVar != null && cVar.f35044g == null) {
            for (int i = 0; i < this.f35032h; i++) {
                File a2 = cVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.i -= cVar.f35042e[i];
                cVar.f35042e[i] = 0;
            }
            this.l++;
            this.j.append((CharSequence) "REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            this.k.remove(str);
            if (e()) {
                this.f35025a.submit(this.n);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.j == null) {
            return;
        }
        Iterator it = new ArrayList(this.k.values()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f35044g != null) {
                cVar.f35044g.b();
            }
        }
        g();
        a(this.j);
        this.j = null;
    }
}
