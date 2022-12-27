package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class NativeApp extends Message {
    public static final String DEFAULT_DOWNLOADAND = "";
    public static final String DEFAULT_DOWNLOADIOS = "";
    public static final String DEFAULT_JUMPAND = "";
    public static final String DEFAULT_JUMPIOS = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String downloadAnd;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String downloadIos;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String jumpAnd;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String jumpIos;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<NativeApp> {
        public String downloadAnd;
        public String downloadIos;
        public String jumpAnd;
        public String jumpIos;

        public Builder() {
        }

        public Builder(NativeApp nativeApp) {
            super(nativeApp);
            if (nativeApp == null) {
                return;
            }
            this.jumpAnd = nativeApp.jumpAnd;
            this.jumpIos = nativeApp.jumpIos;
            this.downloadAnd = nativeApp.downloadAnd;
            this.downloadIos = nativeApp.downloadIos;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NativeApp build(boolean z) {
            return new NativeApp(this, z);
        }
    }

    public NativeApp(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.jumpAnd;
            if (str == null) {
                this.jumpAnd = "";
            } else {
                this.jumpAnd = str;
            }
            String str2 = builder.jumpIos;
            if (str2 == null) {
                this.jumpIos = "";
            } else {
                this.jumpIos = str2;
            }
            String str3 = builder.downloadAnd;
            if (str3 == null) {
                this.downloadAnd = "";
            } else {
                this.downloadAnd = str3;
            }
            String str4 = builder.downloadIos;
            if (str4 == null) {
                this.downloadIos = "";
                return;
            } else {
                this.downloadIos = str4;
                return;
            }
        }
        this.jumpAnd = builder.jumpAnd;
        this.jumpIos = builder.jumpIos;
        this.downloadAnd = builder.downloadAnd;
        this.downloadIos = builder.downloadIos;
    }
}
