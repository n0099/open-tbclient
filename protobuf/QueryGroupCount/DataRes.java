package protobuf.QueryGroupCount;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_POSITION = "";
    @ProtoField(tag = 3)
    public final Banner banner;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer localGroupCount;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String position;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userGroupCount;
    public static final Integer DEFAULT_USERGROUPCOUNT = 0;
    public static final Integer DEFAULT_LOCALGROUPCOUNT = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.userGroupCount == null) {
                this.userGroupCount = DEFAULT_USERGROUPCOUNT;
            } else {
                this.userGroupCount = builder.userGroupCount;
            }
            if (builder.localGroupCount == null) {
                this.localGroupCount = DEFAULT_LOCALGROUPCOUNT;
            } else {
                this.localGroupCount = builder.localGroupCount;
            }
            this.banner = builder.banner;
            if (builder.position == null) {
                this.position = "";
                return;
            } else {
                this.position = builder.position;
                return;
            }
        }
        this.userGroupCount = builder.userGroupCount;
        this.localGroupCount = builder.localGroupCount;
        this.banner = builder.banner;
        this.position = builder.position;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Banner banner;
        public Integer localGroupCount;
        public String position;
        public Integer userGroupCount;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.userGroupCount = dataRes.userGroupCount;
                this.localGroupCount = dataRes.localGroupCount;
                this.banner = dataRes.banner;
                this.position = dataRes.position;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
