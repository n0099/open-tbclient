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
    public d f32283c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.f.c f32284d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32285e = false;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32286f;

    private com.kwad.sdk.contentalliance.detail.photo.newui.b.a h() {
        com.kwad.sdk.contentalliance.detail.photo.newui.b.a aVar = new com.kwad.sdk.contentalliance.detail.photo.newui.b.a(o());
        aVar.setButtonImageResource(R.drawable.ksad_func_button_photo_share_2);
        aVar.setButtonText("复制链接");
        return aVar;
    }

    private void p() {
        b.a aVar = new b.a();
        LiveInfo A = com.kwad.sdk.core.response.b.c.A(this.f32286f);
        aVar.f36067a = com.kwad.sdk.live.mode.a.b(A);
        aVar.f36068b = com.kwad.sdk.live.mode.a.a(A);
        new k().a(aVar, new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.2
            @Override // com.kwad.sdk.core.g.k.a
            public void a(int i, String str) {
                Context o;
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                if (i == com.kwad.sdk.core.network.f.f33876h.k) {
                    o = f.this.o();
                } else {
                    o = f.this.o();
                    str = "复制链接失败，请稍后重试";
                }
                p.a(o, str);
                if (f.this.f32284d != null) {
                    f.this.f32284d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.f32283c.a(), false);
                f.this.f32285e = false;
            }

            @Override // com.kwad.sdk.core.g.k.a
            public void a(@NonNull PhotoShareInfo photoShareInfo) {
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                if (f.this.f32284d != null) {
                    f.this.f32284d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.f32283c.a(), true);
                f.this.f32285e = false;
            }
        });
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        d dVar = ((a) this).f32258a.f32272a;
        this.f32283c = dVar;
        this.f32286f = dVar.a();
        this.f32284d = ((a) this).f32258a.f32273b;
        com.kwad.sdk.core.report.e.e(this.f32283c.a());
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32284d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: f */
    public LinearLayout g() {
        return h();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f32283c == null) {
            return;
        }
        if (this.f32285e) {
            com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "mIsRequesting= " + this.f32285e);
            return;
        }
        this.f32285e = true;
        if (com.kwad.sdk.core.response.b.c.a(this.f32286f)) {
            p();
        } else {
            new k().a(this.f32283c.b(), new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.1
                @Override // com.kwad.sdk.core.g.k.a
                public void a(int i, String str) {
                    Context o;
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                    if (i == com.kwad.sdk.core.network.f.f33876h.k) {
                        o = f.this.o();
                    } else {
                        o = f.this.o();
                        str = "复制链接失败，请稍后重试";
                    }
                    p.a(o, str);
                    if (f.this.f32284d != null) {
                        f.this.f32284d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.f32283c.a(), false);
                    f.this.f32285e = false;
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(@NonNull PhotoShareInfo photoShareInfo) {
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                    i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                    p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                    if (f.this.f32284d != null) {
                        f.this.f32284d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.f32283c.a(), true);
                    f.this.f32285e = false;
                }
            });
        }
    }
}
