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
public class d17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<jn> a;
    public e17 b;
    public k17 c;
    public ep4 d;
    public PostForumData e;
    public h17 f;
    public z07 g;
    public z07 h;
    public z07 i;
    public f17 j;
    public c17 k;
    public f17 l;
    public List<rw5> m;
    public List<jn> n;
    public po4 o;
    public int p;

    public d17() {
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

    public z07 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (z07) invokeV.objValue;
    }

    public z07 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (z07) invokeV.objValue;
    }

    public ep4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (ep4) invokeV.objValue;
    }

    public h17 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (h17) invokeV.objValue;
    }

    public e17 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (e17) invokeV.objValue;
    }

    public List<jn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public z07 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (z07) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            e17 e17Var = new e17();
            this.b = e17Var;
            e17Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            f17 f17Var = new f17();
            this.l = f17Var;
            f17Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                rw5 rw5Var = null;
                if (threadData.isShareThread) {
                    rw5Var = new zw5();
                    rw5Var.a = threadData;
                } else if (ax5.R(threadData)) {
                    rw5Var = new ax5(threadData);
                    rw5Var.s = true;
                } else if (zw5.W(threadData)) {
                    rw5Var = new zw5();
                    rw5Var.a = threadData;
                }
                if (rw5Var != null && rw5Var.isValid()) {
                    rw5Var.L("c10814");
                    this.m.add(rw5Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            k17 k17Var = new k17();
            this.c = k17Var;
            k17Var.parserProtobuf(dataRes.relate_forum);
            ep4 ep4Var = new ep4();
            this.d = ep4Var;
            ep4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0877);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            ep4 ep4Var2 = this.d;
            ep4Var2.e = R.color.CAM_X0108;
            ArrayList<dp4> i = ep4Var2.i();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    dp4 dp4Var = new dp4();
                    dp4Var.D(relateForum.forum_id.intValue());
                    dp4Var.E(relateForum.forum_name);
                    dp4Var.C(relateForum.avatar);
                    dp4Var.A(relateForum.desc);
                    dp4Var.B(relateForum.thread_num.intValue());
                    dp4Var.z(relateForum.member_num.intValue());
                    dp4Var.y(relateForum.is_liked.intValue() != 0);
                    i.add(dp4Var);
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
            h17 h17Var = new h17();
            this.f = h17Var;
            h17Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            z07 z07Var = new z07();
            this.g = z07Var;
            z07Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            z07 z07Var2 = new z07();
            this.h = z07Var2;
            z07Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            z07 z07Var3 = new z07();
            this.i = z07Var3;
            z07Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            f17 f17Var2 = new f17();
            this.j = f17Var2;
            f17Var2.a(dataRes.hot_thread);
            c17 c17Var = new c17();
            this.k = c17Var;
            c17Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                po4 po4Var = new po4();
                this.o = po4Var;
                po4Var.j(dataRes.hot_thread.page);
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
                        fl7 fl7Var = new fl7(specialTopic.title);
                        if (!z) {
                            fl7Var.b = false;
                            z = true;
                        }
                        this.n.add(fl7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        el7 el7Var = new el7(threadInfo2, i2 == size);
                        el7Var.e(i2);
                        this.n.add(el7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<jn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h17 h17Var = this.f;
            if (h17Var != null) {
                this.a.add(h17Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (rw5 rw5Var : this.m) {
                    this.a.add(rw5Var);
                }
            }
            k17 k17Var = this.c;
            if (k17Var != null && k17Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            c17 c17Var = this.k;
            if (c17Var != null && !ListUtils.isEmpty(c17Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((rw5) ListUtils.getItem(this.k.a, i));
                    k17 k17Var2 = this.c;
                    if (k17Var2 != null && k17Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
