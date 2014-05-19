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

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.id == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = builder.id;
            }
            if (builder.name == null) {
                this.name = "";
            } else {
                this.name = builder.name;
            }
            if (builder.nameShow == null) {
                this.nameShow = "";
            } else {
                this.nameShow = builder.nameShow;
            }
            if (builder.portrait == null) {
                this.portrait = "";
            } else {
                this.portrait = builder.portrait;
            }
            if (builder.portraith == null) {
                this.portraith = "";
            } else {
                this.portraith = builder.portraith;
            }
            if (builder.intro == null) {
                this.intro = "";
            } else {
                this.intro = builder.intro;
            }
            if (builder.sex == null) {
                this.sex = DEFAULT_SEX;
            } else {
                this.sex = builder.sex;
            }
            if (builder.hasConcerned == null) {
                this.hasConcerned = DEFAULT_HASCONCERNED;
            } else {
                this.hasConcerned = builder.hasConcerned;
            }
            if (builder.isBlacklist == null) {
                this.isBlacklist = DEFAULT_ISBLACKLIST;
            } else {
                this.isBlacklist = builder.isBlacklist;
            }
            if (builder.meizhiLevel == null) {
                this.meizhiLevel = DEFAULT_MEIZHILEVEL;
            } else {
                this.meizhiLevel = builder.meizhiLevel;
            }
            if (builder.userType == null) {
                this.userType = DEFAULT_USERTYPE;
            } else {
                this.userType = builder.userType;
            }
            if (builder.isCoreuser == null) {
                this.isCoreuser = DEFAULT_ISCOREUSER;
            } else {
                this.isCoreuser = builder.isCoreuser;
            }
            if (builder.superboy == null) {
                this.superboy = DEFAULT_SUPERBOY;
            } else {
                this.superboy = builder.superboy;
            }
            if (builder.isInterestman == null) {
                this.isInterestman = DEFAULT_ISINTERESTMAN;
            } else {
                this.isInterestman = builder.isInterestman;
            }
            if (builder.iconInfo == null) {
                this.iconInfo = DEFAULT_ICONINFO;
                return;
            } else {
                this.iconInfo = immutableCopyOf(builder.iconInfo);
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
        this.iconInfo = immutableCopyOf(builder.iconInfo);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
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
        public Integer sex;
        public Integer superboy;
        public Integer userType;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
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
                this.iconInfo = DataRes.copyOf(dataRes.iconInfo);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
