package com.googlecode.mp4parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes12.dex */
public class FileDataSourceImpl implements DataSource {
    FileChannel fc;

    public FileDataSourceImpl(File file) throws FileNotFoundException {
        this.fc = new FileInputStream(file).getChannel();
    }

    public FileDataSourceImpl(String str) throws FileNotFoundException {
        this.fc = new FileInputStream(new File(str)).getChannel();
    }

    public FileDataSourceImpl(FileChannel fileChannel) {
        this.fc = fileChannel;
    }

    @Override // com.googlecode.mp4parser.DataSource
    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.fc.read(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long size() throws IOException {
        return this.fc.size();
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long position() throws IOException {
        return this.fc.position();
    }

    @Override // com.googlecode.mp4parser.DataSource
    public void position(long j) throws IOException {
        this.fc.position(j);
    }

    @Override // com.googlecode.mp4parser.DataSource
    public long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        return this.fc.transferTo(j, j2, writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.DataSource
    public ByteBuffer map(long j, long j2) throws IOException {
        return this.fc.map(FileChannel.MapMode.READ_ONLY, j, j2);
    }

    @Override // com.googlecode.mp4parser.DataSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fc.close();
    }
}
