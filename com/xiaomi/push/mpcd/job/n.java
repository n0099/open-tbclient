package com.xiaomi.push.mpcd.job;

import android.net.wifi.ScanResult;
import java.util.Comparator;
/* loaded from: classes3.dex */
class n implements Comparator<ScanResult> {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
