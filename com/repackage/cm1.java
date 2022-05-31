package com.repackage;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755792502, "Lcom/repackage/cm1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755792502, "Lcom/repackage/cm1;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public cm1(String str, String str2, String str3, int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = z;
    }

    public bo2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                bo2 bo2Var = new bo2();
                bo2Var.j = "SwanAdPlayer";
                bo2Var.b = "SwanAdPlayer";
                bo2Var.o = true;
                bo2Var.k = false;
                bo2Var.x = !this.g;
                bo2Var.I = false;
                bo2Var.l = this.a;
                bo2Var.y = this.b;
                bo2Var.c = this.c;
                np2 np2Var = new np2(0, 0, this.d, this.e);
                bo2Var.h = np2Var;
                np2Var.i(true);
                bo2Var.m = this.f;
                if (this.g) {
                    bo2Var.q = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return bo2.h(jSONObject, bo2Var);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (bo2) invokeV.objValue;
    }
}
