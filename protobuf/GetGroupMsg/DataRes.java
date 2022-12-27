package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_CONFIG = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer allowEggs;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String config;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<GroupMsg> groupMsg;
    @ProtoField(tag = 3)
    public final UserMsgs userMsg;
    public static final List<GroupMsg> DEFAULT_GROUPMSG = Collections.emptyList();
    public static final Integer DEFAULT_ALLOWEGGS = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer allowEggs;
        public String config;
        public List<GroupMsg> groupMsg;
        public UserMsgs userMsg;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.groupMsg = Message.copyOf(dataRes.groupMsg);
            this.allowEggs = dataRes.allowEggs;
            this.userMsg = dataRes.userMsg;
            this.config = dataRes.config;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            List<GroupMsg> list = builder.groupMsg;
            if (list == null) {
                this.groupMsg = DEFAULT_GROUPMSG;
            } else {
                this.groupMsg = Message.immutableCopyOf(list);
            }
            Integer num = builder.allowEggs;
            if (num == null) {
                this.allowEggs = DEFAULT_ALLOWEGGS;
            } else {
                this.allowEggs = num;
            }
            this.userMsg = builder.userMsg;
            String str = builder.config;
            if (str == null) {
                this.config = "";
                return;
            } else {
                this.config = str;
                return;
            }
        }
        this.groupMsg = Message.immutableCopyOf(builder.groupMsg);
        this.allowEggs = builder.allowEggs;
        this.userMsg = builder.userMsg;
        this.config = builder.config;
    }
}
