package protobuf.UpdateClientInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.ConfigVersion;
import protobuf.GroupInfo;
import protobuf.MaskInfo;
import protobuf.UserInfo;
/* loaded from: classes21.dex */
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

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupInfo == null) {
                this.groupInfo = DEFAULT_GROUPINFO;
            } else {
                this.groupInfo = immutableCopyOf(builder.groupInfo);
            }
            this.userInfo = builder.userInfo;
            this.maskInfo = builder.maskInfo;
            if (builder.heartbeatInterval == null) {
                this.heartbeatInterval = DEFAULT_HEARTBEATINTERVAL;
            } else {
                this.heartbeatInterval = immutableCopyOf(builder.heartbeatInterval);
            }
            this.configVersion = builder.configVersion;
            if (builder.isUserAvailable == null) {
                this.isUserAvailable = DEFAULT_ISUSERAVAILABLE;
                return;
            } else {
                this.isUserAvailable = builder.isUserAvailable;
                return;
            }
        }
        this.groupInfo = immutableCopyOf(builder.groupInfo);
        this.userInfo = builder.userInfo;
        this.maskInfo = builder.maskInfo;
        this.heartbeatInterval = immutableCopyOf(builder.heartbeatInterval);
        this.configVersion = builder.configVersion;
        this.isUserAvailable = builder.isUserAvailable;
    }

    /* loaded from: classes21.dex */
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
            if (dataRes != null) {
                this.groupInfo = DataRes.copyOf(dataRes.groupInfo);
                this.userInfo = dataRes.userInfo;
                this.maskInfo = dataRes.maskInfo;
                this.heartbeatInterval = DataRes.copyOf(dataRes.heartbeatInterval);
                this.configVersion = dataRes.configVersion;
                this.isUserAvailable = dataRes.isUserAvailable;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
