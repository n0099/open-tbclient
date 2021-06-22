package com.kwad.sdk.contentalliance.detail.photo.d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.g.k;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoShareInfo;
import com.kwad.sdk.live.a.b;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class f extends a<LinearLayout> {

    /* renamed from: c  reason: collision with root package name */
    public d f32949c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.f.c f32950d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32951e = false;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32952f;

    private com.kwad.sdk.contentalliance.detail.photo.newui.b.a h() {
        com.kwad.sdk.contentalliance.detail.photo.newui.b.a aVar = new com.kwad.sdk.contentalliance.detail.photo.newui.b.a(o());
        aVar.setButtonImageResource(R.drawable.ksad_func_button_photo_share_2);
        aVar.setButtonText("复制链接");
        return aVar;
    }

    private void p() {
        b.a aVar = new b.a();
        LiveInfo A = com.kwad.sdk.core.response.b.c.A(this.f32952f);
        aVar.f36874a = com.kwad.sdk.live.mode.a.b(A);
        aVar.f36875b = com.kwad.sdk.live.mode.a.a(A);
        new k().a(aVar, new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.2
            @Override // com.kwad.sdk.core.g.k.a
            public void a(int i2, String str) {
                Context o;
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i2 + " msg=" + str);
                if (i2 == com.kwad.sdk.core.network.f.f34602h.k) {
                    o = f.this.o();
                } else {
                    o = f.this.o();
                    str = "复制链接失败，请稍后重试";
                }
                p.a(o, str);
                if (f.this.f32950d != null) {
                    f.this.f32950d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.f32949c.a(), false);
                f.this.f32951e = false;
            }

            @Override // com.kwad.sdk.core.g.k.a
            public void a(@NonNull PhotoShareInfo photoShareInfo) {
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                if (f.this.f32950d != null) {
                    f.this.f32950d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.f32949c.a(), true);
                f.this.f32951e = false;
            }
        });
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        d dVar = ((a) this).f32924a.f32938a;
        this.f32949c = dVar;
        this.f32952f = dVar.a();
        this.f32950d = ((a) this).f32924a.f32939b;
        com.kwad.sdk.core.report.e.e(this.f32949c.a());
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32950d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: f */
    public LinearLayout g() {
        return h();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f32949c == null) {
            return;
        }
        if (this.f32951e) {
            com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "mIsRequesting= " + this.f32951e);
            return;
        }
        this.f32951e = true;
        if (com.kwad.sdk.core.response.b.c.a(this.f32952f)) {
            p();
        } else {
            new k().a(this.f32949c.b(), new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.1
                @Override // com.kwad.sdk.core.g.k.a
                public void a(int i2, String str) {
                    Context o;
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i2 + " msg=" + str);
                    if (i2 == com.kwad.sdk.core.network.f.f34602h.k) {
                        o = f.this.o();
                    } else {
                        o = f.this.o();
                        str = "复制链接失败，请稍后重试";
                    }
                    p.a(o, str);
                    if (f.this.f32950d != null) {
                        f.this.f32950d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.f32949c.a(), false);
                    f.this.f32951e = false;
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(@NonNull PhotoShareInfo photoShareInfo) {
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                    i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                    p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                    if (f.this.f32950d != null) {
                        f.this.f32950d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.f32949c.a(), true);
                    f.this.f32951e = false;
                }
            });
        }
    }
}
