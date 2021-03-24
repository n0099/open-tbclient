package com.google.zxing.datamatrix.encoder;

import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public final class TextEncoder extends C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    public int encodeChar(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        } else if (c2 >= 'a' && c2 <= 'z') {
            sb.append((char) ((c2 - 'a') + 14));
            return 1;
        } else if (c2 >= 0 && c2 <= 31) {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        } else if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        } else if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        } else if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        } else if (c2 == '`') {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c2 - 'A') + 1));
            return 2;
        } else if (c2 >= '{' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) ((c2 - Constants.METHOD_IM_FRIEND_GROUP_QUERY) + 27));
            return 2;
        } else if (c2 >= 128) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c2 - 128), sb) + 2;
        } else {
            HighLevelEncoder.illegalCharacter(c2);
            return -1;
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 2;
    }
}
