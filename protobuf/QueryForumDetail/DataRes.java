package protobuf.QueryForumDetail;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes11.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_AUTHEN = "";
    public static final String DEFAULT_PORTRAIT = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String authen;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String portrait;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.portrait == null) {
                this.portrait = "";
            } else {
                this.portrait = builder.portrait;
            }
            if (builder.authen == null) {
                this.authen = "";
                return;
            } else {
                this.authen = builder.authen;
                return;
            }
        }
        this.portrait = builder.portrait;
        this.authen = builder.authen;
    }

    /* loaded from: classes11.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public String authen;
        public String portrait;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.portrait = dataRes.portrait;
                this.authen = dataRes.authen;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
