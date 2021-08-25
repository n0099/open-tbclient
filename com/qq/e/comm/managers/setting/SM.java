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
/* loaded from: classes10.dex */
public class SM {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f75176a;

    /* renamed from: b  reason: collision with root package name */
    public String f75177b;

    /* renamed from: c  reason: collision with root package name */
    public a f75178c;

    /* renamed from: d  reason: collision with root package name */
    public a f75179d;

    /* renamed from: e  reason: collision with root package name */
    public String f75180e;

    /* renamed from: f  reason: collision with root package name */
    public d f75181f;

    /* renamed from: g  reason: collision with root package name */
    public d f75182g;

    /* renamed from: h  reason: collision with root package name */
    public String f75183h;

    /* renamed from: i  reason: collision with root package name */
    public c f75184i;

    /* renamed from: j  reason: collision with root package name */
    public final c f75185j;
    public String k;
    public String l;
    public Context m;
    public String n;

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
        this.l = "";
        this.m = context;
        this.f75176a = new a();
        this.f75179d = new a();
        this.f75182g = new b();
        this.f75184i = new c();
        this.f75185j = new c();
        this.n = SystemUtil.buildNewPathByProcessName("e_qq_com_setting");
        try {
            this.k = StringUtil.readAll(new File(this.m.getDir(this.n, 0), "gdt_suid"));
        } catch (Throwable unused) {
            this.k = null;
            GDTLogger.d("IO Exception while loading suid");
        }
        a();
        b();
        c();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            e.a<d> b2 = e.b(this.m);
            if (b2 == null) {
                GDTLogger.d("Load Local SDK Cloud setting fail");
                return;
            }
            this.f75180e = b2.a();
            this.f75181f = b2.b();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            e.a<a> a2 = e.a(this.m);
            if (a2 == null) {
                GDTLogger.d("Load Local DEV Cloud setting fail");
                return;
            }
            this.f75178c = a2.b();
            this.f75177b = a2.a();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            e.a<c> c2 = e.c(this.m);
            if (c2 == null) {
                GDTLogger.d("Load Local DEV Cloud setting fail");
                return;
            }
            this.f75184i = c2.b();
            this.f75183h = c2.a();
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
            if (StringUtil.isEmpty(str)) {
                return null;
            }
            try {
                if (this.f75176a == null || (a5 = this.f75176a.a(str)) == null) {
                    if (this.f75178c == null || (a4 = this.f75178c.a(str)) == null) {
                        if (this.f75179d == null || (a3 = this.f75179d.a(str)) == null) {
                            if (this.f75181f == null || (a2 = this.f75181f.a(str)) == null) {
                                if (this.f75182g != null) {
                                    return this.f75182g.a(str);
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
            } catch (Throwable unused) {
                GDTLogger.d("Exception in settingManager.get Setting for key");
                return null;
            }
        }
        return invokeL.objValue;
    }

    public String getDevCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f75177b : (String) invokeV.objValue;
    }

    public Object getDisplaySetting(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f75185j.a(str) : invokeL.objValue;
    }

    public Object getForPlacement(String str, String str2) {
        InterceptResult invokeLL;
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (StringUtil.isEmpty(str)) {
                return null;
            }
            if (StringUtil.isEmpty(str2)) {
                return get(str);
            }
            try {
                Object a6 = this.f75185j.a(str, str2);
                return a6 != null ? a6 : (this.f75184i == null || (a5 = this.f75184i.a(str, str2)) == null) ? (this.f75176a == null || (a4 = this.f75176a.a(str, str2)) == null) ? (this.f75178c == null || (a3 = this.f75178c.a(str, str2)) == null) ? (this.f75179d == null || (a2 = this.f75179d.a(str, str2)) == null) ? get(str) : a2 : a3 : a4 : a5;
            } catch (Throwable unused) {
                GDTLogger.d("Exception in settingManager.getForPlacement");
                return null;
            }
        }
        return invokeLL.objValue;
    }

    @Deprecated
    public int getInteger(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) {
            Object obj = get(str);
            return (obj == null || !(obj instanceof Integer)) ? i2 : ((Integer) obj).intValue();
        }
        return invokeLI.intValue;
    }

    public int getIntegerForPlacement(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, str, str2, i2)) == null) {
            Object forPlacement = getForPlacement(str, str2);
            return (forPlacement == null || !(forPlacement instanceof Integer)) ? i2 : ((Integer) forPlacement).intValue();
        }
        return invokeLLI.intValue;
    }

    public String getPlacementCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f75183h : (String) invokeV.objValue;
    }

    public String getSdkCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f75180e : (String) invokeV.objValue;
    }

    public String getSettingDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    @Deprecated
    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Object obj = get(str);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            Object obj = get(str);
            return obj == null ? str2 : obj.toString();
        }
        return (String) invokeLL.objValue;
    }

    public String getStringForPlacement(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) ? getStringForPlacement(str, str2, null) : (String) invokeLL.objValue;
    }

    public String getStringForPlacement(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, str, str2, str3)) == null) {
            Object forPlacement = getForPlacement(str, str2);
            return forPlacement == null ? str3 : forPlacement.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public String getSuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void setDEVCodeSetting(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, obj) == null) {
            this.f75179d.a(str, obj);
        }
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, obj, str2) == null) {
            this.f75179d.a(str, obj, str2);
        }
    }

    public void updateContextSetting(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            try {
                a aVar = new a();
                if (!TextUtils.isEmpty(str)) {
                    aVar = new a(new String(Base64.decode(str, 0), "UTF-8"));
                }
                this.f75176a = aVar;
            } catch (Throwable unused) {
                GDTLogger.d("Exception while update Context Setting");
            }
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) && e.b(this.m, str, str2)) {
            b();
        }
    }

    public void updateDisplaySetting(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, obj) == null) {
            this.f75185j.a(str, obj);
        }
    }

    public void updatePlacementSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                e.d(this.m);
                this.f75184i = new c();
                this.f75183h = null;
            } else if (e.c(this.m, str, str2)) {
                c();
            }
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) && e.a(this.m, str, str2)) {
            a();
        }
    }

    public void updateSID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.l = str;
        }
    }

    public void updateSUID(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || TextUtils.isEmpty(str) || str.equals(this.k)) {
            return;
        }
        this.k = str;
        try {
            StringUtil.writeTo(str, new File(this.m.getDir(this.n, 0), "gdt_suid"));
        } catch (IOException unused) {
            GDTLogger.d("Exception while persit suid");
        }
    }
}
