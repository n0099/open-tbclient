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
/* loaded from: classes6.dex */
public class b extends IFragmentActivityProxy {

    /* renamed from: a  reason: collision with root package name */
    public TrendInfo f33057a = new TrendInfo();

    /* renamed from: b  reason: collision with root package name */
    public KsFragment f33058b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f33059c;

    /* renamed from: d  reason: collision with root package name */
    public TrendsParams f33060d;

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
                c a2 = b.a(b.this.f33059c, new ArrayList(), b.this.f33057a);
                b.this.f33058b = a2.a();
                if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                    return;
                }
                b.this.getSupportFragmentManager().beginTransaction().replace(i, b.this.f33058b).commitAllowingStateLoss();
            }

            @Override // com.kwad.sdk.core.g.o.d
            public void a(@NonNull List<TrendInfo> list) {
                Collections.sort(list, TrendInfo.mTrendsComparator);
                c a2 = b.a(b.this.f33059c, list, b.this.f33057a);
                b.this.f33058b = a2.a();
                if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                    return;
                }
                b.this.getSupportFragmentManager().beginTransaction().replace(i, b.this.f33058b).commitAllowingStateLoss();
            }
        });
    }

    private boolean a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TREND_PARAMS");
        if (serializableExtra instanceof TrendsParams) {
            TrendsParams trendsParams = (TrendsParams) serializableExtra;
            this.f33060d = trendsParams;
            TrendInfo trendInfo = trendsParams.trendInfo;
            if (trendInfo != null) {
                this.f33057a = trendInfo;
            }
            this.f33059c = new SceneImpl(this.f33060d.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 2);
            uRLPackage.putParams(URLPackage.KEY_TREND_ID, this.f33057a.trendId);
            this.f33059c.setUrlPackage(uRLPackage);
        }
        TrendsParams trendsParams2 = this.f33060d;
        return (trendsParams2 == null || trendsParams2.mEntryScene == 0) ? false : true;
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

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            b();
            a(true);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
    }
}
