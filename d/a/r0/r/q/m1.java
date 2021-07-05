package d.a.r0.r.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecomPostTopic;
/* loaded from: classes9.dex */
public class m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f56013a;

    /* renamed from: b  reason: collision with root package name */
    public String f56014b;

    /* renamed from: c  reason: collision with root package name */
    public long f56015c;

    public m1() {
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

    public void a(RecomPostTopic recomPostTopic) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, recomPostTopic) == null) || recomPostTopic == null) {
            return;
        }
        this.f56013a = recomPostTopic.recom_title;
        this.f56014b = recomPostTopic.recom_topic;
        this.f56015c = recomPostTopic.uniq_topicid.longValue();
    }
}
