package com.kwad.sdk.core.video.kwai.kwai;

import android.content.Context;
import com.kwad.sdk.core.report.g;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.report.b<c, b> {
    public static a a = new a();
    public static volatile boolean b = false;

    public static void a(final String str, final String str2) {
        a.a(new g<c>() { // from class: com.kwad.sdk.core.video.kwai.kwai.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.g
            /* renamed from: b */
            public c a() {
                return new c(str, str2);
            }
        });
    }

    public static a c() {
        return a;
    }

    @Override // com.kwad.sdk.core.report.b
    public void a(Context context) {
        if (b) {
            return;
        }
        super.a(context);
        b = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b */
    public b a(List list, boolean z) {
        return new b(list);
    }
}
