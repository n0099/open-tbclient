package com.kwad.sdk.contentalliance.related;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.contentalliance.home.g;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.d;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class a extends IFragmentActivityProxy implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelatedVideoDetailParam f35443a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35444b;

    /* renamed from: c  reason: collision with root package name */
    public g f35445c;

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

    public static void a(KsFragment ksFragment, int i2, RelatedVideoDetailParam relatedVideoDetailParam) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65537, null, ksFragment, i2, relatedVideoDetailParam) == null) || ksFragment == null || relatedVideoDetailParam == null) {
            return;
        }
        Intent intent = new Intent(ksFragment.getContext(), BaseFragmentActivity.FragmentActivity4.class);
        intent.putExtra("KEY_RELATED_VIDEO_DETAIL_PARAM", relatedVideoDetailParam);
        ksFragment.startActivityForResult(intent, i2);
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("KEY_RELATED_VIDEO_DETAIL_PARAM");
            if (serializableExtra instanceof RelatedVideoDetailParam) {
                this.f35443a = (RelatedVideoDetailParam) serializableExtra;
            }
            RelatedVideoDetailParam relatedVideoDetailParam = this.f35443a;
            return (relatedVideoDetailParam == null || relatedVideoDetailParam.mEntryScene == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f35444b = (ImageView) findViewById(R.id.ksad_back_btn);
            if (d.a(getActivity())) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35444b.getLayoutParams();
                marginLayoutParams.topMargin = ao.a((Context) getActivity());
                this.f35444b.setLayoutParams(marginLayoutParams);
            }
            this.f35444b.setOnClickListener(this);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            g a2 = g.a(new KsScene.Builder(this.f35443a.mEntryScene).build());
            this.f35445c = a2;
            a2.getArguments().putSerializable("KEY_RELATED_VIDEO_DETAIL_PARAM", this.f35443a);
            getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, this.f35445c).commitAllowingStateLoss();
        }
    }

    private void d() {
        Activity activity;
        g gVar;
        SlidePlayViewPager c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (activity = getActivity()) == null || (gVar = this.f35445c) == null || (c2 = gVar.c()) == null) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().b(c2.getData());
        Intent intent = new Intent();
        intent.putExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", c2.getRealPosition());
        activity.setResult(-1, intent);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            super.onBackPressed();
            g gVar = this.f35445c;
            if (gVar != null) {
                e.d(gVar.d());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f35444b == view) {
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
                setContentView(R.layout.ksad_activity_slide_related_video);
                d.a(getActivity(), 0, false);
                b();
                c();
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            com.kwad.sdk.contentalliance.detail.photo.related.a.a().c();
        }
    }
}
