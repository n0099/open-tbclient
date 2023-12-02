package com.kwad.components.core.page.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class d extends a {
    public View OP;
    public TextView OQ;
    public int OR;
    public Runnable OS = new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.q.a.qu().qx()) {
                bn.runOnUiThreadDelay(this, 500L);
            } else if (d.this.OR > 0) {
                d.this.OQ.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.OR)));
                d.c(d.this);
                com.kwad.components.core.q.a.qu().aF(d.this.OR);
                bn.runOnUiThreadDelay(this, 1000L);
            } else {
                d.this.OQ.setText("已获得权益");
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.OP.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.q.a.qu().aJ(true);
            }
        }
    };

    private void po() {
        TextView textView;
        if (this.OP != null && (textView = this.OQ) != null) {
            textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.OR)));
            this.OP.setVisibility(0);
            bn.runOnUiThreadDelay(this.OS, 1000L);
        }
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.OR = com.kwad.sdk.core.response.b.a.aM(com.kwad.sdk.core.response.b.e.dP(this.Oy.mAdTemplate));
        com.kwad.components.core.q.a.qu().aF(this.OR);
        po();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.OP = findViewById(R.id.obfuscated_res_0x7f09151d);
        this.OQ = (TextView) findViewById(R.id.obfuscated_res_0x7f09151e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bn.c(this.OS);
    }

    public static /* synthetic */ int c(d dVar) {
        int i = dVar.OR;
        dVar.OR = i - 1;
        return i;
    }
}
