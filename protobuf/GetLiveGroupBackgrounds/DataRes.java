package protobuf.GetLiveGroupBackgrounds;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.Photo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final List<Photo> DEFAULT_BACKGROUNDS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<Photo> backgrounds;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.backgrounds == null) {
                this.backgrounds = DEFAULT_BACKGROUNDS;
                return;
            } else {
                this.backgrounds = immutableCopyOf(builder.backgrounds);
                return;
            }
        }
        this.backgrounds = immutableCopyOf(builder.backgrounds);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public List<Photo> backgrounds;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.backgrounds = DataRes.copyOf(dataRes.backgrounds);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
