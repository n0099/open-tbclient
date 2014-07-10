package protobuf.QueryGroupLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final List<String> DEFAULT_BUSINESS = Collections.emptyList();
    public static final String DEFAULT_POSITION = "";
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> business;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String position;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.position == null) {
                this.position = "";
            } else {
                this.position = builder.position;
            }
            if (builder.business == null) {
                this.business = DEFAULT_BUSINESS;
                return;
            } else {
                this.business = immutableCopyOf(builder.business);
                return;
            }
        }
        this.position = builder.position;
        this.business = immutableCopyOf(builder.business);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public List<String> business;
        public String position;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.position = dataRes.position;
                this.business = DataRes.copyOf(dataRes.business);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
