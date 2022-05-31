package com.tencent.mm.opensdk.diffdev.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b g;

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ArrayList<OAuthListener> arrayList = new ArrayList();
            list = this.g.f.c;
            arrayList.addAll(list);
            for (OAuthListener oAuthListener : arrayList) {
                oAuthListener.onQrcodeScanned();
            }
        }
    }
}
