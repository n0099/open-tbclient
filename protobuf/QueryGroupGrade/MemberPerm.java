package protobuf.QueryGroupGrade;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class MemberPerm extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer alreadyCreateNum;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer canCreateMember;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isAuthor;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer leftCreateNum;
    public static final Integer DEFAULT_ISAUTHOR = 0;
    public static final Integer DEFAULT_CANCREATEMEMBER = 0;
    public static final Integer DEFAULT_ALREADYCREATENUM = 0;
    public static final Integer DEFAULT_LEFTCREATENUM = 0;

    private MemberPerm(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.isAuthor == null) {
                this.isAuthor = DEFAULT_ISAUTHOR;
            } else {
                this.isAuthor = builder.isAuthor;
            }
            if (builder.canCreateMember == null) {
                this.canCreateMember = DEFAULT_CANCREATEMEMBER;
            } else {
                this.canCreateMember = builder.canCreateMember;
            }
            if (builder.alreadyCreateNum == null) {
                this.alreadyCreateNum = DEFAULT_ALREADYCREATENUM;
            } else {
                this.alreadyCreateNum = builder.alreadyCreateNum;
            }
            if (builder.leftCreateNum == null) {
                this.leftCreateNum = DEFAULT_LEFTCREATENUM;
                return;
            } else {
                this.leftCreateNum = builder.leftCreateNum;
                return;
            }
        }
        this.isAuthor = builder.isAuthor;
        this.canCreateMember = builder.canCreateMember;
        this.alreadyCreateNum = builder.alreadyCreateNum;
        this.leftCreateNum = builder.leftCreateNum;
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<MemberPerm> {
        public Integer alreadyCreateNum;
        public Integer canCreateMember;
        public Integer isAuthor;
        public Integer leftCreateNum;

        public Builder() {
        }

        public Builder(MemberPerm memberPerm) {
            super(memberPerm);
            if (memberPerm != null) {
                this.isAuthor = memberPerm.isAuthor;
                this.canCreateMember = memberPerm.canCreateMember;
                this.alreadyCreateNum = memberPerm.alreadyCreateNum;
                this.leftCreateNum = memberPerm.leftCreateNum;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MemberPerm build(boolean z) {
            return new MemberPerm(this, z);
        }
    }
}
