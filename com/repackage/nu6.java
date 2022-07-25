package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class nu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final BdUniqueId b;
    public RecPersonalizePageModel c;
    public ConcernNetModel d;
    public d e;
    public RecPersonalizePageModel.c f;
    public ConcernNetModel.d g;
    public ConcernNetModel.c h;

    /* loaded from: classes6.dex */
    public class a implements RecPersonalizePageModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu6 a;

        public a(nu6 nu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu6Var;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.e != null) {
                    TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                    jz6.a("mOnResultListenerSuccess");
                    this.a.e.b(dataRes, z, z2);
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || this.a.e == null) {
                return;
            }
            TbSingleton.getInstance().mIsForceLayoutMaintab = true;
            jz6.a("mOnResultListenerError");
            this.a.e.c("", str, i, false, 1);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ConcernNetModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu6 a;

        public b(nu6 nu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu6Var;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, dataRes, z) == null) || this.a.e == null) {
                return;
            }
            this.a.e.d(dataRes, z);
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || this.a.e == null) {
                return;
            }
            this.a.e.c("", str, i, false, 0);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ConcernNetModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu6 a;

        public c(nu6 nu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu6Var;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.e == null) {
                return;
            }
            this.a.e.a(z);
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i, boolean z, int i2);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, rz6 rz6Var, boolean z2, String str, String str2, boolean z3);
    }

    public nu6(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = RecPersonalizePageModel.g();
        this.f = new a(this);
        this.g = new b(this);
        this.h = new c(this);
        this.a = tbPageContext;
        this.b = bdUniqueId;
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.d = concernNetModel;
        concernNetModel.H(this.g);
        this.d.G(this.h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (concernNetModel = this.d) == null) {
            return;
        }
        concernNetModel.D(z);
    }

    public TbPageContext<BaseFragmentActivity> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (TbPageContext) invokeV.objValue;
    }

    public ee7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ee7) invokeV.objValue;
    }

    public RecPersonalizePageModel.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (RecPersonalizePageModel.c) invokeV.objValue;
    }

    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (d) invokeV.objValue;
    }

    public BdUniqueId g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (BdUniqueId) invokeV.objValue;
    }

    public void h(String str, xc5 xc5Var) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, xc5Var) == null) || (concernNetModel = this.d) == null) {
            return;
        }
        concernNetModel.E(str, xc5Var);
    }

    public void i(int i, int i2, xc5 xc5Var, int i3, int i4) {
        RecPersonalizePageModel recPersonalizePageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), xc5Var, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || (recPersonalizePageModel = this.c) == null) {
            return;
        }
        recPersonalizePageModel.i(i, i2, xc5Var, i3, i4);
    }

    public void j(ee7 ee7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ee7Var) == null) {
        }
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.e = dVar;
        }
    }
}
