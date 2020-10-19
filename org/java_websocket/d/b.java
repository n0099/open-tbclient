package org.java_websocket.d;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class b implements a {
    private final String pcl;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.pcl = str;
    }

    @Override // org.java_websocket.d.a
    public boolean XQ(String str) {
        for (String str2 : str.replaceAll(" ", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (this.pcl.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String erq() {
        return this.pcl;
    }

    @Override // org.java_websocket.d.a
    public a err() {
        return new b(erq());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return erq();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.pcl.equals(((b) obj).pcl);
    }

    public int hashCode() {
        return this.pcl.hashCode();
    }
}
