package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.PostForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.RecomTopicList;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class v47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<on> a;
    public w47 b;
    public c57 c;
    public vq4 d;
    public PostForumData e;
    public z47 f;
    public r47 g;
    public r47 h;
    public r47 i;
    public x47 j;
    public u47 k;
    public x47 l;
    public List<f06> m;
    public List<on> n;
    public gq4 o;
    public int p;
    public RecomTopicList q;

    public v47() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = new ArrayList<>();
    }

    public r47 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (r47) invokeV.objValue;
    }

    public r47 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (r47) invokeV.objValue;
    }

    public vq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (vq4) invokeV.objValue;
    }

    public z47 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (z47) invokeV.objValue;
    }

    public w47 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (w47) invokeV.objValue;
    }

    public List<on> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public r47 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (r47) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            w47 w47Var = new w47();
            this.b = w47Var;
            w47Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            x47 x47Var = new x47();
            this.l = x47Var;
            x47Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                f06 f06Var = null;
                if (threadData.isShareThread) {
                    f06Var = new n06();
                    f06Var.a = threadData;
                } else if (o06.R(threadData)) {
                    f06Var = new o06(threadData);
                    f06Var.s = true;
                } else if (n06.W(threadData)) {
                    f06Var = new n06();
                    f06Var.a = threadData;
                }
                if (f06Var != null && f06Var.isValid()) {
                    f06Var.L("c10814");
                    this.m.add(f06Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            c57 c57Var = new c57();
            this.c = c57Var;
            c57Var.parserProtobuf(dataRes.relate_forum);
            vq4 vq4Var = new vq4();
            this.d = vq4Var;
            vq4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f087c);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            vq4 vq4Var2 = this.d;
            vq4Var2.e = R.color.CAM_X0108;
            ArrayList<uq4> h = vq4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    uq4 uq4Var = new uq4();
                    uq4Var.D(relateForum.forum_id.intValue());
                    uq4Var.E(relateForum.forum_name);
                    uq4Var.C(relateForum.avatar);
                    uq4Var.A(relateForum.desc);
                    uq4Var.B(relateForum.thread_num.intValue());
                    uq4Var.z(relateForum.member_num.intValue());
                    uq4Var.w(relateForum.is_liked.intValue() != 0);
                    h.add(uq4Var);
                }
            }
        }
        List<RelateForum> list2 = dataRes.post_forum;
        if (list2 != null && list2.size() != 0) {
            PostForumData postForumData = new PostForumData();
            this.e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            z47 z47Var = new z47();
            this.f = z47Var;
            z47Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            r47 r47Var = new r47();
            this.g = r47Var;
            r47Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            r47 r47Var2 = new r47();
            this.h = r47Var2;
            r47Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            r47 r47Var3 = new r47();
            this.i = r47Var3;
            r47Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            x47 x47Var2 = new x47();
            this.j = x47Var2;
            x47Var2.a(dataRes.hot_thread);
            u47 u47Var = new u47();
            this.k = u47Var;
            u47Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                gq4 gq4Var = new gq4();
                this.o = gq4Var;
                gq4Var.j(dataRes.hot_thread.page);
                this.o.b();
            }
            dataRes.is_global_block.intValue();
        }
        this.q = dataRes.next_topic;
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        cp7 cp7Var = new cp7(specialTopic.title);
                        if (!z) {
                            cp7Var.b = false;
                            z = true;
                        }
                        this.n.add(cp7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        bp7 bp7Var = new bp7(threadInfo2, i == size);
                        bp7Var.c(i);
                        this.n.add(bp7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<on> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            z47 z47Var = this.f;
            if (z47Var != null) {
                this.a.add(z47Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (f06 f06Var : this.m) {
                    this.a.add(f06Var);
                }
            }
            c57 c57Var = this.c;
            if (c57Var != null && c57Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            u47 u47Var = this.k;
            if (u47Var != null && !ListUtils.isEmpty(u47Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((f06) ListUtils.getItem(this.k.a, i));
                    c57 c57Var2 = this.c;
                    if (c57Var2 != null && c57Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
