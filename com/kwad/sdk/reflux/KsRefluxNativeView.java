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
import com.baidu.tieba.R;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.reflux.b;
import com.kwad.sdk.reflux.kwai.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class KsRefluxNativeView extends FrameLayout {
    public RecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public b f40705b;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static class b extends RecyclerView.Adapter {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public List<com.kwad.sdk.reflux.b> f40706b = new ArrayList();

        public b(Context context) {
            this.a = context;
        }

        private void a(List<com.kwad.sdk.reflux.b> list, List<com.kwad.sdk.reflux.b> list2) {
            com.kwad.sdk.reflux.b bVar;
            int i;
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.add(list2.get(i2));
                if (i2 == size - 1) {
                    bVar = new com.kwad.sdk.reflux.b();
                    i = -2;
                } else {
                    bVar = new com.kwad.sdk.reflux.b();
                    i = -1;
                }
                bVar.b(i);
                list.add(bVar);
            }
        }

        public void a(List<com.kwad.sdk.reflux.b> list) {
            if (list == null) {
                return;
            }
            this.f40706b.clear();
            a(this.f40706b, list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f40706b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.f40706b.get(i).k();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            com.kwad.sdk.reflux.b bVar = this.f40706b.get(i);
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
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View cVar;
            int i2;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (i == FeedType.FEED_TYPE_TEXT_ABOVE.getType()) {
                cVar = new c(this.a);
            } else if (i == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                cVar = new com.kwad.sdk.reflux.kwai.b(this.a);
            } else {
                if (i == -1) {
                    i2 = R.layout.obfuscated_res_0x7f0d045a;
                } else if (i == -2) {
                    i2 = R.layout.obfuscated_res_0x7f0d045f;
                } else {
                    cVar = new c(this.a);
                }
                cVar = from.inflate(i2, viewGroup, false);
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

    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d045e, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0910dc);
        this.a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        b bVar = new b(getContext());
        this.f40705b = bVar;
        bVar.setHasStableIds(true);
        this.a.setAdapter(this.f40705b);
    }

    public void a(List<com.kwad.sdk.reflux.b> list) {
        this.f40705b.a(list);
    }
}
