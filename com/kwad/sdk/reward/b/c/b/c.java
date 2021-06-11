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
    public ViewGroup f37165b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37166c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatedImageView f37167d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatedImageView f37168e;

    /* renamed from: f  reason: collision with root package name */
    public e f37169f = new e() { // from class: com.kwad.sdk.reward.b.c.b.c.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.e();
        }
    };

    private void a(final AnimatedImageView animatedImageView, final String str) {
        if (ag.a(str) || !FrameSequence.isEnable()) {
            animatedImageView.setImageResource(R.drawable.ksad_reward_icon_end);
        } else {
            KSImageLoader.loadImage(str, ((d) this).f37201a.f36955f, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reward.b.c.b.c.2
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
        if (((d) this).f37201a.q) {
            this.f37166c.setVisibility(8);
            String d2 = com.kwad.sdk.core.response.b.b.d(((d) this).f37201a.f36955f);
            if (((d) this).f37201a.f36954e != 1) {
                a(this.f37168e, d2);
                this.f37168e.setVisibility(0);
                this.f37168e.setOnClickListener(this);
                this.f37165b.setVisibility(8);
                return;
            }
            a(this.f37167d, d2);
            this.f37167d.setVisibility(0);
            imageView = this.f37167d;
        } else {
            this.f37167d.setVisibility(8);
            this.f37168e.setVisibility(8);
            this.f37166c.setVisibility(0);
            imageView = this.f37166c;
        }
        imageView.setOnClickListener(this);
        this.f37165b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.reward.a aVar = ((d) this).f37201a;
        com.kwad.sdk.core.report.b.a(aVar.f36955f, 41, aVar.f36957h.getTouchCoords(), ((d) this).f37201a.f36953d);
        ((d) this).f37201a.f36951b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f37201a.n.add(this.f37169f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37201a.n.remove(this.f37169f);
        this.f37167d.b();
        this.f37168e.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37165b = (ViewGroup) b(R.id.ksad_end_reward_icon_layout);
        this.f37166c = (ImageView) b(R.id.ksad_end_reward_icon);
        this.f37167d = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_left);
        this.f37168e = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37166c || view == this.f37167d || view == this.f37168e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), ((d) this).f37201a.f36955f, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.b.c.b.c.3
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    c.this.f();
                }
            }, ((d) this).f37201a.j);
        }
    }
}
