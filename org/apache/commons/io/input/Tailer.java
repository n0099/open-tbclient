package org.apache.commons.io.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file, TailerListener tailerListener) {
        this(file, tailerListener, 1000L);
    }

    public Tailer(File file, TailerListener tailerListener, long j) {
        this(file, tailerListener, j, false);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z) {
        this(file, tailerListener, j, z, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, boolean z2) {
        this(file, tailerListener, j, z, z2, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, int i) {
        this(file, tailerListener, j, z, false, i);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this.run = true;
        this.file = file;
        this.delayMillis = j;
        this.end = z;
        this.inbuf = new byte[i];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z2;
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, int i) {
        Tailer tailer = new Tailer(file, tailerListener, j, z, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        Tailer tailer = new Tailer(file, tailerListener, j, z, z2, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z) {
        return create(file, tailerListener, j, z, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, boolean z2) {
        return create(file, tailerListener, j, z, z2, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j) {
        return create(file, tailerListener, j, false);
    }

    public static Tailer create(File file, TailerListener tailerListener) {
        return create(file, tailerListener, 1000L, false);
    }

    public File getFile() {
        return this.file;
    }

    public long getDelay() {
        return this.delayMillis;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        long j;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        RandomAccessFile randomAccessFile4 = null;
        long j2 = 0;
        long j3 = 0;
        while (this.run && randomAccessFile4 == null) {
            try {
                try {
                    try {
                        randomAccessFile4 = new RandomAccessFile(this.file, RAF_MODE);
                    } catch (FileNotFoundException e) {
                        this.listener.fileNotFound();
                    }
                    if (randomAccessFile4 == null) {
                        try {
                            Thread.sleep(this.delayMillis);
                        } catch (InterruptedException e2) {
                        }
                    } else {
                        j2 = this.end ? this.file.length() : 0L;
                        j3 = System.currentTimeMillis();
                        randomAccessFile4.seek(j2);
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        while (this.run) {
            boolean isFileNewer = FileUtils.isFileNewer(this.file, j3);
            long length = this.file.length();
            if (length < j2) {
                this.listener.fileRotated();
                try {
                    randomAccessFile2 = new RandomAccessFile(this.file, RAF_MODE);
                } catch (FileNotFoundException e4) {
                    long j4 = j2;
                    randomAccessFile = randomAccessFile4;
                    j = j4;
                }
                try {
                    IOUtils.closeQuietly(randomAccessFile4);
                    j2 = 0;
                    randomAccessFile4 = randomAccessFile2;
                } catch (FileNotFoundException e5) {
                    randomAccessFile = randomAccessFile2;
                    j = 0;
                    try {
                        this.listener.fileNotFound();
                        randomAccessFile4 = randomAccessFile;
                        j2 = j;
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile4 = randomAccessFile;
                        this.listener.handle(e);
                        IOUtils.closeQuietly(randomAccessFile4);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile4 = randomAccessFile;
                        IOUtils.closeQuietly(randomAccessFile4);
                        throw th;
                    }
                } catch (Exception e7) {
                    randomAccessFile4 = randomAccessFile2;
                    e = e7;
                    this.listener.handle(e);
                    IOUtils.closeQuietly(randomAccessFile4);
                    return;
                } catch (Throwable th3) {
                    randomAccessFile4 = randomAccessFile2;
                    th = th3;
                    IOUtils.closeQuietly(randomAccessFile4);
                    throw th;
                }
            } else {
                if (length > j2) {
                    j2 = readLines(randomAccessFile4);
                    j3 = System.currentTimeMillis();
                } else if (isFileNewer) {
                    randomAccessFile4.seek(0L);
                    j2 = readLines(randomAccessFile4);
                    j3 = System.currentTimeMillis();
                }
                if (this.reOpen) {
                    IOUtils.closeQuietly(randomAccessFile4);
                }
                try {
                    Thread.sleep(this.delayMillis);
                } catch (InterruptedException e8) {
                }
                if (this.run && this.reOpen) {
                    randomAccessFile3 = new RandomAccessFile(this.file, RAF_MODE);
                    try {
                        randomAccessFile3.seek(j2);
                    } catch (Exception e9) {
                        randomAccessFile4 = randomAccessFile3;
                        e = e9;
                        this.listener.handle(e);
                        IOUtils.closeQuietly(randomAccessFile4);
                        return;
                    } catch (Throwable th4) {
                        randomAccessFile4 = randomAccessFile3;
                        th = th4;
                        IOUtils.closeQuietly(randomAccessFile4);
                        throw th;
                    }
                } else {
                    randomAccessFile3 = randomAccessFile4;
                }
                randomAccessFile4 = randomAccessFile3;
            }
        }
        IOUtils.closeQuietly(randomAccessFile4);
    }

    public void stop() {
        this.run = false;
    }

    private long readLines(RandomAccessFile randomAccessFile) {
        int read;
        StringBuilder sb = new StringBuilder();
        long filePointer = randomAccessFile.getFilePointer();
        boolean z = false;
        long j = filePointer;
        while (this.run && (read = randomAccessFile.read(this.inbuf)) != -1) {
            for (int i = 0; i < read; i++) {
                byte b = this.inbuf[i];
                switch (b) {
                    case 10:
                        this.listener.handle(sb.toString());
                        sb.setLength(0);
                        filePointer = i + j + 1;
                        z = false;
                        break;
                    case 11:
                    case 12:
                    default:
                        if (z) {
                            this.listener.handle(sb.toString());
                            sb.setLength(0);
                            filePointer = i + j + 1;
                            z = false;
                        }
                        sb.append((char) b);
                        break;
                    case 13:
                        if (z) {
                            sb.append('\r');
                        }
                        z = true;
                        break;
                }
            }
            j = randomAccessFile.getFilePointer();
        }
        randomAccessFile.seek(filePointer);
        return filePointer;
    }
}
