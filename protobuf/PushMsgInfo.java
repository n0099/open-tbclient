package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class PushMsgInfo extends Message {
    public static final String DEFAULT_ET = "";
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String et;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<MsgInfo> msgInfo;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long pushTime;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final List<MsgInfo> DEFAULT_MSGINFO = Collections.emptyList();
    public static final Integer DEFAULT_GROUPTYPE = 0;
    public static final Long DEFAULT_PUSHTIME = 0L;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<PushMsgInfo> {
        public String et;
        public Long groupId;
        public Integer groupType;
        public List<MsgInfo> msgInfo;
        public Long pushTime;

        public Builder() {
        }

        public Builder(PushMsgInfo pushMsgInfo) {
            super(pushMsgInfo);
            if (pushMsgInfo == null) {
                return;
            }
            this.groupId = pushMsgInfo.groupId;
            this.msgInfo = Message.copyOf(pushMsgInfo.msgInfo);
            this.groupType = pushMsgInfo.groupType;
            this.et = pushMsgInfo.et;
            this.pushTime = pushMsgInfo.pushTime;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushMsgInfo build(boolean z) {
            return new PushMsgInfo(this, z);
        }
    }

    public PushMsgInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            List<MsgInfo> list = builder.msgInfo;
            if (list == null) {
                this.msgInfo = DEFAULT_MSGINFO;
            } else {
                this.msgInfo = Message.immutableCopyOf(list);
            }
            Integer num = builder.groupType;
            if (num == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = num;
            }
            String str = builder.et;
            if (str == null) {
                this.et = "";
            } else {
                this.et = str;
            }
            Long l2 = builder.pushTime;
            if (l2 == null) {
                this.pushTime = DEFAULT_PUSHTIME;
                return;
            } else {
                this.pushTime = l2;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.msgInfo = Message.immutableCopyOf(builder.msgInfo);
        this.groupType = builder.groupType;
        this.et = builder.et;
        this.pushTime = builder.pushTime;
    }
}
