package d.a.o0.a.i1.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.o0.a.c0.b.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean N;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public String C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public String n;
    public boolean o;
    public String p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public String y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1363384656, "Ld/a/o0/a/i1/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1363384656, "Ld/a/o0/a/i1/g/c;");
                return;
            }
        }
        N = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("video", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = "";
        this.o = false;
        this.p = "";
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = "";
        this.v = 0;
        this.x = "";
        this.y = "";
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = "";
        this.D = "";
        this.H = false;
        this.I = true;
        this.J = -1;
        this.K = true;
        this.L = true;
        this.M = true;
    }

    public static c j(JSONObject jSONObject, @NonNull c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, cVar)) == null) {
            c cVar2 = new c();
            if (jSONObject != null) {
                cVar2.g(jSONObject, cVar);
                cVar2.n = jSONObject.optString("videoId", cVar.n);
                cVar2.s = jSONObject.optBoolean("autoplay", cVar.s);
                cVar2.o = jSONObject.optBoolean("muted", cVar.o);
                cVar2.u = jSONObject.optString("objectFit", cVar.u);
                cVar2.q = jSONObject.optInt("initialTime", cVar.q);
                cVar2.p = jSONObject.optString("poster", cVar.p);
                cVar2.v = jSONObject.optInt("position", cVar.v);
                cVar2.w = jSONObject.optBoolean("fullScreen", cVar.w);
                cVar2.x = m(jSONObject);
                cVar2.y = jSONObject.optString("danmuList", cVar.y);
                cVar2.z = jSONObject.optBoolean("enableDanmu", cVar.z);
                cVar2.A = jSONObject.optBoolean("danmuBtn", cVar.A);
                cVar2.t = jSONObject.optBoolean("loop", cVar.t);
                cVar2.B = jSONObject.optBoolean("controls", cVar.B);
                cVar2.C = n(jSONObject.optString("src", cVar.C));
                cVar2.M = !d.a.o0.a.k2.b.E(jSONObject.optString("src", cVar.C));
                cVar2.E = jSONObject.optBoolean("showPlayBtn", cVar.E);
                cVar2.F = jSONObject.optBoolean("showMuteBtn", cVar.F);
                cVar2.G = jSONObject.optBoolean("showCenterPlayBtn", cVar.G);
                cVar2.H = jSONObject.optBoolean("pageGesture", cVar.H);
                cVar2.I = jSONObject.optBoolean("showProgress", cVar.I);
                cVar2.J = jSONObject.optInt("direction", cVar.J);
                cVar2.K = jSONObject.optBoolean("showFullscreenBtn", cVar.K);
                cVar2.L = jSONObject.optBoolean("enableProgressGesture", cVar.L);
                cVar2.D = jSONObject.optString("sanId", cVar.D);
            }
            return cVar2;
        }
        return (c) invokeLL.objValue;
    }

    public static String m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("text", jSONObject.optString("text"));
                jSONObject2.putOpt("color", jSONObject.optString("color"));
                jSONObject2.putOpt("videoId", jSONObject.optString("videoId"));
            } catch (JSONException e2) {
                if (N) {
                    e2.printStackTrace();
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (!d.a.o0.a.k2.b.E(str) || e.i() == null) ? str : d.a.o0.a.k2.b.H(str, e.i()) : (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.c0.b.b, d.a.o0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.n) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.j : invokeV.booleanValue;
    }

    @Override // d.a.o0.a.c0.b.b
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.n + "', mMute=" + this.o + ", mPoster='" + this.p + "', mInitialTime=" + this.q + ", duration=" + this.r + ", mAutoPlay=" + this.s + ", mLoop=" + this.t + ", mObjectFit='" + this.u + "', mPos=" + this.v + ", mFullScreen=" + this.w + ", mDanmu='" + this.x + "', mDanmuList='" + this.y + "', mEnableDanmu=" + this.z + ", mShowDanmuBtn=" + this.A + ", mShowControlPanel=" + this.B + ", mSrc='" + this.C + "', mSanId='" + this.D + "', mShowPlayBtn=" + this.E + ", mShowMuteBtn=" + this.F + ", mShowCenterPlayBtn=" + this.G + ", mPageGesture=" + this.H + ", mShowProgress=" + this.I + ", mDirection=" + this.J + ", mShowFullscreenBtn=" + this.K + ", mEnableProgressGesture=" + this.L + ", mIsRemoteFile=" + this.M + '}';
        }
        return (String) invokeV.objValue;
    }
}
