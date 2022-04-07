package com.repackage;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface s01 {
    public static final ServiceReference a = new ServiceReference("nad.core", "toast");
    public static final s01 b = new a();

    /* loaded from: classes7.dex */
    public static class a implements s01 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.repackage.s01
        public void a(@NonNull Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
                Toast.makeText(context, str, 0).show();
            }
        }

        @Override // com.repackage.s01
        public void b(@NonNull Context context, @StringRes int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
                Toast.makeText(context, i, 0).show();
            }
        }

        @Override // com.repackage.s01
        public void c(@NonNull Context context, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, context, i, i2) == null) {
                Toast.makeText(context, i, i2).show();
            }
        }
    }

    void a(@NonNull Context context, String str);

    void b(@NonNull Context context, @StringRes int i);

    void c(@NonNull Context context, @StringRes int i, int i2);
}
