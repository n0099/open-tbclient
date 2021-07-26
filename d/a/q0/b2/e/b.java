package d.a.q0.b2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import java.util.Iterator;
import tbclient.ThreadInfo;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f55129e;

    /* renamed from: f  reason: collision with root package name */
    public int f55130f;

    /* renamed from: g  reason: collision with root package name */
    public int f55131g;

    /* renamed from: h  reason: collision with root package name */
    public String f55132h;

    /* renamed from: i  reason: collision with root package name */
    public int f55133i;
    public boolean j;
    public b2 k;

    public b(ThreadInfo threadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadInfo, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(threadInfo);
        this.j = z;
    }

    public final void b(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        b2 b2Var = new b2();
        this.k = b2Var;
        b2Var.K2(threadInfo);
        this.f55129e = threadInfo.title;
        this.f55130f = threadInfo.reply_num.intValue();
        this.f55131g = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.k.A0())) {
            Iterator<MediaData> it = this.k.A0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f55132h = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f55132h = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f55132h)) {
                        this.f55132h = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f55132h)) {
                        this.f55132h = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f55132h)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.f55133i = videoInfo.video_duration.intValue();
        }
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a.f55127a : (BdUniqueId) invokeV.objValue;
    }
}
