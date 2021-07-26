package d.a.q0.e1.k.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes8.dex */
public class c extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f56315e;

    /* renamed from: f  reason: collision with root package name */
    public b2 f56316f;

    /* renamed from: g  reason: collision with root package name */
    public long f56317g;

    /* renamed from: h  reason: collision with root package name */
    public int f56318h;

    /* renamed from: i  reason: collision with root package name */
    public int f56319i;
    public boolean j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-169241202, "Ld/a/q0/e1/k/a/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-169241202, "Ld/a/q0/e1/k/a/c/c;");
                return;
            }
        }
        k = BdUniqueId.gen();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void c(TopicThread topicThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, topicThread) == null) || topicThread == null) {
            return;
        }
        this.f56315e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            b2 b2Var = new b2();
            this.f56316f = b2Var;
            b2Var.K2(topicThread.thread_info);
            this.f56316f.O2();
        }
        this.f56318h = topicThread.user_agree.intValue();
        this.f56319i = topicThread.source.intValue();
    }

    public void d(tbclient.NewTopicThread.TopicThread topicThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topicThread) == null) || topicThread == null) {
            return;
        }
        this.f56315e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            b2 b2Var = new b2();
            this.f56316f = b2Var;
            b2Var.K2(topicThread.thread_info);
            this.f56316f.O2();
        }
        this.f56318h = Integer.parseInt(topicThread.user_agree);
        this.f56319i = topicThread.source.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k : (BdUniqueId) invokeV.objValue;
    }
}
