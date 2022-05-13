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
import com.repackage.fk4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class zi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<yi4>> b;
    public final LinkedList<yi4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public fk4 i;
    public zj4 j;
    public bk4 k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public xj4<yj4> t;
    public rm4 u;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zi4 zi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var, Integer.valueOf(i)};
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
            this.a = zi4Var;
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
                    this.a.m((yi4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(zi4 zi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var, Integer.valueOf(i)};
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
            this.a = zi4Var;
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

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zi4 zi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var, Integer.valueOf(i)};
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
            this.a = zi4Var;
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

    /* loaded from: classes7.dex */
    public class d implements xj4<yj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi4 a;

        public d(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.xj4
        /* renamed from: b */
        public void a(yj4 yj4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yj4Var) == null) || yj4Var == null || (activeCenterData = yj4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            yi4 yi4Var = new yi4();
            yi4Var.O(yj4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(yi4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qm4
        /* renamed from: c */
        public void onSuccess(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yj4Var) == null) || yj4Var == null) {
                return;
            }
            this.a.n(yj4Var.b());
        }

        @Override // com.repackage.qm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements rm4<yi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi4 a;

        public e(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.rm4
        /* renamed from: b */
        public void a(yi4 yi4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yi4Var) == null) || yi4Var == null) {
                return;
            }
            yi4 w = this.a.w(yi4Var);
            if (w != null && w.z) {
                w.R();
                this.a.U(w);
                return;
            }
            kj4.b().h(w);
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
                this.a.I(yi4Var);
            } else {
                this.a.I(w);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends BdAsyncTask<yi4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
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
        public Void doInBackground(yi4... yi4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yi4VarArr)) == null) {
                if (yi4VarArr == null || yi4VarArr.length <= 0 || yi4VarArr[0] == null) {
                    return null;
                }
                wi4.g().a(yi4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(zi4 zi4Var, a aVar) {
            this(zi4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<List<yi4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
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
        public Void doInBackground(List<yi4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                wi4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(zi4 zi4Var, a aVar) {
            this(zi4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BdAsyncTask<yi4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
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
        public Void doInBackground(yi4... yi4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yi4VarArr)) == null) {
                if (yi4VarArr == null || yi4VarArr.length <= 0 || yi4VarArr[0] == null) {
                    return null;
                }
                wi4.g().e(yi4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(zi4 zi4Var, a aVar) {
            this(zi4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends BdAsyncTask<Pair<yi4, yi4>, Integer, Pair<yi4, yi4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi4 a;

        public j(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<yi4, yi4> doInBackground(Pair<yi4, yi4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<yi4, yi4> pair = pairArr[0];
                yi4 yi4Var = (yi4) pair.first;
                yi4 yi4Var2 = (yi4) pair.second;
                if (yi4Var2 != null) {
                    wi4.g().e(yi4Var2);
                }
                if (yi4Var != null) {
                    wi4.g().a(yi4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<yi4, yi4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            yi4 yi4Var = (yi4) pair.first;
            yi4 yi4Var2 = (yi4) pair.second;
            if (yi4Var2 != null) {
                this.a.v(yi4Var2);
            }
            if (yi4Var != null) {
                this.a.L(yi4Var);
            }
        }

        public /* synthetic */ j(zi4 zi4Var, a aVar) {
            this(zi4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<yi4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi4 a;

        public k(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<yi4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<yi4> linkedList = new LinkedList<>();
                linkedList.addAll(wi4.g().f());
                Iterator<yi4> it = linkedList.iterator();
                while (it.hasNext()) {
                    yi4 next = it.next();
                    if (next != null && next.M()) {
                        wi4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.n0();
                        wi4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<yi4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<yi4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        yi4 next = it.next();
                        if (next.h() != null) {
                            this.a.L(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(zi4 zi4Var, a aVar) {
            this(zi4Var);
        }
    }

    /* loaded from: classes7.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final zi4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(187725668, "Lcom/repackage/zi4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(187725668, "Lcom/repackage/zi4$l;");
                    return;
                }
            }
            a = new zi4(null);
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BdAsyncTask<yi4, Integer, yi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi4 a;

        public m(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public yi4 doInBackground(yi4... yi4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yi4VarArr)) == null) {
                if (yi4VarArr == null || yi4VarArr.length <= 0 || yi4VarArr[0] == null) {
                    return null;
                }
                yi4 yi4Var = yi4VarArr[0];
                wi4.g().i(yi4Var);
                return yi4Var;
            }
            return (yi4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(yi4 yi4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yi4Var) == null) && yi4Var != null && yi4Var.z) {
                yi4Var.z = false;
                zi4 zi4Var = this.a;
                zi4Var.R(zi4Var.l, this.a.m);
            }
        }

        public /* synthetic */ m(zi4 zi4Var, a aVar) {
            this(zi4Var);
        }
    }

    public /* synthetic */ zi4(a aVar) {
        this();
    }

    public static final zi4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (zi4) invokeV.objValue;
    }

    public boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<yi4> list = this.b.get(i2);
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

    public final boolean D(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yi4Var)) == null) {
            if (yi4Var == null) {
                return false;
            }
            int[] h2 = yi4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<yi4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (yi4 yi4Var2 : list) {
                    if (yi4Var2 != null && yi4Var2.d() == yi4Var.d() && yi4Var2.q() == yi4Var.q()) {
                        if (yi4Var2.M()) {
                            J(yi4Var, yi4Var2);
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
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && UbsABTestHelper.isRedPackageShowSecondTime() && iu4.k().l("app_restart_times", 0) > 1;
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
            fk4 fk4Var = this.i;
            if (fk4Var != null) {
                fk4Var.m();
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            List<yi4> list = this.b.get(yi4.W);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (yi4 yi4Var : list) {
                Iterator<ej4> it = yi4Var.n().iterator();
                while (it.hasNext()) {
                    ej4 next = it.next();
                    if (next instanceof ij4) {
                        ij4 ij4Var = (ij4) next;
                        if (!next.e()) {
                            ij4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(yi4.W);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void I(yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yi4Var) == null) {
            v(yi4Var);
            new i(this, null).execute(yi4Var);
        }
    }

    public final void J(yi4 yi4Var, yi4 yi4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, yi4Var, yi4Var2) == null) {
            v(yi4Var2);
            new j(this, null).execute(new Pair(yi4Var, yi4Var2));
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

    public final void L(yi4 yi4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, yi4Var) == null) {
            for (int i2 : yi4Var.h()) {
                List<yi4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(yi4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(yi4Var);
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
        List<yi4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && C() && this.f && (list = this.b.get((i2 = yi4.W))) != null && !list.isEmpty()) {
            boolean z = false;
            for (yi4 yi4Var : list) {
                if (yi4Var.x() == 8) {
                    Iterator<ej4> it = yi4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ej4 next = it.next();
                        yi4 c2 = next.c();
                        if (c2 != null && (next instanceof ij4) && c2.d() == yi4Var.d() && c2.q() == yi4Var.q()) {
                            ((ij4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ij4 ij4Var = new ij4(yi4Var);
                        ij4Var.g(0L);
                        ij4Var.f(false);
                        yi4Var.a(ij4Var);
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
            List<yi4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (yi4 yi4Var : list) {
                if (yi4Var.x() == 4) {
                    Iterator<ej4> it = yi4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ej4 next = it.next();
                        if ((next instanceof fj4) && next.c().d() == yi4Var.d() && next.c().q() == yi4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        fj4 fj4Var = new fj4(yi4Var);
                        fj4Var.g(0L);
                        fj4Var.f(false);
                        yi4Var.a(fj4Var);
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
            List<yi4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (yi4 yi4Var : list) {
                if (yi4Var.x() == 2) {
                    Iterator<ej4> it = yi4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ej4 next = it.next();
                        if ((next instanceof gj4) && next.c().d() == yi4Var.d() && next.c().q() == yi4Var.q() && ((gj4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        gj4 gj4Var = new gj4(yi4Var, j2);
                        gj4Var.g(0L);
                        gj4Var.f(false);
                        gj4Var.h(yi4Var.w());
                        yi4Var.a(gj4Var);
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
            List<yi4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (yi4 yi4Var : list) {
                if (yi4Var.x() == 1) {
                    p(yi4Var, j2);
                } else if (yi4Var.x() == 7 && !yi4Var.J(j2)) {
                    o(yi4Var, j2);
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
        List<yi4> list;
        hj4 hj4Var;
        yi4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (yi4 yi4Var : list) {
            if (yi4Var.x() == 7) {
                Iterator<ej4> it = yi4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ej4 next = it.next();
                        if ((next instanceof hj4) && (c2 = (hj4Var = (hj4) next).c()) != null && hj4Var.i() == j2 && c2.d() == yi4Var.d() && c2.q() == yi4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void U(yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, yi4Var) == null) {
            V(yi4Var);
            new m(this, null).execute(yi4Var);
        }
    }

    public final void V(yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, yi4Var) == null) || yi4Var == null) {
            return;
        }
        int x = yi4Var.x();
        Iterator<ej4> it = yi4Var.n().iterator();
        while (it.hasNext()) {
            ej4 next = it.next();
            if (next != null && next.c() != null) {
                yi4 c2 = next.c();
                if (c2.d() == yi4Var.d() && c2.q() == yi4Var.q()) {
                    if (x == 7 && (next instanceof hj4)) {
                        ((hj4) next).f(true);
                    } else if (x == 1 && (next instanceof jj4)) {
                        ((jj4) next).f(true);
                    }
                }
            }
        }
        yi4Var.c0(false);
    }

    public void m(yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, yi4Var) == null) || yi4Var == null) {
            return;
        }
        if (yi4Var.x() == 9) {
            mj4.c().f(yi4Var);
        } else if (!this.f) {
            this.c.add(yi4Var);
        } else if (D(yi4Var)) {
        } else {
            L(yi4Var);
            new g(this, null).execute(yi4Var);
        }
    }

    public void n(List<yi4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (yi4 yi4Var : list) {
            if (yi4Var != null) {
                if (yi4Var.x() == 9) {
                    mj4.c().f(yi4Var);
                } else if (!D(yi4Var)) {
                    L(yi4Var);
                    arrayList.add(yi4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(yi4 yi4Var, long j2) {
        boolean z;
        hj4 hj4Var;
        yi4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, yi4Var, j2) == null) {
            Iterator<ej4> it = yi4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ej4 next = it.next();
                if ((next instanceof hj4) && (c2 = (hj4Var = (hj4) next).c()) != null && hj4Var.i() == j2 && c2.d() == yi4Var.d() && c2.q() == yi4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            hj4 hj4Var2 = new hj4(yi4Var, j2);
            hj4Var2.g(0L);
            hj4Var2.f(false);
            hj4Var2.h(yi4Var.w());
            yi4Var.a(hj4Var2);
        }
    }

    public final void p(yi4 yi4Var, long j2) {
        boolean z;
        jj4 jj4Var;
        yi4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048601, this, yi4Var, j2) == null) {
            Iterator<ej4> it = yi4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ej4 next = it.next();
                if ((next instanceof jj4) && (c2 = (jj4Var = (jj4) next).c()) != null && jj4Var.i() == j2 && c2.d() == yi4Var.d() && c2.q() == yi4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            jj4 jj4Var2 = new jj4(yi4Var, j2);
            jj4Var2.g(0L);
            jj4Var2.f(false);
            jj4Var2.h(yi4Var.w());
            yi4Var.a(jj4Var2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? UtilHelper.isSameDay(iu4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? UtilHelper.isSameDay(z(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? UtilHelper.isSameDay(iu4.k().m("pref_key_last_popup_time", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v(yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, yi4Var) == null) || yi4Var == null) {
            return;
        }
        Iterator<ej4> it = yi4Var.n().iterator();
        while (it.hasNext()) {
            ej4 next = it.next();
            if (next != null && next.c() != null) {
                yi4 c2 = next.c();
                if (c2.d() == yi4Var.d() && c2.q() == yi4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<yi4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<yi4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    yi4 next2 = it2.next();
                    if (next2 != null && next2.d() == yi4Var.d() && next2.q() == yi4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        xi4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + yi4Var.d() + ",missionId=" + yi4Var.q());
    }

    public final yi4 w(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, yi4Var)) == null) {
            if (yi4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<yi4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (yi4 yi4Var2 : valueAt) {
                        if (yi4Var2 != null && yi4Var2.d() == yi4Var.d() && yi4Var2.q() == yi4Var.q()) {
                            return yi4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (yi4) invokeL.objValue;
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
            long m2 = iu4.k().m("pref_key_active_config_info", 0L);
            this.o = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ zi4 e;

        public f(zi4 zi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zi4Var;
            this.d = false;
        }

        public final void a(yi4 yi4Var, fk4.d dVar) {
            ArrayList<ej4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, yi4Var, dVar) == null) || yi4Var == null || dVar == null || (n = yi4Var.n()) == null) {
                return;
            }
            Iterator<ej4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                ej4 next = it.next();
                if (next instanceof jj4) {
                    jj4 jj4Var = (jj4) next;
                    if (this.b != 0 && jj4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(yi4Var);
                    }
                } else if (next instanceof hj4) {
                    hj4 hj4Var = (hj4) next;
                    if (!yi4Var.L() && hj4Var.d() == yi4Var.w()) {
                        if (this.b != 0 && hj4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && hj4Var.i() == this.b && !next.e()) {
                            if (next.b() >= yi4Var.f()) {
                                next.f(true);
                                yi4Var.I();
                            }
                            dVar.c(yi4Var);
                        }
                        int l = yi4Var.l();
                        int A = yi4Var.A();
                        long f = yi4Var.f() * yi4Var.A();
                        if (this.b != 0 && hj4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(yi4Var);
                            yi4Var.c0(true);
                        }
                    }
                } else if (next instanceof gj4) {
                    if (this.c != 0 && ((gj4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof fj4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(yi4 yi4Var, fk4.d dVar) {
            ArrayList<ej4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yi4Var, dVar) == null) || yi4Var == null || dVar == null || (n = yi4Var.n()) == null) {
                return;
            }
            Iterator<ej4> it = n.iterator();
            while (it.hasNext()) {
                ej4 next = it.next();
                if ((next instanceof ij4) && !((ij4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(yi4Var);
                    }
                    dVar.c(yi4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<yi4> list = (List) this.e.b.get(yi4.W);
                List<yi4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                fk4.d dVar = new fk4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    wi4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<yi4> list, fk4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (yi4 yi4Var : list) {
                b(yi4Var, dVar);
            }
        }

        public final void e(List<yi4> list, fk4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (yi4 yi4Var : list) {
                a(yi4Var, dVar);
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

        public /* synthetic */ f(zi4 zi4Var, a aVar) {
            this(zi4Var);
        }
    }

    public zi4() {
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
        fk4 fk4Var = new fk4(gen);
        this.i = fk4Var;
        fk4Var.w(this.u);
        zj4 zj4Var = new zj4(this.h);
        this.j = zj4Var;
        zj4Var.g(this.t);
        this.k = new bk4(this.h);
        this.s.setTag(this.h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        gu4.e().f();
        mj4.c().d(this.h);
        S();
        if (C()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
