package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class ThemeElement extends Message {
    public static final String DEFAULT_COMMONCOLOR = "";
    public static final String DEFAULT_DARKCOLOR = "";
    public static final String DEFAULT_FONTCOLOR = "";
    public static final String DEFAULT_LIGHTCOLOR = "";
    public static final String DEFAULT_PATTERNIMAGE = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String commonColor;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String darkColor;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String fontColor;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String lightColor;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String patternImage;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<ThemeElement> {
        public String commonColor;
        public String darkColor;
        public String fontColor;
        public String lightColor;
        public String patternImage;

        public Builder() {
        }

        public Builder(ThemeElement themeElement) {
            super(themeElement);
            if (themeElement == null) {
                return;
            }
            this.commonColor = themeElement.commonColor;
            this.darkColor = themeElement.darkColor;
            this.lightColor = themeElement.lightColor;
            this.patternImage = themeElement.patternImage;
            this.fontColor = themeElement.fontColor;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ThemeElement build(boolean z) {
            return new ThemeElement(this, z);
        }
    }

    public ThemeElement(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.commonColor;
            if (str == null) {
                this.commonColor = "";
            } else {
                this.commonColor = str;
            }
            String str2 = builder.darkColor;
            if (str2 == null) {
                this.darkColor = "";
            } else {
                this.darkColor = str2;
            }
            String str3 = builder.lightColor;
            if (str3 == null) {
                this.lightColor = "";
            } else {
                this.lightColor = str3;
            }
            String str4 = builder.patternImage;
            if (str4 == null) {
                this.patternImage = "";
            } else {
                this.patternImage = str4;
            }
            String str5 = builder.fontColor;
            if (str5 == null) {
                this.fontColor = "";
                return;
            } else {
                this.fontColor = str5;
                return;
            }
        }
        this.commonColor = builder.commonColor;
        this.darkColor = builder.darkColor;
        this.lightColor = builder.lightColor;
        this.patternImage = builder.patternImage;
        this.fontColor = builder.fontColor;
    }
}
