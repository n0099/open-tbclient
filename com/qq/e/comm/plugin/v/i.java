package com.qq.e.comm.plugin.v;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwai.video.player.PlayerPostEvent;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.m.i;
import com.qq.e.comm.plugin.m.k;
import com.qq.e.comm.plugin.m.m;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.v.h;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class i extends com.qq.e.comm.plugin.m.b {
    long h;
    View i;
    private e j;
    private f k;
    private m l;
    private c m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, String str, String str2, JSONObject jSONObject, VideoOption2 videoOption2, f fVar) {
        super(context, str, str2, jSONObject, 0, 0, 0, videoOption2);
        this.k = fVar;
        this.m = new c(context, this.j, this);
    }

    @Override // com.qq.e.comm.plugin.m.b
    protected com.qq.e.comm.plugin.m.c a(String str, String str2, String str3, JSONObject jSONObject, int i, int i2, VideoOption2 videoOption2) {
        this.j = new e(str, str2, str3, com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD2, jSONObject, i, i2, videoOption2);
        return this.j;
    }

    @Override // com.qq.e.comm.plugin.m.b
    @NonNull
    protected com.qq.e.comm.plugin.m.e a(Context context, com.qq.e.comm.plugin.m.c cVar, VideoOption2 videoOption2, final i.a aVar, com.qq.e.comm.plugin.y.c cVar2) {
        return new h(context, this.j, videoOption2, new h.a() { // from class: com.qq.e.comm.plugin.v.i.1
            @Override // com.qq.e.comm.plugin.v.h.a
            public void a() {
                i.this.k.e();
            }

            @Override // com.qq.e.comm.plugin.m.i.a
            public void a(int i) {
                if (aVar != null) {
                    aVar.a(i);
                }
            }

            @Override // com.qq.e.comm.plugin.m.i.a
            public void a(k kVar) {
                if (aVar != null) {
                    aVar.a(kVar);
                }
                if (kVar != null) {
                    kVar.a(new m() { // from class: com.qq.e.comm.plugin.v.i.1.1
                        @Override // com.qq.e.comm.plugin.m.m
                        public void a(int i) {
                            if (i.this.l != null) {
                                i.this.l.a(i);
                            }
                        }
                    });
                }
            }
        }, cVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.m.b
    public void a() {
        if (this.f != null) {
            this.f.a(this.j.h() ? 4 : 3);
        }
        super.a();
    }

    @Override // com.qq.e.comm.plugin.m.b
    protected void a(int i, String str) {
        g.a(i, this.e, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.m.b
    public void a(int i, Object... objArr) {
        super.a(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.m.b
    public void a(View view) {
        if (view == null) {
            return;
        }
        if (!this.g) {
            this.h = System.currentTimeMillis();
        }
        this.i = view;
        super.a(this.i);
    }

    public void a(m mVar) {
        this.l = mVar;
    }

    @Override // com.qq.e.comm.plugin.m.b
    protected void a(String str) {
        this.m.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, boolean z, View view) {
        this.m.a(str, z, view);
    }

    @Override // com.qq.e.comm.plugin.m.b
    protected void b(int i) {
        g.b(i, this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.m.b
    public void c(int i) {
        g.c(i, this.e);
    }

    @Override // com.qq.e.comm.plugin.m.b, com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        super.destroy();
        this.i = null;
        this.k = null;
    }

    @Override // com.qq.e.comm.plugin.m.b
    protected void l() {
    }

    @Override // com.qq.e.comm.plugin.m.b
    protected void m() {
        g.b(this.e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.qq.e.comm.plugin.m.b, com.qq.e.comm.plugin.nativeadunified.b
    /* renamed from: o */
    public e n() {
        return this.j;
    }

    @Override // com.qq.e.comm.plugin.m.b, com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(final ADListener aDListener) {
        super.setAdListener(new ADListener() { // from class: com.qq.e.comm.plugin.v.i.2
            private void a(ADEvent aDEvent) {
                if (aDListener != null) {
                    aDListener.onADEvent(aDEvent);
                }
            }

            @Override // com.qq.e.comm.adevent.ADListener
            public void onADEvent(ADEvent aDEvent) {
                if (aDEvent.getType() != 105) {
                    a(aDEvent);
                } else if (i.this.f.n() > n.b(i.this.f12483a) * 1000) {
                    a(new ADEvent(PlayerPostEvent.MEDIA_INFO_UNSUPPORTED_SUBTITLE, null));
                } else {
                    a(aDEvent);
                }
            }
        });
    }
}
