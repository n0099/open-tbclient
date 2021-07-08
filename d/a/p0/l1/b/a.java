package d.a.p0.l1.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f59963a;

    /* renamed from: b  reason: collision with root package name */
    public String f59964b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59965c;

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

    public void a(ResponseTagInfo responseTagInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, responseTagInfo) == null) || responseTagInfo == null) {
            return;
        }
        this.f59963a = responseTagInfo.tag_id.intValue();
        this.f59964b = responseTagInfo.tag_name;
        this.f59965c = responseTagInfo.is_followed.intValue() == 1;
    }
}
