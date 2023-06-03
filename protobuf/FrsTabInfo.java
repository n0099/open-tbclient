package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class FrsTabInfo extends Message {
    public static final String DEFAULT_TABCODE = "";
    public static final String DEFAULT_TABGID = "";
    public static final String DEFAULT_TABNAME = "";
    public static final String DEFAULT_TABTITLE = "";
    public static final String DEFAULT_TABURL = "";
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer isDefault;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer isGeneralTab;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer needPage;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String tabCode;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String tabGid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer tabId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String tabName;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String tabTitle;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer tabType;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String tabUrl;
    @ProtoField(tag = 9, type = Message.Datatype.UINT32)
    public final Integer tabVersion;
    public static final Integer DEFAULT_TABID = 0;
    public static final Integer DEFAULT_TABTYPE = 0;
    public static final Integer DEFAULT_ISGENERALTAB = 0;
    public static final Integer DEFAULT_TABVERSION = 0;
    public static final Integer DEFAULT_ISDEFAULT = 0;
    public static final Integer DEFAULT_NEEDPAGE = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<FrsTabInfo> {
        public Integer isDefault;
        public Integer isGeneralTab;
        public Integer needPage;
        public String tabCode;
        public String tabGid;
        public Integer tabId;
        public String tabName;
        public String tabTitle;
        public Integer tabType;
        public String tabUrl;
        public Integer tabVersion;

        public Builder() {
        }

        public Builder(FrsTabInfo frsTabInfo) {
            super(frsTabInfo);
            if (frsTabInfo == null) {
                return;
            }
            this.tabId = frsTabInfo.tabId;
            this.tabType = frsTabInfo.tabType;
            this.tabName = frsTabInfo.tabName;
            this.tabUrl = frsTabInfo.tabUrl;
            this.tabGid = frsTabInfo.tabGid;
            this.tabTitle = frsTabInfo.tabTitle;
            this.isGeneralTab = frsTabInfo.isGeneralTab;
            this.tabCode = frsTabInfo.tabCode;
            this.tabVersion = frsTabInfo.tabVersion;
            this.isDefault = frsTabInfo.isDefault;
            this.needPage = frsTabInfo.needPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public FrsTabInfo build(boolean z) {
            return new FrsTabInfo(this, z);
        }
    }

    public FrsTabInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.tabId;
            if (num == null) {
                this.tabId = DEFAULT_TABID;
            } else {
                this.tabId = num;
            }
            Integer num2 = builder.tabType;
            if (num2 == null) {
                this.tabType = DEFAULT_TABTYPE;
            } else {
                this.tabType = num2;
            }
            String str = builder.tabName;
            if (str == null) {
                this.tabName = "";
            } else {
                this.tabName = str;
            }
            String str2 = builder.tabUrl;
            if (str2 == null) {
                this.tabUrl = "";
            } else {
                this.tabUrl = str2;
            }
            String str3 = builder.tabGid;
            if (str3 == null) {
                this.tabGid = "";
            } else {
                this.tabGid = str3;
            }
            String str4 = builder.tabTitle;
            if (str4 == null) {
                this.tabTitle = "";
            } else {
                this.tabTitle = str4;
            }
            Integer num3 = builder.isGeneralTab;
            if (num3 == null) {
                this.isGeneralTab = DEFAULT_ISGENERALTAB;
            } else {
                this.isGeneralTab = num3;
            }
            String str5 = builder.tabCode;
            if (str5 == null) {
                this.tabCode = "";
            } else {
                this.tabCode = str5;
            }
            Integer num4 = builder.tabVersion;
            if (num4 == null) {
                this.tabVersion = DEFAULT_TABVERSION;
            } else {
                this.tabVersion = num4;
            }
            Integer num5 = builder.isDefault;
            if (num5 == null) {
                this.isDefault = DEFAULT_ISDEFAULT;
            } else {
                this.isDefault = num5;
            }
            Integer num6 = builder.needPage;
            if (num6 == null) {
                this.needPage = DEFAULT_NEEDPAGE;
                return;
            } else {
                this.needPage = num6;
                return;
            }
        }
        this.tabId = builder.tabId;
        this.tabType = builder.tabType;
        this.tabName = builder.tabName;
        this.tabUrl = builder.tabUrl;
        this.tabGid = builder.tabGid;
        this.tabTitle = builder.tabTitle;
        this.isGeneralTab = builder.isGeneralTab;
        this.tabCode = builder.tabCode;
        this.tabVersion = builder.tabVersion;
        this.isDefault = builder.isDefault;
        this.needPage = builder.needPage;
    }
}
