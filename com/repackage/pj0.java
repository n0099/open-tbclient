package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.presenter.LPDownloadManager;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.r21;
import com.repackage.vj0;
/* loaded from: classes6.dex */
public class pj0 extends qc1<r21> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements r21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.pj0$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0490a extends el0<vj0> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r21.b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0490a(a aVar, Class cls, r21.b bVar) {
                super(cls);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cls, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Class) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.el0
            public void onEvent(@NonNull vj0 vj0Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vj0Var) == null) || this.b == null || ty0.g(vj0Var.a)) {
                    return;
                }
                for (vj0.a aVar : vj0Var.a) {
                    if (aVar instanceof vj0.a) {
                        vj0.a aVar2 = aVar;
                        if (!TextUtils.isEmpty(aVar2.b) && !TextUtils.isEmpty(aVar2.a) && !TextUtils.isEmpty(aVar2.c)) {
                            this.b.a("javascript:" + aVar2.a + "('" + uy0.a(aVar2.c) + "');");
                        }
                    }
                }
            }
        }

        public a(pj0 pj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.r21
        public void a(Object obj, r21.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, bVar) == null) {
                al0.a().b(obj, new C0490a(this, vj0.class, bVar));
            }
        }

        @Override // com.repackage.r21
        public void b(Context context, RelativeLayout relativeLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, relativeLayout, str) == null) {
                LPDownloadManager.f(context, relativeLayout, str, true);
            }
        }

        @Override // com.repackage.r21
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    public pj0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    @Override // com.repackage.qc1
    /* renamed from: a */
    public r21 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (r21) invokeV.objValue;
    }
}
