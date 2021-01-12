package com.tencent.mm.sdk.c;

import android.net.Uri;
import android.provider.BaseColumns;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1262a {
        public static Object a(int i, String str) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        }
    }

    /* loaded from: classes14.dex */
    public static final class b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
