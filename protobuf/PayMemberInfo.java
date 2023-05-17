package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class PayMemberInfo extends Message {
    public static final String DEFAULT_EXPIREREMIND = "";
    public static final String DEFAULT_PICURL = "";
    public static final String DEFAULT_URL = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String expireRemind;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer propsId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String url;
    public static final Integer DEFAULT_PROPSID = 0;
    public static final Integer DEFAULT_ENDTIME = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<PayMemberInfo> {
        public Integer endTime;
        public String expireRemind;
        public String picUrl;
        public Integer propsId;
        public String url;

        public Builder() {
        }

        public Builder(PayMemberInfo payMemberInfo) {
            super(payMemberInfo);
            if (payMemberInfo == null) {
                return;
            }
            this.propsId = payMemberInfo.propsId;
            this.endTime = payMemberInfo.endTime;
            this.url = payMemberInfo.url;
            this.expireRemind = payMemberInfo.expireRemind;
            this.picUrl = payMemberInfo.picUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PayMemberInfo build(boolean z) {
            return new PayMemberInfo(this, z);
        }
    }

    public PayMemberInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.propsId;
            if (num == null) {
                this.propsId = DEFAULT_PROPSID;
            } else {
                this.propsId = num;
            }
            Integer num2 = builder.endTime;
            if (num2 == null) {
                this.endTime = DEFAULT_ENDTIME;
            } else {
                this.endTime = num2;
            }
            String str = builder.url;
            if (str == null) {
                this.url = "";
            } else {
                this.url = str;
            }
            String str2 = builder.expireRemind;
            if (str2 == null) {
                this.expireRemind = "";
            } else {
                this.expireRemind = str2;
            }
            String str3 = builder.picUrl;
            if (str3 == null) {
                this.picUrl = "";
                return;
            } else {
                this.picUrl = str3;
                return;
            }
        }
        this.propsId = builder.propsId;
        this.endTime = builder.endTime;
        this.url = builder.url;
        this.expireRemind = builder.expireRemind;
        this.picUrl = builder.picUrl;
    }
}
