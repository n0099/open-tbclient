package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
@Descriptor(tags = {0})
/* loaded from: classes10.dex */
public abstract class BaseDescriptor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public int sizeBytes;
    public int sizeOfInstance;
    public int tag;

    public abstract void parseDetail(ByteBuffer byteBuffer) throws IOException;

    public int getSize() {
        return this.sizeOfInstance + 1 + this.sizeBytes;
    }

    public int getSizeBytes() {
        return this.sizeBytes;
    }

    public int getSizeOfInstance() {
        return this.sizeOfInstance;
    }

    public int getTag() {
        return this.tag;
    }

    public String toString() {
        return "BaseDescriptor{tag=" + this.tag + ", sizeOfInstance=" + this.sizeOfInstance + '}';
    }

    public final void parse(int i, ByteBuffer byteBuffer) throws IOException {
        this.tag = i;
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.sizeOfInstance = readUInt8 & 127;
        int i2 = 1;
        while ((readUInt8 >>> 7) == 1) {
            readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            i2++;
            this.sizeOfInstance = (this.sizeOfInstance << 7) | (readUInt8 & 127);
        }
        this.sizeBytes = i2;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.sizeOfInstance);
        parseDetail(slice);
        byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
    }
}
