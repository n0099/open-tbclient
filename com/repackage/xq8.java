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
import com.repackage.kq8;
import java.util.List;
/* loaded from: classes7.dex */
public class xq8 implements fq8, kq8.c, rz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public xp8 b;
    public jq8 c;
    public SelectMusicModel d;
    public String e;

    public xq8(xp8 xp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xp8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = xp8Var;
        this.a = xp8Var.a;
    }

    public final void a(String str) {
        xp8 xp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (xp8Var = this.b) == null) {
            return;
        }
        if (xp8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        xp8 xp8Var2 = this.b;
        if (xp8Var2 != null) {
            xp8Var2.f(videoInfo);
        }
    }

    public void b() {
        xp8 xp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (xp8Var = this.b) == null) {
            return;
        }
        if (xp8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            xp8 xp8Var2 = this.b;
            if (!xp8Var2.e) {
                r1(xp8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        xp8 xp8Var3 = this.b;
        selectMusicModel.D(xp8Var3.b, xp8Var3.d, yp8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !xp8Var3.e);
    }

    @Override // com.repackage.rz5
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xp8 xp8Var = this.b;
            if (xp8Var != null) {
                xp8Var.i(true);
            }
            jq8 jq8Var = this.c;
            if (jq8Var == null || !jq8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.repackage.kq8.c
    public void onGenFilterVideoFail(int i, String str) {
        xp8 xp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (xp8Var = this.b) == null) {
            return;
        }
        xp8Var.d(i, str);
    }

    @Override // com.repackage.kq8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        xp8 xp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (xp8Var = this.b) == null) {
            return;
        }
        xp8Var.d(i, str);
    }

    @Override // com.repackage.kq8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            xp8 xp8Var = this.b;
            if (xp8Var != null) {
                xp8Var.e();
            }
            a(str);
        }
    }

    @Override // com.repackage.fq8
    public void r1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            xp8 xp8Var = this.b;
            if (xp8Var != null && xp8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0acf);
                xp8 xp8Var2 = this.b;
                if (xp8Var2 != null) {
                    xp8Var2.g(i, str2);
                }
            } else {
                xp8 xp8Var3 = this.b;
                if (xp8Var3 != null) {
                    xp8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        jq8 jq8Var = new jq8(this.a.getActivity());
                        this.c = jq8Var;
                        jq8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                xp8 xp8Var4 = this.b;
                if (xp8Var4 != null) {
                    xp8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.repackage.fq8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
