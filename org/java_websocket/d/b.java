package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String oaq;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.oaq = str;
    }

    @Override // org.java_websocket.d.a
    public boolean SL(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.oaq.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dTX() {
        return this.oaq;
    }

    @Override // org.java_websocket.d.a
    public a dTY() {
        return new b(dTX());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dTX();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.oaq.equals(((b) obj).oaq);
    }

    public int hashCode() {
        return this.oaq.hashCode();
    }
}
