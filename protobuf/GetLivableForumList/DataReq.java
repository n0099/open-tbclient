package protobuf.GetLivableForumList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer filterFlag;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer likeForumFlag;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer minLevel;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer pageNo;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer pageSize;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_FILTERFLAG = 0;
    public static final Integer DEFAULT_MINLEVEL = 0;
    public static final Integer DEFAULT_LIKEFORUMFLAG = 0;
    public static final Integer DEFAULT_PAGESIZE = 0;
    public static final Integer DEFAULT_PAGENO = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer filterFlag;
        public Integer likeForumFlag;
        public Integer minLevel;
        public Integer pageNo;
        public Integer pageSize;
        public Long userId;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.userId = dataReq.userId;
            this.filterFlag = dataReq.filterFlag;
            this.minLevel = dataReq.minLevel;
            this.likeForumFlag = dataReq.likeForumFlag;
            this.pageSize = dataReq.pageSize;
            this.pageNo = dataReq.pageNo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            Integer num = builder.filterFlag;
            if (num == null) {
                this.filterFlag = DEFAULT_FILTERFLAG;
            } else {
                this.filterFlag = num;
            }
            Integer num2 = builder.minLevel;
            if (num2 == null) {
                this.minLevel = DEFAULT_MINLEVEL;
            } else {
                this.minLevel = num2;
            }
            Integer num3 = builder.likeForumFlag;
            if (num3 == null) {
                this.likeForumFlag = DEFAULT_LIKEFORUMFLAG;
            } else {
                this.likeForumFlag = num3;
            }
            Integer num4 = builder.pageSize;
            if (num4 == null) {
                this.pageSize = DEFAULT_PAGESIZE;
            } else {
                this.pageSize = num4;
            }
            Integer num5 = builder.pageNo;
            if (num5 == null) {
                this.pageNo = DEFAULT_PAGENO;
                return;
            } else {
                this.pageNo = num5;
                return;
            }
        }
        this.userId = builder.userId;
        this.filterFlag = builder.filterFlag;
        this.minLevel = builder.minLevel;
        this.likeForumFlag = builder.likeForumFlag;
        this.pageSize = builder.pageSize;
        this.pageNo = builder.pageNo;
    }
}
