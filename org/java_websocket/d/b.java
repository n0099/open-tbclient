package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String kmv;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.kmv = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Hs(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.kmv.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cKT() {
        return this.kmv;
    }

    @Override // org.java_websocket.d.a
    public a cKU() {
        return new b(cKT());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cKT();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.kmv.equals(((b) obj).kmv);
    }

    public int hashCode() {
        return this.kmv.hashCode();
    }
}
