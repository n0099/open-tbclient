package com.kwai.sodler.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e implements com.kwai.sodler.lib.a.g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11310a;

    /* renamed from: b  reason: collision with root package name */
    private g.a f11311b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this.f11310a = context.getApplicationContext();
    }

    @TargetApi(11)
    private void a(int i, @NonNull com.kwai.sodler.lib.a.f fVar) {
        if (i != 0) {
            if (i == -1) {
                a.a("Sodler.update", "Request remote plugin info fail, illegal online plugin.");
                fVar.a(-3);
                fVar.a((PluginError.UpdateError) null);
                return;
            }
            return;
        }
        a.a("Sodler.update", "Using online plugin.");
        com.kwai.sodler.lib.b.b a2 = f.a(this.f11310a, fVar);
        if (a2 == null) {
            a.a("Sodler.update", "No available plugin, abort.");
            fVar.a(-3);
            return;
        }
        a.a("Sodler.update", "Download new plugin, version = " + a2.f11304b + ", url = " + a2.c);
        fVar.a(3);
        fVar.g(a2.c);
        fVar.a(a2.d);
        fVar.f(a2.f);
        fVar.b(a2.f11304b);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, PluginError.UpdateError updateError) {
        a.c("Sodler.update", "onError state = " + fVar.c());
        fVar.a(-4);
        fVar.a((Throwable) updateError);
        fVar.b(updateError);
        e(fVar);
    }

    private void a(com.kwai.sodler.lib.a.f fVar, File file) {
        if (this.f11311b == null) {
            throw new RuntimeException("not yet supported!");
        }
        this.f11311b.a(fVar, file);
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
        } else if (fVar.c() == 2) {
            try {
                fVar.b().e().a();
                try {
                    File d = fVar.b().e().d(fVar.i());
                    int i = 0;
                    fVar.b(fVar.b().b().a());
                    while (true) {
                        if (fVar.f()) {
                            d(fVar);
                            break;
                        }
                        try {
                            com.kwai.sodler.lib.c.a.a(this.f11310a, fVar.o(), d);
                            a.a("Sodler.update", "Extract plugin from assets success.");
                            fVar.d(d.getAbsolutePath());
                            fVar.a(1);
                            e(fVar);
                            break;
                        } catch (Throwable th) {
                            a.a("Sodler.update", th);
                            try {
                                fVar.h();
                                int i2 = i + 1;
                                a.a("Sodler.update", "Extract fail, retry " + i);
                                fVar.c("Retry extract " + i2);
                                i = i2;
                            } catch (PluginError.RetryError e) {
                                a.a("Sodler.update", "Extract plugin from assets fail, error = " + th.toString());
                                a(fVar, new PluginError.UpdateError(th, 2004));
                            }
                        }
                    }
                } catch (Throwable th2) {
                    a.a("Sodler.update", "Can not get temp file, error = " + th2.getLocalizedMessage());
                    a.a("Sodler.update", th2);
                    a(fVar, new PluginError.UpdateError(th2, 2003));
                }
            } catch (Throwable th3) {
                a.a("Sodler.update", th3);
                a(fVar, new PluginError.UpdateError(th3, 2005));
            }
        } else if (fVar.c() == 3) {
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
                    } catch (PluginError.CancelError e2) {
                        d(fVar);
                    } catch (PluginError.UpdateError e3) {
                        a.a("Sodler.update", "Download plugin fail, error = " + e3.getLocalizedMessage());
                        a.a("Sodler.update", e3);
                        fVar.a((Throwable) e3);
                        a(fVar, e3);
                    }
                } catch (Throwable th4) {
                    a.a("Sodler.update", "Can not get temp file, error = " + th4.getLocalizedMessage());
                    a.a("Sodler.update", th4);
                    a(fVar, new PluginError.UpdateError(th4, 2003));
                }
            } catch (Throwable th5) {
                a.a("Sodler.update", th5);
                a(fVar, new PluginError.UpdateError(th5, 2005));
            }
        } else {
            e(fVar);
        }
        return fVar;
    }

    @Override // com.kwai.sodler.lib.a.g
    public com.kwai.sodler.lib.a.g a(g.a aVar) {
        this.f11311b = aVar;
        return this;
    }

    com.kwai.sodler.lib.a.f b(com.kwai.sodler.lib.a.f fVar) {
        a.b("Sodler.update", "Request remote plugin info.");
        if (fVar.j()) {
            fVar.b().e().c(fVar.i());
        }
        try {
            if (!fVar.n() && fVar.s() == null) {
                fVar.b().f().a(fVar);
            }
            if (TextUtils.isEmpty(fVar.i())) {
                a(-1, fVar);
            } else {
                a(0, fVar);
            }
        } catch (Exception e) {
            a.e("Sodler.update", "Request remote plugin info fail, error = " + e.toString());
            a.a("Sodler.update", e);
            fVar.a(-2);
            PluginError.UpdateError updateError = new PluginError.UpdateError(e, 2006);
            fVar.a((Throwable) updateError);
            fVar.a(updateError);
        }
        return fVar;
    }
}
