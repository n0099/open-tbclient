package com.kwad.sdk.core.download.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.download.kwai.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.x;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static boolean a;

    public static int a(Context context, AdTemplate adTemplate, int i) {
        if (adTemplate == null || context == null) {
            return 0;
        }
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String aJ = com.kwad.sdk.core.response.a.a.aJ(j);
        String u = com.kwad.sdk.core.response.a.a.u(j);
        int a2 = a(context, aJ);
        if (a2 == 1) {
            com.kwad.sdk.core.report.a.a(adTemplate, i);
            a(context, aJ, u, adTemplate, i);
        } else if (a2 == -1) {
            com.kwad.sdk.core.report.a.b(adTemplate, i);
        }
        return a2;
    }

    public static int a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 0);
            parseUri.setAction("android.intent.action.VIEW");
            parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return 0;
            }
            context.startActivity(parseUri);
            return 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            return -1;
        }
    }

    public static void a(final Context context, final String str, final String str2, final AdTemplate adTemplate, final int i) {
        if (a()) {
            return;
        }
        b(true);
        final int d = x.a().d();
        int af = com.kwad.sdk.core.config.b.af();
        final boolean z = af > 0 && com.kwad.sdk.core.config.b.ag();
        int abs = Math.abs(af);
        if (abs > 0) {
            ax.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.b(false);
                    if (!x.a().b()) {
                        com.kwad.sdk.core.report.a.c(AdTemplate.this, i);
                        return;
                    }
                    int d2 = x.a().d();
                    Context context2 = context;
                    if (context2 == null || !z || d2 == 0 || d2 != d) {
                        return;
                    }
                    d.b(context2, str, str2, AdTemplate.this);
                }
            }, null, abs * 1000);
        } else {
            b(false);
        }
    }

    public static void a(g.a aVar, AdTemplate adTemplate) {
        aVar.a().show();
        com.kwad.sdk.core.report.a.c(adTemplate, 158, null);
    }

    public static boolean a() {
        return a;
    }

    public static void b(final Context context, final String str, String str2, final AdTemplate adTemplate) {
        g.a a2 = new g.a(Wrapper.wrapContextIfNeed(context)).a(String.format(Wrapper.wrapContextIfNeed(context).getString(R.string.obfuscated_res_0x7f0f0991), str2)).a(new g.b() { // from class: com.kwad.sdk.core.download.a.d.2
            @Override // com.kwad.sdk.core.download.kwai.g.b
            public void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.f(AdTemplate.this, 159);
                dialogInterface.dismiss();
                ax.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        d.a(context, str);
                    }
                }, null, 100L);
            }

            @Override // com.kwad.sdk.core.download.kwai.g.b
            public void b(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.f(AdTemplate.this, 160);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.sdk.core.download.kwai.g.b
            public void c(DialogInterface dialogInterface) {
            }
        });
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        } else if (!(context instanceof ResContext)) {
            return;
        } else {
            ResContext resContext = (ResContext) context;
            if (!(resContext.getDelegatedContext() instanceof Activity) || ((Activity) resContext.getDelegatedContext()).isFinishing()) {
                return;
            }
        }
        a(a2, adTemplate);
    }

    public static void b(boolean z) {
        a = z;
    }
}
