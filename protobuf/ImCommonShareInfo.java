package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class ImCommonShareInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_SCHEMA = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String icon;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String schema;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<ImCommonShareInfo> {
        public String content;
        public String icon;
        public String id;
        public String schema;
        public String title;
        public Integer type;

        public Builder() {
        }

        public Builder(ImCommonShareInfo imCommonShareInfo) {
            super(imCommonShareInfo);
            if (imCommonShareInfo == null) {
                return;
            }
            this.type = imCommonShareInfo.type;
            this.icon = imCommonShareInfo.icon;
            this.title = imCommonShareInfo.title;
            this.content = imCommonShareInfo.content;
            this.schema = imCommonShareInfo.schema;
            this.id = imCommonShareInfo.id;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ImCommonShareInfo build(boolean z) {
            return new ImCommonShareInfo(this, z);
        }
    }

    public ImCommonShareInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            String str = builder.icon;
            if (str == null) {
                this.icon = "";
            } else {
                this.icon = str;
            }
            String str2 = builder.title;
            if (str2 == null) {
                this.title = "";
            } else {
                this.title = str2;
            }
            String str3 = builder.content;
            if (str3 == null) {
                this.content = "";
            } else {
                this.content = str3;
            }
            String str4 = builder.schema;
            if (str4 == null) {
                this.schema = "";
            } else {
                this.schema = str4;
            }
            String str5 = builder.id;
            if (str5 == null) {
                this.id = "";
                return;
            } else {
                this.id = str5;
                return;
            }
        }
        this.type = builder.type;
        this.icon = builder.icon;
        this.title = builder.title;
        this.content = builder.content;
        this.schema = builder.schema;
        this.id = builder.id;
    }
}
