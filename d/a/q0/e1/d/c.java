package d.a.q0.e1.d;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f55775a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f55776b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f55777c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f55778d;

    /* renamed from: e  reason: collision with root package name */
    public d f55779e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f55780f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f55781g;

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f55782h;

    /* loaded from: classes8.dex */
    public class a implements RecPersonalizePageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55783a;

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
            this.f55783a = cVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f55783a.f55779e == null) {
                return;
            }
            this.f55783a.f55779e.b(dataRes, z, z2);
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f55783a.f55779e == null) {
                return;
            }
            this.f55783a.f55779e.c("", str, i2, false, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ConcernNetModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55784a;

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
            this.f55784a = cVar;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, dataRes, z) == null) || this.f55784a.f55779e == null) {
                return;
            }
            this.f55784a.f55779e.d(dataRes, z);
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f55784a.f55779e == null) {
                return;
            }
            this.f55784a.f55779e.c("", str, i2, false, 0);
        }
    }

    /* renamed from: d.a.q0.e1.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1339c implements ConcernNetModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55785a;

        public C1339c(c cVar) {
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
            this.f55785a = cVar;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f55785a.f55779e == null) {
                return;
            }
            this.f55785a.f55779e.a(z);
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i2, boolean z, int i3);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, d.a.q0.e1.i.a.a aVar, boolean z2, String str, String str2, boolean z3);
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
        this.f55780f = new a(this);
        this.f55781g = new b(this);
        this.f55782h = new C1339c(this);
        this.f55775a = tbPageContext;
        this.f55776b = bdUniqueId;
        RecPersonalizePageModel recPersonalizePageModel = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.f55777c = recPersonalizePageModel;
        recPersonalizePageModel.G(this.f55780f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f55778d = concernNetModel;
        concernNetModel.E(this.f55781g);
        this.f55778d.D(this.f55782h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (concernNetModel = this.f55778d) == null) {
            return;
        }
        concernNetModel.z(z);
    }

    public TbPageContext<BaseFragmentActivity> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55775a : (TbPageContext) invokeV.objValue;
    }

    public d.a.q0.n1.s.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (d.a.q0.n1.s.a) invokeV.objValue;
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55779e : (d) invokeV.objValue;
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55776b : (BdUniqueId) invokeV.objValue;
    }

    public void g(String str, d.a.p0.b1.c cVar) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) || (concernNetModel = this.f55778d) == null) {
            return;
        }
        concernNetModel.A(str, cVar);
    }

    public void h(int i2, int i3, d.a.p0.b1.c cVar, int i4, int i5) {
        RecPersonalizePageModel recPersonalizePageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (recPersonalizePageModel = this.f55777c) == null) {
            return;
        }
        recPersonalizePageModel.z(i2, i3, cVar, i4, i5);
    }

    public void i(d.a.q0.n1.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f55779e = dVar;
        }
    }
}
