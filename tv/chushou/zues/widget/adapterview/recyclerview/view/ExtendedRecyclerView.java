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
    protected View hOW;
    protected b qem;

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
            this.qem = (b) adapter;
            super.setAdapter(this.qem);
        } else if (this.qem == null) {
            this.qem = new b(adapter);
            super.setAdapter(this.qem);
        } else {
            this.qem.setAdapter(adapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView
    public b getAdapter() {
        return this.qem;
    }

    public boolean RM(int i) {
        return this.qem != null && this.qem.RJ(i);
    }

    public int getHeaderViewCount() {
        if (this.qem == null) {
            return 0;
        }
        return this.qem.getHeaderViewsCount();
    }

    public boolean ec(View view) {
        return this.qem != null && this.qem.eb(view);
    }

    public boolean RN(int i) {
        return this.qem != null && this.qem.RK(i);
    }

    public void addFooterView(@NonNull View view, int i) {
        if (this.qem == null) {
            throw new IllegalStateException("should call setAdapter() first");
        }
        this.qem.addFooterView(view, i);
    }

    public void ea(View view) {
        if (view != null && this.qem != null) {
            this.qem.ea(view);
        }
    }

    public int getFooterViewCount() {
        if (this.qem == null) {
            return 0;
        }
        return this.qem.getFooterViewsCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.hOW = view;
        if (this.qem == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.qem.a(new a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.ExtendedRecyclerView.1
            @Override // tv.chushou.zues.widget.adapterview.a
            public void Bi(boolean z) {
                if (ExtendedRecyclerView.this.hOW != null) {
                    if (z) {
                        ExtendedRecyclerView.this.setVisibility(8);
                        ExtendedRecyclerView.this.hOW.setVisibility(0);
                        return;
                    }
                    ExtendedRecyclerView.this.setVisibility(0);
                    ExtendedRecyclerView.this.hOW.setVisibility(8);
                }
            }
        });
    }

    @Nullable
    public View getEmptyView() {
        return this.hOW;
    }

    public void setLoadMoreProvider(c cVar) {
        if (this.qem == null) {
            throw new IllegalArgumentException("should call setAdapter() first");
        }
        this.qem.setLoadMoreProvider(cVar);
    }
}
