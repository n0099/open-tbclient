package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(String str, String str2) {
        this(new File(str), str2, false);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z) {
        this(new File(str), str2, z);
    }

    public FileWriterWithEncoding(String str, Charset charset) {
        this(new File(str), charset, false);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z) {
        this(new File(str), charset, z);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) {
        this(new File(str), charsetEncoder, false);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z) {
        this(new File(str), charsetEncoder, z);
    }

    public FileWriterWithEncoding(File file, String str) {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z) {
        this.out = initWriter(file, str, z);
    }

    public FileWriterWithEncoding(File file, Charset charset) {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z) {
        this.out = initWriter(file, charset, z);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z) {
        this.out = initWriter(file, charsetEncoder, z);
    }

    private static Writer initWriter(File file, Object obj, boolean z) {
        FileOutputStream fileOutputStream;
        if (file == null) {
            throw new NullPointerException("File is missing");
        }
        if (obj == null) {
            throw new NullPointerException("Encoding is missing");
        }
        boolean exists = file.exists();
        try {
            fileOutputStream = new FileOutputStream(file, z);
            try {
                if (obj instanceof Charset) {
                    return new OutputStreamWriter(fileOutputStream, (Charset) obj);
                }
                if (obj instanceof CharsetEncoder) {
                    return new OutputStreamWriter(fileOutputStream, (CharsetEncoder) obj);
                }
                return new OutputStreamWriter(fileOutputStream, (String) obj);
            } catch (IOException e) {
                e = e;
                IOUtils.closeQuietly((Writer) null);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                if (!exists) {
                    FileUtils.deleteQuietly(file);
                }
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                IOUtils.closeQuietly((Writer) null);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                if (!exists) {
                    FileUtils.deleteQuietly(file);
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (RuntimeException e4) {
            e = e4;
            fileOutputStream = null;
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

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }
}
