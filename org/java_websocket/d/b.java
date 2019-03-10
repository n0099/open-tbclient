package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String jUU;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.jUU = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Gn(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.jUU.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cDv() {
        return this.jUU;
    }

    @Override // org.java_websocket.d.a
    public a cDw() {
        return new b(cDv());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cDv();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.jUU.equals(((b) obj).jUU);
    }

    public int hashCode() {
        return this.jUU.hashCode();
    }
}
