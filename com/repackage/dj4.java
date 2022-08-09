package com.repackage;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jk4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class dj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<cj4>> b;
    public final LinkedList<cj4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public jk4 i;
    public dk4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public bk4<ck4> s;
    public wm4 t;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dj4 dj4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f = true;
                if (this.a.c.isEmpty()) {
                    return;
                }
                Iterator it = this.a.c.iterator();
                while (it.hasNext()) {
                    this.a.m((cj4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dj4 dj4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dj4 dj4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                this.a.g = true;
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements bk4<ck4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj4 a;

        public d(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bk4
        /* renamed from: b */
        public void a(ck4 ck4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ck4Var) == null) || ck4Var == null || (activeCenterData = ck4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            cj4 cj4Var = new cj4();
            cj4Var.P(ck4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cj4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vm4
        /* renamed from: c */
        public void onSuccess(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ck4Var) == null) || ck4Var == null) {
                return;
            }
            this.a.n(ck4Var.b());
        }

        @Override // com.repackage.vm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements wm4<cj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj4 a;

        public e(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wm4
        /* renamed from: b */
        public void a(cj4 cj4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cj4Var) == null) || cj4Var == null) {
                return;
            }
            cj4 u = this.a.u(cj4Var);
            if (u != null && u.z) {
                u.S();
                this.a.S(u);
                return;
            }
            oj4.b().h(u);
            if (u != null && u.x() == 7) {
                u.I();
                int F = u.F();
                int w = u.w();
                if (F <= 1 || F <= w) {
                    this.a.G(u);
                } else {
                    this.a.S(u);
                }
            } else if (u == null || u.x() != 8) {
                this.a.G(cj4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<cj4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(cj4... cj4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cj4VarArr)) == null) {
                if (cj4VarArr == null || cj4VarArr.length <= 0 || cj4VarArr[0] == null) {
                    return null;
                }
                aj4.g().a(cj4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(dj4 dj4Var, a aVar) {
            this(dj4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<List<cj4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<cj4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                aj4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(dj4 dj4Var, a aVar) {
            this(dj4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<cj4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(cj4... cj4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cj4VarArr)) == null) {
                if (cj4VarArr == null || cj4VarArr.length <= 0 || cj4VarArr[0] == null) {
                    return null;
                }
                aj4.g().e(cj4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(dj4 dj4Var, a aVar) {
            this(dj4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Pair<cj4, cj4>, Integer, Pair<cj4, cj4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj4 a;

        public j(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<cj4, cj4> doInBackground(Pair<cj4, cj4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<cj4, cj4> pair = pairArr[0];
                cj4 cj4Var = (cj4) pair.first;
                cj4 cj4Var2 = (cj4) pair.second;
                if (cj4Var2 != null) {
                    aj4.g().e(cj4Var2);
                }
                if (cj4Var != null) {
                    aj4.g().a(cj4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<cj4, cj4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            cj4 cj4Var = (cj4) pair.first;
            cj4 cj4Var2 = (cj4) pair.second;
            if (cj4Var2 != null) {
                this.a.t(cj4Var2);
            }
            if (cj4Var != null) {
                this.a.J(cj4Var);
            }
        }

        public /* synthetic */ j(dj4 dj4Var, a aVar) {
            this(dj4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<cj4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj4 a;

        public k(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<cj4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<cj4> linkedList = new LinkedList<>();
                linkedList.addAll(aj4.g().f());
                Iterator<cj4> it = linkedList.iterator();
                while (it.hasNext()) {
                    cj4 next = it.next();
                    if (next != null && next.N()) {
                        aj4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        aj4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<cj4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<cj4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        cj4 next = it.next();
                        if (next.h() != null) {
                            this.a.J(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(dj4 dj4Var, a aVar) {
            this(dj4Var);
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final dj4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-441192133, "Lcom/repackage/dj4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-441192133, "Lcom/repackage/dj4$l;");
                    return;
                }
            }
            a = new dj4(null);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<cj4, Integer, cj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj4 a;

        public m(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public cj4 doInBackground(cj4... cj4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cj4VarArr)) == null) {
                if (cj4VarArr == null || cj4VarArr.length <= 0 || cj4VarArr[0] == null) {
                    return null;
                }
                cj4 cj4Var = cj4VarArr[0];
                aj4.g().i(cj4Var);
                return cj4Var;
            }
            return (cj4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(cj4 cj4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cj4Var) == null) && cj4Var != null && cj4Var.z) {
                cj4Var.z = false;
                dj4 dj4Var = this.a;
                dj4Var.P(dj4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(dj4 dj4Var, a aVar) {
            this(dj4Var);
        }
    }

    public /* synthetic */ dj4(a aVar) {
        this();
    }

    public static final dj4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (dj4) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public final boolean B(cj4 cj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cj4Var)) == null) {
            if (cj4Var == null) {
                return false;
            }
            int[] h2 = cj4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<cj4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (cj4 cj4Var2 : list) {
                    if (cj4Var2 != null && cj4Var2.d() == cj4Var.d() && cj4Var2.q() == cj4Var.q()) {
                        if (cj4Var2.N()) {
                            H(cj4Var, cj4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && ru4.k().l("app_restart_times", 0) > 1;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.compareAndSet(true, false);
            this.d.f(0);
            this.d.h(0L);
            this.d.g(0L);
            jk4 jk4Var = this.i;
            if (jk4Var != null) {
                jk4Var.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<cj4> list = this.b.get(cj4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (cj4 cj4Var : list) {
                Iterator<ij4> it = cj4Var.n().iterator();
                while (it.hasNext()) {
                    ij4 next = it.next();
                    if (next instanceof mj4) {
                        mj4 mj4Var = (mj4) next;
                        if (!next.e()) {
                            mj4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(cj4.Y);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void G(cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cj4Var) == null) {
            t(cj4Var);
            new i(this, null).execute(cj4Var);
        }
    }

    public final void H(cj4 cj4Var, cj4 cj4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cj4Var, cj4Var2) == null) {
            t(cj4Var2);
            new j(this, null).execute(new Pair(cj4Var, cj4Var2));
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null && A() && this.g) {
                this.j.f(z(), C(), 1);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J(cj4 cj4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cj4Var) == null) {
            for (int i2 : cj4Var.h()) {
                List<cj4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(cj4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(cj4Var);
                }
            }
        }
    }

    public void K(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A()) {
            this.m = i2;
            long j3 = this.l;
            if (j3 > 0 && this.k > 0 && (j2 == 0 || j2 != j3)) {
                R(this.k, this.l);
                this.l = 0L;
                this.k = 0;
            }
            M();
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public void M() {
        int i2;
        List<cj4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && A() && this.f && (list = this.b.get((i2 = cj4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (cj4 cj4Var : list) {
                if (cj4Var.x() == 8) {
                    Iterator<ij4> it = cj4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ij4 next = it.next();
                        cj4 c2 = next.c();
                        if (c2 != null && (next instanceof mj4) && c2.d() == cj4Var.d() && c2.q() == cj4Var.q()) {
                            ((mj4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        mj4 mj4Var = new mj4(cj4Var);
                        mj4Var.g(0L);
                        mj4Var.f(false);
                        cj4Var.a(mj4Var);
                    }
                }
            }
            this.d.f(i2);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && A() && i2 != 0 && this.f) {
            this.k = i2;
            List<cj4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (cj4 cj4Var : list) {
                if (cj4Var.x() == 4) {
                    Iterator<ij4> it = cj4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ij4 next = it.next();
                        if ((next instanceof jj4) && next.c().d() == cj4Var.d() && next.c().q() == cj4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        jj4 jj4Var = new jj4(cj4Var);
                        jj4Var.g(0L);
                        jj4Var.f(false);
                        cj4Var.a(jj4Var);
                    }
                }
            }
            this.d.f(i2);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public void O(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<cj4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (cj4 cj4Var : list) {
                if (cj4Var.x() == 2) {
                    Iterator<ij4> it = cj4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ij4 next = it.next();
                        if ((next instanceof kj4) && next.c().d() == cj4Var.d() && next.c().q() == cj4Var.q() && ((kj4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        kj4 kj4Var = new kj4(cj4Var, j2);
                        kj4Var.g(0L);
                        kj4Var.f(false);
                        kj4Var.h(cj4Var.w());
                        cj4Var.a(kj4Var);
                    }
                }
            }
            this.d.f(i2);
            this.d.g(j2);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<cj4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (cj4 cj4Var : list) {
                if (cj4Var.x() == 1) {
                    p(cj4Var, j2);
                } else if (cj4Var.x() == 7 && !cj4Var.K(j2)) {
                    o(cj4Var, j2);
                }
            }
            this.d.f(i2);
            this.d.h(j2);
            this.l = j2;
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.scheduleWithFixedDelay(this.d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public void R(int i2, long j2) {
        List<cj4> list;
        lj4 lj4Var;
        cj4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (cj4 cj4Var : list) {
            if (cj4Var.x() == 7) {
                Iterator<ij4> it = cj4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ij4 next = it.next();
                        if ((next instanceof lj4) && (c2 = (lj4Var = (lj4) next).c()) != null && lj4Var.i() == j2 && c2.d() == cj4Var.d() && c2.q() == cj4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cj4Var) == null) {
            T(cj4Var);
            new m(this, null).execute(cj4Var);
        }
    }

    public final void T(cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, cj4Var) == null) || cj4Var == null) {
            return;
        }
        int x = cj4Var.x();
        Iterator<ij4> it = cj4Var.n().iterator();
        while (it.hasNext()) {
            ij4 next = it.next();
            if (next != null && next.c() != null) {
                cj4 c2 = next.c();
                if (c2.d() == cj4Var.d() && c2.q() == cj4Var.q()) {
                    if (x == 7 && (next instanceof lj4)) {
                        ((lj4) next).f(true);
                    } else if (x == 1 && (next instanceof nj4)) {
                        ((nj4) next).f(true);
                    }
                }
            }
        }
        cj4Var.d0(false);
    }

    public void m(cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, cj4Var) == null) || cj4Var == null) {
            return;
        }
        if (cj4Var.x() == 9) {
            qj4.c().f(cj4Var);
        } else if (!this.f) {
            this.c.add(cj4Var);
        } else if (B(cj4Var)) {
        } else {
            J(cj4Var);
            new g(this, null).execute(cj4Var);
        }
    }

    public void n(List<cj4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (cj4 cj4Var : list) {
            if (cj4Var != null) {
                if (cj4Var.x() == 9) {
                    qj4.c().f(cj4Var);
                } else if (!B(cj4Var)) {
                    J(cj4Var);
                    arrayList.add(cj4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(cj4 cj4Var, long j2) {
        boolean z;
        lj4 lj4Var;
        cj4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, cj4Var, j2) == null) {
            Iterator<ij4> it = cj4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ij4 next = it.next();
                if ((next instanceof lj4) && (c2 = (lj4Var = (lj4) next).c()) != null && lj4Var.i() == j2 && c2.d() == cj4Var.d() && c2.q() == cj4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            lj4 lj4Var2 = new lj4(cj4Var, j2);
            lj4Var2.g(0L);
            lj4Var2.f(false);
            lj4Var2.h(cj4Var.w());
            cj4Var.a(lj4Var2);
        }
    }

    public final void p(cj4 cj4Var, long j2) {
        boolean z;
        nj4 nj4Var;
        cj4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, cj4Var, j2) == null) {
            Iterator<ij4> it = cj4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ij4 next = it.next();
                if ((next instanceof nj4) && (c2 = (nj4Var = (nj4) next).c()) != null && nj4Var.i() == j2 && c2.d() == cj4Var.d() && c2.q() == cj4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            nj4 nj4Var2 = new nj4(cj4Var, j2);
            nj4Var2.g(0L);
            nj4Var2.f(false);
            nj4Var2.h(cj4Var.w());
            cj4Var.a(nj4Var2);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.j != null && A() && this.g) {
            if (!s() || D()) {
                this.j.f(z(), C(), 0);
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? UtilHelper.isSameDay(ru4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? UtilHelper.isSameDay(x(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void t(cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, cj4Var) == null) || cj4Var == null) {
            return;
        }
        Iterator<ij4> it = cj4Var.n().iterator();
        while (it.hasNext()) {
            ij4 next = it.next();
            if (next != null && next.c() != null) {
                cj4 c2 = next.c();
                if (c2.d() == cj4Var.d() && c2.q() == cj4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<cj4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<cj4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    cj4 next2 = it2.next();
                    if (next2 != null && next2.d() == cj4Var.d() && next2.q() == cj4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        bj4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + cj4Var.d() + ",missionId=" + cj4Var.q());
    }

    public final cj4 u(cj4 cj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, cj4Var)) == null) {
            if (cj4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<cj4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (cj4 cj4Var2 : valueAt) {
                        if (cj4Var2 != null && cj4Var2.d() == cj4Var.d() && cj4Var2.q() == cj4Var.q()) {
                            return cj4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (cj4) invokeL.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.m : invokeV.intValue;
    }

    public final long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            long m2 = ru4.k().m("pref_key_active_config_info", 0L);
            this.n = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            List<cj4> list = this.b.get(i2);
            return (list == null || list.isEmpty()) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? !r() : invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ dj4 e;

        public f(dj4 dj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dj4Var;
            this.d = false;
        }

        public final void a(cj4 cj4Var, jk4.d dVar) {
            ArrayList<ij4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, cj4Var, dVar) == null) || cj4Var == null || dVar == null || (n = cj4Var.n()) == null) {
                return;
            }
            Iterator<ij4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                ij4 next = it.next();
                if (next instanceof nj4) {
                    nj4 nj4Var = (nj4) next;
                    if (this.b != 0 && nj4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(cj4Var);
                    }
                } else if (next instanceof lj4) {
                    lj4 lj4Var = (lj4) next;
                    if (!cj4Var.M() && lj4Var.d() == cj4Var.w()) {
                        if (this.b != 0 && lj4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && lj4Var.i() == this.b && !next.e()) {
                            if (next.b() >= cj4Var.f()) {
                                next.f(true);
                                cj4Var.J();
                            }
                            dVar.c(cj4Var);
                        }
                        int l = cj4Var.l();
                        int A = cj4Var.A();
                        long f = cj4Var.f() * cj4Var.A();
                        if (this.b != 0 && lj4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(cj4Var);
                            cj4Var.d0(true);
                        }
                    }
                } else if (next instanceof kj4) {
                    if (this.c != 0 && ((kj4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof jj4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(cj4 cj4Var, jk4.d dVar) {
            ArrayList<ij4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cj4Var, dVar) == null) || cj4Var == null || dVar == null || (n = cj4Var.n()) == null) {
                return;
            }
            Iterator<ij4> it = n.iterator();
            while (it.hasNext()) {
                ij4 next = it.next();
                if ((next instanceof mj4) && !((mj4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(cj4Var);
                    }
                    dVar.c(cj4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<cj4> list = (List) this.e.b.get(cj4.Y);
                List<cj4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                jk4.d dVar = new jk4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    aj4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<cj4> list, jk4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (cj4 cj4Var : list) {
                b(cj4Var, dVar);
            }
        }

        public final void e(List<cj4> list, jk4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (cj4 cj4Var : list) {
                a(cj4Var, dVar);
            }
        }

        public synchronized void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                synchronized (this) {
                    this.a = i;
                }
            }
        }

        public synchronized void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                synchronized (this) {
                    this.c = j;
                }
            }
        }

        public synchronized void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                synchronized (this) {
                    this.b = j;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.a == 0 || !this.e.e.get()) {
                    synchronized (this.e.e) {
                        try {
                            this.e.e.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                c();
            }
        }

        public /* synthetic */ f(dj4 dj4Var, a aVar) {
            this(dj4Var);
        }
    }

    public dj4() {
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
        this.a = Executors.newSingleThreadScheduledExecutor();
        this.b = new SparseArray<>();
        this.c = new LinkedList<>();
        this.d = new f(this, null);
        this.e = new AtomicBoolean(false);
        this.f = false;
        this.g = false;
        this.o = false;
        this.p = new a(this, 2921391);
        this.q = new b(this, 2001011);
        this.r = new c(this, 2001371);
        this.s = new d(this);
        this.t = new e(this);
        BdUniqueId gen = BdUniqueId.gen();
        this.h = gen;
        jk4 jk4Var = new jk4(gen);
        this.i = jk4Var;
        jk4Var.w(this.t);
        dk4 dk4Var = new dk4(this.h);
        this.j = dk4Var;
        dk4Var.g(this.s);
        new fk4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        pu4.e().f();
        qj4.c().d(this.h);
        Q();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
