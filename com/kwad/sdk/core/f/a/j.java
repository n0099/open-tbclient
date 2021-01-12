package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.f;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public Context f9145a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f9146b = new LinkedBlockingQueue<>(1);
    private ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.j.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.b("ZTEDeviceIDHelper", "onServiceConnected");
                j.this.f9146b.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public j(Context context) {
        this.f9145a = context;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0046 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public String a() {
        String str;
        Throwable th;
        String str2;
        String str3;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.f9145a.getPackageName());
            ?? bindService = this.f9145a.bindService(intent, this.c, 1);
            com.kwad.sdk.core.d.a.b("ZTEDeviceIDHelper", "getOAID isBind=" + ((boolean) bindService));
            try {
                if (bindService != 0) {
                    try {
                        String a2 = new f.a(this.f9146b.take()).a();
                        try {
                            try {
                                com.kwad.sdk.core.d.a.b("ZTEDeviceIDHelper", "getOAID oaid:" + a2);
                                this.f9145a.unbindService(this.c);
                                bindService = a2;
                            } catch (Exception e) {
                                e = e;
                                str3 = a2;
                                com.kwad.sdk.core.d.a.a(e);
                                this.f9145a.unbindService(this.c);
                                bindService = str3;
                                return bindService;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = str3;
                            try {
                                this.f9145a.unbindService(this.c);
                                throw th;
                            } catch (Exception e2) {
                                e = e2;
                                str = str2;
                                com.kwad.sdk.core.d.a.b("ZTEDeviceIDHelper", "getOAID hw service not found");
                                com.kwad.sdk.core.d.a.a(e);
                                return str;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str3 = "";
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = "";
                        this.f9145a.unbindService(this.c);
                        throw th;
                    }
                    return bindService;
                }
                return "";
            } catch (Exception e4) {
                e = e4;
                str = bindService;
            }
        } catch (Exception e5) {
            e = e5;
            str = "";
        }
    }
}
