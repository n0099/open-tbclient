package com.repackage;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes7.dex */
public class re0 extends pe0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public re0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.oe0
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (this.e) {
                System.currentTimeMillis();
            }
            I();
            if (i != this.f || i2 != this.g) {
                this.f = i;
                this.g = i2;
                t(" w * h : " + i + " * " + i2);
                s();
            }
            if (i == 0 || i2 == 0) {
                return;
            }
            q();
            le0 le0Var = this.c;
            if (le0Var != null) {
                le0Var.g();
            }
            le0 le0Var2 = this.d;
            if (le0Var2 != null) {
                le0Var2.g();
            }
        }
    }

    @Override // com.repackage.oe0
    public int d(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        ke0 G;
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaTrack, i, map)) == null) {
            try {
                if (this.c != null && i != 0 && mediaTrack != null && this.m != null && this.l != null && (G = G(map, mediaTrack)) != null) {
                    return this.c.e(i, G);
                }
            } catch (Exception e) {
                e.printStackTrace();
                u(e.toString(), e);
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0099 */
    /* JADX DEBUG: Multi-variable search result rejected for r11v1, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: float[] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v3, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.repackage.oe0
    public int f(MediaTrack mediaTrack, int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{mediaTrack, Integer.valueOf(i), Integer.valueOf(i2), map})) != null) {
            return invokeCommon.intValue;
        }
        try {
            try {
                if (this.c != null && mediaTrack != null && this.m != null && this.l != null) {
                    le0 le0Var = this.c;
                    float f = mediaTrack.glClearColor[0];
                    float f2 = mediaTrack.glClearColor[1];
                    float f3 = mediaTrack.glClearColor[2];
                    i3 = mediaTrack.glClearColor[3];
                    le0Var.h(f, f2, f3, i3);
                    ArrayList arrayList = new ArrayList();
                    try {
                        if (mediaTrack.mediaSegments == null || mediaTrack.mediaSegments.size() <= this.i) {
                            i4 = i;
                        } else {
                            MediaSegment mediaSegment = mediaTrack.mediaSegments.get(this.i);
                            i4 = i == 0 ? mediaSegment.textureId : i;
                            if (i2 == 1) {
                                z = z(mediaSegment, i4, map);
                            } else if (i2 == 2) {
                                z = y(mediaSegment, i4, map);
                            } else if (i2 == 3) {
                                z = A(mediaTrack, i4, map);
                            } else if (i2 == 4) {
                                C(map, arrayList, mediaTrack);
                            } else if (i2 != 5) {
                                z = B(mediaTrack, mediaSegment, i4, map, arrayList);
                            } else {
                                z = x(i4);
                            }
                            i4 = z;
                        }
                        if (i4 != 0 && arrayList.size() > 0) {
                            i4 = this.c.f(i4, arrayList);
                        }
                        return i4;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        u(e.toString(), e);
                        le0 le0Var2 = this.c;
                        if (le0Var2 != null) {
                            le0Var2.h(0.0f, 0.0f, 0.0f, 0.0f);
                        }
                        return i3;
                    }
                }
                le0 le0Var3 = this.c;
                if (le0Var3 != null) {
                    le0Var3.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return i;
            } catch (Exception e2) {
                e = e2;
                i3 = i;
            }
        } finally {
            le0 le0Var4 = this.c;
            if (le0Var4 != null) {
                le0Var4.h(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    @Override // com.repackage.oe0
    public int h(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, mediaSegment, i, map)) == null) ? mediaSegment == null ? i : r(mediaSegment, i, map) : invokeLIL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        if (r8 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        r8.h(0.0f, 0.0f, 0.0f, 0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r8 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006e, code lost:
        return r9;
     */
    @Override // com.repackage.oe0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        le0 le0Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(1048580, this, mediaTrack, i, map)) != null) {
            return invokeLIL.intValue;
        }
        try {
            try {
                if (this.c != null && mediaTrack != null && this.m != null && this.l != null) {
                    this.c.h(mediaTrack.glClearColor[0], mediaTrack.glClearColor[1], mediaTrack.glClearColor[2], mediaTrack.glClearColor[3]);
                    ArrayList arrayList = new ArrayList();
                    i = D(map, arrayList, mediaTrack, i);
                    if (i != 0 && arrayList.size() > 0) {
                        return this.c.f(i, arrayList);
                    }
                    le0Var = this.c;
                }
                le0 le0Var2 = this.c;
                if (le0Var2 != null) {
                    le0Var2.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return i;
            } catch (Exception e) {
                e.printStackTrace();
                u(e.toString(), e);
                le0Var = this.c;
            }
        } finally {
            le0 le0Var3 = this.c;
            if (le0Var3 != null) {
                le0Var3.h(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    @Override // com.repackage.oe0
    public int k(int i, float[] fArr, float[] fArr2, int i2, int i3, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)})) == null) {
            if (i == 0 || this.m == null) {
                return i;
            }
            Map<String, ShaderConfig> map = this.l;
            if (map != null && !map.containsKey(we0.g)) {
                this.l.put(we0.g, ShaderConfig.getGaussianBlurHShaderConfig(f));
                this.l.put(we0.h, ShaderConfig.getGaussianBlurVShaderConfig(f));
                Map<String, ke0> l = ue0.l(this.a, this.l);
                for (Map.Entry<String, ke0> entry : l.entrySet()) {
                    ke0 value = entry.getValue();
                    value.l();
                    value.v(i2, i3);
                }
                this.m.putAll(l);
            }
            if (this.d == null) {
                this.d = new le0();
            }
            this.d.g();
            this.d.c(i2, i3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.m.get(we0.g));
            arrayList.add(this.m.get(we0.h));
            float[] fArr3 = fArr;
            float[] fArr4 = fArr2;
            int i4 = 0;
            while (i4 < arrayList.size()) {
                ke0 ke0Var = (ke0) arrayList.get(i4);
                ke0Var.v(i2, i3);
                if (i4 == 0) {
                    ke0Var.e(GLES20.glGetUniformLocation(ke0Var.j(), "wRatio"), "wRatio", new ShaderParams("wRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{f}));
                } else {
                    ke0Var.e(GLES20.glGetUniformLocation(ke0Var.j(), "hRatio"), "hRatio", new ShaderParams("hRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{f}));
                }
                w(ke0Var, fArr3, fArr4, null);
                i4++;
                fArr3 = null;
                fArr4 = null;
            }
            return this.d.f(i, arrayList);
        }
        return invokeCommon.intValue;
    }
}
