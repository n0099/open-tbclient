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
/* loaded from: classes5.dex */
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
    public final void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0448, this);
            ((a) this).a = (TextView) findViewById(R.id.obfuscated_res_0x7f0910dd);
            ((a) this).e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910db);
            ((a) this).f = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0910dc);
            ((a) this).d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910d6);
            ((a) this).b = (TextView) findViewById(R.id.obfuscated_res_0x7f0910d7);
            ((a) this).c = (TextView) findViewById(R.id.obfuscated_res_0x7f0910d4);
            ((a) this).g = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0910de);
            ((a) this).h = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f0910d5);
        }
    }
}
