package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVertical.ClassInfo;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.SubClassItem;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class fw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public e b;
    public boolean c;
    public boolean d;
    public boolean e;
    public List<uo> f;
    public List<ThreadInfo> g;
    public int h;
    public List<dw6> i;
    public boolean j;
    public DataRes.Builder k;
    public wa l;

    /* loaded from: classes6.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fw6 fw6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw6Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i;
            ClassInfo classInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.c = false;
                if (responsedMessage == null) {
                    this.a.e = false;
                    if (this.a.b != null) {
                        this.a.b.b(-1, "", this.a.d);
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
                    this.a.k(dataRes.class_info.sub_class_list);
                    this.a.j = dataRes.need_rechoose.intValue() == 1;
                }
                if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                    i = 0;
                } else {
                    i = ListUtils.getCount(dataRes.thread_list);
                    this.a.n(dataRes);
                    if (!ListUtils.isEmpty(dataRes.thread_list)) {
                        this.a.z(dataRes);
                    }
                }
                if (this.a.b != null) {
                    if (responsedMessage.getError() == 0) {
                        this.a.b.a(i, this.a.d, false);
                    } else {
                        this.a.b.b(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.d);
                    }
                }
                this.a.e = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ad5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw6 a;

        public b(fw6 fw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ad5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                br4.f();
                qe<byte[]> e = br4.e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (e != null && (bArr = e.get(String.valueOf(this.a.h))) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e2) {
                        BdLog.e(e2);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ic5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw6 a;

        public c(fw6 fw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ic5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
                return;
            }
            this.a.k = new DataRes.Builder(dataRes);
            int count = ListUtils.getCount(dataRes.thread_list);
            if (count > 0) {
                this.a.n(dataRes);
                this.a.k(dataRes.class_info.sub_class_list);
                if (this.a.b != null) {
                    this.a.b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ad5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ fw6 b;

        public d(fw6 fw6Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw6Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw6Var;
            this.a = builder;
        }

        @Override // com.repackage.ad5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                br4.f();
                try {
                    br4.e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(this.b.h), builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(int i, boolean z, boolean z2);

        void b(int i, String str, boolean z);
    }

    public fw6(TbPageContext tbPageContext, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GAME_VIDEO, 309646);
        this.a = tbPageContext;
        this.b = eVar;
        this.f = new LinkedList();
        this.g = new LinkedList();
        this.i = new LinkedList();
    }

    public final void A(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
            dd5.b(new d(this, builder), null);
        }
    }

    public final void k(List<SubClassItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.i == null) {
            this.i = new LinkedList();
        }
        this.i.clear();
        for (SubClassItem subClassItem : list) {
            dw6 dw6Var = new dw6();
            dw6Var.a(subClassItem);
            this.i.add(dw6Var);
        }
    }

    public List<uo> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public List<dw6> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (List) invokeV.objValue;
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) {
            s(dataRes.thread_list, !this.d);
            List<uo> y = y();
            this.f = y;
            ew6.b(dataRes, y);
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
            dd5.b(new b(this), new c(this));
        }
    }

    public void q(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.c) {
            return;
        }
        this.h = i;
        this.c = true;
        this.d = false;
        if (this.e) {
            p();
            this.e = false;
        }
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i;
        if (!mi.H()) {
            if (mi.v()) {
                i2 = 4;
            } else if (mi.u()) {
                i2 = 3;
            } else if (mi.t()) {
                i2 = 2;
            }
            gameVideoRequestMessage.new_net_type = i2;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.a.sendMessage(gameVideoRequestMessage);
        }
        i2 = 1;
        gameVideoRequestMessage.new_net_type = i2;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.c) {
            return;
        }
        this.h = i;
        int i2 = 1;
        this.c = true;
        this.d = true;
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i;
        if (!mi.H()) {
            if (mi.v()) {
                i2 = 4;
            } else if (mi.u()) {
                i2 = 3;
            } else if (mi.t()) {
                i2 = 2;
            }
        }
        gameVideoRequestMessage.new_net_type = i2;
        gameVideoRequestMessage.load_type = 2;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(gameVideoRequestMessage);
    }

    public final void s(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.g);
            this.g.clear();
            this.g.addAll(linkedList);
            return;
        }
        this.g.addAll(list);
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
        long g = mg.g(str, 0L);
        for (int i = 0; i < this.k.thread_list.size(); i++) {
            ThreadInfo threadInfo = this.k.thread_list.get(i);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g) {
                this.k.thread_list.remove(i);
                A(this.k);
                return;
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || ListUtils.isEmpty(this.f)) {
            return;
        }
        Iterator<uo> it = this.f.iterator();
        while (it.hasNext()) {
            uo next = it.next();
            if (next instanceof xx5) {
                xx5 xx5Var = (xx5) next;
                if (xx5Var.getThreadData() != null && xx5Var.getThreadData().getTid() != null && xx5Var.getThreadData().getTid().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.e = true;
            this.f.clear();
            this.g.clear();
        }
    }

    public final List<uo> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.g)) {
                return linkedList;
            }
            int i = 0;
            for (ThreadInfo threadInfo : this.g) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                if (gy5.R(threadData)) {
                    fy5 fy5Var = new fy5();
                    fy5Var.a = threadData;
                    fy5Var.g = threadData.getTid();
                    fy5Var.position = i;
                    fy5Var.m = true;
                    linkedList.add(fy5Var);
                    gy5 gy5Var = new gy5(threadData);
                    gy5Var.g = threadData.getTid();
                    gy5Var.position = i;
                    gy5Var.s = true;
                    linkedList.add(gy5Var);
                    if (threadInfo.top_agree_post != null) {
                        fy5 fy5Var2 = new fy5();
                        fy5Var2.a = threadData;
                        fy5Var2.g = threadData.getTid();
                        fy5Var2.position = i;
                        fy5Var2.y = true;
                        linkedList.add(fy5Var2);
                    }
                    fy5 fy5Var3 = new fy5();
                    fy5Var3.a = threadData;
                    fy5Var3.g = threadData.getTid();
                    fy5Var3.position = i;
                    fy5Var3.A = true;
                    linkedList.add(fy5Var3);
                    i++;
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
            if (ListUtils.getCount(this.g) >= 12) {
                if (this.d) {
                    List<ThreadInfo> list = this.g;
                    builder.thread_list = list.subList(list.size() - 12, this.g.size());
                } else {
                    builder.thread_list = this.g.subList(0, 12);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.g);
                builder.thread_list = arrayList;
            }
            this.k = builder;
            A(builder);
        }
    }
}
