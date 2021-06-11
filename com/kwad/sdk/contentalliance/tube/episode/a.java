package com.kwad.sdk.contentalliance.tube.episode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
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
/* loaded from: classes6.dex */
public class a extends IFragmentActivityProxy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TubeEpisodeDetailParam f33839a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33840b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f33841c;

    public static void a(Context context, TubeEpisodeDetailParam tubeEpisodeDetailParam) {
        if (tubeEpisodeDetailParam == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.EpisodeDetailActivity.class);
        intent.putExtra("KEY_TUBE_EPISODE_DETAIL_PARAM", tubeEpisodeDetailParam);
        context.startActivity(intent);
    }

    private boolean a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TUBE_EPISODE_DETAIL_PARAM");
        if (serializableExtra instanceof TubeEpisodeDetailParam) {
            TubeEpisodeDetailParam tubeEpisodeDetailParam = (TubeEpisodeDetailParam) serializableExtra;
            this.f33839a = tubeEpisodeDetailParam;
            this.f33841c = new SceneImpl(tubeEpisodeDetailParam.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 5);
            uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f33839a.mTubeId);
            this.f33841c.setUrlPackage(uRLPackage);
        }
        TubeEpisodeDetailParam tubeEpisodeDetailParam2 = this.f33839a;
        return (tubeEpisodeDetailParam2 == null || tubeEpisodeDetailParam2.mEntryScene == 0) ? false : true;
    }

    private void b() {
        this.f33840b = (ImageView) findViewById(R.id.ksad_tube_episode_detail_back);
        if (d.a(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33840b.getLayoutParams();
            marginLayoutParams.topMargin = ao.a((Context) getActivity());
            this.f33840b.setLayoutParams(marginLayoutParams);
        }
        this.f33840b.setOnClickListener(this);
    }

    private void c() {
        g a2 = g.a(new KsScene.Builder(this.f33839a.mEntryScene).build());
        a2.getArguments().putSerializable("KEY_TUBE_EPISODE_DETAIL_PARAM", this.f33839a);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, a2).commitAllowingStateLoss();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        super.onBackPressed();
        e.d(this.f33841c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f33840b == view) {
            e.d(this.f33841c);
            onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
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
