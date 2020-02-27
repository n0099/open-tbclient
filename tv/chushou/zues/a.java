package tv.chushou.zues;

import android.view.View;
/* loaded from: classes5.dex */
public abstract class a implements View.OnClickListener {
    private long lastClickTime = 0;

    public abstract void dz(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime > 500) {
            this.lastClickTime = currentTimeMillis;
            dz(view);
        }
    }
}
