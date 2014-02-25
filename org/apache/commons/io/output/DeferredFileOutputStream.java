package org.apache.commons.io.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class DeferredFileOutputStream extends ThresholdingOutputStream {
    private boolean closed;
    private OutputStream currentOutputStream;
    private final File directory;
    private ByteArrayOutputStream memoryOutputStream;
    private File outputFile;
    private final String prefix;
    private final String suffix;

    public DeferredFileOutputStream(int i, File file) {
        this(i, file, null, null, null);
    }

    public DeferredFileOutputStream(int i, String str, String str2, File file) {
        this(i, null, str, str2, file);
        if (str == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        }
    }

    private DeferredFileOutputStream(int i, File file, String str, String str2, File file2) {
        super(i);
        this.closed = false;
        this.outputFile = file;
        this.memoryOutputStream = new ByteArrayOutputStream();
        this.currentOutputStream = this.memoryOutputStream;
        this.prefix = str;
        this.suffix = str2;
        this.directory = file2;
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream
    protected OutputStream getStream() {
        return this.currentOutputStream;
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream
    protected void thresholdReached() {
        if (this.prefix != null) {
            this.outputFile = File.createTempFile(this.prefix, this.suffix, this.directory);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile);
        this.memoryOutputStream.writeTo(fileOutputStream);
        this.currentOutputStream = fileOutputStream;
        this.memoryOutputStream = null;
    }

    public boolean isInMemory() {
        return !isThresholdExceeded();
    }

    public byte[] getData() {
        if (this.memoryOutputStream != null) {
            return this.memoryOutputStream.toByteArray();
        }
        return null;
    }

    public File getFile() {
        return this.outputFile;
    }

    @Override // org.apache.commons.io.output.ThresholdingOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.closed = true;
    }

    public void writeTo(OutputStream outputStream) {
        if (!this.closed) {
            throw new IOException("Stream not closed");
        }
        if (isInMemory()) {
            this.memoryOutputStream.writeTo(outputStream);
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(this.outputFile);
        try {
            IOUtils.copy(fileInputStream, outputStream);
        } finally {
            IOUtils.closeQuietly((InputStream) fileInputStream);
        }
    }
}
