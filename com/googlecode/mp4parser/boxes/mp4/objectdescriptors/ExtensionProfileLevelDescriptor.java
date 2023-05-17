package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.common.others.lang.StringUtil;
import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;
@Descriptor(tags = {19})
/* loaded from: classes9.dex */
public class ExtensionProfileLevelDescriptor extends BaseDescriptor {
    public byte[] bytes;

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        String encodeHex;
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
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

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        if (getSize() > 0) {
            byte[] bArr = new byte[getSize()];
            this.bytes = bArr;
            byteBuffer.get(bArr);
        }
    }
}
