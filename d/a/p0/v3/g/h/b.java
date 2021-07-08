package d.a.p0.v3.g.h;

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
import d.a.p0.v3.g.d.b;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements d.a.p0.v3.g.b, b.c, d.a.p0.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f65497e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.v3.b f65498f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.v3.g.d.a f65499g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f65500h;

    /* renamed from: i  reason: collision with root package name */
    public String f65501i;

    public b(d.a.p0.v3.b bVar) {
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
        this.f65498f = bVar;
        this.f65497e = bVar.f65362a;
    }

    public final void a(String str) {
        d.a.p0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f65498f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f65498f.c();
            this.f65498f = null;
            return;
        }
        this.f65501i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f65501i);
        videoInfo.setThumbPath(this.f65498f.f65364c);
        d.a.p0.v3.b bVar2 = this.f65498f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        d.a.p0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f65498f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f65498f.c();
            this.f65498f = null;
            return;
        }
        if (StringUtils.isNull(this.f65498f.f65365d)) {
            d.a.p0.v3.b bVar2 = this.f65498f;
            if (!bVar2.f65366e) {
                onSaveMusicVideo(bVar2.f65363b, -4399, "");
                return;
            }
        }
        if (this.f65500h == null) {
            this.f65500h = new SelectMusicModel(this.f65497e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f65500h;
        d.a.p0.v3.b bVar3 = this.f65498f;
        selectMusicModel.z(bVar3.f65363b, bVar3.f65365d, d.a.p0.v3.c.f65375f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f65366e);
    }

    @Override // d.a.p0.e0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.p0.v3.b bVar = this.f65498f;
            if (bVar != null) {
                bVar.i(true);
            }
            d.a.p0.v3.g.d.a aVar = this.f65499g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f65499g.e();
        }
    }

    @Override // d.a.p0.v3.g.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        d.a.p0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f65498f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // d.a.p0.v3.g.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        d.a.p0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f65498f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // d.a.p0.v3.g.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            d.a.p0.v3.b bVar = this.f65498f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // d.a.p0.v3.g.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            d.a.p0.v3.b bVar = this.f65498f;
            if (bVar != null && bVar.b()) {
                this.f65498f.c();
                this.f65498f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f65497e.showToast(R.string.mixing_fail);
                d.a.p0.v3.b bVar2 = this.f65498f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                d.a.p0.v3.b bVar3 = this.f65498f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f65498f.f65367f)) {
                    if (!StringHelper.equals(str, this.f65498f.f65363b)) {
                        this.f65498f.f65368g = str;
                    }
                    if (this.f65499g == null) {
                        d.a.p0.v3.g.d.a aVar = new d.a.p0.v3.g.d.a(this.f65497e.getActivity());
                        this.f65499g = aVar;
                        aVar.i(this);
                    }
                    this.f65499g.g(str, this.f65498f.f65367f);
                    return;
                }
                d.a.p0.v3.b bVar4 = this.f65498f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // d.a.p0.v3.g.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    @Override // d.a.p0.e0.b
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b();
        }
    }
}
