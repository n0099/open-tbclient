package com.kwad.sdk.emotion.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.emotion.model.EmotionResponse;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str);

        void a(EmotionResponse emotionResponse);
    }

    public static void a(@Nullable final a aVar) {
        new i<com.kwad.sdk.emotion.a, EmotionResponse>() { // from class: com.kwad.sdk.emotion.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
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
            protected boolean a_() {
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
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
            public void a(@NonNull com.kwad.sdk.emotion.a aVar2, int i, String str) {
                super.a((AnonymousClass2) aVar2, i, str);
                if (a.this != null) {
                    a.this.a(i, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.emotion.a aVar2, @NonNull EmotionResponse emotionResponse) {
                super.a((AnonymousClass2) aVar2, (com.kwad.sdk.emotion.a) emotionResponse);
                if (a.this != null) {
                    a.this.a(emotionResponse);
                }
            }
        });
    }
}
