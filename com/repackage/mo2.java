package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class mo2 extends iv1 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755492639, "Lcom/repackage/mo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755492639, "Lcom/repackage/mo2;");
                return;
            }
        }
        X = cg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mo2() {
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

    public static mo2 h(JSONObject jSONObject, @NonNull mo2 mo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, mo2Var)) == null) {
            mo2 mo2Var2 = new mo2();
            if (jSONObject != null) {
                mo2Var2.e(jSONObject, mo2Var);
                mo2Var2.j = jSONObject.optString("componentId", mo2Var.j);
                mo2Var2.o = jSONObject.optBoolean("autoplay", mo2Var.o);
                mo2Var2.k = jSONObject.optBoolean("muted", mo2Var.k);
                mo2Var2.q = jSONObject.optString("objectFit", mo2Var.q);
                mo2Var2.m = jSONObject.optInt("initialTime", mo2Var.m);
                mo2Var2.l = jSONObject.optString(NativeConstants.POSTER, mo2Var.l);
                mo2Var2.r = jSONObject.optInt("position", mo2Var.r);
                mo2Var2.s = jSONObject.optBoolean("fullScreen", mo2Var.s);
                mo2Var2.t = p(jSONObject);
                mo2Var2.u = jSONObject.optString("danmuList", mo2Var.u);
                mo2Var2.v = jSONObject.optBoolean("enableDanmu", mo2Var.v);
                mo2Var2.w = jSONObject.optBoolean("danmuBtn", mo2Var.w);
                mo2Var2.p = jSONObject.optBoolean("loop", mo2Var.p);
                mo2Var2.x = jSONObject.optBoolean("controls", mo2Var.x);
                mo2Var2.y = q(jSONObject.optString("src", mo2Var.y));
                mo2Var2.I = !a73.E(jSONObject.optString("src", mo2Var.y));
                mo2Var2.A = jSONObject.optBoolean("showPlayBtn", mo2Var.A);
                mo2Var2.B = jSONObject.optBoolean("showMuteBtn", mo2Var.B);
                mo2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", mo2Var.C);
                mo2Var2.D = jSONObject.optBoolean("pageGesture", mo2Var.D);
                mo2Var2.E = jSONObject.optBoolean("showProgress", mo2Var.E);
                mo2Var2.F = jSONObject.optInt("direction", mo2Var.F);
                mo2Var2.G = jSONObject.optBoolean("showFullscreenBtn", mo2Var.G);
                mo2Var2.H = jSONObject.optBoolean("enableProgressGesture", mo2Var.H);
                mo2Var2.z = jSONObject.optString("componentId", mo2Var.z);
                mo2Var2.J = jSONObject.optBoolean("showNoWifiTip", mo2Var.J);
                mo2Var2.K = jSONObject.optString("title", mo2Var.K);
                mo2Var2.L = jSONObject.optBoolean("enablePlayGesture", mo2Var.L);
                mo2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", mo2Var.M);
                mo2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", mo2Var.N);
                mo2Var2.P = jSONObject.optBoolean("showRateBtn", mo2Var.P);
                mo2Var2.Q = jSONObject.optBoolean("isFullscreen", mo2Var.Q);
                mo2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", mo2Var.O);
                mo2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", mo2Var.R);
                mo2Var2.S = jSONObject.optBoolean("silentPlay", mo2Var.S);
                mo2Var2.T = jSONObject.optString("preload", mo2Var.T);
                mo2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", mo2Var.U);
                mo2Var2.V = jSONObject.optString("silentPlayTips", mo2Var.V);
                mo2Var2.W = jSONObject.optString("rate", mo2Var.W);
            }
            return mo2Var2;
        }
        return (mo2) invokeLL.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (!a73.E(str) || sz2.M() == null) ? str : a73.H(str, sz2.M()) : (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // com.repackage.iv1, com.repackage.rp2
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

    @Override // com.repackage.iv1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
