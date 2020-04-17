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
    protected View gmk;
    protected b ntk;

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
            this.ntk = (b) adapter;
            super.setAdapter(this.ntk);
        } else if (this.ntk == null) {
            this.ntk = new b(adapter);
            super.setAdapter(this.ntk);
        } else {
            this.ntk.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.ntk;
    }

    public boolean JU(int i) {
        return this.ntk != null && this.ntk.JR(i);
    }

    public int getHeaderViewCount() {
        if (this.ntk == null) {
            return 0;
        }
        return this.ntk.getHeaderViewsCount();
    }

    public boolean dx(View view) {
        return this.ntk != null && this.ntk.dw(view);
    }

    public boolean JV(int i) {
        return this.ntk != null && this.ntk.JS(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.ntk == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.ntk.addFooterView(view, i);
    }

    public void dv(View view) {
        if (view != null && this.ntk != null) {
            this.ntk.dv(view);
        }
    }

    public int getFooterViewCount() {
        if (this.ntk == null) {
            return 0;
        }
        return this.ntk.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.gmk = view;
        if (this.ntk == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.ntk.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void wT(boolean z) {
                if (ExtendedRecyclerView.this.gmk != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.gmk.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.gmk.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.gmk;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.ntk == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.ntk.setLoadMoreProvider(cVar);
    }
}
