package com.kwad.sdk.reflux.kwai;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes5.dex */
public class c extends a {
    public c(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.reflux.kwai.a
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0457, this);
        ((a) this).a = (TextView) findViewById(R.id.obfuscated_res_0x7f0910d0);
        ((a) this).e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910cb);
        ((a) this).f = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0910cc);
        ((a) this).d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910c6);
        ((a) this).b = (TextView) findViewById(R.id.obfuscated_res_0x7f0910c7);
        ((a) this).c = (TextView) findViewById(R.id.obfuscated_res_0x7f0910c4);
        ((a) this).g = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0910d1);
        this.h = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f0910c5);
    }
}
