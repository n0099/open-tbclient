package com.kwad.sdk.feed.detail;

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
    public FeedSlideParam f34897a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34898b;

    /* renamed from: c  reason: collision with root package name */
    public g f34899c;

    public static void a(KsFragment ksFragment, FeedSlideParam feedSlideParam) {
        if (ksFragment == null || feedSlideParam == null) {
            return;
        }
        Intent intent = new Intent(ksFragment.getContext(), BaseFragmentActivity.FragmentActivity5.class);
        intent.putExtra("KEY_FEED_SLIDE_PARAM", feedSlideParam);
        ksFragment.startActivity(intent);
    }

    private boolean a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_FEED_SLIDE_PARAM");
        if (serializableExtra instanceof FeedSlideParam) {
            this.f34897a = (FeedSlideParam) serializableExtra;
        }
        FeedSlideParam feedSlideParam = this.f34897a;
        return (feedSlideParam == null || feedSlideParam.mEntryScene == 0) ? false : true;
    }

    private void b() {
        this.f34898b = (ImageView) findViewById(R.id.ksad_back_btn);
        if (d.a(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f34898b.getLayoutParams();
            marginLayoutParams.topMargin = ao.a((Context) getActivity());
            this.f34898b.setLayoutParams(marginLayoutParams);
        }
        this.f34898b.setOnClickListener(this);
    }

    private void c() {
        g a2 = g.a(new KsScene.Builder(this.f34897a.mEntryScene).build());
        this.f34899c = a2;
        a2.getArguments().putSerializable("KEY_FEED_SLIDE_PARAM", this.f34897a);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, this.f34899c).commitAllowingStateLoss();
    }

    private void d() {
        g gVar;
        SlidePlayViewPager c2;
        if (getActivity() == null || (gVar = this.f34899c) == null || (c2 = gVar.c()) == null) {
            return;
        }
        com.kwad.sdk.feed.a.a.a().b(c2.getData());
        com.kwad.sdk.feed.a.a.a().a(c2.getRealPosition());
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        g gVar = this.f34899c;
        if (gVar == null || !gVar.b()) {
            super.onBackPressed();
            d();
            g gVar2 = this.f34899c;
            if (gVar2 != null) {
                e.d(gVar2.d());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f34898b == view) {
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
