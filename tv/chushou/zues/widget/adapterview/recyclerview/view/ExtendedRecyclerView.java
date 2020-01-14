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
/* loaded from: classes4.dex */
public class ExtendedRecyclerView extends RecyclerView {
    protected View fEi;
    protected b nWB;

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
            this.nWB = (b) adapter;
            super.setAdapter(this.nWB);
        } else if (this.nWB == null) {
            this.nWB = new b(adapter);
            super.setAdapter(this.nWB);
        } else {
            this.nWB.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.nWB;
    }

    public boolean Op(int i) {
        return this.nWB != null && this.nWB.Om(i);
    }

    public int getHeaderViewCount() {
        if (this.nWB == null) {
            return 0;
        }
        return this.nWB.getHeaderViewsCount();
    }

    public boolean dE(View view) {
        return this.nWB != null && this.nWB.dD(view);
    }

    public boolean Oq(int i) {
        return this.nWB != null && this.nWB.On(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.nWB == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.nWB.addFooterView(view, i);
    }

    public void dC(View view) {
        if (view != null && this.nWB != null) {
            this.nWB.dC(view);
        }
    }

    public int getFooterViewCount() {
        if (this.nWB == null) {
            return 0;
        }
        return this.nWB.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.fEi = view;
        if (this.nWB == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nWB.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void xd(boolean z) {
                if (ExtendedRecyclerView.this.fEi != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.fEi.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.fEi.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.fEi;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.nWB == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.nWB.setLoadMoreProvider(cVar);
    }
}
