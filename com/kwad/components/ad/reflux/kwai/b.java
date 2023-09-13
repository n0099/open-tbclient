package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class b extends a {
    public ImageView lr;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    public final void M(@NonNull Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04d2, this);
        this.li = (TextView) findViewById(R.id.obfuscated_res_0x7f09136e);
        this.lm = (ImageView) findViewById(R.id.obfuscated_res_0x7f09136c);
        this.ln = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09136d);
        this.ll = (ImageView) findViewById(R.id.obfuscated_res_0x7f091367);
        this.lj = (TextView) findViewById(R.id.obfuscated_res_0x7f091368);
        this.lk = (TextView) findViewById(R.id.obfuscated_res_0x7f091365);
        this.bc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f09136f);
        this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091366);
        this.lr = (ImageView) findViewById(R.id.obfuscated_res_0x7f09136a);
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    public final void a(com.kwad.components.ad.reflux.a aVar) {
        super.a(aVar);
        if (aVar == null || aVar.getAdTemplate() == null || this.lr == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getContext(), aVar.eO(), this.lr, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reflux.kwai.b.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }
}
