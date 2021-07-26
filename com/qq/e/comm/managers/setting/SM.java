package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.setting.e;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class SM {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f38195a;

    /* renamed from: b  reason: collision with root package name */
    public String f38196b;

    /* renamed from: c  reason: collision with root package name */
    public a f38197c;

    /* renamed from: d  reason: collision with root package name */
    public a f38198d;

    /* renamed from: e  reason: collision with root package name */
    public String f38199e;

    /* renamed from: f  reason: collision with root package name */
    public d f38200f;

    /* renamed from: g  reason: collision with root package name */
    public d f38201g;

    /* renamed from: h  reason: collision with root package name */
    public String f38202h;

    /* renamed from: i  reason: collision with root package name */
    public c f38203i;
    public String j;
    public String k;
    public Context l;
    public String m;

    public SM(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = "";
        this.l = context;
        this.f38195a = new a();
        this.f38198d = new a();
        this.f38201g = new b();
        this.f38203i = new c();
        this.m = SystemUtil.buildNewPathByProcessName("e_qq_com_setting");
        try {
            this.j = StringUtil.readAll(new File(this.l.getDir(this.m, 0), "gdt_suid"));
        } catch (Throwable unused) {
            this.j = null;
            GDTLogger.e("IO Exception while loading suid");
        }
        a();
        b();
        c();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            e.a<d> b2 = e.b(this.l);
            if (b2 == null) {
                GDTLogger.d("Load Local SDK Cloud setting fail");
                return;
            }
            this.f38199e = b2.a();
            this.f38200f = b2.b();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            e.a<a> a2 = e.a(this.l);
            if (a2 == null) {
                GDTLogger.d("Load Local DEV Cloud setting fail");
                return;
            }
            this.f38197c = a2.b();
            this.f38196b = a2.a();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            e.a<c> c2 = e.c(this.l);
            if (c2 == null) {
                GDTLogger.d("Load Local DEV Cloud setting fail");
                return;
            }
            this.f38203i = c2.b();
            this.f38202h = c2.a();
        }
    }

    public Object get(String str) {
        InterceptResult invokeL;
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                if (this.f38195a == null || (a5 = this.f38195a.a(str)) == null) {
                    if (this.f38197c == null || (a4 = this.f38197c.a(str)) == null) {
                        if (this.f38198d == null || (a3 = this.f38198d.a(str)) == null) {
                            if (this.f38200f == null || (a2 = this.f38200f.a(str)) == null) {
                                if (this.f38201g != null) {
                                    return this.f38201g.a(str);
                                }
                                return null;
                            }
                            return a2;
                        }
                        return a3;
                    }
                    return a4;
                }
                return a5;
            } catch (Throwable th) {
                GDTLogger.report("Exception in settingManager.get Setting for key:" + str, th);
                return null;
            }
        }
        return invokeL.objValue;
    }

    public String getDevCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38196b : (String) invokeV.objValue;
    }

    public Object getForPlacement(String str, String str2) {
        InterceptResult invokeLL;
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                return get(str);
            }
            try {
                return (this.f38203i == null || (a5 = this.f38203i.a(str, str2)) == null) ? (this.f38195a == null || (a4 = this.f38195a.a(str, str2)) == null) ? (this.f38197c == null || (a3 = this.f38197c.a(str, str2)) == null) ? (this.f38198d == null || (a2 = this.f38198d.a(str, str2)) == null) ? get(str) : a2 : a3 : a4 : a5;
            } catch (Throwable th) {
                GDTLogger.report("Exception in settingManager.getForPlacement", th);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public int getInteger(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            Object obj = get(str);
            return (obj == null || !(obj instanceof Integer)) ? i2 : ((Integer) obj).intValue();
        }
        return invokeLI.intValue;
    }

    public int getIntegerForPlacement(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, str2, i2)) == null) {
            Object forPlacement = getForPlacement(str, str2);
            return (forPlacement == null || !(forPlacement instanceof Integer)) ? i2 : ((Integer) forPlacement).intValue();
        }
        return invokeLLI.intValue;
    }

    public String getPlacementCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38202h : (String) invokeV.objValue;
    }

    public String getSdkCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38199e : (String) invokeV.objValue;
    }

    public String getSettingDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            Object obj = get(str);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            Object obj = get(str);
            return obj == null ? str2 : obj.toString();
        }
        return (String) invokeLL.objValue;
    }

    public String getStringForPlacement(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            Object forPlacement = getForPlacement(str, str2);
            if (forPlacement == null) {
                return null;
            }
            return forPlacement.toString();
        }
        return (String) invokeLL.objValue;
    }

    public String getSuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public void setDEVCodeSetting(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, obj) == null) {
            this.f38198d.a(str, obj);
        }
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, obj, str2) == null) {
            this.f38198d.a(str, obj, str2);
        }
    }

    public void updateContextSetting(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            try {
                a aVar = new a();
                if (!TextUtils.isEmpty(str)) {
                    aVar = new a(new String(Base64.decode(str, 0), "UTF-8"));
                }
                this.f38195a = aVar;
            } catch (Throwable th) {
                GDTLogger.report("Exception while update Context Setting", th);
            }
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) && e.b(this.l, str, str2)) {
            b();
        }
    }

    public void updatePlacementSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                e.d(this.l);
                this.f38203i = new c();
                this.f38202h = null;
            } else if (e.c(this.l, str, str2)) {
                c();
            }
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) && e.a(this.l, str, str2)) {
            a();
        }
    }

    public void updateSID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.k = str;
        }
    }

    public void updateSUID(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || TextUtils.isEmpty(str) || str.equals(this.j)) {
            return;
        }
        this.j = str;
        try {
            StringUtil.writeTo(str, new File(this.l.getDir(this.m, 0), "gdt_suid"));
        } catch (IOException e2) {
            GDTLogger.report("Exception while persit suid", e2);
        }
    }
}
