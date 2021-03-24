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
    public a f33312b;

    /* renamed from: c  reason: collision with root package name */
    public i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> f33313c;

    /* renamed from: e  reason: collision with root package name */
    public long f33315e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f33316f;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33314d = false;

    /* renamed from: a  reason: collision with root package name */
    public Handler f33311a = new Handler(Looper.getMainLooper());

    public c(SceneImpl sceneImpl, long j, a aVar) {
        this.f33315e = j;
        this.f33312b = aVar;
        this.f33316f = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        com.kwad.sdk.core.d.a.c("TubeProfileDataFetcher", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
        b(i, str);
        this.f33314d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeProfileResultData tubeProfileResultData) {
        b(tubeProfileResultData);
        d();
        this.f33314d = false;
    }

    private void b(int i, String str) {
        a aVar = this.f33312b;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    private void b(TubeProfileResultData tubeProfileResultData) {
        a aVar = this.f33312b;
        if (aVar != null) {
            aVar.a(tubeProfileResultData);
        }
    }

    private void c() {
        a aVar = this.f33312b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d() {
        a aVar = this.f33312b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void a() {
        if (this.f33314d) {
            return;
        }
        c();
        f fVar = new f(this.f33316f);
        fVar.f33651b = this.f33316f.getPageScene();
        final b.a aVar = new b.a(fVar, this.f33315e, true);
        i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> iVar = new i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public TubeProfileResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TubeProfileResultData tubeProfileResultData = new TubeProfileResultData(c.this.f33316f);
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
        this.f33313c = iVar;
        iVar.a(new j<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, final int i, final String str) {
                c.this.f33311a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, @NonNull final TubeProfileResultData tubeProfileResultData) {
                c.this.f33311a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(tubeProfileResultData);
                    }
                });
            }
        });
    }

    public void b() {
        i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> iVar = this.f33313c;
        if (iVar != null) {
            iVar.e();
        }
        this.f33312b = null;
        this.f33311a.removeCallbacksAndMessages(null);
    }
}
