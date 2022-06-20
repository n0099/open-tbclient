package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public int o;
    public String p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public String u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755315815, "Lcom/repackage/sm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755315815, "Lcom/repackage/sm2;");
                return;
            }
        }
        v = cg1.a;
    }

    public sm2() {
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
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = false;
        this.j = "";
        this.k = 0;
        this.l = 0;
        this.m = "";
        this.q = false;
    }

    public static sm2 b(JSONObject jSONObject, sm2 sm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, sm2Var)) == null) {
            sm2 sm2Var2 = new sm2();
            if (jSONObject != null) {
                sm2Var2.a = jSONObject.optString("audioId", sm2Var.a);
                sm2Var2.b = jSONObject.optString("slaveId", sm2Var.b);
                sm2Var2.c = jSONObject.optString("src", sm2Var.c);
                sm2Var2.q = sz2.M() != null && a73.E(sm2Var2.c);
                sm2Var2.d = jSONObject.optString("title", sm2Var.d);
                sm2Var2.e = jSONObject.optString("epname", sm2Var.e);
                sm2Var2.f = jSONObject.optString("singer", sm2Var.f);
                sm2Var2.g = jSONObject.optString("coverImgUrl", sm2Var.g);
                sm2Var2.h = jSONObject.optString("lrcURL", sm2Var.h);
                sm2Var2.i = jSONObject.optBoolean("showFloatView", sm2Var.i);
                sm2Var2.j = jSONObject.optString("floatPosition", sm2Var.j);
                sm2Var2.k = jSONObject.optInt(FetchLog.START_TIME, sm2Var.k);
                sm2Var2.l = jSONObject.optInt("position", sm2Var.l);
                sm2Var2.p = jSONObject.optString("cb", sm2Var.p);
                sm2Var2.m = jSONObject.optString("param", sm2Var.m);
                sm2Var2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = m62.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    sm2Var2.s = g0;
                }
                String b = zc3.b();
                if (!TextUtils.isEmpty(b) && zc3.c(sm2Var2.c)) {
                    sm2Var2.t = b;
                }
                String j = o83.l().j(sm2Var2.c);
                if (!TextUtils.isEmpty(j)) {
                    sm2Var2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return sm2Var2;
        }
        return (sm2) invokeLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("src", str);
                jSONObject.putOpt("title", this.d);
                jSONObject.putOpt("epname", this.e);
                jSONObject.putOpt("singer", this.f);
                jSONObject.putOpt("coverImgUrl", this.g);
                jSONObject.putOpt("lrcURL", this.h);
                jSONObject.putOpt("isLocal", Boolean.valueOf(this.q));
                jSONObject.putOpt("appid", sz2.g0());
                jSONObject.putOpt("user-agent", this.s);
                jSONObject.putOpt(TiebaStatic.Params.REFER, this.t);
                jSONObject.putOpt("Cookie", this.u);
            } catch (JSONException e) {
                if (v) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "AudioBGPlayerParams{ playerId=" + this.a + " slaveId=" + this.b + " url=" + this.c + " startTime=" + this.k + " pos=" + this.l + " canPlay=" + this.r + " }";
        }
        return (String) invokeV.objValue;
    }
}
