package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.contentalliance.home.g;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.d;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class b extends IFragmentActivityProxy implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ProfileVideoDetailParam f35401a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35402b;

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

    public static void a(Context context, ProfileVideoDetailParam profileVideoDetailParam) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, profileVideoDetailParam) == null) || profileVideoDetailParam == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.ProfileVideoDetailActivity.class);
        intent.putExtra("KEY_PROFILE_VIDEO_DETAIL_PARAM", profileVideoDetailParam);
        context.startActivity(intent);
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("KEY_PROFILE_VIDEO_DETAIL_PARAM");
            if (serializableExtra instanceof ProfileVideoDetailParam) {
                this.f35401a = (ProfileVideoDetailParam) serializableExtra;
            }
            ProfileVideoDetailParam profileVideoDetailParam = this.f35401a;
            return (profileVideoDetailParam == null || profileVideoDetailParam.mEnterScene == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f35402b = (ImageView) findViewById(R.id.ksad_profile_back);
            if (d.a(getActivity())) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35402b.getLayoutParams();
                marginLayoutParams.topMargin = ao.a((Context) getActivity());
                this.f35402b.setLayoutParams(marginLayoutParams);
            }
            this.f35402b.setOnClickListener(this);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            g a2 = g.a(new KsScene.Builder(this.f35401a.mEnterScene).build());
            a2.getArguments().putSerializable("KEY_PROFILE_VIDEO_DETAIL_PARAM", this.f35401a);
            getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, a2).commitAllowingStateLoss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f35402b == view) {
            onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (a()) {
                getActivity().setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
                setContentView(R.layout.ksad_activity_profile_video_detail);
                d.a(getActivity(), 0, false);
                b();
                c();
            }
        }
    }
}
