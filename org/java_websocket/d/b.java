package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class b implements a {
    private final String jUM;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.jUM = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Gl(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.jUM.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cDy() {
        return this.jUM;
    }

    @Override // org.java_websocket.d.a
    public a cDz() {
        return new b(cDy());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cDy();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.jUM.equals(((b) obj).jUM);
    }

    public int hashCode() {
        return this.jUM.hashCode();
    }
}
