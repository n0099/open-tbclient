package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
/* loaded from: classes8.dex */
public final class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    public final void M(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0467, this);
            this.li = (TextView) findViewById(R.id.obfuscated_res_0x7f0911e7);
            this.lm = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911e5);
            this.ln = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0911e6);
            this.ll = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911e0);
            this.lj = (TextView) findViewById(R.id.obfuscated_res_0x7f0911e1);
            this.lk = (TextView) findViewById(R.id.obfuscated_res_0x7f0911de);
            this.bc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0911e8);
            this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f0911df);
        }
    }
}
