package d.a.q0.u0.r1.a.c;

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
import d.a.d.k.e.n;
import d.a.q0.u0.r1.a.c.a;
import d.a.q0.u0.r1.a.d.e;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements d.a.q0.u0.r1.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f64343a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f64344b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.u0.r1.a.d.b f64345c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f64346d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, d.a.q0.u0.r1.a.a.c> f64347e;

    /* renamed from: f  reason: collision with root package name */
    public int f64348f;

    /* renamed from: g  reason: collision with root package name */
    public int f64349g;

    /* renamed from: h  reason: collision with root package name */
    public int f64350h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64351i;
    public long j;
    public Handler k;
    public d.a.q0.u0.r1.a.c.a l;
    public a.c m;
    public d.a.d.c.g.a n;

    /* loaded from: classes8.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64352a;

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
            this.f64352a = bVar;
        }

        @Override // d.a.q0.u0.r1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.f64352a.f64346d == null || this.f64352a.f64345c == null) {
                return;
            }
            this.f64352a.f64345c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: d.a.q0.u0.r1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1725b extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64353a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1725b(b bVar, int i2, int i3) {
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
            this.f64353a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // d.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            int i2;
            e eVar;
            d.a.q0.u0.r1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f64353a.f64351i = false;
            if (responsedMessage.hasError()) {
                if (this.f64353a.f64345c != null) {
                    this.f64353a.f64345c.b(this.f64353a.f64348f, this.f64353a.f64349g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.f64353a.f64346d == null) {
                    this.f64353a.f64346d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.f64353a.f64346d == null) {
                    this.f64353a.f64346d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.f64353a.f64348f;
            int i4 = this.f64353a.f64349g;
            if (this.f64353a.f64348f == 0 && this.f64353a.f64349g == 0 && !ListUtils.isEmpty(this.f64353a.f64346d) && (eVar = (e) this.f64353a.f64346d.get(0)) != null) {
                i3 = eVar.f64363a;
                Object obj = eVar.f64365c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f64327a;
                    }
                }
            }
            String p = this.f64353a.p(i3, i4);
            d.a.q0.u0.r1.a.a.c cVar = (d.a.q0.u0.r1.a.a.c) this.f64353a.f64347e.get(p);
            if (cVar == null) {
                cVar = new d.a.q0.u0.r1.a.a.c();
                this.f64353a.f64347e.put(p, cVar);
                this.f64353a.f64347e.put(p, cVar);
            }
            cVar.f64336e = hasMore;
            cVar.f64337f = this.f64353a.f64350h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.f64353a.f64350h == 0) {
                    if (ListUtils.isEmpty(cVar.f64335d)) {
                        cVar.f64335d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.f64353a.f64345c == null) {
                            this.f64353a.f64345c.a(this.f64353a.f64348f, this.f64353a.f64349g, cVar.f64335d, this.f64353a.f64346d, cVar.f64336e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f64335d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.f64353a.f64345c == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f64354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f64355f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f64356g;

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
            this.f64356g = bVar;
            this.f64354e = i2;
            this.f64355f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64356g.b(this.f64354e, this.f64355f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f64357e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f64358f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f64359g;

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
            this.f64359g = bVar;
            this.f64357e = i2;
            this.f64358f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64359g.c(this.f64357e, this.f64358f);
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
        this.f64348f = 0;
        this.f64349g = 0;
        this.f64350h = 0;
        this.f64351i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1725b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.f64343a = context;
        this.f64344b = bdUniqueId;
        this.j = j;
        this.f64347e = new HashMap<>();
        d.a.q0.u0.r1.a.c.a aVar = new d.a.q0.u0.r1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        s();
        t();
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            d.a.q0.h3.d0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, d.a.q0.h3.d0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // d.a.q0.u0.r1.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f64346d)) {
                return null;
            }
            for (e eVar : this.f64346d) {
                if (eVar != null && eVar.f64363a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // d.a.q0.u0.r1.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f64351i) {
                this.k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f64348f = i2;
            this.f64349g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String p = p(i2, i3);
                d.a.q0.u0.r1.a.a.c cVar = this.f64347e.get(p);
                if (cVar == null) {
                    cVar = new d.a.q0.u0.r1.a.a.c();
                    this.f64347e.put(p, cVar);
                }
                cVar.f64332a = p;
                cVar.f64333b = this.f64348f;
                cVar.f64334c = this.f64349g;
                cVar.f64337f = 0;
                cVar.f64336e = true;
            }
            this.f64350h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f64348f, this.f64349g);
            frsGameStrategyRequestMessage.setTag(this.f64344b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f64351i = true;
        }
    }

    @Override // d.a.q0.u0.r1.a.d.a
    public void c(int i2, int i3) {
        d.a.q0.u0.r1.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f64351i) {
                this.k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f64348f = i2;
            if (i2 == 0 && i3 == 0) {
                e o = o(i2);
                if (o != null) {
                    Object obj = o.f64365c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f64349g = aVar.f64327a;
                        }
                    }
                }
            } else {
                this.f64349g = i3;
            }
            String p = p(i2, i3);
            d.a.q0.u0.r1.a.a.c cVar = this.f64347e.get(p);
            if (cVar == null) {
                cVar = new d.a.q0.u0.r1.a.a.c();
                this.f64347e.put(p, cVar);
                cVar.f64336e = true;
                this.f64347e.put(p, cVar);
            }
            int i4 = cVar.f64337f + 1;
            this.f64350h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i4, this.f64348f, this.f64349g);
            frsGameStrategyRequestMessage.setTag(this.f64344b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f64351i = true;
        }
    }

    @Override // d.a.q0.u0.r1.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            d.a.q0.u0.r1.a.a.c q = q(i2, i3);
            if (q == null || ListUtils.isEmpty(q.f64335d)) {
                return false;
            }
            d.a.q0.u0.r1.a.d.b bVar = this.f64345c;
            if (bVar != null) {
                bVar.a(i2, i3, q.f64335d, this.f64346d, q.f64336e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // d.a.q0.u0.r1.a.d.a
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.j) : (String) invokeV.objValue;
    }

    public final e o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f64346d)) {
                return null;
            }
            for (e eVar : this.f64346d) {
                if (eVar != null && eVar.f64363a == i2) {
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

    public d.a.q0.u0.r1.a.a.c q(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f64347e.get(p(i2, i3)) : (d.a.q0.u0.r1.a.a.c) invokeII.objValue;
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
            this.n.setTag(this.f64344b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void u(d.a.q0.u0.r1.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f64345c = bVar;
        }
    }
}
