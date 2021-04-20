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
public class a extends RecyclerView.Adapter<C0383a> {

    /* renamed from: a  reason: collision with root package name */
    public final LayoutInflater f33389a;

    /* renamed from: b  reason: collision with root package name */
    public final SceneImpl f33390b;

    /* renamed from: c  reason: collision with root package name */
    public long f33391c;

    /* renamed from: d  reason: collision with root package name */
    public long f33392d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33393e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f33394f;

    /* renamed from: g  reason: collision with root package name */
    public TrendsPanelLayout.b f33395g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0383a extends RecyclerView.ViewHolder {

        /* renamed from: b  reason: collision with root package name */
        public TrendListItemView f33397b;

        public C0383a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.f33397b = trendListItemView;
        }

        public void a(@NonNull final TrendInfo trendInfo, final int i) {
            if (this.f33397b != null) {
                this.f33397b.a(trendInfo, a.this.f33391c == trendInfo.trendId);
                this.f33397b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
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
                                    a.this.f33395g.a(C0383a.this.f33397b, trendInfo, i);
                                    return;
                                } else {
                                    p.a(a.this.f33394f, a.this.f33394f.getString(R.string.ksad_trend_is_no_valid));
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
        this.f33394f = context;
        this.f33390b = bVar.f33403c;
        this.f33389a = LayoutInflater.from(context);
        this.f33391c = bVar.f33402b;
        if (bVar.f33401a != null) {
            this.f33393e.clear();
            for (TrendInfo trendInfo : bVar.f33401a) {
                if (trendInfo != null) {
                    this.f33393e.add(trendInfo);
                }
            }
        }
        this.f33395g = bVar2;
    }

    private void a(int i) {
        long j = i;
        if (j > this.f33392d) {
            this.f33392d = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C0383a onCreateViewHolder(ViewGroup viewGroup, int i) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f33389a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.f33390b);
        return new C0383a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0383a c0383a, int i) {
        c0383a.a(this.f33393e.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33393e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        a(i);
        return super.getItemViewType(i);
    }
}
