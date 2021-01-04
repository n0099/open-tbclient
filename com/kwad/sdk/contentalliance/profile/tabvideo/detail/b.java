package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

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
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.d;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class b extends IFragmentActivityProxy implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ProfileVideoDetailParam f9109a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9110b;

    public static void a(Context context, ProfileVideoDetailParam profileVideoDetailParam) {
        if (profileVideoDetailParam == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.ProfileVideoDetailActivity.class);
        intent.putExtra("KEY_PROFILE_VIDEO_DETAIL_PARAM", profileVideoDetailParam);
        context.startActivity(intent);
    }

    private boolean a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_PROFILE_VIDEO_DETAIL_PARAM");
        if (serializableExtra instanceof ProfileVideoDetailParam) {
            this.f9109a = (ProfileVideoDetailParam) serializableExtra;
        }
        return (this.f9109a == null || this.f9109a.mEnterScene == 0) ? false : true;
    }

    private void b() {
        this.f9110b = (ImageView) findViewById(R.id.ksad_profile_back);
        if (d.a(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f9110b.getLayoutParams();
            marginLayoutParams.topMargin = ao.a((Context) getActivity());
            this.f9110b.setLayoutParams(marginLayoutParams);
        }
        this.f9110b.setOnClickListener(this);
    }

    private void c() {
        g a2 = g.a(new KsScene.Builder(this.f9109a.mEnterScene).build());
        a2.getArguments().putSerializable("KEY_PROFILE_VIDEO_DETAIL_PARAM", this.f9109a);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, a2).commitAllowingStateLoss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f9110b == view) {
            onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
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
