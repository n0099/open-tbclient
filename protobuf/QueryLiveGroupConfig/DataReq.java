package protobuf.QueryLiveGroupConfig;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer onlyIntro;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userId;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_ONLYINTRO = 0;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.userId == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = builder.userId;
            }
            if (builder.onlyIntro == null) {
                this.onlyIntro = DEFAULT_ONLYINTRO;
                return;
            } else {
                this.onlyIntro = builder.onlyIntro;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.userId = builder.userId;
        this.onlyIntro = builder.onlyIntro;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer groupId;
        public Integer onlyIntro;
        public Integer userId;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.userId = dataReq.userId;
                this.onlyIntro = dataReq.onlyIntro;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
