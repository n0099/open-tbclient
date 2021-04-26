package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.kwai.filedownloader.services.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class n implements e.a, t {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f35189a = KsAdSDKImpl.getProxyRealClass(FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Runnable> f35190b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.filedownloader.services.e f35191c;

    @Override // com.kwai.filedownloader.services.e.a
    public void a() {
        this.f35191c = null;
        f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, f35189a));
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, Runnable runnable) {
        if (runnable != null && !this.f35190b.contains(runnable)) {
            this.f35190b.add(runnable);
        }
        context.startService(new Intent(context, f35189a));
    }

    @Override // com.kwai.filedownloader.services.e.a
    public void a(com.kwai.filedownloader.services.e eVar) {
        this.f35191c = eVar;
        this.f35190b.clear();
        for (Runnable runnable : (List) this.f35190b.clone()) {
            runnable.run();
        }
        f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, f35189a));
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(int i2) {
        return !c() ? com.kwai.filedownloader.f.a.a(i2) : this.f35191c.a(i2);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        if (c()) {
            this.f35191c.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
            return true;
        }
        return com.kwai.filedownloader.f.a.a(str, str2, z);
    }

    @Override // com.kwai.filedownloader.t
    public byte b(int i2) {
        return !c() ? com.kwai.filedownloader.f.a.b(i2) : this.f35191c.e(i2);
    }

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        return this.f35191c != null;
    }

    @Override // com.kwai.filedownloader.t
    public boolean c(int i2) {
        return !c() ? com.kwai.filedownloader.f.a.c(i2) : this.f35191c.f(i2);
    }
}
