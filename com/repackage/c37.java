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
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class c37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<nn> a;
    public d37 b;
    public j37 c;
    public dq4 d;
    public PostForumData e;
    public g37 f;
    public y27 g;
    public y27 h;
    public y27 i;
    public e37 j;
    public b37 k;
    public e37 l;
    public List<ny5> m;
    public List<nn> n;
    public op4 o;
    public int p;

    public c37() {
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

    public y27 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (y27) invokeV.objValue;
    }

    public y27 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (y27) invokeV.objValue;
    }

    public dq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (dq4) invokeV.objValue;
    }

    public g37 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (g37) invokeV.objValue;
    }

    public d37 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (d37) invokeV.objValue;
    }

    public List<nn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public y27 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (y27) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            d37 d37Var = new d37();
            this.b = d37Var;
            d37Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            e37 e37Var = new e37();
            this.l = e37Var;
            e37Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                ny5 ny5Var = null;
                if (threadData.isShareThread) {
                    ny5Var = new vy5();
                    ny5Var.a = threadData;
                } else if (wy5.R(threadData)) {
                    ny5Var = new wy5(threadData);
                    ny5Var.s = true;
                } else if (vy5.W(threadData)) {
                    ny5Var = new vy5();
                    ny5Var.a = threadData;
                }
                if (ny5Var != null && ny5Var.isValid()) {
                    ny5Var.L("c10814");
                    this.m.add(ny5Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            j37 j37Var = new j37();
            this.c = j37Var;
            j37Var.parserProtobuf(dataRes.relate_forum);
            dq4 dq4Var = new dq4();
            this.d = dq4Var;
            dq4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f087f);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            dq4 dq4Var2 = this.d;
            dq4Var2.e = R.color.CAM_X0108;
            ArrayList<cq4> g = dq4Var2.g();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    cq4 cq4Var = new cq4();
                    cq4Var.D(relateForum.forum_id.intValue());
                    cq4Var.E(relateForum.forum_name);
                    cq4Var.C(relateForum.avatar);
                    cq4Var.A(relateForum.desc);
                    cq4Var.B(relateForum.thread_num.intValue());
                    cq4Var.x(relateForum.member_num.intValue());
                    cq4Var.u(relateForum.is_liked.intValue() != 0);
                    g.add(cq4Var);
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
            g37 g37Var = new g37();
            this.f = g37Var;
            g37Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            y27 y27Var = new y27();
            this.g = y27Var;
            y27Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            y27 y27Var2 = new y27();
            this.h = y27Var2;
            y27Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            y27 y27Var3 = new y27();
            this.i = y27Var3;
            y27Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            e37 e37Var2 = new e37();
            this.j = e37Var2;
            e37Var2.a(dataRes.hot_thread);
            b37 b37Var = new b37();
            this.k = b37Var;
            b37Var.o(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                op4 op4Var = new op4();
                this.o = op4Var;
                op4Var.j(dataRes.hot_thread.page);
                this.o.b();
            }
            dataRes.is_global_block.intValue();
        }
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        in7 in7Var = new in7(specialTopic.title);
                        if (!z) {
                            in7Var.b = false;
                            z = true;
                        }
                        this.n.add(in7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        hn7 hn7Var = new hn7(threadInfo2, i == size);
                        hn7Var.c(i);
                        this.n.add(hn7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<nn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            g37 g37Var = this.f;
            if (g37Var != null) {
                this.a.add(g37Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (ny5 ny5Var : this.m) {
                    this.a.add(ny5Var);
                }
            }
            j37 j37Var = this.c;
            if (j37Var != null && j37Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            b37 b37Var = this.k;
            if (b37Var != null && !ListUtils.isEmpty(b37Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((ny5) ListUtils.getItem(this.k.a, i));
                    j37 j37Var2 = this.c;
                    if (j37Var2 != null && j37Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
