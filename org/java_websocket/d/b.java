package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String ktY;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.ktY = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Iw(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.ktY.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cOI() {
        return this.ktY;
    }

    @Override // org.java_websocket.d.a
    public a cOJ() {
        return new b(cOI());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cOI();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ktY.equals(((b) obj).ktY);
    }

    public int hashCode() {
        return this.ktY.hashCode();
    }
}
