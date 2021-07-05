package com.kwai.filedownloader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
/* loaded from: classes7.dex */
public abstract class e extends com.kwai.filedownloader.event.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadServiceConnectChangedEvent.ConnectStatus f39619a;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void a();

    @Override // com.kwai.filedownloader.event.c
    public boolean a(com.kwai.filedownloader.event.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar instanceof DownloadServiceConnectChangedEvent) {
                DownloadServiceConnectChangedEvent.ConnectStatus a2 = ((DownloadServiceConnectChangedEvent) bVar).a();
                this.f39619a = a2;
                if (a2 == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
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

    public DownloadServiceConnectChangedEvent.ConnectStatus c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39619a : (DownloadServiceConnectChangedEvent.ConnectStatus) invokeV.objValue;
    }
}
