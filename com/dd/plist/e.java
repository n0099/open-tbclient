package com.dd.plist;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class e extends i {
    private byte[] bytes;

    public e(byte[] bArr) {
        this.bytes = bArr;
    }

    public e(String str) throws IOException {
        this.bytes = b.decode(str.replaceAll("\\s+", ""));
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && Arrays.equals(((e) obj).bytes, this.bytes);
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes) + 335;
    }
}
