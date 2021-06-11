package com.kwad.sdk.entry.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.CommonUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.glide.load.resource.bitmap.o;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.glide.webp.decoder.WebpFrameCacheStrategy;
import com.kwad.sdk.glide.webp.decoder.k;
import com.kwad.sdk.glide.webp.decoder.n;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.widget.AnimatedImageView;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EntryPhotoView extends com.kwad.sdk.widget.a implements View.OnClickListener, g.a {

    /* renamed from: a  reason: collision with root package name */
    public static final s.a f35382a = new s.a();
    public RelativeLayout A;
    public g B;
    public Runnable C;
    public boolean D;
    public View.OnClickListener E;

    /* renamed from: b  reason: collision with root package name */
    public AnimatedImageView f35383b;

    /* renamed from: c  reason: collision with root package name */
    public RoundAngleImageView f35384c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35385d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35386e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35387f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f35388g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f35389h;

    /* renamed from: i  reason: collision with root package name */
    public PhotoInfo f35390i;
    public AdInfo j;
    public boolean k;
    public boolean l;
    public View m;
    public int n;
    public String o;
    public g p;
    public int q;
    public com.kwad.sdk.core.download.b.b r;
    public KsAppDownloadListener s;
    public boolean t;
    public ViewStub u;
    public RoundAngleImageView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public boolean z;

    public EntryPhotoView(@NonNull Context context) {
        super(context);
        this.q = 1;
        this.z = false;
    }

    public EntryPhotoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = 1;
        this.z = false;
    }

    private void a(int i2) {
        ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = ao.a(getContext(), i2);
        this.A.setClickable(true);
        this.A.setOnClickListener(this);
    }

    private void a(int i2, int i3) {
        this.v.setRadius(ao.a(getContext(), 4.0f));
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        layoutParams.width = ao.a(getContext(), i2);
        layoutParams.height = ao.a(getContext(), i3);
        this.v.setClickable(true);
        this.v.setOnClickListener(this);
        com.kwad.sdk.glide.c.b(getContext()).a(com.kwad.sdk.core.response.b.c.q(this.f35389h)).a(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).b(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).c(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).a((e) new com.kwad.sdk.c(com.kwad.sdk.core.response.b.a.o(this.j), this.f35389h)).a((ImageView) this.v);
    }

    private void a(int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = ao.a(getContext(), i2);
        this.x.setClickable(true);
        this.x.setOnClickListener(this);
        setSelectedAdButton(this.f35389h.mHasEntryAdClick);
        this.x.setTextSize(i3);
        this.x.setMaxWidth(ao.a(getContext(), i4));
        this.x.setText(com.kwad.sdk.core.response.b.a.w(this.j));
        g gVar = new g(this.x, 30);
        this.B = gVar;
        gVar.a(new g.a() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.5
            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                if (EntryPhotoView.this.x == null) {
                    return;
                }
                if (EntryPhotoView.this.f35389h.mHasEntryAdClick) {
                    EntryPhotoView.this.setSelectedAdButton(true);
                } else if (!z) {
                    EntryPhotoView.this.setSelectedAdButton(false);
                    EntryPhotoView.this.D = false;
                    EntryPhotoView.this.x.removeCallbacks(EntryPhotoView.this.C);
                } else if (EntryPhotoView.this.D) {
                } else {
                    EntryPhotoView.this.x.removeCallbacks(EntryPhotoView.this.C);
                    EntryPhotoView.this.C = new Runnable() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            EntryPhotoView.this.setSelectedAdButton(true);
                        }
                    };
                    EntryPhotoView.this.x.postDelayed(EntryPhotoView.this.C, 1300L);
                    EntryPhotoView.this.D = true;
                }
            }
        });
        g gVar2 = this.B;
        if (gVar2 != null) {
            gVar2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        com.kwad.sdk.core.report.b.a(this.f35389h, i2, getTouchCoords());
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.s == null) {
            this.s = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.6
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    EntryPhotoView.this.x.setText(CommonUtils.DIALOG_POS_TEXT);
                    ViewGroup.LayoutParams layoutParams = EntryPhotoView.this.x.getLayoutParams();
                    layoutParams.width = -2;
                    EntryPhotoView.this.x.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    EntryPhotoView.this.x.setText(com.kwad.sdk.core.response.b.a.w(EntryPhotoView.this.j));
                    ViewGroup.LayoutParams layoutParams = EntryPhotoView.this.x.getLayoutParams();
                    layoutParams.width = -2;
                    EntryPhotoView.this.x.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    EntryPhotoView.this.x.setText(com.kwad.sdk.core.response.b.a.a(EntryPhotoView.this.f35389h));
                    ViewGroup.LayoutParams layoutParams = EntryPhotoView.this.x.getLayoutParams();
                    layoutParams.width = -2;
                    EntryPhotoView.this.x.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    EntryPhotoView.this.x.setText(com.kwad.sdk.core.response.b.a.w(EntryPhotoView.this.j));
                    ViewGroup.LayoutParams layoutParams = EntryPhotoView.this.x.getLayoutParams();
                    layoutParams.width = -2;
                    EntryPhotoView.this.x.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    EntryPhotoView.this.x.setText(com.kwad.sdk.core.response.b.a.b());
                    ViewGroup.LayoutParams layoutParams = EntryPhotoView.this.x.getLayoutParams();
                    layoutParams.width = -2;
                    EntryPhotoView.this.x.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    TextView textView = EntryPhotoView.this.x;
                    textView.setText("下载中..." + i2 + "%");
                    ViewGroup.LayoutParams layoutParams = EntryPhotoView.this.x.getLayoutParams();
                    layoutParams.width = -2;
                    EntryPhotoView.this.x.setLayoutParams(layoutParams);
                }
            };
        }
        return this.s;
    }

    private void m() {
        this.f35385d.setVisibility(8);
        this.f35386e.setText(com.kwad.sdk.core.response.b.a.n(this.j));
        n();
        p();
        s();
        if (com.kwad.sdk.core.response.b.a.y(this.j) && this.r == null) {
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f35389h);
            this.r = bVar;
            bVar.a(getAppDownloadListener());
        }
    }

    private void n() {
        this.f35386e.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.c.c(EntryPhotoView.this.f35389h)) {
                    com.kwad.sdk.core.report.b.d(EntryPhotoView.this.f35389h, 24);
                }
                if (EntryPhotoView.this.E != null) {
                    EntryPhotoView.this.E.onClick(EntryPhotoView.this);
                }
            }
        });
        this.f35383b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.c.c(EntryPhotoView.this.f35389h)) {
                    com.kwad.sdk.core.report.b.d(EntryPhotoView.this.f35389h, 83);
                }
                if (EntryPhotoView.this.E != null) {
                    EntryPhotoView.this.E.onClick(EntryPhotoView.this);
                }
            }
        });
        this.f35384c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.c.c(EntryPhotoView.this.f35389h)) {
                    com.kwad.sdk.core.report.b.d(EntryPhotoView.this.f35389h, 83);
                }
                if (EntryPhotoView.this.E != null) {
                    EntryPhotoView.this.E.onClick(EntryPhotoView.this);
                }
            }
        });
    }

    private void o() {
        if (this.f35390i == null) {
            return;
        }
        p();
        long m = d.m(this.f35390i);
        this.f35385d.setVisibility(0);
        this.f35385d.setText(ag.a(m, "0"));
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "videoDescPos=" + this.f35388g.f34709i + " videoDesc=" + this.f35390i.baseInfo.videoDesc);
        if (this.f35388g.f34709i != 1 || TextUtils.isEmpty(this.f35390i.baseInfo.videoDesc)) {
            this.f35386e.setVisibility(8);
            return;
        }
        this.f35386e.setVisibility(0);
        this.f35386e.setText(this.f35390i.baseInfo.videoDesc);
    }

    private void p() {
        String D = com.kwad.sdk.core.response.b.c.D(this.f35389h);
        setBackgroundImageView(com.kwad.sdk.core.response.b.c.p(this.f35389h));
        c();
        if (this.k) {
            com.kwad.sdk.core.d.a.a("EntryPhotoView", "coverUrl=" + D);
            if (!TextUtils.isEmpty(D) && FrameSequence.isEnable()) {
                h<Bitmap> oVar = q() ? new o() : new com.kwad.sdk.glide.load.resource.bitmap.g();
                com.kwad.sdk.glide.c.b(getContext()).a(D).a(getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getResources().getDrawable(R.drawable.ksad_loading_entry)).b(oVar).a(k.class, new n(oVar)).a((com.kwad.sdk.glide.load.d<com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy>>) com.kwad.sdk.glide.webp.decoder.o.f36569a, (com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy>) WebpFrameCacheStrategy.f36518b).a(com.kwad.sdk.glide.load.engine.h.f36227d).a((e) new com.kwad.sdk.c(D, this.f35389h)).a((ImageView) this.f35383b);
                return;
            }
        }
        setCoverImageView(com.kwad.sdk.core.response.b.c.o(this.f35389h).a());
    }

    private boolean q() {
        com.kwad.sdk.core.response.model.c n = com.kwad.sdk.core.response.b.c.n(this.f35389h);
        return com.kwad.sdk.core.config.c.V() && n.b() * 3 < n.c() * 4;
    }

    private void r() {
        this.m.setVisibility(8);
        this.f35385d.setVisibility(0);
        this.f35387f.setVisibility(0);
        this.u.setVisibility(8);
    }

    private void s() {
        int i2;
        int i3;
        t();
        if (this.q == 2) {
            a(44);
            a(28, 28);
            i2 = 12;
            a(28, 12, 88);
            i3 = 9;
        } else {
            a(40);
            a(22, 22);
            i2 = 10;
            a(24, 10, 76);
            i3 = 7;
        }
        setAdMarkView(i3);
        setAdTextView(i2);
    }

    private void setAdMarkView(int i2) {
        this.w.setTextSize(i2);
        this.w.setText(com.kwad.sdk.core.response.b.a.v(this.j));
    }

    private void setAdTextView(int i2) {
        this.y.setTextSize(i2);
        String v = com.kwad.sdk.core.response.b.c.v(this.f35389h);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.f35389h)) {
            v = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        this.y.setText(v);
        this.y.setClickable(true);
        this.y.setOnClickListener(this);
    }

    private void setBackgroundImageView(String str) {
        if (!q()) {
            this.f35384c.setVisibility(8);
            return;
        }
        this.f35384c.setVisibility(0);
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "blurBackgroundUrl=" + str);
        com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).b(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).c(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).a((e) new com.kwad.sdk.c(str, this.f35389h)).a((ImageView) this.f35384c);
    }

    private void setCoverImageView(String str) {
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "coverUrl=" + str);
        com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).b(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((e) new com.kwad.sdk.c(str, this.f35389h)).a((ImageView) this.f35383b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedAdButton(boolean z) {
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "setButtonBackground selected=" + z);
        TextView textView = this.x;
        if (textView != null) {
            textView.setSelected(z);
        }
    }

    private void t() {
        if (!this.z) {
            this.u.inflate();
        }
        this.u.setVisibility(0);
        this.u.setClickable(true);
        this.u.setOnClickListener(this);
        this.A = (RelativeLayout) findViewById(R.id.ksad_entryitem_ad_layout);
        this.v = (RoundAngleImageView) findViewById(R.id.ksad_entryitem_ad_app_icon);
        this.x = (TextView) findViewById(R.id.ksad_entryitem_ad_btn);
        this.y = (TextView) findViewById(R.id.ksad_entryitem_ad_text);
        this.w = (TextView) findViewById(R.id.ksad_entryitem_ad_mark);
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        if (com.kwad.sdk.core.response.b.c.c(this.f35389h) && this.z) {
            com.kwad.sdk.core.report.b.a(this.f35389h, (JSONObject) null);
        }
        com.kwad.sdk.core.report.e.b(this.f35389h, this.o);
    }

    public void a(int i2, String str) {
        this.n = i2;
        this.o = str;
    }

    public void a(@NonNull AdTemplate adTemplate, com.kwad.sdk.core.response.model.a aVar) {
        this.f35388g = aVar;
        this.f35389h = adTemplate;
        r();
        if (com.kwad.sdk.core.response.b.c.c(this.f35389h)) {
            this.j = com.kwad.sdk.core.response.b.c.j(this.f35389h);
            m();
            return;
        }
        this.f35390i = com.kwad.sdk.core.response.b.c.k(this.f35389h);
        o();
    }

    @Override // com.kwad.sdk.core.view.g.a
    public void a(boolean z) {
        if (z) {
            d();
        } else {
            e();
        }
    }

    public void a(boolean z, boolean z2) {
        this.k = z;
        this.l = z2;
    }

    public void b() {
        AnimatedImageView animatedImageView = (AnimatedImageView) findViewById(R.id.ksad_entryitem_photocover);
        this.f35383b = animatedImageView;
        animatedImageView.setRadius(ao.a(getContext(), 4.0f));
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_entryitem_background);
        this.f35384c = roundAngleImageView;
        roundAngleImageView.setRadius(ao.a(getContext(), 4.0f));
        this.f35385d = (TextView) findViewById(R.id.ksad_entryitem_lickcount);
        this.m = findViewById(R.id.ksad_entryitem_lookmore);
        this.f35386e = (TextView) findViewById(R.id.ksad_entryitem_title);
        this.f35387f = (ImageView) findViewById(R.id.ksad_entryitem_playbtn);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_entryitem_ad_bottom_viewstub);
        this.u = viewStub;
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.1
            @Override // android.view.ViewStub.OnInflateListener
            public void onInflate(ViewStub viewStub2, View view) {
                EntryPhotoView.this.z = true;
            }
        });
    }

    public void c() {
        AnimatedImageView animatedImageView;
        Context context;
        float f2;
        if (q()) {
            this.f35383b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            animatedImageView = this.f35383b;
            context = getContext();
            f2 = 0.0f;
        } else {
            this.f35383b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            animatedImageView = this.f35383b;
            context = getContext();
            f2 = 4.0f;
        }
        animatedImageView.setRadius(ao.a(context, f2));
    }

    public void d() {
        AnimatedImageView animatedImageView = this.f35383b;
        if (animatedImageView == null || this.t) {
            return;
        }
        animatedImageView.a();
        this.t = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            f35382a.a(getWidth(), getHeight());
            f35382a.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            f35382a.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        AnimatedImageView animatedImageView = this.f35383b;
        if (animatedImageView == null || !this.t) {
            return;
        }
        animatedImageView.b();
        this.t = false;
    }

    public void f() {
        d();
    }

    public void g() {
        e();
    }

    public String getEntryId() {
        return this.o;
    }

    public int getPosition() {
        return this.n;
    }

    public AdTemplate getTemplateData() {
        return this.f35389h;
    }

    @MainThread
    public s.a getTouchCoords() {
        return f35382a;
    }

    public void h() {
        g gVar = this.p;
        if (gVar != null) {
            gVar.b();
        }
    }

    @Override // com.kwad.sdk.widget.a, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        g gVar;
        super.onAttachedToWindow();
        if (this.l && (gVar = this.p) != null) {
            gVar.a();
        }
        g gVar2 = this.B;
        if (gVar2 != null) {
            gVar2.a();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final int i2 = view == this.v ? 55 : view == this.y ? 82 : view == this.x ? 83 : view == this.A ? 35 : 0;
        com.kwad.sdk.core.download.b.b.a(this.r, true);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35389h, new a.InterfaceC0379a() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.7
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                EntryPhotoView.this.f35389h.mHasEntryAdClick = true;
                EntryPhotoView.this.b(i2);
            }
        }, this.r);
    }

    @Override // com.kwad.sdk.widget.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
        g gVar = this.B;
        if (gVar != null) {
            gVar.b();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public void setAdShowStyle(int i2) {
        this.q = i2;
    }

    public void setLikeViewPos(int i2) {
        FrameLayout.LayoutParams layoutParams;
        int i3;
        if (i2 == 0) {
            this.f35385d.setVisibility(8);
            return;
        }
        if (i2 == 1) {
            this.f35385d.setVisibility(0);
            layoutParams = (FrameLayout.LayoutParams) this.f35385d.getLayoutParams();
            i3 = 83;
        } else if (i2 != 2) {
            return;
        } else {
            this.f35385d.setVisibility(0);
            layoutParams = (FrameLayout.LayoutParams) this.f35385d.getLayoutParams();
            i3 = 85;
        }
        layoutParams.gravity = i3;
    }

    public void setLookMoreVisible(boolean z) {
        TextView textView;
        if (z) {
            this.m.setVisibility(0);
            this.f35385d.setVisibility(8);
            this.f35387f.setVisibility(8);
            textView = this.f35386e;
        } else {
            this.m.setVisibility(8);
            this.f35385d.setVisibility(0);
            this.f35387f.setVisibility(0);
            this.f35386e.setVisibility(0);
            if (!com.kwad.sdk.core.response.b.c.c(this.f35389h)) {
                this.f35385d.setVisibility(0);
                return;
            }
            textView = this.f35385d;
        }
        textView.setVisibility(8);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.E = onClickListener;
    }

    public void setPlayBtnRes(int i2) {
        this.f35387f.setImageResource(i2);
    }
}
