package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.kwad.components.core.request.g;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.offline.api.tk.model.BundleServiceConfig;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g {
    public boolean Ye = false;
    public boolean Yf = false;
    public final Map<String, a> Yg = new ConcurrentHashMap();

    /* loaded from: classes10.dex */
    public interface b {
        void onFailed(String str);

        void onSuccess();
    }

    /* loaded from: classes10.dex */
    public static class a {
        public i Yl;
        public boolean Ym;
        public List<b> Yn = new ArrayList();

        public a(i iVar) {
            this.Yl = iVar;
        }

        public final void a(b bVar) {
            if (bVar != null) {
                this.Yn.add(bVar);
            }
        }

        public final void aG(final String str) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (b bVar : a.this.Yn) {
                        bVar.onFailed(str);
                    }
                    a.this.Yn.clear();
                }
            });
        }

        public final void sp() {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    for (b bVar : a.this.Yn) {
                        bVar.onSuccess();
                    }
                    a.this.Yn.clear();
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static final g Yq = new g();
    }

    public static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static g sn() {
        return c.Yq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void so() {
        if (this.Ye && this.Yf) {
            ai(KsAdSDK.getContext());
        }
    }

    public final void init() {
        com.kwad.components.core.n.a.d.b bVar = (com.kwad.components.core.n.a.d.b) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.d.b.class);
        if (bVar != null) {
            bVar.a(new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.core.webview.tachikoma.g.1
                @Override // com.kwad.components.core.n.a.d.a
                public final void a(int i, int i2, long j, long j2) {
                    g.a(g.this, true);
                    g.this.so();
                }
            });
        }
        com.kwad.components.core.request.g.b(new g.a() { // from class: com.kwad.components.core.webview.tachikoma.g.2
            @Override // com.kwad.components.core.request.g.a
            public final void qi() {
            }

            @Override // com.kwad.components.core.request.g.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                g.b(g.this, true);
                g.this.so();
            }
        });
    }

    private void a(Context context, final StyleTemplate styleTemplate, b bVar) {
        final String str = styleTemplate.templateId;
        a aVar = this.Yg.get(str);
        if (aVar != null) {
            if (aVar.Ym) {
                com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle finish: already load");
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            aVar.a(bVar);
            return;
        }
        i iVar = new i(context, false);
        iVar.a("isService", Boolean.TRUE);
        final a aVar2 = new a(iVar);
        aVar2.a(bVar);
        iVar.a(styleTemplate);
        iVar.a((Activity) null, (AdResultData) null, new j() { // from class: com.kwad.components.core.webview.tachikoma.g.3
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0664a c0664a) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(aw awVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(o oVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(m mVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar2) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar3) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void b(ac.a aVar3) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bG() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_bundle_service";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.e getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: execute fail");
                aVar2.aG("execute fail");
                g.this.unloadBundle(str);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bF() {
                com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle success: done");
                a aVar3 = aVar2;
                aVar3.Ym = true;
                aVar3.sp();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return styleTemplate.templateId;
            }
        });
        this.Yg.put(str, aVar2);
    }

    public final void unloadBundle(String str) {
        if (this.Yg.get(str) != null) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "unload bundle" + str);
            a aVar = this.Yg.get(str);
            if (aVar != null) {
                aVar.Yl.jn();
            }
            this.Yg.remove(str);
        }
    }

    public static /* synthetic */ boolean a(g gVar, boolean z) {
        gVar.Ye = true;
        return true;
    }

    public static /* synthetic */ boolean b(g gVar, boolean z) {
        gVar.Yf = true;
        return true;
    }

    private void ai(Context context) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "begin load all services");
        SdkConfigData AR = com.kwad.sdk.core.config.d.AR();
        if (AR == null || context == null || (optJSONObject = AR.toJson().optJSONObject(PrefetchEvent.EVENT_KEY_APP_CONFIG)) == null || (optJSONArray = optJSONObject.optJSONArray("tkServiceConfigs")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            BundleServiceConfig bundleServiceConfig = new BundleServiceConfig();
            bundleServiceConfig.parseJson(optJSONArray.optJSONObject(i));
            if (bundleServiceConfig.loadType == 1) {
                b(context, bundleServiceConfig.bundleName, null);
            }
        }
    }

    public final void a(Context context, String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            bVar.onFailed("invalid bundle string");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            StyleTemplate styleTemplate = new StyleTemplate();
            styleTemplate.parseJson(jSONObject);
            if (TextUtils.isEmpty(styleTemplate.templateId) || TextUtils.isEmpty(styleTemplate.templateUrl)) {
                bVar.onFailed("invalid bundle:" + str);
            }
            a(context, styleTemplate, bVar);
        } catch (Throwable th) {
            bVar.onFailed(th.getMessage());
        }
    }

    public final void b(Context context, String str, b bVar) {
        JSONArray optJSONArray;
        if (isLocalDebugEnable()) {
            unloadBundle(str);
        }
        com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle:" + str);
        if (TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: invalid bundle name");
            if (bVar != null) {
                bVar.onFailed("invalid bundle name");
                return;
            }
            return;
        }
        SdkConfigData AR = com.kwad.sdk.core.config.d.AR();
        if (AR == null) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: config data empty");
            if (bVar != null) {
                bVar.onFailed("config data empty");
            }
        } else if (context == null) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: no context");
            if (bVar != null) {
                bVar.onFailed("no context");
            }
        } else {
            JSONObject optJSONObject = AR.toJson().optJSONObject("styleTemplatesConfig");
            StyleTemplate styleTemplate = null;
            if (optJSONObject == null) {
                optJSONArray = null;
            } else {
                optJSONArray = optJSONObject.optJSONArray("styleTemplates");
            }
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    if (i >= optJSONArray.length()) {
                        break;
                    }
                    StyleTemplate styleTemplate2 = new StyleTemplate();
                    styleTemplate2.parseJson(optJSONArray.optJSONObject(i));
                    String str2 = styleTemplate2.templateId;
                    if (str2 != null && str2.equals(str)) {
                        styleTemplate = styleTemplate2;
                        break;
                    }
                    i++;
                }
            }
            if (isLocalDebugEnable() && styleTemplate == null) {
                styleTemplate = new StyleTemplate();
                styleTemplate.templateId = str;
            }
            if (styleTemplate == null) {
                com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: no bundle");
                if (bVar != null) {
                    bVar.onFailed("no bundle");
                    return;
                }
                return;
            }
            a(context, styleTemplate, bVar);
        }
    }
}
