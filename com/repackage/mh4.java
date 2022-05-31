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
import com.repackage.si4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class mh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<lh4>> b;
    public final LinkedList<lh4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public si4 i;
    public mi4 j;
    public oi4 k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public ki4<li4> t;
    public fl4 u;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mh4 mh4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var, Integer.valueOf(i)};
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
            this.a = mh4Var;
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
                    this.a.m((lh4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mh4 mh4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var, Integer.valueOf(i)};
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
            this.a = mh4Var;
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
        public final /* synthetic */ mh4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(mh4 mh4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var, Integer.valueOf(i)};
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
            this.a = mh4Var;
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
    public class d implements ki4<li4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh4 a;

        public d(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ki4
        /* renamed from: b */
        public void a(li4 li4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li4Var) == null) || li4Var == null || (activeCenterData = li4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            lh4 lh4Var = new lh4();
            lh4Var.O(li4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(lh4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.el4
        /* renamed from: c */
        public void onSuccess(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, li4Var) == null) || li4Var == null) {
                return;
            }
            this.a.n(li4Var.b());
        }

        @Override // com.repackage.el4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements fl4<lh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh4 a;

        public e(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fl4
        /* renamed from: b */
        public void a(lh4 lh4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lh4Var) == null) || lh4Var == null) {
                return;
            }
            lh4 v = this.a.v(lh4Var);
            if (v != null && v.z) {
                v.R();
                this.a.T(v);
                return;
            }
            xh4.b().h(v);
            if (v != null && v.x() == 7) {
                v.H();
                int F = v.F();
                int w = v.w();
                if (F <= 1 || F <= w) {
                    this.a.H(v);
                } else {
                    this.a.T(v);
                }
            } else if (v == null || v.x() != 8) {
                this.a.H(lh4Var);
            } else {
                this.a.H(v);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<lh4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
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
        public Void doInBackground(lh4... lh4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lh4VarArr)) == null) {
                if (lh4VarArr == null || lh4VarArr.length <= 0 || lh4VarArr[0] == null) {
                    return null;
                }
                jh4.g().a(lh4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(mh4 mh4Var, a aVar) {
            this(mh4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<List<lh4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
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
        public Void doInBackground(List<lh4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                jh4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(mh4 mh4Var, a aVar) {
            this(mh4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<lh4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
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
        public Void doInBackground(lh4... lh4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lh4VarArr)) == null) {
                if (lh4VarArr == null || lh4VarArr.length <= 0 || lh4VarArr[0] == null) {
                    return null;
                }
                jh4.g().e(lh4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(mh4 mh4Var, a aVar) {
            this(mh4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Pair<lh4, lh4>, Integer, Pair<lh4, lh4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh4 a;

        public j(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<lh4, lh4> doInBackground(Pair<lh4, lh4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<lh4, lh4> pair = pairArr[0];
                lh4 lh4Var = (lh4) pair.first;
                lh4 lh4Var2 = (lh4) pair.second;
                if (lh4Var2 != null) {
                    jh4.g().e(lh4Var2);
                }
                if (lh4Var != null) {
                    jh4.g().a(lh4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<lh4, lh4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            lh4 lh4Var = (lh4) pair.first;
            lh4 lh4Var2 = (lh4) pair.second;
            if (lh4Var2 != null) {
                this.a.u(lh4Var2);
            }
            if (lh4Var != null) {
                this.a.K(lh4Var);
            }
        }

        public /* synthetic */ j(mh4 mh4Var, a aVar) {
            this(mh4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<lh4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh4 a;

        public k(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<lh4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<lh4> linkedList = new LinkedList<>();
                linkedList.addAll(jh4.g().f());
                Iterator<lh4> it = linkedList.iterator();
                while (it.hasNext()) {
                    lh4 next = it.next();
                    if (next != null && next.M()) {
                        jh4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.n0();
                        jh4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<lh4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<lh4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        lh4 next = it.next();
                        if (next.h() != null) {
                            this.a.K(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(mh4 mh4Var, a aVar) {
            this(mh4Var);
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final mh4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-185376816, "Lcom/repackage/mh4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-185376816, "Lcom/repackage/mh4$l;");
                    return;
                }
            }
            a = new mh4(null);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<lh4, Integer, lh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh4 a;

        public m(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public lh4 doInBackground(lh4... lh4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lh4VarArr)) == null) {
                if (lh4VarArr == null || lh4VarArr.length <= 0 || lh4VarArr[0] == null) {
                    return null;
                }
                lh4 lh4Var = lh4VarArr[0];
                jh4.g().i(lh4Var);
                return lh4Var;
            }
            return (lh4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(lh4 lh4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lh4Var) == null) && lh4Var != null && lh4Var.z) {
                lh4Var.z = false;
                mh4 mh4Var = this.a;
                mh4Var.Q(mh4Var.l, this.a.m);
            }
        }

        public /* synthetic */ m(mh4 mh4Var, a aVar) {
            this(mh4Var);
        }
    }

    public /* synthetic */ mh4(a aVar) {
        this();
    }

    public static final mh4 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (mh4) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !s() : invokeV.booleanValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public final boolean C(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lh4Var)) == null) {
            if (lh4Var == null) {
                return false;
            }
            int[] h2 = lh4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<lh4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (lh4 lh4Var2 : list) {
                    if (lh4Var2 != null && lh4Var2.d() == lh4Var.d() && lh4Var2.q() == lh4Var.q()) {
                        if (lh4Var2.M()) {
                            I(lh4Var, lh4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && UbsABTestHelper.isRedPackageShowSecondTime() && ys4.k().l("app_restart_times", 0) > 1;
        }
        return invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.compareAndSet(true, false);
            this.d.f(0);
            this.d.h(0L);
            this.d.g(0L);
            si4 si4Var = this.i;
            if (si4Var != null) {
                si4Var.m();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            List<lh4> list = this.b.get(lh4.W);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (lh4 lh4Var : list) {
                Iterator<rh4> it = lh4Var.n().iterator();
                while (it.hasNext()) {
                    rh4 next = it.next();
                    if (next instanceof vh4) {
                        vh4 vh4Var = (vh4) next;
                        if (!next.e()) {
                            vh4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(lh4.W);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void H(lh4 lh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lh4Var) == null) {
            u(lh4Var);
            new i(this, null).execute(lh4Var);
        }
    }

    public final void I(lh4 lh4Var, lh4 lh4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lh4Var, lh4Var2) == null) {
            u(lh4Var2);
            new j(this, null).execute(new Pair(lh4Var, lh4Var2));
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null && B() && this.g) {
                this.j.f(A(), D(), 1);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K(lh4 lh4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, lh4Var) == null) {
            for (int i2 : lh4Var.h()) {
                List<lh4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(lh4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(lh4Var);
                }
            }
        }
    }

    public void L(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && B()) {
            this.n = i2;
            long j3 = this.m;
            if (j3 > 0 && this.l > 0 && (j2 == 0 || j2 != j3)) {
                S(this.l, this.m);
                this.m = 0L;
                this.l = 0;
            }
            N();
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.p = z;
        }
    }

    public void N() {
        int i2;
        List<lh4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && B() && this.f && (list = this.b.get((i2 = lh4.W))) != null && !list.isEmpty()) {
            boolean z = false;
            for (lh4 lh4Var : list) {
                if (lh4Var.x() == 8) {
                    Iterator<rh4> it = lh4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        rh4 next = it.next();
                        lh4 c2 = next.c();
                        if (c2 != null && (next instanceof vh4) && c2.d() == lh4Var.d() && c2.q() == lh4Var.q()) {
                            ((vh4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        vh4 vh4Var = new vh4(lh4Var);
                        vh4Var.g(0L);
                        vh4Var.f(false);
                        lh4Var.a(vh4Var);
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

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && B() && i2 != 0 && this.f) {
            this.l = i2;
            List<lh4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (lh4 lh4Var : list) {
                if (lh4Var.x() == 4) {
                    Iterator<rh4> it = lh4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        rh4 next = it.next();
                        if ((next instanceof sh4) && next.c().d() == lh4Var.d() && next.c().q() == lh4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        sh4 sh4Var = new sh4(lh4Var);
                        sh4Var.g(0L);
                        sh4Var.f(false);
                        lh4Var.a(sh4Var);
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

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && B() && i2 != 0 && j2 != 0 && this.f) {
            this.l = i2;
            List<lh4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (lh4 lh4Var : list) {
                if (lh4Var.x() == 2) {
                    Iterator<rh4> it = lh4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        rh4 next = it.next();
                        if ((next instanceof th4) && next.c().d() == lh4Var.d() && next.c().q() == lh4Var.q() && ((th4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        th4 th4Var = new th4(lh4Var, j2);
                        th4Var.g(0L);
                        th4Var.f(false);
                        th4Var.h(lh4Var.w());
                        lh4Var.a(th4Var);
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

    public void Q(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && B() && i2 != 0 && j2 != 0 && this.f) {
            this.l = i2;
            List<lh4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (lh4 lh4Var : list) {
                if (lh4Var.x() == 1) {
                    p(lh4Var, j2);
                } else if (lh4Var.x() == 7 && !lh4Var.J(j2)) {
                    o(lh4Var, j2);
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

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.scheduleWithFixedDelay(this.d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public void S(int i2, long j2) {
        List<lh4> list;
        uh4 uh4Var;
        lh4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (lh4 lh4Var : list) {
            if (lh4Var.x() == 7) {
                Iterator<rh4> it = lh4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        rh4 next = it.next();
                        if ((next instanceof uh4) && (c2 = (uh4Var = (uh4) next).c()) != null && uh4Var.i() == j2 && c2.d() == lh4Var.d() && c2.q() == lh4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void T(lh4 lh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, lh4Var) == null) {
            U(lh4Var);
            new m(this, null).execute(lh4Var);
        }
    }

    public final void U(lh4 lh4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, lh4Var) == null) || lh4Var == null) {
            return;
        }
        int x = lh4Var.x();
        Iterator<rh4> it = lh4Var.n().iterator();
        while (it.hasNext()) {
            rh4 next = it.next();
            if (next != null && next.c() != null) {
                lh4 c2 = next.c();
                if (c2.d() == lh4Var.d() && c2.q() == lh4Var.q()) {
                    if (x == 7 && (next instanceof uh4)) {
                        ((uh4) next).f(true);
                    } else if (x == 1 && (next instanceof wh4)) {
                        ((wh4) next).f(true);
                    }
                }
            }
        }
        lh4Var.c0(false);
    }

    public void m(lh4 lh4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, lh4Var) == null) || lh4Var == null) {
            return;
        }
        if (lh4Var.x() == 9) {
            zh4.c().f(lh4Var);
        } else if (!this.f) {
            this.c.add(lh4Var);
        } else if (C(lh4Var)) {
        } else {
            K(lh4Var);
            new g(this, null).execute(lh4Var);
        }
    }

    public void n(List<lh4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (lh4 lh4Var : list) {
            if (lh4Var != null) {
                if (lh4Var.x() == 9) {
                    zh4.c().f(lh4Var);
                } else if (!C(lh4Var)) {
                    K(lh4Var);
                    arrayList.add(lh4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(lh4 lh4Var, long j2) {
        boolean z;
        uh4 uh4Var;
        lh4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, lh4Var, j2) == null) {
            Iterator<rh4> it = lh4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                rh4 next = it.next();
                if ((next instanceof uh4) && (c2 = (uh4Var = (uh4) next).c()) != null && uh4Var.i() == j2 && c2.d() == lh4Var.d() && c2.q() == lh4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            uh4 uh4Var2 = new uh4(lh4Var, j2);
            uh4Var2.g(0L);
            uh4Var2.f(false);
            uh4Var2.h(lh4Var.w());
            lh4Var.a(uh4Var2);
        }
    }

    public final void p(lh4 lh4Var, long j2) {
        boolean z;
        wh4 wh4Var;
        lh4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, lh4Var, j2) == null) {
            Iterator<rh4> it = lh4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                rh4 next = it.next();
                if ((next instanceof wh4) && (c2 = (wh4Var = (wh4) next).c()) != null && wh4Var.i() == j2 && c2.d() == lh4Var.d() && c2.q() == lh4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            wh4 wh4Var2 = new wh4(lh4Var, j2);
            wh4Var2.g(0L);
            wh4Var2.f(false);
            wh4Var2.h(lh4Var.w());
            lh4Var.a(wh4Var2);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.j != null && B() && this.g) {
            if (!t() || E()) {
                this.j.f(A(), D(), 0);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.k != null && B()) {
            this.k.d();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? UtilHelper.isSameDay(ys4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? UtilHelper.isSameDay(y(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void u(lh4 lh4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, lh4Var) == null) || lh4Var == null) {
            return;
        }
        Iterator<rh4> it = lh4Var.n().iterator();
        while (it.hasNext()) {
            rh4 next = it.next();
            if (next != null && next.c() != null) {
                lh4 c2 = next.c();
                if (c2.d() == lh4Var.d() && c2.q() == lh4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<lh4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<lh4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    lh4 next2 = it2.next();
                    if (next2 != null && next2.d() == lh4Var.d() && next2.q() == lh4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        kh4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + lh4Var.d() + ",missionId=" + lh4Var.q());
    }

    public final lh4 v(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, lh4Var)) == null) {
            if (lh4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<lh4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (lh4 lh4Var2 : valueAt) {
                        if (lh4Var2 != null && lh4Var2.d() == lh4Var.d() && lh4Var2.q() == lh4Var.q()) {
                            return lh4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (lh4) invokeL.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.n : invokeV.intValue;
    }

    public final long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            long m2 = ys4.k().m("pref_key_active_config_info", 0L);
            this.o = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    public boolean z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            List<lh4> list = this.b.get(i2);
            return (list == null || list.isEmpty()) ? false : true;
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ mh4 e;

        public f(mh4 mh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mh4Var;
            this.d = false;
        }

        public final void a(lh4 lh4Var, si4.d dVar) {
            ArrayList<rh4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, lh4Var, dVar) == null) || lh4Var == null || dVar == null || (n = lh4Var.n()) == null) {
                return;
            }
            Iterator<rh4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                rh4 next = it.next();
                if (next instanceof wh4) {
                    wh4 wh4Var = (wh4) next;
                    if (this.b != 0 && wh4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(lh4Var);
                    }
                } else if (next instanceof uh4) {
                    uh4 uh4Var = (uh4) next;
                    if (!lh4Var.L() && uh4Var.d() == lh4Var.w()) {
                        if (this.b != 0 && uh4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && uh4Var.i() == this.b && !next.e()) {
                            if (next.b() >= lh4Var.f()) {
                                next.f(true);
                                lh4Var.I();
                            }
                            dVar.c(lh4Var);
                        }
                        int l = lh4Var.l();
                        int A = lh4Var.A();
                        long f = lh4Var.f() * lh4Var.A();
                        if (this.b != 0 && uh4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(lh4Var);
                            lh4Var.c0(true);
                        }
                    }
                } else if (next instanceof th4) {
                    if (this.c != 0 && ((th4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof sh4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(lh4 lh4Var, si4.d dVar) {
            ArrayList<rh4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lh4Var, dVar) == null) || lh4Var == null || dVar == null || (n = lh4Var.n()) == null) {
                return;
            }
            Iterator<rh4> it = n.iterator();
            while (it.hasNext()) {
                rh4 next = it.next();
                if ((next instanceof vh4) && !((vh4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(lh4Var);
                    }
                    dVar.c(lh4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<lh4> list = (List) this.e.b.get(lh4.W);
                List<lh4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                si4.d dVar = new si4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    jh4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<lh4> list, si4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (lh4 lh4Var : list) {
                b(lh4Var, dVar);
            }
        }

        public final void e(List<lh4> list, si4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (lh4 lh4Var : list) {
                a(lh4Var, dVar);
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

        public /* synthetic */ f(mh4 mh4Var, a aVar) {
            this(mh4Var);
        }
    }

    public mh4() {
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
        si4 si4Var = new si4(gen);
        this.i = si4Var;
        si4Var.w(this.u);
        mi4 mi4Var = new mi4(this.h);
        this.j = mi4Var;
        mi4Var.g(this.t);
        this.k = new oi4(this.h);
        this.s.setTag(this.h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        ws4.e().f();
        zh4.c().d(this.h);
        R();
        if (B()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
