package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rp2 extends xv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public qp2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755342723, "Lcom/repackage/rp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755342723, "Lcom/repackage/rp2;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rp2() {
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
        this.B = new qp2();
        this.C = true;
    }

    public static rp2 h(JSONObject jSONObject, @NonNull rp2 rp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, rp2Var)) == null) {
            rp2 rp2Var2 = new rp2();
            if (jSONObject != null) {
                rp2Var2.e(jSONObject, rp2Var);
                rp2Var2.j = jSONObject.optString("videoId", rp2Var.j);
                rp2Var2.n = jSONObject.optBoolean("autoplay", rp2Var.n);
                rp2Var2.k = jSONObject.optBoolean("muted", rp2Var.k);
                rp2Var2.m = jSONObject.optString("initialTime", rp2Var.m);
                rp2Var2.l = jSONObject.optString(NativeConstants.POSTER, rp2Var.l);
                rp2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, rp2Var.p);
                rp2Var2.q = jSONObject.optBoolean("fullScreen", rp2Var.q);
                rp2Var2.o = jSONObject.optBoolean("loop", rp2Var.o);
                rp2Var2.r = jSONObject.optBoolean("controls", rp2Var.r);
                rp2Var2.s = i(jSONObject.optString("src", rp2Var.s));
                rp2Var2.A = !p73.E(jSONObject.optString("src", rp2Var.s));
                rp2Var2.u = jSONObject.optBoolean("showPlayBtn", rp2Var.u);
                rp2Var2.v = jSONObject.optBoolean("showMuteBtn", rp2Var.v);
                rp2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", rp2Var.w);
                rp2Var2.x = jSONObject.optBoolean("showProgress", rp2Var.x);
                rp2Var2.z = jSONObject.optBoolean("showFullscreenBtn", rp2Var.z);
                rp2Var2.t = jSONObject.optString("sanId", rp2Var.t);
                rp2Var2.B = rp2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                rp2Var2.C = jSONObject.optBoolean("showNoWifiTip", rp2Var.C);
            }
            return rp2Var2;
        }
        return (rp2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!p73.E(str) || h03.M() == null) ? str : p73.H(str, h03.M()) : (String) invokeL.objValue;
    }

    @Override // com.repackage.xv1, com.repackage.gq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.repackage.xv1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
