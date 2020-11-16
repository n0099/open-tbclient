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
    protected View hVt;
    protected b qpk;

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
            this.qpk = (b) adapter;
            super.setAdapter(this.qpk);
        } else if (this.qpk == null) {
            this.qpk = new b(adapter);
            super.setAdapter(this.qpk);
        } else {
            this.qpk.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.qpk;
    }

    public boolean SJ(int i) {
        return this.qpk != null && this.qpk.SG(i);
    }

    public int getHeaderViewCount() {
        if (this.qpk == null) {
            return 0;
        }
        return this.qpk.getHeaderViewsCount();
    }

    public boolean er(View view) {
        return this.qpk != null && this.qpk.eq(view);
    }

    public boolean vA(int i) {
        return this.qpk != null && this.qpk.SH(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.qpk == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.qpk.addFooterView(view, i);
    }

    public void ep(View view) {
        if (view != null && this.qpk != null) {
            this.qpk.ep(view);
        }
    }

    public int getFooterViewCount() {
        if (this.qpk == null) {
            return 0;
        }
        return this.qpk.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.hVt = view;
        if (this.qpk == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.qpk.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void BA(boolean z) {
                if (ExtendedRecyclerView.this.hVt != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.hVt.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.hVt.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.hVt;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.qpk == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.qpk.setLoadMoreProvider(cVar);
    }
}
