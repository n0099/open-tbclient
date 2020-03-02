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
    protected View fGH;
    protected b nXs;

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
            this.nXs = (b) adapter;
            super.setAdapter(this.nXs);
        } else if (this.nXs == null) {
            this.nXs = new b(adapter);
            super.setAdapter(this.nXs);
        } else {
            this.nXs.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.nXs;
    }

    public boolean Os(int i) {
        return this.nXs != null && this.nXs.Op(i);
    }

    public int getHeaderViewCount() {
        if (this.nXs == null) {
            return 0;
        }
        return this.nXs.getHeaderViewsCount();
    }

    public boolean dG(View view) {
        return this.nXs != null && this.nXs.dF(view);
    }

    public boolean Ot(int i) {
        return this.nXs != null && this.nXs.Oq(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.nXs == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.nXs.addFooterView(view, i);
    }

    public void dE(View view) {
        if (view != null && this.nXs != null) {
            this.nXs.dE(view);
        }
    }

    public int getFooterViewCount() {
        if (this.nXs == null) {
            return 0;
        }
        return this.nXs.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.fGH = view;
        if (this.nXs == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nXs.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void xg(boolean z) {
                if (ExtendedRecyclerView.this.fGH != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.fGH.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.fGH.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.fGH;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.nXs == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nXs.setLoadMoreProvider(cVar);
    }
}
