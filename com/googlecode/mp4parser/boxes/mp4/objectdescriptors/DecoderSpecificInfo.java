package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.common.others.lang.StringUtil;
import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
@Descriptor(tags = {5})
/* loaded from: classes10.dex */
public class DecoderSpecificInfo extends BaseDescriptor {
    public byte[] bytes;

    public int hashCode() {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    public ByteBuffer serialize() {
        return ByteBuffer.wrap(this.bytes);
    }

    public int serializedSize() {
        return this.bytes.length;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        String encodeHex;
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderSpecificInfo");
        sb.append("{bytes=");
        byte[] bArr = this.bytes;
        if (bArr == null) {
            encodeHex = StringUtil.NULL_STRING;
        } else {
            encodeHex = Hex.encodeHex(bArr);
        }
        sb.append(encodeHex);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DecoderSpecificInfo.class == obj.getClass() && Arrays.equals(this.bytes, ((DecoderSpecificInfo) obj).bytes)) {
            return true;
        }
        return false;
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
}
