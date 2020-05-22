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
    protected View gBg;
    protected b nOk;

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
            this.nOk = (b) adapter;
            super.setAdapter(this.nOk);
        } else if (this.nOk == null) {
            this.nOk = new b(adapter);
            super.setAdapter(this.nOk);
        } else {
            this.nOk.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.nOk;
    }

    public boolean KF(int i) {
        return this.nOk != null && this.nOk.KC(i);
    }

    public int getHeaderViewCount() {
        if (this.nOk == null) {
            return 0;
        }
        return this.nOk.getHeaderViewsCount();
    }

    public boolean dy(View view) {
        return this.nOk != null && this.nOk.dx(view);
    }

    public boolean KG(int i) {
        return this.nOk != null && this.nOk.KD(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.nOk == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.nOk.addFooterView(view, i);
    }

    public void dw(View view) {
        if (view != null && this.nOk != null) {
            this.nOk.dw(view);
        }
    }

    public int getFooterViewCount() {
        if (this.nOk == null) {
            return 0;
        }
        return this.nOk.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.gBg = view;
        if (this.nOk == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nOk.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void xq(boolean z) {
                if (ExtendedRecyclerView.this.gBg != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.gBg.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.gBg.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.gBg;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.nOk == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nOk.setLoadMoreProvider(cVar);
    }
}
