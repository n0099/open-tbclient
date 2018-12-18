package org.java_websocket.d;
/* loaded from: classes2.dex */
public class b implements a {
    private final String iAy;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.iAy = str;
    }

    @Override // org.java_websocket.d.a
    public boolean zO(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.iAy.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String ccH() {
        return this.iAy;
    }

    @Override // org.java_websocket.d.a
    public a ccI() {
        return new b(ccH());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return ccH();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.iAy.equals(((b) obj).iAy);
    }

    public int hashCode() {
        return this.iAy.hashCode();
    }
}
