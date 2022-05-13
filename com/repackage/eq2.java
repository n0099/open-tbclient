package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class eq2 extends kw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public dq2 B;
    public boolean C;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755729045, "Lcom/repackage/eq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755729045, "Lcom/repackage/eq2;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eq2() {
        super("vrvideo", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = "";
        this.k = false;
        this.l = "";
        this.m = "0";
        this.n = false;
        this.o = false;
        this.p = 0;
        this.r = true;
        this.s = "";
        this.t = "";
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.z = true;
        this.A = true;
        this.B = new dq2();
        this.C = true;
    }

    public static eq2 h(JSONObject jSONObject, @NonNull eq2 eq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, eq2Var)) == null) {
            eq2 eq2Var2 = new eq2();
            if (jSONObject != null) {
                eq2Var2.e(jSONObject, eq2Var);
                eq2Var2.j = jSONObject.optString("videoId", eq2Var.j);
                eq2Var2.n = jSONObject.optBoolean("autoplay", eq2Var.n);
                eq2Var2.k = jSONObject.optBoolean("muted", eq2Var.k);
                eq2Var2.m = jSONObject.optString("initialTime", eq2Var.m);
                eq2Var2.l = jSONObject.optString(NativeConstants.POSTER, eq2Var.l);
                eq2Var2.p = jSONObject.optInt("position", eq2Var.p);
                eq2Var2.q = jSONObject.optBoolean("fullScreen", eq2Var.q);
                eq2Var2.o = jSONObject.optBoolean("loop", eq2Var.o);
                eq2Var2.r = jSONObject.optBoolean("controls", eq2Var.r);
                eq2Var2.s = i(jSONObject.optString("src", eq2Var.s));
                eq2Var2.A = !c83.E(jSONObject.optString("src", eq2Var.s));
                eq2Var2.u = jSONObject.optBoolean("showPlayBtn", eq2Var.u);
                eq2Var2.v = jSONObject.optBoolean("showMuteBtn", eq2Var.v);
                eq2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", eq2Var.w);
                eq2Var2.x = jSONObject.optBoolean("showProgress", eq2Var.x);
                eq2Var2.z = jSONObject.optBoolean("showFullscreenBtn", eq2Var.z);
                eq2Var2.t = jSONObject.optString("sanId", eq2Var.t);
                eq2Var2.B = eq2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                eq2Var2.C = jSONObject.optBoolean("showNoWifiTip", eq2Var.C);
            }
            return eq2Var2;
        }
        return (eq2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!c83.E(str) || u03.L() == null) ? str : c83.H(str, u03.L()) : (String) invokeL.objValue;
    }

    @Override // com.repackage.kw1, com.repackage.tq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.repackage.kw1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
