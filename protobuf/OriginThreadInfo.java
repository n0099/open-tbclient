package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class OriginThreadInfo extends Message {
    public static final String DEFAULT_FNAME = "";
    public static final String DEFAULT_TID = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<Abstract> _abstract;
    @ProtoField(tag = 19)
    public final Agree agree;
    @ProtoField(tag = 6)
    public final AlaLiveInfo alaInfo;
    @ProtoField(tag = 18)
    public final User author;
    @ProtoField(label = Message.Label.REPEATED, tag = 14)
    public final List<PbContent> content;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long fid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String fname;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer goodTypes;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer isDeleted;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer isFrsMask;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer isNewStyle;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer isUgc;
    @ProtoField(tag = 22)
    public final Item item;
    @ProtoField(label = Message.Label.REPEATED, tag = 23)
    public final List<HeadItem> itemStar;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<Media> media;
    @ProtoField(tag = 11)
    public final Baijiahao oriUgcInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 24)
    public final List<PbLinkInfo> pbLinkInfo;
    @ProtoField(tag = 25, type = Message.Datatype.INT64)
    public final Long pid;
    @ProtoField(tag = 21)
    public final PollInfo pollInfo;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer replyNum;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer sharedNum;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer threadType;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String tid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer topTypes;
    @ProtoField(tag = 13)
    public final VideoInfo videoInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 12)
    public final List<Voice> voiceInfo;
    public static final List<Media> DEFAULT_MEDIA = Collections.emptyList();
    public static final List<Abstract> DEFAULT_ABSTRACT = Collections.emptyList();
    public static final Long DEFAULT_FID = 0L;
    public static final Integer DEFAULT_THREADTYPE = 0;
    public static final Integer DEFAULT_ISDELETED = 0;
    public static final Integer DEFAULT_ISUGC = 0;
    public static final List<Voice> DEFAULT_VOICEINFO = Collections.emptyList();
    public static final List<PbContent> DEFAULT_CONTENT = Collections.emptyList();
    public static final Integer DEFAULT_ISNEWSTYLE = 0;
    public static final Integer DEFAULT_REPLYNUM = 0;
    public static final Integer DEFAULT_SHAREDNUM = 0;
    public static final List<HeadItem> DEFAULT_ITEMSTAR = Collections.emptyList();
    public static final List<PbLinkInfo> DEFAULT_PBLINKINFO = Collections.emptyList();
    public static final Long DEFAULT_PID = 0L;
    public static final Integer DEFAULT_GOODTYPES = 0;
    public static final Integer DEFAULT_TOPTYPES = 0;
    public static final Integer DEFAULT_ISFRSMASK = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<OriginThreadInfo> {
        public List<Abstract> _abstract;
        public Agree agree;
        public AlaLiveInfo alaInfo;
        public User author;
        public List<PbContent> content;
        public Long fid;
        public String fname;
        public Integer goodTypes;
        public Integer isDeleted;
        public Integer isFrsMask;
        public Integer isNewStyle;
        public Integer isUgc;
        public Item item;
        public List<HeadItem> itemStar;
        public List<Media> media;
        public Baijiahao oriUgcInfo;
        public List<PbLinkInfo> pbLinkInfo;
        public Long pid;
        public PollInfo pollInfo;
        public Integer replyNum;
        public Integer sharedNum;
        public Integer threadType;
        public String tid;
        public String title;
        public Integer topTypes;
        public VideoInfo videoInfo;
        public List<Voice> voiceInfo;

        public Builder() {
        }

        public Builder(OriginThreadInfo originThreadInfo) {
            super(originThreadInfo);
            if (originThreadInfo == null) {
                return;
            }
            this.title = originThreadInfo.title;
            this.media = Message.copyOf(originThreadInfo.media);
            this._abstract = Message.copyOf(originThreadInfo._abstract);
            this.fname = originThreadInfo.fname;
            this.tid = originThreadInfo.tid;
            this.alaInfo = originThreadInfo.alaInfo;
            this.fid = originThreadInfo.fid;
            this.threadType = originThreadInfo.threadType;
            this.isDeleted = originThreadInfo.isDeleted;
            this.isUgc = originThreadInfo.isUgc;
            this.oriUgcInfo = originThreadInfo.oriUgcInfo;
            this.voiceInfo = Message.copyOf(originThreadInfo.voiceInfo);
            this.videoInfo = originThreadInfo.videoInfo;
            this.content = Message.copyOf(originThreadInfo.content);
            this.isNewStyle = originThreadInfo.isNewStyle;
            this.replyNum = originThreadInfo.replyNum;
            this.author = originThreadInfo.author;
            this.agree = originThreadInfo.agree;
            this.sharedNum = originThreadInfo.sharedNum;
            this.pollInfo = originThreadInfo.pollInfo;
            this.item = originThreadInfo.item;
            this.itemStar = Message.copyOf(originThreadInfo.itemStar);
            this.pbLinkInfo = Message.copyOf(originThreadInfo.pbLinkInfo);
            this.pid = originThreadInfo.pid;
            this.goodTypes = originThreadInfo.goodTypes;
            this.topTypes = originThreadInfo.topTypes;
            this.isFrsMask = originThreadInfo.isFrsMask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public OriginThreadInfo build(boolean z) {
            return new OriginThreadInfo(this, z);
        }
    }

    public OriginThreadInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.title;
            if (str == null) {
                this.title = "";
            } else {
                this.title = str;
            }
            List<Media> list = builder.media;
            if (list == null) {
                this.media = DEFAULT_MEDIA;
            } else {
                this.media = Message.immutableCopyOf(list);
            }
            List<Abstract> list2 = builder._abstract;
            if (list2 == null) {
                this._abstract = DEFAULT_ABSTRACT;
            } else {
                this._abstract = Message.immutableCopyOf(list2);
            }
            String str2 = builder.fname;
            if (str2 == null) {
                this.fname = "";
            } else {
                this.fname = str2;
            }
            String str3 = builder.tid;
            if (str3 == null) {
                this.tid = "";
            } else {
                this.tid = str3;
            }
            this.alaInfo = builder.alaInfo;
            Long l = builder.fid;
            if (l == null) {
                this.fid = DEFAULT_FID;
            } else {
                this.fid = l;
            }
            Integer num = builder.threadType;
            if (num == null) {
                this.threadType = DEFAULT_THREADTYPE;
            } else {
                this.threadType = num;
            }
            Integer num2 = builder.isDeleted;
            if (num2 == null) {
                this.isDeleted = DEFAULT_ISDELETED;
            } else {
                this.isDeleted = num2;
            }
            Integer num3 = builder.isUgc;
            if (num3 == null) {
                this.isUgc = DEFAULT_ISUGC;
            } else {
                this.isUgc = num3;
            }
            this.oriUgcInfo = builder.oriUgcInfo;
            List<Voice> list3 = builder.voiceInfo;
            if (list3 == null) {
                this.voiceInfo = DEFAULT_VOICEINFO;
            } else {
                this.voiceInfo = Message.immutableCopyOf(list3);
            }
            this.videoInfo = builder.videoInfo;
            List<PbContent> list4 = builder.content;
            if (list4 == null) {
                this.content = DEFAULT_CONTENT;
            } else {
                this.content = Message.immutableCopyOf(list4);
            }
            Integer num4 = builder.isNewStyle;
            if (num4 == null) {
                this.isNewStyle = DEFAULT_ISNEWSTYLE;
            } else {
                this.isNewStyle = num4;
            }
            Integer num5 = builder.replyNum;
            if (num5 == null) {
                this.replyNum = DEFAULT_REPLYNUM;
            } else {
                this.replyNum = num5;
            }
            this.author = builder.author;
            this.agree = builder.agree;
            Integer num6 = builder.sharedNum;
            if (num6 == null) {
                this.sharedNum = DEFAULT_SHAREDNUM;
            } else {
                this.sharedNum = num6;
            }
            this.pollInfo = builder.pollInfo;
            this.item = builder.item;
            List<HeadItem> list5 = builder.itemStar;
            if (list5 == null) {
                this.itemStar = DEFAULT_ITEMSTAR;
            } else {
                this.itemStar = Message.immutableCopyOf(list5);
            }
            List<PbLinkInfo> list6 = builder.pbLinkInfo;
            if (list6 == null) {
                this.pbLinkInfo = DEFAULT_PBLINKINFO;
            } else {
                this.pbLinkInfo = Message.immutableCopyOf(list6);
            }
            Long l2 = builder.pid;
            if (l2 == null) {
                this.pid = DEFAULT_PID;
            } else {
                this.pid = l2;
            }
            Integer num7 = builder.goodTypes;
            if (num7 == null) {
                this.goodTypes = DEFAULT_GOODTYPES;
            } else {
                this.goodTypes = num7;
            }
            Integer num8 = builder.topTypes;
            if (num8 == null) {
                this.topTypes = DEFAULT_TOPTYPES;
            } else {
                this.topTypes = num8;
            }
            Integer num9 = builder.isFrsMask;
            if (num9 == null) {
                this.isFrsMask = DEFAULT_ISFRSMASK;
                return;
            } else {
                this.isFrsMask = num9;
                return;
            }
        }
        this.title = builder.title;
        this.media = Message.immutableCopyOf(builder.media);
        this._abstract = Message.immutableCopyOf(builder._abstract);
        this.fname = builder.fname;
        this.tid = builder.tid;
        this.alaInfo = builder.alaInfo;
        this.fid = builder.fid;
        this.threadType = builder.threadType;
        this.isDeleted = builder.isDeleted;
        this.isUgc = builder.isUgc;
        this.oriUgcInfo = builder.oriUgcInfo;
        this.voiceInfo = Message.immutableCopyOf(builder.voiceInfo);
        this.videoInfo = builder.videoInfo;
        this.content = Message.immutableCopyOf(builder.content);
        this.isNewStyle = builder.isNewStyle;
        this.replyNum = builder.replyNum;
        this.author = builder.author;
        this.agree = builder.agree;
        this.sharedNum = builder.sharedNum;
        this.pollInfo = builder.pollInfo;
        this.item = builder.item;
        this.itemStar = Message.immutableCopyOf(builder.itemStar);
        this.pbLinkInfo = Message.immutableCopyOf(builder.pbLinkInfo);
        this.pid = builder.pid;
        this.goodTypes = builder.goodTypes;
        this.topTypes = builder.topTypes;
        this.isFrsMask = builder.isFrsMask;
    }
}
