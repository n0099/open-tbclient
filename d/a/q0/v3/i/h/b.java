package d.a.q0.v3.i.h;

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
import d.a.q0.v3.i.d.b;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements d.a.q0.v3.i.b, b.c, d.a.q0.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f66154e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.v3.b f66155f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.v3.i.d.a f66156g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f66157h;

    /* renamed from: i  reason: collision with root package name */
    public String f66158i;

    public b(d.a.q0.v3.b bVar) {
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
        this.f66155f = bVar;
        this.f66154e = bVar.f66010a;
    }

    public final void a(String str) {
        d.a.q0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f66155f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f66155f.c();
            this.f66155f = null;
            return;
        }
        this.f66158i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f66158i);
        videoInfo.setThumbPath(this.f66155f.f66012c);
        d.a.q0.v3.b bVar2 = this.f66155f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        d.a.q0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f66155f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f66155f.c();
            this.f66155f = null;
            return;
        }
        if (StringUtils.isNull(this.f66155f.f66013d)) {
            d.a.q0.v3.b bVar2 = this.f66155f;
            if (!bVar2.f66014e) {
                onSaveMusicVideo(bVar2.f66011b, -4399, "");
                return;
            }
        }
        if (this.f66157h == null) {
            this.f66157h = new SelectMusicModel(this.f66154e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f66157h;
        d.a.q0.v3.b bVar3 = this.f66155f;
        selectMusicModel.z(bVar3.f66011b, bVar3.f66013d, d.a.q0.v3.c.f66023f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f66014e);
    }

    @Override // d.a.q0.e0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.v3.b bVar = this.f66155f;
            if (bVar != null) {
                bVar.i(true);
            }
            d.a.q0.v3.i.d.a aVar = this.f66156g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f66156g.e();
        }
    }

    @Override // d.a.q0.v3.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        d.a.q0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f66155f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // d.a.q0.v3.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        d.a.q0.v3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f66155f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // d.a.q0.v3.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            d.a.q0.v3.b bVar = this.f66155f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // d.a.q0.v3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            d.a.q0.v3.b bVar = this.f66155f;
            if (bVar != null && bVar.b()) {
                this.f66155f.c();
                this.f66155f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f66154e.showToast(R.string.mixing_fail);
                d.a.q0.v3.b bVar2 = this.f66155f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                d.a.q0.v3.b bVar3 = this.f66155f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f66155f.f66015f)) {
                    if (!StringHelper.equals(str, this.f66155f.f66011b)) {
                        this.f66155f.f66016g = str;
                    }
                    if (this.f66156g == null) {
                        d.a.q0.v3.i.d.a aVar = new d.a.q0.v3.i.d.a(this.f66154e.getActivity());
                        this.f66156g = aVar;
                        aVar.i(this);
                    }
                    this.f66156g.g(str, this.f66155f.f66015f);
                    return;
                }
                d.a.q0.v3.b bVar4 = this.f66155f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // d.a.q0.v3.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    @Override // d.a.q0.e0.b
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b();
        }
    }
}
