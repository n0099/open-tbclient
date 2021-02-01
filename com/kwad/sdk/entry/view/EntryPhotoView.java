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
/* loaded from: classes3.dex */
public class EntryPhotoView extends com.kwad.sdk.widget.a implements View.OnClickListener, g.a {

    /* renamed from: a  reason: collision with root package name */
    private static final s.a f9777a = new s.a();
    private RelativeLayout A;
    private g B;
    private Runnable C;
    private boolean D;
    private View.OnClickListener E;

    /* renamed from: b  reason: collision with root package name */
    private AnimatedImageView f9778b;
    private RoundAngleImageView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private com.kwad.sdk.core.response.model.a g;
    private AdTemplate h;
    private PhotoInfo i;
    private AdInfo j;
    private boolean k;
    private boolean l;
    private View m;
    private int n;
    private String o;
    private g p;
    private int q;
    private com.kwad.sdk.core.download.b.b r;
    private KsAppDownloadListener s;
    private boolean t;
    private ViewStub u;
    private RoundAngleImageView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private boolean z;

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

    private void a(int i) {
        ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = ao.a(getContext(), i);
        this.A.setClickable(true);
        this.A.setOnClickListener(this);
    }

    private void a(int i, int i2) {
        this.v.setRadius(ao.a(getContext(), 4.0f));
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        layoutParams.width = ao.a(getContext(), i);
        layoutParams.height = ao.a(getContext(), i2);
        this.v.setClickable(true);
        this.v.setOnClickListener(this);
        com.kwad.sdk.glide.c.b(getContext()).a(com.kwad.sdk.core.response.b.c.q(this.h)).a(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).b(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).c(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).a((e) new com.kwad.sdk.c(com.kwad.sdk.core.response.b.a.o(this.j), this.h)).a((ImageView) this.v);
    }

