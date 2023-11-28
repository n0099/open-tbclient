package com.kwad.sdk.core.diskcache.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kwad.sdk.utils.q;
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
/* loaded from: classes10.dex */
public final class a implements Closeable {
    public final File arA;
    public final File arB;
    public final File arC;
    public final int arD;
    public int arE;
    public final int arF;
    public Writer arH;
    public int arJ;
    public final File arz;
    public long maxSize;
    public static final Pattern ary = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final OutputStream arN = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    public long size = 0;
    public int arG = 0;
    public final LinkedHashMap<String, b> arI = new LinkedHashMap<>(0, 0.75f, true);
    public long arK = 0;
    public final ThreadPoolExecutor arL = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        public final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    public final Callable<Void> arM = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: BI */
        public Void call() {
            synchronized (a.this) {
                if (a.this.arH == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.BO();
                if (a.this.BN()) {
                    a.this.BL();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public final class C0701a {
        public final b arP;
        public final boolean[] arQ;
        public boolean arR;
        public boolean arS;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0702a extends FilterOutputStream {
            public C0702a(OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0702a(C0701a c0701a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0701a.b(C0701a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0701a.b(C0701a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0701a.b(C0701a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0701a.b(C0701a.this, true);
                }
            }
        }

        public C0701a(b bVar) {
            boolean[] zArr;
            this.arP = bVar;
            if (bVar.arV) {
                zArr = null;
            } else {
                zArr = new boolean[a.this.arF];
            }
            this.arQ = zArr;
        }

        public static /* synthetic */ boolean b(C0701a c0701a, boolean z) {
            c0701a.arR = true;
            return true;
        }

        public /* synthetic */ C0701a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.arR) {
                a.this.a(this, false);
                a.this.remove(this.arP.key);
            } else {
                a.this.a(this, true);
            }
            this.arS = true;
        }

        public final OutputStream cm(int i) {
            FileOutputStream fileOutputStream;
            C0702a c0702a;
            synchronized (a.this) {
                if (this.arP.arW == this) {
                    if (!this.arP.arV) {
                        this.arQ[0] = true;
                    }
                    File co = this.arP.co(0);
                    try {
                        fileOutputStream = new FileOutputStream(co);
                    } catch (FileNotFoundException unused) {
                        a.this.arz.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(co);
                        } catch (FileNotFoundException unused2) {
                            return a.arN;
                        }
                    }
                    c0702a = new C0702a(this, fileOutputStream, (byte) 0);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0702a;
        }
    }

    /* loaded from: classes10.dex */
    public final class b {
        public final long[] arU;
        public boolean arV;
        public C0701a arW;
        public long arX;
        public final String key;

        public b(String str) {
            this.key = str;
            this.arU = new long[a.this.arF];
        }

        public /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.arF) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.arU[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw c(strArr);
                    }
                }
                return;
            }
            throw c(strArr);
        }

        public static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File cn(int i) {
            File file = a.this.arz;
            return new File(file, this.key + i);
        }

        public final File co(int i) {
            File file = a.this.arz;
            return new File(file, this.key + i + ".tmp");
        }

        public static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.arV = true;
            return true;
        }

        public final String BQ() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.arU) {
                sb.append(WebvttCueParser.CHAR_SPACE);
                sb.append(j);
            }
            return sb.toString();
        }
    }

    /* loaded from: classes10.dex */
    public final class c implements Closeable {
        public final long[] arU;
        public final long arX;
        public File[] arY;
        public final InputStream[] arZ;
        public final String key;

        public c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.arX = j;
            this.arY = fileArr;
            this.arZ = inputStreamArr;
            this.arU = jArr;
        }

        public /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.arZ) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File cp(int i) {
            return this.arY[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BN() {
        int i = this.arJ;
        if (i >= 2000 && i >= this.arI.size()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO() {
        while (this.arG > this.arE) {
            remove(this.arI.entrySet().iterator().next().getKey());
        }
    }

    private void checkNotClosed() {
        if (this.arH != null) {
            return;
        }
        throw new IllegalStateException("cache is closed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.arI.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized int BM() {
        return this.arE;
    }

    public final void delete() {
        close();
        q.deleteContents(this.arz);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        BO();
        this.arH.flush();
    }

    public final File getDirectory() {
        return this.arz;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public a(File file, int i, int i2, long j, int i3) {
        this.arz = file;
        this.arD = i;
        this.arA = new File(file, "journal");
        this.arB = new File(file, "journal.tmp");
        this.arC = new File(file, "journal.bkp");
        this.arF = i2;
        this.maxSize = j;
        this.arE = i3;
    }

    private void BJ() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.arA), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && "1".equals(readLine2) && Integer.toString(this.arD).equals(readLine3) && Integer.toString(this.arF).equals(readLine4) && "".equals(readLine5)) {
                int i = 0;
                while (true) {
                    try {
                        cP(bVar.readLine());
                        i++;
                    } catch (EOFException unused) {
                        this.arJ = i - this.arI.size();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + readLine + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine5 + PreferencesUtil.RIGHT_MOUNT);
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void BK() {
        p(this.arB);
        Iterator<b> it = this.arI.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.arW != null) {
                next.arW = null;
                while (i < this.arF) {
                    p(next.cn(i));
                    p(next.co(i));
                    i++;
                }
                it.remove();
            } else {
                while (i < this.arF) {
                    this.size += next.arU[i];
                    this.arG++;
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void BL() {
        if (this.arH != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.arH);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.arB), com.kwad.sdk.crash.utils.a.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.arD));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.arF));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.arI.values()) {
            if (bVar.arW != null) {
                bufferedWriter.write("DIRTY " + bVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + bVar.key + bVar.BQ() + '\n');
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
        if (this.arA.exists()) {
            a(this.arA, this.arC, true);
        }
        a(this.arB, this.arA, false);
        this.arC.delete();
        this.arH = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.arA, true), com.kwad.sdk.crash.utils.a.US_ASCII));
    }

    public static /* synthetic */ int a(a aVar, int i) {
        aVar.arJ = 0;
        return 0;
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
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
                    if (aVar.arA.exists()) {
                        try {
                            aVar.BJ();
                            aVar.BK();
                            aVar.arH = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.arA, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                            return aVar;
                        } catch (IOException e) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                            aVar.delete();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i, i2, j, i3);
                    aVar2.BL();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void cS(String str) {
        if (ary.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    public static void p(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final C0701a cR(String str) {
        return c(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0701a c0701a, boolean z) {
        b bVar = c0701a.arP;
        if (bVar.arW == c0701a) {
            if (z && !bVar.arV) {
                for (int i = 0; i < this.arF; i++) {
                    if (c0701a.arQ[i]) {
                        if (!bVar.co(i).exists()) {
                            c0701a.abort();
                            return;
                        }
                    } else {
                        c0701a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.arF; i2++) {
                File co = bVar.co(i2);
                if (z) {
                    if (co.exists()) {
                        File cn2 = bVar.cn(i2);
                        co.renameTo(cn2);
                        long j = bVar.arU[i2];
                        long length = cn2.length();
                        bVar.arU[i2] = length;
                        this.size = (this.size - j) + length;
                        this.arG++;
                    }
                } else {
                    p(co);
                }
            }
            this.arJ++;
            bVar.arW = null;
            if (bVar.arV | z) {
                b.a(bVar, true);
                this.arH.write("CLEAN " + bVar.key + bVar.BQ() + '\n');
                if (z) {
                    long j2 = this.arK;
                    this.arK = 1 + j2;
                    bVar.arX = j2;
                }
            } else {
                this.arI.remove(bVar.key);
                this.arH.write("REMOVE " + bVar.key + '\n');
            }
            this.arH.flush();
            if (this.size > this.maxSize || this.arG > this.arE || BN()) {
                this.arL.submit(this.arM);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static void a(File file, File file2, boolean z) {
        if (z) {
            p(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException();
    }

    private synchronized C0701a c(String str, long j) {
        checkNotClosed();
        cS(str);
        b bVar = this.arI.get(str);
        if (bVar == null) {
            bVar = new b(this, str, (byte) 0);
            this.arI.put(str, bVar);
        } else if (bVar.arW != null) {
            return null;
        }
        C0701a c0701a = new C0701a(this, bVar, (byte) 0);
        bVar.arW = c0701a;
        Writer writer = this.arH;
        writer.write("DIRTY " + str + '\n');
        this.arH.flush();
        return c0701a;
    }

    private void cP(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.arI.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            b bVar = this.arI.get(substring);
            if (bVar == null) {
                bVar = new b(this, substring, (byte) 0);
                this.arI.put(substring, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                b.a(bVar, true);
                bVar.arW = null;
                bVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.arW = new C0701a(this, bVar, (byte) 0);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized c cQ(String str) {
        if (this.arH == null) {
            return null;
        }
        cS(str);
        b bVar = this.arI.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.arV) {
            return null;
        }
        File[] fileArr = new File[this.arF];
        InputStream[] inputStreamArr = new InputStream[this.arF];
        for (int i = 0; i < this.arF; i++) {
            try {
                File cn2 = bVar.cn(i);
                fileArr[i] = cn2;
                inputStreamArr[i] = new FileInputStream(cn2);
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.arF && inputStreamArr[i2] != null; i2++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamArr[i2]);
                }
                return null;
            }
        }
        this.arJ++;
        this.arH.append((CharSequence) ("READ " + str + '\n'));
        if (BN()) {
            this.arL.submit(this.arM);
        }
        return new c(this, str, bVar.arX, fileArr, inputStreamArr, bVar.arU, (byte) 0);
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        cS(str);
        b bVar = this.arI.get(str);
        if (bVar != null && bVar.arW == null) {
            for (int i = 0; i < this.arF; i++) {
                File cn2 = bVar.cn(i);
                if (cn2.exists() && !cn2.delete()) {
                    throw new IOException("failed to delete " + cn2);
                }
                this.size -= bVar.arU[i];
                this.arG--;
                bVar.arU[i] = 0;
            }
            this.arJ++;
            this.arH.append((CharSequence) ("REMOVE " + str + '\n'));
            this.arI.remove(str);
            if (BN()) {
                this.arL.submit(this.arM);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.arH == null) {
            return;
        }
        Iterator it = new ArrayList(this.arI.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.arW != null) {
                bVar.arW.abort();
            }
        }
        trimToSize();
        BO();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.arH);
        this.arH = null;
    }
}
