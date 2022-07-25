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
public class sp2 extends yv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public rp2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755312932, "Lcom/repackage/sp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755312932, "Lcom/repackage/sp2;");
                return;
            }
        }
        boolean z = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sp2() {
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
        this.B = new rp2();
        this.C = true;
    }

    public static sp2 h(JSONObject jSONObject, @NonNull sp2 sp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, sp2Var)) == null) {
            sp2 sp2Var2 = new sp2();
            if (jSONObject != null) {
                sp2Var2.e(jSONObject, sp2Var);
                sp2Var2.j = jSONObject.optString("videoId", sp2Var.j);
                sp2Var2.n = jSONObject.optBoolean("autoplay", sp2Var.n);
                sp2Var2.k = jSONObject.optBoolean("muted", sp2Var.k);
                sp2Var2.m = jSONObject.optString("initialTime", sp2Var.m);
                sp2Var2.l = jSONObject.optString(NativeConstants.POSTER, sp2Var.l);
                sp2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, sp2Var.p);
                sp2Var2.q = jSONObject.optBoolean("fullScreen", sp2Var.q);
                sp2Var2.o = jSONObject.optBoolean("loop", sp2Var.o);
                sp2Var2.r = jSONObject.optBoolean("controls", sp2Var.r);
                sp2Var2.s = i(jSONObject.optString("src", sp2Var.s));
                sp2Var2.A = !q73.E(jSONObject.optString("src", sp2Var.s));
                sp2Var2.u = jSONObject.optBoolean("showPlayBtn", sp2Var.u);
                sp2Var2.v = jSONObject.optBoolean("showMuteBtn", sp2Var.v);
                sp2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", sp2Var.w);
                sp2Var2.x = jSONObject.optBoolean("showProgress", sp2Var.x);
                sp2Var2.z = jSONObject.optBoolean("showFullscreenBtn", sp2Var.z);
                sp2Var2.t = jSONObject.optString("sanId", sp2Var.t);
                sp2Var2.B = sp2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                sp2Var2.C = jSONObject.optBoolean("showNoWifiTip", sp2Var.C);
            }
            return sp2Var2;
        }
        return (sp2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!q73.E(str) || i03.M() == null) ? str : q73.H(str, i03.M()) : (String) invokeL.objValue;
    }

    @Override // com.repackage.yv1, com.repackage.hq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.j) : invokeV.booleanValue;
    }

    @Override // com.repackage.yv1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
