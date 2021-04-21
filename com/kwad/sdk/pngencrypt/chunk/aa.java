package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public abstract class aa extends PngChunk {
    public aa(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f36504a;
            String str2 = ((aa) obj).f36504a;
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
        String str = this.f36504a;
        return 31 + (str == null ? 0 : str.hashCode());
    }
}
