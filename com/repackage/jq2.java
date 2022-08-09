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
/* loaded from: classes6.dex */
public class jq2 extends pw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public iq2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755580090, "Lcom/repackage/jq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755580090, "Lcom/repackage/jq2;");
                return;
            }
        }
        boolean z = jh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jq2() {
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
        this.B = new iq2();
        this.C = true;
    }

    public static jq2 h(JSONObject jSONObject, @NonNull jq2 jq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, jq2Var)) == null) {
            jq2 jq2Var2 = new jq2();
            if (jSONObject != null) {
                jq2Var2.e(jSONObject, jq2Var);
                jq2Var2.j = jSONObject.optString("videoId", jq2Var.j);
                jq2Var2.n = jSONObject.optBoolean("autoplay", jq2Var.n);
                jq2Var2.k = jSONObject.optBoolean("muted", jq2Var.k);
                jq2Var2.m = jSONObject.optString("initialTime", jq2Var.m);
                jq2Var2.l = jSONObject.optString(NativeConstants.POSTER, jq2Var.l);
                jq2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, jq2Var.p);
                jq2Var2.q = jSONObject.optBoolean("fullScreen", jq2Var.q);
                jq2Var2.o = jSONObject.optBoolean("loop", jq2Var.o);
                jq2Var2.r = jSONObject.optBoolean("controls", jq2Var.r);
                jq2Var2.s = i(jSONObject.optString("src", jq2Var.s));
                jq2Var2.A = !h83.E(jSONObject.optString("src", jq2Var.s));
                jq2Var2.u = jSONObject.optBoolean("showPlayBtn", jq2Var.u);
                jq2Var2.v = jSONObject.optBoolean("showMuteBtn", jq2Var.v);
                jq2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", jq2Var.w);
                jq2Var2.x = jSONObject.optBoolean("showProgress", jq2Var.x);
                jq2Var2.z = jSONObject.optBoolean("showFullscreenBtn", jq2Var.z);
                jq2Var2.t = jSONObject.optString("sanId", jq2Var.t);
                jq2Var2.B = jq2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                jq2Var2.C = jSONObject.optBoolean("showNoWifiTip", jq2Var.C);
            }
            return jq2Var2;
        }
        return (jq2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!h83.E(str) || z03.M() == null) ? str : h83.H(str, z03.M()) : (String) invokeL.objValue;
    }

    @Override // com.repackage.pw1, com.repackage.yq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.repackage.pw1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
