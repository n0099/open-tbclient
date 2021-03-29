package protobuf.UpdateClientInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.ConfigVersion;
import protobuf.GroupInfo;
import protobuf.MaskInfo;
import protobuf.UserInfo;
/* loaded from: classes7.dex */
public final class DataRes extends Message {
    public static final List<GroupInfo> DEFAULT_GROUPINFO = Collections.emptyList();
    public static final List<Integer> DEFAULT_HEARTBEATINTERVAL = Collections.emptyList();
    public static final Long DEFAULT_ISUSERAVAILABLE = 0L;
    @ProtoField(tag = 5)
    public final ConfigVersion configVersion;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<GroupInfo> groupInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> heartbeatInterval;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long isUserAvailable;
    @ProtoField(tag = 3)
    public final MaskInfo maskInfo;
    @ProtoField(tag = 2)
    public final UserInfo userInfo;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public ConfigVersion configVersion;
        public List<GroupInfo> groupInfo;
        public List<Integer> heartbeatInterval;
        public Long isUserAvailable;
        public MaskInfo maskInfo;
        public UserInfo userInfo;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.groupInfo = Message.copyOf(dataRes.groupInfo);
            this.userInfo = dataRes.userInfo;
            this.maskInfo = dataRes.maskInfo;
            this.heartbeatInterval = Message.copyOf(dataRes.heartbeatInterval);
            this.configVersion = dataRes.configVersion;
            this.isUserAvailable = dataRes.isUserAvailable;
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
            List<GroupInfo> list = builder.groupInfo;
            if (list == null) {
                this.groupInfo = DEFAULT_GROUPINFO;
            } else {
                this.groupInfo = Message.immutableCopyOf(list);
            }
            this.userInfo = builder.userInfo;
            this.maskInfo = builder.maskInfo;
            List<Integer> list2 = builder.heartbeatInterval;
            if (list2 == null) {
                this.heartbeatInterval = DEFAULT_HEARTBEATINTERVAL;
            } else {
                this.heartbeatInterval = Message.immutableCopyOf(list2);
            }
            this.configVersion = builder.configVersion;
            Long l = builder.isUserAvailable;
            if (l == null) {
                this.isUserAvailable = DEFAULT_ISUSERAVAILABLE;
                return;
            } else {
                this.isUserAvailable = l;
                return;
            }
        }
        this.groupInfo = Message.immutableCopyOf(builder.groupInfo);
        this.userInfo = builder.userInfo;
        this.maskInfo = builder.maskInfo;
        this.heartbeatInterval = Message.immutableCopyOf(builder.heartbeatInterval);
        this.configVersion = builder.configVersion;
        this.isUserAvailable = builder.isUserAvailable;
    }
}
