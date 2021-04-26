package com.googlecode.mp4parser.util;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes6.dex */
public class ChannelHelper {
    public static ByteBuffer empty = ByteBuffer.allocate(0).asReadOnlyBuffer();

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        readFully(readableByteChannel, byteBuffer, byteBuffer.remaining());
    }

    public static int readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i2) throws IOException {
        int read;
        int i3 = 0;
        do {
            read = readableByteChannel.read(byteBuffer);
            if (-1 == read) {
                break;
            }
            i3 += read;
        } while (i3 != i2);
        if (read != -1) {
            return i3;
        }
        throw new EOFException("End of file. No more boxes.");
    }
}
