package com.kwad.sdk.contentalliance.tube.episode;

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
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.d;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class a extends IFragmentActivityProxy implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TubeEpisodeDetailParam f35700a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35701b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35702c;

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

    public static void a(Context context, TubeEpisodeDetailParam tubeEpisodeDetailParam) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, tubeEpisodeDetailParam) == null) || tubeEpisodeDetailParam == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.EpisodeDetailActivity.class);
        intent.putExtra("KEY_TUBE_EPISODE_DETAIL_PARAM", tubeEpisodeDetailParam);
        context.startActivity(intent);
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TUBE_EPISODE_DETAIL_PARAM");
            if (serializableExtra instanceof TubeEpisodeDetailParam) {
                TubeEpisodeDetailParam tubeEpisodeDetailParam = (TubeEpisodeDetailParam) serializableExtra;
                this.f35700a = tubeEpisodeDetailParam;
                this.f35702c = new SceneImpl(tubeEpisodeDetailParam.mEntryScene);
                URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 5);
                uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f35700a.mTubeId);
                this.f35702c.setUrlPackage(uRLPackage);
            }
            TubeEpisodeDetailParam tubeEpisodeDetailParam2 = this.f35700a;
            return (tubeEpisodeDetailParam2 == null || tubeEpisodeDetailParam2.mEntryScene == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f35701b = (ImageView) findViewById(R.id.ksad_tube_episode_detail_back);
            if (d.a(getActivity())) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35701b.getLayoutParams();
                marginLayoutParams.topMargin = ao.a((Context) getActivity());
                this.f35701b.setLayoutParams(marginLayoutParams);
            }
            this.f35701b.setOnClickListener(this);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            g a2 = g.a(new KsScene.Builder(this.f35700a.mEntryScene).build());
            a2.getArguments().putSerializable("KEY_TUBE_EPISODE_DETAIL_PARAM", this.f35700a);
            getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, a2).commitAllowingStateLoss();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onBackPressed();
            e.d(this.f35702c);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f35701b == view) {
            e.d(this.f35702c);
            onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            if (a()) {
                getActivity().setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
                setContentView(R.layout.ksad_activity_tube_episode_detail);
                af.a(getActivity());
                d.a(getActivity(), 0, false);
                b();
                c();
            }
        }
    }
}
