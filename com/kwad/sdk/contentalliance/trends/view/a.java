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
public class a extends RecyclerView.Adapter<C0368a> {

    /* renamed from: a  reason: collision with root package name */
    public final LayoutInflater f33099a;

    /* renamed from: b  reason: collision with root package name */
    public final SceneImpl f33100b;

    /* renamed from: c  reason: collision with root package name */
    public long f33101c;

    /* renamed from: d  reason: collision with root package name */
    public long f33102d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33103e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f33104f;

    /* renamed from: g  reason: collision with root package name */
    public TrendsPanelLayout.b f33105g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0368a extends RecyclerView.ViewHolder {

        /* renamed from: b  reason: collision with root package name */
        public TrendListItemView f33107b;

        public C0368a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.f33107b = trendListItemView;
        }

        public void a(@NonNull final TrendInfo trendInfo, final int i) {
            if (this.f33107b != null) {
                this.f33107b.a(trendInfo, a.this.f33101c == trendInfo.trendId);
                this.f33107b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
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
                                    a.this.f33105g.a(C0368a.this.f33107b, trendInfo, i);
                                    return;
                                } else {
                                    p.a(a.this.f33104f, a.this.f33104f.getString(R.string.ksad_trend_is_no_valid));
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
        this.f33104f = context;
        this.f33100b = bVar.f33113c;
        this.f33099a = LayoutInflater.from(context);
        this.f33101c = bVar.f33112b;
        if (bVar.f33111a != null) {
            this.f33103e.clear();
            for (TrendInfo trendInfo : bVar.f33111a) {
                if (trendInfo != null) {
                    this.f33103e.add(trendInfo);
                }
            }
        }
        this.f33105g = bVar2;
    }

    private void a(int i) {
        long j = i;
        if (j > this.f33102d) {
            this.f33102d = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C0368a onCreateViewHolder(ViewGroup viewGroup, int i) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f33099a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.f33100b);
        return new C0368a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0368a c0368a, int i) {
        c0368a.a(this.f33103e.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33103e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        a(i);
        return super.getItemViewType(i);
    }
}
