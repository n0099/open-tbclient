package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes10.dex */
public abstract class p extends PngChunk {
    public p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        String str = this.agT;
        if (str == null) {
            if (pVar.agT != null) {
                return false;
            }
        } else if (!str.equals(pVar.agT)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        String str = this.agT;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode + 31;
    }
}
