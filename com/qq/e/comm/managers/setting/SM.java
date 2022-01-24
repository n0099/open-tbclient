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
import com.qq.e.comm.managers.setting.f;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SM {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public String f59142b;

    /* renamed from: c  reason: collision with root package name */
    public a f59143c;

    /* renamed from: d  reason: collision with root package name */
    public a f59144d;

    /* renamed from: e  reason: collision with root package name */
    public String f59145e;

    /* renamed from: f  reason: collision with root package name */
    public e f59146f;

    /* renamed from: g  reason: collision with root package name */
    public e f59147g;

    /* renamed from: h  reason: collision with root package name */
    public String f59148h;

    /* renamed from: i  reason: collision with root package name */
    public d f59149i;

    /* renamed from: j  reason: collision with root package name */
    public final d f59150j;
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
        this.a = new a();
        this.f59144d = new a();
        this.f59147g = new c();
        this.f59149i = new d();
        this.f59150j = new d();
        this.n = SystemUtil.buildNewPathByProcessName("e_qq_com_setting");
        d();
        c();
        a();
        b();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            f.b<a> a = f.a(this.m);
            if (a == null) {
                GDTLogger.d("Load Local DEV Cloud setting fail");
                return;
            }
            this.f59143c = a.a();
            this.f59142b = a.b();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            f.b<d> b2 = f.b(this.m);
            if (b2 == null) {
                GDTLogger.d("Load Local DEV Cloud setting fail");
                return;
            }
            this.f59149i = b2.a();
            this.f59148h = b2.b();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            f.b<e> c2 = f.c(this.m);
            if (c2 == null) {
                GDTLogger.d("Load Local SDK Cloud setting fail");
                return;
            }
            this.f59145e = c2.b();
            this.f59146f = c2.a();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                this.k = StringUtil.readAll(new File(this.m.getDir(this.n, 0), "gdt_suid"));
            } catch (Throwable unused) {
                this.k = null;
                GDTLogger.d("IO Exception while loading suid");
            }
        }
    }

    public Object get(String str) {
        InterceptResult invokeL;
        Object opt;
        Object opt2;
        Object opt3;
        Object opt4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (StringUtil.isEmpty(str)) {
                return null;
            }
            try {
                if (this.a == null || (opt4 = this.a.a.opt(str)) == null) {
                    if (this.f59143c == null || (opt3 = this.f59143c.a.opt(str)) == null) {
                        if (this.f59144d == null || (opt2 = this.f59144d.a.opt(str)) == null) {
                            if (this.f59146f == null || (opt = this.f59146f.a.opt(str)) == null) {
                                if (this.f59147g != null) {
                                    return this.f59147g.a.opt(str);
                                }
                                return null;
                            }
                            return opt;
                        }
                        return opt2;
                    }
                    return opt3;
                }
                return opt4;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59142b : (String) invokeV.objValue;
    }

    public Object getDisplaySetting(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f59150j.a.opt(str) : invokeL.objValue;
    }

    public Object getForPlacement(String str, String str2) {
        InterceptResult invokeLL;
        Object a;
        Object a2;
        Object a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (StringUtil.isEmpty(str)) {
                return null;
            }
            if (StringUtil.isEmpty(str2)) {
                return get(str);
            }
            try {
                JSONObject optJSONObject = this.f59150j.a.optJSONObject(str2);
                Object opt = optJSONObject != null ? optJSONObject.opt(str) : null;
                if (opt != null) {
                    return opt;
                }
                if (this.f59149i != null) {
                    JSONObject optJSONObject2 = this.f59149i.a.optJSONObject(str2);
                    Object opt2 = optJSONObject2 != null ? optJSONObject2.opt(str) : null;
                    if (opt2 != null) {
                        return opt2;
                    }
                }
                return (this.a == null || (a3 = this.a.a(str, str2)) == null) ? (this.f59143c == null || (a2 = this.f59143c.a(str, str2)) == null) ? (this.f59144d == null || (a = this.f59144d.a(str, str2)) == null) ? get(str) : a : a2 : a3;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59148h : (String) invokeV.objValue;
    }

    public String getSdkCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59145e : (String) invokeV.objValue;
    }

    public String getSettingDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public Set<String> getSettingKeySet(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f59150j);
            arrayList2.add(this.f59149i);
            arrayList2.add(this.a);
            arrayList2.add(this.f59143c);
            arrayList2.add(this.f59144d);
            arrayList2.add(this.f59146f);
            arrayList2.add(this.f59147g);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null && (jSONObject = bVar.a) != null) {
                    arrayList.add(jSONObject);
                    arrayList.add(bVar.a.optJSONObject(str));
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                JSONObject jSONObject2 = (JSONObject) it2.next();
                if (jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        hashSet.add(keys.next());
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    @Deprecated
    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            Object obj = get(str);
            return obj == null ? str2 : obj.toString();
        }
        return (String) invokeLL.objValue;
    }

    public String getStringForPlacement(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? getStringForPlacement(str, str2, null) : (String) invokeLL.objValue;
    }

    public String getStringForPlacement(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, str, str2, str3)) == null) {
            Object forPlacement = getForPlacement(str, str2);
            return forPlacement == null ? str3 : forPlacement.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public String getSuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void setDEVCodeSetting(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, obj) == null) {
            a aVar = this.f59144d;
            if (aVar == null) {
                throw null;
            }
            try {
                aVar.a.putOpt(str, obj);
            } catch (JSONException unused) {
                GDTLogger.d("Exception while update setting");
            }
        }
    }

    public void updateContextSetting(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            try {
                a aVar = new a();
                if (!TextUtils.isEmpty(str)) {
                    aVar = new a(new String(Base64.decode(str, 0), "UTF-8"));
                }
                this.a = aVar;
            } catch (Throwable unused) {
                GDTLogger.d("Exception while update Context Setting");
            }
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) && f.a(this.m, str, str2)) {
            a();
        }
    }

    public void updateDisplaySetting(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, obj) == null) {
            d dVar = this.f59150j;
            if (dVar == null) {
                throw null;
            }
            try {
                dVar.a.putOpt(str, obj);
            } catch (JSONException e2) {
                GDTLogger.d(e2.getMessage());
            }
        }
    }

    public void updatePlacementSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                if (f.b(this.m, str, str2)) {
                    b();
                    return;
                }
                return;
            }
            File dir = this.m.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
            if (dir.exists()) {
                File file = new File(dir, "placementCloudSetting.cfg");
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(dir, "placementCloudSetting.sig");
                if (file2.exists()) {
                    file2.delete();
                }
            }
            this.f59149i = new d();
            this.f59148h = null;
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && f.c(this.m, str, str2)) {
            c();
        }
    }

    public void updateSID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.l = str;
        }
    }

    public void updateSUID(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || TextUtils.isEmpty(str) || str.equals(this.k)) {
            return;
        }
        this.k = str;
        try {
            StringUtil.writeTo(str, new File(this.m.getDir(this.n, 0), "gdt_suid"));
        } catch (IOException unused) {
            GDTLogger.d("Exception while persit suid");
        }
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, str, obj, str2) == null) {
            a aVar = this.f59144d;
            if (aVar == null) {
                throw null;
            }
            try {
                JSONObject optJSONObject = aVar.a.optJSONObject("ps");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    aVar.a.putOpt("ps", optJSONObject);
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    optJSONObject.putOpt(str2, optJSONObject2);
                }
                if (obj == null) {
                    optJSONObject2.remove(str);
                } else {
                    optJSONObject2.putOpt(str, obj);
                }
            } catch (JSONException unused) {
                GDTLogger.d("Exception while update setting");
            }
        }
    }
}
