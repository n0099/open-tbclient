package d.f.b.a.d0.w;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import d.f.b.a.a0.t.v;
import d.f.b.a.i0.s;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class c implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // d.f.b.a.d0.w.f
    public Pair<d.f.b.a.a0.e, Boolean> a(d.f.b.a.a0.e eVar, Uri uri, Format format, List<Format> list, DrmInitData drmInitData, s sVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{eVar, uri, format, list, drmInitData, sVar})) == null) {
            String lastPathSegment = uri.getLastPathSegment();
            boolean z = true;
            if (!"text/vtt".equals(format.sampleMimeType) && !lastPathSegment.endsWith(".webvtt") && !lastPathSegment.endsWith(".vtt")) {
                if (lastPathSegment.endsWith(".aac")) {
                    eVar = new d.f.b.a.a0.t.c();
                } else if (!lastPathSegment.endsWith(".ac3") && !lastPathSegment.endsWith(".ec3")) {
                    if (lastPathSegment.endsWith(EmotionResourceProvider.EMOTION_SOUND_SUFFIX)) {
                        eVar = new d.f.b.a.a0.p.b(0, 0L);
                    } else if (eVar == null) {
                        if (!lastPathSegment.endsWith(".mp4") && !lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4)) {
                            int i2 = 16;
                            if (list != null) {
                                i2 = 48;
                            } else {
                                list = Collections.emptyList();
                            }
                            String str = format.codecs;
                            if (!TextUtils.isEmpty(str)) {
                                if (!"audio/mp4a-latm".equals(d.f.b.a.i0.i.a(str))) {
                                    i2 |= 2;
                                }
                                if (!"video/avc".equals(d.f.b.a.i0.i.f(str))) {
                                    i2 |= 4;
                                }
                            }
                            eVar = new v(2, sVar, new d.f.b.a.a0.t.e(i2, list));
                        } else {
                            eVar = new d.f.b.a.a0.q.e(0, sVar, null, drmInitData);
                        }
                    }
                } else {
                    eVar = new d.f.b.a.a0.t.a();
                }
                return Pair.create(eVar, Boolean.valueOf(z));
            }
            eVar = new n(format.language, sVar);
            z = false;
            return Pair.create(eVar, Boolean.valueOf(z));
        }
        return (Pair) invokeCommon.objValue;
    }
}
