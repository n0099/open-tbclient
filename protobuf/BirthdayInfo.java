package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class BirthdayInfo extends Message {
    public static final String DEFAULT_CONSTELLATION = "";
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer age;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer birthdayShowStatus;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long birthdayTime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String constellation;
    public static final Long DEFAULT_BIRTHDAYTIME = 0L;
    public static final Integer DEFAULT_BIRTHDAYSHOWSTATUS = 0;
    public static final Integer DEFAULT_AGE = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<BirthdayInfo> {
        public Integer age;
        public Integer birthdayShowStatus;
        public Long birthdayTime;
        public String constellation;

        public Builder() {
        }

        public Builder(BirthdayInfo birthdayInfo) {
            super(birthdayInfo);
            if (birthdayInfo == null) {
                return;
            }
            this.birthdayTime = birthdayInfo.birthdayTime;
            this.birthdayShowStatus = birthdayInfo.birthdayShowStatus;
            this.constellation = birthdayInfo.constellation;
            this.age = birthdayInfo.age;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BirthdayInfo build(boolean z) {
            return new BirthdayInfo(this, z);
        }
    }

    public BirthdayInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.birthdayTime;
            if (l == null) {
                this.birthdayTime = DEFAULT_BIRTHDAYTIME;
            } else {
                this.birthdayTime = l;
            }
            Integer num = builder.birthdayShowStatus;
            if (num == null) {
                this.birthdayShowStatus = DEFAULT_BIRTHDAYSHOWSTATUS;
            } else {
                this.birthdayShowStatus = num;
            }
            String str = builder.constellation;
            if (str == null) {
                this.constellation = "";
            } else {
                this.constellation = str;
            }
            Integer num2 = builder.age;
            if (num2 == null) {
                this.age = DEFAULT_AGE;
                return;
            } else {
                this.age = num2;
                return;
            }
        }
        this.birthdayTime = builder.birthdayTime;
        this.birthdayShowStatus = builder.birthdayShowStatus;
        this.constellation = builder.constellation;
        this.age = builder.age;
    }
}
