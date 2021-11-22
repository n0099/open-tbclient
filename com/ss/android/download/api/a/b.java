package com.ss.android.download.api.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.s;
/* loaded from: classes2.dex */
public class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public s f69230a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.ss.android.download.api.config.h
    public void a(@NonNull Activity activity, @NonNull String[] strArr, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, strArr, sVar) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f69230a = sVar;
                activity.requestPermissions(strArr, 1);
            } else if (sVar != null) {
                sVar.a();
            }
        }
    }

    @Override // com.ss.android.download.api.config.h
    public boolean a(@Nullable Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) ? context != null && ContextCompat.checkSelfPermission(context, str) == 0 : invokeLL.booleanValue;
    }

    @Override // com.ss.android.download.api.config.h
    public void a(@NonNull Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048576, this, activity, i2, strArr, iArr) == null) || iArr.length <= 0 || (sVar = this.f69230a) == null) {
            return;
        }
        if (iArr[0] == -1) {
            sVar.a(strArr[0]);
        } else if (iArr[0] == 0) {
            sVar.a();
        }
    }
}
