package d.a.s0.e1.e.d;

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
import d.a.c.e.d.l;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.r0.r.q.b2;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.s0.a0.e0.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVertical.ClassInfo;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.SubClassItem;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58573a;

    /* renamed from: b  reason: collision with root package name */
    public e f58574b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58575c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58576d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58577e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f58578f;

    /* renamed from: g  reason: collision with root package name */
    public List<ThreadInfo> f58579g;

    /* renamed from: h  reason: collision with root package name */
    public int f58580h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.s0.e1.e.c.a> f58581i;
    public boolean j;
    public DataRes.Builder k;
    public d.a.c.c.g.a l;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58582a;

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
            this.f58582a = bVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i2;
            ClassInfo classInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f58582a.f58575c = false;
                if (responsedMessage == null) {
                    this.f58582a.f58577e = false;
                    if (this.f58582a.f58574b != null) {
                        this.f58582a.f58574b.b(-1, "", this.f58582a.f58576d);
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
                    this.f58582a.k(dataRes.class_info.sub_class_list);
                    this.f58582a.j = dataRes.need_rechoose.intValue() == 1;
                }
                if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                    i2 = 0;
                } else {
                    i2 = ListUtils.getCount(dataRes.thread_list);
                    this.f58582a.n(dataRes);
                    if (!ListUtils.isEmpty(dataRes.thread_list)) {
                        this.f58582a.z(dataRes);
                    }
                }
                if (this.f58582a.f58574b != null) {
                    if (responsedMessage.getError() == 0) {
                        this.f58582a.f58574b.a(i2, this.f58582a.f58576d, false);
                    } else {
                        this.f58582a.f58574b.b(responsedMessage.getError(), responsedMessage.getErrorString(), this.f58582a.f58576d);
                    }
                }
                this.f58582a.f58577e = false;
            }
        }
    }

    /* renamed from: d.a.s0.e1.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1381b extends f0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58583a;

        public C1381b(b bVar) {
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
            this.f58583a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l<byte[]> e2 = d.a.r0.r.r.a.f().e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get(String.valueOf(this.f58583a.f58580h))) != null && bArr.length != 0) {
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

    /* loaded from: classes9.dex */
    public class c implements d.a.r0.z0.n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58584a;

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
            this.f58584a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.f58584a.k = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.f58584a.n(dataRes);
                this.f58584a.k(dataRes.class_info.sub_class_list);
                if (this.f58584a.f58574b != null) {
                    this.f58584a.f58574b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f58585a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f58586b;

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
            this.f58586b = bVar;
            this.f58585a = builder;
        }

        @Override // d.a.r0.z0.f0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    d.a.r0.r.r.a.f().e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(this.f58586b.f58580h), new DataRes.Builder(this.f58585a.build(true)).build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
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
        this.f58577e = true;
        this.j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GAME_VIDEO, 309646);
        this.f58573a = tbPageContext;
        this.f58574b = eVar;
        this.f58578f = new LinkedList();
        this.f58579g = new LinkedList();
        this.f58581i = new LinkedList();
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
        if (this.f58581i == null) {
            this.f58581i = new LinkedList();
        }
        this.f58581i.clear();
        for (SubClassItem subClassItem : list) {
            d.a.s0.e1.e.c.a aVar = new d.a.s0.e1.e.c.a();
            aVar.a(subClassItem);
            this.f58581i.add(aVar);
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58578f : (List) invokeV.objValue;
    }

    public List<d.a.s0.e1.e.c.a> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58581i : (List) invokeV.objValue;
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) {
            s(dataRes.thread_list, !this.f58576d);
            List<n> y = y();
            this.f58578f = y;
            d.a.s0.e1.e.d.a.b(dataRes, y);
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
            i0.b(new C1381b(this), new c(this));
        }
    }

    public void q(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f58575c) {
            return;
        }
        this.f58580h = i2;
        this.f58575c = true;
        this.f58576d = false;
        if (this.f58577e) {
            p();
            this.f58577e = false;
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
            this.f58573a.sendMessage(gameVideoRequestMessage);
        }
        i3 = 1;
        gameVideoRequestMessage.new_net_type = i3;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f58573a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f58575c) {
            return;
        }
        this.f58580h = i2;
        int i3 = 1;
        this.f58575c = true;
        this.f58576d = true;
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
        this.f58573a.sendMessage(gameVideoRequestMessage);
    }

    public final void s(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f58579g);
            this.f58579g.clear();
            this.f58579g.addAll(linkedList);
            return;
        }
        this.f58579g.addAll(list);
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
        long f2 = d.a.c.e.m.b.f(str, 0L);
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
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || ListUtils.isEmpty(this.f58578f)) {
            return;
        }
        Iterator<n> it = this.f58578f.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.s0.a0.e0.b) {
                d.a.s0.a0.e0.b bVar = (d.a.s0.a0.e0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().n1() != null && bVar.getThreadData().n1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f58577e = true;
            this.f58578f.clear();
            this.f58579g.clear();
        }
    }

    public final List<n> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.f58579g)) {
                return linkedList;
            }
            int i2 = 0;
            for (ThreadInfo threadInfo : this.f58579g) {
                b2 b2Var = new b2();
                b2Var.I2(threadInfo);
                if (d.a.s0.a0.e0.l.R(b2Var)) {
                    k kVar = new k();
                    kVar.f57050e = b2Var;
                    kVar.l = b2Var.n1();
                    kVar.position = i2;
                    kVar.r = true;
                    linkedList.add(kVar);
                    d.a.s0.a0.e0.l lVar = new d.a.s0.a0.e0.l(b2Var);
                    lVar.l = b2Var.n1();
                    lVar.position = i2;
                    lVar.x = true;
                    linkedList.add(lVar);
                    if (threadInfo.top_agree_post != null) {
                        k kVar2 = new k();
                        kVar2.f57050e = b2Var;
                        kVar2.l = b2Var.n1();
                        kVar2.position = i2;
                        kVar2.C = true;
                        linkedList.add(kVar2);
                    }
                    k kVar3 = new k();
                    kVar3.f57050e = b2Var;
                    kVar3.l = b2Var.n1();
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
            if (ListUtils.getCount(this.f58579g) >= 12) {
                if (this.f58576d) {
                    List<ThreadInfo> list = this.f58579g;
                    builder.thread_list = list.subList(list.size() - 12, this.f58579g.size());
                } else {
                    builder.thread_list = this.f58579g.subList(0, 12);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f58579g);
                builder.thread_list = arrayList;
            }
            this.k = builder;
            A(builder);
        }
    }
}
