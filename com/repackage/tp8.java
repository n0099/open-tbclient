package com.repackage;

import android.text.TextUtils;
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
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.repackage.gp8;
import java.util.List;
/* loaded from: classes7.dex */
public class tp8 implements bp8, gp8.c, ux5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public to8 b;
    public fp8 c;
    public SelectMusicModel d;
    public String e;

    public tp8(to8 to8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {to8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = to8Var;
        this.a = to8Var.a;
    }

    public final void a(String str) {
        to8 to8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (to8Var = this.b) == null) {
            return;
        }
        if (to8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        to8 to8Var2 = this.b;
        if (to8Var2 != null) {
            to8Var2.f(videoInfo);
        }
    }

    public void b() {
        to8 to8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (to8Var = this.b) == null) {
            return;
        }
        if (to8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            to8 to8Var2 = this.b;
            if (!to8Var2.e) {
                onSaveMusicVideo(to8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        to8 to8Var3 = this.b;
        selectMusicModel.B(to8Var3.b, to8Var3.d, uo8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !to8Var3.e);
    }

    @Override // com.repackage.ux5
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            to8 to8Var = this.b;
            if (to8Var != null) {
                to8Var.i(true);
            }
            fp8 fp8Var = this.c;
            if (fp8Var == null || !fp8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.repackage.gp8.c
    public void onGenFilterVideoFail(int i, String str) {
        to8 to8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (to8Var = this.b) == null) {
            return;
        }
        to8Var.d(i, str);
    }

    @Override // com.repackage.gp8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        to8 to8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (to8Var = this.b) == null) {
            return;
        }
        to8Var.d(i, str);
    }

    @Override // com.repackage.gp8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            to8 to8Var = this.b;
            if (to8Var != null) {
                to8Var.e();
            }
            a(str);
        }
    }

    @Override // com.repackage.bp8
    public void onSaveMusicVideo(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            to8 to8Var = this.b;
            if (to8Var != null && to8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0adb);
                to8 to8Var2 = this.b;
                if (to8Var2 != null) {
                    to8Var2.g(i, str2);
                }
            } else {
                to8 to8Var3 = this.b;
                if (to8Var3 != null) {
                    to8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        fp8 fp8Var = new fp8(this.a.getActivity());
                        this.c = fp8Var;
                        fp8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                to8 to8Var4 = this.b;
                if (to8Var4 != null) {
                    to8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.repackage.bp8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
