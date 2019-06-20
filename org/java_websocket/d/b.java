package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String kmz;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.kmz = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Hu(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.kmz.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cKU() {
        return this.kmz;
    }

    @Override // org.java_websocket.d.a
    public a cKV() {
        return new b(cKU());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cKU();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.kmz.equals(((b) obj).kmz);
    }

    public int hashCode() {
        return this.kmz.hashCode();
    }
}
