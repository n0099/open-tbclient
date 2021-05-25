package com.kwad.sdk.reward.b.b.b;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.AnimatedImageView;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33628b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33629c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33630d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f33631e;

    /* renamed from: f  reason: collision with root package name */
    public AnimatedImageView f33632f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33633g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33634h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f33635i;
    public com.kwad.sdk.core.download.b.b j;
    public String k;
    public com.kwad.sdk.contentalliance.detail.video.d l = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            AdInfo g2 = com.kwad.sdk.core.response.b.c.g(e.this.f33635i);
            long l = com.kwad.sdk.core.response.b.a.l(g2);
            if (!com.kwad.sdk.core.response.b.a.k(g2) && l > 0) {
                j = Math.min(j, l);
            }
            e.this.a(j, j2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        int i2 = (int) ((((float) (j - j2)) / 1000.0f) + 0.5f);
        if (i2 < 0) {
            this.f33633g.setVisibility(8);
            this.f33634h.setText(l().getString(R.string.ksad_reward_success_tip));
            n();
        } else if (i2 == 0) {
        } else {
            TextView textView = this.f33633g;
            textView.setText(i2 + "s");
            this.f33633g.setVisibility(0);
            this.f33634h.setText(this.k);
        }
    }

    private void a(final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            this.f33632f.setImageResource(R.drawable.ksad_reward_icon_detail);
        } else {
            KSImageLoader.loadImage(str, this.f33635i, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.b.b.e.2
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
                            e.this.f33632f.setWebpStream(decodedResult.mFrameSequence);
                            e.this.f33632f.a();
                            return;
                        }
                        Bitmap bitmap = decodedResult.mBitmap;
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        e.this.f33632f.setImageBitmap(decodedResult.mBitmap);
                    }
                }
            });
        }
    }

    private void e() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33628b.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.f33628b.setLayoutParams(marginLayoutParams);
        this.f33629c.setVisibility(8);
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f33635i);
        long b2 = com.kwad.sdk.core.response.b.a.b(g2) * 1000;
        long l = com.kwad.sdk.core.response.b.a.l(g2);
        if (!com.kwad.sdk.core.response.b.a.k(g2) && l > 0 && b2 != 0) {
            b2 = Math.min(l, b2);
        }
        String a2 = com.kwad.sdk.core.response.b.b.a(this.f33635i);
        this.k = a2;
        if (ag.a(a2)) {
            this.k = l().getString(R.string.ksad_reward_default_tip);
        }
        a(com.kwad.sdk.core.response.b.b.b(this.f33635i));
        a(b2, 0L);
        this.f33631e.setOnClickListener(this);
        this.f33631e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.kwad.sdk.core.report.b.a(this.f33635i, 41, ((com.kwad.sdk.reward.d) this).f33768a.f33497h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f33768a.f33493d);
        ((com.kwad.sdk.reward.d) this).f33768a.f33491b.a();
    }

    private void n() {
        ((com.kwad.sdk.reward.d) this).f33768a.f33491b.e();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33768a;
        this.f33635i = aVar.f33495f;
        this.j = aVar.j;
        e();
        ((com.kwad.sdk.reward.d) this).f33768a.f33498i.a(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33629c = (TextView) a(R.id.ksad_video_count_down);
        this.f33628b = (ImageView) a(R.id.ksad_video_sound_switch);
        this.f33630d = (ImageView) a(R.id.ksad_detail_close_btn);
        ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_reward_container_new);
        this.f33631e = viewGroup;
        this.f33632f = (AnimatedImageView) viewGroup.findViewById(R.id.ksad_detail_reward_icon_new);
        this.f33633g = (TextView) this.f33631e.findViewById(R.id.ksad_video_count_down_new);
        this.f33634h = (TextView) this.f33631e.findViewById(R.id.ksad_detail_reward_tip_new);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33768a.f33498i.b(this.l);
        this.f33632f.b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33631e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33635i, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.b.b.b.e.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                public void a() {
                    e.this.m();
                }
            }, this.j, false);
        }
    }
}
