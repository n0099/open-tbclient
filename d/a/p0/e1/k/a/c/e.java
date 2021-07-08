package d.a.p0.e1.k.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f55781a;

    /* renamed from: b  reason: collision with root package name */
    public long f55782b;

    /* renamed from: c  reason: collision with root package name */
    public String f55783c;

    /* renamed from: d  reason: collision with root package name */
    public String f55784d;

    /* renamed from: e  reason: collision with root package name */
    public String f55785e;

    /* renamed from: f  reason: collision with root package name */
    public int f55786f;

    public e() {
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

    public void a(TimeLineInfo timeLineInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, timeLineInfo) == null) || timeLineInfo == null) {
            return;
        }
        this.f55782b = timeLineInfo.tid.longValue();
        this.f55783c = timeLineInfo.title;
        this.f55784d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f55785e = timeLineInfo.bg_color;
    }
}
