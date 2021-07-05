package d.a.s0.z3.m.c.d;

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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f70084e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70084e = fVar;
        }

        @Override // d.a.s0.z3.m.c.d.f
        public void a(int i2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bitmap) == null) {
                f fVar = this.f70084e;
                if (fVar != null) {
                    fVar.a(i2, bitmap);
                }
                d.a.y0.t.c.d("single-frameResult: " + i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f70085e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70085e = fVar;
        }

        @Override // d.a.s0.z3.m.c.d.f
        public void a(int i2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bitmap) == null) {
                f fVar = this.f70085e;
                if (fVar != null) {
                    fVar.a(i2, bitmap);
                }
                d.a.y0.t.c.d("multi-frameResult: " + i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1406716839, "Ld/a/s0/z3/m/c/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1406716839, "Ld/a/s0/z3/m/c/d/d;");
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
            return tbMultiMediaData;
        }
        return (TbMultiMediaData) invokeL.objValue;
    }

    public static void b(VlogEditManager vlogEditManager, Context context, int i2, int i3, int i4, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vlogEditManager, context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar}) == null) || vlogEditManager == null || context == null || i2 <= 0) {
            return;
        }
        o oVar = new o();
        oVar.f70128a = vlogEditManager.getDuration();
        oVar.f70129b = i2;
        oVar.f70133f = vlogEditManager.getInputMultiMediaData();
        MediaTrack mediaTrack = (MediaTrack) d.a.y0.t.h.c(vlogEditManager.getUpdateMediaTracks(), 0);
        if (mediaTrack == null) {
            return;
        }
        oVar.f70132e = mediaTrack.mediaSegments;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        oVar.f70130c = i3;
        if (i4 == 0) {
            i4 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        oVar.f70131d = i4;
        i.f().i(oVar, new b(fVar));
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i2, int i3, int i4, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar}) == null) || multiMediaData == null || context == null || i2 <= 0) {
            return;
        }
        p pVar = new p();
        pVar.f70135b = i2;
        pVar.f70134a = multiMediaData.originalDuration;
        pVar.f70138e = multiMediaData;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        pVar.f70136c = i3;
        if (i4 == 0) {
            i4 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        pVar.f70137d = i4;
        i.f().j(pVar, new a(fVar));
    }
}
