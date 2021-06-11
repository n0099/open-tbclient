package com.kwad.sdk.contentalliance.tube.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class b extends IFragmentActivityProxy {

    /* renamed from: a  reason: collision with root package name */
    public TubeProfileParam f33851a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f33852b;

    private void a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, d.a(this.f33851a)).commitAllowingStateLoss();
    }

    public static void a(Context context, TubeProfileParam tubeProfileParam) {
        if (tubeProfileParam == null || !tubeProfileParam.isValid()) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.TubeProfileActivity.class);
        intent.putExtra("KEY_TUBE_HOME_PARAM", tubeProfileParam);
        context.startActivity(intent);
    }

    private boolean b() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TUBE_HOME_PARAM");
        if (serializableExtra instanceof TubeProfileParam) {
            TubeProfileParam tubeProfileParam = (TubeProfileParam) serializableExtra;
            this.f33851a = tubeProfileParam;
            this.f33852b = new SceneImpl(tubeProfileParam.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 7);
            uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f33851a.getTubeId());
            this.f33852b.setUrlPackage(uRLPackage);
        }
        return this.f33851a != null;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.e.d(this.f33852b);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!b()) {
            finish();
            return;
        }
        getActivity().setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar);
        setContentView(R.layout.ksad_activity_tube);
        com.kwad.sdk.utils.d.a(getActivity(), 0, false);
        a();
    }
}
