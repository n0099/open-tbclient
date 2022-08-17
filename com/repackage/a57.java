package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes5.dex */
public class a57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<e57> b;
    public d57 c;
    public List<t47> d;
    public List<s47> e;
    public List<TopicList> f;
    public List<NewTopicList> g;

    public a57() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public List<TopicList> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        List<TopicList> list;
        List<TopicList> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        List<TabList> list3 = dataRes.tab_list;
        if (list3 != null && !ListUtils.isEmpty(list3)) {
            this.b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                e57 e57Var = new e57();
                e57Var.a(tabList);
                this.b.add(e57Var);
            }
        }
        if (dataRes.media_topic != null) {
            d57 d57Var = new d57();
            this.c = d57Var;
            d57Var.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                s47 s47Var = new s47();
                s47Var.b(dataRes.topic_manual);
                s47Var.a(dataRes.topic_manual.topic_list.get(i));
                this.e.add(s47Var);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                t47 t47Var = new t47();
                t47Var.b(dataRes.topic_bang);
                t47Var.a(dataRes.topic_bang.topic_list.get(i2));
                this.d.add(t47Var);
            }
        }
        this.f = dataRes.frs_tab_topic;
        this.g = dataRes.topic_list;
    }
}
