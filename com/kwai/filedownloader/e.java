package com.kwai.filedownloader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
/* loaded from: classes8.dex */
public abstract class e extends com.kwai.filedownloader.event.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadServiceConnectChangedEvent.ConnectStatus atb;

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

    public abstract void CB();

    public abstract void CC();

    public final DownloadServiceConnectChangedEvent.ConnectStatus CD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.atb : (DownloadServiceConnectChangedEvent.ConnectStatus) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.event.c
    public final boolean a(com.kwai.filedownloader.event.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar instanceof DownloadServiceConnectChangedEvent) {
                DownloadServiceConnectChangedEvent.ConnectStatus DU = ((DownloadServiceConnectChangedEvent) bVar).DU();
                this.atb = DU;
                if (DU == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
                    CB();
                    return false;
                }
                CC();
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
