package com.kwad.sdk.contentalliance.tube.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.d;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class b extends IFragmentActivityProxy {

    /* renamed from: a  reason: collision with root package name */
    private TubeDetailParam f8925a;

    /* renamed from: b  reason: collision with root package name */
    private SceneImpl f8926b;

    private void a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, c.a(this.f8925a)).commitAllowingStateLoss();
    }

    public static void a(Context context, TubeDetailParam tubeDetailParam) {
        if (tubeDetailParam == null || !tubeDetailParam.isValid()) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.TubeDetailActivity.class);
        intent.putExtra("KEY_TUBE_DETAIL_PARAM", tubeDetailParam);
        context.startActivity(intent);
    }

    private boolean b() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TUBE_DETAIL_PARAM");
        if (serializableExtra instanceof TubeDetailParam) {
            this.f8925a = (TubeDetailParam) serializableExtra;
            this.f8926b = new SceneImpl(this.f8925a.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 6);
            uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f8925a.getTubeId());
            this.f8926b.setUrlPackage(uRLPackage);
        }
        return this.f8925a != null;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        super.onBackPressed();
        e.d(this.f8926b);
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
        d.a(getActivity(), 0, false);
        a();
    }
}
