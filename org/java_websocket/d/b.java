package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class b implements a {
    private final String qcY;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qcY = str;
    }

    @Override // org.java_websocket.d.a
    public boolean aah(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.qcY.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eFd() {
        return this.qcY;
    }

    @Override // org.java_websocket.d.a
    public a eFe() {
        return new b(eFd());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eFd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.qcY.equals(((b) obj).qcY);
    }

    public int hashCode() {
        return this.qcY.hashCode();
    }
}
