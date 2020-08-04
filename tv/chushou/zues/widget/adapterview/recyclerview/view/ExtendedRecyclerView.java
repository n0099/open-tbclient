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
    protected View gTI;
    protected b otS;

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
            this.otS = (b) adapter;
            super.setAdapter(this.otS);
        } else if (this.otS == null) {
            this.otS = new b(adapter);
            super.setAdapter(this.otS);
        } else {
            this.otS.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.otS;
    }

    public boolean Mh(int i) {
        return this.otS != null && this.otS.Me(i);
    }

    public int getHeaderViewCount() {
        if (this.otS == null) {
            return 0;
        }
        return this.otS.getHeaderViewsCount();
    }

    public boolean dF(View view) {
        return this.otS != null && this.otS.dE(view);
    }

    public boolean Mi(int i) {
        return this.otS != null && this.otS.Mf(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.otS == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.otS.addFooterView(view, i);
    }

    public void dD(View view) {
        if (view != null && this.otS != null) {
            this.otS.dD(view);
        }
    }

    public int getFooterViewCount() {
        if (this.otS == null) {
            return 0;
        }
        return this.otS.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.gTI = view;
        if (this.otS == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.otS.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void ys(boolean z) {
                if (ExtendedRecyclerView.this.gTI != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.gTI.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.gTI.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.gTI;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.otS == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.otS.setLoadMoreProvider(cVar);
    }
}
