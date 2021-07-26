package d.a.o0.f.i.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49827a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49828b;

    /* renamed from: c  reason: collision with root package name */
    public String f49829c;

    /* renamed from: d  reason: collision with root package name */
    public int f49830d;

    /* renamed from: e  reason: collision with root package name */
    public int f49831e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49832f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49833g;

    /* renamed from: h  reason: collision with root package name */
    public String f49834h;

    /* renamed from: i  reason: collision with root package name */
    public int f49835i;
    public boolean j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49827a = "";
        this.f49828b = false;
        this.f49829c = "";
        this.f49830d = 0;
        this.f49831e = 0;
        this.f49832f = false;
        this.f49833g = false;
        this.f49834h = "";
        this.f49835i = 0;
        this.k = "";
        this.l = "";
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = "";
        this.q = "";
        this.u = false;
        this.v = true;
        this.w = -1;
        this.x = true;
        this.y = true;
        this.z = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.f49827a + "', mMute=" + this.f49828b + ", mPoster='" + this.f49829c + "', mInitialTime=" + this.f49830d + ", duration=" + this.f49831e + ", mAutoPlay=" + this.f49832f + ", mLoop=" + this.f49833g + ", mObjectFit='" + this.f49834h + "', mPos=" + this.f49835i + ", mFullScreen=" + this.j + ", mDanmu='" + this.k + "', mDanmuList='" + this.l + "', mEnableDanmu=" + this.m + ", mShowDanmuBtn=" + this.n + ", mShowControlPanel=" + this.o + ", mSrc='" + this.p + "', mSanId='" + this.q + "', mShowPlayBtn=" + this.r + ", mShowMuteBtn=" + this.s + ", mShowCenterPlayBtn=" + this.t + ", mPageGesture=" + this.u + ", mShowProgress=" + this.v + ", mDirection=" + this.w + ", mShowFullscreenBtn=" + this.x + ", mEnableProgressGesture=" + this.y + ", mIsRemoteFile=" + this.z + '}';
        }
        return (String) invokeV.objValue;
    }
}
