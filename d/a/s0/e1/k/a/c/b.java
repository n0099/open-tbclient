package d.a.s0.e1.k.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f59020a;

    /* renamed from: b  reason: collision with root package name */
    public String f59021b;

    /* renamed from: c  reason: collision with root package name */
    public String f59022c;

    /* renamed from: d  reason: collision with root package name */
    public String f59023d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.e1.k.b.c.b f59024e;

    /* renamed from: f  reason: collision with root package name */
    public f f59025f;

    public b() {
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

    public void a(TopicDetail topicDetail) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, topicDetail) == null) || topicDetail == null) {
            return;
        }
        this.f59020a = topicDetail.topic_id.longValue();
        this.f59021b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f59022c = topicDetail.topic_image;
        this.f59023d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.a.s0.e1.k.b.c.b bVar = new d.a.s0.e1.k.b.c.b();
        this.f59024e = bVar;
        bVar.f59064a = this.f59020a;
        bVar.f59069f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, timeLine) == null) || timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f59025f = fVar;
        fVar.a(this.f59020a, timeLine);
    }
}
