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
/* loaded from: classes5.dex */
public class a extends RecyclerView.Adapter<C1054a> {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f9194a;

    /* renamed from: b  reason: collision with root package name */
    private final SceneImpl f9195b;
    private long c;
    private long d;
    private List<TrendInfo> e = new ArrayList();
    private Context f;
    private TrendsPanelLayout.b g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1054a extends RecyclerView.ViewHolder {

        /* renamed from: b  reason: collision with root package name */
        private TrendListItemView f9197b;

        public C1054a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.f9197b = trendListItemView;
        }

        void a(@NonNull final TrendInfo trendInfo, final int i) {
            if (this.f9197b != null) {
                this.f9197b.a(trendInfo, a.this.c == trendInfo.trendId);
                this.f9197b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (trendInfo != null && trendInfo.offlineTime > 0 && trendInfo.offlineTime < System.currentTimeMillis()) {
                            p.a(a.this.f, a.this.f.getString(R.string.ksad_trend_is_no_valid));
                        } else {
                            a.this.g.a(C1054a.this.f9197b, trendInfo, i);
                        }
                    }
                });
            }
        }
    }

    public a(Context context, @NonNull b bVar, TrendsPanelLayout.b bVar2) {
        this.f = context;
        this.f9195b = bVar.c;
        this.f9194a = LayoutInflater.from(context);
        this.c = bVar.f9201b;
        if (bVar.f9200a != null) {
            this.e.clear();
            for (TrendInfo trendInfo : bVar.f9200a) {
                if (trendInfo != null) {
                    this.e.add(trendInfo);
                }
            }
        }
        this.g = bVar2;
    }

    private void a(int i) {
        if (i > this.d) {
            this.d = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C1054a onCreateViewHolder(ViewGroup viewGroup, int i) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f9194a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.f9195b);
        return new C1054a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C1054a c1054a, int i) {
        c1054a.a(this.e.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        a(i);
        return super.getItemViewType(i);
    }
}
