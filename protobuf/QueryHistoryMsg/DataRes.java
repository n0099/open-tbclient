package protobuf.QueryHistoryMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<MsgInfo> res;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer total;
    public static final Integer DEFAULT_TOTAL = 0;
    public static final List<MsgInfo> DEFAULT_RES = Collections.emptyList();

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.total == null) {
                this.total = DEFAULT_TOTAL;
            } else {
                this.total = builder.total;
            }
            if (builder.res == null) {
                this.res = DEFAULT_RES;
                return;
            } else {
                this.res = immutableCopyOf(builder.res);
                return;
            }
        }
        this.total = builder.total;
        this.res = immutableCopyOf(builder.res);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public List<MsgInfo> res;
        public Integer total;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.total = dataRes.total;
                this.res = DataRes.copyOf(dataRes.res);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
