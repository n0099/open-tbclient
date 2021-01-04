package com.kwad.sdk.contentalliance.trends;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.g;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private List<TrendInfo> f9177a;

    /* renamed from: b  reason: collision with root package name */
    private TrendInfo f9178b;
    private KsScene c;

    public c(@NonNull KsScene ksScene) {
        this.c = ksScene;
    }

    @NonNull
    public KsFragment a() {
        g a2 = g.a(this.c);
        Bundle arguments = a2.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putString("KEY_TREND_LIST_DATA", TrendInfo.toString(this.f9177a));
        arguments.putString("KEY_CURRENT_TREND", this.f9178b.toJson().toString());
        return a2;
    }

    public void a(@NonNull List<TrendInfo> list, @NonNull TrendInfo trendInfo) {
        this.f9177a = list;
        this.f9178b = trendInfo;
    }
}
