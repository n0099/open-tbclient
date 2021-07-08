package d.a.p0.n2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f60799a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60800b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f60801c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f60802d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f60803e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f60804f;

    public m(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60799a = viewGroup;
        this.f60800b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f60801c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f60802d.cancel();
            this.f60803e.cancel();
            this.f60804f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f60799a.setVisibility(8);
            this.f60801c.h();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f60803e.start();
            this.f60804f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f60802d = ObjectAnimator.ofFloat(this.f60800b, "alpha", 1.0f, 0.5f);
            this.f60803e = ObjectAnimator.ofFloat(this.f60800b, "alpha", 0.5f, 0.0f);
            this.f60804f = ObjectAnimator.ofFloat(this.f60801c, "alpha", 1.0f, 0.0f);
            this.f60802d.setDuration(50L);
            this.f60803e.setDuration(50L);
            this.f60804f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f60801c.j();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f60801c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f60800b.setAlpha(1.0f);
            this.f60801c.setAlpha(1.0f);
            this.f60799a.setVisibility(0);
            this.f60801c.l();
            this.f60802d.start();
        }
    }
}
