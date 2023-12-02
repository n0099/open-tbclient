package com.kwad.components.core.r.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.b.a;
import com.kwad.components.core.c.f;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: classes10.dex */
public class a extends com.kwad.components.core.l.b<b> {
    public static final ConcurrentMap<Integer, Map<String, Object>> Sx = new ConcurrentHashMap();
    public static final AtomicInteger Sy = new AtomicInteger(1);
    public StyleTemplate Sq;
    public String Sr;
    public boolean Ss;
    public k St;
    public com.kwad.components.core.webview.tachikoma.k Su;
    public com.kwad.components.core.r.b.b Sv;
    public int Sw;
    public AdResultData mAdResultData;
    public AdBaseFrameLayout mRootContainer;
    public com.kwad.components.core.b.a mTitleBarHelper;

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d051d;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "TKActivityProxy";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.b
    /* renamed from: qD */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.d(this.mAdResultData);
        bVar.Sq = this.Sq;
        bVar.mRootContainer = this.mRootContainer;
        bVar.St = this.St;
        bVar.Su = this.Su;
        return bVar;
    }

    public static int qE() {
        return Sy.incrementAndGet();
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, a.class);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.Ss = getIntent().getBooleanExtra("show_navigationBar", true);
        this.Sr = getIntent().getStringExtra("title");
        this.St = (k) aq("native_intent");
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.r.b.b bVar = this.Sv;
        if (bVar != null && bVar.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        if (this.Sq != null) {
            return new com.kwad.components.core.r.b.a();
        }
        if (this.Sv == null) {
            this.Sv = new com.kwad.components.core.r.b.b();
        }
        return this.Sv;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        aG(this.Sw);
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    public static void a(int i, String str, Object obj) {
        Map<String, Object> map = Sx.get(Integer.valueOf(i));
        if (map == null) {
            map = new HashMap<>();
            Sx.put(Integer.valueOf(i), map);
        }
        map.put(str, obj);
    }

    public static void aG(int i) {
        Map<String, Object> map = Sx.get(Integer.valueOf(i));
        if (map != null) {
            map.clear();
        }
    }

    private Object aq(String str) {
        return m(this.Sw, str);
    }

    public static Object m(int i, String str) {
        Map<String, Object> map = Sx.get(Integer.valueOf(i));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        this.Sw = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        com.kwad.components.core.webview.tachikoma.k kVar = (com.kwad.components.core.webview.tachikoma.k) aq("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && kVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.Sq = styleTemplate;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (kVar != null) {
            this.Su = kVar;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData d = f.mB().d(intExtra, true);
        this.mAdResultData = d;
        if (intExtra > 0 && d == null) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0914db);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09139b);
        if (!this.Ss && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a((ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913a8));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0632a() { // from class: com.kwad.components.core.r.a.a.1
            @Override // com.kwad.components.core.b.a.InterfaceC0632a
            public final void v(View view2) {
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0632a
            public final void u(View view2) {
                a.this.finish();
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(this.Sr));
        this.mTitleBarHelper.ah(false);
    }
}
