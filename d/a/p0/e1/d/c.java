package d.a.p0.e1.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f55231a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f55232b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f55233c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f55234d;

    /* renamed from: e  reason: collision with root package name */
    public d f55235e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f55236f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f55237g;

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f55238h;

    /* loaded from: classes7.dex */
    public class a implements RecPersonalizePageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55239a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55239a = cVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f55239a.f55235e == null) {
                return;
            }
            this.f55239a.f55235e.b(dataRes, z, z2);
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f55239a.f55235e == null) {
                return;
            }
            this.f55239a.f55235e.c("", str, i2, false, 1);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ConcernNetModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55240a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55240a = cVar;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, dataRes, z) == null) || this.f55240a.f55235e == null) {
                return;
            }
            this.f55240a.f55235e.d(dataRes, z);
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f55240a.f55235e == null) {
                return;
            }
            this.f55240a.f55235e.c("", str, i2, false, 0);
        }
    }

    /* renamed from: d.a.p0.e1.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1330c implements ConcernNetModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55241a;

        public C1330c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55241a = cVar;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f55241a.f55235e == null) {
                return;
            }
            this.f55241a.f55235e.a(z);
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i2, boolean z, int i3);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, d.a.p0.e1.i.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f55236f = new a(this);
        this.f55237g = new b(this);
        this.f55238h = new C1330c(this);
        this.f55231a = tbPageContext;
        this.f55232b = bdUniqueId;
        RecPersonalizePageModel recPersonalizePageModel = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.f55233c = recPersonalizePageModel;
        recPersonalizePageModel.G(this.f55236f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f55234d = concernNetModel;
        concernNetModel.E(this.f55237g);
        this.f55234d.D(this.f55238h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (concernNetModel = this.f55234d) == null) {
            return;
        }
        concernNetModel.z(z);
    }

    public TbPageContext<BaseFragmentActivity> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55231a : (TbPageContext) invokeV.objValue;
    }

    public d.a.p0.n1.s.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (d.a.p0.n1.s.a) invokeV.objValue;
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55235e : (d) invokeV.objValue;
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55232b : (BdUniqueId) invokeV.objValue;
    }

    public void g(String str, d.a.o0.z0.c cVar) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) || (concernNetModel = this.f55234d) == null) {
            return;
        }
        concernNetModel.A(str, cVar);
    }

    public void h(int i2, int i3, d.a.o0.z0.c cVar, int i4, int i5) {
        RecPersonalizePageModel recPersonalizePageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (recPersonalizePageModel = this.f55233c) == null) {
            return;
        }
        recPersonalizePageModel.z(i2, i3, cVar, i4, i5);
    }

    public void i(d.a.p0.n1.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f55235e = dVar;
        }
    }
}
