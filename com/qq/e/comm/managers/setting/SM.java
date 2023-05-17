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
/* loaded from: classes9.dex */
public class SM {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public String b;
    public a c;
    public a d;
    public String e;
    public e f;
    public e g;
    public String h;
    public d i;
    public final d j;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = "";
        this.m = context;
        this.a = new a();
        this.d = new a();
        this.g = new c();
        this.i = new d();
        this.j = new d();
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
            this.c = a.a();
            this.b = a.b();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            f.b<d> b = f.b(this.m);
            if (b == null) {
                GDTLogger.d("Load Local DEV Cloud setting fail");
                return;
            }
            this.i = b.a();
            this.h = b.b();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            f.b<e> c = f.c(this.m);
            if (c == null) {
                GDTLogger.d("Load Local SDK Cloud setting fail");
                return;
            }
            this.e = c.b();
            this.f = c.a();
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

    public String getDevCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Deprecated
    public int getInteger(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            Object obj = get(str);
            return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
        }
        return invokeLI.intValue;
    }

    public int getIntegerForPlacement(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, str, str2, i)) == null) {
            Object forPlacement = getForPlacement(str, str2);
            return (forPlacement == null || !(forPlacement instanceof Integer)) ? i : ((Integer) forPlacement).intValue();
        }
        return invokeLLI.intValue;
    }

    public String getPlacementCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public String getSdkCloudSettingSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String getSettingDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (String) invokeV.objValue;
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
                if (this.a != null && (opt4 = this.a.a.opt(str)) != null) {
                    return opt4;
                }
                if (this.c != null && (opt3 = this.c.a.opt(str)) != null) {
                    return opt3;
                }
                if (this.d != null && (opt2 = this.d.a.opt(str)) != null) {
                    return opt2;
                }
                if (this.f != null && (opt = this.f.a.opt(str)) != null) {
                    return opt;
                }
                if (this.g == null) {
                    return null;
                }
                return this.g.a.opt(str);
            } catch (Throwable unused) {
                GDTLogger.d("Exception in settingManager.get Setting for key");
                return null;
            }
        }
        return invokeL.objValue;
    }

    public Set<String> getSettingKeySet(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.j);
            arrayList2.add(this.i);
            arrayList2.add(this.a);
            arrayList2.add(this.c);
            arrayList2.add(this.d);
            arrayList2.add(this.f);
            arrayList2.add(this.g);
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

    public Object getDisplaySetting(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.j.a.opt(str);
        }
        return invokeL.objValue;
    }

    public Object getForPlacement(String str, String str2) {
        InterceptResult invokeLL;
        Object obj;
        Object a;
        Object a2;
        Object a3;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (StringUtil.isEmpty(str)) {
                return null;
            }
            if (StringUtil.isEmpty(str2)) {
                return get(str);
            }
            try {
                JSONObject optJSONObject = this.j.a.optJSONObject(str2);
                if (optJSONObject != null) {
                    obj = optJSONObject.opt(str);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return obj;
                }
                if (this.i != null) {
                    JSONObject optJSONObject2 = this.i.a.optJSONObject(str2);
                    if (optJSONObject2 != null) {
                        obj2 = optJSONObject2.opt(str);
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        return obj2;
                    }
                }
                if (this.a != null && (a3 = this.a.a(str, str2)) != null) {
                    return a3;
                }
                if (this.c != null && (a2 = this.c.a(str, str2)) != null) {
                    return a2;
                }
                if (this.d != null && (a = this.d.a(str, str2)) != null) {
                    return a;
                }
                return get(str);
            } catch (Throwable unused) {
                GDTLogger.d("Exception in settingManager.getForPlacement");
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public void updatePlacementSetting(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
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
                this.i = new d();
                this.h = null;
            } else if (f.b(this.m, str, str2)) {
                b();
            }
        }
    }

    public void setDEVCodeSetting(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, obj) == null) {
            a aVar = this.d;
            if (aVar != null) {
                try {
                    aVar.a.putOpt(str, obj);
                    return;
                } catch (JSONException unused) {
                    GDTLogger.d("Exception while update setting");
                    return;
                }
            }
            throw null;
        }
    }

    public void updateDisplaySetting(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, obj) == null) {
            d dVar = this.j;
            if (dVar != null) {
                try {
                    dVar.a.putOpt(str, obj);
                    return;
                } catch (JSONException e) {
                    GDTLogger.d(e.getMessage());
                    return;
                }
            }
            throw null;
        }
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, str, obj, str2) == null) {
            a aVar = this.d;
            if (aVar != null) {
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
                        return;
                    } else {
                        optJSONObject2.putOpt(str, obj);
                        return;
                    }
                } catch (JSONException unused) {
                    GDTLogger.d("Exception while update setting");
                    return;
                }
            }
            throw null;
        }
    }
}
