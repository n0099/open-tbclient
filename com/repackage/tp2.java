package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
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
public class tp2 extends pw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean X;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public String K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public String T;
    public boolean U;
    public String V;
    public String W;
    public String j;
    public boolean k;
    public String l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public String q;
    public int r;
    public boolean s;
    public String t;
    public String u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;
    public String z;

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
        X = jh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp2() {
        super("video", "componentId");
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
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = "";
        this.r = 0;
        this.t = "";
        this.u = "";
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = "";
        this.z = "";
        this.D = false;
        this.E = true;
        this.F = -1;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = "";
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = true;
        this.S = false;
        this.T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static tp2 h(JSONObject jSONObject, @NonNull tp2 tp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, tp2Var)) == null) {
            tp2 tp2Var2 = new tp2();
            if (jSONObject != null) {
                tp2Var2.e(jSONObject, tp2Var);
                tp2Var2.j = jSONObject.optString("componentId", tp2Var.j);
                tp2Var2.o = jSONObject.optBoolean("autoplay", tp2Var.o);
                tp2Var2.k = jSONObject.optBoolean("muted", tp2Var.k);
                tp2Var2.q = jSONObject.optString("objectFit", tp2Var.q);
                tp2Var2.m = jSONObject.optInt("initialTime", tp2Var.m);
                tp2Var2.l = jSONObject.optString(NativeConstants.POSTER, tp2Var.l);
                tp2Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, tp2Var.r);
                tp2Var2.s = jSONObject.optBoolean("fullScreen", tp2Var.s);
                tp2Var2.t = p(jSONObject);
                tp2Var2.u = jSONObject.optString("danmuList", tp2Var.u);
                tp2Var2.v = jSONObject.optBoolean("enableDanmu", tp2Var.v);
                tp2Var2.w = jSONObject.optBoolean("danmuBtn", tp2Var.w);
                tp2Var2.p = jSONObject.optBoolean("loop", tp2Var.p);
                tp2Var2.x = jSONObject.optBoolean("controls", tp2Var.x);
                tp2Var2.y = q(jSONObject.optString("src", tp2Var.y));
                tp2Var2.I = !h83.E(jSONObject.optString("src", tp2Var.y));
                tp2Var2.A = jSONObject.optBoolean("showPlayBtn", tp2Var.A);
                tp2Var2.B = jSONObject.optBoolean("showMuteBtn", tp2Var.B);
                tp2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", tp2Var.C);
                tp2Var2.D = jSONObject.optBoolean("pageGesture", tp2Var.D);
                tp2Var2.E = jSONObject.optBoolean("showProgress", tp2Var.E);
                tp2Var2.F = jSONObject.optInt("direction", tp2Var.F);
                tp2Var2.G = jSONObject.optBoolean("showFullscreenBtn", tp2Var.G);
                tp2Var2.H = jSONObject.optBoolean("enableProgressGesture", tp2Var.H);
                tp2Var2.z = jSONObject.optString("componentId", tp2Var.z);
                tp2Var2.J = jSONObject.optBoolean("showNoWifiTip", tp2Var.J);
                tp2Var2.K = jSONObject.optString("title", tp2Var.K);
                tp2Var2.L = jSONObject.optBoolean("enablePlayGesture", tp2Var.L);
                tp2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", tp2Var.M);
                tp2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", tp2Var.N);
                tp2Var2.P = jSONObject.optBoolean("showRateBtn", tp2Var.P);
                tp2Var2.Q = jSONObject.optBoolean("isFullscreen", tp2Var.Q);
                tp2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", tp2Var.O);
                tp2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", tp2Var.R);
                tp2Var2.S = jSONObject.optBoolean("silentPlay", tp2Var.S);
                tp2Var2.T = jSONObject.optString("preload", tp2Var.T);
                tp2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", tp2Var.U);
                tp2Var2.V = jSONObject.optString("silentPlayTips", tp2Var.V);
                tp2Var2.W = jSONObject.optString("rate", tp2Var.W);
            }
            return tp2Var2;
        }
        return (tp2) invokeLL.objValue;
    }

    public static String p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("text", jSONObject.optString("text"));
                jSONObject2.putOpt("color", jSONObject.optString("color"));
                jSONObject2.putOpt("componentId", jSONObject.optString("componentId"));
            } catch (JSONException e) {
                if (X) {
                    e.printStackTrace();
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (!h83.E(str) || z03.M() == null) ? str : h83.H(str, z03.M()) : (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // com.repackage.pw1, com.repackage.yq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.equals("auto", this.T) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.f : invokeV.booleanValue;
    }

    @Override // com.repackage.pw1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
