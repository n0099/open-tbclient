package com.kwad.sdk.emotion.model;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.emotion.c;
/* loaded from: classes6.dex */
public abstract class b {
    @NonNull
    public Context a() {
        return KsAdSDKImpl.get().getContext();
    }

    @NonNull
    public c b() {
        return new c() { // from class: com.kwad.sdk.emotion.model.b.1
            @Override // com.kwad.sdk.emotion.c
            public void a(EmotionPackage emotionPackage) {
                com.kwad.sdk.core.d.a.a("EmotionManager", "onComplete:" + emotionPackage.id);
            }

            @Override // com.kwad.sdk.emotion.c
            public void a(EmotionPackage emotionPackage, Throwable th) {
                com.kwad.sdk.core.d.a.a("EmotionManager", "onError:" + emotionPackage.id);
            }
        };
    }
}
