package org.acra;

import android.widget.ScrollView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ ScrollView a;
    final /* synthetic */ CrashReportDialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CrashReportDialog crashReportDialog, ScrollView scrollView) {
        this.b = crashReportDialog;
        this.a = scrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.scrollTo(0, 0);
    }
}
