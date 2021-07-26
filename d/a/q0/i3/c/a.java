package d.a.q0.i3.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.i3.b.a f59421a;

    /* renamed from: b  reason: collision with root package name */
    public c f59422b;

    /* renamed from: c  reason: collision with root package name */
    public c f59423c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.e.l.c<d.a.d.k.d.a> f59424d;

    /* renamed from: d.a.q0.i3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1492a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59425a;

        public C1492a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59425a = aVar;
        }

        @Override // d.a.q0.i3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59425a.f59421a = null;
                if (this.f59425a.f59422b != null) {
                    this.f59425a.f59422b.a();
                }
            }
        }

        @Override // d.a.q0.i3.c.a.c
        public void b(d.a.q0.i3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f59425a.f59421a = aVar;
                if (this.f59425a.f59422b != null) {
                    this.f59425a.f59422b.b(aVar);
                }
            }
        }

        @Override // d.a.q0.i3.c.a.c
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f59425a.f59422b == null) {
                return;
            }
            this.f59425a.f59422b.c(obj);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59426a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59426a = aVar;
        }

        @Override // d.a.d.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.f59426a.f59422b != null) {
                    this.f59426a.f59422b.a();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || aVar.p() == null) {
                    if (this.f59426a.f59422b != null) {
                        this.f59426a.f59422b.a();
                    }
                } else if (this.f59426a.f59422b != null) {
                    this.f59426a.f59422b.c(aVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a();

        void b(d.a.q0.i3.b.a aVar);

        void c(Object obj);
    }

    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<String, Void, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f59427a;

        public d(a aVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59427a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Object doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
                String postNetData = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || c(postNetData)) {
                    return null;
                }
                d.a.q0.i3.b.a aVar = new d.a.q0.i3.b.a();
                aVar.b(postNetData);
                return aVar;
            }
            return invokeL.objValue;
        }

        public final boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null) {
                    try {
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(str);
                        return errorData.error_code != 0;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (cVar = this.f59427a) == null) {
                return;
            }
            if (obj instanceof d.a.q0.i3.b.a) {
                cVar.b((d.a.q0.i3.b.a) obj);
            } else {
                cVar.a();
            }
        }
    }

    public a() {
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
        this.f59423c = new C1492a(this);
        this.f59424d = new b(this);
    }

    public d.a.q0.i3.b.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.q0.i3.b.a aVar = this.f59421a;
            if (aVar != null && !ListUtils.isEmpty(aVar.f59413a)) {
                for (d.a.q0.i3.b.b bVar : this.f59421a.f59413a) {
                    if (bVar != null && bVar.b() && bVar.f59416b == 3) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (d.a.q0.i3.b.b) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d dVar = new d(this, this.f59423c);
            dVar.setSelfExecute(true);
            dVar.execute(new String[0]);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.i3.b.b c2 = c();
            if (c2 != null && !TextUtils.isEmpty(c2.f59419e)) {
                f(c2.f59418d, c2.f59419e, true);
                return;
            }
            c cVar = this.f59422b;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public final void f(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (i2 == 1 || i2 == 2) {
                if (z) {
                    d.a.d.e.l.d.h().m(str, 10, this.f59424d, null);
                } else {
                    d.a.d.e.l.d.h().m(str, 10, null, null);
                }
            }
        }
    }

    public void g() {
        d.a.q0.i3.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f59421a) == null || ListUtils.isEmpty(aVar.f59413a)) {
            return;
        }
        d.a.q0.i3.b.b c2 = c();
        for (d.a.q0.i3.b.b bVar : this.f59421a.f59413a) {
            if (bVar != null && bVar != c2 && bVar.b() && bVar.f59416b != 4) {
                f(bVar.f59418d, bVar.f59419e, false);
            }
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f59422b = cVar;
        }
    }
}
