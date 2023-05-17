package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class NewGodInfo extends Message {
    public static final String DEFAULT_FIELDNAME = "";
    public static final String DEFAULT_TYPENAME = "";
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer fieldId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String fieldName;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer type;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String typeName;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_FIELDID = 0;
    public static final Integer DEFAULT_TYPE = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<NewGodInfo> {
        public Integer fieldId;
        public String fieldName;
        public Integer status;
        public Integer type;
        public String typeName;

        public Builder() {
        }

        public Builder(NewGodInfo newGodInfo) {
            super(newGodInfo);
            if (newGodInfo == null) {
                return;
            }
            this.status = newGodInfo.status;
            this.fieldId = newGodInfo.fieldId;
            this.fieldName = newGodInfo.fieldName;
            this.type = newGodInfo.type;
            this.typeName = newGodInfo.typeName;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NewGodInfo build(boolean z) {
            return new NewGodInfo(this, z);
        }
    }

    public NewGodInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.status;
            if (num == null) {
                this.status = DEFAULT_STATUS;
            } else {
                this.status = num;
            }
            Integer num2 = builder.fieldId;
            if (num2 == null) {
                this.fieldId = DEFAULT_FIELDID;
            } else {
                this.fieldId = num2;
            }
            String str = builder.fieldName;
            if (str == null) {
                this.fieldName = "";
            } else {
                this.fieldName = str;
            }
            Integer num3 = builder.type;
            if (num3 == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num3;
            }
            String str2 = builder.typeName;
            if (str2 == null) {
                this.typeName = "";
                return;
            } else {
                this.typeName = str2;
                return;
            }
        }
        this.status = builder.status;
        this.fieldId = builder.fieldId;
        this.fieldName = builder.fieldName;
        this.type = builder.type;
        this.typeName = builder.typeName;
    }
}
