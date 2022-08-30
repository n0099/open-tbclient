package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public abstract class p extends PngChunk {
    public p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.alB;
            String str2 = ((p) obj).alB;
            if (str == null) {
                if (str2 != null) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.alB;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}
