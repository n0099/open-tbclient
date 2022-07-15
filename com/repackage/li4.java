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
import com.repackage.rj4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class li4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<ki4>> b;
    public final LinkedList<ki4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public rj4 i;
    public lj4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public jj4<kj4> s;
    public em4 t;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(li4 li4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var, Integer.valueOf(i)};
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
            this.a = li4Var;
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
                    this.a.m((ki4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(li4 li4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var, Integer.valueOf(i)};
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
            this.a = li4Var;
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
        public final /* synthetic */ li4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(li4 li4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var, Integer.valueOf(i)};
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
            this.a = li4Var;
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
    public class d implements jj4<kj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li4 a;

        public d(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jj4
        /* renamed from: b */
        public void a(kj4 kj4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kj4Var) == null) || kj4Var == null || (activeCenterData = kj4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            ki4 ki4Var = new ki4();
            ki4Var.P(kj4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ki4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.dm4
        /* renamed from: c */
        public void onSuccess(kj4 kj4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kj4Var) == null) || kj4Var == null) {
                return;
            }
            this.a.n(kj4Var.b());
        }

        @Override // com.repackage.dm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements em4<ki4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li4 a;

        public e(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.em4
        /* renamed from: b */
        public void a(ki4 ki4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki4Var) == null) || ki4Var == null) {
                return;
            }
            ki4 u = this.a.u(ki4Var);
            if (u != null && u.z) {
                u.S();
                this.a.S(u);
                return;
            }
            wi4.b().h(u);
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
                this.a.G(ki4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<ki4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
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
        public Void doInBackground(ki4... ki4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ki4VarArr)) == null) {
                if (ki4VarArr == null || ki4VarArr.length <= 0 || ki4VarArr[0] == null) {
                    return null;
                }
                ii4.g().a(ki4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(li4 li4Var, a aVar) {
            this(li4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<List<ki4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
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
        public Void doInBackground(List<ki4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                ii4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(li4 li4Var, a aVar) {
            this(li4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<ki4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
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
        public Void doInBackground(ki4... ki4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ki4VarArr)) == null) {
                if (ki4VarArr == null || ki4VarArr.length <= 0 || ki4VarArr[0] == null) {
                    return null;
                }
                ii4.g().e(ki4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(li4 li4Var, a aVar) {
            this(li4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Pair<ki4, ki4>, Integer, Pair<ki4, ki4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li4 a;

        public j(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<ki4, ki4> doInBackground(Pair<ki4, ki4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<ki4, ki4> pair = pairArr[0];
                ki4 ki4Var = (ki4) pair.first;
                ki4 ki4Var2 = (ki4) pair.second;
                if (ki4Var2 != null) {
                    ii4.g().e(ki4Var2);
                }
                if (ki4Var != null) {
                    ii4.g().a(ki4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<ki4, ki4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            ki4 ki4Var = (ki4) pair.first;
            ki4 ki4Var2 = (ki4) pair.second;
            if (ki4Var2 != null) {
                this.a.t(ki4Var2);
            }
            if (ki4Var != null) {
                this.a.J(ki4Var);
            }
        }

        public /* synthetic */ j(li4 li4Var, a aVar) {
            this(li4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<ki4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li4 a;

        public k(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<ki4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<ki4> linkedList = new LinkedList<>();
                linkedList.addAll(ii4.g().f());
                Iterator<ki4> it = linkedList.iterator();
                while (it.hasNext()) {
                    ki4 next = it.next();
                    if (next != null && next.N()) {
                        ii4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        ii4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<ki4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<ki4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        ki4 next = it.next();
                        if (next.h() != null) {
                            this.a.J(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(li4 li4Var, a aVar) {
            this(li4Var);
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final li4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-213082446, "Lcom/repackage/li4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-213082446, "Lcom/repackage/li4$l;");
                    return;
                }
            }
            a = new li4(null);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<ki4, Integer, ki4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li4 a;

        public m(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ki4 doInBackground(ki4... ki4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ki4VarArr)) == null) {
                if (ki4VarArr == null || ki4VarArr.length <= 0 || ki4VarArr[0] == null) {
                    return null;
                }
                ki4 ki4Var = ki4VarArr[0];
                ii4.g().i(ki4Var);
                return ki4Var;
            }
            return (ki4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ki4 ki4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki4Var) == null) && ki4Var != null && ki4Var.z) {
                ki4Var.z = false;
                li4 li4Var = this.a;
                li4Var.P(li4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(li4 li4Var, a aVar) {
            this(li4Var);
        }
    }

    public /* synthetic */ li4(a aVar) {
        this();
    }

    public static final li4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (li4) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public final boolean B(ki4 ki4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki4Var)) == null) {
            if (ki4Var == null) {
                return false;
            }
            int[] h2 = ki4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<ki4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (ki4 ki4Var2 : list) {
                    if (ki4Var2 != null && ki4Var2.d() == ki4Var.d() && ki4Var2.q() == ki4Var.q()) {
                        if (ki4Var2.N()) {
                            H(ki4Var, ki4Var2);
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
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && xt4.k().l("app_restart_times", 0) > 1;
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
            rj4 rj4Var = this.i;
            if (rj4Var != null) {
                rj4Var.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<ki4> list = this.b.get(ki4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (ki4 ki4Var : list) {
                Iterator<qi4> it = ki4Var.n().iterator();
                while (it.hasNext()) {
                    qi4 next = it.next();
                    if (next instanceof ui4) {
                        ui4 ui4Var = (ui4) next;
                        if (!next.e()) {
                            ui4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(ki4.Y);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void G(ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ki4Var) == null) {
            t(ki4Var);
            new i(this, null).execute(ki4Var);
        }
    }

    public final void H(ki4 ki4Var, ki4 ki4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, ki4Var, ki4Var2) == null) {
            t(ki4Var2);
            new j(this, null).execute(new Pair(ki4Var, ki4Var2));
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

    public final void J(ki4 ki4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ki4Var) == null) {
            for (int i2 : ki4Var.h()) {
                List<ki4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(ki4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(ki4Var);
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
        List<ki4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && A() && this.f && (list = this.b.get((i2 = ki4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (ki4 ki4Var : list) {
                if (ki4Var.x() == 8) {
                    Iterator<qi4> it = ki4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        qi4 next = it.next();
                        ki4 c2 = next.c();
                        if (c2 != null && (next instanceof ui4) && c2.d() == ki4Var.d() && c2.q() == ki4Var.q()) {
                            ((ui4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ui4 ui4Var = new ui4(ki4Var);
                        ui4Var.g(0L);
                        ui4Var.f(false);
                        ki4Var.a(ui4Var);
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
            List<ki4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (ki4 ki4Var : list) {
                if (ki4Var.x() == 4) {
                    Iterator<qi4> it = ki4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        qi4 next = it.next();
                        if ((next instanceof ri4) && next.c().d() == ki4Var.d() && next.c().q() == ki4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ri4 ri4Var = new ri4(ki4Var);
                        ri4Var.g(0L);
                        ri4Var.f(false);
                        ki4Var.a(ri4Var);
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
            List<ki4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (ki4 ki4Var : list) {
                if (ki4Var.x() == 2) {
                    Iterator<qi4> it = ki4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        qi4 next = it.next();
                        if ((next instanceof si4) && next.c().d() == ki4Var.d() && next.c().q() == ki4Var.q() && ((si4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        si4 si4Var = new si4(ki4Var, j2);
                        si4Var.g(0L);
                        si4Var.f(false);
                        si4Var.h(ki4Var.w());
                        ki4Var.a(si4Var);
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
            List<ki4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (ki4 ki4Var : list) {
                if (ki4Var.x() == 1) {
                    p(ki4Var, j2);
                } else if (ki4Var.x() == 7 && !ki4Var.K(j2)) {
                    o(ki4Var, j2);
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
        List<ki4> list;
        ti4 ti4Var;
        ki4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (ki4 ki4Var : list) {
            if (ki4Var.x() == 7) {
                Iterator<qi4> it = ki4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        qi4 next = it.next();
                        if ((next instanceof ti4) && (c2 = (ti4Var = (ti4) next).c()) != null && ti4Var.i() == j2 && c2.d() == ki4Var.d() && c2.q() == ki4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ki4Var) == null) {
            T(ki4Var);
            new m(this, null).execute(ki4Var);
        }
    }

    public final void T(ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, ki4Var) == null) || ki4Var == null) {
            return;
        }
        int x = ki4Var.x();
        Iterator<qi4> it = ki4Var.n().iterator();
        while (it.hasNext()) {
            qi4 next = it.next();
            if (next != null && next.c() != null) {
                ki4 c2 = next.c();
                if (c2.d() == ki4Var.d() && c2.q() == ki4Var.q()) {
                    if (x == 7 && (next instanceof ti4)) {
                        ((ti4) next).f(true);
                    } else if (x == 1 && (next instanceof vi4)) {
                        ((vi4) next).f(true);
                    }
                }
            }
        }
        ki4Var.d0(false);
    }

    public void m(ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, ki4Var) == null) || ki4Var == null) {
            return;
        }
        if (ki4Var.x() == 9) {
            yi4.c().f(ki4Var);
        } else if (!this.f) {
            this.c.add(ki4Var);
        } else if (B(ki4Var)) {
        } else {
            J(ki4Var);
            new g(this, null).execute(ki4Var);
        }
    }

    public void n(List<ki4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ki4 ki4Var : list) {
            if (ki4Var != null) {
                if (ki4Var.x() == 9) {
                    yi4.c().f(ki4Var);
                } else if (!B(ki4Var)) {
                    J(ki4Var);
                    arrayList.add(ki4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(ki4 ki4Var, long j2) {
        boolean z;
        ti4 ti4Var;
        ki4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, ki4Var, j2) == null) {
            Iterator<qi4> it = ki4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                qi4 next = it.next();
                if ((next instanceof ti4) && (c2 = (ti4Var = (ti4) next).c()) != null && ti4Var.i() == j2 && c2.d() == ki4Var.d() && c2.q() == ki4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            ti4 ti4Var2 = new ti4(ki4Var, j2);
            ti4Var2.g(0L);
            ti4Var2.f(false);
            ti4Var2.h(ki4Var.w());
            ki4Var.a(ti4Var2);
        }
    }

    public final void p(ki4 ki4Var, long j2) {
        boolean z;
        vi4 vi4Var;
        ki4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, ki4Var, j2) == null) {
            Iterator<qi4> it = ki4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                qi4 next = it.next();
                if ((next instanceof vi4) && (c2 = (vi4Var = (vi4) next).c()) != null && vi4Var.i() == j2 && c2.d() == ki4Var.d() && c2.q() == ki4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            vi4 vi4Var2 = new vi4(ki4Var, j2);
            vi4Var2.g(0L);
            vi4Var2.f(false);
            vi4Var2.h(ki4Var.w());
            ki4Var.a(vi4Var2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? UtilHelper.isSameDay(xt4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? UtilHelper.isSameDay(x(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void t(ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, ki4Var) == null) || ki4Var == null) {
            return;
        }
        Iterator<qi4> it = ki4Var.n().iterator();
        while (it.hasNext()) {
            qi4 next = it.next();
            if (next != null && next.c() != null) {
                ki4 c2 = next.c();
                if (c2.d() == ki4Var.d() && c2.q() == ki4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<ki4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<ki4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    ki4 next2 = it2.next();
                    if (next2 != null && next2.d() == ki4Var.d() && next2.q() == ki4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        ji4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + ki4Var.d() + ",missionId=" + ki4Var.q());
    }

    public final ki4 u(ki4 ki4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, ki4Var)) == null) {
            if (ki4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<ki4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (ki4 ki4Var2 : valueAt) {
                        if (ki4Var2 != null && ki4Var2.d() == ki4Var.d() && ki4Var2.q() == ki4Var.q()) {
                            return ki4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (ki4) invokeL.objValue;
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
            long m2 = xt4.k().m("pref_key_active_config_info", 0L);
            this.n = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            List<ki4> list = this.b.get(i2);
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
        public final /* synthetic */ li4 e;

        public f(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = li4Var;
            this.d = false;
        }

        public final void a(ki4 ki4Var, rj4.d dVar) {
            ArrayList<qi4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, ki4Var, dVar) == null) || ki4Var == null || dVar == null || (n = ki4Var.n()) == null) {
                return;
            }
            Iterator<qi4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                qi4 next = it.next();
                if (next instanceof vi4) {
                    vi4 vi4Var = (vi4) next;
                    if (this.b != 0 && vi4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(ki4Var);
                    }
                } else if (next instanceof ti4) {
                    ti4 ti4Var = (ti4) next;
                    if (!ki4Var.M() && ti4Var.d() == ki4Var.w()) {
                        if (this.b != 0 && ti4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && ti4Var.i() == this.b && !next.e()) {
                            if (next.b() >= ki4Var.f()) {
                                next.f(true);
                                ki4Var.J();
                            }
                            dVar.c(ki4Var);
                        }
                        int l = ki4Var.l();
                        int A = ki4Var.A();
                        long f = ki4Var.f() * ki4Var.A();
                        if (this.b != 0 && ti4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(ki4Var);
                            ki4Var.d0(true);
                        }
                    }
                } else if (next instanceof si4) {
                    if (this.c != 0 && ((si4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof ri4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(ki4 ki4Var, rj4.d dVar) {
            ArrayList<qi4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki4Var, dVar) == null) || ki4Var == null || dVar == null || (n = ki4Var.n()) == null) {
                return;
            }
            Iterator<qi4> it = n.iterator();
            while (it.hasNext()) {
                qi4 next = it.next();
                if ((next instanceof ui4) && !((ui4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(ki4Var);
                    }
                    dVar.c(ki4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<ki4> list = (List) this.e.b.get(ki4.Y);
                List<ki4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                rj4.d dVar = new rj4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    ii4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<ki4> list, rj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (ki4 ki4Var : list) {
                b(ki4Var, dVar);
            }
        }

        public final void e(List<ki4> list, rj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (ki4 ki4Var : list) {
                a(ki4Var, dVar);
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

        public /* synthetic */ f(li4 li4Var, a aVar) {
            this(li4Var);
        }
    }

    public li4() {
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
        rj4 rj4Var = new rj4(gen);
        this.i = rj4Var;
        rj4Var.w(this.t);
        lj4 lj4Var = new lj4(this.h);
        this.j = lj4Var;
        lj4Var.g(this.s);
        new nj4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        vt4.e().f();
        yi4.c().d(this.h);
        Q();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
