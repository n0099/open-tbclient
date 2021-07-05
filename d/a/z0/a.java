package d.a.z0;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f71594a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71595b;

    /* renamed from: c  reason: collision with root package name */
    public String f71596c;

    /* renamed from: d  reason: collision with root package name */
    public String f71597d;

    /* renamed from: e  reason: collision with root package name */
    public String f71598e;

    /* renamed from: f  reason: collision with root package name */
    public int f71599f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71594a = z;
        this.f71595b = z2;
        this.f71596c = str;
        this.f71597d = str2;
        this.f71598e = str3;
        this.f71599f = i2;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f71596c)) {
                return this.f71596c;
            }
            return new d.a.z0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f71596c.getBytes());
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "UnionIDInfo{isTrackLimited=" + this.f71594a + ", isSupport=" + this.f71595b + ", OAID='" + this.f71596c + "', EncodedOAID='" + a() + "', AAID='" + this.f71597d + "', VAID='" + this.f71598e + "', StatusCode='" + this.f71599f + "'}";
        }
        return (String) invokeV.objValue;
    }
}
