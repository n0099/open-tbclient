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
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.AnimatedImageView;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f36423b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36424c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatedImageView f36425d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatedImageView f36426e;

    /* renamed from: f  reason: collision with root package name */
    public e f36427f = new e() { // from class: com.kwad.sdk.reward.b.c.b.c.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.e();
        }
    };

    private void a(final AnimatedImageView animatedImageView, final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            animatedImageView.setImageResource(R.drawable.ksad_reward_icon_end);
        } else {
            KSImageLoader.loadImage(str, ((d) this).f36458a.f36222f, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.c.b.c.2
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
        ImageView imageView;
        if (((d) this).f36458a.q) {
            this.f36424c.setVisibility(8);
            String d2 = com.kwad.sdk.core.response.b.b.d(((d) this).f36458a.f36222f);
            if (((d) this).f36458a.f36221e != 1) {
                a(this.f36426e, d2);
                this.f36426e.setVisibility(0);
                this.f36426e.setOnClickListener(this);
                this.f36423b.setVisibility(8);
                return;
            }
            a(this.f36425d, d2);
            this.f36425d.setVisibility(0);
            imageView = this.f36425d;
        } else {
            this.f36425d.setVisibility(8);
            this.f36426e.setVisibility(8);
            this.f36424c.setVisibility(0);
            imageView = this.f36424c;
        }
        imageView.setOnClickListener(this);
        this.f36423b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.reward.a aVar = ((d) this).f36458a;
        com.kwad.sdk.core.report.b.a(aVar.f36222f, 41, aVar.f36224h.getTouchCoords(), ((d) this).f36458a.f36220d);
        ((d) this).f36458a.f36218b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f36458a.n.add(this.f36427f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36458a.n.remove(this.f36427f);
        this.f36425d.b();
        this.f36426e.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36423b = (ViewGroup) b(R.id.ksad_end_reward_icon_layout);
        this.f36424c = (ImageView) b(R.id.ksad_end_reward_icon);
        this.f36425d = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_left);
        this.f36426e = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36424c || view == this.f36425d || view == this.f36426e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), ((d) this).f36458a.f36222f, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.b.c.b.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    c.this.f();
                }
            }, ((d) this).f36458a.j);
        }
    }
}
