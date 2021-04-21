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
    public a f33697b;

    /* renamed from: c  reason: collision with root package name */
    public i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> f33698c;

    /* renamed from: e  reason: collision with root package name */
    public long f33700e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f33701f;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33699d = false;

    /* renamed from: a  reason: collision with root package name */
    public Handler f33696a = new Handler(Looper.getMainLooper());

    public c(SceneImpl sceneImpl, long j, a aVar) {
        this.f33700e = j;
        this.f33697b = aVar;
        this.f33701f = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        com.kwad.sdk.core.d.a.c("TubeProfileDataFetcher", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
        b(i, str);
        this.f33699d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeProfileResultData tubeProfileResultData) {
        b(tubeProfileResultData);
        d();
        this.f33699d = false;
    }

    private void b(int i, String str) {
        a aVar = this.f33697b;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    private void b(TubeProfileResultData tubeProfileResultData) {
        a aVar = this.f33697b;
        if (aVar != null) {
            aVar.a(tubeProfileResultData);
        }
    }

    private void c() {
        a aVar = this.f33697b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d() {
        a aVar = this.f33697b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void a() {
        if (this.f33699d) {
            return;
        }
        c();
        f fVar = new f(this.f33701f);
        fVar.f34036b = this.f33701f.getPageScene();
        final b.a aVar = new b.a(fVar, this.f33700e, true);
        i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> iVar = new i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public TubeProfileResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TubeProfileResultData tubeProfileResultData = new TubeProfileResultData(c.this.f33701f);
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
        this.f33698c = iVar;
        iVar.a(new j<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData>() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, final int i, final String str) {
                c.this.f33696a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.contentalliance.tube.b.b bVar, @NonNull final TubeProfileResultData tubeProfileResultData) {
                c.this.f33696a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.tube.profile.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(tubeProfileResultData);
                    }
                });
            }
        });
    }

    public void b() {
        i<com.kwad.sdk.contentalliance.tube.b.b, TubeProfileResultData> iVar = this.f33698c;
        if (iVar != null) {
            iVar.e();
        }
        this.f33697b = null;
        this.f33696a.removeCallbacksAndMessages(null);
    }
}
