package d.a.z.b.a;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class f implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68713a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f68714b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.z.b.a.b f68715c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68716d;

    /* renamed from: e  reason: collision with root package name */
    public int f68717e;

    /* renamed from: f  reason: collision with root package name */
    public int f68718f;

    /* renamed from: g  reason: collision with root package name */
    public final LinkedList<Runnable> f68719g;

    /* renamed from: h  reason: collision with root package name */
    public int f68720h;

    /* renamed from: i  reason: collision with root package name */
    public long f68721i;
    public List<MediaTrack> j;
    public Map<String, ShaderConfig> k;
    public Map<String, d.a.z.b.a.a> l;
    public boolean m;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68722e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f68723f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f68724g;

        public a(f fVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68724g = fVar;
            this.f68722e = i2;
            this.f68723f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f68724g;
                fVar.f68720h = this.f68722e;
                fVar.f68721i = this.f68723f;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f68725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f68726f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f68727g;

        public b(f fVar, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68727g = fVar;
            this.f68725e = list;
            this.f68726f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68727g.f68714b) {
                    this.f68727g.r();
                }
                f fVar = this.f68727g;
                fVar.j = this.f68725e;
                fVar.k = this.f68726f;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f68728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f68729f;

        public c(f fVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68729f = fVar;
            this.f68728e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68729f.j = this.f68728e;
            }
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68716d = false;
        this.f68719g = new LinkedList<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r5 <= r14) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int A(Map<String, float[]> map, List<d.a.z.b.a.a> list, MediaTrack mediaTrack, int i2) {
        InterceptResult invokeLLLI;
        d.a.z.b.a.a aVar;
        d.a.z.b.a.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, map, list, mediaTrack, i2)) == null) {
            boolean l = d.a.z.b.a.k.c.l(mediaTrack, "effect");
            int size = l ? mediaTrack.mediaSegments.size() - 1 : 0;
            boolean z = !l ? size >= mediaTrack.mediaSegments.size() : size < 0;
            int i3 = size;
            int i4 = i2;
            while (z) {
                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i3);
                if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                    long j = mediaSegment.start;
                    long j2 = mediaSegment.end;
                    if (j != j2) {
                        long j3 = this.f68721i;
                        if (j3 >= j) {
                        }
                    }
                    i3 = !l ? i3 - 1 : i3 + 1;
                    z = l ? i3 < mediaTrack.mediaSegments.size() : i3 >= 0;
                }
                if (!l && !d.a.z.b.a.k.c.l(mediaTrack, "template_effect") && mediaSegment.mediaAEffect != null) {
                    int e2 = this.f68715c.e(i4, B(mediaSegment, mediaSegment.textureId, map));
                    if (e2 != i4) {
                        i4 = e2;
                    }
                } else {
                    String str = mediaSegment.shaderConfigKey;
                    if (!TextUtils.isEmpty(str) && (aVar2 = this.l.get(str)) != null) {
                        u(aVar2, map);
                        G(str, aVar2);
                        o(aVar2);
                        list.add(aVar2);
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
                                long j8 = this.f68721i;
                                if (j8 >= j5 && j8 <= j7 && (aVar = this.l.get(str2)) != null) {
                                    u(aVar, map);
                                    G(str2, aVar);
                                    o(aVar);
                                    aVar.F(mediaAEffect2.effectType, j5, j7, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                                    list.add(aVar);
                                }
                            }
                        }
                    }
                }
                if (l) {
                    break;
                }
                if (!l) {
                }
                if (l) {
                }
            }
            return i4;
        }
        return invokeLLLI.intValue;
    }

    public d.a.z.b.a.a B(MediaSegment mediaSegment, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaSegment, i2, map)) == null) {
            if (i2 == 0) {
                i2 = mediaSegment.textureId;
            }
            d.a.z.b.a.a aVar = null;
            if (i2 == 0) {
                return null;
            }
            int q = q(mediaSegment, i2, map);
            String str = mediaSegment.shaderConfigKey;
            if (!TextUtils.isEmpty(str)) {
                List<MediaTextureData> list = this.k.get(str).textures;
                if (list != null) {
                    for (MediaTextureData mediaTextureData : list) {
                        mediaTextureData.textureId = q;
                    }
                }
                aVar = this.l.get(str);
                if (aVar != null) {
                    u(aVar, map);
                    G(str, aVar);
                    o(aVar);
                }
            }
            return aVar;
        }
        return (d.a.z.b.a.a) invokeLIL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r5 <= r3) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.z.b.a.a C(MediaSegment mediaSegment, Map<String, float[]> map) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, mediaSegment, map)) != null) {
            return (d.a.z.b.a.a) invokeLL.objValue;
        }
        if (mediaSegment == null) {
            return null;
        }
        if (mediaSegment.start != 0 || mediaSegment.end != 0) {
            long j = mediaSegment.start;
            long j2 = mediaSegment.end;
            if (j != j2) {
                long j3 = this.f68721i;
                if (j3 >= j) {
                }
            }
            z = false;
            if (z) {
                return null;
            }
            return B(mediaSegment, mediaSegment.textureId, map);
        }
        z = true;
        if (z) {
        }
    }

    public d.a.z.b.a.a D(Map<String, float[]> map, MediaTrack mediaTrack) {
        InterceptResult invokeLL;
        d.a.z.b.a.a C;
        d.a.z.b.a.a C2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, map, mediaTrack)) == null) {
            if (mediaTrack != null) {
                MediaSegment mediaSegment = mediaTrack.superpositionHeader;
                if (mediaSegment == null || !TextUtils.equals(mediaSegment.superpositionType, "self") || (C2 = C(mediaTrack.superpositionHeader, map)) == null) {
                    MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                    if (mediaSegment2 == null || !TextUtils.equals(mediaSegment2.superpositionType, "self") || (C = C(mediaTrack.superpositionFooter, map)) == null) {
                        return null;
                    }
                    return C;
                }
                return C2;
            }
            return null;
        }
        return (d.a.z.b.a.a) invokeLL.objValue;
    }

    public void E(int i2, MediaTrack mediaTrack, MediaTransition mediaTransition, Map<String, float[]> map) {
        int i3;
        List<MediaTextureData> list;
        d.a.z.b.a.a C;
        int e2;
        List<MediaTextureData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), mediaTrack, mediaTransition, map}) == null) {
            ShaderConfig shaderConfig = this.k.get(mediaTransition.shaderConfigKey);
            if (shaderConfig != null && (list2 = shaderConfig.textures) != null) {
                for (MediaTextureData mediaTextureData : list2) {
                    if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData.type)) {
                        i3 = mediaTextureData.textureId;
                        break;
                    }
                }
            }
            i3 = 0;
            if (i3 == 0) {
                return;
            }
            int i4 = i2 + 1;
            if (mediaTrack.mediaSegments.size() > i4) {
                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i4);
                i3 = v(mediaSegment, w(mediaSegment, i3, map), map);
                MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                if (mediaSegment2 != null && TextUtils.equals(mediaSegment2.superpositionType, "all") && (C = C(mediaTrack.superpositionFooter, map)) != null && (e2 = this.f68715c.e(i3, C)) != i3) {
                    i3 = e2;
                }
            }
            if (shaderConfig == null || (list = shaderConfig.textures) == null) {
                return;
            }
            for (MediaTextureData mediaTextureData2 : list) {
                if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData2.type)) {
                    mediaTextureData2.textureId = i3;
                    return;
                }
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            while (!this.f68719g.isEmpty()) {
                this.f68719g.removeFirst().run();
            }
        }
    }

    public void G(String str, d.a.z.b.a.a aVar) {
        ShaderConfig shaderConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) || !(aVar instanceof d) || TextUtils.isEmpty(str) || (shaderConfig = this.k.get(str)) == null || shaderConfig.textures == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaTextureData mediaTextureData : shaderConfig.textures) {
            int i2 = mediaTextureData.textureId;
            if (i2 != 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        ((d) aVar).Y(arrayList);
    }

    public void H(String str, d.a.z.b.a.a aVar, MediaTransition mediaTransition) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, aVar, mediaTransition) == null) && (aVar instanceof d)) {
            ArrayList arrayList = new ArrayList();
            for (MediaTextureData mediaTextureData : this.k.get(str).textures) {
                int i2 = mediaTextureData.textureId;
                if (i2 != 0) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            ((d) aVar).Y(arrayList);
            o(aVar);
            aVar.Q(mediaTransition.start, mediaTransition.end, mediaTransition.tParams);
        }
    }

    @Override // d.a.z.b.a.e
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f68721i : invokeV.longValue;
    }

    @Override // d.a.z.b.a.e
    public int c(int i2, int i3, Map<String, float[]> map) {
        InterceptResult invokeIIL;
        d.a.z.b.a.a D;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, map)) == null) {
            try {
                b(i2, i3);
            } catch (Exception e2) {
                e2.printStackTrace();
                t(e2.toString(), e2);
            }
            if (this.f68715c != null && this.j != null && this.l != null && this.k != null) {
                ArrayList arrayList = new ArrayList();
                MediaTrack mediaTrack = null;
                int size = d.a.z.b.a.k.a.w(this.j, "edit_sticker") ? this.j.size() - 2 : this.j.size() - 1;
                int i5 = 0;
                for (int i6 = 0; i6 < this.j.size(); i6++) {
                    MediaTrack mediaTrack2 = this.j.get(i6);
                    if (i6 == 0) {
                        if (mediaTrack2.mediaSegments != null && mediaTrack2.mediaSegments.size() > this.f68720h) {
                            MediaSegment mediaSegment = mediaTrack2.mediaSegments.get(this.f68720h);
                            int i7 = mediaSegment.textureId;
                            if (TextUtils.equals(mediaSegment.type, "camera")) {
                                this.m = true;
                                if (mediaSegment.vertexMtx != null || mediaSegment.textureMtx != null) {
                                    d.a.z.b.a.c cVar = (d.a.z.b.a.c) this.l.get(d.a.z.b.a.k.c.f68741b);
                                    if (mediaSegment.vertexMtx != null) {
                                        cVar.U(mediaSegment.vertexMtx);
                                    }
                                    if (mediaSegment.textureMtx != null) {
                                        cVar.V(mediaSegment.textureMtx);
                                    }
                                    cVar.D(1.0f);
                                    int e3 = this.f68715c.e(i7, cVar);
                                    if (e3 != i7) {
                                        i4 = e3;
                                        i5 = y(mediaTrack2, mediaSegment, i4, map, arrayList);
                                    }
                                }
                            }
                            i4 = i7;
                            i5 = y(mediaTrack2, mediaSegment, i4, map, arrayList);
                        }
                        mediaTrack = mediaTrack2;
                    } else {
                        A(map, arrayList, mediaTrack2, i5);
                    }
                    if (i6 == size && (D = D(map, mediaTrack)) != null) {
                        arrayList.add(D);
                    }
                }
                if (i5 != 0) {
                    return this.f68715c.f(i5, arrayList);
                }
                return 0;
            }
            return 0;
        }
        return invokeIIL.intValue;
    }

    @Override // d.a.z.b.a.e
    public void e(List<MediaTrack> list, Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, list, map) == null) {
            this.f68719g.add(new b(this, list, map));
        }
    }

    @Override // d.a.z.b.a.e
    public void g(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f68719g.add(new a(this, i2, j));
        }
    }

    @Override // d.a.z.b.a.e
    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            this.f68713a = context;
        }
    }

    @Override // d.a.z.b.a.e
    public List<MediaTrack> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    @Override // d.a.z.b.a.e
    public int l(int i2, float[] fArr, float[] fArr2, int i3, int i4, int i5, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), fArr, fArr2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), map})) == null) {
            F();
            List<MediaTrack> list = this.j;
            if (list != null && list.size() != 0 && this.j.get(0).mediaSegments != null && this.j.get(0).mediaSegments.size() == 1 && i4 != 0 && i5 != 0) {
                if (i4 != this.f68717e || i5 != this.f68718f) {
                    this.f68717e = i4;
                    this.f68718f = i5;
                    s(" w * h : " + i4 + " * " + i5);
                    r();
                }
                try {
                    MediaSegment mediaSegment = this.j.get(0).mediaSegments.get(0);
                    mediaSegment.textureId = i2;
                    mediaSegment.vertexMtx = fArr;
                    mediaSegment.textureMtx = fArr2;
                    int c2 = c(i4, i5, map);
                    if (c2 != 0) {
                        if (fArr2 != null) {
                            Matrix.setIdentityM(fArr2, 0);
                        }
                        if (fArr != null) {
                            Matrix.setIdentityM(fArr, 0);
                        }
                    }
                    return c2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    t(e2.toString(), e2);
                }
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    @Override // d.a.z.b.a.e
    public void m(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f68719g.add(new c(this, list));
        }
    }

    public void o(d.a.z.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) && !this.m && (aVar instanceof d)) {
            ((d) aVar).X(Rotation.NORMAL, false, true);
        }
    }

    public void p() {
        Map<String, ShaderConfig> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f68714b || this.j == null || (map = this.k) == null) {
            return;
        }
        if (!map.containsKey(d.a.z.b.a.k.c.f68741b)) {
            this.k.put(d.a.z.b.a.k.c.f68741b, ShaderConfig.getDefaultShaderConfig());
        }
        Map<String, d.a.z.b.a.a> l = d.a.z.b.a.k.a.l(this.f68713a, this.k);
        this.l = l;
        for (Map.Entry<String, d.a.z.b.a.a> entry : l.entrySet()) {
            d.a.z.b.a.a value = entry.getValue();
            value.l();
            value.v(this.f68717e, this.f68718f);
        }
        if (this.f68715c == null) {
            d.a.z.b.a.b bVar = new d.a.z.b.a.b();
            this.f68715c = bVar;
            bVar.c(this.f68717e, this.f68718f);
        }
        this.f68714b = true;
    }

    public int q(MediaSegment mediaSegment, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048594, this, mediaSegment, i2, map)) == null) {
            MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
            if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                if (mediaAEffect2.duration > 0) {
                    String str = mediaAEffect2.shaderConfigKey;
                    if (!TextUtils.isEmpty(str)) {
                        List<MediaTextureData> list = this.k.get(str).textures;
                        if (list != null) {
                            for (MediaTextureData mediaTextureData : list) {
                                mediaTextureData.textureId = i2;
                            }
                        }
                        d.a.z.b.a.a aVar = this.l.get(str);
                        long j = mediaSegment.effectStart;
                        if (j <= 0) {
                            j = mediaSegment.start;
                        }
                        long j2 = j;
                        long j3 = mediaSegment.effectEnd;
                        long j4 = j3 > 0 ? j3 : mediaSegment.end;
                        if (aVar != null) {
                            long j5 = this.f68721i;
                            if (j5 >= j2 && j5 <= j4) {
                                u(aVar, map);
                                G(str, aVar);
                                aVar.F(mediaAEffect2.effectType, j2, j4, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                                int e2 = this.f68715c.e(i2, aVar);
                                if (e2 != i2) {
                                    return e2;
                                }
                            }
                        }
                    }
                }
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            try {
                if (this.f68714b) {
                    if (this.l != null) {
                        for (Map.Entry<String, d.a.z.b.a.a> entry : this.l.entrySet()) {
                            entry.getValue().h();
                        }
                        this.l = null;
                    }
                    this.f68721i = 0L;
                    this.f68714b = false;
                }
            } catch (Exception e2) {
                s(e2.getMessage());
            }
        }
    }

    @Override // d.a.z.b.a.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            try {
                if (this.f68715c != null) {
                    this.f68715c.b();
                    this.f68715c = null;
                }
                if (this.k != null) {
                    for (Map.Entry<String, ShaderConfig> entry : this.k.entrySet()) {
                        entry.getValue().destroy();
                    }
                    this.k = null;
                }
                r();
            } catch (Exception e2) {
                s(e2.getMessage());
            }
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && this.f68716d) {
            Log.d("zmy", "---> " + str);
        }
    }

    public void t(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, exc) == null) && this.f68716d) {
            Log.d("zmy", "---> " + str, exc);
        }
    }

    public void u(d.a.z.b.a.a aVar, Map<String, float[]> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, aVar, map) == null) || aVar == null) {
            return;
        }
        if (aVar instanceof d.a.z.b.a.c) {
            d.a.z.b.a.c cVar = (d.a.z.b.a.c) aVar;
            cVar.U(g.f68731b);
            cVar.V(g.f68731b);
        }
        aVar.J();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, float[]> entry : map.entrySet()) {
                aVar.I(GLES20.glGetUniformLocation(aVar.j(), entry.getKey()), entry.getValue(), true);
            }
        }
        aVar.E(this.f68721i);
    }

    public int v(MediaSegment mediaSegment, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        d.a.z.b.a.a aVar;
        d.a.z.b.a.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048600, this, mediaSegment, i2, map)) == null) {
            int i3 = i2;
            String str = mediaSegment.shaderConfigKey;
            if (!TextUtils.isEmpty(str) && (aVar2 = this.l.get(str)) != null) {
                u(aVar2, map);
                G(str, aVar2);
                int e2 = this.f68715c.e(i3, aVar2);
                if (e2 != i3) {
                    i3 = e2;
                }
            }
            MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
            if (mediaAEffect == null || TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                return i3;
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
                    return i3;
                }
                long j5 = this.f68721i;
                if (j5 < j2 || j5 > j4 || (aVar = this.l.get(str2)) == null) {
                    return i3;
                }
                u(aVar, map);
                G(str2, aVar);
                aVar.F(mediaAEffect2.effectType, j2, j4, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                int e3 = this.f68715c.e(i3, aVar);
                return e3 != i3 ? e3 : i3;
            }
            return i3;
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int w(MediaSegment mediaSegment, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        d.a.z.b.a.a aVar;
        List<MediaTextureData> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048601, this, mediaSegment, i2, map)) == null) {
            String str = mediaSegment.lutConfigKey;
            if (TextUtils.isEmpty(str)) {
                return i2;
            }
            ShaderConfig shaderConfig = this.k.get(str);
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
            if (TextUtils.isEmpty(str2) || (aVar = this.l.get(str2)) == null) {
                return i2;
            }
            u(aVar, map);
            G(str2, aVar);
            int e2 = this.f68715c.e(i2, aVar);
            return e2 != i2 ? e2 : i2;
        }
        return invokeLIL.intValue;
    }

    public int x(MediaTrack mediaTrack, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        MediaSegment mediaSegment;
        d.a.z.b.a.a C;
        int e2;
        MediaSegment mediaSegment2;
        d.a.z.b.a.a C2;
        int e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048602, this, mediaTrack, i2, map)) == null) {
            if (this.f68720h == 0 && (mediaSegment2 = mediaTrack.superpositionHeader) != null && ((TextUtils.equals(mediaSegment2.superpositionType, "all") || TextUtils.equals(mediaTrack.superpositionHeader.superpositionType, "without_trans")) && (C2 = C(mediaTrack.superpositionHeader, map)) != null && (e3 = this.f68715c.e(i2, C2)) != i2)) {
                i2 = e3;
            }
            return (this.f68720h != mediaTrack.mediaSegments.size() + (-1) || (mediaSegment = mediaTrack.superpositionFooter) == null) ? i2 : ((!TextUtils.equals(mediaSegment.superpositionType, "all") && !TextUtils.equals(mediaTrack.superpositionFooter.superpositionType, "without_trans")) || (C = C(mediaTrack.superpositionFooter, map)) == null || (e2 = this.f68715c.e(i2, C)) == i2) ? i2 : e2;
        }
        return invokeLIL.intValue;
    }

    public int y(MediaTrack mediaTrack, MediaSegment mediaSegment, int i2, Map<String, float[]> map, List<d.a.z.b.a.a> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{mediaTrack, mediaSegment, Integer.valueOf(i2), map, list})) == null) {
            int x = x(mediaTrack, v(mediaSegment, w(mediaSegment, i2, map), map), map);
            z(map, list, mediaTrack);
            return x;
        }
        return invokeCommon.intValue;
    }

    public void z(Map<String, float[]> map, List<d.a.z.b.a.a> list, MediaTrack mediaTrack) {
        List<MediaTransition> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048604, this, map, list, mediaTrack) == null) || (list2 = mediaTrack.mediaTransitions) == null) {
            return;
        }
        int size = list2.size();
        int i2 = this.f68720h;
        if (size > i2) {
            MediaTransition mediaTransition = mediaTrack.mediaTransitions.get(i2);
            long j = mediaTransition.end;
            long j2 = mediaTransition.start;
            if (j - j2 > 0) {
                long j3 = this.f68721i;
                if (j3 < j2 || j3 > j) {
                    return;
                }
                String str = mediaTransition.shaderConfigKey;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                E(this.f68720h, mediaTrack, mediaTransition, map);
                d.a.z.b.a.a aVar = this.l.get(str);
                if (aVar != null) {
                    u(aVar, map);
                    H(str, aVar, mediaTransition);
                    list.add(aVar);
                }
            }
        }
    }
}
