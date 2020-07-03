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
    protected View gOc;
    protected b oli;

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
            this.oli = (b) adapter;
            super.setAdapter(this.oli);
        } else if (this.oli == null) {
            this.oli = new b(adapter);
            super.setAdapter(this.oli);
        } else {
            this.oli.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.oli;
    }

    public boolean LN(int i) {
        return this.oli != null && this.oli.LK(i);
    }

    public int getHeaderViewCount() {
        if (this.oli == null) {
            return 0;
        }
        return this.oli.getHeaderViewsCount();
    }

    public boolean dz(View view) {
        return this.oli != null && this.oli.dy(view);
    }

    public boolean LO(int i) {
        return this.oli != null && this.oli.LL(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.oli == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.oli.addFooterView(view, i);
    }

    public void dx(View view) {
        if (view != null && this.oli != null) {
            this.oli.dx(view);
        }
    }

    public int getFooterViewCount() {
        if (this.oli == null) {
            return 0;
        }
        return this.oli.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.gOc = view;
        if (this.oli == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.oli.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void xN(boolean z) {
                if (ExtendedRecyclerView.this.gOc != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.gOc.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.gOc.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.gOc;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.oli == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.oli.setLoadMoreProvider(cVar);
    }
}
