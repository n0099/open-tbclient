package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yj9;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class zzb extends Fragment implements yj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, LifecycleCallback> a;
    @Nullable
    public Bundle b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(340160752, "Lcom/google/android/gms/common/api/internal/zzb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(340160752, "Lcom/google/android/gms/common/api/internal/zzb;");
                return;
            }
        }
        new WeakHashMap();
    }

    public zzb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = Collections.synchronizedMap(new ArrayMap());
    }

    @Override // android.app.Fragment
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, fileDescriptor, printWriter, strArr) == null) {
            super.dump(str, fileDescriptor, printWriter, strArr);
            for (LifecycleCallback lifecycleCallback : this.a.values()) {
                lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.repackage.yj9
    @Nullable
    public final Activity h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getActivity() : (Activity) invokeV.objValue;
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            for (LifecycleCallback lifecycleCallback : this.a.values()) {
                lifecycleCallback.b(i, i2, intent);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.b = bundle;
            for (Map.Entry<String, LifecycleCallback> entry : this.a.entrySet()) {
                entry.getValue().c(bundle != null ? bundle.getBundle(entry.getKey()) : null);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            for (LifecycleCallback lifecycleCallback : this.a.values()) {
                lifecycleCallback.d();
            }
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            for (LifecycleCallback lifecycleCallback : this.a.values()) {
                lifecycleCallback.e();
            }
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null) {
                return;
            }
            for (Map.Entry<String, LifecycleCallback> entry : this.a.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().f(bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            for (LifecycleCallback lifecycleCallback : this.a.values()) {
                lifecycleCallback.g();
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
            for (LifecycleCallback lifecycleCallback : this.a.values()) {
                lifecycleCallback.h();
            }
        }
    }
}
