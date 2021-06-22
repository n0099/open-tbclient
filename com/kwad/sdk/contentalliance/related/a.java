package com.kwad.sdk.contentalliance.related;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
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
/* loaded from: classes6.dex */
public class a extends IFragmentActivityProxy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public RelatedVideoDetailParam f33680a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33681b;

    /* renamed from: c  reason: collision with root package name */
    public g f33682c;

    public static void a(KsFragment ksFragment, int i2, RelatedVideoDetailParam relatedVideoDetailParam) {
        if (ksFragment == null || relatedVideoDetailParam == null) {
            return;
        }
        Intent intent = new Intent(ksFragment.getContext(), BaseFragmentActivity.FragmentActivity4.class);
        intent.putExtra("KEY_RELATED_VIDEO_DETAIL_PARAM", relatedVideoDetailParam);
        ksFragment.startActivityForResult(intent, i2);
    }

    private boolean a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_RELATED_VIDEO_DETAIL_PARAM");
        if (serializableExtra instanceof RelatedVideoDetailParam) {
            this.f33680a = (RelatedVideoDetailParam) serializableExtra;
        }
        RelatedVideoDetailParam relatedVideoDetailParam = this.f33680a;
        return (relatedVideoDetailParam == null || relatedVideoDetailParam.mEntryScene == 0) ? false : true;
    }

    private void b() {
        this.f33681b = (ImageView) findViewById(R.id.ksad_back_btn);
        if (d.a(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33681b.getLayoutParams();
            marginLayoutParams.topMargin = ao.a((Context) getActivity());
            this.f33681b.setLayoutParams(marginLayoutParams);
        }
        this.f33681b.setOnClickListener(this);
    }

    private void c() {
        g a2 = g.a(new KsScene.Builder(this.f33680a.mEntryScene).build());
        this.f33682c = a2;
        a2.getArguments().putSerializable("KEY_RELATED_VIDEO_DETAIL_PARAM", this.f33680a);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, this.f33682c).commitAllowingStateLoss();
    }

    private void d() {
        g gVar;
        SlidePlayViewPager c2;
        Activity activity = getActivity();
        if (activity == null || (gVar = this.f33682c) == null || (c2 = gVar.c()) == null) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().b(c2.getData());
        Intent intent = new Intent();
        intent.putExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", c2.getRealPosition());
        activity.setResult(-1, intent);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        d();
        super.onBackPressed();
        g gVar = this.f33682c;
        if (gVar != null) {
            e.d(gVar.d());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f33681b == view) {
            onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            getActivity().setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_activity_slide_related_video);
            d.a(getActivity(), 0, false);
            b();
            c();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().c();
    }
}
