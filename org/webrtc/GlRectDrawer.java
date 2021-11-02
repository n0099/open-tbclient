package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.GlGenericDrawer;
/* loaded from: classes3.dex */
public class GlRectDrawer extends GlGenericDrawer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: org.webrtc.GlRectDrawer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ShaderCallbacks() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, glShader) == null) {
            }
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glShader, fArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            }
        }

        public /* synthetic */ ShaderCallbacks(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlRectDrawer() {
        super(FRAGMENT_SHADER, new ShaderCallbacks(null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (GlGenericDrawer.ShaderCallbacks) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // org.webrtc.GlGenericDrawer, org.webrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawOes(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8) {
        super.drawOes(i2, fArr, i3, i4, i5, i6, i7, i8);
    }

    @Override // org.webrtc.GlGenericDrawer, org.webrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawRgb(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8) {
        super.drawRgb(i2, fArr, i3, i4, i5, i6, i7, i8);
    }

    @Override // org.webrtc.GlGenericDrawer, org.webrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawYuv(int[] iArr, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super.drawYuv(iArr, fArr, i2, i3, i4, i5, i6, i7);
    }

    @Override // org.webrtc.GlGenericDrawer, org.webrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }
}
