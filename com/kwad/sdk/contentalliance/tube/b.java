package com.kwad.sdk.contentalliance.tube;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.tube.b.a;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private a f8909b;
    private i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData> c;
    private long e;
    private SceneImpl f;
    private AtomicBoolean d = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private Handler f8908a = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public interface a {
        @MainThread
        void a(boolean z);

        @MainThread
        void a(boolean z, int i, String str);

        @MainThread
        void a(boolean z, @NonNull AdResultData adResultData);

        @MainThread
        void b(boolean z);
    }

    public b(SceneImpl sceneImpl, long j, a aVar) {
        this.f = sceneImpl;
        this.e = j;
        this.f8909b = aVar;
    }

    private void a(boolean z) {
        if (this.f8909b != null) {
            this.f8909b.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, String str) {
        if (this.f8909b != null) {
            this.f8909b.a(z, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AdResultData adResultData) {
        if (this.f8909b != null) {
            this.f8909b.a(z, adResultData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.f8909b != null) {
            this.f8909b.b(z);
        }
    }

    public void a() {
        if (this.c != null) {
            this.c.e();
        }
        this.f8909b = null;
        this.f8908a.removeCallbacksAndMessages(null);
    }

    public void a(final boolean z, final long j) {
        if (this.d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "loadData startRequest loadMore =" + z + " lastPhotoId=" + j);
        a(z);
        f fVar = new f(this.f);
        fVar.f9166b = this.f.getPageScene();
        fVar.c = 100L;
        com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "pageScene=" + fVar.f9166b + " lastPhotoId=" + j);
        final a.C1080a c1080a = new a.C1080a(fVar, this.e, j, 15);
        this.c = new i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData>() { // from class: com.kwad.sdk.contentalliance.tube.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(b.this.f);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.contentalliance.tube.b.a b() {
                return new com.kwad.sdk.contentalliance.tube.b.a(c1080a);
            }
        };
        this.c.a(new j<com.kwad.sdk.contentalliance.tube.b.a, AdResultData>() { // from class: com.kwad.sdk.contentalliance.tube.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.a aVar, final int i, final String str) {
                com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "lastPhotoId=" + j + " errorCode = " + i + " errorMsg=" + str);
                b.this.f8908a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.b.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.c("TubeFeedLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        b.this.a(z, i, str);
                        b.this.d.set(false);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.a aVar, @NonNull final AdResultData adResultData) {
                b.this.f8908a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(z, adResultData);
                        b.this.b(z);
                        b.this.d.set(false);
                    }
                });
            }
        });
    }
}
