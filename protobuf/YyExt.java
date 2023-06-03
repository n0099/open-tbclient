package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class YyExt extends Message {
    public static final String DEFAULT_ICONURL = "";
    public static final Integer DEFAULT_ISYYGAME = 0;
    public static final String DEFAULT_RANKSHOW = "";
    public static final String DEFAULT_SID = "";
    public static final String DEFAULT_SSID = "";
    public static final String DEFAULT_STREAMINFO = "";
    public static final String DEFAULT_TEMPLATEID = "";
    public static final String DEFAULT_YYUID = "";
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String iconUrl;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer isYyGame;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String rankShow;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String sid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String ssid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String streamInfo;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String templateId;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String yyUid;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<YyExt> {
        public String iconUrl;
        public Integer isYyGame;
        public String rankShow;
        public String sid;
        public String ssid;
        public String streamInfo;
        public String templateId;
        public String yyUid;

        public Builder() {
        }

        public Builder(YyExt yyExt) {
            super(yyExt);
            if (yyExt == null) {
                return;
            }
            this.sid = yyExt.sid;
            this.ssid = yyExt.ssid;
            this.templateId = yyExt.templateId;
            this.yyUid = yyExt.yyUid;
            this.isYyGame = yyExt.isYyGame;
            this.streamInfo = yyExt.streamInfo;
            this.rankShow = yyExt.rankShow;
            this.iconUrl = yyExt.iconUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public YyExt build(boolean z) {
            return new YyExt(this, z);
        }
    }

    public YyExt(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.sid;
            if (str == null) {
                this.sid = "";
            } else {
                this.sid = str;
            }
            String str2 = builder.ssid;
            if (str2 == null) {
                this.ssid = "";
            } else {
                this.ssid = str2;
            }
            String str3 = builder.templateId;
            if (str3 == null) {
                this.templateId = "";
            } else {
                this.templateId = str3;
            }
            String str4 = builder.yyUid;
            if (str4 == null) {
                this.yyUid = "";
            } else {
                this.yyUid = str4;
            }
            Integer num = builder.isYyGame;
            if (num == null) {
                this.isYyGame = DEFAULT_ISYYGAME;
            } else {
                this.isYyGame = num;
            }
            String str5 = builder.streamInfo;
            if (str5 == null) {
                this.streamInfo = "";
            } else {
                this.streamInfo = str5;
            }
            String str6 = builder.rankShow;
            if (str6 == null) {
                this.rankShow = "";
            } else {
                this.rankShow = str6;
            }
            String str7 = builder.iconUrl;
            if (str7 == null) {
                this.iconUrl = "";
                return;
            } else {
                this.iconUrl = str7;
                return;
            }
        }
        this.sid = builder.sid;
        this.ssid = builder.ssid;
        this.templateId = builder.templateId;
        this.yyUid = builder.yyUid;
        this.isYyGame = builder.isYyGame;
        this.streamInfo = builder.streamInfo;
        this.rankShow = builder.rankShow;
        this.iconUrl = builder.iconUrl;
    }
}
