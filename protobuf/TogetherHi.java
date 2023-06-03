package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class TogetherHi extends Message {
    public static final String DEFAULT_ALBUMNAME = "";
    public static final String DEFAULT_LOCATION = "";
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long albumId;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String albumName;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer endTime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String location;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer numJoin;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer numSignup;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.STRING)
    public final List<String> picUrls;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.STRING)
    public final List<String> potraits;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer startTime;
    public static final Long DEFAULT_ALBUMID = 0L;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Integer DEFAULT_ENDTIME = 0;
    public static final Integer DEFAULT_NUMSIGNUP = 0;
    public static final List<String> DEFAULT_POTRAITS = Collections.emptyList();
    public static final Integer DEFAULT_NUMJOIN = 0;
    public static final List<String> DEFAULT_PICURLS = Collections.emptyList();

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<TogetherHi> {
        public Long albumId;
        public String albumName;
        public Integer endTime;
        public String location;
        public Integer numJoin;
        public Integer numSignup;
        public List<String> picUrls;
        public List<String> potraits;
        public Integer startTime;

        public Builder() {
        }

        public Builder(TogetherHi togetherHi) {
            super(togetherHi);
            if (togetherHi == null) {
                return;
            }
            this.albumName = togetherHi.albumName;
            this.albumId = togetherHi.albumId;
            this.startTime = togetherHi.startTime;
            this.endTime = togetherHi.endTime;
            this.location = togetherHi.location;
            this.numSignup = togetherHi.numSignup;
            this.potraits = Message.copyOf(togetherHi.potraits);
            this.numJoin = togetherHi.numJoin;
            this.picUrls = Message.copyOf(togetherHi.picUrls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public TogetherHi build(boolean z) {
            return new TogetherHi(this, z);
        }
    }

    public TogetherHi(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.albumName;
            if (str == null) {
                this.albumName = "";
            } else {
                this.albumName = str;
            }
            Long l = builder.albumId;
            if (l == null) {
                this.albumId = DEFAULT_ALBUMID;
            } else {
                this.albumId = l;
            }
            Integer num = builder.startTime;
            if (num == null) {
                this.startTime = DEFAULT_STARTTIME;
            } else {
                this.startTime = num;
            }
            Integer num2 = builder.endTime;
            if (num2 == null) {
                this.endTime = DEFAULT_ENDTIME;
            } else {
                this.endTime = num2;
            }
            String str2 = builder.location;
            if (str2 == null) {
                this.location = "";
            } else {
                this.location = str2;
            }
            Integer num3 = builder.numSignup;
            if (num3 == null) {
                this.numSignup = DEFAULT_NUMSIGNUP;
            } else {
                this.numSignup = num3;
            }
            List<String> list = builder.potraits;
            if (list == null) {
                this.potraits = DEFAULT_POTRAITS;
            } else {
                this.potraits = Message.immutableCopyOf(list);
            }
            Integer num4 = builder.numJoin;
            if (num4 == null) {
                this.numJoin = DEFAULT_NUMJOIN;
            } else {
                this.numJoin = num4;
            }
            List<String> list2 = builder.picUrls;
            if (list2 == null) {
                this.picUrls = DEFAULT_PICURLS;
                return;
            } else {
                this.picUrls = Message.immutableCopyOf(list2);
                return;
            }
        }
        this.albumName = builder.albumName;
        this.albumId = builder.albumId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.location = builder.location;
        this.numSignup = builder.numSignup;
        this.potraits = Message.immutableCopyOf(builder.potraits);
        this.numJoin = builder.numJoin;
        this.picUrls = Message.immutableCopyOf(builder.picUrls);
    }
}
