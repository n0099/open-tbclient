package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class b implements a {
    private final String oja;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.oja = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Tw(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.oja.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String dXt() {
        return this.oja;
    }

    @Override // org.java_websocket.d.a
    public a dXu() {
        return new b(dXt());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return dXt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.oja.equals(((b) obj).oja);
    }

    public int hashCode() {
        return this.oja.hashCode();
    }
}
