package com.kwad.sdk.reflux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.reflux.b;
import com.kwad.sdk.reflux.kwai.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class KsRefluxNativeView extends FrameLayout {
    public RecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public b f59406b;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        @Nullable
        public com.kwad.sdk.reflux.kwai.a a() {
            View view = this.itemView;
            if (view instanceof com.kwad.sdk.reflux.kwai.a) {
                return (com.kwad.sdk.reflux.kwai.a) view;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.Adapter {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public List<com.kwad.sdk.reflux.b> f59407b = new ArrayList();

        public b(Context context) {
            this.a = context;
        }

        private void a(List<com.kwad.sdk.reflux.b> list, List<com.kwad.sdk.reflux.b> list2) {
            com.kwad.sdk.reflux.b bVar;
            int i2;
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                list.add(list2.get(i3));
                if (i3 == size - 1) {
                    bVar = new com.kwad.sdk.reflux.b();
                    i2 = -2;
                } else {
                    bVar = new com.kwad.sdk.reflux.b();
                    i2 = -1;
                }
                bVar.b(i2);
                list.add(bVar);
            }
        }

        public void a(List<com.kwad.sdk.reflux.b> list) {
            if (list == null) {
                return;
            }
            this.f59407b.clear();
            a(this.f59407b, list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f59407b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            return this.f59407b.get(i2).k();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            com.kwad.sdk.reflux.b bVar = this.f59407b.get(i2);
            a aVar = (a) viewHolder;
            int itemViewType = aVar.getItemViewType();
            if (itemViewType == FeedType.FEED_TYPE_UNKNOWN.getType() || itemViewType == FeedType.FEED_TYPE_TEXT_ABOVE.getType() || itemViewType == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                if (bVar.i()) {
                    bVar.b();
                    bVar.a(new b.a() { // from class: com.kwad.sdk.reflux.KsRefluxNativeView.b.1
                        @Override // com.kwad.sdk.reflux.b.a
                        public void a(com.kwad.sdk.reflux.b bVar2) {
                            try {
                                b.this.notifyDataSetChanged();
                            } catch (IllegalStateException unused) {
                            }
                        }
                    });
                }
                com.kwad.sdk.reflux.kwai.a a = aVar.a();
                if (a != null) {
                    a.a(bVar);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            View cVar;
            int i3;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (i2 == FeedType.FEED_TYPE_TEXT_ABOVE.getType()) {
                cVar = new c(this.a);
            } else if (i2 == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                cVar = new com.kwad.sdk.reflux.kwai.b(this.a);
            } else {
                if (i2 == -1) {
                    i3 = R.layout.ksad_reflux_card_divider;
                } else if (i2 == -2) {
                    i3 = R.layout.ksad_reflux_native_list_footer;
                } else {
                    cVar = new c(this.a);
                }
                cVar = from.inflate(i3, viewGroup, false);
            }
            cVar.setLayoutParams(layoutParams);
            return new a(cVar);
        }
    }

    public KsRefluxNativeView(@NonNull Context context) {
        super(context);
        a(context, null, 0);
    }

    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        FrameLayout.inflate(context, R.layout.ksad_reflux_native, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ksad_reflux_native_list);
        this.a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        b bVar = new b(getContext());
        this.f59406b = bVar;
        bVar.setHasStableIds(true);
        this.a.setAdapter(this.f59406b);
    }

    public void a(List<com.kwad.sdk.reflux.b> list) {
        this.f59406b.a(list);
    }
}
