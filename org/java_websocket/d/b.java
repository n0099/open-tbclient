package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class b implements a {
    private final String nLU;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nLU = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Sn(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nLU.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dMs() {
        return this.nLU;
    }

    @Override // org.java_websocket.d.a
    public a dMt() {
        return new b(dMs());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dMs();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nLU.equals(((b) obj).nLU);
    }

    public int hashCode() {
        return this.nLU.hashCode();
    }
}
