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
public class a extends RecyclerView.Adapter<C0369a> {

    /* renamed from: a  reason: collision with root package name */
    public final LayoutInflater f33709a;

    /* renamed from: b  reason: collision with root package name */
    public final SceneImpl f33710b;

    /* renamed from: c  reason: collision with root package name */
    public long f33711c;

    /* renamed from: d  reason: collision with root package name */
    public long f33712d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33713e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f33714f;

    /* renamed from: g  reason: collision with root package name */
    public TrendsPanelLayout.b f33715g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0369a extends RecyclerView.ViewHolder {

        /* renamed from: b  reason: collision with root package name */
        public TrendListItemView f33717b;

        public C0369a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.f33717b = trendListItemView;
        }

        public void a(@NonNull final TrendInfo trendInfo, final int i2) {
            if (this.f33717b != null) {
                this.f33717b.a(trendInfo, a.this.f33711c == trendInfo.trendId);
                this.f33717b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
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
                                    a.this.f33715g.a(C0369a.this.f33717b, trendInfo, i2);
                                    return;
                                } else {
                                    p.a(a.this.f33714f, a.this.f33714f.getString(R.string.ksad_trend_is_no_valid));
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
        this.f33714f = context;
        this.f33710b = bVar.f33723c;
        this.f33709a = LayoutInflater.from(context);
        this.f33711c = bVar.f33722b;
        if (bVar.f33721a != null) {
            this.f33713e.clear();
            for (TrendInfo trendInfo : bVar.f33721a) {
                if (trendInfo != null) {
                    this.f33713e.add(trendInfo);
                }
            }
        }
        this.f33715g = bVar2;
    }

    private void a(int i2) {
        long j = i2;
        if (j > this.f33712d) {
            this.f33712d = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C0369a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f33709a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.f33710b);
        return new C0369a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0369a c0369a, int i2) {
        c0369a.a(this.f33713e.get(i2), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33713e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        a(i2);
        return super.getItemViewType(i2);
    }
}
