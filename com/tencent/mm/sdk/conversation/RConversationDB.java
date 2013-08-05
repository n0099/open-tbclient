package com.tencent.mm.sdk.conversation;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.sdk.storage.ContentProviderDB;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class RConversationDB extends ContentProviderDB {
    private static final Map O;

    static {
        HashMap hashMap = new HashMap();
        O = hashMap;
        hashMap.put(RConversationStorage.TABLE, Uri.parse("content://com.tencent.mm.sdk.conversation.provider/rconversation"));
    }

    public RConversationDB(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.sdk.storage.ContentProviderDB
    public Uri getUriFromTable(String str) {
        return (Uri) O.get(str);
    }
}
