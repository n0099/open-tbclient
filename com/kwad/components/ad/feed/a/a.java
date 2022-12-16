package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public abstract class a extends com.kwad.components.core.widget.b<AdTemplate> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.feed.b dd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context) {
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

    public final void bf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f09111c);
            if (!com.kwad.sdk.core.response.a.a.ao(this.mAdInfo)) {
                complianceTextView.setVisibility(8);
                return;
            }
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && com.kwad.sdk.core.response.a.a.am(this.mAdInfo) && com.kwad.components.ad.feed.kwai.b.bd() && getApkDownloadHelper() != null) {
            DownloadProgressView downloadProgressView = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f0910f5);
            if (!z || getApkDownloadHelper().mI() == 2) {
                com.kwad.components.ad.feed.b bVar = this.dd;
                if (bVar != null) {
                    bVar.aX();
                    return;
                }
                return;
            }
            setPaddingToShowAnim(downloadProgressView);
            if (this.dd == null) {
                this.dd = new com.kwad.components.ad.feed.b();
            }
            this.dd.a(downloadProgressView);
        }
    }

    public com.kwad.components.core.c.a.c getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (com.kwad.components.core.c.a.c) invokeV.objValue;
    }

    public void setPaddingToShowAnim(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2.getParent() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        viewGroup.setPadding(0, 0, com.kwad.sdk.b.kwai.a.a(this.mContext, 4.0f), 0);
        viewGroup.setClipToPadding(false);
    }
}
