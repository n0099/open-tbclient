package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class ThemeCardInUser extends Message {
    public static final String DEFAULT_COORDINATE = "";
    public static final String DEFAULT_IMGANDROID = "";
    public static final String DEFAULT_IMGIOS = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String coordinate;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String imgAndroid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String imgIos;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer level;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long propsId;
    public static final Long DEFAULT_PROPSID = 0L;
    public static final Integer DEFAULT_LEVEL = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<ThemeCardInUser> {
        public String coordinate;
        public String imgAndroid;
        public String imgIos;
        public Integer level;
        public Long propsId;

        public Builder() {
        }

        public Builder(ThemeCardInUser themeCardInUser) {
            super(themeCardInUser);
            if (themeCardInUser == null) {
                return;
            }
            this.propsId = themeCardInUser.propsId;
            this.imgIos = themeCardInUser.imgIos;
            this.coordinate = themeCardInUser.coordinate;
            this.imgAndroid = themeCardInUser.imgAndroid;
            this.level = themeCardInUser.level;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ThemeCardInUser build(boolean z) {
            return new ThemeCardInUser(this, z);
        }
    }

    public ThemeCardInUser(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.propsId;
            if (l == null) {
                this.propsId = DEFAULT_PROPSID;
            } else {
                this.propsId = l;
            }
            String str = builder.imgIos;
            if (str == null) {
                this.imgIos = "";
            } else {
                this.imgIos = str;
            }
            String str2 = builder.coordinate;
            if (str2 == null) {
                this.coordinate = "";
            } else {
                this.coordinate = str2;
            }
            String str3 = builder.imgAndroid;
            if (str3 == null) {
                this.imgAndroid = "";
            } else {
                this.imgAndroid = str3;
            }
            Integer num = builder.level;
            if (num == null) {
                this.level = DEFAULT_LEVEL;
                return;
            } else {
                this.level = num;
                return;
            }
        }
        this.propsId = builder.propsId;
        this.imgIos = builder.imgIos;
        this.coordinate = builder.coordinate;
        this.imgAndroid = builder.imgAndroid;
        this.level = builder.level;
    }
}
