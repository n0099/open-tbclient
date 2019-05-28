package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String kmw;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.kmw = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Hs(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.kmw.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cKV() {
        return this.kmw;
    }

    @Override // org.java_websocket.d.a
    public a cKW() {
        return new b(cKV());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cKV();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.kmw.equals(((b) obj).kmw);
    }

    public int hashCode() {
        return this.kmw.hashCode();
    }
}
