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
public class a extends RecyclerView.Adapter<C0372a> {

    /* renamed from: a  reason: collision with root package name */
    public final LayoutInflater f33807a;

    /* renamed from: b  reason: collision with root package name */
    public final SceneImpl f33808b;

    /* renamed from: c  reason: collision with root package name */
    public long f33809c;

    /* renamed from: d  reason: collision with root package name */
    public long f33810d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33811e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f33812f;

    /* renamed from: g  reason: collision with root package name */
    public TrendsPanelLayout.b f33813g;

    /* renamed from: com.kwad.sdk.contentalliance.trends.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0372a extends RecyclerView.ViewHolder {

        /* renamed from: b  reason: collision with root package name */
        public TrendListItemView f33815b;

        public C0372a(TrendListItemView trendListItemView) {
            super(trendListItemView);
            this.f33815b = trendListItemView;
        }

        public void a(@NonNull final TrendInfo trendInfo, final int i2) {
            if (this.f33815b != null) {
                this.f33815b.a(trendInfo, a.this.f33809c == trendInfo.trendId);
                this.f33815b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.a.a.1
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
                                    a.this.f33813g.a(C0372a.this.f33815b, trendInfo, i2);
                                    return;
                                } else {
                                    p.a(a.this.f33812f, a.this.f33812f.getString(R.string.ksad_trend_is_no_valid));
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
        this.f33812f = context;
        this.f33808b = bVar.f33821c;
        this.f33807a = LayoutInflater.from(context);
        this.f33809c = bVar.f33820b;
        if (bVar.f33819a != null) {
            this.f33811e.clear();
            for (TrendInfo trendInfo : bVar.f33819a) {
                if (trendInfo != null) {
                    this.f33811e.add(trendInfo);
                }
            }
        }
        this.f33813g = bVar2;
    }

    private void a(int i2) {
        long j = i2;
        if (j > this.f33810d) {
            this.f33810d = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C0372a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        TrendListItemView trendListItemView = (TrendListItemView) this.f33807a.inflate(R.layout.ksad_trend_panel_list_item_2, viewGroup, false);
        trendListItemView.setAdScene(this.f33808b);
        return new C0372a(trendListItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0372a c0372a, int i2) {
        c0372a.a(this.f33811e.get(i2), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33811e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        a(i2);
        return super.getItemViewType(i2);
    }
}
