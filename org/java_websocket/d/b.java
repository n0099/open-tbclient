package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String nMW;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nMW = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Sz(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nMW.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dNI() {
        return this.nMW;
    }

    @Override // org.java_websocket.d.a
    public a dNJ() {
        return new b(dNI());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dNI();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nMW.equals(((b) obj).nMW);
    }

    public int hashCode() {
        return this.nMW.hashCode();
    }
}
