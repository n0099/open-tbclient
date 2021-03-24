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
    public ImageView f34794b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34795c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34796d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f34797e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f34798f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f34799g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0400a f34800h;

    /* renamed from: com.kwad.sdk.feed.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0401a implements a.InterfaceC0400a, ap.a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f34801a;

        /* renamed from: b  reason: collision with root package name */
        public final int f34802b = 100;

        public C0401a(a aVar) {
            this.f34801a = new WeakReference<>(aVar);
        }

        @Override // com.kwad.sdk.feed.a.a.InterfaceC0400a
        public void a(int i) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemClickPresenter", "position=" + i);
            a aVar = this.f34801a.get();
            if (aVar == null || aVar.f34798f == null) {
                return;
            }
            aVar.f34798f.k();
            if (aVar.f34799g == null) {
                aVar.f34799g = new ap(this);
            }
            Message obtain = Message.obtain(aVar.f34799g);
            obtain.what = 100;
            obtain.arg1 = i;
            aVar.f34799g.sendMessageDelayed(obtain, 100L);
        }

        @Override // com.kwad.sdk.utils.ap.a
        public void a(Message message) {
            a aVar = this.f34801a.get();
            if (aVar != null && message.what == 100) {
                aVar.f34797e.scrollToPosition(message.arg1);
            }
        }
    }

    private void e() {
        SceneImpl sceneImpl = ((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).i).mAdScene;
        if (sceneImpl == null) {
            return;
        }
        com.kwad.sdk.feed.a.a.a().a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).f36004f.g());
        com.kwad.sdk.feed.a.a.a().f();
        com.kwad.sdk.feed.a.a.a().a(f());
        FeedSlideParam feedSlideParam = new FeedSlideParam();
        feedSlideParam.mEntryScene = sceneImpl.entryScene;
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a;
        feedSlideParam.mSelectedPosition = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36006h;
        com.kwad.sdk.feed.detail.a.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f36002d, feedSlideParam);
    }

    private a.InterfaceC0400a f() {
        if (this.f34800h == null) {
            this.f34800h = new C0401a(this);
        }
        return this.f34800h;
    }

    private void g() {
        com.kwad.sdk.core.report.e.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).i, 1);
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a;
        this.f34796d = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).i;
        this.f34797e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36003e;
        this.f34798f = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36004f;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f34800h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.f34800h);
        }
        Handler handler = this.f34799g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34794b = (ImageView) b(R.id.ksad_feed_item_cover);
        this.f34795c = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f34794b.setOnClickListener(this);
        this.f34795c.setOnClickListener(this);
        l().setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.f34800h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.f34800h);
        }
        Handler handler = this.f34799g;
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
        if (view == this.f34794b) {
            if (com.kwad.sdk.core.response.b.c.c(this.f34796d)) {
                adTemplate = this.f34796d;
                i = 83;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        } else if (view == this.f34795c) {
            if (com.kwad.sdk.core.response.b.c.c(this.f34796d)) {
                adTemplate = this.f34796d;
                i = 24;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        } else {
            if (com.kwad.sdk.core.response.b.c.c(this.f34796d)) {
                adTemplate = this.f34796d;
                i = 79;
                com.kwad.sdk.core.report.b.d(adTemplate, i);
            }
            e();
            g();
        }
    }
}
