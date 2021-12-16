package com.kwad.sdk.h;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.n;
/* loaded from: classes3.dex */
public abstract class a extends IActivityProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean enableDestroyer;
    public final com.kwad.sdk.h.a.a mPageMonitor;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPageMonitor = new com.kwad.sdk.h.a.a();
        this.enableDestroyer = true;
    }

    public boolean enableSaveFragmentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Intent intent = super.getIntent();
            aj.a(intent);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public abstract String getPageName();

    public boolean isEnableDestroyer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.enableDestroyer : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
            this.mPageMonitor.a(getPageName());
            this.mPageMonitor.a(longExtra);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            if (this.enableDestroyer) {
                n.a(this);
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.mPageMonitor.a(getActivity());
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (!KsAdSDKImpl.get().getIsExternal() || enableSaveFragmentState() || bundle == null || !bundle.containsKey(FRAGMENTS_TAG)) {
                return;
            }
            bundle.remove(FRAGMENTS_TAG);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.setContentView(View.inflate(Wrapper.wrapContextIfNeed(getActivity()), i2, null));
        }
    }

    public void setEnableDestroyer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.enableDestroyer = z;
        }
    }
}
