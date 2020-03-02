package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String nML;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nML = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Sy(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nML.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dNH() {
        return this.nML;
    }

    @Override // org.java_websocket.d.a
    public a dNI() {
        return new b(dNH());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dNH();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nML.equals(((b) obj).nML);
    }

    public int hashCode() {
        return this.nML.hashCode();
    }
}
