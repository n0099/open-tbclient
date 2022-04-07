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
/* loaded from: classes7.dex */
public class x37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<uo> a;
    public y37 b;
    public e47 c;
    public fq4 d;
    public PostForumData e;
    public b47 f;
    public t37 g;
    public t37 h;
    public t37 i;
    public z37 j;
    public w37 k;
    public z37 l;
    public List<vx5> m;
    public List<uo> n;
    public qp4 o;
    public int p;

    public x37() {
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

    public t37 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (t37) invokeV.objValue;
    }

    public t37 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (t37) invokeV.objValue;
    }

    public fq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (fq4) invokeV.objValue;
    }

    public b47 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (b47) invokeV.objValue;
    }

    public y37 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (y37) invokeV.objValue;
    }

    public List<uo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public t37 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (t37) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            y37 y37Var = new y37();
            this.b = y37Var;
            y37Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            z37 z37Var = new z37();
            this.l = z37Var;
            z37Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                vx5 vx5Var = null;
                if (threadData.isShareThread) {
                    vx5Var = new dy5();
                    vx5Var.a = threadData;
                } else if (ey5.R(threadData)) {
                    vx5Var = new ey5(threadData);
                    vx5Var.s = true;
                } else if (dy5.W(threadData)) {
                    vx5Var = new dy5();
                    vx5Var.a = threadData;
                }
                if (vx5Var != null && vx5Var.isValid()) {
                    vx5Var.L("c10814");
                    this.m.add(vx5Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            e47 e47Var = new e47();
            this.c = e47Var;
            e47Var.parserProtobuf(dataRes.relate_forum);
            fq4 fq4Var = new fq4();
            this.d = fq4Var;
            fq4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0869);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            fq4 fq4Var2 = this.d;
            fq4Var2.e = R.color.CAM_X0108;
            ArrayList<eq4> i = fq4Var2.i();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    eq4 eq4Var = new eq4();
                    eq4Var.D(relateForum.forum_id.intValue());
                    eq4Var.E(relateForum.forum_name);
                    eq4Var.C(relateForum.avatar);
                    eq4Var.A(relateForum.desc);
                    eq4Var.B(relateForum.thread_num.intValue());
                    eq4Var.z(relateForum.member_num.intValue());
                    eq4Var.y(relateForum.is_liked.intValue() != 0);
                    i.add(eq4Var);
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
            b47 b47Var = new b47();
            this.f = b47Var;
            b47Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            t37 t37Var = new t37();
            this.g = t37Var;
            t37Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            t37 t37Var2 = new t37();
            this.h = t37Var2;
            t37Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            t37 t37Var3 = new t37();
            this.i = t37Var3;
            t37Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            z37 z37Var2 = new z37();
            this.j = z37Var2;
            z37Var2.a(dataRes.hot_thread);
            w37 w37Var = new w37();
            this.k = w37Var;
            w37Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                qp4 qp4Var = new qp4();
                this.o = qp4Var;
                qp4Var.j(dataRes.hot_thread.page);
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
                        un7 un7Var = new un7(specialTopic.title);
                        if (!z) {
                            un7Var.b = false;
                            z = true;
                        }
                        this.n.add(un7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        tn7 tn7Var = new tn7(threadInfo2, i2 == size);
                        tn7Var.e(i2);
                        this.n.add(tn7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<uo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b47 b47Var = this.f;
            if (b47Var != null) {
                this.a.add(b47Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (vx5 vx5Var : this.m) {
                    this.a.add(vx5Var);
                }
            }
            e47 e47Var = this.c;
            if (e47Var != null && e47Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            w37 w37Var = this.k;
            if (w37Var != null && !ListUtils.isEmpty(w37Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((vx5) ListUtils.getItem(this.k.a, i));
                    e47 e47Var2 = this.c;
                    if (e47Var2 != null && e47Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
