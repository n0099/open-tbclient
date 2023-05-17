package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class TwZhiBoUser extends Message {
    public static final String DEFAULT_FIELDEX = "";
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer anchorLevel;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String fieldEx;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer inBlackList;
    public static final Integer DEFAULT_ANCHORLEVEL = 0;
    public static final Integer DEFAULT_INBLACKLIST = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<TwZhiBoUser> {
        public Integer anchorLevel;
        public String fieldEx;
        public Integer inBlackList;

        public Builder() {
        }

        public Builder(TwZhiBoUser twZhiBoUser) {
            super(twZhiBoUser);
            if (twZhiBoUser == null) {
                return;
            }
            this.anchorLevel = twZhiBoUser.anchorLevel;
            this.inBlackList = twZhiBoUser.inBlackList;
            this.fieldEx = twZhiBoUser.fieldEx;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public TwZhiBoUser build(boolean z) {
            return new TwZhiBoUser(this, z);
        }
    }

    public TwZhiBoUser(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.anchorLevel;
            if (num == null) {
                this.anchorLevel = DEFAULT_ANCHORLEVEL;
            } else {
                this.anchorLevel = num;
            }
            Integer num2 = builder.inBlackList;
            if (num2 == null) {
                this.inBlackList = DEFAULT_INBLACKLIST;
            } else {
                this.inBlackList = num2;
            }
            String str = builder.fieldEx;
            if (str == null) {
                this.fieldEx = "";
                return;
            } else {
                this.fieldEx = str;
                return;
            }
        }
        this.anchorLevel = builder.anchorLevel;
        this.inBlackList = builder.inBlackList;
        this.fieldEx = builder.fieldEx;
    }
}
