package com.tencent.mm.sdk.message;

import com.tencent.mm.sdk.storage.MAutoDBItem;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class RMsgInfo extends MAutoDBItem {
    public static final String[] COLUMNS;
    public static final String COL_CONTENT = "content";
    public static final String COL_CREATE_TIME = "createTime";
    public static final String COL_ID = "msgId";
    public static final String COL_ID_SVR = "msgSvrId";
    public static final String COL_IMG_PATH = "imgPath";
    public static final String COL_IS_SEND = "isSend";
    public static final String COL_IS_SHOWTIMER = "isShowTimer";
    public static final String COL_LVBUFFER = "lvbuffer";
    public static final String COL_RESERVED = "reserved";
    public static final String COL_STATUS = "status";
    public static final String COL_TALKER = "talker";
    public static final String COL_TYPE = "type";
    protected static Field[] p;
    public String commentUrl;
    public String field_content;
    public long field_createTime;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvBuffer;
    public long field_msgId;
    public int field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_type;

    static {
        Field[] validFields = MAutoDBItem.getValidFields(RMsgInfo.class);
        p = validFields;
        COLUMNS = MAutoDBItem.getFullColumns(validFields);
    }

    public RMsgInfo() {
        this.field_type = 0;
        this.field_status = 0;
        this.field_talker = "";
        this.field_content = "";
        this.field_imgPath = "";
        this.field_reserved = "";
        this.commentUrl = "";
    }

    public RMsgInfo(long j) {
        this.field_type = 0;
        this.field_status = 0;
        this.field_talker = "";
        this.field_content = "";
        this.field_imgPath = "";
        this.field_reserved = "";
        this.commentUrl = "";
        this.field_msgId = j;
    }

    public RMsgInfo(String str) {
        this.field_type = 0;
        this.field_status = 0;
        this.field_talker = "";
        this.field_content = "";
        this.field_imgPath = "";
        this.field_reserved = "";
        this.commentUrl = "";
        this.field_talker = str;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoDBItem
    public Field[] fields() {
        return p;
    }
}
