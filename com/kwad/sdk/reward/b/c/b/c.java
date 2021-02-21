package com.kwad.sdk.reward.b.c.b;

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
/* loaded from: classes3.dex */
public class c extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f10634b;
    private ImageView c;
    private AnimatedImageView d;
    private AnimatedImageView e;
    private e f = new e() { // from class: com.kwad.sdk.reward.b.c.b.c.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.e();
        }
    };

    private void a(final AnimatedImageView animatedImageView, final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            animatedImageView.setImageResource(R.drawable.ksad_reward_icon_end);
        } else {
            KSImageLoader.loadImage(str, this.f10652a.f, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.c.b.c.2
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
                        if (decodedResult.mFrameSequence != null) {
                            animatedImageView.setWebpStream(decodedResult.mFrameSequence);
                            animatedImageView.a();
                        } else if (decodedResult.mBitmap == null || decodedResult.mBitmap.isRecycled()) {
                        } else {
                            animatedImageView.setImageBitmap(decodedResult.mBitmap);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.f10652a.q) {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setOnClickListener(this);
            this.f10634b.setVisibility(0);
            return;
        }
        this.c.setVisibility(8);
        String d = com.kwad.sdk.core.response.b.b.d(this.f10652a.f);
        if (this.f10652a.e == 1) {
            a(this.d, d);
            this.d.setVisibility(0);
            this.d.setOnClickListener(this);
            this.f10634b.setVisibility(0);
            return;
        }
        a(this.e, d);
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
        this.f10634b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.a(this.f10652a.f, 41, this.f10652a.h.getTouchCoords(), this.f10652a.d);
        this.f10652a.f10527b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10652a.n.add(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10652a.n.remove(this.f);
        this.d.b();
        this.e.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10634b = (ViewGroup) b(R.id.ksad_end_reward_icon_layout);
        this.c = (ImageView) b(R.id.ksad_end_reward_icon);
        this.d = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_left);
        this.e = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c || view == this.d || view == this.e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f10652a.f, new a.InterfaceC1094a() { // from class: com.kwad.sdk.reward.b.c.b.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1094a
                public void a() {
                    c.this.f();
                }
            }, this.f10652a.j);
        }
    }
}
