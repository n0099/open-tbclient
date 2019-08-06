package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String kve;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.kve = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Ix(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.kve.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cPd() {
        return this.kve;
    }

    @Override // org.java_websocket.d.a
    public a cPe() {
        return new b(cPd());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cPd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.kve.equals(((b) obj).kve);
    }

    public int hashCode() {
        return this.kve.hashCode();
    }
}
