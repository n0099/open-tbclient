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
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.h.b implements p.b {
    public AdBaseFrameLayout a;
    public e b;
    public AdTemplate c;
    public com.kwad.sdk.core.download.a.b d;
    public boolean e = true;

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
            this.c = new AdTemplate();
            this.c.parseJson(new JSONObject(stringExtra));
            this.d = new com.kwad.sdk.core.download.a.b(this.c);
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.p.b
    public void a(p.a aVar) {
        e eVar;
        com.kwad.sdk.core.d.a.a("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
        if (aVar.a != 1 || (eVar = this.b) == null) {
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
        setContentView(R.layout.obfuscated_res_0x7f0d0417);
        a(getIntent());
        this.a = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0910bd);
        e eVar = new e((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0910be));
        this.b = eVar;
        eVar.a(this.c, this.a, this.d);
        this.b.a(this);
        this.b.b();
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        this.b.a((p.b) null);
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
