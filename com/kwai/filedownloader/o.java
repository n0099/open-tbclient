package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.design.provider.ServiceProvider;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.kwai.filedownloader.services.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o implements e.a, u {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Runnable> f58332b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.filedownloader.services.e f58333c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-224696919, "Lcom/kwai/filedownloader/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-224696919, "Lcom/kwai/filedownloader/o;");
                return;
            }
        }
        a = ((com.kwad.sdk.design.kwai.b) ServiceProvider.a(com.kwad.sdk.design.kwai.b.class)).a(FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58332b = new ArrayList<>();
    }

    @Override // com.kwai.filedownloader.services.e.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58333c = null;
            f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, a));
        }
    }

    @Override // com.kwai.filedownloader.u
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            a(context, null);
        }
    }

    public void a(Context context, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, runnable) == null) {
            if (runnable != null && !this.f58332b.contains(runnable)) {
                this.f58332b.add(runnable);
            }
            context.startService(new Intent(context, a));
        }
    }

    @Override // com.kwai.filedownloader.services.e.a
    public void a(com.kwai.filedownloader.services.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f58333c = eVar;
            this.f58332b.clear();
            for (Runnable runnable : (List) this.f58332b.clone()) {
                runnable.run();
            }
            f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, a));
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? !c() ? com.kwai.filedownloader.e.a.a(i2) : this.f58333c.a(i2) : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.u
    public boolean a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)})) == null) {
            if (c()) {
                this.f58333c.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
                return true;
            }
            return com.kwai.filedownloader.e.a.a(str, str2, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.kwai.filedownloader.u
    public byte b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? !c() ? com.kwai.filedownloader.e.a.b(i2) : this.f58333c.e(i2) : invokeI.byteValue;
    }

    @Override // com.kwai.filedownloader.u
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58333c != null : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.u
    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? !c() ? com.kwai.filedownloader.e.a.c(i2) : this.f58333c.f(i2) : invokeI.booleanValue;
    }
}
