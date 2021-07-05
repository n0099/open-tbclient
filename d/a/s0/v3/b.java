package d.a.s0.v3;

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
/* loaded from: classes9.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f68580a;

    /* renamed from: b  reason: collision with root package name */
    public String f68581b;

    /* renamed from: c  reason: collision with root package name */
    public String f68582c;

    /* renamed from: d  reason: collision with root package name */
    public String f68583d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68584e;

    /* renamed from: f  reason: collision with root package name */
    public String f68585f;

    /* renamed from: g  reason: collision with root package name */
    public String f68586g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68587h;

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
        this.f68581b = str;
        this.f68582c = str2;
        this.f68580a = baseActivity;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || k.isEmpty(this.f68586g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f68586g));
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68587h : invokeV.booleanValue;
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
            this.f68587h = z;
        }
    }

    public void j(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, editVideoData) == null) || editVideoData == null) {
            return;
        }
        this.f68581b = editVideoData.originPath;
        this.f68582c = editVideoData.coverPath;
        this.f68583d = editVideoData.musicPath;
        this.f68584e = editVideoData.isMute;
        this.f68585f = editVideoData.filterName;
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
            this.f68581b = editVideoData.originPath;
            this.f68582c = editVideoData.coverPath;
            this.f68583d = editVideoData.musicPath;
            this.f68584e = editVideoData.isMute;
            this.f68585f = editVideoData.filterName;
        }
        this.f68580a = baseActivity;
    }
}
