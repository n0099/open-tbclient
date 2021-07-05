package com.kwad.sdk.contentalliance.tube.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class b extends IFragmentActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TubeProfileParam f35712a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f35713b;

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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, d.a(this.f35712a)).commitAllowingStateLoss();
        }
    }

    public static void a(Context context, TubeProfileParam tubeProfileParam) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, tubeProfileParam) == null) && tubeProfileParam != null && tubeProfileParam.isValid()) {
            Intent intent = new Intent(context, BaseFragmentActivity.TubeProfileActivity.class);
            intent.putExtra("KEY_TUBE_HOME_PARAM", tubeProfileParam);
            context.startActivity(intent);
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TUBE_HOME_PARAM");
            if (serializableExtra instanceof TubeProfileParam) {
                TubeProfileParam tubeProfileParam = (TubeProfileParam) serializableExtra;
                this.f35712a = tubeProfileParam;
                this.f35713b = new SceneImpl(tubeProfileParam.mEntryScene);
                URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 7);
                uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f35712a.getTubeId());
                this.f35713b.setUrlPackage(uRLPackage);
            }
            return this.f35712a != null;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onBackPressed();
            com.kwad.sdk.core.report.e.d(this.f35713b);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (!b()) {
                finish();
                return;
            }
            getActivity().setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_activity_tube);
            com.kwad.sdk.utils.d.a(getActivity(), 0, false);
            a();
        }
    }
}
