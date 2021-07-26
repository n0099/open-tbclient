package d.a.q0.x3.d;

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
import d.a.q0.x3.c.d;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66945a;

    /* renamed from: b  reason: collision with root package name */
    public int f66946b;

    /* renamed from: c  reason: collision with root package name */
    public d f66947c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayView.d f66948d;

    /* renamed from: e  reason: collision with root package name */
    public int f66949e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f66950f;

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
        this.f66945a = 0;
        this.f66946b = 0;
        this.f66950f = new HashSet();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66949e = Math.min(7, TbConfig.PREFETCH_NEXT_VIDEO_NUM);
            this.f66946b = this.f66945a + 1;
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f66947c == null || this.f66949e <= 0) {
            return;
        }
        while (this.f66946b < this.f66947c.i()) {
            VideoItemData o = this.f66947c.o(this.f66946b);
            this.f66946b++;
            if (o != null && !TextUtils.isEmpty(o.video_url)) {
                this.f66949e--;
                if (!this.f66950f.contains(o.video_url)) {
                    CyberPlayerManager.prefetch(o.video_url, null, null, TbConfig.PREFETCH_NEXT_VIDEO_SIZE, null);
                    this.f66950f.add(o.video_url);
                }
                if (this.f66949e <= 0) {
                    break;
                }
            }
        }
        if (this.f66949e <= 0 || this.f66948d == null || this.f66947c.i() - this.f66945a >= 10) {
            return;
        }
        this.f66948d.a();
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f66945a = i2;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f66947c = dVar;
        }
    }

    public void e(VideoPlayView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f66948d = dVar;
        }
    }
}
