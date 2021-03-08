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
/* loaded from: classes3.dex */
public class a extends RecyclerView.Adapter<C1101a> {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f5931a;
    private final SceneImpl b;
    private long c;
    private long d;
    private List<TrendInfo> e = new ArrayList();
    private Context f;
    private TrendsPanelLayout.b g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1101a extends RecyclerView.ViewHolder {
        private TrendListItemView b;

        public C1101a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.b = trendListItemView;
        }

        void a(@NonNull final TrendInfo trendInfo, final int i) {
            if (this.b != null) {
                this.b.a(trendInfo, a.this.c == trendInfo.trendId);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (trendInfo != null && trendInfo.offlineTime > 0 && trendInfo.offlineTime < System.currentTimeMillis()) {
                            p.a(a.this.f, a.this.f.getString(R.string.ksad_trend_is_no_valid));
                        } else {
                            a.this.g.a(C1101a.this.b, trendInfo, i);
                        }
                    }
                });
            }
        }
    }

    public a(Context context, @NonNull b bVar, TrendsPanelLayout.b bVar2) {
        this.f = context;
        this.b = bVar.c;
        this.f5931a = LayoutInflater.from(context);
        this.c = bVar.b;
        if (bVar.f5934a != null) {
            this.e.clear();
            for (TrendInfo trendInfo : bVar.f5934a) {
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
    public C1101a onCreateViewHolder(ViewGroup viewGroup, int i) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f5931a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.b);
        return new C1101a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C1101a c1101a, int i) {
        c1101a.a(this.e.get(i), i);
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
