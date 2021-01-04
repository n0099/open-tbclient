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
/* loaded from: classes5.dex */
public class a extends IFragmentActivityProxy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private FeedSlideParam f10151a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f10152b;
    private g c;

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
            this.f10151a = (FeedSlideParam) serializableExtra;
        }
        return (this.f10151a == null || this.f10151a.mEntryScene == 0) ? false : true;
    }

    private void b() {
        this.f10152b = (ImageView) findViewById(R.id.ksad_back_btn);
        if (d.a(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f10152b.getLayoutParams();
            marginLayoutParams.topMargin = ao.a((Context) getActivity());
            this.f10152b.setLayoutParams(marginLayoutParams);
        }
        this.f10152b.setOnClickListener(this);
    }

    private void c() {
        this.c = g.a(new KsScene.Builder(this.f10151a.mEntryScene).build());
        this.c.getArguments().putSerializable("KEY_FEED_SLIDE_PARAM", this.f10151a);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, this.c).commitAllowingStateLoss();
    }

    private void d() {
        SlidePlayViewPager c;
        if (getActivity() == null || this.c == null || (c = this.c.c()) == null) {
            return;
        }
        com.kwad.sdk.feed.a.a.a().b(c.getData());
        com.kwad.sdk.feed.a.a.a().a(c.getRealPosition());
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.c == null || !this.c.b()) {
            super.onBackPressed();
            d();
            if (this.c != null) {
                e.d(this.c.d());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f10152b == view) {
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
