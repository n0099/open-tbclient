package com.kwad.sdk.contentalliance.trends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.g.o;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.af;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends IFragmentActivityProxy {

    /* renamed from: a  reason: collision with root package name */
    private TrendInfo f9173a = new TrendInfo();

    /* renamed from: b  reason: collision with root package name */
    private KsFragment f9174b;
    private SceneImpl c;
    private TrendsParams d;

    public static c a(@NonNull KsScene ksScene, @NonNull List<TrendInfo> list, @NonNull TrendInfo trendInfo) {
        c cVar = new c(ksScene);
        cVar.a(list, trendInfo);
        return cVar;
    }

    public static void a(Context context, @NonNull TrendsParams trendsParams) {
        Intent intent = new Intent(context, BaseFragmentActivity.KsTrendsActivity.class);
        intent.putExtra("KEY_TREND_PARAMS", trendsParams);
        context.startActivity(intent);
    }

    private void a(boolean z) {
        final int i = R.id.ksad_content_trends_container;
        o.a(z, new o.d() { // from class: com.kwad.sdk.contentalliance.trends.b.1
            @Override // com.kwad.sdk.core.g.o.d
            public void a(int i2, String str) {
                c a2 = b.a(b.this.c, new ArrayList(), b.this.f9173a);
                b.this.f9174b = a2.a();
                if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                    return;
                }
                b.this.getSupportFragmentManager().beginTransaction().replace(i, b.this.f9174b).commitAllowingStateLoss();
            }

            @Override // com.kwad.sdk.core.g.o.d
            public void a(@NonNull List<TrendInfo> list) {
                Collections.sort(list, TrendInfo.mTrendsComparator);
                c a2 = b.a(b.this.c, list, b.this.f9173a);
                b.this.f9174b = a2.a();
                if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                    return;
                }
                b.this.getSupportFragmentManager().beginTransaction().replace(i, b.this.f9174b).commitAllowingStateLoss();
            }
        });
    }

    private boolean a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TREND_PARAMS");
        if (serializableExtra instanceof TrendsParams) {
            this.d = (TrendsParams) serializableExtra;
            if (this.d.trendInfo != null) {
                this.f9173a = this.d.trendInfo;
            }
            this.c = new SceneImpl(this.d.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 2);
            uRLPackage.putParams(URLPackage.KEY_TREND_ID, this.f9173a.trendId);
            this.c.setUrlPackage(uRLPackage);
        }
        return (this.d == null || this.d.mEntryScene == 0) ? false : true;
    }

    private void b() {
        af.a(getActivity());
        setContentView(R.layout.ksad_activity_trends_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ksad_trends_top_panel), new OnApplyWindowInsetsListener() { // from class: com.kwad.sdk.contentalliance.trends.b.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                af.a(view, windowInsetsCompat.getSystemWindowInsetTop());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            b();
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
    }
}
