package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class b implements a {
    private final String nDs;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.nDs = str;
    }

    @Override // org.java_websocket.d.a
    public boolean RX(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.nDs.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dOZ() {
        return this.nDs;
    }

    @Override // org.java_websocket.d.a
    public a dPa() {
        return new b(dOZ());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dOZ();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.nDs.equals(((b) obj).nDs);
    }

    public int hashCode() {
        return this.nDs.hashCode();
    }
}
