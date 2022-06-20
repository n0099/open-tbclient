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
import com.repackage.cj4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class wh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<vh4>> b;
    public final LinkedList<vh4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public cj4 i;
    public wi4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public ui4<vi4> s;
    public pl4 t;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wh4 wh4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var, Integer.valueOf(i)};
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
            this.a = wh4Var;
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
                    this.a.m((vh4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wh4 wh4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var, Integer.valueOf(i)};
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
            this.a = wh4Var;
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
        public final /* synthetic */ wh4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(wh4 wh4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var, Integer.valueOf(i)};
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
            this.a = wh4Var;
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
    public class d implements ui4<vi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh4 a;

        public d(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ui4
        /* renamed from: b */
        public void a(vi4 vi4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi4Var) == null) || vi4Var == null || (activeCenterData = vi4Var.g) == null || activeCenterData.mission == null) {
                return;
            }
            vh4 vh4Var = new vh4();
            vh4Var.O(vi4Var.g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(vh4Var);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ol4
        /* renamed from: c */
        public void onSuccess(vi4 vi4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vi4Var) == null) || vi4Var == null) {
                return;
            }
            this.a.n(vi4Var.b());
        }

        @Override // com.repackage.ol4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements pl4<vh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh4 a;

        public e(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pl4
        /* renamed from: b */
        public void a(vh4 vh4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vh4Var) == null) || vh4Var == null) {
                return;
            }
            vh4 u = this.a.u(vh4Var);
            if (u != null && u.z) {
                u.R();
                this.a.S(u);
                return;
            }
            hi4.b().h(u);
            if (u != null && u.x() == 7) {
                u.H();
                int F = u.F();
                int w = u.w();
                if (F <= 1 || F <= w) {
                    this.a.G(u);
                } else {
                    this.a.S(u);
                }
            } else if (u == null || u.x() != 8) {
                this.a.G(vh4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends BdAsyncTask<vh4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
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
        public Void doInBackground(vh4... vh4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vh4VarArr)) == null) {
                if (vh4VarArr == null || vh4VarArr.length <= 0 || vh4VarArr[0] == null) {
                    return null;
                }
                th4.g().a(vh4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(wh4 wh4Var, a aVar) {
            this(wh4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<List<vh4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
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
        public Void doInBackground(List<vh4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                th4.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(wh4 wh4Var, a aVar) {
            this(wh4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BdAsyncTask<vh4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
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
        public Void doInBackground(vh4... vh4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vh4VarArr)) == null) {
                if (vh4VarArr == null || vh4VarArr.length <= 0 || vh4VarArr[0] == null) {
                    return null;
                }
                th4.g().e(vh4VarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(wh4 wh4Var, a aVar) {
            this(wh4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends BdAsyncTask<Pair<vh4, vh4>, Integer, Pair<vh4, vh4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh4 a;

        public j(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<vh4, vh4> doInBackground(Pair<vh4, vh4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<vh4, vh4> pair = pairArr[0];
                vh4 vh4Var = (vh4) pair.first;
                vh4 vh4Var2 = (vh4) pair.second;
                if (vh4Var2 != null) {
                    th4.g().e(vh4Var2);
                }
                if (vh4Var != null) {
                    th4.g().a(vh4Var);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<vh4, vh4> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            vh4 vh4Var = (vh4) pair.first;
            vh4 vh4Var2 = (vh4) pair.second;
            if (vh4Var2 != null) {
                this.a.t(vh4Var2);
            }
            if (vh4Var != null) {
                this.a.J(vh4Var);
            }
        }

        public /* synthetic */ j(wh4 wh4Var, a aVar) {
            this(wh4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<vh4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh4 a;

        public k(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<vh4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<vh4> linkedList = new LinkedList<>();
                linkedList.addAll(th4.g().f());
                Iterator<vh4> it = linkedList.iterator();
                while (it.hasNext()) {
                    vh4 next = it.next();
                    if (next != null && next.M()) {
                        th4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.n0();
                        th4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<vh4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<vh4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        vh4 next = it.next();
                        if (next.h() != null) {
                            this.a.J(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(wh4 wh4Var, a aVar) {
            this(wh4Var);
        }
    }

    /* loaded from: classes7.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final wh4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(100914694, "Lcom/repackage/wh4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(100914694, "Lcom/repackage/wh4$l;");
                    return;
                }
            }
            a = new wh4(null);
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BdAsyncTask<vh4, Integer, vh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wh4 a;

        public m(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public vh4 doInBackground(vh4... vh4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vh4VarArr)) == null) {
                if (vh4VarArr == null || vh4VarArr.length <= 0 || vh4VarArr[0] == null) {
                    return null;
                }
                vh4 vh4Var = vh4VarArr[0];
                th4.g().i(vh4Var);
                return vh4Var;
            }
            return (vh4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(vh4 vh4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vh4Var) == null) && vh4Var != null && vh4Var.z) {
                vh4Var.z = false;
                wh4 wh4Var = this.a;
                wh4Var.P(wh4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(wh4 wh4Var, a aVar) {
            this(wh4Var);
        }
    }

    public /* synthetic */ wh4(a aVar) {
        this();
    }

    public static final wh4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (wh4) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public final boolean B(vh4 vh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vh4Var)) == null) {
            if (vh4Var == null) {
                return false;
            }
            int[] h2 = vh4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<vh4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (vh4 vh4Var2 : list) {
                    if (vh4Var2 != null && vh4Var2.d() == vh4Var.d() && vh4Var2.q() == vh4Var.q()) {
                        if (vh4Var2.M()) {
                            H(vh4Var, vh4Var2);
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
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && ht4.k().l("app_restart_times", 0) > 1;
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
            cj4 cj4Var = this.i;
            if (cj4Var != null) {
                cj4Var.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<vh4> list = this.b.get(vh4.W);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (vh4 vh4Var : list) {
                Iterator<bi4> it = vh4Var.n().iterator();
                while (it.hasNext()) {
                    bi4 next = it.next();
                    if (next instanceof fi4) {
                        fi4 fi4Var = (fi4) next;
                        if (!next.e()) {
                            fi4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.e.get()) {
                return;
            }
            this.d.f(vh4.W);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public final void G(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vh4Var) == null) {
            t(vh4Var);
            new i(this, null).execute(vh4Var);
        }
    }

    public final void H(vh4 vh4Var, vh4 vh4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, vh4Var, vh4Var2) == null) {
            t(vh4Var2);
            new j(this, null).execute(new Pair(vh4Var, vh4Var2));
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

    public final void J(vh4 vh4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vh4Var) == null) {
            for (int i2 : vh4Var.h()) {
                List<vh4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(vh4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(vh4Var);
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
        List<vh4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && A() && this.f && (list = this.b.get((i2 = vh4.W))) != null && !list.isEmpty()) {
            boolean z = false;
            for (vh4 vh4Var : list) {
                if (vh4Var.x() == 8) {
                    Iterator<bi4> it = vh4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        bi4 next = it.next();
                        vh4 c2 = next.c();
                        if (c2 != null && (next instanceof fi4) && c2.d() == vh4Var.d() && c2.q() == vh4Var.q()) {
                            ((fi4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        fi4 fi4Var = new fi4(vh4Var);
                        fi4Var.g(0L);
                        fi4Var.f(false);
                        vh4Var.a(fi4Var);
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
            List<vh4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (vh4 vh4Var : list) {
                if (vh4Var.x() == 4) {
                    Iterator<bi4> it = vh4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        bi4 next = it.next();
                        if ((next instanceof ci4) && next.c().d() == vh4Var.d() && next.c().q() == vh4Var.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ci4 ci4Var = new ci4(vh4Var);
                        ci4Var.g(0L);
                        ci4Var.f(false);
                        vh4Var.a(ci4Var);
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
            List<vh4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (vh4 vh4Var : list) {
                if (vh4Var.x() == 2) {
                    Iterator<bi4> it = vh4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        bi4 next = it.next();
                        if ((next instanceof di4) && next.c().d() == vh4Var.d() && next.c().q() == vh4Var.q() && ((di4) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        di4 di4Var = new di4(vh4Var, j2);
                        di4Var.g(0L);
                        di4Var.f(false);
                        di4Var.h(vh4Var.w());
                        vh4Var.a(di4Var);
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
            List<vh4> list = this.b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (vh4 vh4Var : list) {
                if (vh4Var.x() == 1) {
                    p(vh4Var, j2);
                } else if (vh4Var.x() == 7 && !vh4Var.J(j2)) {
                    o(vh4Var, j2);
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
        List<vh4> list;
        ei4 ei4Var;
        vh4 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (vh4 vh4Var : list) {
            if (vh4Var.x() == 7) {
                Iterator<bi4> it = vh4Var.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        bi4 next = it.next();
                        if ((next instanceof ei4) && (c2 = (ei4Var = (ei4) next).c()) != null && ei4Var.i() == j2 && c2.d() == vh4Var.d() && c2.q() == vh4Var.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, vh4Var) == null) {
            T(vh4Var);
            new m(this, null).execute(vh4Var);
        }
    }

    public final void T(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, vh4Var) == null) || vh4Var == null) {
            return;
        }
        int x = vh4Var.x();
        Iterator<bi4> it = vh4Var.n().iterator();
        while (it.hasNext()) {
            bi4 next = it.next();
            if (next != null && next.c() != null) {
                vh4 c2 = next.c();
                if (c2.d() == vh4Var.d() && c2.q() == vh4Var.q()) {
                    if (x == 7 && (next instanceof ei4)) {
                        ((ei4) next).f(true);
                    } else if (x == 1 && (next instanceof gi4)) {
                        ((gi4) next).f(true);
                    }
                }
            }
        }
        vh4Var.c0(false);
    }

    public void m(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, vh4Var) == null) || vh4Var == null) {
            return;
        }
        if (vh4Var.x() == 9) {
            ji4.c().f(vh4Var);
        } else if (!this.f) {
            this.c.add(vh4Var);
        } else if (B(vh4Var)) {
        } else {
            J(vh4Var);
            new g(this, null).execute(vh4Var);
        }
    }

    public void n(List<vh4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (vh4 vh4Var : list) {
            if (vh4Var != null) {
                if (vh4Var.x() == 9) {
                    ji4.c().f(vh4Var);
                } else if (!B(vh4Var)) {
                    J(vh4Var);
                    arrayList.add(vh4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(vh4 vh4Var, long j2) {
        boolean z;
        ei4 ei4Var;
        vh4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, vh4Var, j2) == null) {
            Iterator<bi4> it = vh4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                bi4 next = it.next();
                if ((next instanceof ei4) && (c2 = (ei4Var = (ei4) next).c()) != null && ei4Var.i() == j2 && c2.d() == vh4Var.d() && c2.q() == vh4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            ei4 ei4Var2 = new ei4(vh4Var, j2);
            ei4Var2.g(0L);
            ei4Var2.f(false);
            ei4Var2.h(vh4Var.w());
            vh4Var.a(ei4Var2);
        }
    }

    public final void p(vh4 vh4Var, long j2) {
        boolean z;
        gi4 gi4Var;
        vh4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, vh4Var, j2) == null) {
            Iterator<bi4> it = vh4Var.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                bi4 next = it.next();
                if ((next instanceof gi4) && (c2 = (gi4Var = (gi4) next).c()) != null && gi4Var.i() == j2 && c2.d() == vh4Var.d() && c2.q() == vh4Var.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            gi4 gi4Var2 = new gi4(vh4Var, j2);
            gi4Var2.g(0L);
            gi4Var2.f(false);
            gi4Var2.h(vh4Var.w());
            vh4Var.a(gi4Var2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? UtilHelper.isSameDay(ht4.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? UtilHelper.isSameDay(x(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void t(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, vh4Var) == null) || vh4Var == null) {
            return;
        }
        Iterator<bi4> it = vh4Var.n().iterator();
        while (it.hasNext()) {
            bi4 next = it.next();
            if (next != null && next.c() != null) {
                vh4 c2 = next.c();
                if (c2.d() == vh4Var.d() && c2.q() == vh4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<vh4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<vh4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    vh4 next2 = it2.next();
                    if (next2 != null && next2.d() == vh4Var.d() && next2.q() == vh4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        uh4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + vh4Var.d() + ",missionId=" + vh4Var.q());
    }

    public final vh4 u(vh4 vh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, vh4Var)) == null) {
            if (vh4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<vh4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (vh4 vh4Var2 : valueAt) {
                        if (vh4Var2 != null && vh4Var2.d() == vh4Var.d() && vh4Var2.q() == vh4Var.q()) {
                            return vh4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (vh4) invokeL.objValue;
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
            long m2 = ht4.k().m("pref_key_active_config_info", 0L);
            this.n = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            List<vh4> list = this.b.get(i2);
            return (list == null || list.isEmpty()) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? !r() : invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ wh4 e;

        public f(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wh4Var;
            this.d = false;
        }

        public final void a(vh4 vh4Var, cj4.d dVar) {
            ArrayList<bi4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, vh4Var, dVar) == null) || vh4Var == null || dVar == null || (n = vh4Var.n()) == null) {
                return;
            }
            Iterator<bi4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                bi4 next = it.next();
                if (next instanceof gi4) {
                    gi4 gi4Var = (gi4) next;
                    if (this.b != 0 && gi4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(vh4Var);
                    }
                } else if (next instanceof ei4) {
                    ei4 ei4Var = (ei4) next;
                    if (!vh4Var.L() && ei4Var.d() == vh4Var.w()) {
                        if (this.b != 0 && ei4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && ei4Var.i() == this.b && !next.e()) {
                            if (next.b() >= vh4Var.f()) {
                                next.f(true);
                                vh4Var.I();
                            }
                            dVar.c(vh4Var);
                        }
                        int l = vh4Var.l();
                        int A = vh4Var.A();
                        long f = vh4Var.f() * vh4Var.A();
                        if (this.b != 0 && ei4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(vh4Var);
                            vh4Var.c0(true);
                        }
                    }
                } else if (next instanceof di4) {
                    if (this.c != 0 && ((di4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof ci4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(vh4 vh4Var, cj4.d dVar) {
            ArrayList<bi4> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vh4Var, dVar) == null) || vh4Var == null || dVar == null || (n = vh4Var.n()) == null) {
                return;
            }
            Iterator<bi4> it = n.iterator();
            while (it.hasNext()) {
                bi4 next = it.next();
                if ((next instanceof fi4) && !((fi4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(vh4Var);
                    }
                    dVar.c(vh4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<vh4> list = (List) this.e.b.get(vh4.W);
                List<vh4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                cj4.d dVar = new cj4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    th4.g().k(dVar.c);
                }
                if (ListUtils.isEmpty(dVar.a) && ListUtils.isEmpty(dVar.b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
            }
        }

        public final void d(List<vh4> list, cj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (vh4 vh4Var : list) {
                b(vh4Var, dVar);
            }
        }

        public final void e(List<vh4> list, cj4.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, dVar) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (vh4 vh4Var : list) {
                a(vh4Var, dVar);
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

        public /* synthetic */ f(wh4 wh4Var, a aVar) {
            this(wh4Var);
        }
    }

    public wh4() {
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
        cj4 cj4Var = new cj4(gen);
        this.i = cj4Var;
        cj4Var.w(this.t);
        wi4 wi4Var = new wi4(this.h);
        this.j = wi4Var;
        wi4Var.g(this.s);
        new yi4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        ft4.e().f();
        ji4.c().d(this.h);
        Q();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
