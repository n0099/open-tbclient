package protobuf.QueryLiveGroupConfig;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_SENDIMGTIPS = "";
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer bgRotateSecs;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer hasSendImgAuth;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer introExpireHours;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer introPullHours;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer introStaySecs;
    @ProtoField(label = Message.Label.REPEATED, tag = 5)
    public final List<IntroInfo> intros;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String sendImgTips;
    public static final Integer DEFAULT_HASSENDIMGAUTH = 0;
    public static final Integer DEFAULT_INTROSTAYSECS = 0;
    public static final Integer DEFAULT_BGROTATESECS = 0;
    public static final List<IntroInfo> DEFAULT_INTROS = Collections.emptyList();
    public static final Integer DEFAULT_INTROEXPIREHOURS = 0;
    public static final Integer DEFAULT_INTROPULLHOURS = 0;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.hasSendImgAuth == null) {
                this.hasSendImgAuth = DEFAULT_HASSENDIMGAUTH;
            } else {
                this.hasSendImgAuth = builder.hasSendImgAuth;
            }
            if (builder.sendImgTips == null) {
                this.sendImgTips = "";
            } else {
                this.sendImgTips = builder.sendImgTips;
            }
            if (builder.introStaySecs == null) {
                this.introStaySecs = DEFAULT_INTROSTAYSECS;
            } else {
                this.introStaySecs = builder.introStaySecs;
            }
            if (builder.bgRotateSecs == null) {
                this.bgRotateSecs = DEFAULT_BGROTATESECS;
            } else {
                this.bgRotateSecs = builder.bgRotateSecs;
            }
            if (builder.intros == null) {
                this.intros = DEFAULT_INTROS;
            } else {
                this.intros = immutableCopyOf(builder.intros);
            }
            if (builder.introExpireHours == null) {
                this.introExpireHours = DEFAULT_INTROEXPIREHOURS;
            } else {
                this.introExpireHours = builder.introExpireHours;
            }
            if (builder.introPullHours == null) {
                this.introPullHours = DEFAULT_INTROPULLHOURS;
                return;
            } else {
                this.introPullHours = builder.introPullHours;
                return;
            }
        }
        this.hasSendImgAuth = builder.hasSendImgAuth;
        this.sendImgTips = builder.sendImgTips;
        this.introStaySecs = builder.introStaySecs;
        this.bgRotateSecs = builder.bgRotateSecs;
        this.intros = immutableCopyOf(builder.intros);
        this.introExpireHours = builder.introExpireHours;
        this.introPullHours = builder.introPullHours;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Integer bgRotateSecs;
        public Integer hasSendImgAuth;
        public Integer introExpireHours;
        public Integer introPullHours;
        public Integer introStaySecs;
        public List<IntroInfo> intros;
        public String sendImgTips;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.hasSendImgAuth = dataRes.hasSendImgAuth;
                this.sendImgTips = dataRes.sendImgTips;
                this.introStaySecs = dataRes.introStaySecs;
                this.bgRotateSecs = dataRes.bgRotateSecs;
                this.intros = DataRes.copyOf(dataRes.intros);
                this.introExpireHours = dataRes.introExpireHours;
                this.introPullHours = dataRes.introPullHours;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
