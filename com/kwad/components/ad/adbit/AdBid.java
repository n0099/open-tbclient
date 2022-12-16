package com.kwad.components.ad.adbit;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
@KsJson
/* loaded from: classes8.dex */
public class AdBid extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3937320872050889919L;
    public transient /* synthetic */ FieldHolder $fh;
    public int bidEcpm;
    public long creativeId;
    public long ecpm;
    public String materialId;
    public String winNoticeUrl;

    public AdBid() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
