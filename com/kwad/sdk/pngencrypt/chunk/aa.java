package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes5.dex */
public abstract class aa extends PngChunk {
    /* JADX INFO: Access modifiers changed from: protected */
    public aa(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aa aaVar = (aa) obj;
            return this.f10793a == null ? aaVar.f10793a == null : this.f10793a.equals(aaVar.f10793a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f10793a == null ? 0 : this.f10793a.hashCode()) + 31;
    }
}
