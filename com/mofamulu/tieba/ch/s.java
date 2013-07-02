package com.mofamulu.tieba.ch;

import android.widget.TextView;
import java.util.List;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ r a;
    private final /* synthetic */ TextView b;
    private final /* synthetic */ List c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, TextView textView, List list, int i, int i2) {
        this.a = rVar;
        this.b = textView;
        this.c = list;
        this.d = i;
        this.e = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.setText(String.valueOf(this.c.size()));
        if (this.d == 0) {
            this.b.setVisibility(8);
        } else if (this.d == this.e) {
            this.b.setTextColor(-16711936);
            this.b.setVisibility(0);
        } else {
            this.b.setTextColor(-65536);
            this.b.setVisibility(0);
        }
    }
}
