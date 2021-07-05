package d.a.q0.a.y0.g.i;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f51757a;

    /* renamed from: b  reason: collision with root package name */
    public long f51758b;

    /* renamed from: c  reason: collision with root package name */
    public String f51759c;

    /* renamed from: d  reason: collision with root package name */
    public String f51760d;

    /* renamed from: e  reason: collision with root package name */
    public String f51761e;

    public b(String str, long j, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51757a = str;
        this.f51758b = j;
        this.f51759c = str2;
        this.f51760d = str3;
        this.f51761e = str4;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f51757a) || TextUtils.isEmpty(this.f51759c) || TextUtils.isEmpty(this.f51760d) || TextUtils.isEmpty(this.f51761e) || !d.a.q0.a.y0.g.g.a.a(this.f51758b)) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "roomName=" + this.f51757a + ";localUserId=" + this.f51758b + ";displayName=" + this.f51759c + ";rtcAppId=" + this.f51760d + ";token=" + this.f51761e;
        }
        return (String) invokeV.objValue;
    }
}
