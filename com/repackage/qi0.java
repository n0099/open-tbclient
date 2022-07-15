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
import com.repackage.w11;
import com.repackage.xi0;
/* loaded from: classes7.dex */
public class qi0 extends dc1<w11> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements w11 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.qi0$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0715a extends ik0<xi0> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w11.b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0715a(a aVar, Class cls, w11.b bVar) {
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
            @Override // com.repackage.ik0
            public void onEvent(@NonNull xi0 xi0Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi0Var) == null) || this.b == null || xx0.g(xi0Var.a)) {
                    return;
                }
                for (xi0.a aVar : xi0Var.a) {
                    if (aVar instanceof xi0.a) {
                        xi0.a aVar2 = aVar;
                        if (!TextUtils.isEmpty(aVar2.b) && !TextUtils.isEmpty(aVar2.a) && !TextUtils.isEmpty(aVar2.c)) {
                            this.b.a("javascript:" + aVar2.a + "('" + yx0.a(aVar2.c) + "');");
                        }
                    }
                }
            }
        }

        public a(qi0 qi0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.w11
        public void a(Object obj, w11.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, bVar) == null) {
                ek0.a().b(obj, new C0715a(this, xi0.class, bVar));
            }
        }

        @Override // com.repackage.w11
        public void b(Context context, RelativeLayout relativeLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, relativeLayout, str) == null) {
                LPDownloadManager.f(context, relativeLayout, str, true);
            }
        }

        @Override // com.repackage.w11
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    public qi0() {
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
    @Override // com.repackage.dc1
    /* renamed from: a */
    public w11 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (w11) invokeV.objValue;
    }
}
