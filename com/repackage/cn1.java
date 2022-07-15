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
public class cn1 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755791541, "Lcom/repackage/cn1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755791541, "Lcom/repackage/cn1;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public cn1(String str, String str2, String str3, int i, int i2, int i3, boolean z) {
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

    public bp2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                bp2 bp2Var = new bp2();
                bp2Var.j = "SwanAdPlayer";
                bp2Var.b = "SwanAdPlayer";
                bp2Var.o = true;
                bp2Var.k = false;
                bp2Var.x = !this.g;
                bp2Var.I = false;
                bp2Var.l = this.a;
                bp2Var.y = this.b;
                bp2Var.c = this.c;
                nq2 nq2Var = new nq2(0, 0, this.d, this.e);
                bp2Var.h = nq2Var;
                nq2Var.i(true);
                bp2Var.m = this.f;
                if (this.g) {
                    bp2Var.q = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return bp2.h(jSONObject, bp2Var);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (bp2) invokeV.objValue;
    }
}
