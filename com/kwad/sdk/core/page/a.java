package com.kwad.sdk.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.widget.e;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.h.b implements p.b {
    public AdBaseFrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public e f54477b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f54478c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f54479d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54480e = true;

    public static void a(Context context, AdTemplate adTemplate) {
        KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.FragmentActivity8.class, a.class);
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity8.class);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        context.startActivity(intent);
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra("key_template_json");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            this.f54478c = new AdTemplate();
            this.f54478c.parseJson(new JSONObject(stringExtra));
            this.f54479d = new com.kwad.sdk.core.download.a.b(this.f54478c);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.p.b
    public void a(p.a aVar) {
        e eVar;
        com.kwad.sdk.core.d.a.a("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
        if (aVar.a != 1 || (eVar = this.f54477b) == null) {
            return;
        }
        eVar.c();
    }

    @Override // com.kwad.sdk.h.b
    public String getPageName() {
        return "AdPlayableActivityProxy";
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ksad_activity_playable);
        a(getIntent());
        this.a = (AdBaseFrameLayout) findViewById(R.id.ksad_playable_activity_root);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        this.f54477b = eVar;
        eVar.a(this.f54478c, this.a, this.f54479d);
        this.f54477b.a(this);
        this.f54477b.b();
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        this.f54477b.a((p.b) null);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
