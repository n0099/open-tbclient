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
    protected View hnG;
    protected b oXE;

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
            this.oXE = (b) adapter;
            super.setAdapter(this.oXE);
        } else if (this.oXE == null) {
            this.oXE = new b(adapter);
            super.setAdapter(this.oXE);
        } else {
            this.oXE.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.oXE;
    }

    public boolean Pp(int i) {
        return this.oXE != null && this.oXE.Pm(i);
    }

    public int getHeaderViewCount() {
        if (this.oXE == null) {
            return 0;
        }
        return this.oXE.getHeaderViewsCount();
    }

    public boolean dQ(View view) {
        return this.oXE != null && this.oXE.dP(view);
    }

    public boolean Pq(int i) {
        return this.oXE != null && this.oXE.Pn(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.oXE == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.oXE.addFooterView(view, i);
    }

    public void dO(View view) {
        if (view != null && this.oXE != null) {
            this.oXE.dO(view);
        }
    }

    public int getFooterViewCount() {
        if (this.oXE == null) {
            return 0;
        }
        return this.oXE.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.hnG = view;
        if (this.oXE == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.oXE.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void zu(boolean z) {
                if (ExtendedRecyclerView.this.hnG != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.hnG.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.hnG.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.hnG;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.oXE == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.oXE.setLoadMoreProvider(cVar);
    }
}
