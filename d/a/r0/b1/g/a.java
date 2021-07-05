package d.a.r0.b1.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f54939a;

    /* renamed from: b  reason: collision with root package name */
    public String f54940b;

    /* renamed from: c  reason: collision with root package name */
    public String f54941c;

    /* renamed from: d  reason: collision with root package name */
    public long f54942d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54943e;

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
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.f54942d == this.f54942d && aVar.f54941c.equals(this.f54941c) && aVar.f54940b.equals(this.f54940b) && aVar.f54943e == this.f54943e && aVar.f54939a == this.f54939a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f54939a + ",forumAvatar=" + this.f54940b + ",forumName=" + this.f54941c + ",forumId=" + this.f54942d + ",isLiked=" + this.f54943e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
