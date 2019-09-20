package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String kxx;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.kxx = str;
    }

    @Override // org.java_websocket.d.a
    public boolean IV(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.kxx.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cPP() {
        return this.kxx;
    }

    @Override // org.java_websocket.d.a
    public a cPQ() {
        return new b(cPP());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cPP();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.kxx.equals(((b) obj).kxx);
    }

    public int hashCode() {
        return this.kxx.hashCode();
    }
}
