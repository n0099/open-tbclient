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
    protected View gBr;
    protected b nPu;

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
            this.nPu = (b) adapter;
            super.setAdapter(this.nPu);
        } else if (this.nPu == null) {
            this.nPu = new b(adapter);
            super.setAdapter(this.nPu);
        } else {
            this.nPu.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.nPu;
    }

    public boolean KH(int i) {
        return this.nPu != null && this.nPu.KE(i);
    }

    public int getHeaderViewCount() {
        if (this.nPu == null) {
            return 0;
        }
        return this.nPu.getHeaderViewsCount();
    }

    public boolean dy(View view) {
        return this.nPu != null && this.nPu.dx(view);
    }

    public boolean KI(int i) {
        return this.nPu != null && this.nPu.KF(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.nPu == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.nPu.addFooterView(view, i);
    }

    public void dw(View view) {
        if (view != null && this.nPu != null) {
            this.nPu.dw(view);
        }
    }

    public int getFooterViewCount() {
        if (this.nPu == null) {
            return 0;
        }
        return this.nPu.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.gBr = view;
        if (this.nPu == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nPu.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void xs(boolean z) {
                if (ExtendedRecyclerView.this.gBr != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.gBr.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.gBr.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.gBr;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.nPu == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nPu.setLoadMoreProvider(cVar);
    }
}
