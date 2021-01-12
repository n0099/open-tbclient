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
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C1078a> {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f8895a;

    /* renamed from: b  reason: collision with root package name */
    private final SceneImpl f8896b;
    private long c;
    private long d;
    private List<TrendInfo> e = new ArrayList();
    private Context f;
    private TrendsPanelLayout.b g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1078a extends RecyclerView.ViewHolder {

        /* renamed from: b  reason: collision with root package name */
        private TrendListItemView f8898b;

        public C1078a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.f8898b = trendListItemView;
        }

        void a(@NonNull final TrendInfo trendInfo, final int i) {
            if (this.f8898b != null) {
                this.f8898b.a(trendInfo, a.this.c == trendInfo.trendId);
                this.f8898b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (trendInfo != null && trendInfo.offlineTime > 0 && trendInfo.offlineTime < System.currentTimeMillis()) {
                            p.a(a.this.f, a.this.f.getString(R.string.ksad_trend_is_no_valid));
                        } else {
                            a.this.g.a(C1078a.this.f8898b, trendInfo, i);
                        }
                    }
                });
            }
        }
    }

    public a(Context context, @NonNull b bVar, TrendsPanelLayout.b bVar2) {
        this.f = context;
        this.f8896b = bVar.c;
        this.f8895a = LayoutInflater.from(context);
        this.c = bVar.f8902b;
        if (bVar.f8901a != null) {
            this.e.clear();
            for (TrendInfo trendInfo : bVar.f8901a) {
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
    public C1078a onCreateViewHolder(ViewGroup viewGroup, int i) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f8895a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.f8896b);
        return new C1078a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C1078a c1078a, int i) {
        c1078a.a(this.e.get(i), i);
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
