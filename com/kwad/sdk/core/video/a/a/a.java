package com.kwad.sdk.core.video.a.a;

import android.content.Context;
import com.kwad.sdk.core.report.h;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.report.c<c, b> {

    /* renamed from: a  reason: collision with root package name */
    public static a f34833a = new a();

    public static void a(final String str, final String str2) {
        f34833a.a(new h<c>() { // from class: com.kwad.sdk.core.video.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.h
            /* renamed from: b */
            public c a() {
                return new c(str, str2);
            }
        });
    }

    public static a c() {
        return f34833a;
    }

    @Override // com.kwad.sdk.core.report.c
    public void a(Context context) {
        super.a(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.c
    /* renamed from: b */
    public b a(List list) {
        return new b(list);
    }

    @Override // com.kwad.sdk.core.report.c
    public String b() {
        return "mplrep";
    }
}
