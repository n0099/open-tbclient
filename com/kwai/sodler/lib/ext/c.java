package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String Rc;
    public final int ayc;
    public final String ayn;
    public final String ayo;
    public final String ayp;
    public final String ayq;
    public final String ayr;
    public final String ays;
    public final boolean ayt;
    public final boolean ayu;
    public final boolean ayv;
    public String ayw;
    public byte[] ayx;
    public boolean ayy;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String Rc;
        public int ayc;
        public String ayn;
        public String ayo;
        public String ayp;
        public String ayq;
        public String ayr;
        public String ays;
        public boolean ayt;
        public boolean ayu;
        public boolean ayv;
        public String ayw;
        public byte[] ayx;
        public boolean ayy;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ayc = 3;
            this.Rc = "sodler";
            this.ayn = "code-cache";
            this.ayo = "lib";
            this.ayp = SevenZipUtils.FILE_NAME_TEMP;
            this.ayr = "base-1.apk";
            this.ayq = ".tmp";
            this.ayu = false;
            this.ayt = false;
        }

        public final c FG() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this.ayt, this.ayu, this.ays, this.Rc, this.ayn, this.ayo, this.ayp, this.ayq, this.ayr, this.ayc, this.ayw, this.ayx, this.ayy, this.ayv, (byte) 0) : (c) invokeV.objValue;
        }

        public final a bF(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.ayy = false;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a bG(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.ayv = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a cI(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (i > 0) {
                    this.ayc = i;
                }
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a fc(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.Rc = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8, bArr, Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ayc = i;
        this.Rc = str2;
        this.ayn = str3;
        this.ayo = str4;
        this.ayp = str5;
        this.ayq = str6;
        this.ayr = str7;
        this.ays = str;
        this.ayt = z;
        this.ayu = z2;
        this.ayw = str8;
        this.ayx = bArr;
        this.ayy = z3;
        this.ayv = z4;
    }

    public /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4);
    }

    public final String FA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.ayo : (String) invokeV.objValue;
    }

    public final String FB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.ayp : (String) invokeV.objValue;
    }

    public final String FC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ayq : (String) invokeV.objValue;
    }

    public final String FD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.ayr : (String) invokeV.objValue;
    }

    public final boolean FE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.ayu : invokeV.booleanValue;
    }

    public final boolean FF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.ayv : invokeV.booleanValue;
    }

    public final String Fy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Rc : (String) invokeV.objValue;
    }

    public final String Fz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.ayn : (String) invokeV.objValue;
    }

    public final int getRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.ayc : invokeV.intValue;
    }
}
