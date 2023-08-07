package com.kwad.components.ad.reflux;

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
import com.kwad.components.ad.reflux.a;
import com.kwad.components.ad.reward.c.c;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class KsRefluxNativeView extends FrameLayout {
    public RecyclerView kG;
    public b kH;

    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view2) {
            super(view2);
        }

        @Nullable
        public final com.kwad.components.ad.reflux.kwai.a eE() {
            View view2 = this.itemView;
            if (view2 instanceof com.kwad.components.ad.reflux.kwai.a) {
                return (com.kwad.components.ad.reflux.kwai.a) view2;
            }
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends RecyclerView.Adapter {
        public List<com.kwad.components.ad.reflux.a> kI = new ArrayList();
        public c kJ;
        public Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public static void a(List<com.kwad.components.ad.reflux.a> list, List<com.kwad.components.ad.reflux.a> list2) {
            com.kwad.components.ad.reflux.a aVar;
            int i;
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.add(list2.get(i2));
                if (i2 == size - 1) {
                    aVar = new com.kwad.components.ad.reflux.a(null);
                    i = -2;
                } else {
                    aVar = new com.kwad.components.ad.reflux.a(null);
                    i = -1;
                }
                aVar.K(i);
                list.add(aVar);
            }
        }

        public final void d(List<com.kwad.components.ad.reflux.a> list) {
            if (list == null) {
                return;
            }
            this.kI.clear();
            a(this.kI, list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.kI.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i) {
            return this.kI.get(i).eR();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            com.kwad.components.ad.reflux.a aVar = this.kI.get(i);
            a aVar2 = (a) viewHolder;
            int itemViewType = aVar2.getItemViewType();
            if (itemViewType == FeedType.FEED_TYPE_UNKNOWN.getType() || itemViewType == FeedType.FEED_TYPE_TEXT_ABOVE.getType() || itemViewType == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                if (aVar.eP()) {
                    aVar.eK();
                    aVar.a(new a.InterfaceC0616a() { // from class: com.kwad.components.ad.reflux.KsRefluxNativeView.b.1
                        @Override // com.kwad.components.ad.reflux.a.InterfaceC0616a
                        public final void eF() {
                            try {
                                b.this.notifyDataSetChanged();
                            } catch (IllegalStateException unused) {
                            }
                        }
                    });
                }
                com.kwad.components.ad.reflux.kwai.a eE = aVar2.eE();
                if (eE != null) {
                    eE.a(aVar);
                }
            }
            View view2 = viewHolder.itemView;
            if (view2 instanceof com.kwad.components.ad.reflux.kwai.a) {
                final com.kwad.components.ad.reward.c.b eJ = aVar.eJ();
                ((com.kwad.components.ad.reflux.kwai.a) view2).setAdClickListener(new b.a() { // from class: com.kwad.components.ad.reflux.KsRefluxNativeView.b.2
                    @Override // com.kwad.components.core.widget.b.a, com.kwad.components.core.widget.b.InterfaceC0671b
                    public final void onAdClicked() {
                        super.onAdClicked();
                        if (b.this.kJ != null) {
                            b.this.kJ.d(eJ);
                        }
                    }

                    @Override // com.kwad.components.core.widget.b.a, com.kwad.components.core.widget.b.InterfaceC0671b
                    public final void onAdShow() {
                        super.onAdShow();
                        if (b.this.kJ != null) {
                            b.this.kJ.e(eJ);
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View cVar;
            int i2;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (i == FeedType.FEED_TYPE_TEXT_ABOVE.getType()) {
                cVar = new com.kwad.components.ad.reflux.kwai.c(this.mContext);
            } else if (i == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                cVar = new com.kwad.components.ad.reflux.kwai.b(this.mContext);
            } else {
                if (i == -1) {
                    i2 = R.layout.obfuscated_res_0x7f0d04c3;
                } else if (i == -2) {
                    i2 = R.layout.obfuscated_res_0x7f0d04c7;
                } else {
                    cVar = new com.kwad.components.ad.reflux.kwai.c(this.mContext);
                }
                cVar = from.inflate(i2, viewGroup, false);
            }
            cVar.setLayoutParams(layoutParams);
            return new a(cVar);
        }

        public final void setInnerAdInteractionListener(c cVar) {
            this.kJ = cVar;
        }
    }

    public KsRefluxNativeView(@NonNull Context context) {
        super(context);
        L(context);
    }

    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        L(context);
    }

    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        L(context);
    }

    @RequiresApi(api = 21)
    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        L(context);
    }

    private void L(@NonNull Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04c6, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091357);
        this.kG = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        b bVar = new b(getContext());
        this.kH = bVar;
        bVar.setHasStableIds(true);
        this.kG.setAdapter(this.kH);
    }

    public final void c(List<com.kwad.components.ad.reflux.a> list) {
        this.kH.d(list);
    }

    public void setInnerAdInteractionListener(c cVar) {
        b bVar = this.kH;
        if (bVar != null) {
            bVar.setInnerAdInteractionListener(cVar);
        }
    }
}
