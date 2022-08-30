package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.kwai.filedownloader.services.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class o implements e.a, u {
    public static /* synthetic */ Interceptable $ic;
    public static Class<?> atv;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Runnable> atw;
    public com.kwai.filedownloader.services.e atx;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-224696919, "Lcom/kwai/filedownloader/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-224696919, "Lcom/kwai/filedownloader/o;");
        }
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.atw = new ArrayList<>();
    }

    public static Class<?> CU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (atv == null) {
                atv = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getProxyRealClass(FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);
            }
            return atv;
        }
        return (Class) invokeV.objValue;
    }

    private void a(Context context, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, runnable) == null) {
            context.startService(new Intent(context, CU()));
        }
    }

    @Override // com.kwai.filedownloader.services.e.a
    public final void a(com.kwai.filedownloader.services.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.atx = eVar;
            this.atw.clear();
            for (Runnable runnable : (List) this.atw.clone()) {
                runnable.run();
            }
            f.CE().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, CU()));
        }
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)})) == null) {
            if (isConnected()) {
                this.atx.b(str, str2, z, i, i2, i3, z2, bVar, z3);
                return true;
            }
            return com.kwai.filedownloader.e.a.l(str, str2, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean bW(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? !isConnected() ? com.kwai.filedownloader.e.a.bW(i) : this.atx.bW(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.u
    public final byte bX(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? !isConnected() ? com.kwai.filedownloader.e.a.bX(i) : this.atx.bX(i) : invokeI.byteValue;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean bY(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? !isConnected() ? com.kwai.filedownloader.e.a.bY(i) : this.atx.bY(i) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.u
    public final void dC(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            a(context, null);
        }
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.atx != null : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.services.e.a
    public final void onDisconnected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.atx = null;
            f.CE().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, CU()));
        }
    }
}
