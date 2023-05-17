package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public final class ImShareThreadInfo extends Message {
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 3)
    public final User author;
    @ProtoField(tag = 7)
    public final SimpleForum forumInfo;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer isShareThread;
    @ProtoField(label = Message.Label.REPEATED, tag = 12)
    public final List<Media> media;
    @ProtoField(tag = 9)
    public final OriginThreadInfo originThreadInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 6)
    public final List<PbContent> richAbstract;
    @ProtoField(label = Message.Label.REPEATED, tag = 5)
    public final List<PbContent> richTitle;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer threadType;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 10)
    public final VideoInfo videoInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 11)
    public final List<Voice> voiceInfo;
    public static final Integer DEFAULT_THREADTYPE = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final List<PbContent> DEFAULT_RICHTITLE = Collections.emptyList();
    public static final List<PbContent> DEFAULT_RICHABSTRACT = Collections.emptyList();
    public static final Integer DEFAULT_ISSHARETHREAD = 0;
    public static final List<Voice> DEFAULT_VOICEINFO = Collections.emptyList();
    public static final List<Media> DEFAULT_MEDIA = Collections.emptyList();

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<ImShareThreadInfo> {
        public User author;
        public SimpleForum forumInfo;
        public Long id;
        public Integer isShareThread;
        public List<Media> media;
        public OriginThreadInfo originThreadInfo;
        public List<PbContent> richAbstract;
        public List<PbContent> richTitle;
        public Integer threadType;
        public String title;
        public VideoInfo videoInfo;
        public List<Voice> voiceInfo;

        public Builder() {
        }

        public Builder(ImShareThreadInfo imShareThreadInfo) {
            super(imShareThreadInfo);
            if (imShareThreadInfo == null) {
                return;
            }
            this.threadType = imShareThreadInfo.threadType;
            this.id = imShareThreadInfo.id;
            this.author = imShareThreadInfo.author;
            this.title = imShareThreadInfo.title;
            this.richTitle = Message.copyOf(imShareThreadInfo.richTitle);
            this.richAbstract = Message.copyOf(imShareThreadInfo.richAbstract);
            this.forumInfo = imShareThreadInfo.forumInfo;
            this.isShareThread = imShareThreadInfo.isShareThread;
            this.originThreadInfo = imShareThreadInfo.originThreadInfo;
            this.videoInfo = imShareThreadInfo.videoInfo;
            this.voiceInfo = Message.copyOf(imShareThreadInfo.voiceInfo);
            this.media = Message.copyOf(imShareThreadInfo.media);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ImShareThreadInfo build(boolean z) {
            return new ImShareThreadInfo(this, z);
        }
    }

    public ImShareThreadInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.threadType;
            if (num == null) {
                this.threadType = DEFAULT_THREADTYPE;
            } else {
                this.threadType = num;
            }
            Long l = builder.id;
            if (l == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = l;
            }
            this.author = builder.author;
            String str = builder.title;
            if (str == null) {
                this.title = "";
            } else {
                this.title = str;
            }
            List<PbContent> list = builder.richTitle;
            if (list == null) {
                this.richTitle = DEFAULT_RICHTITLE;
            } else {
                this.richTitle = Message.immutableCopyOf(list);
            }
            List<PbContent> list2 = builder.richAbstract;
            if (list2 == null) {
                this.richAbstract = DEFAULT_RICHABSTRACT;
            } else {
                this.richAbstract = Message.immutableCopyOf(list2);
            }
            this.forumInfo = builder.forumInfo;
            Integer num2 = builder.isShareThread;
            if (num2 == null) {
                this.isShareThread = DEFAULT_ISSHARETHREAD;
            } else {
                this.isShareThread = num2;
            }
            this.originThreadInfo = builder.originThreadInfo;
            this.videoInfo = builder.videoInfo;
            List<Voice> list3 = builder.voiceInfo;
            if (list3 == null) {
                this.voiceInfo = DEFAULT_VOICEINFO;
            } else {
                this.voiceInfo = Message.immutableCopyOf(list3);
            }
            List<Media> list4 = builder.media;
            if (list4 == null) {
                this.media = DEFAULT_MEDIA;
                return;
            } else {
                this.media = Message.immutableCopyOf(list4);
                return;
            }
        }
        this.threadType = builder.threadType;
        this.id = builder.id;
        this.author = builder.author;
        this.title = builder.title;
        this.richTitle = Message.immutableCopyOf(builder.richTitle);
        this.richAbstract = Message.immutableCopyOf(builder.richAbstract);
        this.forumInfo = builder.forumInfo;
        this.isShareThread = builder.isShareThread;
        this.originThreadInfo = builder.originThreadInfo;
        this.videoInfo = builder.videoInfo;
        this.voiceInfo = Message.immutableCopyOf(builder.voiceInfo);
        this.media = Message.immutableCopyOf(builder.media);
    }
}
