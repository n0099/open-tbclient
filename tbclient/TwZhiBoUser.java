package tbclient;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class TwZhiBoUser extends Message {
    public static final String DEFAULT_ANCHOR_ICON = "";
    public static final Integer DEFAULT_ANCHOR_LEVEL = 0;
    public static final Integer DEFAULT_IN_BLACK_LIST = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String anchor_icon;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer anchor_level;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer in_black_list;

    /* synthetic */ TwZhiBoUser(Builder builder, boolean z, TwZhiBoUser twZhiBoUser) {
        this(builder, z);
    }

    private TwZhiBoUser(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.anchor_level == null) {
                this.anchor_level = DEFAULT_ANCHOR_LEVEL;
            } else {
                this.anchor_level = builder.anchor_level;
            }
            if (builder.in_black_list == null) {
                this.in_black_list = DEFAULT_IN_BLACK_LIST;
            } else {
                this.in_black_list = builder.in_black_list;
            }
            if (builder.anchor_icon == null) {
                this.anchor_icon = "";
                return;
            } else {
                this.anchor_icon = builder.anchor_icon;
                return;
            }
        }
        this.anchor_level = builder.anchor_level;
        this.in_black_list = builder.in_black_list;
        this.anchor_icon = builder.anchor_icon;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<TwZhiBoUser> {
        public String anchor_icon;
        public Integer anchor_level;
        public Integer in_black_list;

        public Builder() {
        }

        public Builder(TwZhiBoUser twZhiBoUser) {
            super(twZhiBoUser);
            if (twZhiBoUser != null) {
                this.anchor_level = twZhiBoUser.anchor_level;
                this.in_black_list = twZhiBoUser.in_black_list;
                this.anchor_icon = twZhiBoUser.anchor_icon;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public TwZhiBoUser build(boolean z) {
            return new TwZhiBoUser(this, z, null);
        }
    }
}
