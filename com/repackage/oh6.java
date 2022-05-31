package com.repackage;

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
import com.repackage.nh6;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class oh6 implements ph6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public BdUniqueId b;
    public qh6 c;
    public List<th6> d;
    public final HashMap<String, lh6> e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public long j;
    public Handler k;
    public nh6 l;
    public nh6.c m;
    public wa n;

    /* loaded from: classes6.dex */
    public class a implements nh6.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh6 a;

        public a(oh6 oh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh6Var;
        }

        @Override // com.repackage.nh6.c
        public void a(List<th6> list, List<jn> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.a.d == null || this.a.c == null) {
                return;
            }
            this.a.c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(oh6 oh6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = oh6Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.wa
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<jn> threadList;
            boolean hasMore;
            int i;
            th6 th6Var;
            jh6 jh6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.a.i = false;
            if (responsedMessage.hasError()) {
                if (this.a.c != null) {
                    this.a.c.b(this.a.f, this.a.g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.a.d == null) {
                    this.a.d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.a.d == null) {
                    this.a.d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i2 = this.a.f;
            int i3 = this.a.g;
            if (this.a.f == 0 && this.a.g == 0 && !ListUtils.isEmpty(this.a.d) && (th6Var = (th6) this.a.d.get(0)) != null) {
                i2 = th6Var.a;
                Object obj = th6Var.c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (jh6Var = labelDataList.get(0)) != null) {
                        i3 = jh6Var.a;
                    }
                }
            }
            String p = this.a.p(i2, i3);
            lh6 lh6Var = (lh6) this.a.e.get(p);
            if (lh6Var == null) {
                lh6Var = new lh6();
                this.a.e.put(p, lh6Var);
                this.a.e.put(p, lh6Var);
            }
            lh6Var.e = hasMore;
            lh6Var.f = this.a.h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.a.h == 0) {
                    if (ListUtils.isEmpty(lh6Var.d)) {
                        lh6Var.d = threadList;
                    } else {
                        i = lh6Var.a(threadList);
                        if (this.a.c == null) {
                            this.a.c.a(this.a.f, this.a.g, lh6Var.d, this.a.d, lh6Var.e, false, i);
                            return;
                        }
                        return;
                    }
                } else {
                    lh6Var.d.addAll(threadList);
                }
            }
            i = -1;
            if (this.a.c == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ oh6 c;

        public c(oh6 oh6Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oh6Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.c(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ oh6 c;

        public d(oh6 oh6Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oh6Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, this.b);
            }
        }
    }

    public oh6(Context context, BdUniqueId bdUniqueId, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.a = context;
        this.b = bdUniqueId;
        this.j = j;
        this.e = new HashMap<>();
        nh6 nh6Var = new nh6();
        this.l = nh6Var;
        nh6Var.e(this.m);
        s();
        t();
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            ig8.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, ig8.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.repackage.ph6
    public th6 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            for (th6 th6Var : this.d) {
                if (th6Var != null && th6Var.a == i) {
                    return th6Var;
                }
            }
            return null;
        }
        return (th6) invokeI.objValue;
    }

    @Override // com.repackage.ph6
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? String.valueOf(this.j) : (String) invokeV.objValue;
    }

    @Override // com.repackage.ph6
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new c(this, i, i2), 1000L);
                return;
            }
            this.f = i;
            this.g = i2;
            if (i == 0 && i2 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String p = p(i, i2);
                lh6 lh6Var = this.e.get(p);
                if (lh6Var == null) {
                    lh6Var = new lh6();
                    this.e.put(p, lh6Var);
                }
                lh6Var.a = p;
                lh6Var.b = this.f;
                lh6Var.c = this.g;
                lh6Var.f = 0;
                lh6Var.e = true;
            }
            this.h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f, this.g);
            frsGameStrategyRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // com.repackage.ph6
    public void d(int i, int i2) {
        jh6 jh6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new d(this, i, i2), 1000L);
                return;
            }
            this.f = i;
            if (i == 0 && i2 == 0) {
                th6 o = o(i);
                if (o != null) {
                    Object obj = o.c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (jh6Var = labelDataList.get(0)) != null) {
                            this.g = jh6Var.a;
                        }
                    }
                }
            } else {
                this.g = i2;
            }
            String p = p(i, i2);
            lh6 lh6Var = this.e.get(p);
            if (lh6Var == null) {
                lh6Var = new lh6();
                this.e.put(p, lh6Var);
                lh6Var.e = true;
                this.e.put(p, lh6Var);
            }
            int i3 = lh6Var.f + 1;
            this.h = i3;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i3, this.f, this.g);
            frsGameStrategyRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // com.repackage.ph6
    public boolean e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            lh6 q = q(i, i2);
            if (q == null || ListUtils.isEmpty(q.d)) {
                return false;
            }
            qh6 qh6Var = this.c;
            if (qh6Var != null) {
                qh6Var.a(i, i2, q.d, this.d, q.e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    public final th6 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            for (th6 th6Var : this.d) {
                if (th6Var != null && th6Var.a == i) {
                    return th6Var;
                }
            }
            return null;
        }
        return (th6) invokeI.objValue;
    }

    public final String p(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return i + "_" + i2;
        }
        return (String) invokeII.objValue;
    }

    public lh6 q(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) ? this.e.get(p(i, i2)) : (lh6) invokeII.objValue;
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
            this.n.setTag(this.b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void u(qh6 qh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, qh6Var) == null) {
            this.c = qh6Var;
        }
    }
}
