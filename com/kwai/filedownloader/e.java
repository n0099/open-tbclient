package com.kwai.filedownloader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
/* loaded from: classes5.dex */
public abstract class e extends com.kwai.filedownloader.event.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadServiceConnectChangedEvent.ConnectStatus a;

    public e() {
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

    public abstract void a();

    @Override // com.kwai.filedownloader.event.c
    public final boolean a(com.kwai.filedownloader.event.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar instanceof DownloadServiceConnectChangedEvent) {
                DownloadServiceConnectChangedEvent.ConnectStatus a = ((DownloadServiceConnectChangedEvent) bVar).a();
                this.a = a;
                if (a == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
                    a();
                    return false;
                }
                b();
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract void b();

    public final DownloadServiceConnectChangedEvent.ConnectStatus c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (DownloadServiceConnectChangedEvent.ConnectStatus) invokeV.objValue;
    }
}
