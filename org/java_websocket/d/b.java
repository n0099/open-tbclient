package org.java_websocket.d;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class b implements a {
    private final String ncQ;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.ncQ = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Rs(String str) {
        for (String str2 : str.replaceAll(HanziToPinyin.Token.SEPARATOR, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.ncQ.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dFP() {
        return this.ncQ;
    }

    @Override // org.java_websocket.d.a
    public a dFQ() {
        return new b(dFP());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dFP();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ncQ.equals(((b) obj).ncQ);
    }

    public int hashCode() {
        return this.ncQ.hashCode();
    }
}
