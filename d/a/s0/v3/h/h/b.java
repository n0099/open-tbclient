package d.a.s0.v3.h.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.v3.h.d.b;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements d.a.s0.v3.h.b, b.c, d.a.s0.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f68713e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.v3.b f68714f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.v3.h.d.a f68715g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f68716h;

    /* renamed from: i  reason: collision with root package name */
    public String f68717i;

    public b(d.a.s0.v3.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68714f = bVar;
        this.f68713e = bVar.f68580a;
    }

    public final void a(String str) {
        d.a.s0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f68714f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f68714f.c();
            this.f68714f = null;
            return;
        }
        this.f68717i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f68717i);
        videoInfo.setThumbPath(this.f68714f.f68582c);
        d.a.s0.v3.b bVar2 = this.f68714f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        d.a.s0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f68714f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f68714f.c();
            this.f68714f = null;
            return;
        }
        if (StringUtils.isNull(this.f68714f.f68583d)) {
            d.a.s0.v3.b bVar2 = this.f68714f;
            if (!bVar2.f68584e) {
                onSaveMusicVideo(bVar2.f68581b, -4399, "");
                return;
            }
        }
        if (this.f68716h == null) {
            this.f68716h = new SelectMusicModel(this.f68713e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f68716h;
        d.a.s0.v3.b bVar3 = this.f68714f;
        selectMusicModel.z(bVar3.f68581b, bVar3.f68583d, d.a.s0.v3.c.f68591d + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f68584e);
    }

    @Override // d.a.s0.e0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.s0.v3.b bVar = this.f68714f;
            if (bVar != null) {
                bVar.i(true);
            }
            d.a.s0.v3.h.d.a aVar = this.f68715g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f68715g.e();
        }
    }

    @Override // d.a.s0.v3.h.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        d.a.s0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f68714f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // d.a.s0.v3.h.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        d.a.s0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f68714f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // d.a.s0.v3.h.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            d.a.s0.v3.b bVar = this.f68714f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // d.a.s0.v3.h.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            d.a.s0.v3.b bVar = this.f68714f;
            if (bVar != null && bVar.b()) {
                this.f68714f.c();
                this.f68714f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f68713e.showToast(R.string.mixing_fail);
                d.a.s0.v3.b bVar2 = this.f68714f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                d.a.s0.v3.b bVar3 = this.f68714f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f68714f.f68585f)) {
                    if (!StringHelper.equals(str, this.f68714f.f68581b)) {
                        this.f68714f.f68586g = str;
                    }
                    if (this.f68715g == null) {
                        d.a.s0.v3.h.d.a aVar = new d.a.s0.v3.h.d.a(this.f68713e.getActivity());
                        this.f68715g = aVar;
                        aVar.i(this);
                    }
                    this.f68715g.g(str, this.f68714f.f68585f);
                    return;
                }
                d.a.s0.v3.b bVar4 = this.f68714f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // d.a.s0.v3.h.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    @Override // d.a.s0.e0.b
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b();
        }
    }
}
