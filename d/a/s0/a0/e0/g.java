package d.a.s0.a0.e0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g implements d.a.s0.f1.b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f57059a;

    /* renamed from: b  reason: collision with root package name */
    public String f57060b;

    /* renamed from: c  reason: collision with root package name */
    public String f57061c;

    /* renamed from: d  reason: collision with root package name */
    public long f57062d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57063e;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d.a.r0.b1.g.a) {
                d.a.r0.b1.g.a aVar = (d.a.r0.b1.g.a) obj;
                return aVar.f54942d == this.f57062d && aVar.f54941c.equals(this.f57061c) && aVar.f54940b.equals(this.f57060b) && aVar.f54943e == this.f57063e && aVar.f54939a == this.f57059a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f57059a + ",forumAvatar=" + this.f57060b + ",forumName=" + this.f57061c + ",forumId=" + this.f57062d + ",isLiked=" + this.f57063e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
