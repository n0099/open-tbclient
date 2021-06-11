package com.kwad.sdk.emotion.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.emotion.model.EmotionResponse;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2, String str);

        void a(EmotionResponse emotionResponse);
    }

    public static void a(@Nullable final a aVar) {
        new i<com.kwad.sdk.emotion.a, EmotionResponse>() { // from class: com.kwad.sdk.emotion.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public EmotionResponse b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                EmotionResponse emotionResponse = new EmotionResponse();
                emotionResponse.parseJson(jSONObject);
                return emotionResponse;
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean a_() {
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.emotion.a b() {
                return new com.kwad.sdk.emotion.a();
            }
        }.a(new j<com.kwad.sdk.emotion.a, EmotionResponse>() { // from class: com.kwad.sdk.emotion.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.emotion.a aVar2) {
                super.a((AnonymousClass2) aVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.emotion.a aVar2, int i2, String str) {
                super.a((AnonymousClass2) aVar2, i2, str);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.emotion.a aVar2, @NonNull EmotionResponse emotionResponse) {
                super.a((AnonymousClass2) aVar2, (com.kwad.sdk.emotion.a) emotionResponse);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(emotionResponse);
                }
            }
        });
    }
}
