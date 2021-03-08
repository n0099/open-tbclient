package com.kwad.sdk.contentalliance.detail.photo.d;

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
/* loaded from: classes3.dex */
public class f extends a<LinearLayout> {
    public d c;
    private com.kwad.sdk.contentalliance.detail.photo.f.c d;
    private boolean e = false;
    private AdTemplate f;

    private com.kwad.sdk.contentalliance.detail.photo.newui.b.a h() {
        com.kwad.sdk.contentalliance.detail.photo.newui.b.a aVar = new com.kwad.sdk.contentalliance.detail.photo.newui.b.a(o());
        aVar.setButtonImageResource(R.drawable.ksad_func_button_photo_share_2);
        aVar.setButtonText("复制链接");
        return aVar;
    }

    private void p() {
        b.a aVar = new b.a();
        LiveInfo A = com.kwad.sdk.core.response.b.c.A(this.f);
        aVar.f6908a = com.kwad.sdk.live.mode.a.b(A);
        aVar.b = com.kwad.sdk.live.mode.a.a(A);
        new k().a(aVar, new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.2
            @Override // com.kwad.sdk.core.g.k.a
            public void a(int i, String str) {
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                if (i == com.kwad.sdk.core.network.f.h.k) {
                    p.a(f.this.o(), str);
                } else {
                    p.a(f.this.o(), "复制链接失败，请稍后重试");
                }
                if (f.this.d != null) {
                    f.this.d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.c.a(), false);
                f.this.e = false;
            }

            @Override // com.kwad.sdk.core.g.k.a
            public void a(@NonNull PhotoShareInfo photoShareInfo) {
                com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                if (f.this.d != null) {
                    f.this.d.a(f.this);
                }
                com.kwad.sdk.core.report.e.a(f.this.c.a(), true);
                f.this.e = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f5639a.f5646a;
        this.f = this.c.a();
        this.d = this.f5639a.b;
        com.kwad.sdk.core.report.e.e(this.c.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: f */
    public LinearLayout g() {
        return h();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c == null) {
            return;
        }
        if (this.e) {
            com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "mIsRequesting= " + this.e);
            return;
        }
        this.e = true;
        if (com.kwad.sdk.core.response.b.c.a(this.f)) {
            p();
        } else {
            new k().a(this.c.b(), new k.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.1
                @Override // com.kwad.sdk.core.g.k.a
                public void a(int i, String str) {
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                    if (i == com.kwad.sdk.core.network.f.h.k) {
                        p.a(f.this.o(), str);
                    } else {
                        p.a(f.this.o(), "复制链接失败，请稍后重试");
                    }
                    if (f.this.d != null) {
                        f.this.d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.c.a(), false);
                    f.this.e = false;
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(@NonNull PhotoShareInfo photoShareInfo) {
                    com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                    i.a(f.this.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                    p.a(f.this.o(), "链接已经复制\n快分享给好友吧");
                    if (f.this.d != null) {
                        f.this.d.a(f.this);
                    }
                    com.kwad.sdk.core.report.e.a(f.this.c.a(), true);
                    f.this.e = false;
                }
            });
        }
    }
}
