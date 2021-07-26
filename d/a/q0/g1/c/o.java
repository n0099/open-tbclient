package d.a.q0.g1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class o implements d.a.d.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f56993e;

    /* renamed from: f  reason: collision with root package name */
    public String f56994f;

    /* renamed from: g  reason: collision with root package name */
    public String f56995g;

    /* renamed from: h  reason: collision with root package name */
    public String f56996h;

    /* renamed from: i  reason: collision with root package name */
    public int f56997i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1153127026, "Ld/a/q0/g1/c/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1153127026, "Ld/a/q0/g1/c/o;");
                return;
            }
        }
        k = BdUniqueId.gen();
    }

    public o() {
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

    public void b(MediaTopic mediaTopic) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaTopic) == null) || mediaTopic == null) {
            return;
        }
        this.f56993e = mediaTopic.topic_id.longValue();
        this.f56994f = mediaTopic.topic_name;
        this.f56995g = mediaTopic.pic_url;
        VideoInfo videoInfo = mediaTopic.video_info;
        if (videoInfo == null || videoInfo.video_duration.intValue() <= 0) {
            return;
        }
        c(mediaTopic.video_info);
    }

    public void c(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoInfo) == null) {
            String str = videoInfo.video_md5;
            this.f56996h = videoInfo.video_url;
            this.f56997i = videoInfo.video_duration.intValue();
            videoInfo.video_width.intValue();
            videoInfo.video_height.intValue();
            this.j = videoInfo.thumbnail_url;
            videoInfo.thumbnail_width.intValue();
            videoInfo.thumbnail_height.intValue();
            videoInfo.video_length.intValue();
            videoInfo.play_count.intValue();
        }
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k : (BdUniqueId) invokeV.objValue;
    }
}
