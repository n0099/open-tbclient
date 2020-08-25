package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String oCY;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.oCY = str;
    }

    @Override // org.java_websocket.d.a
    public boolean WA(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.oCY.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String ejy() {
        return this.oCY;
    }

    @Override // org.java_websocket.d.a
    public a ejz() {
        return new b(ejy());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return ejy();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.oCY.equals(((b) obj).oCY);
    }

    public int hashCode() {
        return this.oCY.hashCode();
    }
}
