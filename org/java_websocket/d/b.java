package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String jUf;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.jUf = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Ga(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.jUf.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cDn() {
        return this.jUf;
    }

    @Override // org.java_websocket.d.a
    public a cDo() {
        return new b(cDn());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cDn();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.jUf.equals(((b) obj).jUf);
    }

    public int hashCode() {
        return this.jUf.hashCode();
    }
}
