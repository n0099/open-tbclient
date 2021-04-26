package com.coremedia.iso.boxes.sampleentry;

import android.support.v4.media.session.PlaybackStateCompat;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class TextSampleEntry extends AbstractSampleEntry {
    public static final String TYPE1 = "tx3g";
    public static final String TYPE_ENCRYPTED = "enct";
    public int[] backgroundColorRgba;
    public BoxRecord boxRecord;
    public long displayFlags;
    public int horizontalJustification;
    public StyleRecord styleRecord;
    public int verticalJustification;

    /* loaded from: classes6.dex */
    public static class BoxRecord {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public BoxRecord() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || BoxRecord.class != obj.getClass()) {
                return false;
            }
            BoxRecord boxRecord = (BoxRecord) obj;
            return this.bottom == boxRecord.bottom && this.left == boxRecord.left && this.right == boxRecord.right && this.top == boxRecord.top;
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.writeUInt16(byteBuffer, this.top);
            IsoTypeWriter.writeUInt16(byteBuffer, this.left);
            IsoTypeWriter.writeUInt16(byteBuffer, this.bottom);
            IsoTypeWriter.writeUInt16(byteBuffer, this.right);
        }

        public int getSize() {
            return 8;
        }

        public int hashCode() {
            return (((((this.top * 31) + this.left) * 31) + this.bottom) * 31) + this.right;
        }

        public void parse(ByteBuffer byteBuffer) {
            this.top = IsoTypeReader.readUInt16(byteBuffer);
            this.left = IsoTypeReader.readUInt16(byteBuffer);
            this.bottom = IsoTypeReader.readUInt16(byteBuffer);
            this.right = IsoTypeReader.readUInt16(byteBuffer);
        }

        public BoxRecord(int i2, int i3, int i4, int i5) {
            this.top = i2;
            this.left = i3;
            this.bottom = i4;
            this.right = i5;
        }
    }

    public TextSampleEntry() {
        super(TYPE1);
        this.backgroundColorRgba = new int[4];
        this.boxRecord = new BoxRecord();
        this.styleRecord = new StyleRecord();
    }

    public int[] getBackgroundColorRgba() {
        return this.backgroundColorRgba;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(38);
        allocate.position(6);
        IsoTypeWriter.writeUInt16(allocate, this.dataReferenceIndex);
        IsoTypeWriter.writeUInt32(allocate, this.displayFlags);
        IsoTypeWriter.writeUInt8(allocate, this.horizontalJustification);
        IsoTypeWriter.writeUInt8(allocate, this.verticalJustification);
        IsoTypeWriter.writeUInt8(allocate, this.backgroundColorRgba[0]);
        IsoTypeWriter.writeUInt8(allocate, this.backgroundColorRgba[1]);
        IsoTypeWriter.writeUInt8(allocate, this.backgroundColorRgba[2]);
        IsoTypeWriter.writeUInt8(allocate, this.backgroundColorRgba[3]);
        this.boxRecord.getContent(allocate);
        this.styleRecord.getContent(allocate);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public BoxRecord getBoxRecord() {
        return this.boxRecord;
    }

    public int getHorizontalJustification() {
        return this.horizontalJustification;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        long containerSize = getContainerSize() + 38;
        return containerSize + ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8);
    }

    public StyleRecord getStyleRecord() {
        return this.styleRecord;
    }

    public int getVerticalJustification() {
        return this.verticalJustification;
    }

    public boolean isContinuousKaraoke() {
        return (this.displayFlags & 2048) == 2048;
    }

    public boolean isFillTextRegion() {
        return (this.displayFlags & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) == PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public boolean isScrollDirection() {
        return (this.displayFlags & 384) == 384;
    }

    public boolean isScrollIn() {
        return (this.displayFlags & 32) == 32;
    }

    public boolean isScrollOut() {
        return (this.displayFlags & 64) == 64;
    }

    public boolean isWriteTextVertically() {
        return (this.displayFlags & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) == PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(38);
        dataSource.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(allocate);
        this.displayFlags = IsoTypeReader.readUInt32(allocate);
        this.horizontalJustification = IsoTypeReader.readUInt8(allocate);
        this.verticalJustification = IsoTypeReader.readUInt8(allocate);
        int[] iArr = new int[4];
        this.backgroundColorRgba = iArr;
        iArr[0] = IsoTypeReader.readUInt8(allocate);
        this.backgroundColorRgba[1] = IsoTypeReader.readUInt8(allocate);
        this.backgroundColorRgba[2] = IsoTypeReader.readUInt8(allocate);
        this.backgroundColorRgba[3] = IsoTypeReader.readUInt8(allocate);
        BoxRecord boxRecord = new BoxRecord();
        this.boxRecord = boxRecord;
        boxRecord.parse(allocate);
        StyleRecord styleRecord = new StyleRecord();
        this.styleRecord = styleRecord;
        styleRecord.parse(allocate);
        parseContainer(dataSource, j - 38, boxParser);
    }

    public void setBackgroundColorRgba(int[] iArr) {
        this.backgroundColorRgba = iArr;
    }

    public void setBoxRecord(BoxRecord boxRecord) {
        this.boxRecord = boxRecord;
    }

    public void setContinuousKaraoke(boolean z) {
        if (z) {
            this.displayFlags |= 2048;
        } else {
            this.displayFlags &= -2049;
        }
    }

    public void setFillTextRegion(boolean z) {
        if (z) {
            this.displayFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        } else {
            this.displayFlags &= -262145;
        }
    }

    public void setHorizontalJustification(int i2) {
        this.horizontalJustification = i2;
    }

    public void setScrollDirection(boolean z) {
        if (z) {
            this.displayFlags |= 384;
        } else {
            this.displayFlags &= -385;
        }
    }

    public void setScrollIn(boolean z) {
        if (z) {
            this.displayFlags |= 32;
        } else {
            this.displayFlags &= -33;
        }
    }

    public void setScrollOut(boolean z) {
        if (z) {
            this.displayFlags |= 64;
        } else {
            this.displayFlags &= -65;
        }
    }

    public void setStyleRecord(StyleRecord styleRecord) {
        this.styleRecord = styleRecord;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVerticalJustification(int i2) {
        this.verticalJustification = i2;
    }

    public void setWriteTextVertically(boolean z) {
        if (z) {
            this.displayFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        } else {
            this.displayFlags &= -131073;
        }
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String toString() {
        return "TextSampleEntry";
    }

    /* loaded from: classes6.dex */
    public static class StyleRecord {
        public int endChar;
        public int faceStyleFlags;
        public int fontId;
        public int fontSize;
        public int startChar;
        public int[] textColor;

        public StyleRecord() {
            this.textColor = new int[]{255, 255, 255, 255};
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || StyleRecord.class != obj.getClass()) {
                return false;
            }
            StyleRecord styleRecord = (StyleRecord) obj;
            return this.endChar == styleRecord.endChar && this.faceStyleFlags == styleRecord.faceStyleFlags && this.fontId == styleRecord.fontId && this.fontSize == styleRecord.fontSize && this.startChar == styleRecord.startChar && Arrays.equals(this.textColor, styleRecord.textColor);
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.writeUInt16(byteBuffer, this.startChar);
            IsoTypeWriter.writeUInt16(byteBuffer, this.endChar);
            IsoTypeWriter.writeUInt16(byteBuffer, this.fontId);
            IsoTypeWriter.writeUInt8(byteBuffer, this.faceStyleFlags);
            IsoTypeWriter.writeUInt8(byteBuffer, this.fontSize);
            IsoTypeWriter.writeUInt8(byteBuffer, this.textColor[0]);
            IsoTypeWriter.writeUInt8(byteBuffer, this.textColor[1]);
            IsoTypeWriter.writeUInt8(byteBuffer, this.textColor[2]);
            IsoTypeWriter.writeUInt8(byteBuffer, this.textColor[3]);
        }

        public int getSize() {
            return 12;
        }

        public int hashCode() {
            int i2 = ((((((((this.startChar * 31) + this.endChar) * 31) + this.fontId) * 31) + this.faceStyleFlags) * 31) + this.fontSize) * 31;
            int[] iArr = this.textColor;
            return i2 + (iArr != null ? Arrays.hashCode(iArr) : 0);
        }

        public void parse(ByteBuffer byteBuffer) {
            this.startChar = IsoTypeReader.readUInt16(byteBuffer);
            this.endChar = IsoTypeReader.readUInt16(byteBuffer);
            this.fontId = IsoTypeReader.readUInt16(byteBuffer);
            this.faceStyleFlags = IsoTypeReader.readUInt8(byteBuffer);
            this.fontSize = IsoTypeReader.readUInt8(byteBuffer);
            int[] iArr = new int[4];
            this.textColor = iArr;
            iArr[0] = IsoTypeReader.readUInt8(byteBuffer);
            this.textColor[1] = IsoTypeReader.readUInt8(byteBuffer);
            this.textColor[2] = IsoTypeReader.readUInt8(byteBuffer);
            this.textColor[3] = IsoTypeReader.readUInt8(byteBuffer);
        }

        public StyleRecord(int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            this.textColor = new int[]{255, 255, 255, 255};
            this.startChar = i2;
            this.endChar = i3;
            this.fontId = i4;
            this.faceStyleFlags = i5;
            this.fontSize = i6;
            this.textColor = iArr;
        }
    }

    public TextSampleEntry(String str) {
        super(str);
        this.backgroundColorRgba = new int[4];
        this.boxRecord = new BoxRecord();
        this.styleRecord = new StyleRecord();
    }
}
