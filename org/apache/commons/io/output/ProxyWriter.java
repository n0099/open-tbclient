package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes.dex */
public class ProxyWriter extends FilterWriter {
    public ProxyWriter(Writer writer) {
        super(writer);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        try {
            beforeWrite(1);
            this.out.append(c);
            afterWrite(1);
        } catch (IOException e) {
            handleIOException(e);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        try {
            beforeWrite(i2 - i);
            this.out.append(charSequence, i, i2);
            afterWrite(i2 - i);
        } catch (IOException e) {
            handleIOException(e);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        int i = 0;
        if (charSequence != null) {
            try {
                i = charSequence.length();
            } catch (IOException e) {
                handleIOException(e);
            }
        }
        beforeWrite(i);
        this.out.append(charSequence);
        afterWrite(i);
        return this;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i) {
        try {
            beforeWrite(1);
            this.out.write(i);
            afterWrite(1);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        int i = 0;
        if (cArr != null) {
            try {
                i = cArr.length;
            } catch (IOException e) {
                handleIOException(e);
                return;
            }
        }
        beforeWrite(i);
        this.out.write(cArr);
        afterWrite(i);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        try {
            beforeWrite(i2);
            this.out.write(cArr, i, i2);
            afterWrite(i2);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.Writer
    public void write(String str) {
        int i = 0;
        if (str != null) {
            try {
                i = str.length();
            } catch (IOException e) {
                handleIOException(e);
                return;
            }
        }
        beforeWrite(i);
        this.out.write(str);
        afterWrite(i);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i, int i2) {
        try {
            beforeWrite(i2);
            this.out.write(str, i, i2);
            afterWrite(i2);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    protected void beforeWrite(int i) {
    }

    protected void afterWrite(int i) {
    }

    protected void handleIOException(IOException iOException) {
        throw iOException;
    }
}
