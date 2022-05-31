package com.kwad.sdk.reflux.kwai;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class b extends a {
    public ImageView i;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.reflux.kwai.a
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0440, this);
        ((a) this).a = (TextView) findViewById(R.id.obfuscated_res_0x7f09109f);
        ((a) this).e = (ImageView) findViewById(R.id.obfuscated_res_0x7f09109d);
        ((a) this).f = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09109e);
        ((a) this).d = (ImageView) findViewById(R.id.obfuscated_res_0x7f091098);
        ((a) this).b = (TextView) findViewById(R.id.obfuscated_res_0x7f091099);
        ((a) this).c = (TextView) findViewById(R.id.obfuscated_res_0x7f091096);
        ((a) this).g = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0910a0);
        this.h = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091097);
        this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f09109b);
    }

    @Override // com.kwad.sdk.reflux.kwai.a
    public void a(com.kwad.sdk.reflux.b bVar) {
        super.a(bVar);
        if (bVar == null || bVar.c() == null || this.i == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getContext(), bVar.h(), this.i, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.sdk.reflux.kwai.b.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }
}
