package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class b implements a {
    private final String nLP;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nLP = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Sn(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nLP.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dMq() {
        return this.nLP;
    }

    @Override // org.java_websocket.d.a
    public a dMr() {
        return new b(dMq());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dMq();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nLP.equals(((b) obj).nLP);
    }

    public int hashCode() {
        return this.nLP.hashCode();
    }
}
