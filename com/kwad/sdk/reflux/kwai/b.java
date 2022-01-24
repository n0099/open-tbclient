package com.kwad.sdk.reflux.kwai;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: i  reason: collision with root package name */
    public ImageView f57246i;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.reflux.kwai.a
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        FrameLayout.inflate(context, R.layout.ksad_reflux_card_left, this);
        ((a) this).a = (TextView) findViewById(R.id.ksad_reflux_card_title);
        ((a) this).f57239e = (ImageView) findViewById(R.id.ksad_reflux_card_img);
        ((a) this).f57240f = (KsLogoView) findViewById(R.id.ksad_reflux_card_logo);
        ((a) this).f57238d = (ImageView) findViewById(R.id.ksad_reflux_app_icon);
        ((a) this).f57236b = (TextView) findViewById(R.id.ksad_reflux_app_name);
        ((a) this).f57237c = (TextView) findViewById(R.id.ksad_reflux_app_desc);
        ((a) this).f57241g = (ComplianceTextView) findViewById(R.id.ksad_reflux_card_title_compliance);
        this.f57242h = (DownloadProgressView) findViewById(R.id.ksad_reflux_app_download_btn);
        this.f57246i = (ImageView) findViewById(R.id.ksad_reflux_card_blur);
    }

    @Override // com.kwad.sdk.reflux.kwai.a
    public void a(com.kwad.sdk.reflux.b bVar) {
        super.a(bVar);
        if (bVar == null || bVar.c() == null || this.f57246i == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getContext(), bVar.h(), this.f57246i, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reflux.kwai.b.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }
}
