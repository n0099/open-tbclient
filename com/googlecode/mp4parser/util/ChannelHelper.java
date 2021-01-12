package com.googlecode.mp4parser.util;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes3.dex */
public class ChannelHelper {
    private static ByteBuffer empty = ByteBuffer.allocate(0).asReadOnlyBuffer();

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        readFully(readableByteChannel, byteBuffer, byteBuffer.remaining());
    }

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
        if (read == -1) {
            throw new EOFException("End of file. No more boxes.");
        }
        return i2;
    }
}
