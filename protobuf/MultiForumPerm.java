package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class MultiForumPerm extends Message {
    public static final String DEFAULT_BAWUTYPE = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String bawuType;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isBawu;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer isBlockBawuDelete;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer isDeleted;
    public static final Integer DEFAULT_ISBAWU = 0;
    public static final Integer DEFAULT_ISDELETED = 0;
    public static final Integer DEFAULT_ISBLOCKBAWUDELETE = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<MultiForumPerm> {
        public String bawuType;
        public Integer isBawu;
        public Integer isBlockBawuDelete;
        public Integer isDeleted;

        public Builder() {
        }

        public Builder(MultiForumPerm multiForumPerm) {
            super(multiForumPerm);
            if (multiForumPerm == null) {
                return;
            }
            this.isBawu = multiForumPerm.isBawu;
            this.bawuType = multiForumPerm.bawuType;
            this.isDeleted = multiForumPerm.isDeleted;
            this.isBlockBawuDelete = multiForumPerm.isBlockBawuDelete;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MultiForumPerm build(boolean z) {
            return new MultiForumPerm(this, z);
        }
    }

    public MultiForumPerm(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isBawu;
            if (num == null) {
                this.isBawu = DEFAULT_ISBAWU;
            } else {
                this.isBawu = num;
            }
            String str = builder.bawuType;
            if (str == null) {
                this.bawuType = "";
            } else {
                this.bawuType = str;
            }
            Integer num2 = builder.isDeleted;
            if (num2 == null) {
                this.isDeleted = DEFAULT_ISDELETED;
            } else {
                this.isDeleted = num2;
            }
            Integer num3 = builder.isBlockBawuDelete;
            if (num3 == null) {
                this.isBlockBawuDelete = DEFAULT_ISBLOCKBAWUDELETE;
                return;
            } else {
                this.isBlockBawuDelete = num3;
                return;
            }
        }
        this.isBawu = builder.isBawu;
        this.bawuType = builder.bawuType;
        this.isDeleted = builder.isDeleted;
        this.isBlockBawuDelete = builder.isBlockBawuDelete;
    }
}
