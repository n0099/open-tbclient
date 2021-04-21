package com.kwad.sdk.contentalliance.trends;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.g;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<TrendInfo> f33448a;

    /* renamed from: b  reason: collision with root package name */
    public TrendInfo f33449b;

    /* renamed from: c  reason: collision with root package name */
    public KsScene f33450c;

    public c(@NonNull KsScene ksScene) {
        this.f33450c = ksScene;
    }

    @NonNull
    public KsFragment a() {
        g a2 = g.a(this.f33450c);
        Bundle arguments = a2.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putString("KEY_TREND_LIST_DATA", TrendInfo.toString(this.f33448a));
        arguments.putString("KEY_CURRENT_TREND", this.f33449b.toJson().toString());
        return a2;
    }

    public void a(@NonNull List<TrendInfo> list, @NonNull TrendInfo trendInfo) {
        this.f33448a = list;
        this.f33449b = trendInfo;
    }
}
