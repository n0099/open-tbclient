package d.a.p0.a0.e0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g implements d.a.p0.f1.b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53804a;

    /* renamed from: b  reason: collision with root package name */
    public String f53805b;

    /* renamed from: c  reason: collision with root package name */
    public String f53806c;

    /* renamed from: d  reason: collision with root package name */
    public long f53807d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53808e;

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
            if (obj instanceof d.a.o0.b1.g.a) {
                d.a.o0.b1.g.a aVar = (d.a.o0.b1.g.a) obj;
                return aVar.f51647d == this.f53807d && aVar.f51646c.equals(this.f53806c) && aVar.f51645b.equals(this.f53805b) && aVar.f51648e == this.f53808e && aVar.f51644a == this.f53804a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "[HotForumInfoData:rank=" + this.f53804a + ",forumAvatar=" + this.f53805b + ",forumName=" + this.f53806c + ",forumId=" + this.f53807d + ",isLiked=" + this.f53808e + "," + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
