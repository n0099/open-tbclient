package com.tencent.mm.sdk.conversation;

import android.content.Context;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
/* loaded from: classes.dex */
public class RConversationStorage extends MAutoStorage {
    public static final String AUTHORITY = "com.tencent.mm.sdk.conversation.provider";
    public static final String PRIMARY_KEY = "username";
    public static final String TABLE = "rconversation";

    private RConversationStorage(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase);
    }

    public static RConversationStorage create(Context context) {
        return new RConversationStorage(new RConversationDB(context));
    }

    public RConversation get(String str) {
        RConversation rConversation = new RConversation();
        rConversation.field_username = str;
        if (super.get(rConversation, "username")) {
            return rConversation;
        }
        return null;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage
    public String[] getColumns() {
        return RConversation.COLUMNS;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage
    public String getPrimaryKey() {
        return "username";
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage
    public String getTableName() {
        return TABLE;
    }
}
