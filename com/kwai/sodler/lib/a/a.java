package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.i;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File axU;
    public String axV;
    public String axW;
    public boolean axX;
    public final byte[] axY;
    public final String axZ;
    public com.kwai.sodler.lib.ext.c axi;
    public com.kwai.sodler.lib.c.b aya;
    public String mVersion;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.axY = new byte[0];
        this.axX = false;
        this.axZ = str;
        this.axV = str;
        this.axi = i.EU().EX();
    }

    private void Fg() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.axX) {
            return;
        }
        synchronized (this.axY) {
            this.axX = true;
        }
    }

    public final String Fh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.axZ : (String) invokeV.objValue;
    }

    public final String Fi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.kwai.sodler.lib.c.b bVar = this.aya;
            if (bVar != null) {
                return bVar.ayC;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final a a(@NonNull com.kwai.sodler.lib.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            this.aya = bVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public abstract void ad(Context context, String str);

    public final void af(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            ad(context, str);
            Fg();
        }
    }

    public final void eT(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mVersion = str;
        }
    }

    public final void eU(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.axW = str;
        }
    }

    public final void eV(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.axV = str;
        }
    }

    public final String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.axW : (String) invokeV.objValue;
    }

    public final String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mVersion : (String) invokeV.objValue;
    }

    public final boolean isLoaded() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.axX) {
                return true;
            }
            synchronized (this.axY) {
                z = this.axX;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "Plugin{, ApkPath = '" + this.axZ + "'}";
        }
        return (String) invokeV.objValue;
    }
}
