package d.a.o0.a;

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
import d.a.o0.a.e0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f51257a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<d.a.o0.a.c>> f51258b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d.a.o0.a.c> f51259c;

    /* renamed from: d  reason: collision with root package name */
    public f f51260d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f51261e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51262f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51263g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f51264h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.a.e0.d f51265i;
    public d.a.o0.a.c0.c j;
    public d.a.o0.a.d0.b k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public d.a.o0.a.c0.a<d.a.o0.a.c0.b> t;
    public d.a.o0.m.b u;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f51266a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51266a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f51266a.f51262f = true;
                if (this.f51266a.f51259c.isEmpty()) {
                    return;
                }
                Iterator it = this.f51266a.f51259c.iterator();
                while (it.hasNext()) {
                    this.f51266a.m((d.a.o0.a.c) it.next());
                }
                this.f51266a.f51259c.clear();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f51267a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51267a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                this.f51267a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f51268a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51268a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                this.f51268a.f51263g = true;
                this.f51268a.q();
            }
        }
    }

    /* renamed from: d.a.o0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1164d implements d.a.o0.a.c0.a<d.a.o0.a.c0.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f51269a;

        public C1164d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51269a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.c0.a
        /* renamed from: b */
        public void a(d.a.o0.a.c0.b bVar) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || (activeCenterData = bVar.f51251g) == null || activeCenterData.mission == null) {
                return;
            }
            d.a.o0.a.c cVar = new d.a.o0.a.c();
            cVar.O(bVar.f51251g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            this.f51269a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.m.a
        /* renamed from: c */
        public void onSuccess(d.a.o0.a.c0.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
                return;
            }
            this.f51269a.n(bVar.b());
        }

        @Override // d.a.o0.m.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.o0.m.b<d.a.o0.a.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f51270a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51270a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.m.b
        /* renamed from: b */
        public void a(d.a.o0.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            d.a.o0.a.c w = this.f51270a.w(cVar);
            if (w != null && w.z) {
                w.R();
                this.f51270a.S(w);
                return;
            }
            p.b().h(w);
            if (w != null && w.x() == 7) {
                w.H();
                int F = w.F();
                int w2 = w.w();
                if (F <= 1 || F <= w2) {
                    this.f51270a.G(w);
                } else {
                    this.f51270a.S(w);
                }
            } else if (w == null || w.x() != 8) {
                this.f51270a.G(cVar);
            } else {
                this.f51270a.G(w);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends BdAsyncTask<d.a.o0.a.c, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.o0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                d.a.o0.a.a.g().a(cVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<List<d.a.o0.a.c>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<d.a.o0.a.c>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                d.a.o0.a.a.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BdAsyncTask<d.a.o0.a.c, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.o0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                d.a.o0.a.a.g().e(cVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends BdAsyncTask<Pair<d.a.o0.a.c, d.a.o0.a.c>, Integer, Pair<d.a.o0.a.c, d.a.o0.a.c>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f51276a;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51276a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<d.a.o0.a.c, d.a.o0.a.c> doInBackground(Pair<d.a.o0.a.c, d.a.o0.a.c>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<d.a.o0.a.c, d.a.o0.a.c> pair = pairArr[0];
                d.a.o0.a.c cVar = (d.a.o0.a.c) pair.first;
                d.a.o0.a.c cVar2 = (d.a.o0.a.c) pair.second;
                if (cVar2 != null) {
                    d.a.o0.a.a.g().e(cVar2);
                }
                if (cVar != null) {
                    d.a.o0.a.a.g().a(cVar);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<d.a.o0.a.c, d.a.o0.a.c> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            d.a.o0.a.c cVar = (d.a.o0.a.c) pair.first;
            d.a.o0.a.c cVar2 = (d.a.o0.a.c) pair.second;
            if (cVar2 != null) {
                this.f51276a.v(cVar2);
            }
            if (cVar != null) {
                this.f51276a.J(cVar);
            }
        }

        public /* synthetic */ j(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes7.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<d.a.o0.a.c>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f51277a;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51277a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<d.a.o0.a.c> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<d.a.o0.a.c> linkedList = new LinkedList<>();
                linkedList.addAll(d.a.o0.a.a.g().f());
                Iterator<d.a.o0.a.c> it = linkedList.iterator();
                while (it.hasNext()) {
                    d.a.o0.a.c next = it.next();
                    if (next != null && next.M()) {
                        d.a.o0.a.a.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.n0();
                        d.a.o0.a.a.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<d.a.o0.a.c> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<d.a.o0.a.c> it = linkedList.iterator();
                    while (it.hasNext()) {
                        d.a.o0.a.c next = it.next();
                        if (next.h() != null) {
                            this.f51277a.J(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f51278a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(154868870, "Ld/a/o0/a/d$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(154868870, "Ld/a/o0/a/d$l;");
                    return;
                }
            }
            f51278a = new d(null);
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BdAsyncTask<d.a.o0.a.c, Integer, d.a.o0.a.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f51279a;

        public m(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51279a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.o0.a.c doInBackground(d.a.o0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                d.a.o0.a.c cVar = cVarArr[0];
                d.a.o0.a.a.g().i(cVar);
                return cVar;
            }
            return (d.a.o0.a.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.o0.a.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && cVar != null && cVar.z) {
                cVar.z = false;
                d dVar = this.f51279a;
                dVar.P(dVar.l, this.f51279a.m);
            }
        }

        public /* synthetic */ m(d dVar, a aVar) {
            this(dVar);
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static final d y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.f51278a : (d) invokeV.objValue;
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

    public final boolean C(d.a.o0.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            int[] h2 = cVar.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<d.a.o0.a.c> list = this.f51258b.get(i2);
                if (list == null) {
                    return false;
                }
                for (d.a.o0.a.c cVar2 : list) {
                    if (cVar2 != null && cVar2.d() == cVar.d() && cVar2.q() == cVar.q()) {
                        if (cVar2.M()) {
                            H(cVar, cVar2);
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

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f51261e.compareAndSet(true, false);
            this.f51260d.f(0);
            this.f51260d.h(0L);
            this.f51260d.g(0L);
            d.a.o0.a.e0.d dVar = this.f51265i;
            if (dVar != null) {
                dVar.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<d.a.o0.a.c> list = this.f51258b.get(d.a.o0.a.c.V);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (d.a.o0.a.c cVar : list) {
                Iterator<d.a.o0.a.j> it = cVar.n().iterator();
                while (it.hasNext()) {
                    d.a.o0.a.j next = it.next();
                    if (next instanceof n) {
                        n nVar = (n) next;
                        if (!next.e()) {
                            nVar.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.f51261e.get()) {
                return;
            }
            this.f51260d.f(d.a.o0.a.c.V);
            this.f51261e.compareAndSet(false, true);
            synchronized (this.f51261e) {
                this.f51261e.notify();
            }
        }
    }

    public final void G(d.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            v(cVar);
            new i(this, null).execute(cVar);
        }
    }

    public final void H(d.a.o0.a.c cVar, d.a.o0.a.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cVar, cVar2) == null) {
            v(cVar2);
            new j(this, null).execute(new Pair(cVar, cVar2));
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null && B()) {
                this.j.f(A(), D(), 1);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J(d.a.o0.a.c cVar) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            for (int i2 : cVar.h()) {
                List<d.a.o0.a.c> list = this.f51258b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(cVar);
                    this.f51258b.put(i2, linkedList);
                } else {
                    list.add(cVar);
                }
            }
        }
    }

    public void K(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && B()) {
            this.n = i2;
            long j3 = this.m;
            if (j3 > 0 && this.l > 0 && (j2 == 0 || j2 != j3)) {
                R(this.l, this.m);
                this.m = 0L;
                this.l = 0;
            }
            M();
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.p = z;
        }
    }

    public void M() {
        int i2;
        List<d.a.o0.a.c> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && B() && this.f51262f && (list = this.f51258b.get((i2 = d.a.o0.a.c.V))) != null && !list.isEmpty()) {
            boolean z = false;
            for (d.a.o0.a.c cVar : list) {
                if (cVar.x() == 8) {
                    Iterator<d.a.o0.a.j> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.o0.a.j next = it.next();
                        d.a.o0.a.c c2 = next.c();
                        if (c2 != null && (next instanceof n) && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                            ((n) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        n nVar = new n(cVar);
                        nVar.g(0L);
                        nVar.f(false);
                        cVar.a(nVar);
                    }
                }
            }
            this.f51260d.f(i2);
            this.f51261e.compareAndSet(false, true);
            synchronized (this.f51261e) {
                this.f51261e.notify();
            }
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && B() && i2 != 0 && this.f51262f) {
            this.l = i2;
            List<d.a.o0.a.c> list = this.f51258b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (d.a.o0.a.c cVar : list) {
                if (cVar.x() == 4) {
                    Iterator<d.a.o0.a.j> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.o0.a.j next = it.next();
                        if ((next instanceof d.a.o0.a.k) && next.c().d() == cVar.d() && next.c().q() == cVar.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.a.o0.a.k kVar = new d.a.o0.a.k(cVar);
                        kVar.g(0L);
                        kVar.f(false);
                        cVar.a(kVar);
                    }
                }
            }
            this.f51260d.f(i2);
            this.f51261e.compareAndSet(false, true);
            synchronized (this.f51261e) {
                this.f51261e.notify();
            }
        }
    }

    public void O(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && B() && i2 != 0 && j2 != 0 && this.f51262f) {
            this.l = i2;
            List<d.a.o0.a.c> list = this.f51258b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (d.a.o0.a.c cVar : list) {
                if (cVar.x() == 2) {
                    Iterator<d.a.o0.a.j> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.o0.a.j next = it.next();
                        if ((next instanceof d.a.o0.a.l) && next.c().d() == cVar.d() && next.c().q() == cVar.q() && ((d.a.o0.a.l) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        d.a.o0.a.l lVar = new d.a.o0.a.l(cVar, j2);
                        lVar.g(0L);
                        lVar.f(false);
                        lVar.h(cVar.w());
                        cVar.a(lVar);
                    }
                }
            }
            this.f51260d.f(i2);
            this.f51260d.g(j2);
            this.f51261e.compareAndSet(false, true);
            synchronized (this.f51261e) {
                this.f51261e.notify();
            }
        }
    }

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && B() && i2 != 0 && j2 != 0 && this.f51262f) {
            this.l = i2;
            List<d.a.o0.a.c> list = this.f51258b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (d.a.o0.a.c cVar : list) {
                if (cVar.x() == 1) {
                    p(cVar, j2);
                } else if (cVar.x() == 7 && !cVar.J(j2)) {
                    o(cVar, j2);
                }
            }
            this.f51260d.f(i2);
            this.f51260d.h(j2);
            this.m = j2;
            this.f51261e.compareAndSet(false, true);
            synchronized (this.f51261e) {
                this.f51261e.notify();
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f51257a.scheduleWithFixedDelay(this.f51260d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public void R(int i2, long j2) {
        List<d.a.o0.a.c> list;
        d.a.o0.a.m mVar;
        d.a.o0.a.c c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.f51258b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (d.a.o0.a.c cVar : list) {
            if (cVar.x() == 7) {
                Iterator<d.a.o0.a.j> it = cVar.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        d.a.o0.a.j next = it.next();
                        if ((next instanceof d.a.o0.a.m) && (c2 = (mVar = (d.a.o0.a.m) next).c()) != null && mVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void S(d.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            T(cVar);
            new m(this, null).execute(cVar);
        }
    }

    public final void T(d.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) || cVar == null) {
            return;
        }
        int x = cVar.x();
        Iterator<d.a.o0.a.j> it = cVar.n().iterator();
        while (it.hasNext()) {
            d.a.o0.a.j next = it.next();
            if (next != null && next.c() != null) {
                d.a.o0.a.c c2 = next.c();
                if (c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    if (x == 7 && (next instanceof d.a.o0.a.m)) {
                        ((d.a.o0.a.m) next).f(true);
                    } else if (x == 1 && (next instanceof o)) {
                        ((o) next).f(true);
                    }
                }
            }
        }
        cVar.c0(false);
    }

    public void m(d.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) || cVar == null) {
            return;
        }
        if (cVar.x() == 9) {
            r.c().f(cVar);
        } else if (!this.f51262f) {
            this.f51259c.add(cVar);
        } else if (C(cVar)) {
        } else {
            J(cVar);
            new g(this, null).execute(cVar);
        }
    }

    public void n(List<d.a.o0.a.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f51262f) {
            this.f51259c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.o0.a.c cVar : list) {
            if (cVar != null) {
                if (cVar.x() == 9) {
                    r.c().f(cVar);
                } else if (!C(cVar)) {
                    J(cVar);
                    arrayList.add(cVar);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(d.a.o0.a.c cVar, long j2) {
        boolean z;
        d.a.o0.a.m mVar;
        d.a.o0.a.c c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, cVar, j2) == null) {
            Iterator<d.a.o0.a.j> it = cVar.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                d.a.o0.a.j next = it.next();
                if ((next instanceof d.a.o0.a.m) && (c2 = (mVar = (d.a.o0.a.m) next).c()) != null && mVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            d.a.o0.a.m mVar2 = new d.a.o0.a.m(cVar, j2);
            mVar2.g(0L);
            mVar2.f(false);
            mVar2.h(cVar.w());
            cVar.a(mVar2);
        }
    }

    public final void p(d.a.o0.a.c cVar, long j2) {
        boolean z;
        o oVar;
        d.a.o0.a.c c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, cVar, j2) == null) {
            Iterator<d.a.o0.a.j> it = cVar.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                d.a.o0.a.j next = it.next();
                if ((next instanceof o) && (c2 = (oVar = (o) next).c()) != null && oVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            o oVar2 = new o(cVar, j2);
            oVar2.g(0L);
            oVar2.f(false);
            oVar2.h(cVar.w());
            cVar.a(oVar2);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.j != null && B() && this.f51263g && !t()) {
            this.j.f(A(), D(), 0);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.k != null && B()) {
            this.k.d();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? UtilHelper.isSameDay(d.a.o0.r.d0.b.j().l("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? UtilHelper.isSameDay(z(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? UtilHelper.isSameDay(d.a.o0.r.d0.b.j().l("pref_key_last_popup_time", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v(d.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) || cVar == null) {
            return;
        }
        Iterator<d.a.o0.a.j> it = cVar.n().iterator();
        while (it.hasNext()) {
            d.a.o0.a.j next = it.next();
            if (next != null && next.c() != null) {
                d.a.o0.a.c c2 = next.c();
                if (c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.f51258b.size(); i2++) {
            List<d.a.o0.a.c> valueAt = this.f51258b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<d.a.o0.a.c> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    d.a.o0.a.c next2 = it2.next();
                    if (next2 != null && next2.d() == cVar.d() && next2.q() == cVar.q()) {
                        it2.remove();
                    }
                }
            }
        }
        d.a.o0.a.b.a("deleteActivityMissionInfoDataInMemory-->activityId=" + cVar.d() + ",missionId=" + cVar.q());
    }

    public final d.a.o0.a.c w(d.a.o0.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.f51258b.size(); i2++) {
                List<d.a.o0.a.c> valueAt = this.f51258b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (d.a.o0.a.c cVar2 : valueAt) {
                        if (cVar2 != null && cVar2.d() == cVar.d() && cVar2.q() == cVar.q()) {
                            return cVar2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (d.a.o0.a.c) invokeL.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.n : invokeV.intValue;
    }

    public final long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            long l2 = d.a.o0.r.d0.b.j().l("pref_key_active_config_info", 0L);
            this.o = l2;
            return l2;
        }
        return invokeV.longValue;
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile int f51271e;

        /* renamed from: f  reason: collision with root package name */
        public volatile long f51272f;

        /* renamed from: g  reason: collision with root package name */
        public volatile long f51273g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f51274h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f51275i;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51275i = dVar;
            this.f51274h = false;
        }

        public final void a(d.a.o0.a.c cVar, d.C1166d c1166d) {
            ArrayList<d.a.o0.a.j> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, c1166d) == null) || cVar == null || c1166d == null || (n = cVar.n()) == null) {
                return;
            }
            Iterator<d.a.o0.a.j> it = n.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                d.a.o0.a.j next = it.next();
                if (next instanceof o) {
                    o oVar = (o) next;
                    if (this.f51272f != 0 && oVar.i() == this.f51272f && !next.e()) {
                        this.f51274h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                c1166d.b(next);
                            }
                        }
                        c1166d.c(cVar);
                    }
                } else if (next instanceof d.a.o0.a.m) {
                    d.a.o0.a.m mVar = (d.a.o0.a.m) next;
                    if (!cVar.L() && mVar.d() == cVar.w()) {
                        if (this.f51272f != 0 && mVar.i() == this.f51272f && !next.e()) {
                            this.f51274h = false;
                            next.a(1);
                        }
                        i2 = (int) (i2 + next.b());
                        if (this.f51272f != 0 && mVar.i() == this.f51272f && !next.e()) {
                            if (next.b() >= cVar.f()) {
                                next.f(true);
                                cVar.I();
                            }
                            c1166d.c(cVar);
                        }
                        int l = cVar.l();
                        int A = cVar.A();
                        long f2 = cVar.f() * cVar.A();
                        if (this.f51272f != 0 && mVar.i() == this.f51272f) {
                            next.e();
                        }
                        if (i2 >= f2 && l >= A) {
                            c1166d.a(cVar);
                            cVar.c0(true);
                        }
                    }
                } else if (next instanceof d.a.o0.a.l) {
                    if (this.f51273g != 0 && ((d.a.o0.a.l) next).i() == this.f51273g && !next.e()) {
                        this.f51274h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                c1166d.b(next);
                            }
                        }
                    }
                } else if ((next instanceof d.a.o0.a.k) && !next.e()) {
                    this.f51274h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c1166d.b(next);
                    }
                }
            }
        }

        public final void b(d.a.o0.a.c cVar, d.C1166d c1166d) {
            ArrayList<d.a.o0.a.j> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, c1166d) == null) || cVar == null || c1166d == null || (n = cVar.n()) == null) {
                return;
            }
            Iterator<d.a.o0.a.j> it = n.iterator();
            while (it.hasNext()) {
                d.a.o0.a.j next = it.next();
                if ((next instanceof n) && !((n) next).j() && !next.e()) {
                    this.f51274h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c1166d.a(cVar);
                    }
                    c1166d.c(cVar);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f51274h = true;
                List<d.a.o0.a.c> list = (List) this.f51275i.f51258b.get(d.a.o0.a.c.V);
                List<d.a.o0.a.c> list2 = (List) this.f51275i.f51258b.get(this.f51271e);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.f51275i.f51261e.compareAndSet(true, false);
                    return;
                }
                d.C1166d c1166d = new d.C1166d();
                c1166d.f51324a = new LinkedList();
                c1166d.f51325b = new LinkedList();
                c1166d.f51326c = new LinkedList();
                d(list, c1166d);
                e(list2, c1166d);
                if (this.f51274h) {
                    this.f51275i.f51261e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(c1166d.f51326c)) {
                    d.a.o0.a.a.g().k(c1166d.f51326c);
                }
                if (ListUtils.isEmpty(c1166d.f51324a) && ListUtils.isEmpty(c1166d.f51325b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, c1166d));
            }
        }

        public final void d(List<d.a.o0.a.c> list, d.C1166d c1166d) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, c1166d) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (d.a.o0.a.c cVar : list) {
                b(cVar, c1166d);
            }
        }

        public final void e(List<d.a.o0.a.c> list, d.C1166d c1166d) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, c1166d) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (d.a.o0.a.c cVar : list) {
                a(cVar, c1166d);
            }
        }

        public synchronized void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                synchronized (this) {
                    this.f51271e = i2;
                }
            }
        }

        public synchronized void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                synchronized (this) {
                    this.f51273g = j;
                }
            }
        }

        public synchronized void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                synchronized (this) {
                    this.f51272f = j;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.f51271e == 0 || !this.f51275i.f51261e.get()) {
                    synchronized (this.f51275i.f51261e) {
                        try {
                            this.f51275i.f51261e.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                c();
            }
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d() {
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
        this.f51257a = Executors.newSingleThreadScheduledExecutor();
        this.f51258b = new SparseArray<>();
        this.f51259c = new LinkedList<>();
        this.f51260d = new f(this, null);
        this.f51261e = new AtomicBoolean(false);
        this.f51262f = false;
        this.f51263g = false;
        this.p = false;
        this.q = new a(this, 2921391);
        this.r = new b(this, 2001011);
        this.s = new c(this, 2001371);
        this.t = new C1164d(this);
        this.u = new e(this);
        BdUniqueId gen = BdUniqueId.gen();
        this.f51264h = gen;
        d.a.o0.a.e0.d dVar = new d.a.o0.a.e0.d(gen);
        this.f51265i = dVar;
        dVar.w(this.u);
        d.a.o0.a.c0.c cVar = new d.a.o0.a.c0.c(this.f51264h);
        this.j = cVar;
        cVar.g(this.t);
        this.k = new d.a.o0.a.d0.b(this.f51264h);
        this.s.setTag(this.f51264h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.f51264h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.f51264h);
        MessageManager.getInstance().registerListener(this.q);
        d.a.o0.r.c0.a.e().f();
        r.c().d(this.f51264h);
        Q();
        if (B()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
