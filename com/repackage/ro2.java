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
/* loaded from: classes7.dex */
public class ro2 extends xu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public qo2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755343684, "Lcom/repackage/ro2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755343684, "Lcom/repackage/ro2;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ro2() {
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
        this.B = new qo2();
        this.C = true;
    }

    public static ro2 h(JSONObject jSONObject, @NonNull ro2 ro2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, ro2Var)) == null) {
            ro2 ro2Var2 = new ro2();
            if (jSONObject != null) {
                ro2Var2.e(jSONObject, ro2Var);
                ro2Var2.j = jSONObject.optString("videoId", ro2Var.j);
                ro2Var2.n = jSONObject.optBoolean("autoplay", ro2Var.n);
                ro2Var2.k = jSONObject.optBoolean("muted", ro2Var.k);
                ro2Var2.m = jSONObject.optString("initialTime", ro2Var.m);
                ro2Var2.l = jSONObject.optString(NativeConstants.POSTER, ro2Var.l);
                ro2Var2.p = jSONObject.optInt("position", ro2Var.p);
                ro2Var2.q = jSONObject.optBoolean("fullScreen", ro2Var.q);
                ro2Var2.o = jSONObject.optBoolean("loop", ro2Var.o);
                ro2Var2.r = jSONObject.optBoolean("controls", ro2Var.r);
                ro2Var2.s = i(jSONObject.optString("src", ro2Var.s));
                ro2Var2.A = !p63.E(jSONObject.optString("src", ro2Var.s));
                ro2Var2.u = jSONObject.optBoolean("showPlayBtn", ro2Var.u);
                ro2Var2.v = jSONObject.optBoolean("showMuteBtn", ro2Var.v);
                ro2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", ro2Var.w);
                ro2Var2.x = jSONObject.optBoolean("showProgress", ro2Var.x);
                ro2Var2.z = jSONObject.optBoolean("showFullscreenBtn", ro2Var.z);
                ro2Var2.t = jSONObject.optString("sanId", ro2Var.t);
                ro2Var2.B = ro2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                ro2Var2.C = jSONObject.optBoolean("showNoWifiTip", ro2Var.C);
            }
            return ro2Var2;
        }
        return (ro2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!p63.E(str) || hz2.L() == null) ? str : p63.H(str, hz2.L()) : (String) invokeL.objValue;
    }

    @Override // com.repackage.xu1, com.repackage.gp2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.repackage.xu1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
