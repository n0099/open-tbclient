package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes6.dex */
public class SubtitleSampleEntry extends AbstractSampleEntry {
    public static final String TYPE1 = "stpp";
    public String imageMimeType;
    public String namespace;
    public String schemaLocation;

    public SubtitleSampleEntry() {
        super(TYPE1);
        this.namespace = "";
        this.schemaLocation = "";
        this.imageMimeType = "";
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(this.namespace.length() + 8 + this.schemaLocation.length() + this.imageMimeType.length() + 3);
        allocate.position(6);
        IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
        IsoTypeWriter.writeZeroTermUtf8String(allocate, this.namespace);
        IsoTypeWriter.writeZeroTermUtf8String(allocate, this.schemaLocation);
        IsoTypeWriter.writeZeroTermUtf8String(allocate, this.imageMimeType);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public String getImageMimeType() {
        return this.imageMimeType;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getSchemaLocation() {
        return this.schemaLocation;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        int i2 = 8;
        long containerSize = getContainerSize() + this.namespace.length() + 8 + this.schemaLocation.length() + this.imageMimeType.length() + 3;
        return containerSize + ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 16);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        dataSource.read((ByteBuffer) allocate.rewind());
        allocate.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
        long position = dataSource.position();
        ByteBuffer allocate2 = ByteBuffer.allocate(1024);
        dataSource.read((ByteBuffer) allocate2.rewind());
        String readString = IsoTypeReader.readString((ByteBuffer) allocate2.rewind());
        this.namespace = readString;
        dataSource.position(readString.length() + position + 1);
        dataSource.read((ByteBuffer) allocate2.rewind());
        this.schemaLocation = IsoTypeReader.readString((ByteBuffer) allocate2.rewind());
        dataSource.position(this.namespace.length() + position + this.schemaLocation.length() + 2);
        dataSource.read((ByteBuffer) allocate2.rewind());
        this.imageMimeType = IsoTypeReader.readString((ByteBuffer) allocate2.rewind());
        dataSource.position(position + this.namespace.length() + this.schemaLocation.length() + this.imageMimeType.length() + 3);
        parseContainer(dataSource, j - ((((byteBuffer.remaining() + this.namespace.length()) + this.schemaLocation.length()) + this.imageMimeType.length()) + 3), boxParser);
    }

    public void setImageMimeType(String str) {
        this.imageMimeType = str;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void setSchemaLocation(String str) {
        this.schemaLocation = str;
    }
}
