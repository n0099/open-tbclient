package org.apache.commons.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
@Deprecated
/* loaded from: classes.dex */
public class CopyUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    public static void copy(byte[] bArr, OutputStream outputStream) {
        outputStream.write(bArr);
    }

    public static void copy(byte[] bArr, Writer writer) {
        copy(new ByteArrayInputStream(bArr), writer);
    }

    public static void copy(byte[] bArr, Writer writer, String str) {
        copy(new ByteArrayInputStream(bArr), writer, str);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                i += read;
            } else {
                return i;
            }
        }
    }

    public static int copy(Reader reader, Writer writer) {
        char[] cArr = new char[4096];
        int i = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 != read) {
                writer.write(cArr, 0, read);
                i += read;
            } else {
                return i;
            }
        }
    }

    public static void copy(InputStream inputStream, Writer writer) {
        copy(new InputStreamReader(inputStream), writer);
    }

    public static void copy(InputStream inputStream, Writer writer, String str) {
        copy(new InputStreamReader(inputStream, str), writer);
    }

    public static void copy(Reader reader, OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        copy(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void copy(String str, OutputStream outputStream) {
        StringReader stringReader = new StringReader(str);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        copy(stringReader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void copy(String str, Writer writer) {
        writer.write(str);
    }
}
