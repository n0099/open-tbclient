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
import com.repackage.op8;
import java.util.List;
/* loaded from: classes5.dex */
public class bq8 implements jp8, op8.c, uy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public bp8 b;
    public np8 c;
    public SelectMusicModel d;
    public String e;

    public bq8(bp8 bp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bp8Var;
        this.a = bp8Var.a;
    }

    public final void a(String str) {
        bp8 bp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bp8Var = this.b) == null) {
            return;
        }
        if (bp8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        bp8 bp8Var2 = this.b;
        if (bp8Var2 != null) {
            bp8Var2.f(videoInfo);
        }
    }

    public void b() {
        bp8 bp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bp8Var = this.b) == null) {
            return;
        }
        if (bp8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            bp8 bp8Var2 = this.b;
            if (!bp8Var2.e) {
                r1(bp8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        bp8 bp8Var3 = this.b;
        selectMusicModel.C(bp8Var3.b, bp8Var3.d, cp8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !bp8Var3.e);
    }

    @Override // com.repackage.uy5
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bp8 bp8Var = this.b;
            if (bp8Var != null) {
                bp8Var.i(true);
            }
            np8 np8Var = this.c;
            if (np8Var == null || !np8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.repackage.op8.c
    public void onGenFilterVideoFail(int i, String str) {
        bp8 bp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (bp8Var = this.b) == null) {
            return;
        }
        bp8Var.d(i, str);
    }

    @Override // com.repackage.op8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        bp8 bp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (bp8Var = this.b) == null) {
            return;
        }
        bp8Var.d(i, str);
    }

    @Override // com.repackage.op8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            bp8 bp8Var = this.b;
            if (bp8Var != null) {
                bp8Var.e();
            }
            a(str);
        }
    }

    @Override // com.repackage.jp8
    public void r1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            bp8 bp8Var = this.b;
            if (bp8Var != null && bp8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0adf);
                bp8 bp8Var2 = this.b;
                if (bp8Var2 != null) {
                    bp8Var2.g(i, str2);
                }
            } else {
                bp8 bp8Var3 = this.b;
                if (bp8Var3 != null) {
                    bp8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        np8 np8Var = new np8(this.a.getActivity());
                        this.c = np8Var;
                        np8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                bp8 bp8Var4 = this.b;
                if (bp8Var4 != null) {
                    bp8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.repackage.jp8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
