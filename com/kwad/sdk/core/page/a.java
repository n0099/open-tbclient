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
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.h.b implements p.b {
    public AdBaseFrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public e f39598b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f39599c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f39600d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39601e = true;

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
            this.f39599c = new AdTemplate();
            this.f39599c.parseJson(new JSONObject(stringExtra));
            this.f39600d = new com.kwad.sdk.core.download.a.b(this.f39599c);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.p.b
    public void a(p.a aVar) {
        e eVar;
        com.kwad.sdk.core.d.a.a("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
        if (aVar.a != 1 || (eVar = this.f39598b) == null) {
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
        setContentView(R.layout.obfuscated_res_0x7f0d041c);
        a(getIntent());
        this.a = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0910c3);
        e eVar = new e((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0910c4));
        this.f39598b = eVar;
        eVar.a(this.f39599c, this.a, this.f39600d);
        this.f39598b.a(this);
        this.f39598b.b();
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        this.f39598b.a((p.b) null);
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
