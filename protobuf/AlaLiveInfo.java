package protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class AlaLiveInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_AUDIENCECOUNT;
    public static final String DEFAULT_COVER = "";
    public static final String DEFAULT_COVERWIDE = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final List<DislikeInfo> DEFAULT_DISLIKEINFO;
    public static final Long DEFAULT_DISTANCE;
    public static final Integer DEFAULT_DURATION;
    public static final String DEFAULT_FIRSTHEADLINE = "";
    public static final String DEFAULT_FORUMUSERLIVEMSG = "";
    public static final Integer DEFAULT_FRSTOPLIVEFORCE;
    public static final String DEFAULT_FRSTOPLIVEPIC = "";
    public static final Integer DEFAULT_FRSTOPLIVETYPE;
    public static final Long DEFAULT_GROUPID;
    public static final String DEFAULT_HLSURL = "";
    public static final String DEFAULT_LABELNAME = "";
    public static final Integer DEFAULT_LIVEFROM;
    public static final Long DEFAULT_LIVEID;
    public static final Integer DEFAULT_LIVESTATUS;
    public static final Integer DEFAULT_LIVETYPE;
    public static final String DEFAULT_MEDIAID = "";
    public static final String DEFAULT_MEDIAPIC = "";
    public static final String DEFAULT_MEDIASUBTITLE = "";
    public static final String DEFAULT_MEDIAURL = "";
    public static final Integer DEFAULT_OPENRECOMDURATION;
    public static final Integer DEFAULT_OPENRECOMFANS;
    public static final Integer DEFAULT_OPENRECOMLOCATION;
    public static final Integer DEFAULT_OPENRECOMREASON;
    public static final Integer DEFAULT_PBDISPLAYTYPE;
    public static final String DEFAULT_RECOMREASON = "";
    public static final Long DEFAULT_ROOMID;
    public static final String DEFAULT_ROOMNAME = "";
    public static final Integer DEFAULT_ROOMSTATUS;
    public static final String DEFAULT_ROUTERTYPE = "";
    public static final String DEFAULT_RTMPURL = "";
    public static final Integer DEFAULT_SCREENDIRECTION;
    public static final String DEFAULT_SECONDHEADLINE = "";
    public static final String DEFAULT_SESSIONID = "";
    public static final List<AlaStageDislikeInfo> DEFAULT_STAGEDISLIKEINFO;
    public static final String DEFAULT_THIRDAPPID = "";
    public static final String DEFAULT_THIRDLIVETYPE = "";
    public static final String DEFAULT_THIRDROOMID = "";
    public static final Long DEFAULT_THREADID;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 14, type = Message.Datatype.UINT32)
    public final Integer audienceCount;
    @ProtoField(tag = 25)
    public final AlaChallengeInfo challengeInfo;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cover;
    @ProtoField(tag = 48, type = Message.Datatype.STRING)
    public final String coverWide;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(label = Message.Label.REPEATED, tag = 43)
    public final List<DislikeInfo> dislikeInfo;
    @ProtoField(tag = 20, type = Message.Datatype.UINT64)
    public final Long distance;
    @ProtoField(tag = 13, type = Message.Datatype.UINT32)
    public final Integer duration;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String firstHeadline;
    @ProtoField(tag = 47, type = Message.Datatype.STRING)
    public final String forumUserLiveMsg;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer frsTopliveForce;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String frsToplivePic;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer frsTopliveType;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long groupId;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String hlsUrl;
    @ProtoField(tag = 24)
    public final AlaCoverLabel label;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String labelName;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer liveFrom;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long liveId;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer liveStatus;
    @ProtoField(tag = 15, type = Message.Datatype.UINT32)
    public final Integer liveType;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String mediaId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String mediaPic;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String mediaSubtitle;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String mediaUrl;
    @ProtoField(tag = 41, type = Message.Datatype.UINT32)
    public final Integer openRecomDuration;
    @ProtoField(tag = 40, type = Message.Datatype.UINT32)
    public final Integer openRecomFans;
    @ProtoField(tag = 39, type = Message.Datatype.UINT32)
    public final Integer openRecomLocation;
    @ProtoField(tag = 38, type = Message.Datatype.UINT32)
    public final Integer openRecomReason;
    @ProtoField(tag = 36, type = Message.Datatype.UINT32)
    public final Integer pbDisplayType;
    @ProtoField(tag = 37, type = Message.Datatype.STRING)
    public final String recomReason;
    @ProtoField(tag = 44, type = Message.Datatype.UINT64)
    public final Long roomId;
    @ProtoField(tag = 46, type = Message.Datatype.STRING)
    public final String roomName;
    @ProtoField(tag = 45, type = Message.Datatype.INT32)
    public final Integer roomStatus;
    @ProtoField(tag = 32, type = Message.Datatype.STRING)
    public final String routerType;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String rtmpUrl;
    @ProtoField(tag = 16, type = Message.Datatype.UINT32)
    public final Integer screenDirection;
    @ProtoField(tag = 35, type = Message.Datatype.STRING)
    public final String secondHeadline;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String sessionId;
    @ProtoField(tag = 19)
    public final AlaShareInfo shareInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 23)
    public final List<AlaStageDislikeInfo> stageDislikeInfo;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String thirdAppId;
    @ProtoField(tag = 33, type = Message.Datatype.STRING)
    public final String thirdLiveType;
    @ProtoField(tag = 31, type = Message.Datatype.STRING)
    public final String thirdRoomId;
    @ProtoField(tag = 22, type = Message.Datatype.UINT64)
    public final Long threadId;
    @ProtoField(tag = 12)
    public final AlaUserInfo userInfo;
    @ProtoField(tag = 49)
    public final YyExt yyExt;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<AlaLiveInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer audienceCount;
        public AlaChallengeInfo challengeInfo;
        public String cover;
        public String coverWide;
        public String description;
        public List<DislikeInfo> dislikeInfo;
        public Long distance;
        public Integer duration;
        public String firstHeadline;
        public String forumUserLiveMsg;
        public Integer frsTopliveForce;
        public String frsToplivePic;
        public Integer frsTopliveType;
        public Long groupId;
        public String hlsUrl;
        public AlaCoverLabel label;
        public String labelName;
        public Integer liveFrom;
        public Long liveId;
        public Integer liveStatus;
        public Integer liveType;
        public String mediaId;
        public String mediaPic;
        public String mediaSubtitle;
        public String mediaUrl;
        public Integer openRecomDuration;
        public Integer openRecomFans;
        public Integer openRecomLocation;
        public Integer openRecomReason;
        public Integer pbDisplayType;
        public String recomReason;
        public Long roomId;
        public String roomName;
        public Integer roomStatus;
        public String routerType;
        public String rtmpUrl;
        public Integer screenDirection;
        public String secondHeadline;
        public String sessionId;
        public AlaShareInfo shareInfo;
        public List<AlaStageDislikeInfo> stageDislikeInfo;
        public String thirdAppId;
        public String thirdLiveType;
        public String thirdRoomId;
        public Long threadId;
        public AlaUserInfo userInfo;
        public YyExt yyExt;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(AlaLiveInfo alaLiveInfo) {
            super(alaLiveInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveInfo};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (alaLiveInfo == null) {
                return;
            }
            this.liveId = alaLiveInfo.liveId;
            this.cover = alaLiveInfo.cover;
            this.sessionId = alaLiveInfo.sessionId;
            this.rtmpUrl = alaLiveInfo.rtmpUrl;
            this.hlsUrl = alaLiveInfo.hlsUrl;
            this.groupId = alaLiveInfo.groupId;
            this.mediaUrl = alaLiveInfo.mediaUrl;
            this.mediaPic = alaLiveInfo.mediaPic;
            this.mediaId = alaLiveInfo.mediaId;
            this.mediaSubtitle = alaLiveInfo.mediaSubtitle;
            this.description = alaLiveInfo.description;
            this.userInfo = alaLiveInfo.userInfo;
            this.duration = alaLiveInfo.duration;
            this.audienceCount = alaLiveInfo.audienceCount;
            this.liveType = alaLiveInfo.liveType;
            this.screenDirection = alaLiveInfo.screenDirection;
            this.labelName = alaLiveInfo.labelName;
            this.liveStatus = alaLiveInfo.liveStatus;
            this.shareInfo = alaLiveInfo.shareInfo;
            this.distance = alaLiveInfo.distance;
            this.thirdAppId = alaLiveInfo.thirdAppId;
            this.threadId = alaLiveInfo.threadId;
            this.stageDislikeInfo = Message.copyOf(alaLiveInfo.stageDislikeInfo);
            this.label = alaLiveInfo.label;
            this.challengeInfo = alaLiveInfo.challengeInfo;
            this.frsTopliveType = alaLiveInfo.frsTopliveType;
            this.frsToplivePic = alaLiveInfo.frsToplivePic;
            this.frsTopliveForce = alaLiveInfo.frsTopliveForce;
            this.liveFrom = alaLiveInfo.liveFrom;
            this.thirdRoomId = alaLiveInfo.thirdRoomId;
            this.routerType = alaLiveInfo.routerType;
            this.thirdLiveType = alaLiveInfo.thirdLiveType;
            this.firstHeadline = alaLiveInfo.firstHeadline;
            this.secondHeadline = alaLiveInfo.secondHeadline;
            this.pbDisplayType = alaLiveInfo.pbDisplayType;
            this.recomReason = alaLiveInfo.recomReason;
            this.openRecomReason = alaLiveInfo.openRecomReason;
            this.openRecomLocation = alaLiveInfo.openRecomLocation;
            this.openRecomFans = alaLiveInfo.openRecomFans;
            this.openRecomDuration = alaLiveInfo.openRecomDuration;
            this.dislikeInfo = Message.copyOf(alaLiveInfo.dislikeInfo);
            this.roomId = alaLiveInfo.roomId;
            this.roomStatus = alaLiveInfo.roomStatus;
            this.roomName = alaLiveInfo.roomName;
            this.forumUserLiveMsg = alaLiveInfo.forumUserLiveMsg;
            this.coverWide = alaLiveInfo.coverWide;
            this.yyExt = alaLiveInfo.yyExt;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaLiveInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new AlaLiveInfo(this, z, null);
            }
            return (AlaLiveInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(195366435, "Lprotobuf/AlaLiveInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(195366435, "Lprotobuf/AlaLiveInfo;");
                return;
            }
        }
        DEFAULT_LIVEID = 0L;
        DEFAULT_GROUPID = 0L;
        DEFAULT_DURATION = 0;
        DEFAULT_AUDIENCECOUNT = 0;
        DEFAULT_LIVETYPE = 0;
        DEFAULT_SCREENDIRECTION = 0;
        DEFAULT_LIVESTATUS = 0;
        DEFAULT_DISTANCE = 0L;
        DEFAULT_THREADID = 0L;
        DEFAULT_STAGEDISLIKEINFO = Collections.emptyList();
        DEFAULT_FRSTOPLIVETYPE = 0;
        DEFAULT_FRSTOPLIVEFORCE = 0;
        DEFAULT_LIVEFROM = 0;
        DEFAULT_PBDISPLAYTYPE = 0;
        DEFAULT_OPENRECOMREASON = 0;
        DEFAULT_OPENRECOMLOCATION = 0;
        DEFAULT_OPENRECOMFANS = 0;
        DEFAULT_OPENRECOMDURATION = 0;
        DEFAULT_DISLIKEINFO = Collections.emptyList();
        DEFAULT_ROOMID = 0L;
        DEFAULT_ROOMSTATUS = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveInfo(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            Long l = builder.liveId;
            if (l == null) {
                this.liveId = DEFAULT_LIVEID;
            } else {
                this.liveId = l;
            }
            String str = builder.cover;
            if (str == null) {
                this.cover = "";
            } else {
                this.cover = str;
            }
            String str2 = builder.sessionId;
            if (str2 == null) {
                this.sessionId = "";
            } else {
                this.sessionId = str2;
            }
            String str3 = builder.rtmpUrl;
            if (str3 == null) {
                this.rtmpUrl = "";
            } else {
                this.rtmpUrl = str3;
            }
            String str4 = builder.hlsUrl;
            if (str4 == null) {
                this.hlsUrl = "";
            } else {
                this.hlsUrl = str4;
            }
            Long l2 = builder.groupId;
            if (l2 == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l2;
            }
            String str5 = builder.mediaUrl;
            if (str5 == null) {
                this.mediaUrl = "";
            } else {
                this.mediaUrl = str5;
            }
            String str6 = builder.mediaPic;
            if (str6 == null) {
                this.mediaPic = "";
            } else {
                this.mediaPic = str6;
            }
            String str7 = builder.mediaId;
            if (str7 == null) {
                this.mediaId = "";
            } else {
                this.mediaId = str7;
            }
            String str8 = builder.mediaSubtitle;
            if (str8 == null) {
                this.mediaSubtitle = "";
            } else {
                this.mediaSubtitle = str8;
            }
            String str9 = builder.description;
            if (str9 == null) {
                this.description = "";
            } else {
                this.description = str9;
            }
            this.userInfo = builder.userInfo;
            Integer num = builder.duration;
            if (num == null) {
                this.duration = DEFAULT_DURATION;
            } else {
                this.duration = num;
            }
            Integer num2 = builder.audienceCount;
            if (num2 == null) {
                this.audienceCount = DEFAULT_AUDIENCECOUNT;
            } else {
                this.audienceCount = num2;
            }
            Integer num3 = builder.liveType;
            if (num3 == null) {
                this.liveType = DEFAULT_LIVETYPE;
            } else {
                this.liveType = num3;
            }
            Integer num4 = builder.screenDirection;
            if (num4 == null) {
                this.screenDirection = DEFAULT_SCREENDIRECTION;
            } else {
                this.screenDirection = num4;
            }
            String str10 = builder.labelName;
            if (str10 == null) {
                this.labelName = "";
            } else {
                this.labelName = str10;
            }
            Integer num5 = builder.liveStatus;
            if (num5 == null) {
                this.liveStatus = DEFAULT_LIVESTATUS;
            } else {
                this.liveStatus = num5;
            }
            this.shareInfo = builder.shareInfo;
            Long l3 = builder.distance;
            if (l3 == null) {
                this.distance = DEFAULT_DISTANCE;
            } else {
                this.distance = l3;
            }
            String str11 = builder.thirdAppId;
            if (str11 == null) {
                this.thirdAppId = "";
            } else {
                this.thirdAppId = str11;
            }
            Long l4 = builder.threadId;
            if (l4 == null) {
                this.threadId = DEFAULT_THREADID;
            } else {
                this.threadId = l4;
            }
            List<AlaStageDislikeInfo> list = builder.stageDislikeInfo;
            if (list == null) {
                this.stageDislikeInfo = DEFAULT_STAGEDISLIKEINFO;
            } else {
                this.stageDislikeInfo = Message.immutableCopyOf(list);
            }
            this.label = builder.label;
            this.challengeInfo = builder.challengeInfo;
            Integer num6 = builder.frsTopliveType;
            if (num6 == null) {
                this.frsTopliveType = DEFAULT_FRSTOPLIVETYPE;
            } else {
                this.frsTopliveType = num6;
            }
            String str12 = builder.frsToplivePic;
            if (str12 == null) {
                this.frsToplivePic = "";
            } else {
                this.frsToplivePic = str12;
            }
            Integer num7 = builder.frsTopliveForce;
            if (num7 == null) {
                this.frsTopliveForce = DEFAULT_FRSTOPLIVEFORCE;
            } else {
                this.frsTopliveForce = num7;
            }
            Integer num8 = builder.liveFrom;
            if (num8 == null) {
                this.liveFrom = DEFAULT_LIVEFROM;
            } else {
                this.liveFrom = num8;
            }
            String str13 = builder.thirdRoomId;
            if (str13 == null) {
                this.thirdRoomId = "";
            } else {
                this.thirdRoomId = str13;
            }
            String str14 = builder.routerType;
            if (str14 == null) {
                this.routerType = "";
            } else {
                this.routerType = str14;
            }
            String str15 = builder.thirdLiveType;
            if (str15 == null) {
                this.thirdLiveType = "";
            } else {
                this.thirdLiveType = str15;
            }
            String str16 = builder.firstHeadline;
            if (str16 == null) {
                this.firstHeadline = "";
            } else {
                this.firstHeadline = str16;
            }
            String str17 = builder.secondHeadline;
            if (str17 == null) {
                this.secondHeadline = "";
            } else {
                this.secondHeadline = str17;
            }
            Integer num9 = builder.pbDisplayType;
            if (num9 == null) {
                this.pbDisplayType = DEFAULT_PBDISPLAYTYPE;
            } else {
                this.pbDisplayType = num9;
            }
            String str18 = builder.recomReason;
            if (str18 == null) {
                this.recomReason = "";
            } else {
                this.recomReason = str18;
            }
            Integer num10 = builder.openRecomReason;
            if (num10 == null) {
                this.openRecomReason = DEFAULT_OPENRECOMREASON;
            } else {
                this.openRecomReason = num10;
            }
            Integer num11 = builder.openRecomLocation;
            if (num11 == null) {
                this.openRecomLocation = DEFAULT_OPENRECOMLOCATION;
            } else {
                this.openRecomLocation = num11;
            }
            Integer num12 = builder.openRecomFans;
            if (num12 == null) {
                this.openRecomFans = DEFAULT_OPENRECOMFANS;
            } else {
                this.openRecomFans = num12;
            }
            Integer num13 = builder.openRecomDuration;
            if (num13 == null) {
                this.openRecomDuration = DEFAULT_OPENRECOMDURATION;
            } else {
                this.openRecomDuration = num13;
            }
            List<DislikeInfo> list2 = builder.dislikeInfo;
            if (list2 == null) {
                this.dislikeInfo = DEFAULT_DISLIKEINFO;
            } else {
                this.dislikeInfo = Message.immutableCopyOf(list2);
            }
            Long l5 = builder.roomId;
            if (l5 == null) {
                this.roomId = DEFAULT_ROOMID;
            } else {
                this.roomId = l5;
            }
            Integer num14 = builder.roomStatus;
            if (num14 == null) {
                this.roomStatus = DEFAULT_ROOMSTATUS;
            } else {
                this.roomStatus = num14;
            }
            String str19 = builder.roomName;
            if (str19 == null) {
                this.roomName = "";
            } else {
                this.roomName = str19;
            }
            String str20 = builder.forumUserLiveMsg;
            if (str20 == null) {
                this.forumUserLiveMsg = "";
            } else {
                this.forumUserLiveMsg = str20;
            }
            String str21 = builder.coverWide;
            if (str21 == null) {
                this.coverWide = "";
            } else {
                this.coverWide = str21;
            }
            this.yyExt = builder.yyExt;
            return;
        }
        this.liveId = builder.liveId;
        this.cover = builder.cover;
        this.sessionId = builder.sessionId;
        this.rtmpUrl = builder.rtmpUrl;
        this.hlsUrl = builder.hlsUrl;
        this.groupId = builder.groupId;
        this.mediaUrl = builder.mediaUrl;
        this.mediaPic = builder.mediaPic;
        this.mediaId = builder.mediaId;
        this.mediaSubtitle = builder.mediaSubtitle;
        this.description = builder.description;
        this.userInfo = builder.userInfo;
        this.duration = builder.duration;
        this.audienceCount = builder.audienceCount;
        this.liveType = builder.liveType;
        this.screenDirection = builder.screenDirection;
        this.labelName = builder.labelName;
        this.liveStatus = builder.liveStatus;
        this.shareInfo = builder.shareInfo;
        this.distance = builder.distance;
        this.thirdAppId = builder.thirdAppId;
        this.threadId = builder.threadId;
        this.stageDislikeInfo = Message.immutableCopyOf(builder.stageDislikeInfo);
        this.label = builder.label;
        this.challengeInfo = builder.challengeInfo;
        this.frsTopliveType = builder.frsTopliveType;
        this.frsToplivePic = builder.frsToplivePic;
        this.frsTopliveForce = builder.frsTopliveForce;
        this.liveFrom = builder.liveFrom;
        this.thirdRoomId = builder.thirdRoomId;
        this.routerType = builder.routerType;
        this.thirdLiveType = builder.thirdLiveType;
        this.firstHeadline = builder.firstHeadline;
        this.secondHeadline = builder.secondHeadline;
        this.pbDisplayType = builder.pbDisplayType;
        this.recomReason = builder.recomReason;
        this.openRecomReason = builder.openRecomReason;
        this.openRecomLocation = builder.openRecomLocation;
        this.openRecomFans = builder.openRecomFans;
        this.openRecomDuration = builder.openRecomDuration;
        this.dislikeInfo = Message.immutableCopyOf(builder.dislikeInfo);
        this.roomId = builder.roomId;
        this.roomStatus = builder.roomStatus;
        this.roomName = builder.roomName;
        this.forumUserLiveMsg = builder.forumUserLiveMsg;
        this.coverWide = builder.coverWide;
        this.yyExt = builder.yyExt;
    }

    public /* synthetic */ AlaLiveInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
