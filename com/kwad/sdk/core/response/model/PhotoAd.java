package com.kwad.sdk.core.response.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class PhotoAd extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3907193550069150451L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean requestAggregateAd;
    public boolean requestBannerAd;
    public boolean requestDynamicRewardAd;
    public boolean requestInsertScreenAd;
    public boolean requestPatchAd;
    public boolean requestPatchEc;
    public boolean requestWidgetAd;
    @Deprecated
    public int widgetAdPosition;

    public PhotoAd() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestDynamicRewardAd = true;
    }
}
