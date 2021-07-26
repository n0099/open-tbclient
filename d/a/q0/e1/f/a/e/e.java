package d.a.q0.e1.f.a.e;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class e implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55940e;

    /* renamed from: f  reason: collision with root package name */
    public String f55941f;

    /* renamed from: g  reason: collision with root package name */
    public int f55942g;

    /* renamed from: h  reason: collision with root package name */
    public String f55943h;

    /* renamed from: i  reason: collision with root package name */
    public int f55944i;
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
        this.f55940e = i2 + 1;
        this.f55941f = threadInfo.title;
        this.f55942g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f55943h = threadInfo.media.get(0).src_pic;
            this.f55944i = threadInfo.media.get(0).during_time.intValue();
        }
        b2 b2Var = new b2();
        this.j = b2Var;
        b2Var.c2 = true;
        b2Var.K2(threadInfo);
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f55931b : (BdUniqueId) invokeV.objValue;
    }
}
