package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class LockableFileWriter extends Writer {
    private static final String LCK = ".lck";
    private final File lockFile;
    private final Writer out;

    public LockableFileWriter(String str) {
        this(str, false, (String) null);
    }

    public LockableFileWriter(String str, boolean z) {
        this(str, z, (String) null);
    }

    public LockableFileWriter(String str, boolean z, String str2) {
        this(new File(str), z, str2);
    }

    public LockableFileWriter(File file) {
        this(file, false, (String) null);
    }

    public LockableFileWriter(File file, boolean z) {
        this(file, z, (String) null);
    }

    public LockableFileWriter(File file, boolean z, String str) {
        this(file, Charset.defaultCharset(), z, str);
    }

    public LockableFileWriter(File file, Charset charset) {
        this(file, charset, false, (String) null);
    }

    public LockableFileWriter(File file, String str) {
        this(file, str, false, (String) null);
    }

    public LockableFileWriter(File file, Charset charset, boolean z, String str) {
        File absoluteFile = file.getAbsoluteFile();
        if (absoluteFile.getParentFile() != null) {
            FileUtils.forceMkdir(absoluteFile.getParentFile());
        }
        if (absoluteFile.isDirectory()) {
            throw new IOException("File specified is a directory");
        }
        File file2 = new File(str == null ? System.getProperty("java.io.tmpdir") : str);
        FileUtils.forceMkdir(file2);
        testLockDir(file2);
        this.lockFile = new File(file2, absoluteFile.getName() + LCK);
        createLock();
        this.out = initWriter(absoluteFile, charset, z);
    }

    public LockableFileWriter(File file, String str, boolean z, String str2) {
        this(file, Charsets.toCharset(str), z, str2);
    }

    private void testLockDir(File file) {
        if (!file.exists()) {
            throw new IOException("Could not find lockDir: " + file.getAbsolutePath());
        }
        if (!file.canWrite()) {
            throw new IOException("Could not write to lockDir: " + file.getAbsolutePath());
        }
    }

    private void createLock() {
        synchronized (LockableFileWriter.class) {
            if (!this.lockFile.createNewFile()) {
                throw new IOException("Can't write file, lock " + this.lockFile.getAbsolutePath() + " exists");
            }
            this.lockFile.deleteOnExit();
        }
    }

    private Writer initWriter(File file, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        boolean exists = file.exists();
        try {
            fileOutputStream = new FileOutputStream(file.getAbsolutePath(), z);
        } catch (IOException e) {
            e = e;
            fileOutputStream = null;
        } catch (RuntimeException e2) {
            e = e2;
            fileOutputStream = null;
        }
        try {
            return new OutputStreamWriter(fileOutputStream, Charsets.toCharset(charset));
        } catch (IOException e3) {
            e = e3;
            IOUtils.closeQuietly((Writer) null);
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
            FileUtils.deleteQuietly(this.lockFile);
            if (!exists) {
                FileUtils.deleteQuietly(file);
            }
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            IOUtils.closeQuietly((Writer) null);
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
            FileUtils.deleteQuietly(this.lockFile);
            if (!exists) {
                FileUtils.deleteQuietly(file);
            }
            throw e;
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.out.close();
        } finally {
            this.lockFile.delete();
        }
    }

    @Override // java.io.Writer
    public void write(int i) {
        this.out.write(i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.out.write(cArr);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        this.out.write(cArr, i, i2);
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.out.write(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.out.write(str, i, i2);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        this.out.flush();
    }
}
