package com.kwad.sdk.contentalliance.tube.detail;

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
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.d;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class b extends IFragmentActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TubeDetailParam f35637a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f35638b;

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
            getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, c.a(this.f35637a)).commitAllowingStateLoss();
        }
    }

    public static void a(Context context, TubeDetailParam tubeDetailParam) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, tubeDetailParam) == null) && tubeDetailParam != null && tubeDetailParam.isValid()) {
            Intent intent = new Intent(context, BaseFragmentActivity.TubeDetailActivity.class);
            intent.putExtra("KEY_TUBE_DETAIL_PARAM", tubeDetailParam);
            context.startActivity(intent);
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TUBE_DETAIL_PARAM");
            if (serializableExtra instanceof TubeDetailParam) {
                TubeDetailParam tubeDetailParam = (TubeDetailParam) serializableExtra;
                this.f35637a = tubeDetailParam;
                this.f35638b = new SceneImpl(tubeDetailParam.mEntryScene);
                URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 6);
                uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f35637a.getTubeId());
                this.f35638b.setUrlPackage(uRLPackage);
            }
            return this.f35637a != null;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onBackPressed();
            e.d(this.f35638b);
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
            d.a(getActivity(), 0, false);
            a();
        }
    }
}
