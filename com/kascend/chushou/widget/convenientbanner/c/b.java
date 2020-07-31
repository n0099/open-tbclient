package com.kascend.chushou.widget.convenientbanner.c;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes6.dex */
public class b<T> extends RecyclerView.ViewHolder {
    private long lastClickTime;
    private T mData;
    private final View.OnClickListener mOnClickListener;
    private com.kascend.chushou.widget.convenientbanner.d.b<T> nGA;
    private final SparseArray<View> nGB;

    public b(View view, com.kascend.chushou.widget.convenientbanner.d.b<T> bVar) {
        super(view);
        this.nGB = new SparseArray<>();
        this.lastClickTime = 0L;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.widget.convenientbanner.c.b.1
            /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.kascend.chushou.widget.convenientbanner.d.b */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - b.this.lastClickTime > 500) {
                    b.this.lastClickTime = currentTimeMillis;
                    if (b.this.nGA != null && b.this.mData != null) {
                        b.this.nGA.c(view2, b.this.mData);
                    }
                }
            }
        };
        this.nGA = bVar;
        view.setOnClickListener(this.mOnClickListener);
    }

    @CallSuper
    public void bw(T t) {
        this.mData = t;
    }

    @CallSuper
    public void i(T t, int i) {
        this.mData = t;
    }
}
