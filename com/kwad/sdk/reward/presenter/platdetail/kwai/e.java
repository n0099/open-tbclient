package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.WebpAnimationImageView;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class e extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57809b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57810c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f57811d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f57812e;

    /* renamed from: f  reason: collision with root package name */
    public WebpAnimationImageView f57813f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57814g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57815h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f57816i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57817j;
    public String k;
    public com.kwad.sdk.contentalliance.detail.video.d l = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(e.this.f57816i));
            if (p > 0) {
                j2 = Math.min(j2, p);
            }
            e.this.a(j2, j3);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, long j3) {
        int i2 = (int) ((((float) (j2 - j3)) / 1000.0f) + 0.5f);
        if (i2 < 0) {
            this.f57814g.setVisibility(8);
            this.f57815h.setText(q().getString(R.string.ksad_reward_success_tip));
            r();
        } else if (i2 == 0) {
        } else {
            TextView textView = this.f57814g;
            textView.setText(i2 + "s");
            this.f57814g.setVisibility(0);
            this.f57815h.setText(this.k);
        }
    }

    private void a(final String str) {
        if (at.a(str) || !FrameSequence.isEnable()) {
            this.f57813f.setImageResource(R.drawable.ksad_reward_icon_detail);
        } else {
            KSImageLoader.loadImage(str, this.f57816i, KSImageLoader.IMGOPTION_ENTRY_FS(), new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.2
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
                            e.this.f57813f.setWebpStream(decodedResult.mFrameSequence);
                            e.this.f57813f.a();
                            return;
                        }
                        Bitmap bitmap = decodedResult.mBitmap;
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        e.this.f57813f.setImageBitmap(decodedResult.mBitmap);
                    }
                }
            });
        }
    }

    private void e() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f57809b.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.f57809b.setLayoutParams(marginLayoutParams);
        this.f57810c.setVisibility(8);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f57816i);
        long b2 = com.kwad.sdk.core.response.a.a.b(j2) * 1000;
        long p = com.kwad.sdk.core.response.a.a.p(j2);
        if (p > 0 && b2 != 0) {
            b2 = Math.min(p, b2);
        }
        String a = com.kwad.sdk.core.response.a.c.a(this.f57816i);
        this.k = a;
        if (at.a(a)) {
            this.k = q().getString(R.string.ksad_reward_default_tip);
        }
        a(com.kwad.sdk.core.response.a.c.b(this.f57816i));
        a(b2, 0L);
        this.f57812e.setOnClickListener(this);
        this.f57812e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.kwad.sdk.core.report.a.a(this.f57816i, 41, ((g) this).a.f57422j.getTouchCoords(), ((g) this).a.f57417e);
        ((g) this).a.f57414b.a();
    }

    private void r() {
        ((g) this).a.f57414b.e();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57816i = aVar.f57419g;
        this.f57817j = aVar.l;
        e();
        ((g) this).a.k.a(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.l);
        this.f57813f.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57810c = (TextView) a(R.id.ksad_video_count_down);
        this.f57809b = (ImageView) a(R.id.ksad_video_sound_switch);
        this.f57811d = (ImageView) a(R.id.ksad_detail_close_btn);
        ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_reward_container_new);
        this.f57812e = viewGroup;
        this.f57813f = (WebpAnimationImageView) viewGroup.findViewById(R.id.ksad_detail_reward_icon_new);
        this.f57814g = (TextView) this.f57812e.findViewById(R.id.ksad_video_count_down_new);
        this.f57815h = (TextView) this.f57812e.findViewById(R.id.ksad_detail_reward_tip_new);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57812e) {
            com.kwad.sdk.core.download.a.a.a(new a.C2116a(view.getContext()).a(this.f57816i).a(this.f57817j).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.3
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    e.this.i();
                }
            }));
        }
    }
}
