package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfoResultData;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends a {
    private boolean c;
    private boolean d = false;
    private SceneImpl e;
    private String f;
    private com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData> g;

    public f(SceneImpl sceneImpl, boolean z) {
        this.e = sceneImpl;
        this.c = z;
    }

    private boolean e() {
        return !"no_more".equals(this.f);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.d) {
            return;
        }
        this.d = true;
        a(z, z2, i, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f8623b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f8622a.clear();
                    m.e();
                    f.this.f8622a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    if (!f.this.f8622a.isEmpty()) {
                        f.this.f = f.this.f8622a.get(f.this.f8622a.size() - 1).mLiveInfo.pcursor;
                    }
                    com.kwad.sdk.contentalliance.home.c.c();
                    f.this.a(z, 0);
                    f.this.d = false;
                }
            });
        } else if (!this.c) {
            this.f8623b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.5
                @Override // java.lang.Runnable
                public void run() {
                    f.this.a(com.kwad.sdk.core.network.f.g.k, com.kwad.sdk.core.network.f.g.l);
                    f.this.d = false;
                }
            });
        } else if (!e()) {
            this.f8623b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.this.a(com.kwad.sdk.core.network.f.g.k, com.kwad.sdk.core.network.f.g.l);
                    f.this.d = false;
                }
            });
        } else {
            this.g = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.f.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public LiveInfoResultData b(String str) {
                    LiveInfoResultData liveInfoResultData = new LiveInfoResultData();
                    liveInfoResultData.parseJson(new JSONObject(str));
                    return liveInfoResultData;
                }

                @Override // com.kwad.sdk.core.network.i
                protected boolean a_() {
                    return false;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public com.kwad.sdk.core.network.g b() {
                    return ag.a(f.this.f) ? new com.kwad.sdk.live.a.a() : new com.kwad.sdk.live.a.a(f.this.f);
                }
            };
            this.g.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, LiveInfoResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.f.4
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i2, final String str) {
                    f.this.f8623b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.a(i2, str);
                            f.this.d = false;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final LiveInfoResultData liveInfoResultData) {
                    f.this.f8623b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.f.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z) {
                                f.this.f8622a.clear();
                            }
                            if (f.this.f8622a.isEmpty()) {
                                m.e();
                            }
                            f.this.f = liveInfoResultData.pcursor;
                            f.this.f8622a.addAll(com.kwad.sdk.live.mode.a.a(liveInfoResultData, f.this.e));
                            f.this.a(z, 0);
                            f.this.d = false;
                        }
                    });
                }
            });
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        if (this.g != null) {
            this.g.e();
        }
    }
}
