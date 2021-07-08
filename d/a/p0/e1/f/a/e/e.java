package d.a.p0.e1.f.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class e implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55396e;

    /* renamed from: f  reason: collision with root package name */
    public String f55397f;

    /* renamed from: g  reason: collision with root package name */
    public int f55398g;

    /* renamed from: h  reason: collision with root package name */
    public String f55399h;

    /* renamed from: i  reason: collision with root package name */
    public int f55400i;
    public b2 j;

    public e(@NonNull ThreadInfo threadInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadInfo, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55396e = i2 + 1;
        this.f55397f = threadInfo.title;
        this.f55398g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f55399h = threadInfo.media.get(0).src_pic;
            this.f55400i = threadInfo.media.get(0).during_time.intValue();
        }
        b2 b2Var = new b2();
        this.j = b2Var;
        b2Var.c2 = true;
        b2Var.I2(threadInfo);
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f55387b : (BdUniqueId) invokeV.objValue;
    }
}
