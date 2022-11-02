package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public final class zzd extends Fragment implements LifecycleFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final WeakHashMap<FragmentActivity, WeakReference<zzd>> zza;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, LifecycleCallback> zzb;
    public int zzc;
    @Nullable
    public Bundle zzd;

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.zzc > 0 : invokeV.booleanValue;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.zzc >= 2 : invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(340160814, "Lcom/google/android/gms/common/api/internal/zzd;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(340160814, "Lcom/google/android/gms/common/api/internal/zzd;");
                return;
            }
        }
        zza = new WeakHashMap<>();
    }

    public zzd() {
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
        this.zzb = Collections.synchronizedMap(new ArrayMap());
        this.zzc = 0;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    @Nullable
    public final /* synthetic */ Activity getLifecycleActivity() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.zzc = 5;
            for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
                lifecycleCallback.onDestroy();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            this.zzc = 3;
            for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
                lifecycleCallback.onResume();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStart();
            this.zzc = 2;
            for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
                lifecycleCallback.onStart();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStop();
            this.zzc = 4;
            for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
                lifecycleCallback.onStop();
            }
        }
    }

    public static zzd zzc(FragmentActivity fragmentActivity) {
        InterceptResult invokeL;
        zzd zzdVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fragmentActivity)) == null) {
            WeakReference<zzd> weakReference = zza.get(fragmentActivity);
            if (weakReference != null && (zzdVar = weakReference.get()) != null) {
                return zzdVar;
            }
            try {
                zzd zzdVar2 = (zzd) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (zzdVar2 == null || zzdVar2.isRemoving()) {
                    zzdVar2 = new zzd();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add(zzdVar2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                zza.put(fragmentActivity, new WeakReference<>(zzdVar2));
                return zzdVar2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return (zzd) invokeL.objValue;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String str, @NonNull LifecycleCallback lifecycleCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, lifecycleCallback) == null) {
            if (!this.zzb.containsKey(str)) {
                this.zzb.put(str, lifecycleCallback);
                if (this.zzc > 0) {
                    new zzi(Looper.getMainLooper()).post(new zzc(this, lifecycleCallback, str));
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fileDescriptor, printWriter, strArr) == null) {
            super.dump(str, fileDescriptor, printWriter, strArr);
            for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
                lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    @Nullable
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cls)) == null) {
            return cls.cast(this.zzb.get(str));
        }
        return (T) invokeLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            for (LifecycleCallback lifecycleCallback : this.zzb.values()) {
                lifecycleCallback.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.zzc = 1;
            this.zzd = bundle;
            for (Map.Entry<String, LifecycleCallback> entry : this.zzb.entrySet()) {
                LifecycleCallback value = entry.getValue();
                if (bundle != null) {
                    bundle2 = bundle.getBundle(entry.getKey());
                } else {
                    bundle2 = null;
                }
                value.onCreate(bundle2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null) {
                return;
            }
            for (Map.Entry<String, LifecycleCallback> entry : this.zzb.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().onSaveInstanceState(bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }
}
