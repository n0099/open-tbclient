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
    public d f32851c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.f.c f32852d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32853e = false;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32854f;

    private com.kwad.sdk.contentalliance.detail.photo.newui.b.a h() {
        com.kwad.sdk.contentalliance.detail.photo.newui.b.a aVar = new com.kwad.sdk.contentalliance.detail.photo.newui.b.a(o());
        aVar.setButtonImageResource(R.drawable.ksad_func_button_photo_share_2);
        aVar.setButtonText("复制链接");
        return aVar;
    }

    private void p() {
        b.a aVar = new b.a();
        LiveInfo A = com.kwad.sdk.core.response.b.c.A(this.f32854f);
        aVar.f36776a = com.kwad.sdk.live.mode.a.b(A);
        aVar.f36777b = com.kwad.sdk.live.mode.a.a(A);
        new k().a(aVar, new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.2
            @Override // com.kwad.sdk.core.g.k.a
            public void a(int i2, String str) {
                Context o;
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i2 + " msg=" + str);
                if (i2 == com.kwad.sdk.core.network.f.f34504h.k) {
                    o = f.this.o();
                } else {
                    o = f.this.o();
                    str = "复制链接失败，请稍后重试";
                }
                p.a(o, str);
                if (f.this.f32852d != null) {
                    f.this.f32852d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.f32851c.a(), false);
                f.this.f32853e = false;
            }

            @Override // com.kwad.sdk.core.g.k.a
            public void a(@NonNull PhotoShareInfo photoShareInfo) {
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                if (f.this.f32852d != null) {
                    f.this.f32852d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.f32851c.a(), true);
                f.this.f32853e = false;
            }
        });
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        d dVar = ((a) this).f32826a.f32840a;
        this.f32851c = dVar;
        this.f32854f = dVar.a();
        this.f32852d = ((a) this).f32826a.f32841b;
        com.kwad.sdk.core.report.e.e(this.f32851c.a());
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32852d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: f */
    public LinearLayout g() {
        return h();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f32851c == null) {
            return;
        }
        if (this.f32853e) {
            com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "mIsRequesting= " + this.f32853e);
            return;
        }
        this.f32853e = true;
        if (com.kwad.sdk.core.response.b.c.a(this.f32854f)) {
            p();
        } else {
            new k().a(this.f32851c.b(), new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.1
                @Override // com.kwad.sdk.core.g.k.a
                public void a(int i2, String str) {
                    Context o;
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i2 + " msg=" + str);
                    if (i2 == com.kwad.sdk.core.network.f.f34504h.k) {
                        o = f.this.o();
                    } else {
                        o = f.this.o();
                        str = "复制链接失败，请稍后重试";
                    }
                    p.a(o, str);
                    if (f.this.f32852d != null) {
                        f.this.f32852d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.f32851c.a(), false);
                    f.this.f32853e = false;
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(@NonNull PhotoShareInfo photoShareInfo) {
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                    i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                    p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                    if (f.this.f32852d != null) {
                        f.this.f32852d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.f32851c.a(), true);
                    f.this.f32853e = false;
                }
            });
        }
    }
}
