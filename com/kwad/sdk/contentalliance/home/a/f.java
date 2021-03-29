package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfoResultData;
import com.kwad.sdk.utils.ag;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public boolean f32583c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32584d = false;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f32585e;

    /* renamed from: f  reason: collision with root package name */
    public String f32586f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData> f32587g;

    public f(SceneImpl sceneImpl, boolean z) {
        this.f32585e = sceneImpl;
        this.f32583c = z;
    }

    private boolean e() {
        return !"no_more".equals(this.f32586f);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.f32584d) {
            return;
        }
        this.f32584d = true;
        a(z, z2, i, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f32562a.clear();
                    m.e();
                    f.this.f32562a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    if (!f.this.f32562a.isEmpty()) {
                        f fVar = f.this;
                        List<AdTemplate> list = fVar.f32562a;
                        fVar.f32586f = list.get(list.size() - 1).mLiveInfo.pcursor;
                    }
                    com.kwad.sdk.contentalliance.home.c.c();
                    f.this.a(z, 0);
                    f.this.f32584d = false;
                }
            });
        } else if (!this.f32583c) {
            this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.5
                @Override // java.lang.Runnable
                public void run() {
                    f fVar = f.this;
                    com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f33875g;
                    fVar.a(fVar2.k, fVar2.l);
                    f.this.f32584d = false;
                }
            });
        } else if (!e()) {
            this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f fVar = f.this;
                    com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f33875g;
                    fVar.a(fVar2.k, fVar2.l);
                    f.this.f32584d = false;
                }
            });
        } else {
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.f.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public LiveInfoResultData b(String str) {
                    LiveInfoResultData liveInfoResultData = new LiveInfoResultData();
                    liveInfoResultData.parseJson(new JSONObject(str));
                    return liveInfoResultData;
                }

                @Override // com.kwad.sdk.core.network.i
                public boolean a_() {
                    return false;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public com.kwad.sdk.core.network.g b() {
                    return ag.a(f.this.f32586f) ? new com.kwad.sdk.live.a.a() : new com.kwad.sdk.live.a.a(f.this.f32586f);
                }
            };
            this.f32587g = iVar;
            iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, LiveInfoResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.f.4
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i2, final String str) {
                    f.this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.a(i2, str);
                            f.this.f32584d = false;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final LiveInfoResultData liveInfoResultData) {
                    f.this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (z) {
                                f.this.f32562a.clear();
                            }
                            if (f.this.f32562a.isEmpty()) {
                                m.e();
                            }
                            f.this.f32586f = liveInfoResultData.pcursor;
                            f fVar = f.this;
                            fVar.f32562a.addAll(com.kwad.sdk.live.mode.a.a(liveInfoResultData, fVar.f32585e));
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            f.this.a(z, 0);
                            f.this.f32584d = false;
                        }
                    });
                }
            });
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData> iVar = this.f32587g;
        if (iVar != null) {
            iVar.e();
        }
    }
}
