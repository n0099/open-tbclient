package protobuf.QueryLiveGroupLikeList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<LikeUserInfo> likeUserList;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer likers;
    public static final List<LikeUserInfo> DEFAULT_LIKEUSERLIST = Collections.emptyList();
    public static final Integer DEFAULT_LIKERS = 0;
    public static final Integer DEFAULT_HASMORE = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.likeUserList == null) {
                this.likeUserList = DEFAULT_LIKEUSERLIST;
            } else {
                this.likeUserList = immutableCopyOf(builder.likeUserList);
            }
            if (builder.likers == null) {
                this.likers = DEFAULT_LIKERS;
            } else {
                this.likers = builder.likers;
            }
            if (builder.hasMore == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = builder.hasMore;
                return;
            }
        }
        this.likeUserList = immutableCopyOf(builder.likeUserList);
        this.likers = builder.likers;
        this.hasMore = builder.hasMore;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer hasMore;
        public List<LikeUserInfo> likeUserList;
        public Integer likers;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.likeUserList = DataRes.copyOf(dataRes.likeUserList);
                this.likers = dataRes.likers;
                this.hasMore = dataRes.hasMore;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
