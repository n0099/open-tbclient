package com.kwad.sdk.contentalliance.tube.profile;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.tube.b.b;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private a f8991b;
    private i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> c;
    private long e;
    private SceneImpl f;
    private boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    private Handler f8990a = new Handler(Looper.getMainLooper());

    public c(SceneImpl sceneImpl, long j, a aVar) {
        this.e = j;
        this.f8991b = aVar;
        this.f = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        com.kwad.sdk.core.d.a.c("TubeProfileDataFetcher", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
        b(i, str);
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeProfileResultData tubeProfileResultData) {
        b(tubeProfileResultData);
        d();
        this.d = false;
    }

    private void b(int i, String str) {
        if (this.f8991b != null) {
            this.f8991b.a(i, str);
        }
    }

    private void b(TubeProfileResultData tubeProfileResultData) {
        if (this.f8991b != null) {
            this.f8991b.a(tubeProfileResultData);
        }
    }

    private void c() {
        if (this.f8991b != null) {
            this.f8991b.a();
        }
    }

    private void d() {
        if (this.f8991b != null) {
            this.f8991b.b();
        }
    }

    public void a() {
        if (this.d) {
            return;
        }
        c();
        f fVar = new f(this.f);
        fVar.f9168b = this.f.getPageScene();
        final b.a aVar = new b.a(fVar, this.e, true);
        this.c = new i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public TubeProfileResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TubeProfileResultData tubeProfileResultData = new TubeProfileResultData(c.this.f);
                tubeProfileResultData.parseJson(jSONObject);
                return tubeProfileResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.contentalliance.tube.b.b b() {
                return new com.kwad.sdk.contentalliance.tube.b.b(aVar);
            }
        };
        this.c.a(new j<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, final int i, final String str) {
                c.this.f8990a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, @NonNull final TubeProfileResultData tubeProfileResultData) {
                c.this.f8990a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(tubeProfileResultData);
                    }
                });
            }
        });
    }

    public void b() {
        if (this.c != null) {
            this.c.e();
        }
        this.f8991b = null;
        this.f8990a.removeCallbacksAndMessages(null);
    }
}
