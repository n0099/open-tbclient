package com.kwad.components.core.k;

import androidx.annotation.NonNull;
import com.kwad.components.core.response.model.AdResultData;
/* loaded from: classes10.dex */
public class c extends b {
    @Override // com.kwad.components.core.k.b
    public void a(int i, String str, boolean z) {
        onError(i, str);
    }

    @Override // com.kwad.components.core.k.g
    public void a(@NonNull AdResultData adResultData) {
    }

    @Override // com.kwad.components.core.k.b
    public void a(@NonNull AdResultData adResultData, boolean z) {
        a(adResultData);
    }

    @Override // com.kwad.components.core.k.g
    public void onError(int i, String str) {
    }
}
