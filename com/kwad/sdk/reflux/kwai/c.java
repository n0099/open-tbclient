package com.kwad.sdk.reflux.kwai;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes2.dex */
public class c extends a {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reflux.kwai.a
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, attributeSet, i2) == null) {
            FrameLayout.inflate(context, R.layout.ksad_reflux_card_top, this);
            ((a) this).a = (TextView) findViewById(R.id.ksad_reflux_card_title);
            ((a) this).f58861e = (ImageView) findViewById(R.id.ksad_reflux_card_img);
            ((a) this).f58862f = (KsLogoView) findViewById(R.id.ksad_reflux_card_logo);
            ((a) this).f58860d = (ImageView) findViewById(R.id.ksad_reflux_app_icon);
            ((a) this).f58858b = (TextView) findViewById(R.id.ksad_reflux_app_name);
            ((a) this).f58859c = (TextView) findViewById(R.id.ksad_reflux_app_desc);
            ((a) this).f58863g = (ComplianceTextView) findViewById(R.id.ksad_reflux_card_title_compliance);
            this.f58864h = (DownloadProgressView) findViewById(R.id.ksad_reflux_app_download_btn);
        }
    }
}
