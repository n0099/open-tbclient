package protobuf.GetMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_LIST = "";
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer isMask;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String list;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<UserInfo> users;
    public static final Integer DEFAULT_ISMASK = 0;
    public static final List<UserInfo> DEFAULT_USERS = Collections.emptyList();

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.isMask == null) {
                this.isMask = DEFAULT_ISMASK;
            } else {
                this.isMask = builder.isMask;
            }
            if (builder.list == null) {
                this.list = "";
            } else {
                this.list = builder.list;
            }
            if (builder.users == null) {
                this.users = DEFAULT_USERS;
                return;
            } else {
                this.users = immutableCopyOf(builder.users);
                return;
            }
        }
        this.isMask = builder.isMask;
        this.list = builder.list;
        this.users = immutableCopyOf(builder.users);
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer isMask;
        public String list;
        public List<UserInfo> users;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.isMask = dataRes.isMask;
                this.list = dataRes.list;
                this.users = DataRes.copyOf(dataRes.users);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
