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
    public d f32572c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.f.c f32573d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32574e = false;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32575f;

    private com.kwad.sdk.contentalliance.detail.photo.newui.b.a h() {
        com.kwad.sdk.contentalliance.detail.photo.newui.b.a aVar = new com.kwad.sdk.contentalliance.detail.photo.newui.b.a(o());
        aVar.setButtonImageResource(R.drawable.ksad_func_button_photo_share_2);
        aVar.setButtonText("复制链接");
        return aVar;
    }

    private void p() {
        b.a aVar = new b.a();
        LiveInfo A = com.kwad.sdk.core.response.b.c.A(this.f32575f);
        aVar.f36356a = com.kwad.sdk.live.mode.a.b(A);
        aVar.f36357b = com.kwad.sdk.live.mode.a.a(A);
        new k().a(aVar, new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.2
            @Override // com.kwad.sdk.core.g.k.a
            public void a(int i, String str) {
                Context o;
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                if (i == com.kwad.sdk.core.network.f.f34165h.k) {
                    o = f.this.o();
                } else {
                    o = f.this.o();
                    str = "复制链接失败，请稍后重试";
                }
                p.a(o, str);
                if (f.this.f32573d != null) {
                    f.this.f32573d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.f32572c.a(), false);
                f.this.f32574e = false;
            }

            @Override // com.kwad.sdk.core.g.k.a
            public void a(@NonNull PhotoShareInfo photoShareInfo) {
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                if (f.this.f32573d != null) {
                    f.this.f32573d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.f32572c.a(), true);
                f.this.f32574e = false;
            }
        });
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        d dVar = ((a) this).f32547a.f32561a;
        this.f32572c = dVar;
        this.f32575f = dVar.a();
        this.f32573d = ((a) this).f32547a.f32562b;
        com.kwad.sdk.core.report.e.e(this.f32572c.a());
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32573d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: f */
    public LinearLayout g() {
        return h();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f32572c == null) {
            return;
        }
        if (this.f32574e) {
            com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "mIsRequesting= " + this.f32574e);
            return;
        }
        this.f32574e = true;
        if (com.kwad.sdk.core.response.b.c.a(this.f32575f)) {
            p();
        } else {
            new k().a(this.f32572c.b(), new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.1
                @Override // com.kwad.sdk.core.g.k.a
                public void a(int i, String str) {
                    Context o;
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                    if (i == com.kwad.sdk.core.network.f.f34165h.k) {
                        o = f.this.o();
                    } else {
                        o = f.this.o();
                        str = "复制链接失败，请稍后重试";
                    }
                    p.a(o, str);
                    if (f.this.f32573d != null) {
                        f.this.f32573d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.f32572c.a(), false);
                    f.this.f32574e = false;
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(@NonNull PhotoShareInfo photoShareInfo) {
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                    i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                    p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                    if (f.this.f32573d != null) {
                        f.this.f32573d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.f32572c.a(), true);
                    f.this.f32574e = false;
                }
            });
        }
    }
}
