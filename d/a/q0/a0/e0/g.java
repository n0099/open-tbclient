package d.a.q0.a0.e0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g implements d.a.q0.f1.b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f54347a;

    /* renamed from: b  reason: collision with root package name */
    public String f54348b;

    /* renamed from: c  reason: collision with root package name */
    public String f54349c;

    /* renamed from: d  reason: collision with root package name */
    public long f54350d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54351e;

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
            if (obj instanceof d.a.p0.d1.g.a) {
                d.a.p0.d1.g.a aVar = (d.a.p0.d1.g.a) obj;
                return aVar.f52310d == this.f54350d && aVar.f52309c.equals(this.f54349c) && aVar.f52308b.equals(this.f54348b) && aVar.f52311e == this.f54351e && aVar.f52307a == this.f54347a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f54347a + ",forumAvatar=" + this.f54348b + ",forumName=" + this.f54349c + ",forumId=" + this.f54350d + ",isLiked=" + this.f54351e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
