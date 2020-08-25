package tv.chushou.zues.toolkit.a.a;

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
/* loaded from: classes6.dex */
public final class a implements Closeable {
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream oMI = new OutputStream() { // from class: tv.chushou.zues.toolkit.a.a.a.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private final int appVersion;
    private final File directory;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private long maxSize;
    private Writer oMF;
    private int redundantOpCount;
    private final int valueCount;
    private long size = 0;
    private final LinkedHashMap<String, b> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    final ThreadPoolExecutor oMG = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> oMH = new Callable<Void>() { // from class: tv.chushou.zues.toolkit.a.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.oMF != null) {
                    a.this.trimToSize();
                    if (a.this.journalRebuildRequired()) {
                        a.this.rebuildJournal();
                        a.this.redundantOpCount = 0;
                    }
                }
            }
            return null;
        }
    };

    private a(File file, int i, int i2, long j) {
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = i2;
        this.maxSize = j;
    }

    public static a b(File file, int i, int i2, long j) throws IOException {
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
                b(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j);
        if (aVar.journalFile.exists()) {
            try {
                aVar.readJournal();
                aVar.processJournal();
                return aVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.delete();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.rebuildJournal();
        return aVar2;
    }

    private void readJournal() throws IOException {
        tv.chushou.zues.toolkit.a.a.b bVar = new tv.chushou.zues.toolkit.a.a.b(new FileInputStream(this.journalFile), tv.chushou.zues.toolkit.a.a.c.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.appVersion).equals(readLine3) || !Integer.toString(this.valueCount).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(bVar.readLine());
                    i++;
                } catch (EOFException e) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (bVar.emf()) {
                        rebuildJournal();
                    } else {
                        this.oMF = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), tv.chushou.zues.toolkit.a.a.c.US_ASCII));
                    }
                    tv.chushou.zues.toolkit.a.a.c.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            tv.chushou.zues.toolkit.a.a.c.closeQuietly(bVar);
            throw th;
        }
    }

    private void readJournalLine(String str) throws IOException {
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
                this.lruEntries.remove(substring2);
                return;
            }
            substring = substring2;
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.lruEntries.get(substring);
        if (bVar == null) {
            bVar = new b(substring);
            this.lruEntries.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.readable = true;
            bVar.oMN = null;
            bVar.setLengths(split);
        } else if (indexOf2 != -1 || indexOf != "DIRTY".length() || !str.startsWith("DIRTY")) {
            if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            bVar.oMN = new C1010a(bVar);
        }
    }

    private void processJournal() throws IOException {
        au(this.journalFileTmp);
        Iterator<b> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.oMN == null) {
                for (int i = 0; i < this.valueCount; i++) {
                    this.size += next.lengths[i];
                }
            } else {
                next.oMN = null;
                for (int i2 = 0; i2 < this.valueCount; i2++) {
                    au(next.OA(i2));
                    au(next.OB(i2));
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rebuildJournal() throws IOException {
        if (this.oMF != null) {
            this.oMF.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), tv.chushou.zues.toolkit.a.a.c.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.appVersion));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.valueCount));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.lruEntries.values()) {
            if (bVar.oMN != null) {
                bufferedWriter.write("DIRTY " + bVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + bVar.key + bVar.eme() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.journalFile.exists()) {
            b(this.journalFile, this.journalFileBackup, true);
        }
        b(this.journalFileTmp, this.journalFile, false);
        this.journalFileBackup.delete();
        this.oMF = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), tv.chushou.zues.toolkit.a.a.c.US_ASCII));
    }

    private static void au(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void b(File file, File file2, boolean z) throws IOException {
        if (z) {
            au(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized c WR(String str) throws IOException {
        c cVar = null;
        synchronized (this) {
            checkNotClosed();
            validateKey(str);
            b bVar = this.lruEntries.get(str);
            if (bVar != null && bVar.readable) {
                InputStream[] inputStreamArr = new InputStream[this.valueCount];
                for (int i = 0; i < this.valueCount; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(bVar.OA(i));
                    } catch (FileNotFoundException e) {
                        for (int i2 = 0; i2 < this.valueCount && inputStreamArr[i2] != null; i2++) {
                            tv.chushou.zues.toolkit.a.a.c.closeQuietly(inputStreamArr[i2]);
                        }
                    }
                }
                this.redundantOpCount++;
                this.oMF.append((CharSequence) ("READ " + str + '\n'));
                if (journalRebuildRequired()) {
                    this.oMG.submit(this.oMH);
                }
                cVar = new c(str, bVar.sequenceNumber, inputStreamArr, bVar.lengths);
            }
        }
        return cVar;
    }

    public C1010a WS(String str) throws IOException {
        return O(str, -1L);
    }

    private synchronized C1010a O(String str, long j) throws IOException {
        b bVar;
        C1010a c1010a;
        checkNotClosed();
        validateKey(str);
        b bVar2 = this.lruEntries.get(str);
        if (j == -1 || (bVar2 != null && bVar2.sequenceNumber == j)) {
            if (bVar2 == null) {
                b bVar3 = new b(str);
                this.lruEntries.put(str, bVar3);
                bVar = bVar3;
            } else if (bVar2.oMN != null) {
                c1010a = null;
            } else {
                bVar = bVar2;
            }
            c1010a = new C1010a(bVar);
            bVar.oMN = c1010a;
            this.oMF.write("DIRTY " + str + '\n');
            this.oMF.flush();
        } else {
            c1010a = null;
        }
        return c1010a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C1010a c1010a, boolean z) throws IOException {
        synchronized (this) {
            b bVar = c1010a.oMK;
            if (bVar.oMN != c1010a) {
                throw new IllegalStateException();
            }
            if (z && !bVar.readable) {
                for (int i = 0; i < this.valueCount; i++) {
                    if (!c1010a.written[i]) {
                        c1010a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!bVar.OB(i).exists()) {
                        c1010a.abort();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.valueCount; i2++) {
                File OB = bVar.OB(i2);
                if (z) {
                    if (OB.exists()) {
                        File OA = bVar.OA(i2);
                        OB.renameTo(OA);
                        long j = bVar.lengths[i2];
                        long length = OA.length();
                        bVar.lengths[i2] = length;
                        this.size = (this.size - j) + length;
                    }
                } else {
                    au(OB);
                }
            }
            this.redundantOpCount++;
            bVar.oMN = null;
            if (bVar.readable | z) {
                bVar.readable = true;
                this.oMF.write("CLEAN " + bVar.key + bVar.eme() + '\n');
                if (z) {
                    long j2 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j2;
                    bVar.sequenceNumber = j2;
                }
            } else {
                this.lruEntries.remove(bVar.key);
                this.oMF.write("REMOVE " + bVar.key + '\n');
            }
            this.oMF.flush();
            if (this.size > this.maxSize || journalRebuildRequired()) {
                this.oMG.submit(this.oMH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public synchronized boolean remove(String str) throws IOException {
        boolean z;
        synchronized (this) {
            checkNotClosed();
            validateKey(str);
            b bVar = this.lruEntries.get(str);
            if (bVar == null || bVar.oMN != null) {
                z = false;
            } else {
                for (int i = 0; i < this.valueCount; i++) {
                    File OA = bVar.OA(i);
                    if (OA.exists() && !OA.delete()) {
                        throw new IOException("failed to delete " + OA);
                    }
                    this.size -= bVar.lengths[i];
                    bVar.lengths[i] = 0;
                }
                this.redundantOpCount++;
                this.oMF.append((CharSequence) ("REMOVE " + str + '\n'));
                this.lruEntries.remove(str);
                if (journalRebuildRequired()) {
                    this.oMG.submit(this.oMH);
                }
                z = true;
            }
        }
        return z;
    }

    private void checkNotClosed() {
        if (this.oMF == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.oMF != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.oMN != null) {
                    bVar.oMN.abort();
                }
            }
            trimToSize();
            this.oMF.close();
            this.oMF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    public void delete() throws IOException {
        close();
        tv.chushou.zues.toolkit.a.a.c.deleteContents(this.directory);
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements Closeable {
        private final String key;
        private final long[] lengths;
        private final InputStream[] oMO;
        private final long sequenceNumber;

        private c(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.oMO = inputStreamArr;
            this.lengths = jArr;
        }

        public InputStream OC(int i) {
            return this.oMO[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.oMO) {
                tv.chushou.zues.toolkit.a.a.c.closeQuietly(inputStream);
            }
        }
    }

    /* renamed from: tv.chushou.zues.toolkit.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1010a {
        private boolean hasErrors;
        private final b oMK;
        private boolean oML;
        private final boolean[] written;

        private C1010a(b bVar) {
            this.oMK = bVar;
            this.written = bVar.readable ? null : new boolean[a.this.valueCount];
        }

        public OutputStream Oz(int i) throws IOException {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i < 0 || i >= a.this.valueCount) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + a.this.valueCount);
            }
            synchronized (a.this) {
                if (this.oMK.oMN != this) {
                    throw new IllegalStateException();
                }
                if (!this.oMK.readable) {
                    this.written[i] = true;
                }
                File OB = this.oMK.OB(i);
                try {
                    fileOutputStream = new FileOutputStream(OB);
                } catch (FileNotFoundException e) {
                    a.this.directory.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(OB);
                    } catch (FileNotFoundException e2) {
                        outputStream = a.oMI;
                    }
                }
                outputStream = new C1011a(fileOutputStream);
            }
            return outputStream;
        }

        public void commit() throws IOException {
            if (this.hasErrors) {
                a.this.a(this, false);
                a.this.remove(this.oMK.key);
            } else {
                a.this.a(this, true);
            }
            this.oML = true;
        }

        public void abort() throws IOException {
            a.this.a(this, false);
        }

        /* renamed from: tv.chushou.zues.toolkit.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private class C1011a extends FilterOutputStream {
            private C1011a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C1010a.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C1010a.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C1010a.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C1010a.this.hasErrors = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b {
        private final String key;
        private final long[] lengths;
        private C1010a oMN;
        private boolean readable;
        private long sequenceNumber;

        private b(String str) {
            this.key = str;
            this.lengths = new long[a.this.valueCount];
        }

        public String eme() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.lengths) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length != a.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw invalidLengths(strArr);
                }
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File OA(int i) {
            return new File(a.this.directory, this.key + "." + i);
        }

        public File OB(int i) {
            return new File(a.this.directory, this.key + "." + i + ".tmp");
        }
    }
}
