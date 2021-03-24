package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class NewpushGroupRepair extends Message {
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long endSid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer fromUType;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long fromUid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long gid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer gtype;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long lastMid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long startSid;
    public static final Long DEFAULT_GID = 0L;
    public static final Integer DEFAULT_GTYPE = 0;
    public static final Long DEFAULT_STARTSID = 0L;
    public static final Long DEFAULT_ENDSID = 0L;
    public static final Long DEFAULT_LASTMID = 0L;
    public static final Long DEFAULT_FROMUID = 0L;
    public static final Integer DEFAULT_FROMUTYPE = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<NewpushGroupRepair> {
        public Long endSid;
        public Integer fromUType;
        public Long fromUid;
        public Long gid;
        public Integer gtype;
        public Long lastMid;
        public Long startSid;

        public Builder() {
        }

        public Builder(NewpushGroupRepair newpushGroupRepair) {
            super(newpushGroupRepair);
            if (newpushGroupRepair == null) {
                return;
            }
            this.gid = newpushGroupRepair.gid;
            this.gtype = newpushGroupRepair.gtype;
            this.startSid = newpushGroupRepair.startSid;
            this.endSid = newpushGroupRepair.endSid;
            this.lastMid = newpushGroupRepair.lastMid;
            this.fromUid = newpushGroupRepair.fromUid;
            this.fromUType = newpushGroupRepair.fromUType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NewpushGroupRepair build(boolean z) {
            return new NewpushGroupRepair(this, z);
        }
    }

    public NewpushGroupRepair(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.gid;
            if (l == null) {
                this.gid = DEFAULT_GID;
            } else {
                this.gid = l;
            }
            Integer num = builder.gtype;
            if (num == null) {
                this.gtype = DEFAULT_GTYPE;
            } else {
                this.gtype = num;
            }
            Long l2 = builder.startSid;
            if (l2 == null) {
                this.startSid = DEFAULT_STARTSID;
            } else {
                this.startSid = l2;
            }
            Long l3 = builder.endSid;
            if (l3 == null) {
                this.endSid = DEFAULT_ENDSID;
            } else {
                this.endSid = l3;
            }
            Long l4 = builder.lastMid;
            if (l4 == null) {
                this.lastMid = DEFAULT_LASTMID;
            } else {
                this.lastMid = l4;
            }
            Long l5 = builder.fromUid;
            if (l5 == null) {
                this.fromUid = DEFAULT_FROMUID;
            } else {
                this.fromUid = l5;
            }
            Integer num2 = builder.fromUType;
            if (num2 == null) {
                this.fromUType = DEFAULT_FROMUTYPE;
                return;
            } else {
                this.fromUType = num2;
                return;
            }
        }
        this.gid = builder.gid;
        this.gtype = builder.gtype;
        this.startSid = builder.startSid;
        this.endSid = builder.endSid;
        this.lastMid = builder.lastMid;
        this.fromUid = builder.fromUid;
        this.fromUType = builder.fromUType;
    }
}
