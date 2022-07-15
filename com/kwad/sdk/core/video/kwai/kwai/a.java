package com.kwad.sdk.core.video.kwai.kwai;

import android.content.Context;
import com.kwad.sdk.core.report.i;
import java.util.List;
/* loaded from: classes5.dex */
public final class a extends com.kwad.sdk.core.report.b<c, b> {
    public static a a = new a();
    public static volatile boolean b = false;

    public static void a(final String str, final String str2) {
        a.a(new i<c>() { // from class: com.kwad.sdk.core.video.kwai.kwai.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.report.i
            /* renamed from: b */
            public c a() {
                return new c(str, str2);
            }
        });
    }

    public static b b(List<c> list) {
        return new b(list);
    }

    public static a d() {
        return a;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.List] */
    /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.g' to match base method */
    @Override // com.kwad.sdk.core.report.b
    public final /* synthetic */ b a(List<c> list) {
        return b(list);
    }

    @Override // com.kwad.sdk.core.report.b
    public final void a(Context context, int i) {
        if (b) {
            return;
        }
        super.a(context, i);
        b = true;
    }
}
