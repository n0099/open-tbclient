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
/* loaded from: classes7.dex */
public class e extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f41093b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41094c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f41095d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f41096e;

    /* renamed from: f  reason: collision with root package name */
    public WebpAnimationImageView f41097f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41098g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41099h;
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
            this.f41098g.setVisibility(8);
            this.f41099h.setText(q().getString(R.string.obfuscated_res_0x7f0f09b2));
            r();
        } else if (i == 0) {
        } else {
            TextView textView = this.f41098g;
            textView.setText(i + "s");
            this.f41098g.setVisibility(0);
            this.f41099h.setText(this.k);
        }
    }

    private void a(final String str) {
        if (at.a(str) || !FrameSequence.isEnable()) {
            this.f41097f.setImageResource(R.drawable.obfuscated_res_0x7f080c94);
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
                public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    if (str.equals(str2)) {
                        if (decodedResult.mFrameSequence != null) {
                            e.this.f41097f.setWebpStream(decodedResult.mFrameSequence);
                            e.this.f41097f.a();
                            return;
                        }
                        Bitmap bitmap = decodedResult.mBitmap;
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        e.this.f41097f.setImageBitmap(decodedResult.mBitmap);
                    }
                }
            });
        }
    }

    private void e() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f41093b.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.f41093b.setLayoutParams(marginLayoutParams);
        this.f41094c.setVisibility(8);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.i);
        long b2 = com.kwad.sdk.core.response.a.a.b(j) * 1000;
        long p = com.kwad.sdk.core.response.a.a.p(j);
        if (p > 0 && b2 != 0) {
            b2 = Math.min(p, b2);
        }
        String a = com.kwad.sdk.core.response.a.c.a(this.i);
        this.k = a;
        if (at.a(a)) {
            this.k = q().getString(R.string.obfuscated_res_0x7f0f09b1);
        }
        a(com.kwad.sdk.core.response.a.c.b(this.i));
        a(b2, 0L);
        this.f41096e.setOnClickListener(this);
        this.f41096e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.kwad.sdk.core.report.a.a(this.i, 41, ((g) this).a.j.getTouchCoords(), ((g) this).a.f40745e);
        ((g) this).a.f40742b.a();
    }

    private void r() {
        ((g) this).a.f40742b.e();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.i = aVar.f40747g;
        this.j = aVar.l;
        e();
        ((g) this).a.k.a(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.l);
        this.f41097f.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f41094c = (TextView) a(R.id.obfuscated_res_0x7f091167);
        this.f41093b = (ImageView) a(R.id.obfuscated_res_0x7f09117c);
        this.f41095d = (ImageView) a(R.id.obfuscated_res_0x7f091065);
        ViewGroup viewGroup = (ViewGroup) a(R.id.obfuscated_res_0x7f0910ef);
        this.f41096e = viewGroup;
        this.f41097f = (WebpAnimationImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091067);
        this.f41098g = (TextView) this.f41096e.findViewById(R.id.obfuscated_res_0x7f091168);
        this.f41099h = (TextView) this.f41096e.findViewById(R.id.obfuscated_res_0x7f091068);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f41096e) {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.i).a(this.j).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.3
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    e.this.i();
                }
            }));
        }
    }
}
