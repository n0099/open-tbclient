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
    public final LayoutInflater f33100a;

    /* renamed from: b  reason: collision with root package name */
    public final SceneImpl f33101b;

    /* renamed from: c  reason: collision with root package name */
    public long f33102c;

    /* renamed from: d  reason: collision with root package name */
    public long f33103d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33104e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f33105f;

    /* renamed from: g  reason: collision with root package name */
    public TrendsPanelLayout.b f33106g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0369a extends RecyclerView.ViewHolder {

        /* renamed from: b  reason: collision with root package name */
        public TrendListItemView f33108b;

        public C0369a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.f33108b = trendListItemView;
        }

        public void a(@NonNull final TrendInfo trendInfo, final int i) {
            if (this.f33108b != null) {
                this.f33108b.a(trendInfo, a.this.f33102c == trendInfo.trendId);
                this.f33108b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
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
                                    a.this.f33106g.a(C0369a.this.f33108b, trendInfo, i);
                                    return;
                                } else {
                                    p.a(a.this.f33105f, a.this.f33105f.getString(R.string.ksad_trend_is_no_valid));
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
        this.f33105f = context;
        this.f33101b = bVar.f33114c;
        this.f33100a = LayoutInflater.from(context);
        this.f33102c = bVar.f33113b;
        if (bVar.f33112a != null) {
            this.f33104e.clear();
            for (TrendInfo trendInfo : bVar.f33112a) {
                if (trendInfo != null) {
                    this.f33104e.add(trendInfo);
                }
            }
        }
        this.f33106g = bVar2;
    }

    private void a(int i) {
        long j = i;
        if (j > this.f33103d) {
            this.f33103d = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C0369a onCreateViewHolder(ViewGroup viewGroup, int i) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f33100a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.f33101b);
        return new C0369a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0369a c0369a, int i) {
        c0369a.a(this.f33104e.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33104e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        a(i);
        return super.getItemViewType(i);
    }
}
