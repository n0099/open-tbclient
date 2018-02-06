package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import android.support.v4.media.TransportMediator;
import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
@Descriptor(tags = {0})
/* loaded from: classes2.dex */
public abstract class BaseDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled;
    int sizeBytes;
    int sizeOfInstance;
    int tag;

    public abstract void parseDetail(ByteBuffer byteBuffer) throws IOException;

    static {
        $assertionsDisabled = !BaseDescriptor.class.desiredAssertionStatus();
    }

    public int getTag() {
        return this.tag;
    }

    public int getSize() {
        return this.sizeOfInstance + 1 + this.sizeBytes;
    }

    public int getSizeOfInstance() {
        return this.sizeOfInstance;
    }

    public int getSizeBytes() {
        return this.sizeBytes;
    }

    public final void parse(int i, ByteBuffer byteBuffer) throws IOException {
        this.tag = i;
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.sizeOfInstance = readUInt8 & TransportMediator.KEYCODE_MEDIA_PAUSE;
        int i2 = 1;
        while ((readUInt8 >>> 7) == 1) {
            readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            i2++;
            this.sizeOfInstance = (this.sizeOfInstance << 7) | (readUInt8 & TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        this.sizeBytes = i2;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.sizeOfInstance);
        parseDetail(slice);
        if (!$assertionsDisabled && slice.remaining() != 0) {
            throw new AssertionError(String.valueOf(getClass().getSimpleName()) + " has not been fully parsed");
        }
        byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseDescriptor");
        sb.append("{tag=").append(this.tag);
        sb.append(", sizeOfInstance=").append(this.sizeOfInstance);
        sb.append('}');
        return sb.toString();
    }
}
