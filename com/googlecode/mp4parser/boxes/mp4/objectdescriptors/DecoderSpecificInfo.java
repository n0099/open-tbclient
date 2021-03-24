package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.common.others.lang.StringUtil;
import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
@Descriptor(tags = {5})
/* loaded from: classes6.dex */
public class DecoderSpecificInfo extends BaseDescriptor {
    public byte[] bytes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && DecoderSpecificInfo.class == obj.getClass() && Arrays.equals(this.bytes, ((DecoderSpecificInfo) obj).bytes);
    }

    public int hashCode() {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int i = this.sizeOfInstance;
        if (i > 0) {
            byte[] bArr = new byte[i];
            this.bytes = bArr;
            byteBuffer.get(bArr);
        }
    }

    public ByteBuffer serialize() {
        return ByteBuffer.wrap(this.bytes);
    }

    public int serializedSize() {
        return this.bytes.length;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderSpecificInfo");
        sb.append("{bytes=");
        byte[] bArr = this.bytes;
        sb.append(bArr == null ? StringUtil.NULL_STRING : Hex.encodeHex(bArr));
        sb.append('}');
        return sb.toString();
    }
}
