package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public final class s extends e {
    public static int IO = 1;
    public static String awS = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public s(@Nullable Context context, int i) {
        super(context, "ksadrep.db", i, awS);
    }
}
