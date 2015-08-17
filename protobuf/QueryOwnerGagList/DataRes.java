package protobuf.QueryOwnerGagList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer gagers;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<UserInfo> userList;
    public static final List<UserInfo> DEFAULT_USERLIST = Collections.emptyList();
    public static final Integer DEFAULT_HASMORE = 0;
    public static final Integer DEFAULT_GAGERS = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.userList == null) {
                this.userList = DEFAULT_USERLIST;
            } else {
                this.userList = immutableCopyOf(builder.userList);
            }
            if (builder.hasMore == null) {
                this.hasMore = DEFAULT_HASMORE;
            } else {
                this.hasMore = builder.hasMore;
            }
            if (builder.gagers == null) {
                this.gagers = DEFAULT_GAGERS;
                return;
            } else {
                this.gagers = builder.gagers;
                return;
            }
        }
        this.userList = immutableCopyOf(builder.userList);
        this.hasMore = builder.hasMore;
        this.gagers = builder.gagers;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer gagers;
        public Integer hasMore;
        public List<UserInfo> userList;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.userList = DataRes.copyOf(dataRes.userList);
                this.hasMore = dataRes.hasMore;
                this.gagers = dataRes.gagers;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
