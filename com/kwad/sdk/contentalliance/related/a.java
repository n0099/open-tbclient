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
/* loaded from: classes5.dex */
public class a extends IFragmentActivityProxy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RelatedVideoDetailParam f9134a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9135b;
    private g c;

    public static void a(KsFragment ksFragment, int i, RelatedVideoDetailParam relatedVideoDetailParam) {
        if (ksFragment == null || relatedVideoDetailParam == null) {
            return;
        }
        Intent intent = new Intent(ksFragment.getContext(), BaseFragmentActivity.FragmentActivity4.class);
        intent.putExtra("KEY_RELATED_VIDEO_DETAIL_PARAM", relatedVideoDetailParam);
        ksFragment.startActivityForResult(intent, i);
    }

    private boolean a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_RELATED_VIDEO_DETAIL_PARAM");
        if (serializableExtra instanceof RelatedVideoDetailParam) {
            this.f9134a = (RelatedVideoDetailParam) serializableExtra;
        }
        return (this.f9134a == null || this.f9134a.mEntryScene == 0) ? false : true;
    }

    private void b() {
        this.f9135b = (ImageView) findViewById(R.id.ksad_back_btn);
        if (d.a(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f9135b.getLayoutParams();
            marginLayoutParams.topMargin = ao.a((Context) getActivity());
            this.f9135b.setLayoutParams(marginLayoutParams);
        }
        this.f9135b.setOnClickListener(this);
    }

    private void c() {
        this.c = g.a(new KsScene.Builder(this.f9134a.mEntryScene).build());
        this.c.getArguments().putSerializable("KEY_RELATED_VIDEO_DETAIL_PARAM", this.f9134a);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, this.c).commitAllowingStateLoss();
    }

    private void d() {
        SlidePlayViewPager c;
        Activity activity = getActivity();
        if (activity == null || this.c == null || (c = this.c.c()) == null) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().b(c.getData());
        Intent intent = new Intent();
        intent.putExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", c.getRealPosition());
        activity.setResult(-1, intent);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        d();
        super.onBackPressed();
        if (this.c != null) {
            e.d(this.c.d());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f9135b == view) {
            onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().c();
    }
}
