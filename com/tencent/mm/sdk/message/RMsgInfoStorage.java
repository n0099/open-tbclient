package com.tencent.mm.sdk.message;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage;
/* loaded from: classes.dex */
public class RMsgInfoStorage extends MStorage {
    public static final String AUTHORITY = "com.tencent.mm.sdk.msginfo.provider";
    public static final String PRIMARY_KEY = "msgId";
    ISQLiteDatabase P;

    private RMsgInfoStorage(ISQLiteDatabase iSQLiteDatabase) {
        this.P = null;
        this.P = iSQLiteDatabase;
    }

    public static RMsgInfoStorage create(Context context) {
        return new RMsgInfoStorage(new RMsgInfoDB(context));
    }

    public int doDelete(long j) {
        int delete = this.P.delete("message", "msgId=?", new String[]{String.valueOf(j)});
        if (delete > 0) {
            notify();
        }
        return delete;
    }

    public long doInsert(RMsgInfo rMsgInfo) {
        if (rMsgInfo == null || Util.isNullOrNil(rMsgInfo.field_talker)) {
            return -1L;
        }
        long insert = this.P.insert("message", "msgId", rMsgInfo.convertTo());
        if (insert > 0) {
            notify();
            return insert;
        }
        return insert;
    }

    public int doUpdate(long j, RMsgInfo rMsgInfo) {
        if (rMsgInfo == null || Util.isNullOrNil(rMsgInfo.field_talker)) {
            return -1;
        }
        int update = this.P.update("message", rMsgInfo.convertTo(), "msgId=?", new String[]{String.valueOf(j)});
        if (update > 0) {
            notify();
            return update;
        }
        return update;
    }

    public RMsgInfo getMsgById(long j) {
        Cursor query = this.P.query("message", null, "msgId=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() == 0) {
            query.close();
            return null;
        }
        RMsgInfo rMsgInfo = new RMsgInfo();
        rMsgInfo.convertFrom(query);
        return rMsgInfo;
    }

    public Cursor getMsgByTalker(String str) {
        return this.P.query("message", null, "talker=?", new String[]{str}, null, null, null);
    }
}
