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
public class a37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ro> a;
    public b37 b;
    public h37 c;
    public pq4 d;
    public PostForumData e;
    public e37 f;
    public w27 g;
    public w27 h;
    public w27 i;
    public c37 j;
    public z27 k;
    public c37 l;
    public List<yx5> m;
    public List<ro> n;
    public aq4 o;
    public int p;

    public a37() {
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

    public w27 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (w27) invokeV.objValue;
    }

    public w27 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (w27) invokeV.objValue;
    }

    public pq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (pq4) invokeV.objValue;
    }

    public e37 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (e37) invokeV.objValue;
    }

    public b37 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (b37) invokeV.objValue;
    }

    public List<ro> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public w27 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (w27) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            b37 b37Var = new b37();
            this.b = b37Var;
            b37Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            c37 c37Var = new c37();
            this.l = c37Var;
            c37Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                yx5 yx5Var = null;
                if (threadData.isShareThread) {
                    yx5Var = new gy5();
                    yx5Var.a = threadData;
                } else if (hy5.R(threadData)) {
                    yx5Var = new hy5(threadData);
                    yx5Var.s = true;
                } else if (gy5.W(threadData)) {
                    yx5Var = new gy5();
                    yx5Var.a = threadData;
                }
                if (yx5Var != null && yx5Var.isValid()) {
                    yx5Var.L("c10814");
                    this.m.add(yx5Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            h37 h37Var = new h37();
            this.c = h37Var;
            h37Var.parserProtobuf(dataRes.relate_forum);
            pq4 pq4Var = new pq4();
            this.d = pq4Var;
            pq4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0871);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            pq4 pq4Var2 = this.d;
            pq4Var2.e = R.color.CAM_X0108;
            ArrayList<oq4> i = pq4Var2.i();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    oq4 oq4Var = new oq4();
                    oq4Var.D(relateForum.forum_id.intValue());
                    oq4Var.E(relateForum.forum_name);
                    oq4Var.C(relateForum.avatar);
                    oq4Var.A(relateForum.desc);
                    oq4Var.B(relateForum.thread_num.intValue());
                    oq4Var.z(relateForum.member_num.intValue());
                    oq4Var.y(relateForum.is_liked.intValue() != 0);
                    i.add(oq4Var);
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
            e37 e37Var = new e37();
            this.f = e37Var;
            e37Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            w27 w27Var = new w27();
            this.g = w27Var;
            w27Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            w27 w27Var2 = new w27();
            this.h = w27Var2;
            w27Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            w27 w27Var3 = new w27();
            this.i = w27Var3;
            w27Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            c37 c37Var2 = new c37();
            this.j = c37Var2;
            c37Var2.a(dataRes.hot_thread);
            z27 z27Var = new z27();
            this.k = z27Var;
            z27Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                aq4 aq4Var = new aq4();
                this.o = aq4Var;
                aq4Var.j(dataRes.hot_thread.page);
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
                        xn7 xn7Var = new xn7(specialTopic.title);
                        if (!z) {
                            xn7Var.b = false;
                            z = true;
                        }
                        this.n.add(xn7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        wn7 wn7Var = new wn7(threadInfo2, i2 == size);
                        wn7Var.e(i2);
                        this.n.add(wn7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<ro> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e37 e37Var = this.f;
            if (e37Var != null) {
                this.a.add(e37Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (yx5 yx5Var : this.m) {
                    this.a.add(yx5Var);
                }
            }
            h37 h37Var = this.c;
            if (h37Var != null && h37Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            z27 z27Var = this.k;
            if (z27Var != null && !ListUtils.isEmpty(z27Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((yx5) ListUtils.getItem(this.k.a, i));
                    h37 h37Var2 = this.c;
                    if (h37Var2 != null && h37Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
