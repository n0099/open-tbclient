package com.kwad.sdk.reward.b.c.b;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.AnimatedImageView;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34546b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34547c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatedImageView f34548d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatedImageView f34549e;

    /* renamed from: f  reason: collision with root package name */
    public f f34550f = new f() { // from class: com.kwad.sdk.reward.b.c.b.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) c.this).f34594a.s) {
                return;
            }
            c.this.e();
        }
    };

    private void a(final AnimatedImageView animatedImageView, final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            animatedImageView.setImageResource(R.drawable.ksad_reward_icon_end);
        } else {
            KSImageLoader.loadImage(str, ((d) this).f34594a.f34321f, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.c.b.c.2
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
                            animatedImageView.setWebpStream(frameSequence);
                            animatedImageView.a();
                            return;
                        }
                        Bitmap bitmap = decodedResult.mBitmap;
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        animatedImageView.setImageBitmap(decodedResult.mBitmap);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ViewGroup viewGroup;
        if (((d) this).f34594a.r) {
            ImageView imageView = this.f34547c;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            String c2 = com.kwad.sdk.core.response.b.b.c(((d) this).f34594a.f34321f);
            if (((d) this).f34594a.f34320e != 1) {
                AnimatedImageView animatedImageView = this.f34549e;
                if (animatedImageView != null) {
                    a(animatedImageView, c2);
                    this.f34549e.setVisibility(0);
                    this.f34549e.setOnClickListener(this);
                }
                ViewGroup viewGroup2 = this.f34546b;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(8);
                    return;
                }
                return;
            }
            AnimatedImageView animatedImageView2 = this.f34548d;
            if (animatedImageView2 != null) {
                a(animatedImageView2, c2);
                this.f34548d.setVisibility(0);
                this.f34548d.setOnClickListener(this);
            }
            viewGroup = this.f34546b;
            if (viewGroup == null) {
                return;
            }
        } else {
            AnimatedImageView animatedImageView3 = this.f34548d;
            if (animatedImageView3 != null) {
                animatedImageView3.setVisibility(8);
            }
            AnimatedImageView animatedImageView4 = this.f34549e;
            if (animatedImageView4 != null) {
                animatedImageView4.setVisibility(8);
            }
            ImageView imageView2 = this.f34547c;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                this.f34547c.setOnClickListener(this);
            }
            viewGroup = this.f34546b;
            if (viewGroup == null) {
                return;
            }
        }
        viewGroup.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.kwad.sdk.reward.a aVar = ((d) this).f34594a;
        com.kwad.sdk.core.report.b.a(aVar.f34321f, 41, aVar.f34323h.getTouchCoords(), ((d) this).f34594a.f34319d);
        ((d) this).f34594a.f34317b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f34594a.a(this.f34550f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34546b = (ViewGroup) a(R.id.ksad_end_reward_icon_layout);
        this.f34547c = (ImageView) a(R.id.ksad_end_reward_icon);
        this.f34548d = (AnimatedImageView) a(R.id.ksad_end_reward_icon_new_left);
        this.f34549e = (AnimatedImageView) a(R.id.ksad_end_reward_icon_new_right);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f34594a.b(this.f34550f);
        this.f34548d.b();
        this.f34549e.b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34547c || view == this.f34548d || view == this.f34549e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), ((d) this).f34594a.f34321f, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.b.c.b.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                public void a() {
                    c.this.m();
                }
            }, ((d) this).f34594a.j, false);
        }
    }
}
