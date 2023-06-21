package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
/* loaded from: classes9.dex */
public final class c extends a {
    public c(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    public final void M(@NonNull Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04b6, this);
        this.li = (TextView) findViewById(R.id.obfuscated_res_0x7f09131b);
        this.lm = (ImageView) findViewById(R.id.obfuscated_res_0x7f091319);
        this.ln = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09131a);
        this.ll = (ImageView) findViewById(R.id.obfuscated_res_0x7f091314);
        this.lj = (TextView) findViewById(R.id.obfuscated_res_0x7f091315);
        this.lk = (TextView) findViewById(R.id.obfuscated_res_0x7f091312);
        this.bc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f09131c);
        this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091313);
    }
}
