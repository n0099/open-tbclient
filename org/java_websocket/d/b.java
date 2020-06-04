package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String nEC;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nEC = str;
    }

    @Override // org.java_websocket.d.a
    public boolean RY(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nEC.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dPn() {
        return this.nEC;
    }

    @Override // org.java_websocket.d.a
    public a dPo() {
        return new b(dPn());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dPn();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nEC.equals(((b) obj).nEC);
    }

    public int hashCode() {
        return this.nEC.hashCode();
    }
}
