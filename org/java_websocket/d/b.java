package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes18.dex */
public class b implements a {
    private final String qeB;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qeB = str;
    }

    @Override // org.java_websocket.d.a
    public boolean ZS(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.qeB.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eFe() {
        return this.qeB;
    }

    @Override // org.java_websocket.d.a
    public a eFf() {
        return new b(eFe());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eFe();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.qeB.equals(((b) obj).qeB);
    }

    public int hashCode() {
        return this.qeB.hashCode();
    }
}
