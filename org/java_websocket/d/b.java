package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes17.dex */
public class b implements a {
    private final String oMV;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.oMV = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Xc(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.oMV.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String enE() {
        return this.oMV;
    }

    @Override // org.java_websocket.d.a
    public a enF() {
        return new b(enE());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return enE();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.oMV.equals(((b) obj).oMV);
    }

    public int hashCode() {
        return this.oMV.hashCode();
    }
}
