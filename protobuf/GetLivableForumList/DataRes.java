package protobuf.GetLivableForumList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.ForumRalatedInfo;
/* loaded from: classes7.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_TIPS = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer available;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(label = Message.Label.REPEATED, tag = 4)
    public final List<ForumRalatedInfo> likeList;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer minLevel;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String tips;
    public static final Integer DEFAULT_AVAILABLE = 0;
    public static final Integer DEFAULT_MINLEVEL = 0;
    public static final List<ForumRalatedInfo> DEFAULT_LIKELIST = Collections.emptyList();
    public static final Integer DEFAULT_HASMORE = 0;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.available == null) {
                this.available = DEFAULT_AVAILABLE;
            } else {
                this.available = builder.available;
            }
            if (builder.minLevel == null) {
                this.minLevel = DEFAULT_MINLEVEL;
            } else {
                this.minLevel = builder.minLevel;
            }
            if (builder.tips == null) {
                this.tips = "";
            } else {
                this.tips = builder.tips;
            }
            if (builder.likeList == null) {
                this.likeList = DEFAULT_LIKELIST;
            } else {
                this.likeList = immutableCopyOf(builder.likeList);
            }
            if (builder.hasMore == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = builder.hasMore;
                return;
            }
        }
        this.available = builder.available;
        this.minLevel = builder.minLevel;
        this.tips = builder.tips;
        this.likeList = immutableCopyOf(builder.likeList);
        this.hasMore = builder.hasMore;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer available;
        public Integer hasMore;
        public List<ForumRalatedInfo> likeList;
        public Integer minLevel;
        public String tips;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.available = dataRes.available;
                this.minLevel = dataRes.minLevel;
                this.tips = dataRes.tips;
                this.likeList = DataRes.copyOf(dataRes.likeList);
                this.hasMore = dataRes.hasMore;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
