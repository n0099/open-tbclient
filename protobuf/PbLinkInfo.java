package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class PbLinkInfo extends Message {
    public static final String DEFAULT_EXTTXT = "";
    public static final String DEFAULT_LINKFROM = "";
    public static final String DEFAULT_PICURL = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_TOURL = "";
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String extTxt;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String linkFrom;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer sort;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String toUrl;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer urlType;
    public static final Integer DEFAULT_SORT = 0;
    public static final Integer DEFAULT_URLTYPE = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<PbLinkInfo> {
        public String extTxt;
        public String linkFrom;
        public String picUrl;
        public Integer sort;
        public String title;
        public String toUrl;
        public Integer urlType;

        public Builder() {
        }

        public Builder(PbLinkInfo pbLinkInfo) {
            super(pbLinkInfo);
            if (pbLinkInfo == null) {
                return;
            }
            this.title = pbLinkInfo.title;
            this.toUrl = pbLinkInfo.toUrl;
            this.picUrl = pbLinkInfo.picUrl;
            this.linkFrom = pbLinkInfo.linkFrom;
            this.extTxt = pbLinkInfo.extTxt;
            this.sort = pbLinkInfo.sort;
            this.urlType = pbLinkInfo.urlType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PbLinkInfo build(boolean z) {
            return new PbLinkInfo(this, z);
        }
    }

    public PbLinkInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.title;
            if (str == null) {
                this.title = "";
            } else {
                this.title = str;
            }
            String str2 = builder.toUrl;
            if (str2 == null) {
                this.toUrl = "";
            } else {
                this.toUrl = str2;
            }
            String str3 = builder.picUrl;
            if (str3 == null) {
                this.picUrl = "";
            } else {
                this.picUrl = str3;
            }
            String str4 = builder.linkFrom;
            if (str4 == null) {
                this.linkFrom = "";
            } else {
                this.linkFrom = str4;
            }
            String str5 = builder.extTxt;
            if (str5 == null) {
                this.extTxt = "";
            } else {
                this.extTxt = str5;
            }
            Integer num = builder.sort;
            if (num == null) {
                this.sort = DEFAULT_SORT;
            } else {
                this.sort = num;
            }
            Integer num2 = builder.urlType;
            if (num2 == null) {
                this.urlType = DEFAULT_URLTYPE;
                return;
            } else {
                this.urlType = num2;
                return;
            }
        }
        this.title = builder.title;
        this.toUrl = builder.toUrl;
        this.picUrl = builder.picUrl;
        this.linkFrom = builder.linkFrom;
        this.extTxt = builder.extTxt;
        this.sort = builder.sort;
        this.urlType = builder.urlType;
    }
}
