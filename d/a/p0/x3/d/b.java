package d.a.p0.x3.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.x3.c.d;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66269a;

    /* renamed from: b  reason: collision with root package name */
    public int f66270b;

    /* renamed from: c  reason: collision with root package name */
    public d f66271c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.d f66272d;

    /* renamed from: e  reason: collision with root package name */
    public int f66273e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f66274f;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66269a = 0;
        this.f66270b = 0;
        this.f66274f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66273e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f66270b = this.f66269a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f66271c == null || this.f66273e <= 0) {
            return;
        }
        while (this.f66270b < this.f66271c.h()) {
            VideoItemData n = this.f66271c.n(this.f66270b);
            this.f66270b++;
            if (n != null && !TextUtils.isEmpty(n.video_url)) {
                this.f66273e--;
                if (!this.f66274f.contains(n.video_url)) {
                    CyberPlayerManager.prefetch(n.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f66274f.add(n.video_url);
                }
                if (this.f66273e <= 0) {
                    break;
                }
            }
        }
        if (this.f66273e <= 0 || this.f66272d == null || this.f66271c.h() - this.f66269a >= 10) {
            return;
        }
        this.f66272d.a();
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f66269a = i2;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f66271c = dVar;
        }
    }

    public void e(VideoPlayView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f66272d = dVar;
        }
    }
}
