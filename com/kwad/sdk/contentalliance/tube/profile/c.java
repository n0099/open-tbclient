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
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public a f34026b;

    /* renamed from: c  reason: collision with root package name */
    public i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> f34027c;

    /* renamed from: e  reason: collision with root package name */
    public long f34029e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f34030f;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34028d = false;

    /* renamed from: a  reason: collision with root package name */
    public Handler f34025a = new Handler(Looper.getMainLooper());

    public c(SceneImpl sceneImpl, long j, a aVar) {
        this.f34029e = j;
        this.f34026b = aVar;
        this.f34030f = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        com.kwad.sdk.core.d.a.c("TubeProfileDataFetcher", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
        b(i2, str);
        this.f34028d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeProfileResultData tubeProfileResultData) {
        b(tubeProfileResultData);
        d();
        this.f34028d = false;
    }

    private void b(int i2, String str) {
        a aVar = this.f34026b;
        if (aVar != null) {
            aVar.a(i2, str);
        }
    }

    private void b(TubeProfileResultData tubeProfileResultData) {
        a aVar = this.f34026b;
        if (aVar != null) {
            aVar.a(tubeProfileResultData);
        }
    }

    private void c() {
        a aVar = this.f34026b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d() {
        a aVar = this.f34026b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void a() {
        if (this.f34028d) {
            return;
        }
        c();
        f fVar = new f(this.f34030f);
        fVar.f34376b = this.f34030f.getPageScene();
        final b.a aVar = new b.a(fVar, this.f34029e, true);
        i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> iVar = new i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public TubeProfileResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TubeProfileResultData tubeProfileResultData = new TubeProfileResultData(c.this.f34030f);
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
        this.f34027c = iVar;
        iVar.a(new j<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, final int i2, final String str) {
                c.this.f34025a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(i2, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, @NonNull final TubeProfileResultData tubeProfileResultData) {
                c.this.f34025a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(tubeProfileResultData);
                    }
                });
            }
        });
    }

    public void b() {
        i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> iVar = this.f34027c;
        if (iVar != null) {
            iVar.e();
        }
        this.f34026b = null;
        this.f34025a.removeCallbacksAndMessages(null);
    }
}
