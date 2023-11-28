package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public class t extends f {
    public static volatile t awT;
    public r awU;

    @Override // com.kwad.sdk.core.report.f
    public final String Du() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.f
    public final String getTag() {
        return "ReportActionDBManager";
    }

    public t(Context context) {
        super(new s(context, s.IO));
        this.awU = new l();
    }

    public static t bf(Context context) {
        if (awT == null) {
            synchronized (t.class) {
                if (awT == null) {
                    awT = new t(context);
                }
            }
        }
        return awT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.f
    /* renamed from: h */
    public synchronized q g(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yC()) {
            return this.awU.X(string2, string);
        }
        return this.awU.X(string2, string);
    }

    @Override // com.kwad.sdk.core.report.f
    public final String Dv() {
        return "select aLog, actionId from " + Du();
    }
}
