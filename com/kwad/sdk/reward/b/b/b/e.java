package com.kwad.sdk.reward.b.b.b;

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
/* loaded from: classes4.dex */
public class e extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f10587b;
    private TextView c;
    private ImageView d;
    private ViewGroup e;
    private AnimatedImageView f;
    private TextView g;
    private TextView h;
    private AdTemplate i;
    private com.kwad.sdk.core.download.b.b j;
    private String k;
    private com.kwad.sdk.contentalliance.detail.video.e l = new f() { // from class: com.kwad.sdk.reward.b.b.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            AdInfo j3 = com.kwad.sdk.core.response.b.c.j(e.this.i);
            long m = com.kwad.sdk.core.response.b.a.m(j3);
            if (!com.kwad.sdk.core.response.b.a.l(j3) && m > 0) {
                j = Math.min(j, m);
            }
            e.this.a(j, j2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        int i = (int) ((((float) (j - j2)) / 1000.0f) + 0.5f);
        if (i < 0) {
            this.g.setVisibility(8);
            this.h.setText(o().getString(R.string.ksad_reward_success_tip));
            g();
        } else if (i != 0) {
            this.g.setText(i + "s");
            this.g.setVisibility(0);
            this.h.setText(this.k);
        }
    }

    private void a(final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            this.f.setImageResource(R.drawable.ksad_reward_icon_detail);
        } else {
            KSImageLoader.loadImage(str, this.i, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.b.b.e.2
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
                            e.this.f.setWebpStream(decodedResult.mFrameSequence);
                            e.this.f.a();
                        } else if (decodedResult.mBitmap == null || decodedResult.mBitmap.isRecycled()) {
                        } else {
                            e.this.f.setImageBitmap(decodedResult.mBitmap);
                        }
                    }
                }
            });
        }
    }

    private void e() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f10587b.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.f10587b.setLayoutParams(marginLayoutParams);
        this.c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
        if (this.d == null || this.d.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.e.setLayoutParams(layoutParams);
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.i);
        long b2 = com.kwad.sdk.core.response.b.a.b(j) * 1000;
        long m = com.kwad.sdk.core.response.b.a.m(j);
        if (!com.kwad.sdk.core.response.b.a.l(j) && m > 0 && b2 != 0) {
            b2 = Math.min(m, b2);
        }
        this.k = com.kwad.sdk.core.response.b.b.b(this.i);
        if (ag.a(this.k)) {
            this.k = o().getString(R.string.ksad_reward_default_tip);
        }
        a(com.kwad.sdk.core.response.b.b.c(this.i));
        a(b2, 0L);
        this.e.setOnClickListener(this);
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.a(this.i, 41, this.f10650a.h.getTouchCoords(), this.f10650a.d);
        this.f10650a.f10525b.a();
    }

    private void g() {
        this.f10650a.f10525b.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.i = this.f10650a.f;
        this.j = this.f10650a.j;
        e();
        this.f10650a.i.a(this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10650a.i.b(this.l);
        this.f.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (TextView) b(R.id.ksad_video_count_down);
        this.f10587b = (ImageView) b(R.id.ksad_video_sound_switch);
        this.d = (ImageView) b(R.id.ksad_detail_close_btn);
        this.e = (ViewGroup) b(R.id.ksad_reward_container_new);
        this.f = (AnimatedImageView) this.e.findViewById(R.id.ksad_detail_reward_icon_new);
        this.g = (TextView) this.e.findViewById(R.id.ksad_video_count_down_new);
        this.h = (TextView) this.e.findViewById(R.id.ksad_detail_reward_tip_new);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.i, new a.InterfaceC1088a() { // from class: com.kwad.sdk.reward.b.b.b.e.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1088a
                public void a() {
                    e.this.f();
                }
            }, this.j);
        }
    }
}
