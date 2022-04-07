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
import com.repackage.at8;
import java.util.List;
/* loaded from: classes6.dex */
public class nt8 implements vs8, at8.c, gz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public ns8 b;
    public zs8 c;
    public SelectMusicModel d;
    public String e;

    public nt8(ns8 ns8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ns8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ns8Var;
        this.a = ns8Var.a;
    }

    public final void a(String str) {
        ns8 ns8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (ns8Var = this.b) == null) {
            return;
        }
        if (ns8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        ns8 ns8Var2 = this.b;
        if (ns8Var2 != null) {
            ns8Var2.f(videoInfo);
        }
    }

    public void b() {
        ns8 ns8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ns8Var = this.b) == null) {
            return;
        }
        if (ns8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            ns8 ns8Var2 = this.b;
            if (!ns8Var2.e) {
                onSaveMusicVideo(ns8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        ns8 ns8Var3 = this.b;
        selectMusicModel.B(ns8Var3.b, ns8Var3.d, os8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !ns8Var3.e);
    }

    @Override // com.repackage.gz5
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ns8 ns8Var = this.b;
            if (ns8Var != null) {
                ns8Var.i(true);
            }
            zs8 zs8Var = this.c;
            if (zs8Var == null || !zs8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.repackage.at8.c
    public void onGenFilterVideoFail(int i, String str) {
        ns8 ns8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (ns8Var = this.b) == null) {
            return;
        }
        ns8Var.d(i, str);
    }

    @Override // com.repackage.at8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        ns8 ns8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (ns8Var = this.b) == null) {
            return;
        }
        ns8Var.d(i, str);
    }

    @Override // com.repackage.at8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ns8 ns8Var = this.b;
            if (ns8Var != null) {
                ns8Var.e();
            }
            a(str);
        }
    }

    @Override // com.repackage.vs8
    public void onSaveMusicVideo(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            ns8 ns8Var = this.b;
            if (ns8Var != null && ns8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ac7);
                ns8 ns8Var2 = this.b;
                if (ns8Var2 != null) {
                    ns8Var2.g(i, str2);
                }
            } else {
                ns8 ns8Var3 = this.b;
                if (ns8Var3 != null) {
                    ns8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        zs8 zs8Var = new zs8(this.a.getActivity());
                        this.c = zs8Var;
                        zs8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                ns8 ns8Var4 = this.b;
                if (ns8Var4 != null) {
                    ns8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.repackage.vs8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
