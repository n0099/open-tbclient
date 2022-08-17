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
import com.repackage.bt8;
import java.util.List;
/* loaded from: classes7.dex */
public class ot8 implements ws8, bt8.c, j16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public os8 b;
    public at8 c;
    public SelectMusicModel d;
    public String e;

    public ot8(os8 os8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {os8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = os8Var;
        this.a = os8Var.a;
    }

    public final void a(String str) {
        os8 os8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (os8Var = this.b) == null) {
            return;
        }
        if (os8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        os8 os8Var2 = this.b;
        if (os8Var2 != null) {
            os8Var2.f(videoInfo);
        }
    }

    public void b() {
        os8 os8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (os8Var = this.b) == null) {
            return;
        }
        if (os8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            os8 os8Var2 = this.b;
            if (!os8Var2.e) {
                q1(os8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        os8 os8Var3 = this.b;
        selectMusicModel.C(os8Var3.b, os8Var3.d, ps8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !os8Var3.e);
    }

    @Override // com.repackage.j16
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            os8 os8Var = this.b;
            if (os8Var != null) {
                os8Var.i(true);
            }
            at8 at8Var = this.c;
            if (at8Var == null || !at8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.repackage.bt8.c
    public void onGenFilterVideoFail(int i, String str) {
        os8 os8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (os8Var = this.b) == null) {
            return;
        }
        os8Var.d(i, str);
    }

    @Override // com.repackage.bt8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        os8 os8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (os8Var = this.b) == null) {
            return;
        }
        os8Var.d(i, str);
    }

    @Override // com.repackage.bt8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            os8 os8Var = this.b;
            if (os8Var != null) {
                os8Var.e();
            }
            a(str);
        }
    }

    @Override // com.repackage.ws8
    public void q1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            os8 os8Var = this.b;
            if (os8Var != null && os8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ae0);
                os8 os8Var2 = this.b;
                if (os8Var2 != null) {
                    os8Var2.g(i, str2);
                }
            } else {
                os8 os8Var3 = this.b;
                if (os8Var3 != null) {
                    os8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        at8 at8Var = new at8(this.a.getActivity());
                        this.c = at8Var;
                        at8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                os8 os8Var4 = this.b;
                if (os8Var4 != null) {
                    os8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.repackage.ws8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
