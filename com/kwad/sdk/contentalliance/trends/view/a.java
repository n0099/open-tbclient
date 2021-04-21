package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends RecyclerView.Adapter<C0386a> {

    /* renamed from: a  reason: collision with root package name */
    public final LayoutInflater f33484a;

    /* renamed from: b  reason: collision with root package name */
    public final SceneImpl f33485b;

    /* renamed from: c  reason: collision with root package name */
    public long f33486c;

    /* renamed from: d  reason: collision with root package name */
    public long f33487d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33488e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f33489f;

    /* renamed from: g  reason: collision with root package name */
    public TrendsPanelLayout.b f33490g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0386a extends RecyclerView.ViewHolder {

        /* renamed from: b  reason: collision with root package name */
        public TrendListItemView f33492b;

        public C0386a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.f33492b = trendListItemView;
        }

        public void a(@NonNull final TrendInfo trendInfo, final int i) {
            if (this.f33492b != null) {
                this.f33492b.a(trendInfo, a.this.f33486c == trendInfo.trendId);
                this.f33492b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
                    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
                    @Override // android.view.View.OnClickListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onClick(View view) {
                        boolean z;
                        TrendInfo trendInfo2 = trendInfo;
                        if (trendInfo2 != null) {
                            long j = trendInfo2.offlineTime;
                            if (j > 0 && j < System.currentTimeMillis()) {
                                z = true;
                                if (z) {
                                    a.this.f33490g.a(C0386a.this.f33492b, trendInfo, i);
                                    return;
                                } else {
                                    p.a(a.this.f33489f, a.this.f33489f.getString(R.string.ksad_trend_is_no_valid));
                                    return;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                });
            }
        }
    }

    public a(Context context, @NonNull b bVar, TrendsPanelLayout.b bVar2) {
        this.f33489f = context;
        this.f33485b = bVar.f33498c;
        this.f33484a = LayoutInflater.from(context);
        this.f33486c = bVar.f33497b;
        if (bVar.f33496a != null) {
            this.f33488e.clear();
            for (TrendInfo trendInfo : bVar.f33496a) {
                if (trendInfo != null) {
                    this.f33488e.add(trendInfo);
                }
            }
        }
        this.f33490g = bVar2;
    }

    private void a(int i) {
        long j = i;
        if (j > this.f33487d) {
            this.f33487d = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C0386a onCreateViewHolder(ViewGroup viewGroup, int i) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f33484a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.f33485b);
        return new C0386a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0386a c0386a, int i) {
        c0386a.a(this.f33488e.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33488e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        a(i);
        return super.getItemViewType(i);
    }
}
