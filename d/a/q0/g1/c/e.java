package d.a.q0.g1.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.PostForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.a1;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.o1;
import d.a.p0.s.q.p1;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.d.k.e.n> f56951a;

    /* renamed from: b  reason: collision with root package name */
    public f f56952b;

    /* renamed from: c  reason: collision with root package name */
    public n f56953c;

    /* renamed from: d  reason: collision with root package name */
    public p1 f56954d;

    /* renamed from: e  reason: collision with root package name */
    public PostForumData f56955e;

    /* renamed from: f  reason: collision with root package name */
    public i f56956f;

    /* renamed from: g  reason: collision with root package name */
    public a f56957g;

    /* renamed from: h  reason: collision with root package name */
    public a f56958h;

    /* renamed from: i  reason: collision with root package name */
    public a f56959i;
    public g j;
    public d k;
    public g l;
    public List<d.a.q0.a0.e0.b> m;
    public List<d.a.d.k.e.n> n;
    public a1 o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56951a = null;
        this.f56952b = null;
        this.f56953c = null;
        this.f56955e = null;
        this.f56956f = null;
        this.f56957g = null;
        this.f56958h = null;
        this.f56959i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = true;
        this.q = 0;
        this.f56951a = new ArrayList<>();
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null || ListUtils.getCount(dVar.R3) == 0) {
            return;
        }
        for (d.a.q0.a0.e0.b bVar : dVar.R3) {
            this.f56951a.add(bVar);
        }
    }

    public void b(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null) {
            return;
        }
        d.a.q0.a0.e0.k kVar = new d.a.q0.a0.e0.k();
        kVar.f54338e = b2Var;
        b2Var.V3(5);
        this.f56951a.add(0, kVar);
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56957g : (a) invokeV.objValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56958h : (a) invokeV.objValue;
    }

    public p1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56954d : (p1) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.intValue;
    }

    public i g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f56956f : (i) invokeV.objValue;
    }

    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f56952b : (f) invokeV.objValue;
    }

    public ArrayList<d.a.d.k.e.n> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f56951a : (ArrayList) invokeV.objValue;
    }

    public a1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (a1) invokeV.objValue;
    }

    public n k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f56953c : (n) invokeV.objValue;
    }

    public List<d.a.d.k.e.n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f56959i : (a) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void o(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.p = dataRes.is_new_url.intValue() == 1;
        if (dataRes.topic_info != null) {
            f fVar = new f();
            this.f56952b = fVar;
            fVar.b(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            g gVar = new g();
            this.l = gVar;
            gVar.b(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                b2 b2Var = new b2();
                b2Var.V3(5);
                b2Var.K2(threadInfo);
                d.a.q0.a0.e0.b bVar = null;
                if (b2Var.v1) {
                    bVar = new d.a.q0.a0.e0.k();
                    bVar.f54338e = b2Var;
                } else if (d.a.q0.a0.e0.l.R(b2Var)) {
                    bVar = new d.a.q0.a0.e0.l(b2Var);
                    bVar.x = true;
                } else if (d.a.q0.a0.e0.k.W(b2Var)) {
                    bVar = new d.a.q0.a0.e0.k();
                    bVar.f54338e = b2Var;
                }
                if (bVar != null && bVar.isValid()) {
                    bVar.L("c10814");
                    this.m.add(bVar);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            n nVar = new n();
            this.f56953c = nVar;
            nVar.parserProtobuf(dataRes.relate_forum);
            p1 p1Var = new p1();
            this.f56954d = p1Var;
            p1Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.f56954d.f53411h = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
            } else {
                this.f56954d.f53411h = dataRes.relate_forum_title;
            }
            p1 p1Var2 = this.f56954d;
            p1Var2.f53412i = R.color.CAM_X0108;
            ArrayList<o1> e2 = p1Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    o1 o1Var = new o1();
                    o1Var.B(relateForum.forum_id.intValue());
                    o1Var.C(relateForum.forum_name);
                    o1Var.A(relateForum.avatar);
                    o1Var.y(relateForum.desc);
                    o1Var.z(relateForum.thread_num.intValue());
                    o1Var.x(relateForum.member_num.intValue());
                    o1Var.w(relateForum.is_liked.intValue() != 0);
                    e2.add(o1Var);
                }
            }
        }
        List<RelateForum> list2 = dataRes.post_forum;
        if (list2 != null && list2.size() != 0) {
            PostForumData postForumData = new PostForumData();
            this.f56955e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            i iVar = new i();
            this.f56956f = iVar;
            iVar.b(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            a aVar = new a();
            this.f56957g = aVar;
            aVar.b(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            a aVar2 = new a();
            this.f56958h = aVar2;
            aVar2.b(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            a aVar3 = new a();
            this.f56959i = aVar3;
            aVar3.b(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            g gVar2 = new g();
            this.j = gVar2;
            gVar2.b(dataRes.hot_thread);
            d dVar = new d();
            this.k = dVar;
            dVar.z4(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                a1 a1Var = new a1();
                this.o = a1Var;
                a1Var.j(dataRes.hot_thread.page);
                this.r = this.o.b() != 0;
            }
            this.q = dataRes.is_global_block.intValue();
        }
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f56956f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        d.a.q0.b2.e.c cVar = new d.a.q0.b2.e.c(specialTopic.title);
                        if (!z) {
                            cVar.f55135f = false;
                            z = true;
                        }
                        this.n.add(cVar);
                    }
                    int size = specialTopic.thread_list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        List<d.a.d.k.e.n> list3 = this.n;
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i2);
                        i2++;
                        list3.add(new d.a.q0.b2.e.b(threadInfo2, i2 == size));
                    }
                }
            }
        }
        p();
    }

    public final ArrayList<d.a.d.k.e.n> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            i iVar = this.f56956f;
            if (iVar != null) {
                this.f56951a.add(iVar);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.f56951a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (d.a.q0.a0.e0.b bVar : this.m) {
                    this.f56951a.add(bVar);
                }
            }
            n nVar = this.f56953c;
            if (nVar != null && nVar.getCount() > 0 && this.s == 1) {
                this.f56951a.add(this.f56953c);
            }
            d dVar = this.k;
            if (dVar != null && !ListUtils.isEmpty(dVar.R3)) {
                this.f56951a.add(this.j);
                for (int i2 = 0; i2 < this.k.R3.size(); i2++) {
                    this.f56951a.add((d.a.q0.a0.e0.b) ListUtils.getItem(this.k.R3, i2));
                    n nVar2 = this.f56953c;
                    if (nVar2 != null && nVar2.getCount() > 0 && i2 == 2 && this.s == 0) {
                        this.f56951a.add(this.f56953c);
                    }
                }
            }
            return this.f56951a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void q(a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, a1Var) == null) {
            this.o = a1Var;
        }
    }
}
