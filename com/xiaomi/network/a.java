package com.xiaomi.network;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a implements HostFilter {
    final /* synthetic */ HostManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HostManager hostManager) {
        this.a = hostManager;
    }

    @Override // com.xiaomi.network.HostFilter
    public boolean a(String str) {
        return true;
    }
}
