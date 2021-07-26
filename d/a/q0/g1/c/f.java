package d.a.q0.g1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Hottopic.TopicInfo;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class f implements d.a.d.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f56960e;

    /* renamed from: f  reason: collision with root package name */
    public String f56961f;

    /* renamed from: g  reason: collision with root package name */
    public String f56962g;

    /* renamed from: h  reason: collision with root package name */
    public long f56963h;

    /* renamed from: i  reason: collision with root package name */
    public String f56964i;
    public String j;
    public String k;
    public long l;
    public String m;
    public String n;
    public Long o;
    public Integer p;
    public h q;
    public String r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1153126747, "Ld/a/q0/g1/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1153126747, "Ld/a/q0/g1/c/f;");
                return;
            }
        }
        s = BdUniqueId.gen();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void b(TopicInfo topicInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, topicInfo) == null) || topicInfo == null) {
            return;
        }
        this.f56960e = String.valueOf(topicInfo.topic_id);
        this.f56961f = topicInfo.topic_name;
        this.f56962g = topicInfo.desc;
        this.f56963h = topicInfo.total_post_num.longValue();
        this.f56964i = topicInfo.head_photo_url;
        this.j = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
        this.k = topicInfo.share_pic;
        this.l = topicInfo.idx_num.longValue();
        this.o = topicInfo.pmy_topic_id;
        this.r = topicInfo.head_photo_jump_url;
        this.p = topicInfo.pmy_source;
        VideoInfo videoInfo = topicInfo.video_info;
        if (videoInfo != null && !StringUtils.isNull(videoInfo.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
            VideoInfo videoInfo2 = topicInfo.video_info;
            String str = videoInfo2.video_md5;
            this.m = videoInfo2.video_url;
            videoInfo2.video_duration.intValue();
            topicInfo.video_info.video_width.intValue();
            topicInfo.video_info.video_height.intValue();
            VideoInfo videoInfo3 = topicInfo.video_info;
            String str2 = videoInfo3.thumbnail_url;
            videoInfo3.thumbnail_width.intValue();
            topicInfo.video_info.thumbnail_height.intValue();
            topicInfo.video_info.video_length.intValue();
            topicInfo.video_info.play_count.intValue();
        }
        this.n = topicInfo.tag_list_type;
        if (topicInfo.join_info != null) {
            h hVar = new h();
            this.q = hVar;
            hVar.a(topicInfo.join_info);
        }
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? s : (BdUniqueId) invokeV.objValue;
    }
}
