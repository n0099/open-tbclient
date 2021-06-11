package com.kwai.sodler.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
/* loaded from: classes7.dex */
public class e implements com.kwai.sodler.lib.a.g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f37925a;

    /* renamed from: b  reason: collision with root package name */
    public g.a f37926b;

    public e(Context context) {
        this.f37925a = context.getApplicationContext();
    }

    @TargetApi(11)
    private void a(int i2, @NonNull com.kwai.sodler.lib.a.f fVar) {
        if (i2 != 0) {
            if (i2 == -1) {
                a.a("Sodler.update", "Request remote plugin info fail, illegal online plugin.");
                fVar.a(-3);
                fVar.a((PluginError.UpdateError) null);
                return;
            }
            return;
        }
        a.a("Sodler.update", "Using online plugin.");
        com.kwai.sodler.lib.b.b a2 = f.a(this.f37925a, fVar);
        if (a2 == null) {
            a.a("Sodler.update", "No available plugin, abort.");
            fVar.a(-3);
            return;
        }
        a.a("Sodler.update", "Download new plugin, version = " + a2.f37911b + ", url = " + a2.f37912c);
        fVar.a(3);
        fVar.g(a2.f37912c);
        fVar.a(a2.f37913d);
        fVar.f(a2.f37915f);
        fVar.b(a2.f37911b);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, PluginError.UpdateError updateError) {
        a.c("Sodler.update", "onError state = " + fVar.c());
        fVar.a(-4);
        fVar.a((Throwable) updateError);
        fVar.b(updateError);
        e(fVar);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, File file) {
        g.a aVar = this.f37926b;
        if (aVar == null) {
            throw new RuntimeException("not yet supported!");
        }
        aVar.a(fVar, file);
    }

    private void c(com.kwai.sodler.lib.a.f fVar) {
        a.c("Sodler.update", "onPreUpdate state = " + fVar.c());
        fVar.b().g().c(fVar);
    }

    private void d(com.kwai.sodler.lib.a.f fVar) {
        a.c("Sodler.update", "onCanceled state = " + fVar.c());
        fVar.a(-7);
        fVar.b().g().b(fVar);
    }

    private void e(com.kwai.sodler.lib.a.f fVar) {
        a.c("Sodler.update", "onPostUpdate state = " + fVar.c());
        fVar.b().g().d(fVar);
    }

    @Override // com.kwai.sodler.lib.a.g
    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar) {
        a.c("Sodler.update", "Start update, id = " + fVar.i());
        fVar.c("Update");
        c(fVar);
        b(fVar);
        if (fVar.f()) {
            d(fVar);
            return fVar;
        } else if (fVar.c() != 2) {
            if (fVar.c() != 3) {
                e(fVar);
                return fVar;
            }
            try {
                fVar.b().e().a();
                try {
                    File d2 = fVar.b().e().d(fVar.i());
                    try {
                        a(fVar, d2);
                        a.a("Sodler.update", "Download plugin online success.");
                        fVar.d(d2.getAbsolutePath());
                        fVar.a(1);
                        e(fVar);
                        return fVar;
                    } catch (PluginError.CancelError unused) {
                        d(fVar);
                        return fVar;
                    } catch (PluginError.UpdateError e2) {
                        a.a("Sodler.update", "Download plugin fail, error = " + e2.getLocalizedMessage());
                        a.a("Sodler.update", e2);
                        fVar.a((Throwable) e2);
                        a(fVar, e2);
                        return fVar;
                    }
                } catch (Throwable th) {
                    a.a("Sodler.update", "Can not get temp file, error = " + th.getLocalizedMessage());
                    a.a("Sodler.update", th);
                    a(fVar, new PluginError.UpdateError(th, 2003));
                    return fVar;
                }
            } catch (Throwable th2) {
                a.a("Sodler.update", th2);
                a(fVar, new PluginError.UpdateError(th2, 2005));
                return fVar;
            }
        } else {
            try {
                fVar.b().e().a();
                try {
                    File d3 = fVar.b().e().d(fVar.i());
                    int i2 = 0;
                    fVar.b(fVar.b().b().a());
                    while (!fVar.f()) {
                        try {
                            com.kwai.sodler.lib.c.a.a(this.f37925a, fVar.o(), d3);
                            a.a("Sodler.update", "Extract plugin from assets success.");
                            fVar.d(d3.getAbsolutePath());
                            fVar.a(1);
                            e(fVar);
                            return fVar;
                        } catch (Throwable th3) {
                            a.a("Sodler.update", th3);
                            try {
                                fVar.h();
                                StringBuilder sb = new StringBuilder();
                                sb.append("Extract fail, retry ");
                                int i3 = i2 + 1;
                                sb.append(i2);
                                a.a("Sodler.update", sb.toString());
                                fVar.c("Retry extract " + i3);
                                i2 = i3;
                            } catch (PluginError.RetryError unused2) {
                                a.a("Sodler.update", "Extract plugin from assets fail, error = " + th3.toString());
                                a(fVar, new PluginError.UpdateError(th3, 2004));
                                return fVar;
                            }
                        }
                    }
                    d(fVar);
                    return fVar;
                } catch (Throwable th4) {
                    a.a("Sodler.update", "Can not get temp file, error = " + th4.getLocalizedMessage());
                    a.a("Sodler.update", th4);
                    a(fVar, new PluginError.UpdateError(th4, 2003));
                    return fVar;
                }
            } catch (Throwable th5) {
                a.a("Sodler.update", th5);
                a(fVar, new PluginError.UpdateError(th5, 2005));
                return fVar;
            }
        }
    }

    @Override // com.kwai.sodler.lib.a.g
    public com.kwai.sodler.lib.a.g a(g.a aVar) {
        this.f37926b = aVar;
        return this;
    }

    public com.kwai.sodler.lib.a.f b(com.kwai.sodler.lib.a.f fVar) {
        a.b("Sodler.update", "Request remote plugin info.");
        if (fVar.j()) {
            fVar.b().e().c(fVar.i());
        }
        try {
            if (!fVar.n() && fVar.s() == null) {
                fVar.b().f().a(fVar);
            }
        } catch (Exception e2) {
            a.e("Sodler.update", "Request remote plugin info fail, error = " + e2.toString());
            a.a("Sodler.update", e2);
            fVar.a(-2);
            PluginError.UpdateError updateError = new PluginError.UpdateError(e2, 2006);
            fVar.a((Throwable) updateError);
            fVar.a(updateError);
        }
        if (TextUtils.isEmpty(fVar.i())) {
            a(-1, fVar);
            return fVar;
        }
        a(0, fVar);
        return fVar;
    }
}
