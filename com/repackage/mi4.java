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
import com.repackage.sj4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class mi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<li4>> b;
    public final LinkedList<li4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public sj4 i;
    public mj4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public kj4<lj4> s;
    public fm4 t;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mi4 mi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var, Integer.valueOf(i)};
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
            this.a = mi4Var;
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
                    this.a.m((li4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mi4 mi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var, Integer.valueOf(i)};
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
            this.a = mi4Var;
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
        public final /* synthetic */ mi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(mi4 mi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var, Integer.valueOf(i)};
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
            this.a = mi4Var;
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
    public class d implements kj4<lj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi4 a;

        public d(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.kj4
        /* renamed from: b */
        public void a(lj4 lj4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lj4Var) == null) || lj4Var == null || (activeCenterData = lj4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            li4 li4Var = new li4();
            li4Var.P(lj4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(li4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.em4
        /* renamed from: c */
        public void onSuccess(lj4 lj4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lj4Var) == null) || lj4Var == null) {
                return;
            }
            this.a.n(lj4Var.b());
        }

        @Override // com.repackage.em4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements fm4<li4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi4 a;

        public e(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fm4
        /* renamed from: b */
        public void a(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li4Var) == null) || li4Var == null) {
                return;
            }
            li4 u = this.a.u(li4Var);
            if (u != null && u.z) {
                u.S();
                this.a.S(u);
                return;
            }
            xi4.b().h(u);
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
                this.a.G(li4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<li4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
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
        public Void doInBackground(li4... li4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, li4VarArr)) == null) {
                if (li4VarArr == null || li4VarArr.length <= 0 || li4VarArr[0] == null) {
                    return null;
                }
                ji4.g().a(li4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(mi4 mi4Var, a aVar) {
            this(mi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<List<li4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
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
        public Void doInBackground(List<li4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                ji4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(mi4 mi4Var, a aVar) {
            this(mi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<li4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
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
        public Void doInBackground(li4... li4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, li4VarArr)) == null) {
                if (li4VarArr == null || li4VarArr.length <= 0 || li4VarArr[0] == null) {
                    return null;
                }
                ji4.g().e(li4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(mi4 mi4Var, a aVar) {
            this(mi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Pair<li4, li4>, Integer, Pair<li4, li4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi4 a;

        public j(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<li4, li4> doInBackground(Pair<li4, li4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<li4, li4> pair = pairArr[0];
                li4 li4Var = (li4) pair.first;
                li4 li4Var2 = (li4) pair.second;
                if (li4Var2 != null) {
                    ji4.g().e(li4Var2);
                }
                if (li4Var != null) {
                    ji4.g().a(li4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<li4, li4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            li4 li4Var = (li4) pair.first;
            li4 li4Var2 = (li4) pair.second;
            if (li4Var2 != null) {
                this.a.t(li4Var2);
            }
            if (li4Var != null) {
                this.a.J(li4Var);
            }
        }

        public /* synthetic */ j(mi4 mi4Var, a aVar) {
            this(mi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<li4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi4 a;

        public k(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<li4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<li4> linkedList = new LinkedList<>();
                linkedList.addAll(ji4.g().f());
                Iterator<li4> it = linkedList.iterator();
                while (it.hasNext()) {
                    li4 next = it.next();
                    if (next != null && next.N()) {
                        ji4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        ji4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<li4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<li4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        li4 next = it.next();
                        if (next.h() != null) {
                            this.a.J(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(mi4 mi4Var, a aVar) {
            this(mi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final mi4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-184453295, "Lcom/repackage/mi4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-184453295, "Lcom/repackage/mi4$l;");
                    return;
                }
            }
            a = new mi4(null);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<li4, Integer, li4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi4 a;

        public m(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public li4 doInBackground(li4... li4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, li4VarArr)) == null) {
                if (li4VarArr == null || li4VarArr.length <= 0 || li4VarArr[0] == null) {
                    return null;
                }
                li4 li4Var = li4VarArr[0];
                ji4.g().i(li4Var);
                return li4Var;
            }
            return (li4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(li4 li4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li4Var) == null) && li4Var != null && li4Var.z) {
                li4Var.z = false;
                mi4 mi4Var = this.a;
                mi4Var.P(mi4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(mi4 mi4Var, a aVar) {
            this(mi4Var);
        }
    }

    public /* synthetic */ mi4(a aVar) {
        this();
    }

    public static final mi4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (mi4) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public final boolean B(li4 li4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li4Var)) == null) {
            if (li4Var == null) {
                return false;
            }
            int[] h2 = li4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<li4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (li4 li4Var2 : list) {
                    if (li4Var2 != null && li4Var2.d() == li4Var.d() && li4Var2.q() == li4Var.q()) {
                        if (li4Var2.N()) {
                            H(li4Var, li4Var2);
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
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && yt4.k().l("app_restart_times", 0) > 1;
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
            sj4 sj4Var = this.i;
            if (sj4Var != null) {
                sj4Var.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<li4> list = this.b.get(li4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (li4 li4Var : list) {
                Iterator<ri4> it = li4Var.n().iterator();
                while (it.hasNext()) {
                    ri4 next = it.next();
                    if (next instanceof vi4) {
                        vi4 vi4Var = (vi4) next;
                        if (!next.e()) {
                            vi4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(li4.Y);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void G(li4 li4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, li4Var) == null) {
            t(li4Var);
            new i(this, null).execute(li4Var);
        }
    }

    public final void H(li4 li4Var, li4 li4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, li4Var, li4Var2) == null) {
            t(li4Var2);
            new j(this, null).execute(new Pair(li4Var, li4Var2));
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

    public final void J(li4 li4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, li4Var) == null) {
            for (int i2 : li4Var.h()) {
                List<li4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(li4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(li4Var);
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
        List<li4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && A() && this.f && (list = this.b.get((i2 = li4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (li4 li4Var : list) {
                if (li4Var.x() == 8) {
                    Iterator<ri4> it = li4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ri4 next = it.next();
                        li4 c2 = next.c();
                        if (c2 != null && (next instanceof vi4) && c2.d() == li4Var.d() && c2.q() == li4Var.q()) {
                            ((vi4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        vi4 vi4Var = new vi4(li4Var);
                        vi4Var.g(0L);
                        vi4Var.f(false);
                        li4Var.a(vi4Var);
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
            List<li4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (li4 li4Var : list) {
                if (li4Var.x() == 4) {
                    Iterator<ri4> it = li4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ri4 next = it.next();
                        if ((next instanceof si4) && next.c().d() == li4Var.d() && next.c().q() == li4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        si4 si4Var = new si4(li4Var);
                        si4Var.g(0L);
                        si4Var.f(false);
                        li4Var.a(si4Var);
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
            List<li4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (li4 li4Var : list) {
                if (li4Var.x() == 2) {
                    Iterator<ri4> it = li4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ri4 next = it.next();
                        if ((next instanceof ti4) && next.c().d() == li4Var.d() && next.c().q() == li4Var.q() && ((ti4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ti4 ti4Var = new ti4(li4Var, j2);
                        ti4Var.g(0L);
                        ti4Var.f(false);
                        ti4Var.h(li4Var.w());
                        li4Var.a(ti4Var);
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
            List<li4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (li4 li4Var : list) {
                if (li4Var.x() == 1) {
                    p(li4Var, j2);
                } else if (li4Var.x() == 7 && !li4Var.K(j2)) {
                    o(li4Var, j2);
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
        List<li4> list;
        ui4 ui4Var;
        li4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (li4 li4Var : list) {
            if (li4Var.x() == 7) {
                Iterator<ri4> it = li4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ri4 next = it.next();
                        if ((next instanceof ui4) && (c2 = (ui4Var = (ui4) next).c()) != null && ui4Var.i() == j2 && c2.d() == li4Var.d() && c2.q() == li4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(li4 li4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, li4Var) == null) {
            T(li4Var);
            new m(this, null).execute(li4Var);
        }
    }

    public final void T(li4 li4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, li4Var) == null) || li4Var == null) {
            return;
        }
        int x = li4Var.x();
        Iterator<ri4> it = li4Var.n().iterator();
        while (it.hasNext()) {
            ri4 next = it.next();
            if (next != null && next.c() != null) {
                li4 c2 = next.c();
                if (c2.d() == li4Var.d() && c2.q() == li4Var.q()) {
                    if (x == 7 && (next instanceof ui4)) {
                        ((ui4) next).f(true);
                    } else if (x == 1 && (next instanceof wi4)) {
                        ((wi4) next).f(true);
                    }
                }
            }
        }
        li4Var.d0(false);
    }

    public void m(li4 li4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, li4Var) == null) || li4Var == null) {
            return;
        }
        if (li4Var.x() == 9) {
            zi4.c().f(li4Var);
        } else if (!this.f) {
            this.c.add(li4Var);
        } else if (B(li4Var)) {
        } else {
            J(li4Var);
            new g(this, null).execute(li4Var);
        }
    }

    public void n(List<li4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (li4 li4Var : list) {
            if (li4Var != null) {
                if (li4Var.x() == 9) {
                    zi4.c().f(li4Var);
                } else if (!B(li4Var)) {
                    J(li4Var);
                    arrayList.add(li4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(li4 li4Var, long j2) {
        boolean z;
        ui4 ui4Var;
        li4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, li4Var, j2) == null) {
            Iterator<ri4> it = li4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ri4 next = it.next();
                if ((next instanceof ui4) && (c2 = (ui4Var = (ui4) next).c()) != null && ui4Var.i() == j2 && c2.d() == li4Var.d() && c2.q() == li4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            ui4 ui4Var2 = new ui4(li4Var, j2);
            ui4Var2.g(0L);
            ui4Var2.f(false);
            ui4Var2.h(li4Var.w());
            li4Var.a(ui4Var2);
        }
    }

    public final void p(li4 li4Var, long j2) {
        boolean z;
        wi4 wi4Var;
        li4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, li4Var, j2) == null) {
            Iterator<ri4> it = li4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ri4 next = it.next();
                if ((next instanceof wi4) && (c2 = (wi4Var = (wi4) next).c()) != null && wi4Var.i() == j2 && c2.d() == li4Var.d() && c2.q() == li4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            wi4 wi4Var2 = new wi4(li4Var, j2);
            wi4Var2.g(0L);
            wi4Var2.f(false);
            wi4Var2.h(li4Var.w());
            li4Var.a(wi4Var2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? UtilHelper.isSameDay(yt4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? UtilHelper.isSameDay(x(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void t(li4 li4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, li4Var) == null) || li4Var == null) {
            return;
        }
        Iterator<ri4> it = li4Var.n().iterator();
        while (it.hasNext()) {
            ri4 next = it.next();
            if (next != null && next.c() != null) {
                li4 c2 = next.c();
                if (c2.d() == li4Var.d() && c2.q() == li4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<li4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<li4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    li4 next2 = it2.next();
                    if (next2 != null && next2.d() == li4Var.d() && next2.q() == li4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        ki4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + li4Var.d() + ",missionId=" + li4Var.q());
    }

    public final li4 u(li4 li4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, li4Var)) == null) {
            if (li4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<li4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (li4 li4Var2 : valueAt) {
                        if (li4Var2 != null && li4Var2.d() == li4Var.d() && li4Var2.q() == li4Var.q()) {
                            return li4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (li4) invokeL.objValue;
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
            long m2 = yt4.k().m("pref_key_active_config_info", 0L);
            this.n = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            List<li4> list = this.b.get(i2);
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
        public final /* synthetic */ mi4 e;

        public f(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mi4Var;
            this.d = false;
        }

        public final void a(li4 li4Var, sj4.d dVar) {
            ArrayList<ri4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, li4Var, dVar) == null) || li4Var == null || dVar == null || (n = li4Var.n()) == null) {
                return;
            }
            Iterator<ri4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                ri4 next = it.next();
                if (next instanceof wi4) {
                    wi4 wi4Var = (wi4) next;
                    if (this.b != 0 && wi4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(li4Var);
                    }
                } else if (next instanceof ui4) {
                    ui4 ui4Var = (ui4) next;
                    if (!li4Var.M() && ui4Var.d() == li4Var.w()) {
                        if (this.b != 0 && ui4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && ui4Var.i() == this.b && !next.e()) {
                            if (next.b() >= li4Var.f()) {
                                next.f(true);
                                li4Var.J();
                            }
                            dVar.c(li4Var);
                        }
                        int l = li4Var.l();
                        int A = li4Var.A();
                        long f = li4Var.f() * li4Var.A();
                        if (this.b != 0 && ui4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(li4Var);
                            li4Var.d0(true);
                        }
                    }
                } else if (next instanceof ti4) {
                    if (this.c != 0 && ((ti4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof si4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(li4 li4Var, sj4.d dVar) {
            ArrayList<ri4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li4Var, dVar) == null) || li4Var == null || dVar == null || (n = li4Var.n()) == null) {
                return;
            }
            Iterator<ri4> it = n.iterator();
            while (it.hasNext()) {
                ri4 next = it.next();
                if ((next instanceof vi4) && !((vi4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(li4Var);
                    }
                    dVar.c(li4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<li4> list = (List) this.e.b.get(li4.Y);
                List<li4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                sj4.d dVar = new sj4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    ji4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<li4> list, sj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (li4 li4Var : list) {
                b(li4Var, dVar);
            }
        }

        public final void e(List<li4> list, sj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (li4 li4Var : list) {
                a(li4Var, dVar);
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

        public /* synthetic */ f(mi4 mi4Var, a aVar) {
            this(mi4Var);
        }
    }

    public mi4() {
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
        sj4 sj4Var = new sj4(gen);
        this.i = sj4Var;
        sj4Var.w(this.t);
        mj4 mj4Var = new mj4(this.h);
        this.j = mj4Var;
        mj4Var.g(this.s);
        new oj4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        wt4.e().f();
        zi4.c().d(this.h);
        Q();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
