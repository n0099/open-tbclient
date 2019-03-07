package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String jUB;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.jUB = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Gk(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.jUB.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cDl() {
        return this.jUB;
    }

    @Override // org.java_websocket.d.a
    public a cDm() {
        return new b(cDl());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cDl();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.jUB.equals(((b) obj).jUB);
    }

    public int hashCode() {
        return this.jUB.hashCode();
    }
}
