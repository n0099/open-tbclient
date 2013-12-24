package defpackage;

import android.view.KeyEvent;
import android.view.View;
/* renamed from: aw  reason: default package */
/* loaded from: classes.dex */
class aw implements View.OnKeyListener {
    final /* synthetic */ av a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.a = avVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i == 4 && this.a.isShowing()) {
            this.a.dismiss();
            return true;
        }
        return false;
    }
}
