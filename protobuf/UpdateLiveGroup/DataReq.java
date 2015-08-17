package protobuf.UpdateLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_SIGNATURE = "";
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.STRING)
    public final List<String> backgrounds;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer labelId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String signature;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_LABELID = 0;
    public static final List<String> DEFAULT_BACKGROUNDS = Collections.emptyList();

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.name == null) {
                this.name = "";
            } else {
                this.name = builder.name;
            }
            if (builder.intro == null) {
                this.intro = "";
            } else {
                this.intro = builder.intro;
            }
            if (builder.portrait == null) {
                this.portrait = "";
            } else {
                this.portrait = builder.portrait;
            }
            if (builder.labelId == null) {
                this.labelId = DEFAULT_LABELID;
            } else {
                this.labelId = builder.labelId;
            }
            if (builder.backgrounds == null) {
                this.backgrounds = DEFAULT_BACKGROUNDS;
            } else {
                this.backgrounds = immutableCopyOf(builder.backgrounds);
            }
            if (builder.signature == null) {
                this.signature = "";
                return;
            } else {
                this.signature = builder.signature;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.name = builder.name;
        this.intro = builder.intro;
        this.portrait = builder.portrait;
        this.labelId = builder.labelId;
        this.backgrounds = immutableCopyOf(builder.backgrounds);
        this.signature = builder.signature;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public List<String> backgrounds;
        public Integer groupId;
        public String intro;
        public Integer labelId;
        public String name;
        public String portrait;
        public String signature;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.name = dataReq.name;
                this.intro = dataReq.intro;
                this.portrait = dataReq.portrait;
                this.labelId = dataReq.labelId;
                this.backgrounds = DataReq.copyOf(dataReq.backgrounds);
                this.signature = dataReq.signature;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
