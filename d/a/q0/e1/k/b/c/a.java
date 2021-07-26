package d.a.q0.e1.k.b.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.PkModule;
import tbclient.TopicModule;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a0.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j0;
    public static final BdUniqueId k0;
    public transient /* synthetic */ FieldHolder $fh;
    public int U;
    public long V;
    public String W;
    public String X;
    public long Y;
    public String Z;
    public b a0;
    public PostData b0;
    public int c0;
    public b2 i0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-140612113, "Ld/a/q0/e1/k/b/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-140612113, "Ld/a/q0/e1/k/b/c/a;");
                return;
            }
        }
        j0 = BdUniqueId.gen();
        k0 = BdUniqueId.gen();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c0 = 0;
    }

    public static boolean N(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b2Var)) == null) ? b2Var != null && b2Var.getType() == b2.i3 : invokeL.booleanValue;
    }

    public void O(NewTopicList newTopicList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, newTopicList) == null) || newTopicList == null) {
            return;
        }
        this.V = newTopicList.topic_id.longValue();
        this.W = newTopicList.topic_name;
        this.X = newTopicList.topic_desc;
        this.Y = newTopicList.discuss_num.longValue();
        this.Z = newTopicList.topic_image;
        PkModule pkModule = newTopicList.pk_module;
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            b bVar = new b();
            this.a0 = bVar;
            bVar.f56353a = this.V;
            bVar.f56358f = 1;
            bVar.b(newTopicList.pk_module);
        }
        if (newTopicList.top_agree_post != null) {
            PostData postData = new PostData();
            this.b0 = postData;
            postData.b0(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
        }
    }

    public void P(TopicModule topicModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topicModule) == null) || topicModule == null) {
            return;
        }
        this.V = topicModule.topic_id.longValue();
        this.W = topicModule.topic_name;
        this.X = topicModule.topic_desc;
        this.Z = topicModule.topic_image;
        tbclient.PkModule pkModule = topicModule.pk_module;
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        b bVar = new b();
        this.a0 = bVar;
        bVar.f56353a = this.V;
        bVar.f56358f = 3;
        bVar.c(topicModule.pk_module);
    }

    public void Q(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            this.i0 = b2Var;
        }
    }

    @Override // d.a.q0.a0.e0.b, d.a.p0.s.q.a
    public w0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            w0 negFeedBackData = super.getNegFeedBackData();
            if (negFeedBackData != null) {
                negFeedBackData.p(this.V);
            }
            return negFeedBackData;
        }
        return (w0) invokeV.objValue;
    }

    @Override // d.a.q0.a0.e0.b, d.a.p0.s.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i0 : (b2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c0 == 0 ? j0 : k0 : (BdUniqueId) invokeV.objValue;
    }
}
