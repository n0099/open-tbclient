package protobuf.QueryUserInfos;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAMESHOW = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_PORTRAITH = "";
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer hasConcerned;
    @ProtoField(label = Message.Label.REPEATED, tag = 15)
    public final List<IconInfo> iconInfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer isBlacklist;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer isCoreuser;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer isInterestman;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer meizhiLevel;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String nameShow;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String portraith;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer remindMask;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer sex;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer superboy;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer userType;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_SEX = 0;
    public static final Integer DEFAULT_HASCONCERNED = 0;
    public static final Integer DEFAULT_ISBLACKLIST = 0;
    public static final Integer DEFAULT_MEIZHILEVEL = 0;
    public static final Integer DEFAULT_USERTYPE = 0;
    public static final Integer DEFAULT_ISCOREUSER = 0;
    public static final Integer DEFAULT_SUPERBOY = 0;
    public static final Integer DEFAULT_ISINTERESTMAN = 0;
    public static final List<IconInfo> DEFAULT_ICONINFO = Collections.emptyList();
    public static final Integer DEFAULT_REMINDMASK = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer hasConcerned;
        public List<IconInfo> iconInfo;
        public Long id;
        public String intro;
        public Integer isBlacklist;
        public Integer isCoreuser;
        public Integer isInterestman;
        public Integer meizhiLevel;
        public String name;
        public String nameShow;
        public String portrait;
        public String portraith;
        public Integer remindMask;
        public Integer sex;
        public Integer superboy;
        public Integer userType;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes == null) {
                return;
            }
            this.id = dataRes.id;
            this.name = dataRes.name;
            this.nameShow = dataRes.nameShow;
            this.portrait = dataRes.portrait;
            this.portraith = dataRes.portraith;
            this.intro = dataRes.intro;
            this.sex = dataRes.sex;
            this.hasConcerned = dataRes.hasConcerned;
            this.isBlacklist = dataRes.isBlacklist;
            this.meizhiLevel = dataRes.meizhiLevel;
            this.userType = dataRes.userType;
            this.isCoreuser = dataRes.isCoreuser;
            this.superboy = dataRes.superboy;
            this.isInterestman = dataRes.isInterestman;
            this.iconInfo = Message.copyOf(dataRes.iconInfo);
            this.remindMask = dataRes.remindMask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.id;
            if (l == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = l;
            }
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.nameShow;
            if (str2 == null) {
                this.nameShow = "";
            } else {
                this.nameShow = str2;
            }
            String str3 = builder.portrait;
            if (str3 == null) {
                this.portrait = "";
            } else {
                this.portrait = str3;
            }
            String str4 = builder.portraith;
            if (str4 == null) {
                this.portraith = "";
            } else {
                this.portraith = str4;
            }
            String str5 = builder.intro;
            if (str5 == null) {
                this.intro = "";
            } else {
                this.intro = str5;
            }
            Integer num = builder.sex;
            if (num == null) {
                this.sex = DEFAULT_SEX;
            } else {
                this.sex = num;
            }
            Integer num2 = builder.hasConcerned;
            if (num2 == null) {
                this.hasConcerned = DEFAULT_HASCONCERNED;
            } else {
                this.hasConcerned = num2;
            }
            Integer num3 = builder.isBlacklist;
            if (num3 == null) {
                this.isBlacklist = DEFAULT_ISBLACKLIST;
            } else {
                this.isBlacklist = num3;
            }
            Integer num4 = builder.meizhiLevel;
            if (num4 == null) {
                this.meizhiLevel = DEFAULT_MEIZHILEVEL;
            } else {
                this.meizhiLevel = num4;
            }
            Integer num5 = builder.userType;
            if (num5 == null) {
                this.userType = DEFAULT_USERTYPE;
            } else {
                this.userType = num5;
            }
            Integer num6 = builder.isCoreuser;
            if (num6 == null) {
                this.isCoreuser = DEFAULT_ISCOREUSER;
            } else {
                this.isCoreuser = num6;
            }
            Integer num7 = builder.superboy;
            if (num7 == null) {
                this.superboy = DEFAULT_SUPERBOY;
            } else {
                this.superboy = num7;
            }
            Integer num8 = builder.isInterestman;
            if (num8 == null) {
                this.isInterestman = DEFAULT_ISINTERESTMAN;
            } else {
                this.isInterestman = num8;
            }
            List<IconInfo> list = builder.iconInfo;
            if (list == null) {
                this.iconInfo = DEFAULT_ICONINFO;
            } else {
                this.iconInfo = Message.immutableCopyOf(list);
            }
            Integer num9 = builder.remindMask;
            if (num9 == null) {
                this.remindMask = DEFAULT_REMINDMASK;
                return;
            } else {
                this.remindMask = num9;
                return;
            }
        }
        this.id = builder.id;
        this.name = builder.name;
        this.nameShow = builder.nameShow;
        this.portrait = builder.portrait;
        this.portraith = builder.portraith;
        this.intro = builder.intro;
        this.sex = builder.sex;
        this.hasConcerned = builder.hasConcerned;
        this.isBlacklist = builder.isBlacklist;
        this.meizhiLevel = builder.meizhiLevel;
        this.userType = builder.userType;
        this.isCoreuser = builder.isCoreuser;
        this.superboy = builder.superboy;
        this.isInterestman = builder.isInterestman;
        this.iconInfo = Message.immutableCopyOf(builder.iconInfo);
        this.remindMask = builder.remindMask;
    }
}
