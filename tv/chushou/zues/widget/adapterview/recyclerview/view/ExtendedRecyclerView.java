package tv.chushou.zues.widget.adapterview.recyclerview.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.widget.adapterview.a;
import tv.chushou.zues.widget.adapterview.c;
import tv.chushou.zues.widget.adapterview.recyclerview.a.b;
/* loaded from: classes5.dex */
public class ExtendedRecyclerView extends RecyclerView {
    protected View fGF;
    protected b nXq;

    public ExtendedRecyclerView(Context context) {
        super(context);
    }

    public ExtendedRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExtendedRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof b) {
            this.nXq = (b) adapter;
            super.setAdapter(this.nXq);
        } else if (this.nXq == null) {
            this.nXq = new b(adapter);
            super.setAdapter(this.nXq);
        } else {
            this.nXq.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.nXq;
    }

    public boolean Os(int i) {
        return this.nXq != null && this.nXq.Op(i);
    }

    public int getHeaderViewCount() {
        if (this.nXq == null) {
            return 0;
        }
        return this.nXq.getHeaderViewsCount();
    }

    public boolean dG(View view) {
        return this.nXq != null && this.nXq.dF(view);
    }

    public boolean Ot(int i) {
        return this.nXq != null && this.nXq.Oq(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.nXq == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.nXq.addFooterView(view, i);
    }

    public void dE(View view) {
        if (view != null && this.nXq != null) {
            this.nXq.dE(view);
        }
    }

    public int getFooterViewCount() {
        if (this.nXq == null) {
            return 0;
        }
        return this.nXq.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.fGF = view;
        if (this.nXq == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nXq.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void xg(boolean z) {
                if (ExtendedRecyclerView.this.fGF != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.fGF.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.fGF.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.fGF;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.nXq == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nXq.setLoadMoreProvider(cVar);
    }
}
