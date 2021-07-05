package d.a.s0.r0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.r0.a.c;
import d.a.s0.z3.a;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65012a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f65013b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.r0.a.c f65014c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.j2.e f65015d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.z3.a f65016e;

    /* renamed from: f  reason: collision with root package name */
    public e f65017f;

    /* loaded from: classes9.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65018a;

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
            this.f65018a = dVar;
        }

        @Override // d.a.s0.r0.a.c.b
        public void a(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || this.f65018a.f65017f == null) {
                return;
            }
            this.f65018a.f65017f.b(i2, str, z, 0, 0L);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65019a;

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
            this.f65019a = dVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.f65019a.f65017f == null) {
                return;
            }
            this.f65019a.f65017f.b(i2, str, z, 1, j);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65020a;

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
            this.f65020a = dVar;
        }

        @Override // d.a.s0.z3.a.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65020a.f65015d.dismiss();
                if (this.f65020a.f65017f != null) {
                    this.f65020a.f65017f.a();
                }
                this.f65020a.f65014c.d();
            }
        }
    }

    /* renamed from: d.a.s0.r0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1653d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65021a;

        public C1653d(d dVar) {
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
            this.f65021a = dVar;
        }

        @Override // d.a.s0.z3.a.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f65021a.f65015d == null) {
                return;
            }
            this.f65021a.f65015d.dismiss();
        }
    }

    /* loaded from: classes9.dex */
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
        this.f65012a = tbPageContext;
        d.a.s0.r0.a.c cVar = new d.a.s0.r0.a.c(tbPageContext, bdUniqueId);
        this.f65014c = cVar;
        cVar.e(new a(this));
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f65013b = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void d() {
        d.a.s0.z3.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f65016e) == null) {
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
            this.f65013b.removeFans(j);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f65017f = eVar;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f65015d == null) {
                d.a.s0.z3.a aVar = new d.a.s0.z3.a(this.f65012a.getContext());
                this.f65016e = aVar;
                aVar.i(this.f65012a.getString(R.string.confirm_remove_all_forbidden_fans));
                ArrayList arrayList = new ArrayList();
                a.b bVar = new a.b(this.f65012a.getString(R.string.confirm), this.f65016e);
                bVar.h(new c(this));
                arrayList.add(bVar);
                this.f65016e.h(new C1653d(this));
                this.f65016e.g(arrayList);
                d.a.s0.j2.e eVar = new d.a.s0.j2.e(this.f65012a.getPageActivity(), this.f65016e.b());
                this.f65015d = eVar;
                eVar.a(0.7f);
            }
            this.f65015d.show();
        }
    }
}
