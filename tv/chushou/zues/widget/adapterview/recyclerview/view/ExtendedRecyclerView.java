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
    protected View fGU;
    protected b nXD;

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
            this.nXD = (b) adapter;
            super.setAdapter(this.nXD);
        } else if (this.nXD == null) {
            this.nXD = new b(adapter);
            super.setAdapter(this.nXD);
        } else {
            this.nXD.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.nXD;
    }

    public boolean Os(int i) {
        return this.nXD != null && this.nXD.Op(i);
    }

    public int getHeaderViewCount() {
        if (this.nXD == null) {
            return 0;
        }
        return this.nXD.getHeaderViewsCount();
    }

    public boolean dG(View view) {
        return this.nXD != null && this.nXD.dF(view);
    }

    public boolean Ot(int i) {
        return this.nXD != null && this.nXD.Oq(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.nXD == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.nXD.addFooterView(view, i);
    }

    public void dE(View view) {
        if (view != null && this.nXD != null) {
            this.nXD.dE(view);
        }
    }

    public int getFooterViewCount() {
        if (this.nXD == null) {
            return 0;
        }
        return this.nXD.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.fGU = view;
        if (this.nXD == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nXD.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void xg(boolean z) {
                if (ExtendedRecyclerView.this.fGU != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.fGU.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.fGU.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.fGU;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.nXD == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nXD.setLoadMoreProvider(cVar);
    }
}
