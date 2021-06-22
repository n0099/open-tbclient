package com.kwad.sdk.glide.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
/* loaded from: classes7.dex */
public final class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final File f35798b;

    /* renamed from: c  reason: collision with root package name */
    public final File f35799c;

    /* renamed from: d  reason: collision with root package name */
    public final File f35800d;

    /* renamed from: e  reason: collision with root package name */
    public final File f35801e;

    /* renamed from: f  reason: collision with root package name */
    public final int f35802f;

    /* renamed from: g  reason: collision with root package name */
    public long f35803g;

    /* renamed from: h  reason: collision with root package name */
    public final int f35804h;
    public Writer j;
    public int l;

    /* renamed from: i  reason: collision with root package name */
    public long f35805i = 0;
    public final LinkedHashMap<String, c> k = new LinkedHashMap<>(0, 0.75f, true);
    public long m = 0;

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f35797a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0409a());
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
    /* loaded from: classes7.dex */
    public static final class ThreadFactoryC0409a implements ThreadFactory {
        public ThreadFactoryC0409a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: classes7.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        public final c f35808b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f35809c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35810d;

        public b(c cVar) {
            this.f35808b = cVar;
            this.f35809c = cVar.f35816f ? null : new boolean[a.this.f35804h];
        }

        public File a(int i2) {
            File b2;
            synchronized (a.this) {
                if (this.f35808b.f35817g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f35808b.f35816f) {
                    this.f35809c[i2] = true;
                }
                b2 = this.f35808b.b(i2);
                if (!a.this.f35798b.exists()) {
                    a.this.f35798b.mkdirs();
                }
            }
            return b2;
        }

        public void a() {
            a.this.a(this, true);
            this.f35810d = true;
        }

        public void b() {
            a.this.a(this, false);
        }

        public void c() {
            if (this.f35810d) {
                return;
            }
            try {
                b();
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public File[] f35811a;

        /* renamed from: b  reason: collision with root package name */
        public File[] f35812b;

        /* renamed from: d  reason: collision with root package name */
        public final String f35814d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f35815e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f35816f;

        /* renamed from: g  reason: collision with root package name */
        public b f35817g;

        /* renamed from: h  reason: collision with root package name */
        public long f35818h;

        public c(String str) {
            this.f35814d = str;
            this.f35815e = new long[a.this.f35804h];
            this.f35811a = new File[a.this.f35804h];
            this.f35812b = new File[a.this.f35804h];
            StringBuilder sb = new StringBuilder(str);
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f35804h; i2++) {
                sb.append(i2);
                this.f35811a[i2] = new File(a.this.f35798b, sb.toString());
                sb.append(".tmp");
                this.f35812b[i2] = new File(a.this.f35798b, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.f35804h) {
                throw b(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f35815e[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return this.f35811a[i2];
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f35815e) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i2) {
            return this.f35812b[i2];
        }
    }

    /* loaded from: classes7.dex */
    public final class d {

        /* renamed from: b  reason: collision with root package name */
        public final String f35820b;

        /* renamed from: c  reason: collision with root package name */
        public final long f35821c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f35822d;

        /* renamed from: e  reason: collision with root package name */
        public final File[] f35823e;

        public d(String str, long j, File[] fileArr, long[] jArr) {
            this.f35820b = str;
            this.f35821c = j;
            this.f35823e = fileArr;
            this.f35822d = jArr;
        }

        public File a(int i2) {
            return this.f35823e[i2];
        }
    }

    public a(File file, int i2, int i3, long j) {
        this.f35798b = file;
        this.f35802f = i2;
        this.f35799c = new File(file, "journal");
        this.f35800d = new File(file, "journal.tmp");
        this.f35801e = new File(file, "journal.bkp");
        this.f35804h = i3;
        this.f35803g = j;
    }

    private synchronized b a(String str, long j) {
        f();
        c cVar = this.k.get(str);
        if (j == -1 || (cVar != null && cVar.f35818h == j)) {
            if (cVar == null) {
                cVar = new c(str);
                this.k.put(str, cVar);
            } else if (cVar.f35817g != null) {
                return null;
            }
            b bVar = new b(cVar);
            cVar.f35817g = bVar;
            this.j.append((CharSequence) "DIRTY");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            b(this.j);
            return bVar;
        }
        return null;
    }

    public static a a(File file, int i2, int i3, long j) {
        if (j > 0) {
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
                a aVar = new a(file, i2, i3, j);
                if (aVar.f35799c.exists()) {
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
                a aVar2 = new a(file, i2, i3, j);
                aVar2.d();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b bVar, boolean z) {
        c cVar = bVar.f35808b;
        if (cVar.f35817g != bVar) {
            throw new IllegalStateException();
        }
        if (z && !cVar.f35816f) {
            for (int i2 = 0; i2 < this.f35804h; i2++) {
                if (!bVar.f35809c[i2]) {
                    bVar.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                } else if (!cVar.b(i2).exists()) {
                    bVar.b();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.f35804h; i3++) {
            File b2 = cVar.b(i3);
            if (!z) {
                a(b2);
            } else if (b2.exists()) {
                File a2 = cVar.a(i3);
                b2.renameTo(a2);
                long j = cVar.f35815e[i3];
                long length = a2.length();
                cVar.f35815e[i3] = length;
                this.f35805i = (this.f35805i - j) + length;
            }
        }
        this.l++;
        cVar.f35817g = null;
        if (cVar.f35816f || z) {
            cVar.f35816f = true;
            this.j.append((CharSequence) "CLEAN");
            this.j.append(' ');
            this.j.append((CharSequence) cVar.f35814d);
            this.j.append((CharSequence) cVar.a());
            this.j.append('\n');
            if (z) {
                long j2 = this.m;
                this.m = 1 + j2;
                cVar.f35818h = j2;
            }
        } else {
            this.k.remove(cVar.f35814d);
            this.j.append((CharSequence) "REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence) cVar.f35814d);
            this.j.append('\n');
        }
        b(this.j);
        if (this.f35805i > this.f35803g || e()) {
            this.f35797a.submit(this.n);
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
        com.kwad.sdk.glide.a.b bVar = new com.kwad.sdk.glide.a.b(new FileInputStream(this.f35799c), com.kwad.sdk.glide.a.c.f35830a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f35802f).equals(a4) || !Integer.toString(this.f35804h).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i2 = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i2++;
                } catch (EOFException unused) {
                    this.l = i2 - this.k.size();
                    if (bVar.b()) {
                        d();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35799c, true), com.kwad.sdk.glide.a.c.f35830a));
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
        a(this.f35800d);
        Iterator<c> it = this.k.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.f35817g == null) {
                while (i2 < this.f35804h) {
                    this.f35805i += next.f35815e[i2];
                    i2++;
                }
            } else {
                next.f35817g = null;
                while (i2 < this.f35804h) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
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
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35800d), com.kwad.sdk.glide.a.c.f35830a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f35802f));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f35804h));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (c cVar : this.k.values()) {
            bufferedWriter.write(cVar.f35817g != null ? "DIRTY " + cVar.f35814d + '\n' : "CLEAN " + cVar.f35814d + cVar.a() + '\n');
        }
        a(bufferedWriter);
        if (this.f35799c.exists()) {
            a(this.f35799c, this.f35801e, true);
        }
        a(this.f35800d, this.f35799c, false);
        this.f35801e.delete();
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35799c, true), com.kwad.sdk.glide.a.c.f35830a));
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
                this.k.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i2, indexOf2);
        }
        c cVar = this.k.get(substring);
        if (cVar == null) {
            cVar = new c(substring);
            this.k.put(substring, cVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            cVar.f35816f = true;
            cVar.f35817g = null;
            cVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            cVar.f35817g = new b(cVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int i2 = this.l;
        return i2 >= 2000 && i2 >= this.k.size();
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        while (this.f35805i > this.f35803g) {
            c(this.k.entrySet().iterator().next().getKey());
        }
    }

    public synchronized d a(String str) {
        f();
        c cVar = this.k.get(str);
        if (cVar == null) {
            return null;
        }
        if (cVar.f35816f) {
            for (File file : cVar.f35811a) {
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
                this.f35797a.submit(this.n);
            }
            return new d(str, cVar.f35818h, cVar.f35811a, cVar.f35815e);
        }
        return null;
    }

    public void a() {
        close();
        com.kwad.sdk.glide.a.c.a(this.f35798b);
    }

    public b b(String str) {
        return a(str, -1L);
    }

    public synchronized boolean c(String str) {
        f();
        c cVar = this.k.get(str);
        if (cVar != null && cVar.f35817g == null) {
            for (int i2 = 0; i2 < this.f35804h; i2++) {
                File a2 = cVar.a(i2);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.f35805i -= cVar.f35815e[i2];
                cVar.f35815e[i2] = 0;
            }
            this.l++;
            this.j.append((CharSequence) "REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            this.k.remove(str);
            if (e()) {
                this.f35797a.submit(this.n);
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
            if (cVar.f35817g != null) {
                cVar.f35817g.b();
            }
        }
        g();
        a(this.j);
        this.j = null;
    }
}
