package com.kwad.sdk.core.report;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.c;
import java.util.List;
/* loaded from: classes6.dex */
public class g extends c<ReportAction, f> {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f32585a = false;

    /* renamed from: b  reason: collision with root package name */
    public static g f32586b = new g();

    public static void a(@NonNull a aVar) {
        if (aVar == null) {
            return;
        }
        if (com.kwad.sdk.b.f31819b.booleanValue()) {
            Log.d("BatchReporter", "report actionType:" + aVar.f32540c);
        }
        if (b(aVar.f32540c)) {
            b(aVar);
        } else {
            c(aVar);
        }
    }

    public static void b(final a aVar) {
        if (aVar == null) {
            return;
        }
        f32586b.b(new h<ReportAction>() { // from class: com.kwad.sdk.core.report.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.h
            /* renamed from: b */
            public ReportAction a() {
                return ReportAction.a(a.this);
            }
        });
    }

    public static boolean b(long j) {
        return c.a.al.a(j);
    }

    public static g c() {
        return f32586b;
    }

    public static void c(final a aVar) {
        if (aVar == null) {
            return;
        }
        f32586b.a(new h<ReportAction>() { // from class: com.kwad.sdk.core.report.g.1
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
        if (f32585a) {
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
        f32585a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.c
    /* renamed from: b */
    public f a(List<ReportAction> list) {
        return new f(list);
    }

    @Override // com.kwad.sdk.core.report.c
    public String b() {
        return "barep";
    }
}
