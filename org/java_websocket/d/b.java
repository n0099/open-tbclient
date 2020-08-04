package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class b implements a {
    private final String ojc;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.ojc = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Tw(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.ojc.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dXu() {
        return this.ojc;
    }

    @Override // org.java_websocket.d.a
    public a dXv() {
        return new b(dXu());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dXu();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ojc.equals(((b) obj).ojc);
    }

    public int hashCode() {
        return this.ojc.hashCode();
    }
}
