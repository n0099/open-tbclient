package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.CommentResponse;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f9551a = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public interface a {
        @MainThread
        void a(int i, String str);

        @MainThread
        void a(@NonNull CommentResponse commentResponse);
    }

    public void a(final long j, @NonNull final a aVar) {
        new com.kwad.sdk.core.network.i<b, CommentResponse>() { // from class: com.kwad.sdk.core.g.g.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public CommentResponse b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CommentResponse commentResponse = new CommentResponse();
                commentResponse.parseJson(jSONObject);
                return commentResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public b b() {
                return new b(j);
            }
        }.a(new com.kwad.sdk.core.network.j<b, CommentResponse>() { // from class: com.kwad.sdk.core.g.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull b bVar, final int i, final String str) {
                g.f9551a.post(new Runnable() { // from class: com.kwad.sdk.core.g.g.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.d("PhotoCommentRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull b bVar, @NonNull final CommentResponse commentResponse) {
                g.f9551a.post(new Runnable() { // from class: com.kwad.sdk.core.g.g.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(commentResponse);
                    }
                });
            }
        });
    }
}
