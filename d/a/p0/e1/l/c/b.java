package d.a.p0.e1.l.c;

import android.text.SpannableString;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.message.VideoTabHttpResMessage;
import com.baidu.tieba.homepage.video.message.VideoTabRequestMessage;
import com.baidu.tieba.homepage.video.message.VideoTabSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.o0.z0.f0;
import d.a.o0.z0.i0;
import d.a.p0.a0.e0.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVideo.DataRes;
import tbclient.RecomVideo.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55861a;

    /* renamed from: b  reason: collision with root package name */
    public f f55862b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f55863c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f55864d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadPersonalized> f55865e;

    /* renamed from: f  reason: collision with root package name */
    public DataRes.Builder f55866f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55867g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55868h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f55869i;

    /* loaded from: classes8.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55870a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55870a = bVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f55870a.f55867g = false;
                this.f55870a.f55868h = false;
                if (responsedMessage != null) {
                    this.f55870a.g(responsedMessage);
                } else if (this.f55870a.f55862b != null) {
                    this.f55870a.f55862b.b(-1, "", false);
                }
            }
        }
    }

    /* renamed from: d.a.p0.e1.l.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1357b extends f0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1357b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l<byte[]> e2 = d.a.o0.r.r.a.f().e("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get(TbadkCoreApplication.getCurrentAccount())) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e3) {
                        BdLog.e(e3);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.o0.z0.n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55871a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55871a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.f55871a.f55866f = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.f55871a.i(dataRes, false);
                if (this.f55871a.f55862b != null) {
                    this.f55871a.f55862b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.o0.b1.m.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.a.p0.a0.e0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2, String str, d.a.p0.a0.e0.b bVar2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), str, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar2;
        }

        @Override // d.a.o0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.p0.e1.l.d.a.e(this.l);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f55872a;

        public e(b bVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55872a = builder;
        }

        @Override // d.a.o0.z0.f0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    d.a.o0.r.r.a.f().e("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).g(TbadkCoreApplication.getCurrentAccount(), new DataRes.Builder(this.f55872a.build(true)).build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(int i2, boolean z, boolean z2);

        void b(int i2, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55868h = true;
        this.f55869i = new a(this, CmdConfigHttp.CMD_VIDEO_TAB, 309648);
        this.f55861a = tbPageContext;
        this.f55862b = fVar;
        this.f55863c = new LinkedList();
        this.f55864d = new LinkedList();
        this.f55865e = new LinkedList();
        d.a.o0.v0.b bVar = new d.a.o0.v0.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, d.a.p0.h3.d0.a.a(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void g(ResponsedMessage<?> responsedMessage) {
        DataRes dataRes;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
            if (responsedMessage instanceof VideoTabSocketResMessage) {
                dataRes = ((VideoTabSocketResMessage) responsedMessage).mResultData;
            } else {
                dataRes = responsedMessage instanceof VideoTabHttpResMessage ? ((VideoTabHttpResMessage) responsedMessage).mResultData : null;
            }
            boolean z = responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof VideoTabRequestMessage) && ((VideoTabRequestMessage) responsedMessage.getOrginalMessage().getExtra()).load_type == 2;
            if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                i2 = 0;
            } else {
                i2 = ListUtils.getCount(dataRes.thread_list);
                i(dataRes, z);
                if (!ListUtils.isEmpty(dataRes.thread_list)) {
                    t(z);
                }
            }
            if (this.f55862b != null) {
                if (responsedMessage.getError() != 0) {
                    this.f55862b.b(responsedMessage.getError(), responsedMessage.getErrorString(), z);
                } else {
                    this.f55862b.a(i2, z, false);
                }
            }
        }
    }

    public List<n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55863c : (List) invokeV.objValue;
    }

    public final void i(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, dataRes, z) == null) {
            m(dataRes.thread_list, !z);
            n(dataRes.thread_personalized, !z);
            List<n> s = s();
            this.f55863c = s;
            d.a.p0.e1.l.c.a.b(this.f55865e, s);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f55867g) {
            return;
        }
        this.f55867g = true;
        if (this.f55868h) {
            k();
            this.f55868h = false;
        }
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 1;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f55861a.sendMessage(videoTabRequestMessage);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i0.b(new C1357b(this), new c(this));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f55867g) {
            return;
        }
        this.f55867g = true;
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 2;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f55861a.sendMessage(videoTabRequestMessage);
    }

    public final void m(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f55864d);
            this.f55864d.clear();
            this.f55864d.addAll(linkedList);
            return;
        }
        this.f55864d.addAll(list);
    }

    public final void n(List<ThreadPersonalized> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f55865e);
            this.f55865e.clear();
            this.f55865e.addAll(linkedList);
            return;
        }
        this.f55865e.addAll(list);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f55869i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().registerListener(this.f55869i);
        }
    }

    public void q(String str) {
        DataRes.Builder builder;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (builder = this.f55866f) == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(str, 0L);
        for (int i2 = 0; i2 < this.f55866f.thread_list.size(); i2++) {
            ThreadInfo threadInfo = this.f55866f.thread_list.get(i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                this.f55866f.thread_list.remove(i2);
                v(this.f55866f);
                return;
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || ListUtils.isEmpty(this.f55863c)) {
            return;
        }
        Iterator<n> it = this.f55863c.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.p0.a0.e0.b) {
                d.a.p0.a0.e0.b bVar = (d.a.p0.a0.e0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().n1() != null && bVar.getThreadData().n1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public final List<n> s() {
        InterceptResult invokeV;
        k g2;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.f55864d)) {
                return linkedList;
            }
            int i2 = 0;
            for (ThreadInfo threadInfo : this.f55864d) {
                b2 b2Var2 = new b2();
                b2Var2.I2(threadInfo);
                b2Var2.Y1 = true;
                if (d.a.p0.a0.e0.l.R(b2Var2)) {
                    k g3 = d.a.p0.e1.h.k.d.g(b2Var2);
                    if (g3 != null && (b2Var = g3.f53795e) != null && b2Var.V() != null && !StringUtils.isNull(g3.f53795e.V().f52815b) && !g3.f53795e.u2()) {
                        g3.l = b2Var2.n1();
                        g3.position = i2;
                        d.a.p0.e1.h.k.d.r(g3);
                        linkedList.add(g3);
                    } else {
                        k g4 = d.a.p0.e1.h.k.d.g(b2Var2);
                        if (g4 != null) {
                            g4.l = b2Var2.n1();
                            g4.position = i2;
                            d.a.p0.e1.h.k.d.t(g4);
                        }
                        if (g4 != null && g4.isValid()) {
                            linkedList.add(g4);
                        }
                    }
                    int[] d0 = b2Var2.d0();
                    d.a.p0.a0.e0.b e2 = d.a.p0.e1.h.k.d.e(b2Var2);
                    if (e2 != null) {
                        e2.l = b2Var2.n1();
                        e2.position = i2;
                        if (e2 instanceof k) {
                            if (b2Var2.F1()) {
                                d.a.p0.e1.h.k.d.u(e2);
                            } else if (b2Var2.N2() == 1) {
                                d.a.p0.e1.h.k.d.w(e2);
                                e2.o = d0[0];
                                e2.p = d0[1];
                            } else if (b2Var2.N2() >= 2) {
                                d.a.p0.e1.h.k.d.v(e2);
                            } else {
                                d.a.p0.e1.h.k.d.x(e2);
                            }
                        } else if (e2 instanceof d.a.p0.a0.e0.l) {
                            d.a.p0.e1.h.k.d.y(e2);
                        }
                    }
                    if (e2 != null && e2.isValid()) {
                        if (!b2Var2.p2() && b2Var2.H() != null && b2Var2.V() != null && !StringUtils.isNull(b2Var2.V().f52815b)) {
                            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), b2Var2.H().getName_show());
                            SpannableString spannableString = new SpannableString(format);
                            spannableString.setSpan(new d(this, 16, b2Var2.H().getUserId(), e2), 0, format.length() - 1, 33);
                            e2.f53795e.A1(spannableString);
                        }
                        linkedList.add(e2);
                    }
                    if (b2Var2.showCardEnterFourm() && (g2 = d.a.p0.e1.h.k.d.g(b2Var2)) != null) {
                        g2.l = b2Var2.n1();
                        g2.position = i2;
                        d.a.p0.e1.h.k.d.q(g2);
                        if (k.W(b2Var2)) {
                            g2.L("1");
                        } else if (d.a.p0.a0.e0.l.R(b2Var2)) {
                            g2.L("2");
                        }
                        if (b2Var2.showCardEnterFourm() && !StringUtils.isNull(b2Var2.W())) {
                            linkedList.add(g2);
                        } else if (!StringUtils.isNull(b2Var2.W())) {
                            linkedList.add(g2);
                        }
                    }
                    if (threadInfo.top_agree_post != null) {
                        k g5 = d.a.p0.e1.h.k.d.g(b2Var2);
                        if (g5 != null) {
                            g5.l = b2Var2.n1();
                            g5.position = i2;
                            d.a.p0.e1.h.k.d.s(g5);
                        }
                        if (g5 != null && g5.isValid()) {
                            linkedList.add(g5);
                        }
                    }
                    k g6 = d.a.p0.e1.h.k.d.g(b2Var2);
                    if (g6 != null) {
                        g6.l = b2Var2.n1();
                        g6.position = i2;
                        d.a.p0.e1.h.k.d.p(g6);
                    }
                    if (g6 != null && g6.isValid()) {
                        linkedList.add(g6);
                    }
                    i2++;
                }
            }
            d.a.o0.b.f.a.d(linkedList);
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            DataRes.Builder builder = new DataRes.Builder();
            if (ListUtils.getCount(this.f55864d) < 12) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f55864d);
                builder.thread_list = arrayList;
                u(builder, false);
            } else if (z) {
                List<ThreadInfo> list = this.f55864d;
                builder.thread_list = list.subList(list.size() - 12, this.f55864d.size());
                u(builder, true);
            } else {
                builder.thread_list = this.f55864d.subList(0, 12);
                u(builder, false);
            }
            this.f55866f = builder;
            v(builder);
        }
    }

    public final void u(DataRes.Builder builder, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, builder, z) == null) || builder == null) {
            return;
        }
        if (ListUtils.getCount(this.f55865e) < 12) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f55865e);
            builder.thread_personalized = linkedList;
        } else if (z) {
            List<ThreadPersonalized> list = this.f55865e;
            builder.thread_personalized = list.subList(list.size() - 12, this.f55865e.size());
        } else {
            builder.thread_personalized = this.f55865e.subList(0, 12);
        }
    }

    public final void v(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, builder) == null) {
            i0.b(new e(this, builder), null);
        }
    }
}
