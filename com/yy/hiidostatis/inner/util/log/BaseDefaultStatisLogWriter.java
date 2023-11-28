package com.yy.hiidostatis.inner.util.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public class BaseDefaultStatisLogWriter implements IBaseStatisLogWriter {
    public static final int DEFAULT_LEN = 4194304;
    public static final int MAX_LOG_SIZE = 33554432;
    public static final int MIN_LOG_SIZE = 262144;
    public FileWriter fileWriter;
    public boolean isFileExist;
    public AtomicLong length;
    public String mFilePath;
    public int mLogMaxLen;
    public final boolean mWriteDebugLog;

    public BaseDefaultStatisLogWriter(String str, int i, boolean z) {
        this.mLogMaxLen = 4194304;
        this.isFileExist = false;
        this.fileWriter = null;
        this.length = new AtomicLong(0L);
        this.mFilePath = str;
        int min = Math.min(i, 33554432);
        this.mLogMaxLen = min;
        this.mLogMaxLen = Math.max(min, 262144);
        this.mWriteDebugLog = z;
    }

    public BaseDefaultStatisLogWriter(String str, boolean z) {
        this(str, 4194304, z);
    }

    @Override // com.yy.hiidostatis.inner.util.log.IBaseStatisLogWriter
    public void write(int i, String str) {
        writeLogOrThrow(str);
    }

    private FileWriter getFileWriter() {
        if (this.fileWriter != null && this.length.get() < this.mLogMaxLen) {
            return this.fileWriter;
        }
        synchronized (this) {
            if (this.fileWriter != null && this.length.get() < this.mLogMaxLen) {
                return this.fileWriter;
            }
            if (this.fileWriter != null) {
                try {
                    this.fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                File file = new File(this.mFilePath);
                if (file.length() > this.mLogMaxLen) {
                    File file2 = new File(this.mFilePath + "_pre.txt");
                    file2.delete();
                    if (!file.renameTo(file2) && !file.delete()) {
                        return null;
                    }
                    file = new File(this.mFilePath);
                }
                this.length.set(file.length());
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                if (!file.canWrite()) {
                    return null;
                }
                FileWriter fileWriter = new FileWriter(file, true);
                this.fileWriter = fileWriter;
                return fileWriter;
            } catch (IOException unused) {
                return null;
            }
        }
    }

    private boolean writeLogOrThrow(String str) {
        if (str != null && str.length() != 0) {
            try {
                FileWriter fileWriter = getFileWriter();
                this.fileWriter = fileWriter;
                if (fileWriter != null) {
                    fileWriter.write(str);
                    this.fileWriter.write("\n");
                    this.length.addAndGet(str.length() + 1);
                    this.fileWriter.flush();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.yy.hiidostatis.inner.util.log.IBaseStatisLogWriter
    public boolean outputDebug() {
        return this.mWriteDebugLog;
    }
}
