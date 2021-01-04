package com.kwad.sdk.glide.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
/* loaded from: classes5.dex */
public final class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final File f10222b;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private Writer j;
    private int l;
    private long i = 0;
    private final LinkedHashMap<String, c> k = new LinkedHashMap<>(0, 0.75f, true);
    private long m = 0;

    /* renamed from: a  reason: collision with root package name */
    final ThreadPoolExecutor f10221a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC1091a());
    private final Callable<Void> n = new Callable<Void>() { // from class: com.kwad.sdk.glide.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.j != null) {
                    a.this.g();
                    if (a.this.e()) {
                        a.this.d();
                        a.this.l = 0;
                    }
                }
            }
            return null;
        }
    };

    /* renamed from: com.kwad.sdk.glide.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class ThreadFactoryC1091a implements ThreadFactory {
        private ThreadFactoryC1091a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: classes5.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        private final c f10225b;
        private final boolean[] c;
        private boolean d;

        private b(c cVar) {
            this.f10225b = cVar;
            this.c = cVar.f ? null : new boolean[a.this.h];
        }

        public File a(int i) {
            File b2;
            synchronized (a.this) {
                if (this.f10225b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f10225b.f) {
                    this.c[i] = true;
                }
                b2 = this.f10225b.b(i);
                if (!a.this.f10222b.exists()) {
                    a.this.f10222b.mkdirs();
                }
            }
            return b2;
        }

        public void a() {
            a.this.a(this, true);
            this.d = true;
        }

        public void b() {
            a.this.a(this, false);
        }

        public void c() {
            if (this.d) {
                return;
            }
            try {
                b();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        File[] f10226a;

        /* renamed from: b  reason: collision with root package name */
        File[] f10227b;
        private final String d;
        private final long[] e;
        private boolean f;
        private b g;
        private long h;

        private c(String str) {
            this.d = str;
            this.e = new long[a.this.h];
            this.f10226a = new File[a.this.h];
            this.f10227b = new File[a.this.h];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < a.this.h; i++) {
                append.append(i);
                this.f10226a[i] = new File(a.this.f10222b, append.toString());
                append.append(".tmp");
                this.f10227b[i] = new File(a.this.f10222b, append.toString());
                append.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.h) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.e[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f10226a[i];
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.e) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return this.f10227b[i];
        }
    }

    /* loaded from: classes5.dex */
    public final class d {

        /* renamed from: b  reason: collision with root package name */
        private final String f10229b;
        private final long c;
        private final long[] d;
        private final File[] e;

        private d(String str, long j, File[] fileArr, long[] jArr) {
            this.f10229b = str;
            this.c = j;
            this.e = fileArr;
            this.d = jArr;
        }

        public File a(int i) {
            return this.e[i];
        }
    }

    private a(File file, int i, int i2, long j) {
        this.f10222b = file;
        this.f = i;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = i2;
        this.g = j;
    }

    private synchronized b a(String str, long j) {
        c cVar;
        b bVar;
        f();
        c cVar2 = this.k.get(str);
        if (j == -1 || (cVar2 != null && cVar2.h == j)) {
            if (cVar2 == null) {
                c cVar3 = new c(str);
                this.k.put(str, cVar3);
                cVar = cVar3;
            } else if (cVar2.g != null) {
                bVar = null;
            } else {
                cVar = cVar2;
            }
            bVar = new b(cVar);
            cVar.g = bVar;
            this.j.append((CharSequence) "DIRTY");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            b(this.j);
        } else {
            bVar = null;
        }
        return bVar;
    }

    public static a a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
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
        if (aVar.c.exists()) {
            try {
                aVar.b();
                aVar.c();
                return aVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.a();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.d();
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b bVar, boolean z) {
        synchronized (this) {
            c cVar = bVar.f10225b;
            if (cVar.g != bVar) {
                throw new IllegalStateException();
            }
            if (z && !cVar.f) {
                for (int i = 0; i < this.h; i++) {
                    if (!bVar.c[i]) {
                        bVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!cVar.b(i).exists()) {
                        bVar.b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.h; i2++) {
                File b2 = cVar.b(i2);
                if (!z) {
                    a(b2);
                } else if (b2.exists()) {
                    File a2 = cVar.a(i2);
                    b2.renameTo(a2);
                    long j = cVar.e[i2];
                    long length = a2.length();
                    cVar.e[i2] = length;
                    this.i = (this.i - j) + length;
                }
            }
            this.l++;
            cVar.g = null;
            if (cVar.f || z) {
                cVar.f = true;
                this.j.append((CharSequence) "CLEAN");
                this.j.append(' ');
                this.j.append((CharSequence) cVar.d);
                this.j.append((CharSequence) cVar.a());
                this.j.append('\n');
                if (z) {
                    long j2 = this.m;
                    this.m = 1 + j2;
                    cVar.h = j2;
                }
            } else {
                this.k.remove(cVar.d);
                this.j.append((CharSequence) "REMOVE");
                this.j.append(' ');
                this.j.append((CharSequence) cVar.d);
                this.j.append('\n');
            }
            b(this.j);
            if (this.i > this.g || e()) {
                this.f10221a.submit(this.n);
            }
        }
    }

    private static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    private static void a(Writer writer) {
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
        com.kwad.sdk.glide.a.b bVar = new com.kwad.sdk.glide.a.b(new FileInputStream(this.c), com.kwad.sdk.glide.a.c.f10233a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f).equals(a4) || !Integer.toString(this.h).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i++;
                } catch (EOFException e) {
                    this.l = i - this.k.size();
                    if (bVar.b()) {
                        d();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), com.kwad.sdk.glide.a.c.f10233a));
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
    private static void b(Writer writer) {
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
        a(this.d);
        Iterator<c> it = this.k.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.g == null) {
                for (int i = 0; i < this.h; i++) {
                    this.i += next.e[i];
                }
            } else {
                next.g = null;
                for (int i2 = 0; i2 < this.h; i2++) {
                    a(next.a(i2));
                    a(next.b(i2));
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
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), com.kwad.sdk.glide.a.c.f10233a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.h));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (c cVar : this.k.values()) {
            if (cVar.g != null) {
                bufferedWriter.write("DIRTY " + cVar.d + '\n');
            } else {
                bufferedWriter.write("CLEAN " + cVar.d + cVar.a() + '\n');
            }
        }
        a(bufferedWriter);
        if (this.c.exists()) {
            a(this.c, this.e, true);
        }
        a(this.d, this.c, false);
        this.e.delete();
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), com.kwad.sdk.glide.a.c.f10233a));
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
            String substring2 = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.k.remove(substring2);
                return;
            }
            substring = substring2;
        } else {
            substring = str.substring(i, indexOf2);
        }
        c cVar = this.k.get(substring);
        if (cVar == null) {
            cVar = new c(substring);
            this.k.put(substring, cVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            cVar.f = true;
            cVar.g = null;
            cVar.a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            cVar.g = new b(cVar);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return this.l >= 2000 && this.l >= this.k.size();
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        while (this.i > this.g) {
            c(this.k.entrySet().iterator().next().getKey());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        r9.l++;
        r9.j.append((java.lang.CharSequence) "READ");
        r9.j.append(' ');
        r9.j.append((java.lang.CharSequence) r10);
        r9.j.append('\n');
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (e() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
        r9.f10221a.submit(r9.n);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        r1 = new com.kwad.sdk.glide.a.a.d(r9, r10, r0.h, r0.f10226a, r0.e, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized d a(String str) {
        d dVar = null;
        synchronized (this) {
            f();
            c cVar = this.k.get(str);
            if (cVar != null && cVar.f) {
                File[] fileArr = cVar.f10226a;
                int length = fileArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (!fileArr[i].exists()) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return dVar;
    }

    public void a() {
        close();
        com.kwad.sdk.glide.a.c.a(this.f10222b);
    }

    public b b(String str) {
        return a(str, -1L);
    }

    public synchronized boolean c(String str) {
        boolean z;
        synchronized (this) {
            f();
            c cVar = this.k.get(str);
            if (cVar == null || cVar.g != null) {
                z = false;
            } else {
                for (int i = 0; i < this.h; i++) {
                    File a2 = cVar.a(i);
                    if (a2.exists() && !a2.delete()) {
                        throw new IOException("failed to delete " + a2);
                    }
                    this.i -= cVar.e[i];
                    cVar.e[i] = 0;
                }
                this.l++;
                this.j.append((CharSequence) "REMOVE");
                this.j.append(' ');
                this.j.append((CharSequence) str);
                this.j.append('\n');
                this.k.remove(str);
                if (e()) {
                    this.f10221a.submit(this.n);
                }
                z = true;
            }
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.j != null) {
            Iterator it = new ArrayList(this.k.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.g != null) {
                    cVar.g.b();
                }
            }
            g();
            a(this.j);
            this.j = null;
        }
    }
}
