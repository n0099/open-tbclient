package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import d.f.b.a.a0.t.w;
import java.util.List;
/* loaded from: classes8.dex */
public final class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<Format> f69656a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.a0.m[] f69657b;

    public t(List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69656a = list;
        this.f69657b = new d.f.b.a.a0.m[list.size()];
    }

    public void a(long j, d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, lVar) == null) {
            d.f.b.a.e0.l.g.a(j, lVar, this.f69657b);
        }
    }

    public void b(d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
            for (int i2 = 0; i2 < this.f69657b.length; i2++) {
                dVar.a();
                d.f.b.a.a0.m a2 = gVar.a(dVar.c(), 3);
                Format format = this.f69656a.get(i2);
                String str = format.sampleMimeType;
                boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
                d.f.b.a.i0.a.b(z, "Invalid closed caption mime type provided: " + str);
                String str2 = format.id;
                if (str2 == null) {
                    str2 = dVar.b();
                }
                a2.b(Format.createTextSampleFormat(str2, str, (String) null, -1, format.selectionFlags, format.language, format.accessibilityChannel, (DrmInitData) null));
                this.f69657b[i2] = a2;
            }
        }
    }
}
