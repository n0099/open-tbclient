package com.kwad.sdk.contentalliance.profile.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.utils.d;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class a extends IFragmentActivityProxy {

    /* renamed from: a  reason: collision with root package name */
    public ProfileHomeParam f33143a;

    private void a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, c.a(this.f33143a)).commitAllowingStateLoss();
    }

    public static void a(Context context, ProfileHomeParam profileHomeParam) {
        if (profileHomeParam == null || !profileHomeParam.isValid()) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.ProfileHomeActivity.class);
        intent.addFlags(603979776);
        intent.putExtra("KEY_PROFILE_HOME_PARAM", profileHomeParam);
        context.startActivity(intent);
        com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a().b();
    }

    private boolean b() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_PROFILE_HOME_PARAM");
        if (serializableExtra instanceof ProfileHomeParam) {
            this.f33143a = (ProfileHomeParam) serializableExtra;
        }
        return this.f33143a != null;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.kwad.sdk.core.d.a.a("ProfileHomeActivity", MissionEvent.MESSAGE_CREATE);
        if (!b()) {
            finish();
            return;
        }
        getActivity().setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
        setContentView(R.layout.ksad_activity_profile_home);
        d.a(getActivity(), 0, false);
        a();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.kwad.sdk.core.d.a.a("ProfileHomeActivity", "onNewIntent");
    }
}
