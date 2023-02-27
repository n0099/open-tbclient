package com.googlecode.mp4parser.util;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes8.dex */
public class ChannelHelper {
    public static ByteBuffer empty = ByteBuffer.allocate(0).asReadOnlyBuffer();

    public static int readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i) throws IOException {
        int read;
        int i2 = 0;
        do {
            read = readableByteChannel.read(byteBuffer);
            if (-1 == read) {
                break;
            }
            i2 += read;
        } while (i2 != i);
        if (read != -1) {
            return i2;
        }
        throw new EOFException("End of file. No more boxes.");
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        readFully(readableByteChannel, byteBuffer, byteBuffer.remaining());
    }
}
