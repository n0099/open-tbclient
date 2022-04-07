package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.b;
import java.util.List;
/* loaded from: classes5.dex */
public class f extends b<ReportAction, e> {
    public static volatile boolean a;
    public static f b = new f();

    public static void a(@NonNull ReportAction reportAction) {
        if (reportAction == null) {
            return;
        }
        if (com.kwad.sdk.b.c.booleanValue()) {
            com.kwad.sdk.core.d.a.a("BatchReporter", "report actionType:" + reportAction.i);
        }
        if (b(reportAction.i)) {
            b(reportAction);
        } else {
            c(reportAction);
        }
    }

    public static void b(final ReportAction reportAction) {
        if (reportAction == null) {
            return;
        }
        b.b(new g<ReportAction>() { // from class: com.kwad.sdk.core.report.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.g
            /* renamed from: b */
            public ReportAction a() {
                return ReportAction.this.b();
            }
        });
    }

    public static boolean b(long j) {
        return b.a.aU.a(j);
    }

    public static f c() {
        return b;
    }

    public static void c(final ReportAction reportAction) {
        if (reportAction == null) {
            return;
        }
        b.a(new g<ReportAction>() { // from class: com.kwad.sdk.core.report.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.g
            /* renamed from: b */
            public ReportAction a() {
                return ReportAction.this.b();
            }
        });
    }

    @Override // com.kwad.sdk.core.report.b
    public void a(Context context) {
        if (a) {
            return;
        }
        super.a(context);
        n.a(context);
        n.a();
        int a2 = com.kwad.sdk.core.config.item.c.a(context);
        com.kwad.sdk.core.d.a.a("BatchReporter", "cache type = " + a2);
        if (a2 == 2) {
            a(l.a(context));
        }
        a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b */
    public e a(List<ReportAction> list, boolean z) {
        return z ? new com.kwad.sdk.core.report.a.a(list) : new e(list);
    }
}
