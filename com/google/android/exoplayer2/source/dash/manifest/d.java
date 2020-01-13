package com.google.android.exoplayer2.source.dash.manifest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
public final class d {
    @Nullable
    public final String id;
    @NonNull
    public final String schemeIdUri;
    @Nullable
    public final String value;

    public d(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.id = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return v.h(this.schemeIdUri, dVar.schemeIdUri) && v.h(this.value, dVar.value) && v.h(this.id, dVar.id);
    }

    public int hashCode() {
        return (((this.value != null ? this.value.hashCode() : 0) + ((this.schemeIdUri != null ? this.schemeIdUri.hashCode() : 0) * 31)) * 31) + (this.id != null ? this.id.hashCode() : 0);
    }
}
