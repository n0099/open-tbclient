package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.kwai.filedownloader.services.e;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class n implements e.a, t {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f7231a = KsAdSDKImpl.getProxyRealClass(FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);
    private final ArrayList<Runnable> b = new ArrayList<>();
    private com.kwai.filedownloader.services.e c;

    @Override // com.kwai.filedownloader.services.e.a
    public void a() {
        this.c = null;
        f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, f7231a));
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, Runnable runnable) {
        if (runnable != null && !this.b.contains(runnable)) {
            this.b.add(runnable);
        }
        context.startService(new Intent(context, f7231a));
    }

    @Override // com.kwai.filedownloader.services.e.a
    public void a(com.kwai.filedownloader.services.e eVar) {
        this.c = eVar;
        this.b.clear();
        for (Runnable runnable : (List) this.b.clone()) {
            runnable.run();
        }
        f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, f7231a));
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(int i) {
        return !c() ? com.kwai.filedownloader.f.a.a(i) : this.c.a(i);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        if (c()) {
            this.c.a(str, str2, z, i, i2, i3, z2, bVar, z3);
            return true;
        }
        return com.kwai.filedownloader.f.a.a(str, str2, z);
    }

    @Override // com.kwai.filedownloader.t
    public byte b(int i) {
        return !c() ? com.kwai.filedownloader.f.a.b(i) : this.c.e(i);
    }

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        return this.c != null;
    }

    @Override // com.kwai.filedownloader.t
    public boolean c(int i) {
        return !c() ? com.kwai.filedownloader.f.a.c(i) : this.c.f(i);
    }
}
