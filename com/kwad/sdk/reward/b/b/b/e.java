package com.kwad.sdk.reward.b.b.b;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.AnimatedImageView;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f37180b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37181c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37182d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f37183e;

    /* renamed from: f  reason: collision with root package name */
    public AnimatedImageView f37184f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37185g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37186h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f37187i;
    public com.kwad.sdk.core.download.b.b j;
    public String k;
    public com.kwad.sdk.contentalliance.detail.video.e l = new f() { // from class: com.kwad.sdk.reward.b.b.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            AdInfo j3 = com.kwad.sdk.core.response.b.c.j(e.this.f37187i);
            long m = com.kwad.sdk.core.response.b.a.m(j3);
            if (!com.kwad.sdk.core.response.b.a.l(j3) && m > 0) {
                j = Math.min(j, m);
            }
            e.this.a(j, j2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        int i2 = (int) ((((float) (j - j2)) / 1000.0f) + 0.5f);
        if (i2 < 0) {
            this.f37185g.setVisibility(8);
            this.f37186h.setText(o().getString(R.string.ksad_reward_success_tip));
            g();
        } else if (i2 == 0) {
        } else {
            TextView textView = this.f37185g;
            textView.setText(i2 + "s");
            this.f37185g.setVisibility(0);
            this.f37186h.setText(this.k);
        }
    }

    private void a(final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            this.f37184f.setImageResource(R.drawable.ksad_reward_icon_detail);
        } else {
            KSImageLoader.loadImage(str, this.f37187i, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.b.b.e.2
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
                            e.this.f37184f.setWebpStream(decodedResult.mFrameSequence);
                            e.this.f37184f.a();
                            return;
                        }
                        Bitmap bitmap = decodedResult.mBitmap;
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        e.this.f37184f.setImageBitmap(decodedResult.mBitmap);
                    }
                }
            });
        }
    }

    private void e() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f37180b.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.f37180b.setLayoutParams(marginLayoutParams);
        this.f37181c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37183e.getLayoutParams();
        ImageView imageView = this.f37182d;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f37183e.setLayoutParams(layoutParams);
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f37187i);
        long b2 = com.kwad.sdk.core.response.b.a.b(j) * 1000;
        long m = com.kwad.sdk.core.response.b.a.m(j);
        if (!com.kwad.sdk.core.response.b.a.l(j) && m > 0 && b2 != 0) {
            b2 = Math.min(m, b2);
        }
        String b3 = com.kwad.sdk.core.response.b.b.b(this.f37187i);
        this.k = b3;
        if (ag.a(b3)) {
            this.k = o().getString(R.string.ksad_reward_default_tip);
        }
        a(com.kwad.sdk.core.response.b.b.c(this.f37187i));
        a(b2, 0L);
        this.f37183e.setOnClickListener(this);
        this.f37183e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.a(this.f37187i, 41, ((com.kwad.sdk.reward.d) this).f37299a.f37055h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f37299a.f37051d);
        ((com.kwad.sdk.reward.d) this).f37299a.f37049b.a();
    }

    private void g() {
        ((com.kwad.sdk.reward.d) this).f37299a.f37049b.e();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37299a;
        this.f37187i = aVar.f37053f;
        this.j = aVar.j;
        e();
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.a(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.b(this.l);
        this.f37184f.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37181c = (TextView) b(R.id.ksad_video_count_down);
        this.f37180b = (ImageView) b(R.id.ksad_video_sound_switch);
        this.f37182d = (ImageView) b(R.id.ksad_detail_close_btn);
        ViewGroup viewGroup = (ViewGroup) b(R.id.ksad_reward_container_new);
        this.f37183e = viewGroup;
        this.f37184f = (AnimatedImageView) viewGroup.findViewById(R.id.ksad_detail_reward_icon_new);
        this.f37185g = (TextView) this.f37183e.findViewById(R.id.ksad_video_count_down_new);
        this.f37186h = (TextView) this.f37183e.findViewById(R.id.ksad_detail_reward_tip_new);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37183e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37187i, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.b.b.b.e.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                    e.this.f();
                }
            }, this.j);
        }
    }
}
