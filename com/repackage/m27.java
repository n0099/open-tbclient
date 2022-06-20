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
/* loaded from: classes6.dex */
public class m27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<nn> a;
    public n27 b;
    public t27 c;
    public op4 d;
    public PostForumData e;
    public q27 f;
    public i27 g;
    public i27 h;
    public i27 i;
    public o27 j;
    public l27 k;
    public o27 l;
    public List<qx5> m;
    public List<nn> n;
    public zo4 o;
    public int p;

    public m27() {
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

    public i27 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (i27) invokeV.objValue;
    }

    public i27 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (i27) invokeV.objValue;
    }

    public op4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (op4) invokeV.objValue;
    }

    public q27 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (q27) invokeV.objValue;
    }

    public n27 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (n27) invokeV.objValue;
    }

    public List<nn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public i27 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (i27) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            n27 n27Var = new n27();
            this.b = n27Var;
            n27Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            o27 o27Var = new o27();
            this.l = o27Var;
            o27Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                qx5 qx5Var = null;
                if (threadData.isShareThread) {
                    qx5Var = new yx5();
                    qx5Var.a = threadData;
                } else if (zx5.R(threadData)) {
                    qx5Var = new zx5(threadData);
                    qx5Var.s = true;
                } else if (yx5.W(threadData)) {
                    qx5Var = new yx5();
                    qx5Var.a = threadData;
                }
                if (qx5Var != null && qx5Var.isValid()) {
                    qx5Var.L("c10814");
                    this.m.add(qx5Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            t27 t27Var = new t27();
            this.c = t27Var;
            t27Var.parserProtobuf(dataRes.relate_forum);
            op4 op4Var = new op4();
            this.d = op4Var;
            op4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0874);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            op4 op4Var2 = this.d;
            op4Var2.e = R.color.CAM_X0108;
            ArrayList<np4> h = op4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    np4 np4Var = new np4();
                    np4Var.D(relateForum.forum_id.intValue());
                    np4Var.E(relateForum.forum_name);
                    np4Var.C(relateForum.avatar);
                    np4Var.A(relateForum.desc);
                    np4Var.B(relateForum.thread_num.intValue());
                    np4Var.z(relateForum.member_num.intValue());
                    np4Var.w(relateForum.is_liked.intValue() != 0);
                    h.add(np4Var);
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
            q27 q27Var = new q27();
            this.f = q27Var;
            q27Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            i27 i27Var = new i27();
            this.g = i27Var;
            i27Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            i27 i27Var2 = new i27();
            this.h = i27Var2;
            i27Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            i27 i27Var3 = new i27();
            this.i = i27Var3;
            i27Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            o27 o27Var2 = new o27();
            this.j = o27Var2;
            o27Var2.a(dataRes.hot_thread);
            l27 l27Var = new l27();
            this.k = l27Var;
            l27Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                zo4 zo4Var = new zo4();
                this.o = zo4Var;
                zo4Var.j(dataRes.hot_thread.page);
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
                        qm7 qm7Var = new qm7(specialTopic.title);
                        if (!z) {
                            qm7Var.b = false;
                            z = true;
                        }
                        this.n.add(qm7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        pm7 pm7Var = new pm7(threadInfo2, i == size);
                        pm7Var.c(i);
                        this.n.add(pm7Var);
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
            q27 q27Var = this.f;
            if (q27Var != null) {
                this.a.add(q27Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (qx5 qx5Var : this.m) {
                    this.a.add(qx5Var);
                }
            }
            t27 t27Var = this.c;
            if (t27Var != null && t27Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            l27 l27Var = this.k;
            if (l27Var != null && !ListUtils.isEmpty(l27Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((qx5) ListUtils.getItem(this.k.a, i));
                    t27 t27Var2 = this.c;
                    if (t27Var2 != null && t27Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
