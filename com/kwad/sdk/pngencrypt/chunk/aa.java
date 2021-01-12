package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes4.dex */
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
            return this.f10494a == null ? aaVar.f10494a == null : this.f10494a.equals(aaVar.f10494a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f10494a == null ? 0 : this.f10494a.hashCode()) + 31;
    }
}
