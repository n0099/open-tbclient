package com.kwad.sdk.c;

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
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.k;
/* loaded from: classes6.dex */
public abstract class b extends IFragmentActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean enableDestroyer;
    public final com.kwad.sdk.c.a.a mBackPressDelete;
    public final com.kwad.sdk.c.b.a mPageMonitor;

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
                return;
            }
        }
        this.mPageMonitor = new com.kwad.sdk.c.b.a();
        this.mBackPressDelete = new com.kwad.sdk.c.a.a();
        this.enableDestroyer = true;
    }

    public void addBackPressable(com.kwad.sdk.c.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.mBackPressDelete.a(bVar);
        }
    }

    public void addBackPressable(com.kwad.sdk.c.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2) == null) {
            this.mBackPressDelete.a(bVar, i2);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Intent intent = super.getIntent();
            af.a(intent);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public abstract String getPageName();

    public boolean isEnableDestroyer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.enableDestroyer : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mBackPressDelete.a()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
            this.mPageMonitor.a(getClass().getSimpleName());
            this.mPageMonitor.a(longExtra);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            if (this.enableDestroyer) {
                k.a(this);
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            this.mPageMonitor.a(getActivity());
        }
    }

    public void removeBackPressable(com.kwad.sdk.c.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.mBackPressDelete.b(bVar);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.setContentView(View.inflate(Wrapper.wrapContextIfNeed(getActivity()), i2, null));
        }
    }

    public void setEnableDestroyer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.enableDestroyer = z;
        }
    }
}
