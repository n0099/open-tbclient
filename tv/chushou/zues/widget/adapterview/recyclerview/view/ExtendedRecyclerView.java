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
    protected View hgB;
    protected b oNK;

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
            this.oNK = (b) adapter;
            super.setAdapter(this.oNK);
        } else if (this.oNK == null) {
            this.oNK = new b(adapter);
            super.setAdapter(this.oNK);
        } else {
            this.oNK.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.oNK;
    }

    public boolean OK(int i) {
        return this.oNK != null && this.oNK.OH(i);
    }

    public int getHeaderViewCount() {
        if (this.oNK == null) {
            return 0;
        }
        return this.oNK.getHeaderViewsCount();
    }

    public boolean dH(View view) {
        return this.oNK != null && this.oNK.dG(view);
    }

    public boolean OL(int i) {
        return this.oNK != null && this.oNK.OI(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.oNK == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.oNK.addFooterView(view, i);
    }

    public void dF(View view) {
        if (view != null && this.oNK != null) {
            this.oNK.dF(view);
        }
    }

    public int getFooterViewCount() {
        if (this.oNK == null) {
            return 0;
        }
        return this.oNK.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.hgB = view;
        if (this.oNK == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.oNK.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void zk(boolean z) {
                if (ExtendedRecyclerView.this.hgB != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.hgB.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.hgB.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.hgB;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.oNK == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.oNK.setLoadMoreProvider(cVar);
    }
}
