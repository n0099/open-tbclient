package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.PkModule;
import tbclient.TopicModule;
/* loaded from: classes7.dex */
public class wz6 extends rw5 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId i0;
    public static final BdUniqueId j0;
    public transient /* synthetic */ FieldHolder $fh;
    public int R;
    public long S;
    public String T;
    public String U;
    public long V;
    public String W;
    public xz6 X;
    public PostData Y;
    public int Z;
    public String g0;
    public ThreadData h0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755184034, "Lcom/repackage/wz6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755184034, "Lcom/repackage/wz6;");
                return;
            }
        }
        i0 = BdUniqueId.gen();
        j0 = BdUniqueId.gen();
    }

    public wz6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Z = 0;
    }

    public static boolean N(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) ? threadData != null && threadData.getType() == ThreadData.TYPE_TOPIC : invokeL.booleanValue;
    }

    public void O(NewTopicList newTopicList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, newTopicList) == null) || newTopicList == null) {
            return;
        }
        this.S = newTopicList.topic_id.longValue();
        this.T = newTopicList.topic_name;
        this.U = newTopicList.topic_desc;
        this.V = newTopicList.discuss_num.longValue();
        this.W = newTopicList.topic_image;
        PkModule pkModule = newTopicList.pk_module;
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            xz6 xz6Var = new xz6();
            this.X = xz6Var;
            xz6Var.a = this.S;
            xz6Var.f = 1;
            xz6Var.b(newTopicList.pk_module);
        }
        if (newTopicList.top_agree_post != null) {
            PostData postData = new PostData();
            this.Y = postData;
            postData.j0(newTopicList.top_agree_post);
        }
    }

    public void P(TopicModule topicModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topicModule) == null) || topicModule == null) {
            return;
        }
        this.S = topicModule.topic_id.longValue();
        this.T = topicModule.topic_name;
        this.U = topicModule.topic_desc;
        this.W = topicModule.topic_image;
        this.g0 = topicModule.topic_avatar;
        tbclient.PkModule pkModule = topicModule.pk_module;
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        xz6 xz6Var = new xz6();
        this.X = xz6Var;
        xz6Var.a = this.S;
        xz6Var.f = 3;
        xz6Var.c(topicModule.pk_module);
    }

    public void Q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            this.h0 = threadData;
        }
    }

    @Override // com.repackage.rw5, com.repackage.om4
    public lo4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            lo4 negFeedBackData = super.getNegFeedBackData();
            if (negFeedBackData != null) {
                negFeedBackData.q(this.S);
            }
            return negFeedBackData;
        }
        return (lo4) invokeV.objValue;
    }

    @Override // com.repackage.rw5, com.repackage.om4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h0 : (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.jn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.Z == 0 ? i0 : j0 : (BdUniqueId) invokeV.objValue;
    }
}
