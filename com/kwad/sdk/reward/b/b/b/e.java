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
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36343b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36344c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36345d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f36346e;

    /* renamed from: f  reason: collision with root package name */
    public AnimatedImageView f36347f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36348g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f36349h;
    public AdTemplate i;
    public com.kwad.sdk.core.download.b.b j;
    public String k;
    public com.kwad.sdk.contentalliance.detail.video.e l = new f() { // from class: com.kwad.sdk.reward.b.b.b.e.1
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
            this.f36348g.setVisibility(8);
            this.f36349h.setText(o().getString(R.string.ksad_reward_success_tip));
            g();
        } else if (i == 0) {
        } else {
            TextView textView = this.f36348g;
            textView.setText(i + "s");
            this.f36348g.setVisibility(0);
            this.f36349h.setText(this.k);
        }
    }

    private void a(final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            this.f36347f.setImageResource(R.drawable.ksad_reward_icon_detail);
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
                            e.this.f36347f.setWebpStream(decodedResult.mFrameSequence);
                            e.this.f36347f.a();
                            return;
                        }
                        Bitmap bitmap = decodedResult.mBitmap;
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        e.this.f36347f.setImageBitmap(decodedResult.mBitmap);
                    }
                }
            });
        }
    }

    private void e() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f36343b.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.f36343b.setLayoutParams(marginLayoutParams);
        this.f36344c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f36346e.getLayoutParams();
        ImageView imageView = this.f36345d;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f36346e.setLayoutParams(layoutParams);
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.i);
        long b2 = com.kwad.sdk.core.response.b.a.b(j) * 1000;
        long m = com.kwad.sdk.core.response.b.a.m(j);
        if (!com.kwad.sdk.core.response.b.a.l(j) && m > 0 && b2 != 0) {
            b2 = Math.min(m, b2);
        }
        String b3 = com.kwad.sdk.core.response.b.b.b(this.i);
        this.k = b3;
        if (ag.a(b3)) {
            this.k = o().getString(R.string.ksad_reward_default_tip);
        }
        a(com.kwad.sdk.core.response.b.b.c(this.i));
        a(b2, 0L);
        this.f36346e.setOnClickListener(this);
        this.f36346e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.a(this.i, 41, ((com.kwad.sdk.reward.d) this).f36457a.f36223h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36457a.f36219d);
        ((com.kwad.sdk.reward.d) this).f36457a.f36217b.a();
    }

    private void g() {
        ((com.kwad.sdk.reward.d) this).f36457a.f36217b.e();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36457a;
        this.i = aVar.f36221f;
        this.j = aVar.j;
        e();
        ((com.kwad.sdk.reward.d) this).f36457a.i.a(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36457a.i.b(this.l);
        this.f36347f.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36344c = (TextView) b(R.id.ksad_video_count_down);
        this.f36343b = (ImageView) b(R.id.ksad_video_sound_switch);
        this.f36345d = (ImageView) b(R.id.ksad_detail_close_btn);
        ViewGroup viewGroup = (ViewGroup) b(R.id.ksad_reward_container_new);
        this.f36346e = viewGroup;
        this.f36347f = (AnimatedImageView) viewGroup.findViewById(R.id.ksad_detail_reward_icon_new);
        this.f36348g = (TextView) this.f36346e.findViewById(R.id.ksad_video_count_down_new);
        this.f36349h = (TextView) this.f36346e.findViewById(R.id.ksad_detail_reward_tip_new);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36346e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.i, new a.InterfaceC0378a() { // from class: com.kwad.sdk.reward.b.b.b.e.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
                public void a() {
                    e.this.f();
                }
            }, this.j);
        }
    }
}
