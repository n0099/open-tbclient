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
/* loaded from: classes3.dex */
public class c extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57370b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57371c;

    /* renamed from: d  reason: collision with root package name */
    public WebpAnimationImageView f57372d;

    /* renamed from: e  reason: collision with root package name */
    public WebpAnimationImageView f57373e;

    /* renamed from: f  reason: collision with root package name */
    public final f f57374f = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) c.this).a.x || c.this.f() || c.this.g() || !((g) c.this).a.v) {
                return;
            }
            c.this.e();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public final h f57375g = new h() { // from class: com.kwad.sdk.reward.presenter.a.a.c.2
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
            KSImageLoader.loadImage(str, ((g) this).a.f57207g, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.presenter.a.a.c.3
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
            ImageView imageView = this.f57371c;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            String c2 = com.kwad.sdk.core.response.a.c.c(((g) this).a.f57207g);
            if (((g) this).a.f57206f != 1) {
                WebpAnimationImageView webpAnimationImageView = this.f57373e;
                if (webpAnimationImageView != null) {
                    a(webpAnimationImageView, c2);
                    this.f57373e.setVisibility(0);
                    this.f57373e.setOnClickListener(this);
                }
                ViewGroup viewGroup2 = this.f57370b;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(8);
                    return;
                }
                return;
            }
            WebpAnimationImageView webpAnimationImageView2 = this.f57372d;
            if (webpAnimationImageView2 != null) {
                a(webpAnimationImageView2, c2);
                this.f57372d.setVisibility(0);
                this.f57372d.setOnClickListener(this);
            }
            viewGroup = this.f57370b;
            if (viewGroup == null) {
                return;
            }
        } else {
            WebpAnimationImageView webpAnimationImageView3 = this.f57372d;
            if (webpAnimationImageView3 != null) {
                webpAnimationImageView3.setVisibility(8);
            }
            WebpAnimationImageView webpAnimationImageView4 = this.f57373e;
            if (webpAnimationImageView4 != null) {
                webpAnimationImageView4.setVisibility(8);
            }
            ImageView imageView2 = this.f57371c;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                this.f57371c.setOnClickListener(this);
            }
            viewGroup = this.f57370b;
            if (viewGroup == null) {
                return;
            }
        }
        viewGroup.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        com.kwad.sdk.core.report.a.a(aVar.f57207g, 41, aVar.f57210j.getTouchCoords(), ((g) this).a.f57205e);
        ((g) this).a.f57202b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        d.a().a(this.f57375g);
        ((g) this).a.a(this.f57374f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        d.a().b(this.f57375g);
        ((g) this).a.b(this.f57374f);
        this.f57372d.b();
        this.f57373e.b();
        this.f57370b.setVisibility(8);
        this.f57371c.setVisibility(8);
        this.f57372d.setVisibility(8);
        this.f57373e.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57370b = (ViewGroup) a(R.id.ksad_end_reward_icon_layout);
        this.f57371c = (ImageView) a(R.id.ksad_end_reward_icon);
        this.f57372d = (WebpAnimationImageView) a(R.id.ksad_end_reward_icon_new_left);
        this.f57373e = (WebpAnimationImageView) a(R.id.ksad_end_reward_icon_new_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57371c || view == this.f57372d || view == this.f57373e) {
            com.kwad.sdk.core.download.a.a.a(new a.C2100a(view.getContext()).a(((g) this).a.f57207g).a(((g) this).a.l).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.a.c.4
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    c.this.i();
                }
            }));
        }
    }
}
