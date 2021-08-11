package com.duxiaoman.dxmpay.statistics.internal;

import android.content.Context;
import java.util.Map;
/* loaded from: classes9.dex */
public interface ISyncHttpImpl {
    public static final int GET = 0;
    public static final int POST = 1;

    boolean send(Context context, int i2, String str, Map<String, String> map);
}
