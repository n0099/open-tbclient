package d.a.s0.u0.r1.a.c;

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
import d.a.s0.u0.r1.a.c.a;
import d.a.s0.u0.r1.a.d.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements d.a.s0.u0.r1.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66915a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f66916b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.u0.r1.a.d.b f66917c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f66918d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, d.a.s0.u0.r1.a.a.c> f66919e;

    /* renamed from: f  reason: collision with root package name */
    public int f66920f;

    /* renamed from: g  reason: collision with root package name */
    public int f66921g;

    /* renamed from: h  reason: collision with root package name */
    public int f66922h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66923i;
    public long j;
    public Handler k;
    public d.a.s0.u0.r1.a.c.a l;
    public a.c m;
    public d.a.c.c.g.a n;

    /* loaded from: classes9.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66924a;

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
            this.f66924a = bVar;
        }

        @Override // d.a.s0.u0.r1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.f66924a.f66918d == null || this.f66924a.f66917c == null) {
                return;
            }
            this.f66924a.f66917c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: d.a.s0.u0.r1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1763b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66925a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1763b(b bVar, int i2, int i3) {
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
            this.f66925a = bVar;
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
            d.a.s0.u0.r1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f66925a.f66923i = false;
            if (responsedMessage.hasError()) {
                if (this.f66925a.f66917c != null) {
                    this.f66925a.f66917c.b(this.f66925a.f66920f, this.f66925a.f66921g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.f66925a.f66918d == null) {
                    this.f66925a.f66918d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.f66925a.f66918d == null) {
                    this.f66925a.f66918d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.f66925a.f66920f;
            int i4 = this.f66925a.f66921g;
            if (this.f66925a.f66920f == 0 && this.f66925a.f66921g == 0 && !ListUtils.isEmpty(this.f66925a.f66918d) && (eVar = (e) this.f66925a.f66918d.get(0)) != null) {
                i3 = eVar.f66935a;
                Object obj = eVar.f66937c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f66899a;
                    }
                }
            }
            String p = this.f66925a.p(i3, i4);
            d.a.s0.u0.r1.a.a.c cVar = (d.a.s0.u0.r1.a.a.c) this.f66925a.f66919e.get(p);
            if (cVar == null) {
                cVar = new d.a.s0.u0.r1.a.a.c();
                this.f66925a.f66919e.put(p, cVar);
                this.f66925a.f66919e.put(p, cVar);
            }
            cVar.f66908e = hasMore;
            cVar.f66909f = this.f66925a.f66922h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.f66925a.f66922h == 0) {
                    if (ListUtils.isEmpty(cVar.f66907d)) {
                        cVar.f66907d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.f66925a.f66917c == null) {
                            this.f66925a.f66917c.a(this.f66925a.f66920f, this.f66925a.f66921g, cVar.f66907d, this.f66925a.f66918d, cVar.f66908e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f66907d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.f66925a.f66917c == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f66928g;

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
            this.f66928g = bVar;
            this.f66926e = i2;
            this.f66927f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66928g.b(this.f66926e, this.f66927f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66929e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66930f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f66931g;

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
            this.f66931g = bVar;
            this.f66929e = i2;
            this.f66930f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66931g.c(this.f66929e, this.f66930f);
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
        this.f66920f = 0;
        this.f66921g = 0;
        this.f66922h = 0;
        this.f66923i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1763b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.f66915a = context;
        this.f66916b = bdUniqueId;
        this.j = j;
        this.f66919e = new HashMap<>();
        d.a.s0.u0.r1.a.c.a aVar = new d.a.s0.u0.r1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        s();
        t();
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            d.a.s0.h3.d0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, d.a.s0.h3.d0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // d.a.s0.u0.r1.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f66918d)) {
                return null;
            }
            for (e eVar : this.f66918d) {
                if (eVar != null && eVar.f66935a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // d.a.s0.u0.r1.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f66923i) {
                this.k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f66920f = i2;
            this.f66921g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String p = p(i2, i3);
                d.a.s0.u0.r1.a.a.c cVar = this.f66919e.get(p);
                if (cVar == null) {
                    cVar = new d.a.s0.u0.r1.a.a.c();
                    this.f66919e.put(p, cVar);
                }
                cVar.f66904a = p;
                cVar.f66905b = this.f66920f;
                cVar.f66906c = this.f66921g;
                cVar.f66909f = 0;
                cVar.f66908e = true;
            }
            this.f66922h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f66920f, this.f66921g);
            frsGameStrategyRequestMessage.setTag(this.f66916b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f66923i = true;
        }
    }

    @Override // d.a.s0.u0.r1.a.d.a
    public void c(int i2, int i3) {
        d.a.s0.u0.r1.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f66923i) {
                this.k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f66920f = i2;
            if (i2 == 0 && i3 == 0) {
                e o = o(i2);
                if (o != null) {
                    Object obj = o.f66937c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f66921g = aVar.f66899a;
                        }
                    }
                }
            } else {
                this.f66921g = i3;
            }
            String p = p(i2, i3);
            d.a.s0.u0.r1.a.a.c cVar = this.f66919e.get(p);
            if (cVar == null) {
                cVar = new d.a.s0.u0.r1.a.a.c();
                this.f66919e.put(p, cVar);
                cVar.f66908e = true;
                this.f66919e.put(p, cVar);
            }
            int i4 = cVar.f66909f + 1;
            this.f66922h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i4, this.f66920f, this.f66921g);
            frsGameStrategyRequestMessage.setTag(this.f66916b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f66923i = true;
        }
    }

    @Override // d.a.s0.u0.r1.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            d.a.s0.u0.r1.a.a.c q = q(i2, i3);
            if (q == null || ListUtils.isEmpty(q.f66907d)) {
                return false;
            }
            d.a.s0.u0.r1.a.d.b bVar = this.f66917c;
            if (bVar != null) {
                bVar.a(i2, i3, q.f66907d, this.f66918d, q.f66908e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // d.a.s0.u0.r1.a.d.a
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.j) : (String) invokeV.objValue;
    }

    public final e o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f66918d)) {
                return null;
            }
            for (e eVar : this.f66918d) {
                if (eVar != null && eVar.f66935a == i2) {
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

    public d.a.s0.u0.r1.a.a.c q(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f66919e.get(p(i2, i3)) : (d.a.s0.u0.r1.a.a.c) invokeII.objValue;
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
            this.n.setTag(this.f66916b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void u(d.a.s0.u0.r1.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f66917c = bVar;
        }
    }
}
