package com.kwad.sdk.contentalliance.profile.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.utils.d;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class a extends IFragmentActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ProfileHomeParam f35312a;

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
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, c.a(this.f35312a)).commitAllowingStateLoss();
        }
    }

    public static void a(Context context, ProfileHomeParam profileHomeParam) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, profileHomeParam) == null) && profileHomeParam != null && profileHomeParam.isValid()) {
            Intent intent = new Intent(context, BaseFragmentActivity.ProfileHomeActivity.class);
            intent.addFlags(603979776);
            intent.putExtra("KEY_PROFILE_HOME_PARAM", profileHomeParam);
            context.startActivity(intent);
            com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a().b();
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("KEY_PROFILE_HOME_PARAM");
            if (serializableExtra instanceof ProfileHomeParam) {
                this.f35312a = (ProfileHomeParam) serializableExtra;
            }
            return this.f35312a != null;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            com.kwad.sdk.core.d.a.a("ProfileHomeActivity", MissionEvent.MESSAGE_CREATE);
            if (!b()) {
                finish();
                return;
            }
            getActivity().setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_activity_profile_home);
            d.a(getActivity(), 0, false);
            a();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            super.onNewIntent(intent);
            com.kwad.sdk.core.d.a.a("ProfileHomeActivity", "onNewIntent");
        }
    }
}
