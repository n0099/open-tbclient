package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String nOJ;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nOJ = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Sz(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nOJ.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dOi() {
        return this.nOJ;
    }

    @Override // org.java_websocket.d.a
    public a dOj() {
        return new b(dOi());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dOi();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nOJ.equals(((b) obj).nOJ);
    }

    public int hashCode() {
        return this.nOJ.hashCode();
    }
}
