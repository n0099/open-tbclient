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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public a f33746b;

    /* renamed from: c  reason: collision with root package name */
    public i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData> f33747c;

    /* renamed from: e  reason: collision with root package name */
    public long f33749e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f33750f;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f33748d = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public Handler f33745a = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public interface a {
        @MainThread
        void a(boolean z);

        @MainThread
        void a(boolean z, int i2, String str);

        @MainThread
        void a(boolean z, @NonNull AdResultData adResultData);

        @MainThread
        void b(boolean z);
    }

    public b(SceneImpl sceneImpl, long j, a aVar) {
        this.f33750f = sceneImpl;
        this.f33749e = j;
        this.f33746b = aVar;
    }

    private void a(boolean z) {
        a aVar = this.f33746b;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2, String str) {
        a aVar = this.f33746b;
        if (aVar != null) {
            aVar.a(z, i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AdResultData adResultData) {
        a aVar = this.f33746b;
        if (aVar != null) {
            aVar.a(z, adResultData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        a aVar = this.f33746b;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public void a() {
        i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData> iVar = this.f33747c;
        if (iVar != null) {
            iVar.e();
        }
        this.f33746b = null;
        this.f33745a.removeCallbacksAndMessages(null);
    }

    public void a(final boolean z, final long j) {
        if (this.f33748d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "loadData startRequest loadMore =" + z + " lastPhotoId=" + j);
        a(z);
        f fVar = new f(this.f33750f);
        fVar.f34278b = (long) this.f33750f.getPageScene();
        fVar.f34279c = 100L;
        com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "pageScene=" + fVar.f34278b + " lastPhotoId=" + j);
        final a.C0371a c0371a = new a.C0371a(fVar, this.f33749e, j, 15);
        i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData> iVar = new i<com.kwad.sdk.contentalliance.tube.b.a, AdResultData>() { // from class: com.kwad.sdk.contentalliance.tube.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(b.this.f33750f);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.contentalliance.tube.b.a b() {
                return new com.kwad.sdk.contentalliance.tube.b.a(c0371a);
            }
        };
        this.f33747c = iVar;
        iVar.a(new j<com.kwad.sdk.contentalliance.tube.b.a, AdResultData>() { // from class: com.kwad.sdk.contentalliance.tube.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.a aVar, final int i2, final String str) {
                com.kwad.sdk.core.d.a.a("TubeFeedLoadManager", "lastPhotoId=" + j + " errorCode = " + i2 + " errorMsg=" + str);
                b.this.f33745a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.b.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.c("TubeFeedLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        b.this.a(z, i2, str);
                        b.this.f33748d.set(false);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.a aVar, @NonNull final AdResultData adResultData) {
                b.this.f33745a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        b.this.a(z, adResultData);
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        b.this.b(z);
                        b.this.f33748d.set(false);
                    }
                });
            }
        });
    }
}
