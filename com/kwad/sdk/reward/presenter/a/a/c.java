package com.kwad.sdk.reward.presenter.a.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.a.h;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.WebpAnimationImageView;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class c extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57582b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57583c;

    /* renamed from: d  reason: collision with root package name */
    public WebpAnimationImageView f57584d;

    /* renamed from: e  reason: collision with root package name */
    public WebpAnimationImageView f57585e;

    /* renamed from: f  reason: collision with root package name */
    public final f f57586f = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) c.this).a.x || c.this.f() || c.this.g() || !((g) c.this).a.v) {
                return;
            }
            c.this.e();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public final h f57587g = new h() { // from class: com.kwad.sdk.reward.presenter.a.a.c.2
        @Override // com.kwad.sdk.reward.a.h
        public void a() {
            c.this.e();
        }
    };

    private void a(final WebpAnimationImageView webpAnimationImageView, final String str) {
        if (at.a(str) || !FrameSequence.isEnable()) {
            webpAnimationImageView.setImageResource(R.drawable.ksad_reward_icon_end);
        } else if (str.equals(webpAnimationImageView.getTag())) {
        } else {
            KSImageLoader.loadImage(str, ((g) this).a.f57419g, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.presenter.a.a.c.3
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    try {
                        FrameSequence decodeStream = FrameSequence.decodeStream(inputStream);
                        IoUtils.closeSilently(inputStream);
                        decodedResult.mFrameSequence = decodeStream;
                        return decodeStream != null;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.a.a(th);
                        return false;
                    }
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    if (str.equals(str2)) {
                        FrameSequence frameSequence = decodedResult.mFrameSequence;
                        if (frameSequence != null) {
                            webpAnimationImageView.setWebpStream(frameSequence);
                            webpAnimationImageView.setTag(str2);
                            webpAnimationImageView.a();
                            return;
                        }
                        Bitmap bitmap = decodedResult.mBitmap;
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        webpAnimationImageView.setImageBitmap(decodedResult.mBitmap);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ViewGroup viewGroup;
        if (((g) this).a.s) {
            ImageView imageView = this.f57583c;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            String c2 = com.kwad.sdk.core.response.a.c.c(((g) this).a.f57419g);
            if (((g) this).a.f57418f != 1) {
                WebpAnimationImageView webpAnimationImageView = this.f57585e;
                if (webpAnimationImageView != null) {
                    a(webpAnimationImageView, c2);
                    this.f57585e.setVisibility(0);
                    this.f57585e.setOnClickListener(this);
                }
                ViewGroup viewGroup2 = this.f57582b;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(8);
                    return;
                }
                return;
            }
            WebpAnimationImageView webpAnimationImageView2 = this.f57584d;
            if (webpAnimationImageView2 != null) {
                a(webpAnimationImageView2, c2);
                this.f57584d.setVisibility(0);
                this.f57584d.setOnClickListener(this);
            }
            viewGroup = this.f57582b;
            if (viewGroup == null) {
                return;
            }
        } else {
            WebpAnimationImageView webpAnimationImageView3 = this.f57584d;
            if (webpAnimationImageView3 != null) {
                webpAnimationImageView3.setVisibility(8);
            }
            WebpAnimationImageView webpAnimationImageView4 = this.f57585e;
            if (webpAnimationImageView4 != null) {
                webpAnimationImageView4.setVisibility(8);
            }
            ImageView imageView2 = this.f57583c;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                this.f57583c.setOnClickListener(this);
            }
            viewGroup = this.f57582b;
            if (viewGroup == null) {
                return;
            }
        }
        viewGroup.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        com.kwad.sdk.core.report.a.a(aVar.f57419g, 41, aVar.f57422j.getTouchCoords(), ((g) this).a.f57417e);
        ((g) this).a.f57414b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        d.a().a(this.f57587g);
        ((g) this).a.a(this.f57586f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        d.a().b(this.f57587g);
        ((g) this).a.b(this.f57586f);
        this.f57584d.b();
        this.f57585e.b();
        this.f57582b.setVisibility(8);
        this.f57583c.setVisibility(8);
        this.f57584d.setVisibility(8);
        this.f57585e.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57582b = (ViewGroup) a(R.id.ksad_end_reward_icon_layout);
        this.f57583c = (ImageView) a(R.id.ksad_end_reward_icon);
        this.f57584d = (WebpAnimationImageView) a(R.id.ksad_end_reward_icon_new_left);
        this.f57585e = (WebpAnimationImageView) a(R.id.ksad_end_reward_icon_new_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57583c || view == this.f57584d || view == this.f57585e) {
            com.kwad.sdk.core.download.a.a.a(new a.C2116a(view.getContext()).a(((g) this).a.f57419g).a(((g) this).a.l).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.a.c.4
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    c.this.i();
                }
            }));
        }
    }
}
