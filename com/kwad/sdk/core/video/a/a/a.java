package com.kwad.sdk.core.video.a.a;

import android.content.Context;
import com.kwad.sdk.core.report.h;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.report.c<c, b> {

    /* renamed from: a  reason: collision with root package name */
    private static a f9741a = new a();

    private a() {
    }

    public static void a(final String str, final String str2) {
        f9741a.a(new h<c>() { // from class: com.kwad.sdk.core.video.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.h
            /* renamed from: b */
            public c a() {
                return new c(str, str2);
            }
        });
    }

    public static a c() {
        return f9741a;
    }

    @Override // com.kwad.sdk.core.report.c
    public void a(Context context) {
        super.a(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.report.c
    /* renamed from: b */
    public b a(List list) {
        return new b(list);
    }

    @Override // com.kwad.sdk.core.report.c
    protected String b() {
        return "mplrep";
    }
}
