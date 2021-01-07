package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.c;
import java.util.List;
/* loaded from: classes5.dex */
public class g extends c<ReportAction, f> {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f9716a = false;

    /* renamed from: b  reason: collision with root package name */
    private static g f9717b = new g();

    private g() {
    }

    public static void a(@NonNull a aVar) {
        if (aVar == null) {
            return;
        }
        if (b(aVar.c)) {
            c(aVar);
        } else {
            b(aVar);
        }
    }

    public static void b(final a aVar) {
        if (aVar == null) {
            return;
        }
        f9717b.a(new h<ReportAction>() { // from class: com.kwad.sdk.core.report.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.h
            /* renamed from: b */
            public ReportAction a() {
                return ReportAction.a(a.this);
            }
        });
    }

    private static boolean b(long j) {
        return c.a.ae.a(j);
    }

    public static g c() {
        return f9717b;
    }

    public static void c(final a aVar) {
        if (aVar == null) {
            return;
        }
        f9717b.b(new h<ReportAction>() { // from class: com.kwad.sdk.core.report.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.h
            /* renamed from: b */
            public ReportAction a() {
                return ReportAction.a(a.this);
            }
        });
    }

    @Override // com.kwad.sdk.core.report.c
    public void a(Context context) {
        if (f9716a) {
            return;
        }
        super.a(context);
        m.a(context);
        m.a();
        int a2 = com.kwad.sdk.core.config.item.b.a(context);
        com.kwad.sdk.core.d.a.a("BatchReporter", "cache type = " + a2);
        if (a2 == 2) {
            a(l.a(context));
        }
        f9716a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.report.c
    /* renamed from: b */
    public f a(List<ReportAction> list) {
        return new f(list);
    }

    @Override // com.kwad.sdk.core.report.c
    protected String b() {
        return "barep";
    }
}
