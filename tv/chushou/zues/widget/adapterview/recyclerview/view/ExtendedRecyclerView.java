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
    protected View hUT;
    protected b qnH;

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
            this.qnH = (b) adapter;
            super.setAdapter(this.qnH);
        } else if (this.qnH == null) {
            this.qnH = new b(adapter);
            super.setAdapter(this.qnH);
        } else {
            this.qnH.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.qnH;
    }

    public boolean Sh(int i) {
        return this.qnH != null && this.qnH.Se(i);
    }

    public int getHeaderViewCount() {
        if (this.qnH == null) {
            return 0;
        }
        return this.qnH.getHeaderViewsCount();
    }

    public boolean ek(View view) {
        return this.qnH != null && this.qnH.ej(view);
    }

    public boolean vc(int i) {
        return this.qnH != null && this.qnH.Sf(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.qnH == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.qnH.addFooterView(view, i);
    }

    public void ei(View view) {
        if (view != null && this.qnH != null) {
            this.qnH.ei(view);
        }
    }

    public int getFooterViewCount() {
        if (this.qnH == null) {
            return 0;
        }
        return this.qnH.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.hUT = view;
        if (this.qnH == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.qnH.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void Bt(boolean z) {
                if (ExtendedRecyclerView.this.hUT != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.hUT.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.hUT.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.hUT;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.qnH == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.qnH.setLoadMoreProvider(cVar);
    }
}
