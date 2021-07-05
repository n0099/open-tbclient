package d.a.c0.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes8.dex */
public class h extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    @Override // d.a.c0.b.a.e
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (this.f45138d) {
                System.currentTimeMillis();
            }
            F();
            if (i2 != this.f45139e || i3 != this.f45140f) {
                this.f45139e = i2;
                this.f45140f = i3;
                s(" w * h : " + i2 + " * " + i3);
                r();
            }
            if (i2 == 0 || i3 == 0) {
                return;
            }
            p();
            b bVar = this.f45137c;
            if (bVar != null) {
                bVar.g();
            }
        }
    }

    @Override // d.a.c0.b.a.e
    public int d(MediaTrack mediaTrack, int i2, Map<String, float[]> map) {
        a D;
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaTrack, i2, map)) == null) {
            try {
                if (this.f45137c != null && i2 != 0 && mediaTrack != null && this.l != null && this.k != null && (D = D(map, mediaTrack)) != null) {
                    return this.f45137c.e(i2, D);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                t(e2.toString(), e2);
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0091 */
    /* JADX DEBUG: Multi-variable search result rejected for r11v1, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: float[] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v3, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.c0.b.a.e
    public int f(MediaTrack mediaTrack, int i2, int i3, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        int w;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{mediaTrack, Integer.valueOf(i2), Integer.valueOf(i3), map})) != null) {
            return invokeCommon.intValue;
        }
        try {
            try {
                if (this.f45137c != null && mediaTrack != null && this.l != null && this.k != null) {
                    b bVar = this.f45137c;
                    float f2 = mediaTrack.glClearColor[0];
                    float f3 = mediaTrack.glClearColor[1];
                    float f4 = mediaTrack.glClearColor[2];
                    i4 = mediaTrack.glClearColor[3];
                    bVar.h(f2, f3, f4, i4);
                    ArrayList arrayList = new ArrayList();
                    try {
                        if (mediaTrack.mediaSegments == null || mediaTrack.mediaSegments.size() <= this.f45142h) {
                            i5 = i2;
                        } else {
                            MediaSegment mediaSegment = mediaTrack.mediaSegments.get(this.f45142h);
                            i5 = i2 == 0 ? mediaSegment.textureId : i2;
                            if (i3 == 1) {
                                w = w(mediaSegment, i5, map);
                            } else if (i3 == 2) {
                                w = v(mediaSegment, i5, map);
                            } else if (i3 == 3) {
                                w = x(mediaTrack, i5, map);
                            } else if (i3 != 4) {
                                w = y(mediaTrack, mediaSegment, i5, map, arrayList);
                            } else {
                                z(map, arrayList, mediaTrack);
                            }
                            i5 = w;
                        }
                        if (i5 != 0 && arrayList.size() > 0) {
                            i5 = this.f45137c.f(i5, arrayList);
                        }
                        return i5;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        t(e.toString(), e);
                        b bVar2 = this.f45137c;
                        if (bVar2 != null) {
                            bVar2.h(0.0f, 0.0f, 0.0f, 0.0f);
                        }
                        return i4;
                    }
                }
                b bVar3 = this.f45137c;
                if (bVar3 != null) {
                    bVar3.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return i2;
            } finally {
                b bVar4 = this.f45137c;
                if (bVar4 != null) {
                    bVar4.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        } catch (Exception e3) {
            e = e3;
            i4 = i2;
        }
    }

    @Override // d.a.c0.b.a.e
    public int h(MediaSegment mediaSegment, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, mediaSegment, i2, map)) == null) ? mediaSegment == null ? i2 : q(mediaSegment, i2, map) : invokeLIL.intValue;
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
    @Override // d.a.c0.b.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(MediaTrack mediaTrack, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(1048580, this, mediaTrack, i2, map)) != null) {
            return invokeLIL.intValue;
        }
        try {
            try {
                if (this.f45137c != null && mediaTrack != null && this.l != null && this.k != null) {
                    this.f45137c.h(mediaTrack.glClearColor[0], mediaTrack.glClearColor[1], mediaTrack.glClearColor[2], mediaTrack.glClearColor[3]);
                    ArrayList arrayList = new ArrayList();
                    i2 = A(map, arrayList, mediaTrack, i2);
                    if (i2 != 0 && arrayList.size() > 0) {
                        return this.f45137c.f(i2, arrayList);
                    }
                    bVar = this.f45137c;
                }
                b bVar2 = this.f45137c;
                if (bVar2 != null) {
                    bVar2.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return i2;
            } catch (Exception e2) {
                e2.printStackTrace();
                t(e2.toString(), e2);
                bVar = this.f45137c;
            }
        } finally {
            b bVar3 = this.f45137c;
            if (bVar3 != null) {
                bVar3.h(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }
}
