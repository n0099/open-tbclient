package d.a.q0.z3.m.c.d;

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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67565e;

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
            this.f67565e = fVar;
        }

        @Override // d.a.q0.z3.m.c.d.f
        public void a(int i2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bitmap) == null) {
                f fVar = this.f67565e;
                if (fVar != null) {
                    fVar.a(i2, bitmap);
                }
                d.a.w0.t.c.d("single-frameResult: " + i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67566e;

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
            this.f67566e = fVar;
        }

        @Override // d.a.q0.z3.m.c.d.f
        public void a(int i2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bitmap) == null) {
                f fVar = this.f67566e;
                if (fVar != null) {
                    fVar.a(i2, bitmap);
                }
                d.a.w0.t.c.d("multi-frameResult: " + i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-395599589, "Ld/a/q0/z3/m/c/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-395599589, "Ld/a/q0/z3/m/c/d/d;");
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
            tbMultiMediaData.videoInfoType = videoInfo.getVideoType();
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
        oVar.f67609a = vlogEditManager.getDuration();
        oVar.f67610b = i2;
        oVar.f67614f = vlogEditManager.getInputMultiMediaData();
        MediaTrack mediaTrack = (MediaTrack) d.a.w0.t.h.c(vlogEditManager.getUpdateMediaTracks(), 0);
        if (mediaTrack == null) {
            return;
        }
        oVar.f67613e = mediaTrack.mediaSegments;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        oVar.f67611c = i3;
        if (i4 == 0) {
            i4 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        oVar.f67612d = i4;
        i.f().i(oVar, new b(fVar));
    }

    public static void c(MultiMediaData multiMediaData, Context context, int i2, int i3, int i4, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{multiMediaData, context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar}) == null) || multiMediaData == null || context == null || i2 <= 0) {
            return;
        }
        p pVar = new p();
        pVar.f67616b = i2;
        pVar.f67615a = multiMediaData.originalDuration;
        pVar.f67619e = multiMediaData;
        if (i3 == 0) {
            i3 = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        }
        pVar.f67617c = i3;
        if (i4 == 0) {
            i4 = UtilHelper.getDimenPixelSize(R.dimen.tbds32);
        }
        pVar.f67618d = i4;
        i.f().j(pVar, new a(fVar));
    }
}
