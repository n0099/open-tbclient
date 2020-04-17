package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String nip;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nip = str;
    }

    @Override // org.java_websocket.d.a
    public boolean PO(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nip.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dHi() {
        return this.nip;
    }

    @Override // org.java_websocket.d.a
    public a dHj() {
        return new b(dHi());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dHi();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nip.equals(((b) obj).nip);
    }

    public int hashCode() {
        return this.nip.hashCode();
    }
}
