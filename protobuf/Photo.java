package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class Photo extends Message {
    public static final String DEFAULT_BIGURL = "";
    public static final String DEFAULT_PICID = "";
    public static final String DEFAULT_SMALLURL = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String bigurl;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String picId;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String smallurl;

    private Photo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.smallurl == null) {
                this.smallurl = "";
            } else {
                this.smallurl = builder.smallurl;
            }
            if (builder.bigurl == null) {
                this.bigurl = "";
            } else {
                this.bigurl = builder.bigurl;
            }
            if (builder.picId == null) {
                this.picId = "";
                return;
            } else {
                this.picId = builder.picId;
                return;
            }
        }
        this.smallurl = builder.smallurl;
        this.bigurl = builder.bigurl;
        this.picId = builder.picId;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<Photo> {
        public String bigurl;
        public String picId;
        public String smallurl;

        public Builder() {
        }

        public Builder(Photo photo) {
            super(photo);
            if (photo != null) {
                this.smallurl = photo.smallurl;
                this.bigurl = photo.bigurl;
                this.picId = photo.picId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Photo build(boolean z) {
            return new Photo(this, z);
        }
    }
}
