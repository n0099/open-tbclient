package org.acra;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ CrashReportDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(CrashReportDialog crashReportDialog) {
        this.a = crashReportDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.a().b(false);
        this.a.finish();
    }
}
