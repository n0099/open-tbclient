package com.kwad.sdk.core.diskcache.kwai;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kwad.sdk.utils.o;
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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class a implements Closeable {
    public static final Pattern VZ = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final OutputStream Wo = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    public final File Wa;
    public final File Wb;
    public final File Wc;
    public final File Wd;
    public final int We;
    public int Wf;
    public final int Wg;
    public Writer Wi;
    public int Wk;
    public long maxSize;
    public long size = 0;
    public int Wh = 0;
    public final LinkedHashMap<String, b> Wj = new LinkedHashMap<>(0, 0.75f, true);
    public long Wl = 0;
    public final ThreadPoolExecutor Wm = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.kwai.a.1
        public final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    public final Callable<Void> Wn = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: sH */
        public Void call() {
            synchronized (a.this) {
                if (a.this.Wi == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.sO();
                if (a.this.sN()) {
                    a.this.sL();
                    a.this.Wk = 0;
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C0609a {
        public final b Wq;
        public final boolean[] Wr;
        public boolean Ws;
        public boolean Wt;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0610a extends FilterOutputStream {
            public C0610a(OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0610a(C0609a c0609a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0609a.this.Ws = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0609a.this.Ws = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0609a.this.Ws = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0609a.this.Ws = true;
                }
            }
        }

        public C0609a(b bVar) {
            this.Wq = bVar;
            this.Wr = bVar.Ww ? null : new boolean[a.this.Wg];
        }

        public /* synthetic */ C0609a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final OutputStream au(int i) {
            FileOutputStream fileOutputStream;
            C0610a c0610a;
            synchronized (a.this) {
                if (this.Wq.Wx != this) {
                    throw new IllegalStateException();
                }
                if (!this.Wq.Ww) {
                    this.Wr[0] = true;
                }
                File aw = this.Wq.aw(0);
                try {
                    fileOutputStream = new FileOutputStream(aw);
                } catch (FileNotFoundException unused) {
                    a.this.Wa.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(aw);
                    } catch (FileNotFoundException unused2) {
                        return a.Wo;
                    }
                }
                c0610a = new C0610a(this, fileOutputStream, (byte) 0);
            }
            return c0610a;
        }

        public final void commit() {
            if (this.Ws) {
                a.this.a(this, false);
                a.this.remove(this.Wq.key);
            } else {
                a.this.a(this, true);
            }
            this.Wt = true;
        }
    }

    /* loaded from: classes8.dex */
    public final class b {
        public final long[] Wv;
        public boolean Ww;
        public C0609a Wx;
        public long Wy;
        public final String key;

        public b(String str) {
            this.key = str;
            this.Wv = new long[a.this.Wg];
        }

        public /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length != a.this.Wg) {
                throw c(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.Wv[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        public static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File av(int i) {
            File file = a.this.Wa;
            return new File(file, this.key + i);
        }

        public final File aw(int i) {
            File file = a.this.Wa;
            return new File(file, this.key + i + ".tmp");
        }

        public final String sQ() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.Wv) {
                sb.append(WebvttCueParser.CHAR_SPACE);
                sb.append(j);
            }
            return sb.toString();
        }
    }

    /* loaded from: classes8.dex */
    public final class c implements Closeable {
        public final InputStream[] WA;
        public final long[] Wv;
        public final long Wy;
        public File[] Wz;
        public final String key;

        public c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.Wy = j;
            this.Wz = fileArr;
            this.WA = inputStreamArr;
            this.Wv = jArr;
        }

        public /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        public final File ax(int i) {
            return this.Wz[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.WA) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
    }

    public a(File file, int i, int i2, long j, int i3) {
        this.Wa = file;
        this.We = i;
        this.Wb = new File(file, "journal");
        this.Wc = new File(file, "journal.tmp");
        this.Wd = new File(file, "journal.bkp");
        this.Wg = i2;
        this.maxSize = j;
        this.Wf = i3;
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, i, 1, j, Integer.MAX_VALUE);
    }

    public static a a(File file, int i, int i2, long j, int i3) {
        if (j > 0) {
            if (i3 > 0) {
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
                    a aVar = new a(file, i, i2, j, i3);
                    if (aVar.Wb.exists()) {
                        try {
                            aVar.sJ();
                            aVar.sK();
                            aVar.Wi = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.Wb, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                            return aVar;
                        } catch (IOException e) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                            aVar.delete();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i, i2, j, i3);
                    aVar2.sL();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0609a c0609a, boolean z) {
        b bVar = c0609a.Wq;
        if (bVar.Wx != c0609a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.Ww) {
            for (int i = 0; i < this.Wg; i++) {
                if (!c0609a.Wr[i]) {
                    c0609a.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!bVar.aw(i).exists()) {
                    c0609a.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.Wg; i2++) {
            File aw = bVar.aw(i2);
            if (!z) {
                l(aw);
            } else if (aw.exists()) {
                File av = bVar.av(i2);
                aw.renameTo(av);
                long j = bVar.Wv[i2];
                long length = av.length();
                bVar.Wv[i2] = length;
                this.size = (this.size - j) + length;
                this.Wh++;
            }
        }
        this.Wk++;
        bVar.Wx = null;
        if (bVar.Ww || z) {
            bVar.Ww = true;
            this.Wi.write("CLEAN " + bVar.key + bVar.sQ() + '\n');
            if (z) {
                long j2 = this.Wl;
                this.Wl = 1 + j2;
                bVar.Wy = j2;
            }
        } else {
            this.Wj.remove(bVar.key);
            this.Wi.write("REMOVE " + bVar.key + '\n');
        }
        this.Wi.flush();
        if (this.size > this.maxSize || this.Wh > this.Wf || sN()) {
            this.Wm.submit(this.Wn);
        }
    }

    public static void a(File file, File file2, boolean z) {
        if (z) {
            l(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void bw(String str) {
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
                this.Wj.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.Wj.get(substring);
        if (bVar == null) {
            bVar = new b(this, substring, (byte) 0);
            this.Wj.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.Ww = true;
            bVar.Wx = null;
            bVar.b(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.Wx = new C0609a(this, bVar, (byte) 0);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public static void bz(String str) {
        if (VZ.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private synchronized C0609a c(String str, long j) {
        checkNotClosed();
        bz(str);
        b bVar = this.Wj.get(str);
        if (bVar == null) {
            bVar = new b(this, str, (byte) 0);
            this.Wj.put(str, bVar);
        } else if (bVar.Wx != null) {
            return null;
        }
        C0609a c0609a = new C0609a(this, bVar, (byte) 0);
        bVar.Wx = c0609a;
        Writer writer = this.Wi;
        writer.write("DIRTY " + str + '\n');
        this.Wi.flush();
        return c0609a;
    }

    private void checkNotClosed() {
        if (this.Wi == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static void l(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private void sJ() {
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.Wb), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.We).equals(readLine3) || !Integer.toString(this.Wg).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine5 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i = 0;
            while (true) {
                try {
                    bw(bVar.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.Wk = i - this.Wj.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void sK() {
        l(this.Wc);
        Iterator<b> it = this.Wj.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.Wx == null) {
                while (i < this.Wg) {
                    this.size += next.Wv[i];
                    this.Wh++;
                    i++;
                }
            } else {
                next.Wx = null;
                while (i < this.Wg) {
                    l(next.av(i));
                    l(next.aw(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sL() {
        if (this.Wi != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.Wi);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.Wc), com.kwad.sdk.crash.utils.a.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.We));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.Wg));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.Wj.values()) {
            bufferedWriter.write(bVar.Wx != null ? "DIRTY " + bVar.key + '\n' : "CLEAN " + bVar.key + bVar.sQ() + '\n');
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
        if (this.Wb.exists()) {
            a(this.Wb, this.Wd, true);
        }
        a(this.Wc, this.Wb, false);
        this.Wd.delete();
        this.Wi = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.Wb, true), com.kwad.sdk.crash.utils.a.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sN() {
        int i = this.Wk;
        return i >= 2000 && i >= this.Wj.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sO() {
        while (this.Wh > this.Wf) {
            remove(this.Wj.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.Wj.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized c bx(String str) {
        checkNotClosed();
        bz(str);
        b bVar = this.Wj.get(str);
        if (bVar == null) {
            return null;
        }
        if (bVar.Ww) {
            File[] fileArr = new File[this.Wg];
            InputStream[] inputStreamArr = new InputStream[this.Wg];
            for (int i = 0; i < this.Wg; i++) {
                try {
                    File av = bVar.av(i);
                    fileArr[i] = av;
                    inputStreamArr[i] = new FileInputStream(av);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.Wg && inputStreamArr[i2] != null; i2++) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.Wk++;
            this.Wi.append((CharSequence) ("READ " + str + '\n'));
            if (sN()) {
                this.Wm.submit(this.Wn);
            }
            return new c(this, str, bVar.Wy, fileArr, inputStreamArr, bVar.Wv, (byte) 0);
        }
        return null;
    }

    public final C0609a by(String str) {
        return c(str, -1L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.Wi == null) {
            return;
        }
        Iterator it = new ArrayList(this.Wj.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.Wx != null) {
                bVar.Wx.abort();
            }
        }
        trimToSize();
        sO();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.Wi);
        this.Wi = null;
    }

    public final void delete() {
        close();
        o.deleteContents(this.Wa);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        sO();
        this.Wi.flush();
    }

    public final File getDirectory() {
        return this.Wa;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        bz(str);
        b bVar = this.Wj.get(str);
        if (bVar != null && bVar.Wx == null) {
            for (int i = 0; i < this.Wg; i++) {
                File av = bVar.av(i);
                if (av.exists() && !av.delete()) {
                    throw new IOException("failed to delete " + av);
                }
                this.size -= bVar.Wv[i];
                this.Wh--;
                bVar.Wv[i] = 0;
            }
            this.Wk++;
            this.Wi.append((CharSequence) ("REMOVE " + str + '\n'));
            this.Wj.remove(str);
            if (sN()) {
                this.Wm.submit(this.Wn);
            }
            return true;
        }
        return false;
    }

    public final synchronized int sM() {
        return this.Wf;
    }
}
