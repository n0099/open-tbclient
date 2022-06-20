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
/* loaded from: classes5.dex */
public class cp2 extends iv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public bp2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755789588, "Lcom/repackage/cp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755789588, "Lcom/repackage/cp2;");
                return;
            }
        }
        boolean z = cg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp2() {
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
        this.B = new bp2();
        this.C = true;
    }

    public static cp2 h(JSONObject jSONObject, @NonNull cp2 cp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, cp2Var)) == null) {
            cp2 cp2Var2 = new cp2();
            if (jSONObject != null) {
                cp2Var2.e(jSONObject, cp2Var);
                cp2Var2.j = jSONObject.optString("videoId", cp2Var.j);
                cp2Var2.n = jSONObject.optBoolean("autoplay", cp2Var.n);
                cp2Var2.k = jSONObject.optBoolean("muted", cp2Var.k);
                cp2Var2.m = jSONObject.optString("initialTime", cp2Var.m);
                cp2Var2.l = jSONObject.optString(NativeConstants.POSTER, cp2Var.l);
                cp2Var2.p = jSONObject.optInt("position", cp2Var.p);
                cp2Var2.q = jSONObject.optBoolean("fullScreen", cp2Var.q);
                cp2Var2.o = jSONObject.optBoolean("loop", cp2Var.o);
                cp2Var2.r = jSONObject.optBoolean("controls", cp2Var.r);
                cp2Var2.s = i(jSONObject.optString("src", cp2Var.s));
                cp2Var2.A = !a73.E(jSONObject.optString("src", cp2Var.s));
                cp2Var2.u = jSONObject.optBoolean("showPlayBtn", cp2Var.u);
                cp2Var2.v = jSONObject.optBoolean("showMuteBtn", cp2Var.v);
                cp2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", cp2Var.w);
                cp2Var2.x = jSONObject.optBoolean("showProgress", cp2Var.x);
                cp2Var2.z = jSONObject.optBoolean("showFullscreenBtn", cp2Var.z);
                cp2Var2.t = jSONObject.optString("sanId", cp2Var.t);
                cp2Var2.B = cp2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                cp2Var2.C = jSONObject.optBoolean("showNoWifiTip", cp2Var.C);
            }
            return cp2Var2;
        }
        return (cp2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!a73.E(str) || sz2.M() == null) ? str : a73.H(str, sz2.M()) : (String) invokeL.objValue;
    }

    @Override // com.repackage.iv1, com.repackage.rp2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.repackage.iv1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
