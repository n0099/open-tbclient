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
    protected View hCA;
    protected b pmY;

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
            this.pmY = (b) adapter;
            super.setAdapter(this.pmY);
        } else if (this.pmY == null) {
            this.pmY = new b(adapter);
            super.setAdapter(this.pmY);
        } else {
            this.pmY.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.pmY;
    }

    public boolean PV(int i) {
        return this.pmY != null && this.pmY.PS(i);
    }

    public int getHeaderViewCount() {
        if (this.pmY == null) {
            return 0;
        }
        return this.pmY.getHeaderViewsCount();
    }

    public boolean dU(View view) {
        return this.pmY != null && this.pmY.dT(view);
    }

    public boolean PW(int i) {
        return this.pmY != null && this.pmY.PT(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.pmY == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.pmY.addFooterView(view, i);
    }

    public void dS(View view) {
        if (view != null && this.pmY != null) {
            this.pmY.dS(view);
        }
    }

    public int getFooterViewCount() {
        if (this.pmY == null) {
            return 0;
        }
        return this.pmY.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.hCA = view;
        if (this.pmY == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.pmY.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void Ab(boolean z) {
                if (ExtendedRecyclerView.this.hCA != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.hCA.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.hCA.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.hCA;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.pmY == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.pmY.setLoadMoreProvider(cVar);
    }
}
