package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.kwai.filedownloader.services.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class n implements e.a, t {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f37945a = KsAdSDKImpl.getProxyRealClass(FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Runnable> f37946b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.filedownloader.services.e f37947c;

    @Override // com.kwai.filedownloader.services.e.a
    public void a() {
        this.f37947c = null;
        f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, f37945a));
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, Runnable runnable) {
        if (runnable != null && !this.f37946b.contains(runnable)) {
            this.f37946b.add(runnable);
        }
        context.startService(new Intent(context, f37945a));
    }

    @Override // com.kwai.filedownloader.services.e.a
    public void a(com.kwai.filedownloader.services.e eVar) {
        this.f37947c = eVar;
        this.f37946b.clear();
        for (Runnable runnable : (List) this.f37946b.clone()) {
            runnable.run();
        }
        f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, f37945a));
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(int i2) {
        return !c() ? com.kwai.filedownloader.f.a.a(i2) : this.f37947c.a(i2);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        if (c()) {
            this.f37947c.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
            return true;
        }
        return com.kwai.filedownloader.f.a.a(str, str2, z);
    }

    @Override // com.kwai.filedownloader.t
    public byte b(int i2) {
        return !c() ? com.kwai.filedownloader.f.a.b(i2) : this.f37947c.e(i2);
    }

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        return this.f37947c != null;
    }

    @Override // com.kwai.filedownloader.t
    public boolean c(int i2) {
        return !c() ? com.kwai.filedownloader.f.a.c(i2) : this.f37947c.f(i2);
    }
}
