package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class e extends g implements View.OnClickListener {
    public ImageView b;
    public TextView c;
    public ImageView d;
    public ViewGroup e;
    public WebpAnimationImageView f;
    public TextView g;
    public TextView h;
    public AdTemplate i;
    public com.kwad.sdk.core.download.a.b j;
    public String k;
    public com.kwad.sdk.contentalliance.detail.video.d l = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(e.this.i));
            if (p > 0) {
                j = Math.min(j, p);
            }
            e.this.a(j, j2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        int i = (int) ((((float) (j - j2)) / 1000.0f) + 0.5f);
        if (i < 0) {
            this.g.setVisibility(8);
            this.h.setText(q().getString(R.string.obfuscated_res_0x7f0f09c1));
            r();
        } else if (i == 0) {
        } else {
            TextView textView = this.g;
            textView.setText(i + "s");
            this.g.setVisibility(0);
            this.h.setText(this.k);
        }
    }

    private void a(final String str) {
        if (at.a(str) || !FrameSequence.isEnable()) {
            this.f.setImageResource(R.drawable.obfuscated_res_0x7f080cb0);
        } else {
            KSImageLoader.loadImage(str, this.i, KSImageLoader.IMGOPTION_ENTRY_FS(), new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.2
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
                public void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                    if (str.equals(str2)) {
                        if (decodedResult.mFrameSequence != null) {
                            e.this.f.setWebpStream(decodedResult.mFrameSequence);
                            e.this.f.a();
                            return;
                        }
                        Bitmap bitmap = decodedResult.mBitmap;
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        e.this.f.setImageBitmap(decodedResult.mBitmap);
                    }
                }
            });
        }
    }

    private void e() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.b.setLayoutParams(marginLayoutParams);
        this.c.setVisibility(8);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.i);
        long b = com.kwad.sdk.core.response.a.a.b(j) * 1000;
        long p = com.kwad.sdk.core.response.a.a.p(j);
        if (p > 0 && b != 0) {
            b = Math.min(p, b);
        }
        String a = com.kwad.sdk.core.response.a.c.a(this.i);
        this.k = a;
        if (at.a(a)) {
            this.k = q().getString(R.string.obfuscated_res_0x7f0f09c0);
        }
        a(com.kwad.sdk.core.response.a.c.b(this.i));
        a(b, 0L);
        this.e.setOnClickListener(this);
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.kwad.sdk.core.report.a.a(this.i, 41, ((g) this).a.j.getTouchCoords(), ((g) this).a.e);
        ((g) this).a.b.a();
    }

    private void r() {
        ((g) this).a.b.e();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.i = aVar.g;
        this.j = aVar.l;
        e();
        ((g) this).a.k.a(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.l);
        this.f.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.c = (TextView) a(R.id.obfuscated_res_0x7f091122);
        this.b = (ImageView) a(R.id.obfuscated_res_0x7f091137);
        this.d = (ImageView) a(R.id.obfuscated_res_0x7f091020);
        ViewGroup viewGroup = (ViewGroup) a(R.id.obfuscated_res_0x7f0910a7);
        this.e = viewGroup;
        this.f = (WebpAnimationImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091022);
        this.g = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091123);
        this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091023);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.e) {
            com.kwad.sdk.core.download.a.a.a(new a.C0304a(view2.getContext()).a(this.i).a(this.j).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.3
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    e.this.i();
                }
            }));
        }
    }
}
