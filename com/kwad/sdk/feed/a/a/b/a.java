package com.kwad.sdk.feed.a.a.b;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.a.a;
import com.kwad.sdk.feed.detail.FeedSlideParam;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35553b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35554c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35555d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f35556e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f35557f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f35558g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0404a f35559h;

    /* renamed from: com.kwad.sdk.feed.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0405a implements a.InterfaceC0404a, ap.a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f35560a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35561b = 100;

        public C0405a(a aVar) {
            this.f35560a = new WeakReference<>(aVar);
        }

        @Override // com.kwad.sdk.feed.a.a.InterfaceC0404a
        public void a(int i2) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemClickPresenter", "position=" + i2);
            a aVar = this.f35560a.get();
            if (aVar == null || aVar.f35557f == null) {
                return;
            }
            aVar.f35557f.k();
            if (aVar.f35558g == null) {
                aVar.f35558g = new ap(this);
            }
            Message obtain = Message.obtain(aVar.f35558g);
            obtain.what = 100;
            obtain.arg1 = i2;
            aVar.f35558g.sendMessageDelayed(obtain, 100L);
        }

        @Override // com.kwad.sdk.utils.ap.a
        public void a(Message message) {
            a aVar = this.f35560a.get();
            if (aVar != null && message.what == 100) {
                aVar.f35556e.scrollToPosition(message.arg1);
            }
        }
    }

    private void e() {
        SceneImpl sceneImpl = ((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a).f36810i).mAdScene;
        if (sceneImpl == null) {
            return;
        }
        com.kwad.sdk.feed.a.a.a().a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a).f36807f.g());
        com.kwad.sdk.feed.a.a.a().f();
        com.kwad.sdk.feed.a.a.a().a(f());
        FeedSlideParam feedSlideParam = new FeedSlideParam();
        feedSlideParam.mEntryScene = sceneImpl.entryScene;
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a;
        feedSlideParam.mSelectedPosition = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36809h;
        com.kwad.sdk.feed.detail.a.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f36805d, feedSlideParam);
    }

    private a.InterfaceC0404a f() {
        if (this.f35559h == null) {
            this.f35559h = new C0405a(this);
        }
        return this.f35559h;
    }

    private void g() {
        com.kwad.sdk.core.report.e.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a).f36810i, 1);
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a;
        this.f35555d = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36810i;
        this.f35556e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36806e;
        this.f35557f = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36807f;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f35559h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.f35559h);
        }
        Handler handler = this.f35558g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35553b = (ImageView) b(R.id.ksad_feed_item_cover);
        this.f35554c = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f35553b.setOnClickListener(this);
        this.f35554c.setOnClickListener(this);
        l().setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.f35559h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.f35559h);
        }
        Handler handler = this.f35558g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        int i2;
        if (ao.a()) {
            return;
        }
        if (view == this.f35553b) {
            if (com.kwad.sdk.core.response.b.c.c(this.f35555d)) {
                adTemplate = this.f35555d;
                i2 = 83;
                com.kwad.sdk.core.report.b.d(adTemplate, i2);
            }
            e();
            g();
        } else if (view == this.f35554c) {
            if (com.kwad.sdk.core.response.b.c.c(this.f35555d)) {
                adTemplate = this.f35555d;
                i2 = 24;
                com.kwad.sdk.core.report.b.d(adTemplate, i2);
            }
            e();
            g();
        } else {
            if (com.kwad.sdk.core.response.b.c.c(this.f35555d)) {
                adTemplate = this.f35555d;
                i2 = 79;
                com.kwad.sdk.core.report.b.d(adTemplate, i2);
            }
            e();
            g();
        }
    }
}
