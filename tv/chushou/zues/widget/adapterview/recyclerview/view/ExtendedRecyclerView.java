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
/* loaded from: classes6.dex */
public class ExtendedRecyclerView extends RecyclerView {
    protected View hgF;
    protected b oOc;

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
            this.oOc = (b) adapter;
            super.setAdapter(this.oOc);
        } else if (this.oOc == null) {
            this.oOc = new b(adapter);
            super.setAdapter(this.oOc);
        } else {
            this.oOc.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.oOc;
    }

    public boolean OK(int i) {
        return this.oOc != null && this.oOc.OH(i);
    }

    public int getHeaderViewCount() {
        if (this.oOc == null) {
            return 0;
        }
        return this.oOc.getHeaderViewsCount();
    }

    public boolean dH(View view) {
        return this.oOc != null && this.oOc.dG(view);
    }

    public boolean OL(int i) {
        return this.oOc != null && this.oOc.OI(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.oOc == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.oOc.addFooterView(view, i);
    }

    public void dF(View view) {
        if (view != null && this.oOc != null) {
            this.oOc.dF(view);
        }
    }

    public int getFooterViewCount() {
        if (this.oOc == null) {
            return 0;
        }
        return this.oOc.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.hgF = view;
        if (this.oOc == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.oOc.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void zm(boolean z) {
                if (ExtendedRecyclerView.this.hgF != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.hgF.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.hgF.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.hgF;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.oOc == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.oOc.setLoadMoreProvider(cVar);
    }
}
