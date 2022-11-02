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
public final class ImShareThreadInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT_ID;
    public static final Integer DEFAULT_ISSHARETHREAD;
    public static final List<Media> DEFAULT_MEDIA;
    public static final List<PbContent> DEFAULT_RICHABSTRACT;
    public static final List<PbContent> DEFAULT_RICHTITLE;
    public static final Integer DEFAULT_THREADTYPE;
    public static final String DEFAULT_TITLE = "";
    public static final List<Voice> DEFAULT_VOICEINFO;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<ImShareThreadInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
        public Builder(ImShareThreadInfo imShareThreadInfo) {
            super(imShareThreadInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imShareThreadInfo};
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
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new ImShareThreadInfo(this, z, null);
            }
            return (ImShareThreadInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(309252768, "Lprotobuf/ImShareThreadInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(309252768, "Lprotobuf/ImShareThreadInfo;");
                return;
            }
        }
        DEFAULT_THREADTYPE = 0;
        DEFAULT_ID = 0L;
        DEFAULT_RICHTITLE = Collections.emptyList();
        DEFAULT_RICHABSTRACT = Collections.emptyList();
        DEFAULT_ISSHARETHREAD = 0;
        DEFAULT_VOICEINFO = Collections.emptyList();
        DEFAULT_MEDIA = Collections.emptyList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImShareThreadInfo(Builder builder, boolean z) {
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

    public /* synthetic */ ImShareThreadInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
