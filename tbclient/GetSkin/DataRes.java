package tbclient.GetSkin;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_ACTIVITY_URL = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_PACKAGE_SIZE = "";
    public static final String DEFAULT_PACKAGE_URL = "";
    public static final String DEFAULT_PERMISSION = "";
    public static final String DEFAULT_PROPS_STATE_IMG = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String activity_url;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer free_user_level;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String package_size;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String package_url;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String permission;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> pic_url;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String props_state_img;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer props_version;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;
    public static final List<String> DEFAULT_PIC_URL = Collections.emptyList();
    public static final Integer DEFAULT_PROPS_VERSION = 0;
    public static final Integer DEFAULT_FREE_USER_LEVEL = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.title == null) {
                this.title = "";
            } else {
                this.title = builder.title;
            }
            if (builder.description == null) {
                this.description = "";
            } else {
                this.description = builder.description;
            }
            if (builder.pic_url == null) {
                this.pic_url = DEFAULT_PIC_URL;
            } else {
                this.pic_url = immutableCopyOf(builder.pic_url);
            }
            if (builder.props_state_img == null) {
                this.props_state_img = "";
            } else {
                this.props_state_img = builder.props_state_img;
            }
            if (builder.package_url == null) {
                this.package_url = "";
            } else {
                this.package_url = builder.package_url;
            }
            if (builder.package_size == null) {
                this.package_size = "";
            } else {
                this.package_size = builder.package_size;
            }
            if (builder.permission == null) {
                this.permission = "";
            } else {
                this.permission = builder.permission;
            }
            if (builder.props_version == null) {
                this.props_version = DEFAULT_PROPS_VERSION;
            } else {
                this.props_version = builder.props_version;
            }
            if (builder.free_user_level == null) {
                this.free_user_level = DEFAULT_FREE_USER_LEVEL;
            } else {
                this.free_user_level = builder.free_user_level;
            }
            if (builder.activity_url == null) {
                this.activity_url = "";
                return;
            } else {
                this.activity_url = builder.activity_url;
                return;
            }
        }
        this.title = builder.title;
        this.description = builder.description;
        this.pic_url = immutableCopyOf(builder.pic_url);
        this.props_state_img = builder.props_state_img;
        this.package_url = builder.package_url;
        this.package_size = builder.package_size;
        this.permission = builder.permission;
        this.props_version = builder.props_version;
        this.free_user_level = builder.free_user_level;
        this.activity_url = builder.activity_url;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public String activity_url;
        public String description;
        public Integer free_user_level;
        public String package_size;
        public String package_url;
        public String permission;
        public List<String> pic_url;
        public String props_state_img;
        public Integer props_version;
        public String title;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.title = dataRes.title;
                this.description = dataRes.description;
                this.pic_url = DataRes.copyOf(dataRes.pic_url);
                this.props_state_img = dataRes.props_state_img;
                this.package_url = dataRes.package_url;
                this.package_size = dataRes.package_size;
                this.permission = dataRes.permission;
                this.props_version = dataRes.props_version;
                this.free_user_level = dataRes.free_user_level;
                this.activity_url = dataRes.activity_url;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
