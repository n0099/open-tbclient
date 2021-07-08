package d.a.p0.a0.d0;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.p0.n2.e;
import d.a.p0.n2.f;
/* loaded from: classes7.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlaVideoContainer f53789e;

    /* renamed from: f  reason: collision with root package name */
    public b2 f53790f;

    /* renamed from: g  reason: collision with root package name */
    public AlaInfoData f53791g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53792h;

    /* renamed from: i  reason: collision with root package name */
    public f f53793i;
    public f.b j;

    /* renamed from: d.a.p0.a0.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1247a implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53794a;

        public C1247a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53794a = aVar;
        }

        @Override // d.a.p0.n2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53794a.b();
            }
        }
    }

    public a(AlaVideoContainer alaVideoContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaVideoContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53792h = false;
        this.j = new C1247a(this);
        this.f53789e = alaVideoContainer;
        if (alaVideoContainer != null) {
            f fVar = new f();
            this.f53793i = fVar;
            fVar.l(this.f53789e.getVideoView());
            this.f53793i.i(this.j);
        }
    }

    @Override // d.a.p0.n2.e
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (b2Var = this.f53790f) == null || b2Var.l1() == null) {
        }
    }

    public void c() {
        AlaVideoContainer alaVideoContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alaVideoContainer = this.f53789e) == null) {
            return;
        }
        alaVideoContainer.q();
    }

    public void d(b2 b2Var, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{b2Var, str, str2, Boolean.valueOf(z)}) == null) || b2Var == null) {
            return;
        }
        this.f53790f = b2Var;
        if (this.f53789e == null || b2Var.g1() == null) {
            return;
        }
        AlaInfoData g1 = this.f53790f.g1();
        this.f53791g = g1;
        this.f53789e.setVideoThumbnail(g1.cover);
        if (z) {
            this.f53789e.setTitle(this.f53790f.getTitle());
        } else {
            this.f53789e.setTitle("");
        }
        AlaVideoContainer alaVideoContainer = this.f53789e;
        alaVideoContainer.setPlayCount(String.format(alaVideoContainer.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.f53790f.g1().audience_count)));
    }

    @Override // d.a.p0.n2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f53789e;
            if (alaVideoContainer == null || alaVideoContainer.getVideoView() == null) {
                return 0;
            }
            return this.f53789e.getVideoView().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.n2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b2 b2Var = this.f53790f;
            if (b2Var == null || b2Var.l1() == null) {
                return null;
            }
            return this.f53790f.l1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AlaVideoContainer alaVideoContainer = this.f53789e;
            if (alaVideoContainer != null) {
                return alaVideoContainer.getView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f53792h : invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // d.a.p0.n2.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AlaVideoContainer alaVideoContainer = this.f53789e;
            if (alaVideoContainer != null && alaVideoContainer.getVideoView() != null) {
                this.f53789e.getVideoView().stopPlayback();
                this.f53789e.p();
                f fVar = this.f53793i;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.f53792h = false;
        }
    }
}
