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
    protected View fHC;
    protected b nZq;

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
            this.nZq = (b) adapter;
            super.setAdapter(this.nZq);
        } else if (this.nZq == null) {
            this.nZq = new b(adapter);
            super.setAdapter(this.nZq);
        } else {
            this.nZq.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.nZq;
    }

    public boolean Oy(int i) {
        return this.nZq != null && this.nZq.Ov(i);
    }

    public int getHeaderViewCount() {
        if (this.nZq == null) {
            return 0;
        }
        return this.nZq.getHeaderViewsCount();
    }

    public boolean dG(View view) {
        return this.nZq != null && this.nZq.dF(view);
    }

    public boolean Oz(int i) {
        return this.nZq != null && this.nZq.Ow(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.nZq == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.nZq.addFooterView(view, i);
    }

    public void dE(View view) {
        if (view != null && this.nZq != null) {
            this.nZq.dE(view);
        }
    }

    public int getFooterViewCount() {
        if (this.nZq == null) {
            return 0;
        }
        return this.nZq.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.fHC = view;
        if (this.nZq == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nZq.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void xo(boolean z) {
                if (ExtendedRecyclerView.this.fHC != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.fHC.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.fHC.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.fHC;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.nZq == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nZq.setLoadMoreProvider(cVar);
    }
}
