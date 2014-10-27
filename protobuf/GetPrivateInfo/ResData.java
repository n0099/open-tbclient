package protobuf.GetPrivateInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ResData extends Message {
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer group;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer like;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer location;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer post;
    public static final Integer DEFAULT_LOCATION = 0;
    public static final Integer DEFAULT_POST = 0;
    public static final Integer DEFAULT_LIKE = 0;
    public static final Integer DEFAULT_GROUP = 0;

    /* synthetic */ ResData(Builder builder, boolean z, ResData resData) {
        this(builder, z);
    }

    private ResData(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.location == null) {
                this.location = DEFAULT_LOCATION;
            } else {
                this.location = builder.location;
            }
            if (builder.post == null) {
                this.post = DEFAULT_POST;
            } else {
                this.post = builder.post;
            }
            if (builder.like == null) {
                this.like = DEFAULT_LIKE;
            } else {
                this.like = builder.like;
            }
            if (builder.group == null) {
                this.group = DEFAULT_GROUP;
                return;
            } else {
                this.group = builder.group;
                return;
            }
        }
        this.location = builder.location;
        this.post = builder.post;
        this.like = builder.like;
        this.group = builder.group;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<ResData> {
        public Integer group;
        public Integer like;
        public Integer location;
        public Integer post;

        public Builder(ResData resData) {
            super(resData);
            if (resData != null) {
                this.location = resData.location;
                this.post = resData.post;
                this.like = resData.like;
                this.group = resData.group;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ResData build(boolean z) {
            return new ResData(this, z, null);
        }
    }
}
