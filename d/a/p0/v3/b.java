package d.a.p0.v3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import java.io.File;
/* loaded from: classes8.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f65362a;

    /* renamed from: b  reason: collision with root package name */
    public String f65363b;

    /* renamed from: c  reason: collision with root package name */
    public String f65364c;

    /* renamed from: d  reason: collision with root package name */
    public String f65365d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65366e;

    /* renamed from: f  reason: collision with root package name */
    public String f65367f;

    /* renamed from: g  reason: collision with root package name */
    public String f65368g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65369h;

    public b(BaseActivity baseActivity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65363b = str;
        this.f65364c = str2;
        this.f65362a = baseActivity;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || k.isEmpty(this.f65368g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f65368g));
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65369h : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
        }
    }

    public void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            a();
        }
    }

    public abstract void e();

    public void f(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoInfo) == null) {
            a();
        }
    }

    public void g(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            a();
        }
    }

    public abstract void h();

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f65369h = z;
        }
    }

    public void j(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, editVideoData) == null) || editVideoData == null) {
            return;
        }
        this.f65363b = editVideoData.originPath;
        this.f65364c = editVideoData.coverPath;
        this.f65365d = editVideoData.musicPath;
        this.f65366e = editVideoData.isMute;
        this.f65367f = editVideoData.filterName;
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, editVideoData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (editVideoData != null) {
            this.f65363b = editVideoData.originPath;
            this.f65364c = editVideoData.coverPath;
            this.f65365d = editVideoData.musicPath;
            this.f65366e = editVideoData.isMute;
            this.f65367f = editVideoData.filterName;
        }
        this.f65362a = baseActivity;
    }
}
