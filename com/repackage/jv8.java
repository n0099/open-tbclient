package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
/* loaded from: classes6.dex */
public class jv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements lv8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv8 a;

        public a(lv8 lv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv8Var;
        }

        @Override // com.repackage.lv8
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                lv8 lv8Var = this.a;
                if (lv8Var != null) {
                    lv8Var.a(i, bitmap);
                }
                w89.d("single-frameResult: " + i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements lv8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv8 a;

        public b(lv8 lv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv8Var;
        }

        @Override // com.repackage.lv8
        public void a(int i, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) {
                lv8 lv8Var = this.a;
                if (lv8Var != null) {
                    lv8Var.a(i, bitmap);
                }
                w89.d("multi-frameResult: " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755575099, "Lcom/repackage/jv8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755575099, "Lcom/repackage/jv8;");
        }
    }

    public static TbMultiMediaData a(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoInfo)) == null) {
            TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
            tbMultiMediaData.path = videoInfo.getVideoPath();
            tbMultiMediaData.coverPath = videoInfo.getThumbPath();
            tbMultiMediaData.height = videoInfo.getVideoHeight();
            tbMultiMediaData.width = videoInfo.getVideoWidth();
            tbMultiMediaData.type = 1;
            tbMultiMediaData.start = 0L;
            tbMultiMediaData.end = videoInfo.getVideoDuration() * 1000;
            tbMultiMediaData.originalDuration = videoInfo.getVideoDuration() * 1000;
            tbMultiMediaData.scaleType = "center_inside";
            tbMultiMediaData.videoInfoSource = videoInfo.getVideoSource();
            return tbMultiMediaData;
        }
        return (TbMultiMediaData) invokeL.objValue;
    }

    public static void b(VlogEditManager vlogEditManager, Context context, int i, int i2, int i3, lv8 lv8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vlogEditManager, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), lv8Var}) == null) || vlogEditManager == null || context == null || i <= 0) {
            return;
        }
        uv8 uv8Var = new uv8();
        uv8Var.a = vlogEditManager.getDuration();
        uv8Var.b = i;
        uv8Var.f = vlogEditManager.getInputMultiMediaData();
        MediaTrack mediaTrack = (MediaTrack) b99.c(vlogEditManager.getUpdateMediaTracks(), 0);
        if (mediaTrack == null) {
            return;
        }
        uv8Var.e = mediaTrack.mediaSegments;
        if (i2 == 0) {
            i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        uv8Var.c = i2;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        uv8Var.d = i3;
        ov8.f().i(uv8Var, new b(lv8Var));
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i, int i2, int i3, lv8 lv8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), lv8Var}) == null) || multiMediaData == null || context == null || i <= 0) {
            return;
        }
        vv8 vv8Var = new vv8();
        vv8Var.b = i;
        vv8Var.a = multiMediaData.originalDuration;
        vv8Var.e = multiMediaData;
        if (i2 == 0) {
            i2 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        vv8Var.c = i2;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        vv8Var.d = i3;
        ov8.f().j(vv8Var, new a(lv8Var));
    }
}
