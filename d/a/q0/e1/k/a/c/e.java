package d.a.q0.e1.k.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f56325a;

    /* renamed from: b  reason: collision with root package name */
    public long f56326b;

    /* renamed from: c  reason: collision with root package name */
    public String f56327c;

    /* renamed from: d  reason: collision with root package name */
    public String f56328d;

    /* renamed from: e  reason: collision with root package name */
    public String f56329e;

    /* renamed from: f  reason: collision with root package name */
    public int f56330f;

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
        this.f56326b = timeLineInfo.tid.longValue();
        this.f56327c = timeLineInfo.title;
        this.f56328d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f56329e = timeLineInfo.bg_color;
    }
}
