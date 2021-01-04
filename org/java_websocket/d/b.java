package org.java_websocket.d;
/* loaded from: classes4.dex */
public class b implements a {
    private final String qqh;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qqh = str;
    }

    @Override // org.java_websocket.d.a
    public boolean acz(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.qqh.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eNm() {
        return this.qqh;
    }

    @Override // org.java_websocket.d.a
    public a eNn() {
        return new b(eNm());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eNm();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.qqh.equals(((b) obj).qqh);
    }

    public int hashCode() {
        return this.qqh.hashCode();
    }
}
