package d.a.q0.r0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.r0.a.c;
import d.a.q0.z3.a;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62404a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f62405b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.r0.a.c f62406c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.j2.e f62407d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.z3.a f62408e;

    /* renamed from: f  reason: collision with root package name */
    public e f62409f;

    /* loaded from: classes8.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62410a;

        public a(d dVar) {
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
            this.f62410a = dVar;
        }

        @Override // d.a.q0.r0.a.c.b
        public void a(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || this.f62410a.f62409f == null) {
                return;
            }
            this.f62410a.f62409f.b(i2, str, z, 0, 0L);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62411a;

        public b(d dVar) {
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
            this.f62411a = dVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.f62411a.f62409f == null) {
                return;
            }
            this.f62411a.f62409f.b(i2, str, z, 1, j);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62412a;

        public c(d dVar) {
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
            this.f62412a = dVar;
        }

        @Override // d.a.q0.z3.a.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62412a.f62407d.dismiss();
                if (this.f62412a.f62409f != null) {
                    this.f62412a.f62409f.a();
                }
                this.f62412a.f62406c.d();
            }
        }
    }

    /* renamed from: d.a.q0.r0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1616d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62413a;

        public C1616d(d dVar) {
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
            this.f62413a = dVar;
        }

        @Override // d.a.q0.z3.a.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62413a.f62407d == null) {
                return;
            }
            this.f62413a.f62407d.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void b(int i2, String str, boolean z, int i3, long j);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62404a = tbPageContext;
        d.a.q0.r0.a.c cVar = new d.a.q0.r0.a.c(tbPageContext, bdUniqueId);
        this.f62406c = cVar;
        cVar.e(new a(this));
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f62405b = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void d() {
        d.a.q0.z3.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f62408e) == null) {
            return;
        }
        aVar.f();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f62405b.removeFans(j);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f62409f = eVar;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f62407d == null) {
                d.a.q0.z3.a aVar = new d.a.q0.z3.a(this.f62404a.getContext());
                this.f62408e = aVar;
                aVar.i(this.f62404a.getString(R.string.confirm_remove_all_forbidden_fans));
                ArrayList arrayList = new ArrayList();
                a.b bVar = new a.b(this.f62404a.getString(R.string.confirm), this.f62408e);
                bVar.h(new c(this));
                arrayList.add(bVar);
                this.f62408e.h(new C1616d(this));
                this.f62408e.g(arrayList);
                d.a.q0.j2.e eVar = new d.a.q0.j2.e(this.f62404a.getPageActivity(), this.f62408e.b());
                this.f62407d = eVar;
                eVar.a(0.7f);
            }
            this.f62407d.show();
        }
    }
}
