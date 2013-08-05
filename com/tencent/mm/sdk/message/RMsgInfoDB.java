package com.tencent.mm.sdk.message;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.sdk.storage.ContentProviderDB;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class RMsgInfoDB extends ContentProviderDB {
    private static final Map O;
    public static final String TABLE = "message";

    static {
        HashMap hashMap = new HashMap();
        O = hashMap;
        hashMap.put("message", Uri.parse("content://com.tencent.mm.sdk.msginfo.provider/message"));
    }

    public RMsgInfoDB(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.sdk.storage.ContentProviderDB
    public Uri getUriFromTable(String str) {
        return (Uri) O.get(str);
    }
}