    private void a(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = ao.a(getContext(), i);
        this.x.setClickable(true);
        this.x.setOnClickListener(this);
        setSelectedAdButton(this.h.mHasEntryAdClick);
        this.x.setTextSize(i2);
        this.x.setMaxWidth(ao.a(getContext(), i3));
        this.x.setText(com.kwad.sdk.core.response.b.a.w(this.j));
        this.B = new g(this.x, 30);
        this.B.a(new g.a() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.5
            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                if (EntryPhotoView.this.x == null) {
                    return;
                }
                if (EntryPhotoView.this.h.mHasEntryAdClick) {
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
        if (this.B != null) {
            this.B.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.kwad.sdk.core.report.b.a(this.h, i, getTouchCoords());
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.s == null) {
            this.s = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.6
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i) {
                    EntryPhotoView.this.x.setText("继续下载");
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
                    EntryPhotoView.this.x.setText(com.kwad.sdk.core.response.b.a.a(EntryPhotoView.this.h));
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
                public void onProgressUpdate(int i) {
                    EntryPhotoView.this.x.setText("下载中..." + i + "%");
                    ViewGroup.LayoutParams layoutParams = EntryPhotoView.this.x.getLayoutParams();
                    layoutParams.width = -2;
                    EntryPhotoView.this.x.setLayoutParams(layoutParams);
                }
            };
        }
        return this.s;
    }

    private void m() {
        this.d.setVisibility(8);
        this.e.setText(com.kwad.sdk.core.response.b.a.n(this.j));
        n();
        p();
        s();
        if (com.kwad.sdk.core.response.b.a.y(this.j) && this.r == null) {
            this.r = new com.kwad.sdk.core.download.b.b(this.h);
            this.r.a(getAppDownloadListener());
        }
    }

    private void n() {
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.c.c(EntryPhotoView.this.h)) {
                    com.kwad.sdk.core.report.b.d(EntryPhotoView.this.h, 24);
                }
                if (EntryPhotoView.this.E != null) {
                    EntryPhotoView.this.E.onClick(EntryPhotoView.this);
                }
            }
        });
        this.f9778b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.c.c(EntryPhotoView.this.h)) {
                    com.kwad.sdk.core.report.b.d(EntryPhotoView.this.h, 83);
                }
                if (EntryPhotoView.this.E != null) {
                    EntryPhotoView.this.E.onClick(EntryPhotoView.this);
                }
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.c.c(EntryPhotoView.this.h)) {
                    com.kwad.sdk.core.report.b.d(EntryPhotoView.this.h, 83);
                }
                if (EntryPhotoView.this.E != null) {
                    EntryPhotoView.this.E.onClick(EntryPhotoView.this);
                }
            }
        });
    }

    private void o() {
        if (this.i == null) {
            return;
        }
        p();
        long m = d.m(this.i);
        this.d.setVisibility(0);
        this.d.setText(ag.a(m, "0"));
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "videoDescPos=" + this.g.i + " videoDesc=" + this.i.baseInfo.videoDesc);
        if (this.g.i != 1 || TextUtils.isEmpty(this.i.baseInfo.videoDesc)) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.e.setText(this.i.baseInfo.videoDesc);
    }

    private void p() {
        String D = com.kwad.sdk.core.response.b.c.D(this.h);
        setBackgroundImageView(com.kwad.sdk.core.response.b.c.p(this.h));
        c();
        if (this.k) {
            com.kwad.sdk.core.d.a.a("EntryPhotoView", "coverUrl=" + D);
            if (!TextUtils.isEmpty(D) && FrameSequence.isEnable()) {
                h oVar = q() ? new o() : new com.kwad.sdk.glide.load.resource.bitmap.g();
                com.kwad.sdk.glide.c.b(getContext()).a(D).a(getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getResources().getDrawable(R.drawable.ksad_loading_entry)).b((h<Bitmap>) oVar).a(k.class, new n(oVar)).a((com.kwad.sdk.glide.load.d<com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy>>) com.kwad.sdk.glide.webp.decoder.o.f10391a, (com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy>) WebpFrameCacheStrategy.f10367b).a(com.kwad.sdk.glide.load.engine.h.d).a((e) new com.kwad.sdk.c(D, this.h)).a((ImageView) this.f9778b);
                return;
            }
        }
        setCoverImageView(com.kwad.sdk.core.response.b.c.o(this.h).a());
    }

    private boolean q() {
        com.kwad.sdk.core.response.model.c n = com.kwad.sdk.core.response.b.c.n(this.h);
        return com.kwad.sdk.core.config.c.V() && n.b() * 3 < n.c() * 4;
    }

    private void r() {
        this.m.setVisibility(8);
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.u.setVisibility(8);
    }

    private void s() {
        t();
        if (this.q == 2) {
            a(44);
            a(28, 28);
            a(28, 12, 88);
            setAdMarkView(9);
            setAdTextView(12);
            return;
        }
        a(40);
        a(22, 22);
        a(24, 10, 76);
        setAdMarkView(7);
        setAdTextView(10);
    }

    private void setAdMarkView(int i) {
        this.w.setTextSize(i);
        this.w.setText(com.kwad.sdk.core.response.b.a.v(this.j));
    }

    private void setAdTextView(int i) {
        this.y.setTextSize(i);
        String v = com.kwad.sdk.core.response.b.c.v(this.h);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.h)) {
            v = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        this.y.setText(v);
        this.y.setClickable(true);
        this.y.setOnClickListener(this);
    }

    private void setBackgroundImageView(String str) {
        if (!q()) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "blurBackgroundUrl=" + str);
        com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).b(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).c(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).a((e) new com.kwad.sdk.c(str, this.h)).a((ImageView) this.c);
    }

    private void setCoverImageView(String str) {
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "coverUrl=" + str);
        com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).b(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((e) new com.kwad.sdk.c(str, this.h)).a((ImageView) this.f9778b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedAdButton(boolean z) {
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "setButtonBackground selected=" + z);
        if (this.x != null) {
            this.x.setSelected(z);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        if (com.kwad.sdk.core.response.b.c.c(this.h) && this.z) {
            com.kwad.sdk.core.report.b.a(this.h, (JSONObject) null);
        }
        com.kwad.sdk.core.report.e.b(this.h, this.o);
    }

    public void a(int i, String str) {
        this.n = i;
        this.o = str;
    }

    public void a(@NonNull AdTemplate adTemplate, com.kwad.sdk.core.response.model.a aVar) {
        this.g = aVar;
        this.h = adTemplate;
        r();
        if (com.kwad.sdk.core.response.b.c.c(this.h)) {
            this.j = com.kwad.sdk.core.response.b.c.j(this.h);
            m();
            return;
        }
        this.i = com.kwad.sdk.core.response.b.c.k(this.h);
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

    protected void b() {
        this.f9778b = (AnimatedImageView) findViewById(R.id.ksad_entryitem_photocover);
        this.f9778b.setRadius(ao.a(getContext(), 4.0f));
        this.c = (RoundAngleImageView) findViewById(R.id.ksad_entryitem_background);
        this.c.setRadius(ao.a(getContext(), 4.0f));
        this.d = (TextView) findViewById(R.id.ksad_entryitem_lickcount);
        this.m = findViewById(R.id.ksad_entryitem_lookmore);
        this.e = (TextView) findViewById(R.id.ksad_entryitem_title);
        this.f = (ImageView) findViewById(R.id.ksad_entryitem_playbtn);
        this.u = (ViewStub) findViewById(R.id.ksad_entryitem_ad_bottom_viewstub);
        this.u.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.1
            @Override // android.view.ViewStub.OnInflateListener
            public void onInflate(ViewStub viewStub, View view) {
                EntryPhotoView.this.z = true;
            }
        });
    }

    public void c() {
        if (q()) {
            this.f9778b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f9778b.setRadius(ao.a(getContext(), 0.0f));
            return;
        }
        this.f9778b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f9778b.setRadius(ao.a(getContext(), 4.0f));
    }

    public void d() {
        if (this.f9778b == null || this.t) {
            return;
        }
        this.f9778b.a();
        this.t = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                f9777a.a(getWidth(), getHeight());
                f9777a.a(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                f9777a.b(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        if (this.f9778b == null || !this.t) {
            return;
        }
        this.f9778b.b();
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
        return this.h;
    }

    @MainThread
    public s.a getTouchCoords() {
        return f9777a;
    }

    public void h() {
        if (this.p != null) {
            this.p.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.a, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l && this.p != null) {
            this.p.a();
        }
        if (this.B != null) {
            this.B.a();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final int i = 0;
        if (view == this.v) {
            i = 55;
        } else if (view == this.y) {
            i = 82;
        } else if (view == this.x) {
            i = 83;
        } else if (view == this.A) {
            i = 35;
        }
        com.kwad.sdk.core.download.b.b.a(this.r, true);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.h, new a.InterfaceC1092a() { // from class: com.kwad.sdk.entry.view.EntryPhotoView.7
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1092a
            public void a() {
                EntryPhotoView.this.h.mHasEntryAdClick = true;
                EntryPhotoView.this.b(i);
            }
        }, this.r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
        if (this.B != null) {
            this.B.b();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public void setAdShowStyle(int i) {
        this.q = i;
    }

    public void setLikeViewPos(int i) {
        switch (i) {
            case 0:
                this.d.setVisibility(8);
                return;
            case 1:
                this.d.setVisibility(0);
                ((FrameLayout.LayoutParams) this.d.getLayoutParams()).gravity = 83;
                return;
            case 2:
                this.d.setVisibility(0);
                ((FrameLayout.LayoutParams) this.d.getLayoutParams()).gravity = 85;
                return;
            default:
                return;
        }
    }

    public void setLookMoreVisible(boolean z) {
        if (z) {
            this.m.setVisibility(0);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        this.m.setVisibility(8);
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.e.setVisibility(0);
        if (com.kwad.sdk.core.response.b.c.c(this.h)) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.E = onClickListener;
    }

    public void setPlayBtnRes(int i) {
        this.f.setImageResource(i);
    }
}
