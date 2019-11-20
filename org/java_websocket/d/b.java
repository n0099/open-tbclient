package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String kxo;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.kxo = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Hm(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.kxo.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cNU() {
        return this.kxo;
    }

    @Override // org.java_websocket.d.a
    public a cNV() {
        return new b(cNU());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cNU();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.kxo.equals(((b) obj).kxo);
    }

    public int hashCode() {
        return this.kxo.hashCode();
    }
}
