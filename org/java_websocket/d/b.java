package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String kyf;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.kyf = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Hm(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.kyf.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cNW() {
        return this.kyf;
    }

    @Override // org.java_websocket.d.a
    public a cNX() {
        return new b(cNW());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cNW();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.kyf.equals(((b) obj).kyf);
    }

    public int hashCode() {
        return this.kyf.hashCode();
    }
}
