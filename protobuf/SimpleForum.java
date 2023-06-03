package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class SimpleForum extends Message {
    public static final String DEFAULT_AVATAR = "";
    public static final String DEFAULT_EXT = "";
    public static final String DEFAULT_FIRSTCLASS = "";
    public static final String DEFAULT_FORUMTOUTU = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_SECONDCLASS = "";
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String avatar;
    @ProtoField(tag = 17)
    public final DeletedReasonInfo deletedReasonInfo;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String ext;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String firstClass;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String forumToutu;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer isBrandForum;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer isExists;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer isFrsMask;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer isLiked;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer isSigned;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer levelId;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer memberNum;
    @ProtoField(tag = 11)
    public final MultiForumPerm multiForumPerm;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer postNum;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String secondClass;
    @ProtoField(label = Message.Label.REPEATED, tag = 15)
    public final List<FrsTabInfo> tabInfo;
    @ProtoField(tag = 19)
    public final ThemeColorInfo themeColor;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_ISEXISTS = 0;
    public static final Integer DEFAULT_ISLIKED = 0;
    public static final Integer DEFAULT_ISSIGNED = 0;
    public static final Integer DEFAULT_LEVELID = 0;
    public static final Integer DEFAULT_MEMBERNUM = 0;
    public static final Integer DEFAULT_POSTNUM = 0;
    public static final Integer DEFAULT_ISBRANDFORUM = 0;
    public static final List<FrsTabInfo> DEFAULT_TABINFO = Collections.emptyList();
    public static final Integer DEFAULT_ISFRSMASK = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<SimpleForum> {
        public String avatar;
        public DeletedReasonInfo deletedReasonInfo;
        public String ext;
        public String firstClass;
        public String forumToutu;
        public Long id;
        public Integer isBrandForum;
        public Integer isExists;
        public Integer isFrsMask;
        public Integer isLiked;
        public Integer isSigned;
        public Integer levelId;
        public Integer memberNum;
        public MultiForumPerm multiForumPerm;
        public String name;
        public Integer postNum;
        public String secondClass;
        public List<FrsTabInfo> tabInfo;
        public ThemeColorInfo themeColor;

        public Builder() {
        }

        public Builder(SimpleForum simpleForum) {
            super(simpleForum);
            if (simpleForum == null) {
                return;
            }
            this.id = simpleForum.id;
            this.name = simpleForum.name;
            this.isExists = simpleForum.isExists;
            this.avatar = simpleForum.avatar;
            this.isLiked = simpleForum.isLiked;
            this.isSigned = simpleForum.isSigned;
            this.firstClass = simpleForum.firstClass;
            this.secondClass = simpleForum.secondClass;
            this.ext = simpleForum.ext;
            this.levelId = simpleForum.levelId;
            this.multiForumPerm = simpleForum.multiForumPerm;
            this.memberNum = simpleForum.memberNum;
            this.postNum = simpleForum.postNum;
            this.isBrandForum = simpleForum.isBrandForum;
            this.tabInfo = Message.copyOf(simpleForum.tabInfo);
            this.forumToutu = simpleForum.forumToutu;
            this.deletedReasonInfo = simpleForum.deletedReasonInfo;
            this.isFrsMask = simpleForum.isFrsMask;
            this.themeColor = simpleForum.themeColor;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SimpleForum build(boolean z) {
            return new SimpleForum(this, z);
        }
    }

    public SimpleForum(Builder builder, boolean z) {
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
            Integer num = builder.isExists;
            if (num == null) {
                this.isExists = DEFAULT_ISEXISTS;
            } else {
                this.isExists = num;
            }
            String str2 = builder.avatar;
            if (str2 == null) {
                this.avatar = "";
            } else {
                this.avatar = str2;
            }
            Integer num2 = builder.isLiked;
            if (num2 == null) {
                this.isLiked = DEFAULT_ISLIKED;
            } else {
                this.isLiked = num2;
            }
            Integer num3 = builder.isSigned;
            if (num3 == null) {
                this.isSigned = DEFAULT_ISSIGNED;
            } else {
                this.isSigned = num3;
            }
            String str3 = builder.firstClass;
            if (str3 == null) {
                this.firstClass = "";
            } else {
                this.firstClass = str3;
            }
            String str4 = builder.secondClass;
            if (str4 == null) {
                this.secondClass = "";
            } else {
                this.secondClass = str4;
            }
            String str5 = builder.ext;
            if (str5 == null) {
                this.ext = "";
            } else {
                this.ext = str5;
            }
            Integer num4 = builder.levelId;
            if (num4 == null) {
                this.levelId = DEFAULT_LEVELID;
            } else {
                this.levelId = num4;
            }
            this.multiForumPerm = builder.multiForumPerm;
            Integer num5 = builder.memberNum;
            if (num5 == null) {
                this.memberNum = DEFAULT_MEMBERNUM;
            } else {
                this.memberNum = num5;
            }
            Integer num6 = builder.postNum;
            if (num6 == null) {
                this.postNum = DEFAULT_POSTNUM;
            } else {
                this.postNum = num6;
            }
            Integer num7 = builder.isBrandForum;
            if (num7 == null) {
                this.isBrandForum = DEFAULT_ISBRANDFORUM;
            } else {
                this.isBrandForum = num7;
            }
            List<FrsTabInfo> list = builder.tabInfo;
            if (list == null) {
                this.tabInfo = DEFAULT_TABINFO;
            } else {
                this.tabInfo = Message.immutableCopyOf(list);
            }
            String str6 = builder.forumToutu;
            if (str6 == null) {
                this.forumToutu = "";
            } else {
                this.forumToutu = str6;
            }
            this.deletedReasonInfo = builder.deletedReasonInfo;
            Integer num8 = builder.isFrsMask;
            if (num8 == null) {
                this.isFrsMask = DEFAULT_ISFRSMASK;
            } else {
                this.isFrsMask = num8;
            }
            this.themeColor = builder.themeColor;
            return;
        }
        this.id = builder.id;
        this.name = builder.name;
        this.isExists = builder.isExists;
        this.avatar = builder.avatar;
        this.isLiked = builder.isLiked;
        this.isSigned = builder.isSigned;
        this.firstClass = builder.firstClass;
        this.secondClass = builder.secondClass;
        this.ext = builder.ext;
        this.levelId = builder.levelId;
        this.multiForumPerm = builder.multiForumPerm;
        this.memberNum = builder.memberNum;
        this.postNum = builder.postNum;
        this.isBrandForum = builder.isBrandForum;
        this.tabInfo = Message.immutableCopyOf(builder.tabInfo);
        this.forumToutu = builder.forumToutu;
        this.deletedReasonInfo = builder.deletedReasonInfo;
        this.isFrsMask = builder.isFrsMask;
        this.themeColor = builder.themeColor;
    }
}
