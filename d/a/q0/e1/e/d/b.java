package d.a.q0.e1.e.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoHttpResMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoRequestMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.d.e.d.l;
import d.a.d.e.p.j;
import d.a.d.k.e.n;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.s.q.b2;
import d.a.q0.a0.e0.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVertical.ClassInfo;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.SubClassItem;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55862a;

    /* renamed from: b  reason: collision with root package name */
    public e f55863b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55864c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55865d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55866e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f55867f;

    /* renamed from: g  reason: collision with root package name */
    public List<ThreadInfo> f55868g;

    /* renamed from: h  reason: collision with root package name */
    public int f55869h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.q0.e1.e.c.a> f55870i;
    public boolean j;
    public DataRes.Builder k;
    public d.a.d.c.g.a l;

    /* loaded from: classes8.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55871a;

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
            this.f55871a = bVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i2;
            ClassInfo classInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f55871a.f55864c = false;
                if (responsedMessage == null) {
                    this.f55871a.f55866e = false;
                    if (this.f55871a.f55863b != null) {
                        this.f55871a.f55863b.b(-1, "", this.f55871a.f55865d);
                        return;
                    }
                    return;
                }
                DataRes dataRes = null;
                if (responsedMessage instanceof GameVideoSocketResMessage) {
                    dataRes = ((GameVideoSocketResMessage) responsedMessage).mResultData;
                } else if (responsedMessage instanceof GameVideoHttpResMessage) {
                    dataRes = ((GameVideoHttpResMessage) responsedMessage).mResultData;
                }
                if (dataRes != null && (classInfo = dataRes.class_info) != null && !ListUtils.isEmpty(classInfo.sub_class_list)) {
                    this.f55871a.k(dataRes.class_info.sub_class_list);
                    this.f55871a.j = dataRes.need_rechoose.intValue() == 1;
                }
                if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                    i2 = 0;
                } else {
                    i2 = ListUtils.getCount(dataRes.thread_list);
                    this.f55871a.n(dataRes);
                    if (!ListUtils.isEmpty(dataRes.thread_list)) {
                        this.f55871a.z(dataRes);
                    }
                }
                if (this.f55871a.f55863b != null) {
                    if (responsedMessage.getError() == 0) {
                        this.f55871a.f55863b.a(i2, this.f55871a.f55865d, false);
                    } else {
                        this.f55871a.f55863b.b(responsedMessage.getError(), responsedMessage.getErrorString(), this.f55871a.f55865d);
                    }
                }
                this.f55871a.f55866e = false;
            }
        }
    }

    /* renamed from: d.a.q0.e1.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1344b extends f0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55872a;

        public C1344b(b bVar) {
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
            this.f55872a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l<byte[]> e2 = d.a.p0.s.r.a.f().e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get(String.valueOf(this.f55872a.f55869h))) != null && bArr.length != 0) {
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
    public class c implements d.a.p0.b1.n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55873a;

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
            this.f55873a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.f55873a.k = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.f55873a.n(dataRes);
                this.f55873a.k(dataRes.class_info.sub_class_list);
                if (this.f55873a.f55863b != null) {
                    this.f55873a.f55863b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f55874a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f55875b;

        public d(b bVar, DataRes.Builder builder) {
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
            this.f55875b = bVar;
            this.f55874a = builder;
        }

        @Override // d.a.p0.b1.f0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    d.a.p0.s.r.a.f().e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(this.f55875b.f55869h), new DataRes.Builder(this.f55874a.build(true)).build(true).toByteArray());
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
    public interface e {
        void a(int i2, boolean z, boolean z2);

        void b(int i2, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55866e = true;
        this.j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GAME_VIDEO, 309646);
        this.f55862a = tbPageContext;
        this.f55863b = eVar;
        this.f55867f = new LinkedList();
        this.f55868g = new LinkedList();
        this.f55870i = new LinkedList();
    }

    public final void A(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
            i0.b(new d(this, builder), null);
        }
    }

    public final void k(List<SubClassItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f55870i == null) {
            this.f55870i = new LinkedList();
        }
        this.f55870i.clear();
        for (SubClassItem subClassItem : list) {
            d.a.q0.e1.e.c.a aVar = new d.a.q0.e1.e.c.a();
            aVar.a(subClassItem);
            this.f55870i.add(aVar);
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55867f : (List) invokeV.objValue;
    }

    public List<d.a.q0.e1.e.c.a> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55870i : (List) invokeV.objValue;
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) {
            s(dataRes.thread_list, !this.f55865d);
            List<n> y = y();
            this.f55867f = y;
            d.a.q0.e1.e.d.a.b(dataRes, y);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i0.b(new C1344b(this), new c(this));
        }
    }

    public void q(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f55864c) {
            return;
        }
        this.f55869h = i2;
        this.f55864c = true;
        this.f55865d = false;
        if (this.f55866e) {
            p();
            this.f55866e = false;
        }
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i2;
        if (!j.H()) {
            if (j.v()) {
                i3 = 4;
            } else if (j.u()) {
                i3 = 3;
            } else if (j.t()) {
                i3 = 2;
            }
            gameVideoRequestMessage.new_net_type = i3;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.f55862a.sendMessage(gameVideoRequestMessage);
        }
        i3 = 1;
        gameVideoRequestMessage.new_net_type = i3;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f55862a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f55864c) {
            return;
        }
        this.f55869h = i2;
        int i3 = 1;
        this.f55864c = true;
        this.f55865d = true;
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i2;
        if (!j.H()) {
            if (j.v()) {
                i3 = 4;
            } else if (j.u()) {
                i3 = 3;
            } else if (j.t()) {
                i3 = 2;
            }
        }
        gameVideoRequestMessage.new_net_type = i3;
        gameVideoRequestMessage.load_type = 2;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f55862a.sendMessage(gameVideoRequestMessage);
    }

    public final void s(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f55868g);
            this.f55868g.clear();
            this.f55868g.addAll(linkedList);
            return;
        }
        this.f55868g.addAll(list);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public void v(String str) {
        DataRes.Builder builder;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (builder = this.k) == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long f2 = d.a.d.e.m.b.f(str, 0L);
        for (int i2 = 0; i2 < this.k.thread_list.size(); i2++) {
            ThreadInfo threadInfo = this.k.thread_list.get(i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                this.k.thread_list.remove(i2);
                A(this.k);
                return;
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || ListUtils.isEmpty(this.f55867f)) {
            return;
        }
        Iterator<n> it = this.f55867f.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.q0.a0.e0.b) {
                d.a.q0.a0.e0.b bVar = (d.a.q0.a0.e0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().o1() != null && bVar.getThreadData().o1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f55866e = true;
            this.f55867f.clear();
            this.f55868g.clear();
        }
    }

    public final List<n> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.f55868g)) {
                return linkedList;
            }
            int i2 = 0;
            for (ThreadInfo threadInfo : this.f55868g) {
                b2 b2Var = new b2();
                b2Var.K2(threadInfo);
                if (d.a.q0.a0.e0.l.R(b2Var)) {
                    k kVar = new k();
                    kVar.f54338e = b2Var;
                    kVar.l = b2Var.o1();
                    kVar.position = i2;
                    kVar.r = true;
                    linkedList.add(kVar);
                    d.a.q0.a0.e0.l lVar = new d.a.q0.a0.e0.l(b2Var);
                    lVar.l = b2Var.o1();
                    lVar.position = i2;
                    lVar.x = true;
                    linkedList.add(lVar);
                    if (threadInfo.top_agree_post != null) {
                        k kVar2 = new k();
                        kVar2.f54338e = b2Var;
                        kVar2.l = b2Var.o1();
                        kVar2.position = i2;
                        kVar2.C = true;
                        linkedList.add(kVar2);
                    }
                    k kVar3 = new k();
                    kVar3.f54338e = b2Var;
                    kVar3.l = b2Var.o1();
                    kVar3.position = i2;
                    kVar3.E = true;
                    linkedList.add(kVar3);
                    i2++;
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void z(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dataRes) == null) {
            DataRes.Builder builder = new DataRes.Builder();
            builder.need_rechoose = dataRes.need_rechoose;
            builder.class_info = dataRes.class_info;
            builder.thread_personalized = dataRes.thread_personalized;
            if (ListUtils.getCount(this.f55868g) >= 12) {
                if (this.f55865d) {
                    List<ThreadInfo> list = this.f55868g;
                    builder.thread_list = list.subList(list.size() - 12, this.f55868g.size());
                } else {
                    builder.thread_list = this.f55868g.subList(0, 12);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f55868g);
                builder.thread_list = arrayList;
            }
            this.k = builder;
            A(builder);
        }
    }
}
