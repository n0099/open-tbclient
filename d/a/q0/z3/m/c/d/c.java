package d.a.q0.z3.m.c.d;

import android.opengl.Matrix;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface;
import com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor;
/* loaded from: classes8.dex */
public class c extends BaseOutputSurface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float[] f67563e;

    /* renamed from: f  reason: collision with root package name */
    public MultiMediaData f67564f;

    public c(int i2, int i3, boolean z, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67563e = new float[16];
        this.f67564f = new MultiMediaData();
        init(i2, i3, z, handler);
        this.mFullScreenEXT.setMirror(true);
        Matrix.orthoM(this.f67563e, 0, 0.0f, i2, 0.0f, i3, -1.0f, 1.0f);
    }

    public void a(int i2, int i3, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)}) == null) {
            MultiMediaData multiMediaData = this.f67564f;
            multiMediaData.type = 1;
            multiMediaData.width = i2;
            multiMediaData.height = i3;
            multiMediaData.rotation = f2;
            if (((f2 == 90.0f || f2 == 270.0f) ? (i3 * 1.0f) / i2 : (i2 * 1.0f) / i3) <= (this.mVideoWidth * 1.0f) / this.mVideoHeight) {
                this.f67564f.scaleType = "center_crop";
            } else {
                this.f67564f.scaleType = "center_inside";
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void drawImage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.drawImage(i2);
            if (this.mFullScreenEXT == null) {
                return;
            }
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            Matrix.multiplyMM(fArr, 0, this.f67563e, 0, MultiMediaPreProcessor.calculateModelView(this.f67564f, this.mVideoWidth, this.mVideoHeight, 0, 0), 0);
            this.mFullScreenEXT.setVertexPoint(fArr);
            this.mFullScreenEXT.setAngle(180.0f);
            this.mFullScreenEXT.drawFrame(this.mTextureId, this.mSTMatrix);
            Matrix.setIdentityM(fArr, 0);
            this.mFullScreenEXT.setVertexPoint(fArr);
        }
    }
}
