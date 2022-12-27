package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class ZhiBoInfoTW extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_FIELDEX = "";
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_LIVECOVERSRC = "";
    public static final String DEFAULT_LIVECOVERSRCBSIZE = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 20, type = Message.Datatype.UINT32)
    public final Integer copythreadRemind;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String fieldEx;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long forumId;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 19, type = Message.Datatype.UINT32)
    public final Integer freqNum;
    @ProtoField(tag = 21, type = Message.Datatype.UINT32)
    public final Integer isCopytwzhibo;
    @ProtoField(tag = 15, type = Message.Datatype.UINT32)
    public final Integer isHeadline;
    @ProtoField(tag = 17, type = Message.Datatype.UINT32)
    public final Integer isHeadlineAvailable;
    @ProtoField(tag = 16, type = Message.Datatype.UINT32)
    public final Integer isNewHeadline;
    @ProtoField(label = Message.Label.REPEATED, tag = 13)
    public final List<LabelInfoForLivePost> labels;
    @ProtoField(tag = 9, type = Message.Datatype.UINT64)
    public final Long lastModifiedTime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String livecoverSrc;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String livecoverSrcBsize;
    @ProtoField(tag = 18)
    public final LiveCoverStatus livecoverStatus;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer postNum;
    @ProtoField(tag = 14, type = Message.Datatype.UINT32)
    public final Integer rank;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer replyNum;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long threadId;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 12)
    public final UserInfo userInfo;
    @ProtoField(tag = 6)
    public final Zan zan;
    public static final Long DEFAULT_THREADID = 0L;
    public static final Integer DEFAULT_POSTNUM = 0;
    public static final Integer DEFAULT_REPLYNUM = 0;
    public static final Long DEFAULT_FORUMID = 0L;
    public static final Long DEFAULT_LASTMODIFIEDTIME = 0L;
    public static final List<LabelInfoForLivePost> DEFAULT_LABELS = Collections.emptyList();
    public static final Integer DEFAULT_RANK = 0;
    public static final Integer DEFAULT_ISHEADLINE = 0;
    public static final Integer DEFAULT_ISNEWHEADLINE = 0;
    public static final Integer DEFAULT_ISHEADLINEAVAILABLE = 0;
    public static final Integer DEFAULT_FREQNUM = 0;
    public static final Integer DEFAULT_COPYTHREADREMIND = 0;
    public static final Integer DEFAULT_ISCOPYTWZHIBO = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<ZhiBoInfoTW> {
        public String content;
        public Integer copythreadRemind;
        public String fieldEx;
        public Long forumId;
        public String forumName;
        public Integer freqNum;
        public Integer isCopytwzhibo;
        public Integer isHeadline;
        public Integer isHeadlineAvailable;
        public Integer isNewHeadline;
        public List<LabelInfoForLivePost> labels;
        public Long lastModifiedTime;
        public String livecoverSrc;
        public String livecoverSrcBsize;
        public LiveCoverStatus livecoverStatus;
        public Integer postNum;
        public Integer rank;
        public Integer replyNum;
        public Long threadId;
        public String title;
        public UserInfo userInfo;
        public Zan zan;

        public Builder() {
        }

        public Builder(ZhiBoInfoTW zhiBoInfoTW) {
            super(zhiBoInfoTW);
            if (zhiBoInfoTW == null) {
                return;
            }
            this.threadId = zhiBoInfoTW.threadId;
            this.livecoverSrc = zhiBoInfoTW.livecoverSrc;
            this.livecoverSrcBsize = zhiBoInfoTW.livecoverSrcBsize;
            this.postNum = zhiBoInfoTW.postNum;
            this.replyNum = zhiBoInfoTW.replyNum;
            this.zan = zhiBoInfoTW.zan;
            this.forumName = zhiBoInfoTW.forumName;
            this.forumId = zhiBoInfoTW.forumId;
            this.lastModifiedTime = zhiBoInfoTW.lastModifiedTime;
            this.title = zhiBoInfoTW.title;
            this.content = zhiBoInfoTW.content;
            this.userInfo = zhiBoInfoTW.userInfo;
            this.labels = Message.copyOf(zhiBoInfoTW.labels);
            this.rank = zhiBoInfoTW.rank;
            this.isHeadline = zhiBoInfoTW.isHeadline;
            this.isNewHeadline = zhiBoInfoTW.isNewHeadline;
            this.isHeadlineAvailable = zhiBoInfoTW.isHeadlineAvailable;
            this.livecoverStatus = zhiBoInfoTW.livecoverStatus;
            this.freqNum = zhiBoInfoTW.freqNum;
            this.copythreadRemind = zhiBoInfoTW.copythreadRemind;
            this.isCopytwzhibo = zhiBoInfoTW.isCopytwzhibo;
            this.fieldEx = zhiBoInfoTW.fieldEx;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ZhiBoInfoTW build(boolean z) {
            return new ZhiBoInfoTW(this, z);
        }
    }

    public ZhiBoInfoTW(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.threadId;
            if (l == null) {
                this.threadId = DEFAULT_THREADID;
            } else {
                this.threadId = l;
            }
            String str = builder.livecoverSrc;
            if (str == null) {
                this.livecoverSrc = "";
            } else {
                this.livecoverSrc = str;
            }
            String str2 = builder.livecoverSrcBsize;
            if (str2 == null) {
                this.livecoverSrcBsize = "";
            } else {
                this.livecoverSrcBsize = str2;
            }
            Integer num = builder.postNum;
            if (num == null) {
                this.postNum = DEFAULT_POSTNUM;
            } else {
                this.postNum = num;
            }
            Integer num2 = builder.replyNum;
            if (num2 == null) {
                this.replyNum = DEFAULT_REPLYNUM;
            } else {
                this.replyNum = num2;
            }
            this.zan = builder.zan;
            String str3 = builder.forumName;
            if (str3 == null) {
                this.forumName = "";
            } else {
                this.forumName = str3;
            }
            Long l2 = builder.forumId;
            if (l2 == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = l2;
            }
            Long l3 = builder.lastModifiedTime;
            if (l3 == null) {
                this.lastModifiedTime = DEFAULT_LASTMODIFIEDTIME;
            } else {
                this.lastModifiedTime = l3;
            }
            String str4 = builder.title;
            if (str4 == null) {
                this.title = "";
            } else {
                this.title = str4;
            }
            String str5 = builder.content;
            if (str5 == null) {
                this.content = "";
            } else {
                this.content = str5;
            }
            this.userInfo = builder.userInfo;
            List<LabelInfoForLivePost> list = builder.labels;
            if (list == null) {
                this.labels = DEFAULT_LABELS;
            } else {
                this.labels = Message.immutableCopyOf(list);
            }
            Integer num3 = builder.rank;
            if (num3 == null) {
                this.rank = DEFAULT_RANK;
            } else {
                this.rank = num3;
            }
            Integer num4 = builder.isHeadline;
            if (num4 == null) {
                this.isHeadline = DEFAULT_ISHEADLINE;
            } else {
                this.isHeadline = num4;
            }
            Integer num5 = builder.isNewHeadline;
            if (num5 == null) {
                this.isNewHeadline = DEFAULT_ISNEWHEADLINE;
            } else {
                this.isNewHeadline = num5;
            }
            Integer num6 = builder.isHeadlineAvailable;
            if (num6 == null) {
                this.isHeadlineAvailable = DEFAULT_ISHEADLINEAVAILABLE;
            } else {
                this.isHeadlineAvailable = num6;
            }
            this.livecoverStatus = builder.livecoverStatus;
            Integer num7 = builder.freqNum;
            if (num7 == null) {
                this.freqNum = DEFAULT_FREQNUM;
            } else {
                this.freqNum = num7;
            }
            Integer num8 = builder.copythreadRemind;
            if (num8 == null) {
                this.copythreadRemind = DEFAULT_COPYTHREADREMIND;
            } else {
                this.copythreadRemind = num8;
            }
            Integer num9 = builder.isCopytwzhibo;
            if (num9 == null) {
                this.isCopytwzhibo = DEFAULT_ISCOPYTWZHIBO;
            } else {
                this.isCopytwzhibo = num9;
            }
            String str6 = builder.fieldEx;
            if (str6 == null) {
                this.fieldEx = "";
                return;
            } else {
                this.fieldEx = str6;
                return;
            }
        }
        this.threadId = builder.threadId;
        this.livecoverSrc = builder.livecoverSrc;
        this.livecoverSrcBsize = builder.livecoverSrcBsize;
        this.postNum = builder.postNum;
        this.replyNum = builder.replyNum;
        this.zan = builder.zan;
        this.forumName = builder.forumName;
        this.forumId = builder.forumId;
        this.lastModifiedTime = builder.lastModifiedTime;
        this.title = builder.title;
        this.content = builder.content;
        this.userInfo = builder.userInfo;
        this.labels = Message.immutableCopyOf(builder.labels);
        this.rank = builder.rank;
        this.isHeadline = builder.isHeadline;
        this.isNewHeadline = builder.isNewHeadline;
        this.isHeadlineAvailable = builder.isHeadlineAvailable;
        this.livecoverStatus = builder.livecoverStatus;
        this.freqNum = builder.freqNum;
        this.copythreadRemind = builder.copythreadRemind;
        this.isCopytwzhibo = builder.isCopytwzhibo;
        this.fieldEx = builder.fieldEx;
    }
}
