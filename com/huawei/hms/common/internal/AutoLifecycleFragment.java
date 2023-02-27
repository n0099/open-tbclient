package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.api.HuaweiApiClient;
/* loaded from: classes8.dex */
public class AutoLifecycleFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<a> a;
    public boolean b;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final HuaweiApiClient a;

        public a(int i, HuaweiApiClient huaweiApiClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), huaweiApiClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = huaweiApiClient;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.disconnect();
            }
        }
    }

    public AutoLifecycleFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
    }

    @Override // android.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onStart();
            this.b = true;
            for (int i = 0; i < this.a.size(); i++) {
                this.a.valueAt(i).a.connect((Activity) null);
            }
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onStop();
            this.b = false;
            for (int i = 0; i < this.a.size(); i++) {
                this.a.valueAt(i).a.disconnect();
            }
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            Preconditions.checkMainThread("Must be called on the main thread");
            try {
                AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
                FragmentManager fragmentManager = activity.getFragmentManager();
                if (autoLifecycleFragment == null) {
                    AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
                    fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
                    fragmentManager.executePendingTransactions();
                    return autoLifecycleFragment2;
                }
                return autoLifecycleFragment;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e);
            }
        }
        return (AutoLifecycleFragment) invokeL.objValue;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public void stopAutoManage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            a aVar = this.a.get(i);
            this.a.remove(i);
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void startAutoMange(int i, HuaweiApiClient huaweiApiClient) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, huaweiApiClient) == null) {
            Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
            if (this.a.indexOfKey(i) < 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Already managing a HuaweiApiClient with this clientId: " + i);
            this.a.put(i, new a(i, huaweiApiClient));
            if (this.b) {
                huaweiApiClient.connect((Activity) null);
            }
        }
    }
}
