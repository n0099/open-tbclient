package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.b.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends f implements a.InterfaceC0632a, aq.b {
    public boolean NO = true;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;
    public com.kwad.components.core.b.a mTitleBarHelper;
    public com.kwad.components.core.playable.a oK;

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "AdPlayableActivityProxy";
    }

    private void oQ() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.mRootContainer);
        this.mTitleBarHelper = aVar;
        aVar.a(this);
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(""));
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(BaseFragmentActivity.FragmentActivity8.class, a.class);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        this.oK.b(this);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra("key_template_json");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                this.mAdTemplate = new AdTemplate();
                this.mAdTemplate.parseJson(new JSONObject(stringExtra));
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        com.kwad.components.core.playable.a aVar2;
        com.kwad.sdk.core.e.c.d("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
        if (aVar.status == 1 && (aVar2 = this.oK) != null) {
            aVar2.e(PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE);
        }
    }

    @Override // com.kwad.components.core.b.a.InterfaceC0632a
    public final void u(View view2) {
        onBackPressed();
    }

    @Override // com.kwad.components.core.b.a.InterfaceC0632a
    public final void v(View view2) {
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, new j().cB(6), (JSONObject) null);
        finish();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        com.kwad.sdk.service.b.a(BaseFragmentActivity.FragmentActivity8.class, a.class);
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity8.class);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        context.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getActivity().setTheme(R.style.obfuscated_res_0x7f100243);
        setContentView(R.layout.obfuscated_res_0x7f0d04a7);
        b(getIntent());
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913f9);
        oQ();
        com.kwad.components.core.playable.a aVar = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0913fe));
        this.oK = aVar;
        aVar.a(this.mAdTemplate, this.mRootContainer, this.mApkDownloadHelper);
        this.oK.a(this);
        this.oK.pT();
    }
}
