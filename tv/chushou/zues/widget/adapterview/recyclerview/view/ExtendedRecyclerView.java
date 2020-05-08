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
    protected View gmq;
    protected b ntn;

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
            this.ntn = (b) adapter;
            super.setAdapter(this.ntn);
        } else if (this.ntn == null) {
            this.ntn = new b(adapter);
            super.setAdapter(this.ntn);
        } else {
            this.ntn.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.ntn;
    }

    public boolean JU(int i) {
        return this.ntn != null && this.ntn.JR(i);
    }

    public int getHeaderViewCount() {
        if (this.ntn == null) {
            return 0;
        }
        return this.ntn.getHeaderViewsCount();
    }

    public boolean dx(View view) {
        return this.ntn != null && this.ntn.dw(view);
    }

    public boolean JV(int i) {
        return this.ntn != null && this.ntn.JS(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.ntn == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.ntn.addFooterView(view, i);
    }

    public void dv(View view) {
        if (view != null && this.ntn != null) {
            this.ntn.dv(view);
        }
    }

    public int getFooterViewCount() {
        if (this.ntn == null) {
            return 0;
        }
        return this.ntn.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.gmq = view;
        if (this.ntn == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.ntn.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void wT(boolean z) {
                if (ExtendedRecyclerView.this.gmq != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.gmq.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.gmq.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.gmq;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.ntn == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.ntn.setLoadMoreProvider(cVar);
    }
}
