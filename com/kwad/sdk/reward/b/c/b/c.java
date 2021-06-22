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
/* loaded from: classes7.dex */
public class c extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f37263b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37264c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatedImageView f37265d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatedImageView f37266e;

    /* renamed from: f  reason: collision with root package name */
    public e f37267f = new e() { // from class: com.kwad.sdk.reward.b.c.b.c.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.e();
        }
    };

    private void a(final AnimatedImageView animatedImageView, final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            animatedImageView.setImageResource(R.drawable.ksad_reward_icon_end);
        } else {
            KSImageLoader.loadImage(str, ((d) this).f37299a.f37053f, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.c.b.c.2
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
        if (((d) this).f37299a.q) {
            this.f37264c.setVisibility(8);
            String d2 = com.kwad.sdk.core.response.b.b.d(((d) this).f37299a.f37053f);
            if (((d) this).f37299a.f37052e != 1) {
                a(this.f37266e, d2);
                this.f37266e.setVisibility(0);
                this.f37266e.setOnClickListener(this);
                this.f37263b.setVisibility(8);
                return;
            }
            a(this.f37265d, d2);
            this.f37265d.setVisibility(0);
            imageView = this.f37265d;
        } else {
            this.f37265d.setVisibility(8);
            this.f37266e.setVisibility(8);
            this.f37264c.setVisibility(0);
            imageView = this.f37264c;
        }
        imageView.setOnClickListener(this);
        this.f37263b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.reward.a aVar = ((d) this).f37299a;
        com.kwad.sdk.core.report.b.a(aVar.f37053f, 41, aVar.f37055h.getTouchCoords(), ((d) this).f37299a.f37051d);
        ((d) this).f37299a.f37049b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f37299a.n.add(this.f37267f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37299a.n.remove(this.f37267f);
        this.f37265d.b();
        this.f37266e.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37263b = (ViewGroup) b(R.id.ksad_end_reward_icon_layout);
        this.f37264c = (ImageView) b(R.id.ksad_end_reward_icon);
        this.f37265d = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_left);
        this.f37266e = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37264c || view == this.f37265d || view == this.f37266e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), ((d) this).f37299a.f37053f, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.b.c.b.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                    c.this.f();
                }
            }, ((d) this).f37299a.j);
        }
    }
}
