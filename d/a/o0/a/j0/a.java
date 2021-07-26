package d.a.o0.a.j0;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public long B;
    public long C;
    public boolean D;
    public int E;
    public String F;

    /* renamed from: a  reason: collision with root package name */
    public String f46165a;

    /* renamed from: b  reason: collision with root package name */
    public String f46166b;

    /* renamed from: c  reason: collision with root package name */
    public String f46167c;

    /* renamed from: d  reason: collision with root package name */
    public int f46168d;

    /* renamed from: e  reason: collision with root package name */
    public String f46169e;

    /* renamed from: f  reason: collision with root package name */
    public String f46170f;

    /* renamed from: g  reason: collision with root package name */
    public String f46171g;

    /* renamed from: h  reason: collision with root package name */
    public String f46172h;

    /* renamed from: i  reason: collision with root package name */
    public String f46173i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public int s;
    public String t;
    public String u;
    public String v;
    public long w;
    public int x;
    public int y;
    public int z;

    public a() {
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
        this.B = PMSAppInfo.DEFAULT_SWAN_APP_PKG_MAX_AGE;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SwanAppDbInfo{appId='" + this.f46165a + "', appKey='" + this.f46166b + "', errorCode=" + this.f46168d + ", errorDetail='" + this.f46169e + "', errorMsg='" + this.f46170f + "', resumeDate='" + this.f46171g + "', maxSwanVersion='" + this.j + "', minSwanVersion='" + this.k + "', name='" + this.l + "', version='" + this.q + "', type=" + this.r + ", isHaveZip=" + this.s + ", targetSwanVersion='" + this.v + "', mAppZipSize=" + this.w + ", mPendingApsErrcode=" + this.x + ", category=" + this.y + ", versionCode='" + this.A + "', maxAge=" + this.B + ", createTime=" + this.C + ", forceFetchMetaInfoFlag=" + this.D + ", payProtected=" + this.E + '}';
        }
        return (String) invokeV.objValue;
    }
}
