package protobuf.JoinLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final List<LikeUserInfo> DEFAULT_LIKEUSERLIST = Collections.emptyList();
    @ProtoField(tag = 1)
    public final LiveGroupInfo group;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<LikeUserInfo> likeUserList;
    @ProtoField(tag = 2)
    public final UserPermission user;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.group = builder.group;
            this.user = builder.user;
            if (builder.likeUserList == null) {
                this.likeUserList = DEFAULT_LIKEUSERLIST;
                return;
            } else {
                this.likeUserList = immutableCopyOf(builder.likeUserList);
                return;
            }
        }
        this.group = builder.group;
        this.user = builder.user;
        this.likeUserList = immutableCopyOf(builder.likeUserList);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public LiveGroupInfo group;
        public List<LikeUserInfo> likeUserList;
        public UserPermission user;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.group = dataRes.group;
                this.user = dataRes.user;
                this.likeUserList = DataRes.copyOf(dataRes.likeUserList);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
