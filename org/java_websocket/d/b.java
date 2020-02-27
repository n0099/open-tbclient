package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String nMJ;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nMJ = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Sy(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nMJ.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dNF() {
        return this.nMJ;
    }

    @Override // org.java_websocket.d.a
    public a dNG() {
        return new b(dNF());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dNF();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nMJ.equals(((b) obj).nMJ);
    }

    public int hashCode() {
        return this.nMJ.hashCode();
    }
}
