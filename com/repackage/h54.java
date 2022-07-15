package com.repackage;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.PermissionChecker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lv2;
import com.repackage.m53;
/* loaded from: classes6.dex */
public class h54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    h54.c(this.a);
                } else {
                    this.a.onFail();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements lv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.repackage.lv2.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) {
                if (i != 0) {
                    this.a.onFail();
                    return;
                }
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        this.a.onFail();
                        return;
                    }
                }
                this.a.onSuccess();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onFail();

        void onSuccess();
    }

    public static void b(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, cVar) == null) {
            if (!(context instanceof Activity)) {
                cVar.onFail();
                return;
            }
            h03 M = h03.M();
            if (M != null) {
                M.e0().g((Activity) context, "mapp_location", new a(cVar));
            }
        }
    }

    public static void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            h03 b0 = h03.b0();
            if (be3.M() && b0 != null) {
                cVar.onSuccess();
            } else {
                b0.w().y(0, new String[]{PermissionChecker.ACCESS_FINE_LOCATION, PermissionChecker.ACCESS_COARSE_LOCATION}, new b(cVar));
            }
        }
    }
}
