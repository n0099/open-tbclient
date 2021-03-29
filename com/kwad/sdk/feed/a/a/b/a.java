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
    public ImageView f34795b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34796c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34797d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f34798e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f34799f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f34800g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0401a f34801h;

    /* renamed from: com.kwad.sdk.feed.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0402a implements a.InterfaceC0401a, ap.a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f34802a;

        /* renamed from: b  reason: collision with root package name */
        public final int f34803b = 100;

        public C0402a(a aVar) {
            this.f34802a = new WeakReference<>(aVar);
        }

        @Override // com.kwad.sdk.feed.a.a.InterfaceC0401a
        public void a(int i) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemClickPresenter", "position=" + i);
            a aVar = this.f34802a.get();
            if (aVar == null || aVar.f34799f == null) {
                return;
            }
            aVar.f34799f.k();
            if (aVar.f34800g == null) {
                aVar.f34800g = new ap(this);
            }
            Message obtain = Message.obtain(aVar.f34800g);
            obtain.what = 100;
            obtain.arg1 = i;
            aVar.f34800g.sendMessageDelayed(obtain, 100L);
        }

        @Override // com.kwad.sdk.utils.ap.a
        public void a(Message message) {
            a aVar = this.f34802a.get();
            if (aVar != null && message.what == 100) {
                aVar.f34798e.scrollToPosition(message.arg1);
            }
        }
    }

    private void e() {
        SceneImpl sceneImpl = ((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a).i).mAdScene;
        if (sceneImpl == null) {
            return;
        }
        com.kwad.sdk.feed.a.a.a().a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a).f36005f.g());
        com.kwad.sdk.feed.a.a.a().f();
        com.kwad.sdk.feed.a.a.a().a(f());
        FeedSlideParam feedSlideParam = new FeedSlideParam();
        feedSlideParam.mEntryScene = sceneImpl.entryScene;
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a;
        feedSlideParam.mSelectedPosition = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36007h;
        com.kwad.sdk.feed.detail.a.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f36003d, feedSlideParam);
    }

    private a.InterfaceC0401a f() {
        if (this.f34801h == null) {
            this.f34801h = new C0402a(this);
        }
        return this.f34801h;
    }

    private void g() {
        com.kwad.sdk.core.report.e.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a).i, 1);
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a;
        this.f34797d = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).i;
        this.f34798e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36004e;
        this.f34799f = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36005f;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f34801h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.f34801h);
        }
        Handler handler = this.f34800g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34795b = (ImageView) b(R.id.ksad_feed_item_cover);
        this.f34796c = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f34795b.setOnClickListener(this);
        this.f34796c.setOnClickListener(this);
        l().setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.f34801h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.f34801h);
        }
        Handler handler = this.f34800g;
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
        if (view == this.f34795b) {
            if (com.kwad.sdk.core.response.b.c.c(this.f34797d)) {
                adTemplate = this.f34797d;
                i = 83;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        } else if (view == this.f34796c) {
            if (com.kwad.sdk.core.response.b.c.c(this.f34797d)) {
                adTemplate = this.f34797d;
                i = 24;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        } else {
            if (com.kwad.sdk.core.response.b.c.c(this.f34797d)) {
                adTemplate = this.f34797d;
                i = 79;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        }
    }
}
