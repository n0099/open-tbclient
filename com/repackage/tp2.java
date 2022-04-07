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
public class tp2 extends zv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public sp2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755283141, "Lcom/repackage/tp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755283141, "Lcom/repackage/tp2;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp2() {
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
        this.B = new sp2();
        this.C = true;
    }

    public static tp2 h(JSONObject jSONObject, @NonNull tp2 tp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, tp2Var)) == null) {
            tp2 tp2Var2 = new tp2();
            if (jSONObject != null) {
                tp2Var2.e(jSONObject, tp2Var);
                tp2Var2.j = jSONObject.optString("videoId", tp2Var.j);
                tp2Var2.n = jSONObject.optBoolean("autoplay", tp2Var.n);
                tp2Var2.k = jSONObject.optBoolean("muted", tp2Var.k);
                tp2Var2.m = jSONObject.optString("initialTime", tp2Var.m);
                tp2Var2.l = jSONObject.optString(NativeConstants.POSTER, tp2Var.l);
                tp2Var2.p = jSONObject.optInt("position", tp2Var.p);
                tp2Var2.q = jSONObject.optBoolean("fullScreen", tp2Var.q);
                tp2Var2.o = jSONObject.optBoolean("loop", tp2Var.o);
                tp2Var2.r = jSONObject.optBoolean("controls", tp2Var.r);
                tp2Var2.s = i(jSONObject.optString("src", tp2Var.s));
                tp2Var2.A = !r73.E(jSONObject.optString("src", tp2Var.s));
                tp2Var2.u = jSONObject.optBoolean("showPlayBtn", tp2Var.u);
                tp2Var2.v = jSONObject.optBoolean("showMuteBtn", tp2Var.v);
                tp2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", tp2Var.w);
                tp2Var2.x = jSONObject.optBoolean("showProgress", tp2Var.x);
                tp2Var2.z = jSONObject.optBoolean("showFullscreenBtn", tp2Var.z);
                tp2Var2.t = jSONObject.optString("sanId", tp2Var.t);
                tp2Var2.B = tp2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                tp2Var2.C = jSONObject.optBoolean("showNoWifiTip", tp2Var.C);
            }
            return tp2Var2;
        }
        return (tp2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!r73.E(str) || j03.L() == null) ? str : r73.H(str, j03.L()) : (String) invokeL.objValue;
    }

    @Override // com.repackage.zv1, com.repackage.iq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.repackage.zv1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
