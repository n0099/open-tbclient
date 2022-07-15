package com.repackage;

import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* loaded from: classes7.dex */
    public class a implements fm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ qy4 c;

        public a(qy4 qy4Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qy4Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qy4Var;
            this.a = z;
            this.b = z2;
        }

        @Override // com.repackage.fm4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    py4.d().V(true);
                }
                if (this.b) {
                    nz4.l(this.c.a.getPageActivity());
                } else {
                    kz4.e(this.c.a);
                }
            }
        }

        @Override // com.repackage.fm4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    public qy4(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public void b(int i) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (i == 1 || i == 2) {
            if (UbsABTestHelper.isPushOpenNewStyle()) {
                boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.getPageActivity()).areNotificationsEnabled();
                boolean C = py4.d().C();
                if (!(areNotificationsEnabled && C) && nz4.g(TbadkCoreApplication.getInst(), 0)) {
                    a aVar = new a(this, C, areNotificationsEnabled);
                    if (i == 1) {
                        nz4.k(this.a, 4, aVar);
                    } else {
                        nz4.k(this.a, 5, aVar);
                    }
                }
            } else if (kz4.g(TbadkCoreApplication.getInst(), 0)) {
                kz4.i(this.a, 5, 0L);
            }
        }
    }
}
