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
import com.repackage.vj4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class pi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<oi4>> b;
    public final LinkedList<oi4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public vj4 i;
    public pj4 j;
    public rj4 k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public nj4<oj4> t;
    public hm4 u;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pi4 pi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var, Integer.valueOf(i)};
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
            this.a = pi4Var;
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
                    this.a.m((oi4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pi4 pi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var, Integer.valueOf(i)};
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
            this.a = pi4Var;
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
        public final /* synthetic */ pi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(pi4 pi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var, Integer.valueOf(i)};
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
            this.a = pi4Var;
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
    public class d implements nj4<oj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public d(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nj4
        /* renamed from: b */
        public void a(oj4 oj4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oj4Var) == null) || oj4Var == null || (activeCenterData = oj4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            oi4 oi4Var = new oi4();
            oi4Var.O(oj4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(oi4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gm4
        /* renamed from: c */
        public void onSuccess(oj4 oj4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oj4Var) == null) || oj4Var == null) {
                return;
            }
            this.a.n(oj4Var.b());
        }

        @Override // com.repackage.gm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements hm4<oi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public e(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hm4
        /* renamed from: b */
        public void a(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oi4Var) == null) || oi4Var == null) {
                return;
            }
            oi4 w = this.a.w(oi4Var);
            if (w != null && w.z) {
                w.R();
                this.a.U(w);
                return;
            }
            aj4.b().h(w);
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
                this.a.I(oi4Var);
            } else {
                this.a.I(w);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<oi4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
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
        public Void doInBackground(oi4... oi4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oi4VarArr)) == null) {
                if (oi4VarArr == null || oi4VarArr.length <= 0 || oi4VarArr[0] == null) {
                    return null;
                }
                mi4.g().a(oi4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(pi4 pi4Var, a aVar) {
            this(pi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<List<oi4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
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
        public Void doInBackground(List<oi4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                mi4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(pi4 pi4Var, a aVar) {
            this(pi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<oi4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
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
        public Void doInBackground(oi4... oi4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oi4VarArr)) == null) {
                if (oi4VarArr == null || oi4VarArr.length <= 0 || oi4VarArr[0] == null) {
                    return null;
                }
                mi4.g().e(oi4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(pi4 pi4Var, a aVar) {
            this(pi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Pair<oi4, oi4>, Integer, Pair<oi4, oi4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public j(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<oi4, oi4> doInBackground(Pair<oi4, oi4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<oi4, oi4> pair = pairArr[0];
                oi4 oi4Var = (oi4) pair.first;
                oi4 oi4Var2 = (oi4) pair.second;
                if (oi4Var2 != null) {
                    mi4.g().e(oi4Var2);
                }
                if (oi4Var != null) {
                    mi4.g().a(oi4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<oi4, oi4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            oi4 oi4Var = (oi4) pair.first;
            oi4 oi4Var2 = (oi4) pair.second;
            if (oi4Var2 != null) {
                this.a.v(oi4Var2);
            }
            if (oi4Var != null) {
                this.a.L(oi4Var);
            }
        }

        public /* synthetic */ j(pi4 pi4Var, a aVar) {
            this(pi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<oi4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public k(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<oi4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<oi4> linkedList = new LinkedList<>();
                linkedList.addAll(mi4.g().f());
                Iterator<oi4> it = linkedList.iterator();
                while (it.hasNext()) {
                    oi4 next = it.next();
                    if (next != null && next.M()) {
                        mi4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.n0();
                        mi4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<oi4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<oi4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        oi4 next = it.next();
                        if (next.h() != null) {
                            this.a.L(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(pi4 pi4Var, a aVar) {
            this(pi4Var);
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final pi4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-98565842, "Lcom/repackage/pi4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-98565842, "Lcom/repackage/pi4$l;");
                    return;
                }
            }
            a = new pi4(null);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<oi4, Integer, oi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public m(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public oi4 doInBackground(oi4... oi4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oi4VarArr)) == null) {
                if (oi4VarArr == null || oi4VarArr.length <= 0 || oi4VarArr[0] == null) {
                    return null;
                }
                oi4 oi4Var = oi4VarArr[0];
                mi4.g().i(oi4Var);
                return oi4Var;
            }
            return (oi4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oi4Var) == null) && oi4Var != null && oi4Var.z) {
                oi4Var.z = false;
                pi4 pi4Var = this.a;
                pi4Var.R(pi4Var.l, this.a.m);
            }
        }

        public /* synthetic */ m(pi4 pi4Var, a aVar) {
            this(pi4Var);
        }
    }

    public /* synthetic */ pi4(a aVar) {
        this();
    }

    public static final pi4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (pi4) invokeV.objValue;
    }

    public boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<oi4> list = this.b.get(i2);
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

    public final boolean D(oi4 oi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, oi4Var)) == null) {
            if (oi4Var == null) {
                return false;
            }
            int[] h2 = oi4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<oi4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (oi4 oi4Var2 : list) {
                    if (oi4Var2 != null && oi4Var2.d() == oi4Var.d() && oi4Var2.q() == oi4Var.q()) {
                        if (oi4Var2.M()) {
                            J(oi4Var, oi4Var2);
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
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && UbsABTestHelper.isRedPackageShowSecondTime() && wt4.k().l("app_restart_times", 0) > 1;
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
            vj4 vj4Var = this.i;
            if (vj4Var != null) {
                vj4Var.m();
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            List<oi4> list = this.b.get(oi4.W);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (oi4 oi4Var : list) {
                Iterator<ui4> it = oi4Var.n().iterator();
                while (it.hasNext()) {
                    ui4 next = it.next();
                    if (next instanceof yi4) {
                        yi4 yi4Var = (yi4) next;
                        if (!next.e()) {
                            yi4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(oi4.W);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void I(oi4 oi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oi4Var) == null) {
            v(oi4Var);
            new i(this, null).execute(oi4Var);
        }
    }

    public final void J(oi4 oi4Var, oi4 oi4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, oi4Var, oi4Var2) == null) {
            v(oi4Var2);
            new j(this, null).execute(new Pair(oi4Var, oi4Var2));
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

    public final void L(oi4 oi4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, oi4Var) == null) {
            for (int i2 : oi4Var.h()) {
                List<oi4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(oi4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(oi4Var);
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
        List<oi4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && C() && this.f && (list = this.b.get((i2 = oi4.W))) != null && !list.isEmpty()) {
            boolean z = false;
            for (oi4 oi4Var : list) {
                if (oi4Var.x() == 8) {
                    Iterator<ui4> it = oi4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ui4 next = it.next();
                        oi4 c2 = next.c();
                        if (c2 != null && (next instanceof yi4) && c2.d() == oi4Var.d() && c2.q() == oi4Var.q()) {
                            ((yi4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        yi4 yi4Var = new yi4(oi4Var);
                        yi4Var.g(0L);
                        yi4Var.f(false);
                        oi4Var.a(yi4Var);
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
            List<oi4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (oi4 oi4Var : list) {
                if (oi4Var.x() == 4) {
                    Iterator<ui4> it = oi4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ui4 next = it.next();
                        if ((next instanceof vi4) && next.c().d() == oi4Var.d() && next.c().q() == oi4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        vi4 vi4Var = new vi4(oi4Var);
                        vi4Var.g(0L);
                        vi4Var.f(false);
                        oi4Var.a(vi4Var);
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
            List<oi4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (oi4 oi4Var : list) {
                if (oi4Var.x() == 2) {
                    Iterator<ui4> it = oi4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ui4 next = it.next();
                        if ((next instanceof wi4) && next.c().d() == oi4Var.d() && next.c().q() == oi4Var.q() && ((wi4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        wi4 wi4Var = new wi4(oi4Var, j2);
                        wi4Var.g(0L);
                        wi4Var.f(false);
                        wi4Var.h(oi4Var.w());
                        oi4Var.a(wi4Var);
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
            List<oi4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (oi4 oi4Var : list) {
                if (oi4Var.x() == 1) {
                    p(oi4Var, j2);
                } else if (oi4Var.x() == 7 && !oi4Var.J(j2)) {
                    o(oi4Var, j2);
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
        List<oi4> list;
        xi4 xi4Var;
        oi4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (oi4 oi4Var : list) {
            if (oi4Var.x() == 7) {
                Iterator<ui4> it = oi4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ui4 next = it.next();
                        if ((next instanceof xi4) && (c2 = (xi4Var = (xi4) next).c()) != null && xi4Var.i() == j2 && c2.d() == oi4Var.d() && c2.q() == oi4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void U(oi4 oi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, oi4Var) == null) {
            V(oi4Var);
            new m(this, null).execute(oi4Var);
        }
    }

    public final void V(oi4 oi4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, oi4Var) == null) || oi4Var == null) {
            return;
        }
        int x = oi4Var.x();
        Iterator<ui4> it = oi4Var.n().iterator();
        while (it.hasNext()) {
            ui4 next = it.next();
            if (next != null && next.c() != null) {
                oi4 c2 = next.c();
                if (c2.d() == oi4Var.d() && c2.q() == oi4Var.q()) {
                    if (x == 7 && (next instanceof xi4)) {
                        ((xi4) next).f(true);
                    } else if (x == 1 && (next instanceof zi4)) {
                        ((zi4) next).f(true);
                    }
                }
            }
        }
        oi4Var.c0(false);
    }

    public void m(oi4 oi4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, oi4Var) == null) || oi4Var == null) {
            return;
        }
        if (oi4Var.x() == 9) {
            cj4.c().f(oi4Var);
        } else if (!this.f) {
            this.c.add(oi4Var);
        } else if (D(oi4Var)) {
        } else {
            L(oi4Var);
            new g(this, null).execute(oi4Var);
        }
    }

    public void n(List<oi4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (oi4 oi4Var : list) {
            if (oi4Var != null) {
                if (oi4Var.x() == 9) {
                    cj4.c().f(oi4Var);
                } else if (!D(oi4Var)) {
                    L(oi4Var);
                    arrayList.add(oi4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(oi4 oi4Var, long j2) {
        boolean z;
        xi4 xi4Var;
        oi4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, oi4Var, j2) == null) {
            Iterator<ui4> it = oi4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ui4 next = it.next();
                if ((next instanceof xi4) && (c2 = (xi4Var = (xi4) next).c()) != null && xi4Var.i() == j2 && c2.d() == oi4Var.d() && c2.q() == oi4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            xi4 xi4Var2 = new xi4(oi4Var, j2);
            xi4Var2.g(0L);
            xi4Var2.f(false);
            xi4Var2.h(oi4Var.w());
            oi4Var.a(xi4Var2);
        }
    }

    public final void p(oi4 oi4Var, long j2) {
        boolean z;
        zi4 zi4Var;
        oi4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048601, this, oi4Var, j2) == null) {
            Iterator<ui4> it = oi4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ui4 next = it.next();
                if ((next instanceof zi4) && (c2 = (zi4Var = (zi4) next).c()) != null && zi4Var.i() == j2 && c2.d() == oi4Var.d() && c2.q() == oi4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            zi4 zi4Var2 = new zi4(oi4Var, j2);
            zi4Var2.g(0L);
            zi4Var2.f(false);
            zi4Var2.h(oi4Var.w());
            oi4Var.a(zi4Var2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? UtilHelper.isSameDay(wt4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? UtilHelper.isSameDay(z(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? UtilHelper.isSameDay(wt4.k().m("pref_key_last_popup_time", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v(oi4 oi4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, oi4Var) == null) || oi4Var == null) {
            return;
        }
        Iterator<ui4> it = oi4Var.n().iterator();
        while (it.hasNext()) {
            ui4 next = it.next();
            if (next != null && next.c() != null) {
                oi4 c2 = next.c();
                if (c2.d() == oi4Var.d() && c2.q() == oi4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<oi4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<oi4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    oi4 next2 = it2.next();
                    if (next2 != null && next2.d() == oi4Var.d() && next2.q() == oi4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        ni4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + oi4Var.d() + ",missionId=" + oi4Var.q());
    }

    public final oi4 w(oi4 oi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, oi4Var)) == null) {
            if (oi4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<oi4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (oi4 oi4Var2 : valueAt) {
                        if (oi4Var2 != null && oi4Var2.d() == oi4Var.d() && oi4Var2.q() == oi4Var.q()) {
                            return oi4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (oi4) invokeL.objValue;
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
            long m2 = wt4.k().m("pref_key_active_config_info", 0L);
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
        public final /* synthetic */ pi4 e;

        public f(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = pi4Var;
            this.d = false;
        }

        public final void a(oi4 oi4Var, vj4.d dVar) {
            ArrayList<ui4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, oi4Var, dVar) == null) || oi4Var == null || dVar == null || (n = oi4Var.n()) == null) {
                return;
            }
            Iterator<ui4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                ui4 next = it.next();
                if (next instanceof zi4) {
                    zi4 zi4Var = (zi4) next;
                    if (this.b != 0 && zi4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(oi4Var);
                    }
                } else if (next instanceof xi4) {
                    xi4 xi4Var = (xi4) next;
                    if (!oi4Var.L() && xi4Var.d() == oi4Var.w()) {
                        if (this.b != 0 && xi4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && xi4Var.i() == this.b && !next.e()) {
                            if (next.b() >= oi4Var.f()) {
                                next.f(true);
                                oi4Var.I();
                            }
                            dVar.c(oi4Var);
                        }
                        int l = oi4Var.l();
                        int A = oi4Var.A();
                        long f = oi4Var.f() * oi4Var.A();
                        if (this.b != 0 && xi4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(oi4Var);
                            oi4Var.c0(true);
                        }
                    }
                } else if (next instanceof wi4) {
                    if (this.c != 0 && ((wi4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof vi4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(oi4 oi4Var, vj4.d dVar) {
            ArrayList<ui4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oi4Var, dVar) == null) || oi4Var == null || dVar == null || (n = oi4Var.n()) == null) {
                return;
            }
            Iterator<ui4> it = n.iterator();
            while (it.hasNext()) {
                ui4 next = it.next();
                if ((next instanceof yi4) && !((yi4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(oi4Var);
                    }
                    dVar.c(oi4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<oi4> list = (List) this.e.b.get(oi4.W);
                List<oi4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                vj4.d dVar = new vj4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    mi4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<oi4> list, vj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (oi4 oi4Var : list) {
                b(oi4Var, dVar);
            }
        }

        public final void e(List<oi4> list, vj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (oi4 oi4Var : list) {
                a(oi4Var, dVar);
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

        public /* synthetic */ f(pi4 pi4Var, a aVar) {
            this(pi4Var);
        }
    }

    public pi4() {
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
        vj4 vj4Var = new vj4(gen);
        this.i = vj4Var;
        vj4Var.w(this.u);
        pj4 pj4Var = new pj4(this.h);
        this.j = pj4Var;
        pj4Var.g(this.t);
        this.k = new rj4(this.h);
        this.s.setTag(this.h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        ut4.e().f();
        cj4.c().d(this.h);
        S();
        if (C()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
