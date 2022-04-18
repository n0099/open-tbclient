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
import com.repackage.ht8;
import java.util.List;
/* loaded from: classes7.dex */
public class ut8 implements ct8, ht8.c, iz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public us8 b;
    public gt8 c;
    public SelectMusicModel d;
    public String e;

    public ut8(us8 us8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {us8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = us8Var;
        this.a = us8Var.a;
    }

    public final void a(String str) {
        us8 us8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (us8Var = this.b) == null) {
            return;
        }
        if (us8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        us8 us8Var2 = this.b;
        if (us8Var2 != null) {
            us8Var2.f(videoInfo);
        }
    }

    public void b() {
        us8 us8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (us8Var = this.b) == null) {
            return;
        }
        if (us8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            us8 us8Var2 = this.b;
            if (!us8Var2.e) {
                onSaveMusicVideo(us8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        us8 us8Var3 = this.b;
        selectMusicModel.B(us8Var3.b, us8Var3.d, vs8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !us8Var3.e);
    }

    @Override // com.repackage.iz5
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            us8 us8Var = this.b;
            if (us8Var != null) {
                us8Var.i(true);
            }
            gt8 gt8Var = this.c;
            if (gt8Var == null || !gt8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.repackage.ht8.c
    public void onGenFilterVideoFail(int i, String str) {
        us8 us8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (us8Var = this.b) == null) {
            return;
        }
        us8Var.d(i, str);
    }

    @Override // com.repackage.ht8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        us8 us8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (us8Var = this.b) == null) {
            return;
        }
        us8Var.d(i, str);
    }

    @Override // com.repackage.ht8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            us8 us8Var = this.b;
            if (us8Var != null) {
                us8Var.e();
            }
            a(str);
        }
    }

    @Override // com.repackage.ct8
    public void onSaveMusicVideo(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            us8 us8Var = this.b;
            if (us8Var != null && us8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ac6);
                us8 us8Var2 = this.b;
                if (us8Var2 != null) {
                    us8Var2.g(i, str2);
                }
            } else {
                us8 us8Var3 = this.b;
                if (us8Var3 != null) {
                    us8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        gt8 gt8Var = new gt8(this.a.getActivity());
                        this.c = gt8Var;
                        gt8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                us8 us8Var4 = this.b;
                if (us8Var4 != null) {
                    us8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.repackage.ct8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
