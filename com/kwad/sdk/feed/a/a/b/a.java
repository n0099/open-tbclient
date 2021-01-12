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
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9811b;
    private TextView c;
    private AdTemplate d;
    private RecyclerView e;
    private com.kwad.sdk.lib.b.c<?, AdTemplate> f;
    private Handler g;
    private a.InterfaceC1110a h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.feed.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1111a implements a.InterfaceC1110a, ap.a {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f9812a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9813b = 100;

        public C1111a(a aVar) {
            this.f9812a = new WeakReference<>(aVar);
        }

        @Override // com.kwad.sdk.feed.a.a.InterfaceC1110a
        public void a(int i) {
            com.kwad.sdk.core.d.a.a("FeedHomeItemClickPresenter", "position=" + i);
            a aVar = this.f9812a.get();
            if (aVar == null || aVar.f == null) {
                return;
            }
            aVar.f.k();
            if (aVar.g == null) {
                aVar.g = new ap(this);
            }
            Message obtain = Message.obtain(aVar.g);
            obtain.what = 100;
            obtain.arg1 = i;
            aVar.g.sendMessageDelayed(obtain, 100L);
        }

        @Override // com.kwad.sdk.utils.ap.a
        public void a(Message message) {
            a aVar = this.f9812a.get();
            if (aVar == null) {
                return;
            }
            switch (message.what) {
                case 100:
                    aVar.e.scrollToPosition(message.arg1);
                    return;
                default:
                    return;
            }
        }
    }

    private void e() {
        SceneImpl sceneImpl = ((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10452a).i).mAdScene;
        if (sceneImpl == null) {
            return;
        }
        com.kwad.sdk.feed.a.a.a().a(((com.kwad.sdk.feed.a.a.a.b) this.f10452a).f.g());
        com.kwad.sdk.feed.a.a.a().f();
        com.kwad.sdk.feed.a.a.a().a(f());
        FeedSlideParam feedSlideParam = new FeedSlideParam();
        feedSlideParam.mEntryScene = sceneImpl.entryScene;
        feedSlideParam.mSelectedPosition = ((com.kwad.sdk.feed.a.a.a.b) this.f10452a).h;
        com.kwad.sdk.feed.detail.a.a(((com.kwad.sdk.feed.a.a.a.b) this.f10452a).d, feedSlideParam);
    }

    private a.InterfaceC1110a f() {
        if (this.h == null) {
            this.h = new C1111a(this);
        }
        return this.h;
    }

    private void g() {
        com.kwad.sdk.core.report.e.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10452a).i, 1);
    }

    /* JADX DEBUG: Type inference failed for r0v9. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10452a).i;
        this.e = ((com.kwad.sdk.feed.a.a.a.b) this.f10452a).e;
        this.f = ((com.kwad.sdk.feed.a.a.a.b) this.f10452a).f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.h);
        }
        if (this.g != null) {
            this.g.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9811b = (ImageView) b(R.id.ksad_feed_item_cover);
        this.c = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f9811b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        l().setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.h != null) {
            com.kwad.sdk.feed.a.a.a().b(this.h);
        }
        if (this.g != null) {
            this.g.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        if (view == this.f9811b) {
            if (com.kwad.sdk.core.response.b.c.c(this.d)) {
                com.kwad.sdk.core.report.b.d(this.d, 83);
            }
        } else if (view == this.c) {
            if (com.kwad.sdk.core.response.b.c.c(this.d)) {
                com.kwad.sdk.core.report.b.d(this.d, 24);
            }
        } else if (com.kwad.sdk.core.response.b.c.c(this.d)) {
            com.kwad.sdk.core.report.b.d(this.d, 79);
        }
        e();
        g();
    }
}
