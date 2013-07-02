package com.mofamulu.tieba.tail;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ f a;
    private final /* synthetic */ ViewGroup b;
    private final /* synthetic */ ViewGroup c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.a = fVar;
        this.b = viewGroup;
        this.c = viewGroup2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.getVisibility() == 8) {
            this.c.setBackgroundResource(R.drawable.more_up);
            this.b.setVisibility(0);
            return;
        }
        this.c.setBackgroundResource(R.drawable.more_all);
        this.b.setVisibility(8);
    }
}
