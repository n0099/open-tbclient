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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.repackage.uj4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class oi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<ni4>> b;
    public final LinkedList<ni4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public uj4 i;
    public oj4 j;
    public qj4 k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public mj4<nj4> t;
    public gm4 u;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(oi4 oi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var, Integer.valueOf(i)};
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
            this.a = oi4Var;
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
                    this.a.m((ni4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(oi4 oi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var, Integer.valueOf(i)};
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
            this.a = oi4Var;
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
        public final /* synthetic */ oi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(oi4 oi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var, Integer.valueOf(i)};
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
            this.a = oi4Var;
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
    public class d implements mj4<nj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi4 a;

        public d(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mj4
        /* renamed from: b */
        public void a(nj4 nj4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nj4Var) == null) || nj4Var == null || (activeCenterData = nj4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            ni4 ni4Var = new ni4();
            ni4Var.O(nj4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ni4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fm4
        /* renamed from: c */
        public void onSuccess(nj4 nj4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nj4Var) == null) || nj4Var == null) {
                return;
            }
            this.a.n(nj4Var.b());
        }

        @Override // com.repackage.fm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements gm4<ni4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi4 a;

        public e(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gm4
        /* renamed from: b */
        public void a(ni4 ni4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni4Var) == null) || ni4Var == null) {
                return;
            }
            ni4 w = this.a.w(ni4Var);
            if (w != null && w.z) {
                w.R();
                this.a.U(w);
                return;
            }
            zi4.b().h(w);
            if (w != null && w.x() == 7) {
                w.H();
                int F = w.F();
                int w2 = w.w();
                if (F <= 1 || F <= w2) {
                    this.a.I(w);
                } else {
                    this.a.U(w);
                }
            } else if (w == null || w.x() != 8) {
                this.a.I(ni4Var);
            } else {
                this.a.I(w);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<ni4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
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
        public Void doInBackground(ni4... ni4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ni4VarArr)) == null) {
                if (ni4VarArr == null || ni4VarArr.length <= 0 || ni4VarArr[0] == null) {
                    return null;
                }
                li4.g().a(ni4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(oi4 oi4Var, a aVar) {
            this(oi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<List<ni4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
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
        public Void doInBackground(List<ni4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                li4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(oi4 oi4Var, a aVar) {
            this(oi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<ni4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
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
        public Void doInBackground(ni4... ni4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ni4VarArr)) == null) {
                if (ni4VarArr == null || ni4VarArr.length <= 0 || ni4VarArr[0] == null) {
                    return null;
                }
                li4.g().e(ni4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(oi4 oi4Var, a aVar) {
            this(oi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Pair<ni4, ni4>, Integer, Pair<ni4, ni4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi4 a;

        public j(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<ni4, ni4> doInBackground(Pair<ni4, ni4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<ni4, ni4> pair = pairArr[0];
                ni4 ni4Var = (ni4) pair.first;
                ni4 ni4Var2 = (ni4) pair.second;
                if (ni4Var2 != null) {
                    li4.g().e(ni4Var2);
                }
                if (ni4Var != null) {
                    li4.g().a(ni4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<ni4, ni4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            ni4 ni4Var = (ni4) pair.first;
            ni4 ni4Var2 = (ni4) pair.second;
            if (ni4Var2 != null) {
                this.a.v(ni4Var2);
            }
            if (ni4Var != null) {
                this.a.L(ni4Var);
            }
        }

        public /* synthetic */ j(oi4 oi4Var, a aVar) {
            this(oi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<ni4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi4 a;

        public k(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<ni4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<ni4> linkedList = new LinkedList<>();
                linkedList.addAll(li4.g().f());
                Iterator<ni4> it = linkedList.iterator();
                while (it.hasNext()) {
                    ni4 next = it.next();
                    if (next != null && next.M()) {
                        li4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.n0();
                        li4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<ni4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<ni4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        ni4 next = it.next();
                        if (next.h() != null) {
                            this.a.L(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(oi4 oi4Var, a aVar) {
            this(oi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final oi4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-127194993, "Lcom/repackage/oi4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-127194993, "Lcom/repackage/oi4$l;");
                    return;
                }
            }
            a = new oi4(null);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<ni4, Integer, ni4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi4 a;

        public m(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ni4 doInBackground(ni4... ni4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ni4VarArr)) == null) {
                if (ni4VarArr == null || ni4VarArr.length <= 0 || ni4VarArr[0] == null) {
                    return null;
                }
                ni4 ni4Var = ni4VarArr[0];
                li4.g().i(ni4Var);
                return ni4Var;
            }
            return (ni4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ni4 ni4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni4Var) == null) && ni4Var != null && ni4Var.z) {
                ni4Var.z = false;
                oi4 oi4Var = this.a;
                oi4Var.R(oi4Var.l, this.a.m);
            }
        }

        public /* synthetic */ m(oi4 oi4Var, a aVar) {
            this(oi4Var);
        }
    }

    public /* synthetic */ oi4(a aVar) {
        this();
    }

    public static final oi4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (oi4) invokeV.objValue;
    }

    public boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<ni4> list = this.b.get(i2);
            return (list == null || list.isEmpty()) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !s() : invokeV.booleanValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public final boolean D(ni4 ni4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ni4Var)) == null) {
            if (ni4Var == null) {
                return false;
            }
            int[] h2 = ni4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<ni4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (ni4 ni4Var2 : list) {
                    if (ni4Var2 != null && ni4Var2.d() == ni4Var.d() && ni4Var2.q() == ni4Var.q()) {
                        if (ni4Var2.M()) {
                            J(ni4Var, ni4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && UbsABTestHelper.isRedPackageShowSecondTime() && vt4.k().l("app_restart_times", 0) > 1;
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.compareAndSet(true, false);
            this.d.f(0);
            this.d.h(0L);
            this.d.g(0L);
            uj4 uj4Var = this.i;
            if (uj4Var != null) {
                uj4Var.m();
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            List<ni4> list = this.b.get(ni4.W);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (ni4 ni4Var : list) {
                Iterator<ti4> it = ni4Var.n().iterator();
                while (it.hasNext()) {
                    ti4 next = it.next();
                    if (next instanceof xi4) {
                        xi4 xi4Var = (xi4) next;
                        if (!next.e()) {
                            xi4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(ni4.W);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void I(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ni4Var) == null) {
            v(ni4Var);
            new i(this, null).execute(ni4Var);
        }
    }

    public final void J(ni4 ni4Var, ni4 ni4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, ni4Var, ni4Var2) == null) {
            v(ni4Var2);
            new j(this, null).execute(new Pair(ni4Var, ni4Var2));
        }
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j != null && C() && this.g) {
                this.j.f(B(), E(), 1);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L(ni4 ni4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ni4Var) == null) {
            for (int i2 : ni4Var.h()) {
                List<ni4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(ni4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(ni4Var);
                }
            }
        }
    }

    public void M(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C()) {
            this.n = i2;
            long j3 = this.m;
            if (j3 > 0 && this.l > 0 && (j2 == 0 || j2 != j3)) {
                T(this.l, this.m);
                this.m = 0L;
                this.l = 0;
            }
            O();
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.p = z;
        }
    }

    public void O() {
        int i2;
        List<ni4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && C() && this.f && (list = this.b.get((i2 = ni4.W))) != null && !list.isEmpty()) {
            boolean z = false;
            for (ni4 ni4Var : list) {
                if (ni4Var.x() == 8) {
                    Iterator<ti4> it = ni4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ti4 next = it.next();
                        ni4 c2 = next.c();
                        if (c2 != null && (next instanceof xi4) && c2.d() == ni4Var.d() && c2.q() == ni4Var.q()) {
                            ((xi4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        xi4 xi4Var = new xi4(ni4Var);
                        xi4Var.g(0L);
                        xi4Var.f(false);
                        ni4Var.a(xi4Var);
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

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && C() && i2 != 0 && this.f) {
            this.l = i2;
            List<ni4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (ni4 ni4Var : list) {
                if (ni4Var.x() == 4) {
                    Iterator<ti4> it = ni4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ti4 next = it.next();
                        if ((next instanceof ui4) && next.c().d() == ni4Var.d() && next.c().q() == ni4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ui4 ui4Var = new ui4(ni4Var);
                        ui4Var.g(0L);
                        ui4Var.f(false);
                        ni4Var.a(ui4Var);
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

    public void Q(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C() && i2 != 0 && j2 != 0 && this.f) {
            this.l = i2;
            List<ni4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (ni4 ni4Var : list) {
                if (ni4Var.x() == 2) {
                    Iterator<ti4> it = ni4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ti4 next = it.next();
                        if ((next instanceof vi4) && next.c().d() == ni4Var.d() && next.c().q() == ni4Var.q() && ((vi4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        vi4 vi4Var = new vi4(ni4Var, j2);
                        vi4Var.g(0L);
                        vi4Var.f(false);
                        vi4Var.h(ni4Var.w());
                        ni4Var.a(vi4Var);
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

    public void R(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C() && i2 != 0 && j2 != 0 && this.f) {
            this.l = i2;
            List<ni4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (ni4 ni4Var : list) {
                if (ni4Var.x() == 1) {
                    p(ni4Var, j2);
                } else if (ni4Var.x() == 7 && !ni4Var.J(j2)) {
                    o(ni4Var, j2);
                }
            }
            this.d.f(i2);
            this.d.h(j2);
            this.m = j2;
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.scheduleWithFixedDelay(this.d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public void T(int i2, long j2) {
        List<ni4> list;
        wi4 wi4Var;
        ni4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (ni4 ni4Var : list) {
            if (ni4Var.x() == 7) {
                Iterator<ti4> it = ni4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ti4 next = it.next();
                        if ((next instanceof wi4) && (c2 = (wi4Var = (wi4) next).c()) != null && wi4Var.i() == j2 && c2.d() == ni4Var.d() && c2.q() == ni4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void U(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, ni4Var) == null) {
            V(ni4Var);
            new m(this, null).execute(ni4Var);
        }
    }

    public final void V(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, ni4Var) == null) || ni4Var == null) {
            return;
        }
        int x = ni4Var.x();
        Iterator<ti4> it = ni4Var.n().iterator();
        while (it.hasNext()) {
            ti4 next = it.next();
            if (next != null && next.c() != null) {
                ni4 c2 = next.c();
                if (c2.d() == ni4Var.d() && c2.q() == ni4Var.q()) {
                    if (x == 7 && (next instanceof wi4)) {
                        ((wi4) next).f(true);
                    } else if (x == 1 && (next instanceof yi4)) {
                        ((yi4) next).f(true);
                    }
                }
            }
        }
        ni4Var.c0(false);
    }

    public void m(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, ni4Var) == null) || ni4Var == null) {
            return;
        }
        if (ni4Var.x() == 9) {
            bj4.c().f(ni4Var);
        } else if (!this.f) {
            this.c.add(ni4Var);
        } else if (D(ni4Var)) {
        } else {
            L(ni4Var);
            new g(this, null).execute(ni4Var);
        }
    }

    public void n(List<ni4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ni4 ni4Var : list) {
            if (ni4Var != null) {
                if (ni4Var.x() == 9) {
                    bj4.c().f(ni4Var);
                } else if (!D(ni4Var)) {
                    L(ni4Var);
                    arrayList.add(ni4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(ni4 ni4Var, long j2) {
        boolean z;
        wi4 wi4Var;
        ni4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, ni4Var, j2) == null) {
            Iterator<ti4> it = ni4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ti4 next = it.next();
                if ((next instanceof wi4) && (c2 = (wi4Var = (wi4) next).c()) != null && wi4Var.i() == j2 && c2.d() == ni4Var.d() && c2.q() == ni4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            wi4 wi4Var2 = new wi4(ni4Var, j2);
            wi4Var2.g(0L);
            wi4Var2.f(false);
            wi4Var2.h(ni4Var.w());
            ni4Var.a(wi4Var2);
        }
    }

    public final void p(ni4 ni4Var, long j2) {
        boolean z;
        yi4 yi4Var;
        ni4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048601, this, ni4Var, j2) == null) {
            Iterator<ti4> it = ni4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ti4 next = it.next();
                if ((next instanceof yi4) && (c2 = (yi4Var = (yi4) next).c()) != null && yi4Var.i() == j2 && c2.d() == ni4Var.d() && c2.q() == ni4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            yi4 yi4Var2 = new yi4(ni4Var, j2);
            yi4Var2.g(0L);
            yi4Var2.f(false);
            yi4Var2.h(ni4Var.w());
            ni4Var.a(yi4Var2);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.j != null && C() && this.g) {
            if (!t() || F()) {
                this.j.f(B(), E(), 0);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.k != null && C()) {
            this.k.d();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? UtilHelper.isSameDay(vt4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? UtilHelper.isSameDay(z(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? UtilHelper.isSameDay(vt4.k().m("pref_key_last_popup_time", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, ni4Var) == null) || ni4Var == null) {
            return;
        }
        Iterator<ti4> it = ni4Var.n().iterator();
        while (it.hasNext()) {
            ti4 next = it.next();
            if (next != null && next.c() != null) {
                ni4 c2 = next.c();
                if (c2.d() == ni4Var.d() && c2.q() == ni4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<ni4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<ni4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    ni4 next2 = it2.next();
                    if (next2 != null && next2.d() == ni4Var.d() && next2.q() == ni4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        mi4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + ni4Var.d() + ",missionId=" + ni4Var.q());
    }

    public final ni4 w(ni4 ni4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, ni4Var)) == null) {
            if (ni4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<ni4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (ni4 ni4Var2 : valueAt) {
                        if (ni4Var2 != null && ni4Var2.d() == ni4Var.d() && ni4Var2.q() == ni4Var.q()) {
                            return ni4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (ni4) invokeL.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.n : invokeV.intValue;
    }

    public final long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            long m2 = vt4.k().m("pref_key_active_config_info", 0L);
            this.o = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ oi4 e;

        public f(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oi4Var;
            this.d = false;
        }

        public final void a(ni4 ni4Var, uj4.d dVar) {
            ArrayList<ti4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, ni4Var, dVar) == null) || ni4Var == null || dVar == null || (n = ni4Var.n()) == null) {
                return;
            }
            Iterator<ti4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                ti4 next = it.next();
                if (next instanceof yi4) {
                    yi4 yi4Var = (yi4) next;
                    if (this.b != 0 && yi4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(ni4Var);
                    }
                } else if (next instanceof wi4) {
                    wi4 wi4Var = (wi4) next;
                    if (!ni4Var.L() && wi4Var.d() == ni4Var.w()) {
                        if (this.b != 0 && wi4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && wi4Var.i() == this.b && !next.e()) {
                            if (next.b() >= ni4Var.f()) {
                                next.f(true);
                                ni4Var.I();
                            }
                            dVar.c(ni4Var);
                        }
                        int l = ni4Var.l();
                        int A = ni4Var.A();
                        long f = ni4Var.f() * ni4Var.A();
                        if (this.b != 0 && wi4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(ni4Var);
                            ni4Var.c0(true);
                        }
                    }
                } else if (next instanceof vi4) {
                    if (this.c != 0 && ((vi4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof ui4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(ni4 ni4Var, uj4.d dVar) {
            ArrayList<ti4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni4Var, dVar) == null) || ni4Var == null || dVar == null || (n = ni4Var.n()) == null) {
                return;
            }
            Iterator<ti4> it = n.iterator();
            while (it.hasNext()) {
                ti4 next = it.next();
                if ((next instanceof xi4) && !((xi4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(ni4Var);
                    }
                    dVar.c(ni4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<ni4> list = (List) this.e.b.get(ni4.W);
                List<ni4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                uj4.d dVar = new uj4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    li4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<ni4> list, uj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (ni4 ni4Var : list) {
                b(ni4Var, dVar);
            }
        }

        public final void e(List<ni4> list, uj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (ni4 ni4Var : list) {
                a(ni4Var, dVar);
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

        public /* synthetic */ f(oi4 oi4Var, a aVar) {
            this(oi4Var);
        }
    }

    public oi4() {
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
        this.p = false;
        this.q = new a(this, 2921391);
        this.r = new b(this, 2001011);
        this.s = new c(this, 2001371);
        this.t = new d(this);
        this.u = new e(this);
        BdUniqueId gen = BdUniqueId.gen();
        this.h = gen;
        uj4 uj4Var = new uj4(gen);
        this.i = uj4Var;
        uj4Var.w(this.u);
        oj4 oj4Var = new oj4(this.h);
        this.j = oj4Var;
        oj4Var.g(this.t);
        this.k = new qj4(this.h);
        this.s.setTag(this.h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        tt4.e().f();
        bj4.c().d(this.h);
        S();
        if (C()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
