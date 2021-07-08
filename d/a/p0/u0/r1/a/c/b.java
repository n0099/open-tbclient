package d.a.p0.u0.r1.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyHttpResponseMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyRequestMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategySocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.p0.u0.r1.a.c.a;
import d.a.p0.u0.r1.a.d.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements d.a.p0.u0.r1.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f63698a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f63699b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.u0.r1.a.d.b f63700c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f63701d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, d.a.p0.u0.r1.a.a.c> f63702e;

    /* renamed from: f  reason: collision with root package name */
    public int f63703f;

    /* renamed from: g  reason: collision with root package name */
    public int f63704g;

    /* renamed from: h  reason: collision with root package name */
    public int f63705h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63706i;
    public long j;
    public Handler k;
    public d.a.p0.u0.r1.a.c.a l;
    public a.c m;
    public d.a.c.c.g.a n;

    /* loaded from: classes8.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63707a;

        public a(b bVar) {
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
            this.f63707a = bVar;
        }

        @Override // d.a.p0.u0.r1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.f63707a.f63701d == null || this.f63707a.f63700c == null) {
                return;
            }
            this.f63707a.f63700c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: d.a.p0.u0.r1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1722b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63708a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1722b(b bVar, int i2, int i3) {
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
            this.f63708a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            int i2;
            e eVar;
            d.a.p0.u0.r1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f63708a.f63706i = false;
            if (responsedMessage.hasError()) {
                if (this.f63708a.f63700c != null) {
                    this.f63708a.f63700c.b(this.f63708a.f63703f, this.f63708a.f63704g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.f63708a.f63701d == null) {
                    this.f63708a.f63701d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.f63708a.f63701d == null) {
                    this.f63708a.f63701d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.f63708a.f63703f;
            int i4 = this.f63708a.f63704g;
            if (this.f63708a.f63703f == 0 && this.f63708a.f63704g == 0 && !ListUtils.isEmpty(this.f63708a.f63701d) && (eVar = (e) this.f63708a.f63701d.get(0)) != null) {
                i3 = eVar.f63718a;
                Object obj = eVar.f63720c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f63682a;
                    }
                }
            }
            String p = this.f63708a.p(i3, i4);
            d.a.p0.u0.r1.a.a.c cVar = (d.a.p0.u0.r1.a.a.c) this.f63708a.f63702e.get(p);
            if (cVar == null) {
                cVar = new d.a.p0.u0.r1.a.a.c();
                this.f63708a.f63702e.put(p, cVar);
                this.f63708a.f63702e.put(p, cVar);
            }
            cVar.f63691e = hasMore;
            cVar.f63692f = this.f63708a.f63705h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.f63708a.f63705h == 0) {
                    if (ListUtils.isEmpty(cVar.f63690d)) {
                        cVar.f63690d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.f63708a.f63700c == null) {
                            this.f63708a.f63700c.a(this.f63708a.f63703f, this.f63708a.f63704g, cVar.f63690d, this.f63708a.f63701d, cVar.f63691e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f63690d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.f63708a.f63700c == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f63710f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f63711g;

        public c(b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63711g = bVar;
            this.f63709e = i2;
            this.f63710f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63711g.b(this.f63709e, this.f63710f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63712e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f63713f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f63714g;

        public d(b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63714g = bVar;
            this.f63712e = i2;
            this.f63713f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63714g.c(this.f63712e, this.f63713f);
            }
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63703f = 0;
        this.f63704g = 0;
        this.f63705h = 0;
        this.f63706i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1722b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.f63698a = context;
        this.f63699b = bdUniqueId;
        this.j = j;
        this.f63702e = new HashMap<>();
        d.a.p0.u0.r1.a.c.a aVar = new d.a.p0.u0.r1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        s();
        t();
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            d.a.p0.h3.d0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, d.a.p0.h3.d0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // d.a.p0.u0.r1.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f63701d)) {
                return null;
            }
            for (e eVar : this.f63701d) {
                if (eVar != null && eVar.f63718a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // d.a.p0.u0.r1.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f63706i) {
                this.k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f63703f = i2;
            this.f63704g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String p = p(i2, i3);
                d.a.p0.u0.r1.a.a.c cVar = this.f63702e.get(p);
                if (cVar == null) {
                    cVar = new d.a.p0.u0.r1.a.a.c();
                    this.f63702e.put(p, cVar);
                }
                cVar.f63687a = p;
                cVar.f63688b = this.f63703f;
                cVar.f63689c = this.f63704g;
                cVar.f63692f = 0;
                cVar.f63691e = true;
            }
            this.f63705h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f63703f, this.f63704g);
            frsGameStrategyRequestMessage.setTag(this.f63699b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f63706i = true;
        }
    }

    @Override // d.a.p0.u0.r1.a.d.a
    public void c(int i2, int i3) {
        d.a.p0.u0.r1.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f63706i) {
                this.k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f63703f = i2;
            if (i2 == 0 && i3 == 0) {
                e o = o(i2);
                if (o != null) {
                    Object obj = o.f63720c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f63704g = aVar.f63682a;
                        }
                    }
                }
            } else {
                this.f63704g = i3;
            }
            String p = p(i2, i3);
            d.a.p0.u0.r1.a.a.c cVar = this.f63702e.get(p);
            if (cVar == null) {
                cVar = new d.a.p0.u0.r1.a.a.c();
                this.f63702e.put(p, cVar);
                cVar.f63691e = true;
                this.f63702e.put(p, cVar);
            }
            int i4 = cVar.f63692f + 1;
            this.f63705h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i4, this.f63703f, this.f63704g);
            frsGameStrategyRequestMessage.setTag(this.f63699b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f63706i = true;
        }
    }

    @Override // d.a.p0.u0.r1.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            d.a.p0.u0.r1.a.a.c q = q(i2, i3);
            if (q == null || ListUtils.isEmpty(q.f63690d)) {
                return false;
            }
            d.a.p0.u0.r1.a.d.b bVar = this.f63700c;
            if (bVar != null) {
                bVar.a(i2, i3, q.f63690d, this.f63701d, q.f63691e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // d.a.p0.u0.r1.a.d.a
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.j) : (String) invokeV.objValue;
    }

    public final e o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f63701d)) {
                return null;
            }
            for (e eVar : this.f63701d) {
                if (eVar != null && eVar.f63718a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    public final String p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            return i2 + "_" + i3;
        }
        return (String) invokeII.objValue;
    }

    public d.a.p0.u0.r1.a.a.c q(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f63702e.get(p(i2, i3)) : (d.a.p0.u0.r1.a.a.c) invokeII.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.removeCallbacksAndMessages(null);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.setTag(this.f63699b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void u(d.a.p0.u0.r1.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f63700c = bVar;
        }
    }
}
