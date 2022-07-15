package com.repackage;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class pe0 implements oe0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public volatile boolean b;
    public le0 c;
    public le0 d;
    public boolean e;
    public int f;
    public int g;
    public final LinkedList<Runnable> h;
    public int i;
    public long j;
    public List<MediaTrack> k;
    public Map<String, ShaderConfig> l;
    public Map<String, ke0> m;
    public boolean n;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ pe0 c;

        public a(pe0 pe0Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe0Var, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pe0Var;
            this.a = i;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pe0 pe0Var = this.c;
                pe0Var.i = this.a;
                pe0Var.j = this.b;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ pe0 c;

        public b(pe0 pe0Var, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe0Var, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pe0Var;
            this.a = list;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.b) {
                    this.c.s();
                }
                pe0 pe0Var = this.c;
                pe0Var.k = this.a;
                pe0Var.l = this.b;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ pe0 b;

        public c(pe0 pe0Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe0Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pe0Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.k = this.a;
            }
        }
    }

    public pe0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.h = new LinkedList<>();
    }

    public int A(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        MediaSegment mediaSegment;
        ke0 F;
        int e;
        MediaSegment mediaSegment2;
        ke0 F2;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, mediaTrack, i, map)) == null) {
            if (this.i == 0 && (mediaSegment2 = mediaTrack.superpositionHeader) != null && ((TextUtils.equals(mediaSegment2.superpositionType, "all") || TextUtils.equals(mediaTrack.superpositionHeader.superpositionType, "without_trans")) && (F2 = F(mediaTrack.superpositionHeader, map)) != null && (e2 = this.c.e(i, F2)) != i)) {
                i = e2;
            }
            return (this.i != mediaTrack.mediaSegments.size() + (-1) || (mediaSegment = mediaTrack.superpositionFooter) == null) ? i : ((!TextUtils.equals(mediaSegment.superpositionType, "all") && !TextUtils.equals(mediaTrack.superpositionFooter.superpositionType, "without_trans")) || (F = F(mediaTrack.superpositionFooter, map)) == null || (e = this.c.e(i, F)) == i) ? i : e;
        }
        return invokeLIL.intValue;
    }

    public int B(MediaTrack mediaTrack, MediaSegment mediaSegment, int i, Map<String, float[]> map, List<ke0> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaTrack, mediaSegment, Integer.valueOf(i), map, list})) == null) {
            int A = A(mediaTrack, y(mediaSegment, z(mediaSegment, i, map), map), map);
            C(map, list, mediaTrack);
            return A;
        }
        return invokeCommon.intValue;
    }

    public void C(Map<String, float[]> map, List<ke0> list, MediaTrack mediaTrack) {
        List<MediaTransition> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, map, list, mediaTrack) == null) || (list2 = mediaTrack.mediaTransitions) == null) {
            return;
        }
        int size = list2.size();
        int i = this.i;
        if (size > i) {
            MediaTransition mediaTransition = mediaTrack.mediaTransitions.get(i);
            long j = mediaTransition.end;
            long j2 = mediaTransition.start;
            if (j - j2 > 0) {
                long j3 = this.j;
                if (j3 < j2 || j3 > j) {
                    return;
                }
                String str = mediaTransition.shaderConfigKey;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                H(this.i, mediaTrack, mediaTransition, map);
                ke0 ke0Var = this.m.get(str);
                if (ke0Var != null) {
                    v(ke0Var, map);
                    K(str, ke0Var, mediaTransition);
                    list.add(ke0Var);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r5 <= r14) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int D(Map<String, float[]> map, List<ke0> list, MediaTrack mediaTrack, int i) {
        InterceptResult invokeLLLI;
        ke0 ke0Var;
        ke0 ke0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, map, list, mediaTrack, i)) == null) {
            boolean m = we0.m(mediaTrack, "effect");
            int size = m ? mediaTrack.mediaSegments.size() - 1 : 0;
            boolean z = !m ? size >= mediaTrack.mediaSegments.size() : size < 0;
            int i2 = size;
            int i3 = i;
            while (z) {
                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i2);
                if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                    long j = mediaSegment.start;
                    long j2 = mediaSegment.end;
                    if (j != j2) {
                        long j3 = this.j;
                        if (j3 >= j) {
                        }
                    }
                    i2 = !m ? i2 - 1 : i2 + 1;
                    z = m ? i2 < mediaTrack.mediaSegments.size() : i2 >= 0;
                }
                if (!m && !we0.m(mediaTrack, "template_effect") && mediaSegment.mediaAEffect != null) {
                    int e = this.c.e(i3, E(mediaSegment, mediaSegment.textureId, map));
                    if (e != i3) {
                        i3 = e;
                    }
                } else {
                    String str = mediaSegment.shaderConfigKey;
                    if (!TextUtils.isEmpty(str) && (ke0Var2 = this.m.get(str)) != null) {
                        v(ke0Var2, map);
                        J(str, ke0Var2);
                        p(ke0Var2);
                        list.add(ke0Var2);
                    }
                    MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
                    if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                        MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                        if (mediaAEffect2.duration > 0) {
                            String str2 = mediaAEffect2.shaderConfigKey;
                            long j4 = mediaSegment.effectStart;
                            if (j4 <= 0) {
                                j4 = mediaSegment.start;
                            }
                            long j5 = j4;
                            long j6 = mediaSegment.effectEnd;
                            long j7 = j6 > 0 ? j6 : mediaSegment.end;
                            if (!TextUtils.isEmpty(str2)) {
                                long j8 = this.j;
                                if (j8 >= j5 && j8 <= j7 && (ke0Var = this.m.get(str2)) != null) {
                                    v(ke0Var, map);
                                    J(str2, ke0Var);
                                    p(ke0Var);
                                    ke0Var.F(mediaAEffect2.effectType, j5, j7, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                                    list.add(ke0Var);
                                }
                            }
                        }
                    }
                }
                if (m) {
                    break;
                }
                if (!m) {
                }
                if (m) {
                }
            }
            return i3;
        }
        return invokeLLLI.intValue;
    }

    public ke0 E(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, mediaSegment, i, map)) == null) {
            if (i == 0) {
                i = mediaSegment.textureId;
            }
            ke0 ke0Var = null;
            if (i == 0) {
                return null;
            }
            int r = r(mediaSegment, i, map);
            String str = mediaSegment.shaderConfigKey;
            if (!TextUtils.isEmpty(str)) {
                List<MediaTextureData> list = this.l.get(str).textures;
                if (list != null) {
                    for (MediaTextureData mediaTextureData : list) {
                        mediaTextureData.textureId = r;
                    }
                }
                ke0Var = this.m.get(str);
                if (ke0Var != null) {
                    v(ke0Var, map);
                    J(str, ke0Var);
                    p(ke0Var);
                }
            }
            return ke0Var;
        }
        return (ke0) invokeLIL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r5 <= r3) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ke0 F(MediaSegment mediaSegment, Map<String, float[]> map) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048581, this, mediaSegment, map)) != null) {
            return (ke0) invokeLL.objValue;
        }
        if (mediaSegment == null) {
            return null;
        }
        if (mediaSegment.start != 0 || mediaSegment.end != 0) {
            long j = mediaSegment.start;
            long j2 = mediaSegment.end;
            if (j != j2) {
                long j3 = this.j;
                if (j3 >= j) {
                }
            }
            z = false;
            if (z) {
                return null;
            }
            return E(mediaSegment, mediaSegment.textureId, map);
        }
        z = true;
        if (z) {
        }
    }

    public ke0 G(Map<String, float[]> map, MediaTrack mediaTrack) {
        InterceptResult invokeLL;
        ke0 F;
        ke0 F2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, map, mediaTrack)) == null) {
            if (mediaTrack != null) {
                MediaSegment mediaSegment = mediaTrack.superpositionHeader;
                if (mediaSegment == null || !TextUtils.equals(mediaSegment.superpositionType, "self") || (F2 = F(mediaTrack.superpositionHeader, map)) == null) {
                    MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                    if (mediaSegment2 == null || !TextUtils.equals(mediaSegment2.superpositionType, "self") || (F = F(mediaTrack.superpositionFooter, map)) == null) {
                        return null;
                    }
                    return F;
                }
                return F2;
            }
            return null;
        }
        return (ke0) invokeLL.objValue;
    }

    public void H(int i, MediaTrack mediaTrack, MediaTransition mediaTransition, Map<String, float[]> map) {
        int i2;
        List<MediaTextureData> list;
        ke0 F;
        int e;
        List<MediaTextureData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), mediaTrack, mediaTransition, map}) == null) {
            ShaderConfig shaderConfig = this.l.get(mediaTransition.shaderConfigKey);
            if (shaderConfig != null && (list2 = shaderConfig.textures) != null) {
                for (MediaTextureData mediaTextureData : list2) {
                    if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData.type)) {
                        i2 = mediaTextureData.textureId;
                        break;
                    }
                }
            }
            i2 = 0;
            if (i2 == 0) {
                return;
            }
            int i3 = i + 1;
            if (mediaTrack.mediaSegments.size() > i3) {
                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i3);
                i2 = y(mediaSegment, x(z(mediaSegment, i2, map)), map);
                MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                if (mediaSegment2 != null && TextUtils.equals(mediaSegment2.superpositionType, "all") && (F = F(mediaTrack.superpositionFooter, map)) != null && (e = this.c.e(i2, F)) != i2) {
                    i2 = e;
                }
            }
            if (shaderConfig == null || (list = shaderConfig.textures) == null) {
                return;
            }
            for (MediaTextureData mediaTextureData2 : list) {
                if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData2.type)) {
                    mediaTextureData2.textureId = i2;
                    return;
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            while (!this.h.isEmpty()) {
                this.h.removeFirst().run();
            }
        }
    }

    public void J(String str, ke0 ke0Var) {
        ShaderConfig shaderConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, ke0Var) == null) || !(ke0Var instanceof ne0) || TextUtils.isEmpty(str) || (shaderConfig = this.l.get(str)) == null || shaderConfig.textures == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaTextureData mediaTextureData : shaderConfig.textures) {
            int i = mediaTextureData.textureId;
            if (i != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        ((ne0) ke0Var).Y(arrayList);
    }

    public void K(String str, ke0 ke0Var, MediaTransition mediaTransition) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, str, ke0Var, mediaTransition) == null) && (ke0Var instanceof ne0)) {
            ArrayList arrayList = new ArrayList();
            for (MediaTextureData mediaTextureData : this.l.get(str).textures) {
                int i = mediaTextureData.textureId;
                if (i != 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            ((ne0) ke0Var).Y(arrayList);
            p(ke0Var);
            ke0Var.Q(mediaTransition.start, mediaTransition.end, mediaTransition.tParams);
        }
    }

    @Override // com.repackage.oe0
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // com.repackage.oe0
    @Deprecated
    public int c(int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeIIL;
        ke0 G;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i, i2, map)) == null) {
            try {
                b(i, i2);
            } catch (Exception e) {
                e.printStackTrace();
                u(e.toString(), e);
            }
            if (this.c != null && this.k != null && this.m != null && this.l != null) {
                ArrayList arrayList = new ArrayList();
                MediaTrack mediaTrack = null;
                int size = ue0.x(this.k, "edit_sticker") ? this.k.size() - 2 : this.k.size() - 1;
                int i4 = 0;
                for (int i5 = 0; i5 < this.k.size(); i5++) {
                    MediaTrack mediaTrack2 = this.k.get(i5);
                    if (i5 == 0) {
                        if (mediaTrack2.mediaSegments != null && mediaTrack2.mediaSegments.size() > this.i) {
                            MediaSegment mediaSegment = mediaTrack2.mediaSegments.get(this.i);
                            int i6 = mediaSegment.textureId;
                            if (TextUtils.equals(mediaSegment.type, "camera")) {
                                this.n = true;
                                if (mediaSegment.vertexMtx != null || mediaSegment.textureMtx != null) {
                                    me0 me0Var = (me0) this.m.get(we0.b);
                                    if (mediaSegment.vertexMtx != null) {
                                        me0Var.U(mediaSegment.vertexMtx);
                                    }
                                    if (mediaSegment.textureMtx != null) {
                                        me0Var.V(mediaSegment.textureMtx);
                                    }
                                    me0Var.D(1.0f);
                                    int e2 = this.c.e(i6, me0Var);
                                    if (e2 != i6) {
                                        i3 = e2;
                                        i4 = B(mediaTrack2, mediaSegment, i3, map, arrayList);
                                    }
                                }
                            }
                            i3 = i6;
                            i4 = B(mediaTrack2, mediaSegment, i3, map, arrayList);
                        }
                        mediaTrack = mediaTrack2;
                    } else {
                        D(map, arrayList, mediaTrack2, i4);
                    }
                    if (i5 == size && (G = G(map, mediaTrack)) != null) {
                        arrayList.add(G);
                    }
                }
                if (i4 != 0) {
                    return this.c.f(i4, arrayList);
                }
                return 0;
            }
            return 0;
        }
        return invokeIIL.intValue;
    }

    @Override // com.repackage.oe0
    public void e(List<MediaTrack> list, Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, map) == null) {
            this.h.add(new b(this, list, map));
        }
    }

    @Override // com.repackage.oe0
    public void g(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.h.add(new a(this, i, j));
        }
    }

    @Override // com.repackage.oe0
    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.a = context;
        }
    }

    @Override // com.repackage.oe0
    public List<MediaTrack> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    @Override // com.repackage.oe0
    @Deprecated
    public int m(int i, float[] fArr, float[] fArr2, int i2, int i3, int i4, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) {
            I();
            List<MediaTrack> list = this.k;
            if (list != null && list.size() != 0 && this.k.get(0).mediaSegments != null && this.k.get(0).mediaSegments.size() == 1 && i3 != 0 && i4 != 0) {
                if (i3 != this.f || i4 != this.g) {
                    this.f = i3;
                    this.g = i4;
                    t(" w * h : " + i3 + " * " + i4);
                    s();
                }
                try {
                    MediaSegment mediaSegment = this.k.get(0).mediaSegments.get(0);
                    mediaSegment.textureId = i;
                    mediaSegment.vertexMtx = fArr;
                    mediaSegment.textureMtx = fArr2;
                    int c2 = c(i3, i4, map);
                    if (c2 != 0) {
                        if (fArr2 != null) {
                            Matrix.setIdentityM(fArr2, 0);
                        }
                        if (fArr != null) {
                            Matrix.setIdentityM(fArr, 0);
                        }
                    }
                    return c2;
                } catch (Exception e) {
                    e.printStackTrace();
                    u(e.toString(), e);
                }
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    @Override // com.repackage.oe0
    public void n(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.h.add(new c(this, list));
        }
    }

    public void p(ke0 ke0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, ke0Var) == null) && !this.n && (ke0Var instanceof ne0)) {
            ((ne0) ke0Var).X(Rotation.NORMAL, false, true);
        }
    }

    public void q() {
        Map<String, ShaderConfig> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.b || this.k == null || (map = this.l) == null) {
            return;
        }
        if (!map.containsKey(we0.b)) {
            this.l.put(we0.b, ShaderConfig.getDefaultShaderConfig());
        }
        if (!this.l.containsKey(we0.f)) {
            this.l.put(we0.f, ShaderConfig.getStickerShaderConfig());
        }
        Map<String, ke0> l = ue0.l(this.a, this.l);
        this.m = l;
        for (Map.Entry<String, ke0> entry : l.entrySet()) {
            ke0 value = entry.getValue();
            value.l();
            value.v(this.f, this.g);
        }
        if (this.c == null) {
            this.c = new le0();
        }
        this.c.c(this.f, this.g);
        this.b = true;
    }

    public int r(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048597, this, mediaSegment, i, map)) == null) {
            MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
            if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                if (mediaAEffect2.duration > 0) {
                    String str = mediaAEffect2.shaderConfigKey;
                    if (!TextUtils.isEmpty(str)) {
                        List<MediaTextureData> list = this.l.get(str).textures;
                        if (list != null) {
                            for (MediaTextureData mediaTextureData : list) {
                                mediaTextureData.textureId = i;
                            }
                        }
                        ke0 ke0Var = this.m.get(str);
                        long j = mediaSegment.effectStart;
                        if (j <= 0) {
                            j = mediaSegment.start;
                        }
                        long j2 = j;
                        long j3 = mediaSegment.effectEnd;
                        long j4 = j3 > 0 ? j3 : mediaSegment.end;
                        if (ke0Var != null) {
                            long j5 = this.j;
                            if (j5 >= j2 && j5 <= j4) {
                                v(ke0Var, map);
                                J(str, ke0Var);
                                ke0Var.F(mediaAEffect2.effectType, j2, j4, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                                int e = this.c.e(i, ke0Var);
                                if (e != i) {
                                    return e;
                                }
                            }
                        }
                    }
                }
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    @Override // com.repackage.oe0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                if (this.c != null) {
                    this.c.b();
                    this.c = null;
                }
                if (this.d != null) {
                    this.d.b();
                    this.d = null;
                }
                if (this.l != null) {
                    for (Map.Entry<String, ShaderConfig> entry : this.l.entrySet()) {
                        entry.getValue().destroy();
                    }
                    this.l = null;
                }
                s();
            } catch (Exception e) {
                t(e.getMessage());
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            try {
                if (this.b) {
                    if (this.m != null) {
                        for (Map.Entry<String, ke0> entry : this.m.entrySet()) {
                            entry.getValue().h();
                        }
                        this.m = null;
                    }
                    this.j = 0L;
                    this.b = false;
                }
            } catch (Exception e) {
                t(e.getMessage());
            }
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && this.e) {
            Log.d("zmy", "---> " + str);
        }
    }

    public void u(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, str, exc) == null) && this.e) {
            Log.d("zmy", "---> " + str, exc);
        }
    }

    public void v(ke0 ke0Var, Map<String, float[]> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, ke0Var, map) == null) {
            float[] fArr = qe0.b;
            w(ke0Var, fArr, fArr, map);
        }
    }

    public void w(ke0 ke0Var, float[] fArr, float[] fArr2, Map<String, float[]> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048603, this, ke0Var, fArr, fArr2, map) == null) || ke0Var == null) {
            return;
        }
        if (ke0Var instanceof me0) {
            if (fArr == null) {
                fArr = qe0.b;
            }
            if (fArr2 == null) {
                fArr2 = qe0.b;
            }
            me0 me0Var = (me0) ke0Var;
            me0Var.U(fArr);
            me0Var.V(fArr2);
        }
        ke0Var.J();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, float[]> entry : map.entrySet()) {
                ke0Var.I(GLES20.glGetUniformLocation(ke0Var.j(), entry.getKey()), entry.getValue(), true);
            }
        }
        ke0Var.E(this.j);
    }

    public int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            List<MediaTrack> list = this.k;
            if (list == null) {
                return i;
            }
            String str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
            if (!we0.k(list, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                str = "user_background";
            }
            int i2 = 1;
            while (true) {
                if (i2 >= this.k.size()) {
                    break;
                }
                MediaTrack mediaTrack = this.k.get(i2);
                if (mediaTrack != null && we0.m(mediaTrack, str)) {
                    le0 le0Var = this.c;
                    float[] fArr = mediaTrack.glClearColor;
                    le0Var.h(fArr[0], fArr[1], fArr[2], fArr[3]);
                    List<MediaSegment> list2 = mediaTrack.mediaSegments;
                    if (list2 != null) {
                        for (MediaSegment mediaSegment : list2) {
                            if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                                long j = mediaSegment.start;
                                long j2 = mediaSegment.end;
                                if (j != j2) {
                                    long j3 = this.j;
                                    if (j3 >= j && j3 <= j2) {
                                    }
                                } else {
                                    continue;
                                }
                            }
                            if (mediaSegment.textureId == 0) {
                                continue;
                            } else if (TextUtils.equals(mediaSegment.type, "input")) {
                                return i;
                            } else {
                                ke0 ke0Var = this.m.get(we0.f);
                                if (ke0Var != null) {
                                    v(ke0Var, null);
                                    if (ke0Var instanceof ne0) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(Integer.valueOf(i));
                                        ((ne0) ke0Var).Y(arrayList);
                                    }
                                    p(ke0Var);
                                    int e = this.c.e(mediaSegment.textureId, ke0Var);
                                    if (e != mediaSegment.textureId) {
                                        i = e;
                                    }
                                }
                            }
                        }
                    } else {
                        ke0 ke0Var2 = this.m.get(we0.b);
                        if (ke0Var2 != null) {
                            v(ke0Var2, null);
                            GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                            GLES20.glBlendFunc(770, 771);
                            int e2 = this.c.e(i, ke0Var2);
                            GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                            if (e2 != i) {
                                i = e2;
                            }
                        }
                    }
                    this.c.h(0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    i2++;
                }
            }
            return i;
        }
        return invokeI.intValue;
    }

    public int y(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        ke0 ke0Var;
        ke0 ke0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048605, this, mediaSegment, i, map)) == null) {
            int i2 = i;
            String str = mediaSegment.shaderConfigKey;
            if (!TextUtils.isEmpty(str) && (ke0Var2 = this.m.get(str)) != null) {
                v(ke0Var2, map);
                J(str, ke0Var2);
                int e = this.c.e(i2, ke0Var2);
                if (e != i2) {
                    i2 = e;
                }
            }
            MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
            if (mediaAEffect == null || TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                return i2;
            }
            MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
            if (mediaAEffect2.duration > 0) {
                String str2 = mediaAEffect2.shaderConfigKey;
                long j = mediaSegment.effectStart;
                if (j <= 0) {
                    j = mediaSegment.start;
                }
                long j2 = j;
                long j3 = mediaSegment.effectEnd;
                long j4 = j3 > 0 ? j3 : mediaSegment.end;
                if (TextUtils.isEmpty(str2)) {
                    return i2;
                }
                long j5 = this.j;
                if (j5 < j2 || j5 > j4 || (ke0Var = this.m.get(str2)) == null) {
                    return i2;
                }
                v(ke0Var, map);
                J(str2, ke0Var);
                ke0Var.F(mediaAEffect2.effectType, j2, j4, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                int e2 = this.c.e(i2, ke0Var);
                return e2 != i2 ? e2 : i2;
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int z(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        ke0 ke0Var;
        List<MediaTextureData> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048606, this, mediaSegment, i, map)) == null) {
            String str = mediaSegment.lutConfigKey;
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            ShaderConfig shaderConfig = this.l.get(str);
            String str2 = null;
            if (shaderConfig != null && (list = shaderConfig.textures) != null) {
                for (MediaTextureData mediaTextureData : list) {
                    if (mediaTextureData.textureId == 0 || !TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_LUT)) {
                        str = null;
                        break;
                    }
                    while (r0.hasNext()) {
                    }
                }
                str2 = str;
            }
            if (TextUtils.isEmpty(str2) || (ke0Var = this.m.get(str2)) == null) {
                return i;
            }
            v(ke0Var, map);
            J(str2, ke0Var);
            int e = this.c.e(i, ke0Var);
            return e != i ? e : i;
        }
        return invokeLIL.intValue;
    }
}
