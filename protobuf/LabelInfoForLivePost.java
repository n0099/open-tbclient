package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class LabelInfoForLivePost extends Message {
    public static final String DEFAULT_LABELCONTENT = "";
    public static final Integer DEFAULT_LABELHOT = 0;
    public static final String DEFAULT_LABELID = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String labelContent;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer labelHot;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String labelId;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<LabelInfoForLivePost> {
        public String labelContent;
        public Integer labelHot;
        public String labelId;

        public Builder() {
        }

        public Builder(LabelInfoForLivePost labelInfoForLivePost) {
            super(labelInfoForLivePost);
            if (labelInfoForLivePost == null) {
                return;
            }
            this.labelContent = labelInfoForLivePost.labelContent;
            this.labelHot = labelInfoForLivePost.labelHot;
            this.labelId = labelInfoForLivePost.labelId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LabelInfoForLivePost build(boolean z) {
            return new LabelInfoForLivePost(this, z);
        }
    }

    public LabelInfoForLivePost(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.labelContent;
            if (str == null) {
                this.labelContent = "";
            } else {
                this.labelContent = str;
            }
            Integer num = builder.labelHot;
            if (num == null) {
                this.labelHot = DEFAULT_LABELHOT;
            } else {
                this.labelHot = num;
            }
            String str2 = builder.labelId;
            if (str2 == null) {
                this.labelId = "";
                return;
            } else {
                this.labelId = str2;
                return;
            }
        }
        this.labelContent = builder.labelContent;
        this.labelHot = builder.labelHot;
        this.labelId = builder.labelId;
    }
}
