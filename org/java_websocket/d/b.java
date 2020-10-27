package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class b implements a {
    private final String pTE;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.pTE = str;
    }

    @Override // org.java_websocket.d.a
    public boolean ZD(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.pTE.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eBo() {
        return this.pTE;
    }

    @Override // org.java_websocket.d.a
    public a eBp() {
        return new b(eBo());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eBo();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.pTE.equals(((b) obj).pTE);
    }

    public int hashCode() {
        return this.pTE.hashCode();
    }
}
