package protobuf.QueryGroupsByLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer geo;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<Business> groups;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    public static final List<Business> DEFAULT_GROUPS = Collections.emptyList();
    public static final Integer DEFAULT_GEO = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_HASMORE = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groups == null) {
                this.groups = DEFAULT_GROUPS;
            } else {
                this.groups = immutableCopyOf(builder.groups);
            }
            if (builder.geo == null) {
                this.geo = DEFAULT_GEO;
            } else {
                this.geo = builder.geo;
            }
            if (builder.offset == null) {
                this.offset = DEFAULT_OFFSET;
            } else {
                this.offset = builder.offset;
            }
            if (builder.hasMore == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = builder.hasMore;
                return;
            }
        }
        this.groups = immutableCopyOf(builder.groups);
        this.geo = builder.geo;
        this.offset = builder.offset;
        this.hasMore = builder.hasMore;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Integer geo;
        public List<Business> groups;
        public Integer hasMore;
        public Integer offset;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groups = DataRes.copyOf(dataRes.groups);
                this.geo = dataRes.geo;
                this.offset = dataRes.offset;
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
