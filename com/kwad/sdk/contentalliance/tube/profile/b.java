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
/* loaded from: classes5.dex */
public class b extends IFragmentActivityProxy {

    /* renamed from: a  reason: collision with root package name */
    private TubeProfileParam f9255a;

    /* renamed from: b  reason: collision with root package name */
    private SceneImpl f9256b;

    private void a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, d.a(this.f9255a)).commitAllowingStateLoss();
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
            this.f9255a = (TubeProfileParam) serializableExtra;
            this.f9256b = new SceneImpl(this.f9255a.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 7);
            uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f9255a.getTubeId());
            this.f9256b.setUrlPackage(uRLPackage);
        }
        return this.f9255a != null;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.e.d(this.f9256b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
