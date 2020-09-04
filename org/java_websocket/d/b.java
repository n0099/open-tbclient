package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String oDq;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.oDq = str;
    }

    @Override // org.java_websocket.d.a
    public boolean WA(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.oDq.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String ejH() {
        return this.oDq;
    }

    @Override // org.java_websocket.d.a
    public a ejI() {
        return new b(ejH());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return ejH();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.oDq.equals(((b) obj).oDq);
    }

    public int hashCode() {
        return this.oDq.hashCode();
    }
}
