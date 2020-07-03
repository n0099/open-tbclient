package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String oan;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.oan = str;
    }

    @Override // org.java_websocket.d.a
    public boolean SK(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.oan.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dTT() {
        return this.oan;
    }

    @Override // org.java_websocket.d.a
    public a dTU() {
        return new b(dTT());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dTT();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.oan.equals(((b) obj).oan);
    }

    public int hashCode() {
        return this.oan.hashCode();
    }
}
