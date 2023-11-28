package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends f {
    public static int IO = 1;
    public static volatile a aFJ;

    @Override // com.kwad.sdk.core.report.f
    public final String Du() {
        return "ksad_block_actions";
    }

    @Override // com.kwad.sdk.core.report.f
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }

    public a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.a.a(context, IO));
    }

    public static a bw(Context context) {
        if (aFJ == null) {
            synchronized (a.class) {
                if (aFJ == null) {
                    aFJ = new a(context);
                }
            }
        }
        return aFJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.f
    /* renamed from: j */
    public synchronized BlockReportAction g(@NonNull Cursor cursor) {
        try {
        } catch (JSONException e) {
            c.printStackTrace(e);
            return new BlockReportAction("");
        }
        return new BlockReportAction(new JSONObject(cursor.getString(0)));
    }

    @Override // com.kwad.sdk.core.report.f
    public final String Dv() {
        return "select aLog from " + Du();
    }
}
