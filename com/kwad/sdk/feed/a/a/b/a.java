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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35084b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35085c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35086d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f35087e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f35088f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f35089g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0415a f35090h;

    /* renamed from: com.kwad.sdk.feed.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0416a implements a.InterfaceC0415a, ap.a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f35091a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35092b = 100;

        public C0416a(a aVar) {
            this.f35091a = new WeakReference<>(aVar);
        }

        @Override // com.kwad.sdk.feed.a.a.InterfaceC0415a
        public void a(int i) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemClickPresenter", "position=" + i);
            a aVar = this.f35091a.get();
            if (aVar == null || aVar.f35088f == null) {
                return;
            }
            aVar.f35088f.k();
            if (aVar.f35089g == null) {
                aVar.f35089g = new ap(this);
            }
            Message obtain = Message.obtain(aVar.f35089g);
            obtain.what = 100;
            obtain.arg1 = i;
            aVar.f35089g.sendMessageDelayed(obtain, 100L);
        }

        @Override // com.kwad.sdk.utils.ap.a
        public void a(Message message) {
            a aVar = this.f35091a.get();
            if (aVar != null && message.what == 100) {
                aVar.f35087e.scrollToPosition(message.arg1);
            }
        }
    }

    private void e() {
        SceneImpl sceneImpl = ((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i).mAdScene;
        if (sceneImpl == null) {
            return;
        }
        com.kwad.sdk.feed.a.a.a().a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).f36294f.g());
        com.kwad.sdk.feed.a.a.a().f();
        com.kwad.sdk.feed.a.a.a().a(f());
        FeedSlideParam feedSlideParam = new FeedSlideParam();
        feedSlideParam.mEntryScene = sceneImpl.entryScene;
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a;
        feedSlideParam.mSelectedPosition = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36296h;
        com.kwad.sdk.feed.detail.a.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f36292d, feedSlideParam);
    }

    private a.InterfaceC0415a f() {
        if (this.f35090h == null) {
            this.f35090h = new C0416a(this);
        }
        return this.f35090h;
    }

    private void g() {
        com.kwad.sdk.core.report.e.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i, 1);
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a;
        this.f35086d = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).i;
        this.f35087e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36293e;
        this.f35088f = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36294f;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f35090h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.f35090h);
        }
        Handler handler = this.f35089g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35084b = (ImageView) b(R.id.ksad_feed_item_cover);
        this.f35085c = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f35084b.setOnClickListener(this);
        this.f35085c.setOnClickListener(this);
        l().setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.f35090h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.f35090h);
        }
        Handler handler = this.f35089g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        int i;
        if (ao.a()) {
            return;
        }
        if (view == this.f35084b) {
            if (com.kwad.sdk.core.response.b.c.c(this.f35086d)) {
                adTemplate = this.f35086d;
                i = 83;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        } else if (view == this.f35085c) {
            if (com.kwad.sdk.core.response.b.c.c(this.f35086d)) {
                adTemplate = this.f35086d;
                i = 24;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        } else {
            if (com.kwad.sdk.core.response.b.c.c(this.f35086d)) {
                adTemplate = this.f35086d;
                i = 79;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        }
    }
}
