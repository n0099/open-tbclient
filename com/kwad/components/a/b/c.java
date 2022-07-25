package com.kwad.components.a.b;

import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> Qe;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-125498074, "Lcom/kwad/components/a/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-125498074, "Lcom/kwad/components/a/b/c;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        Qe = arrayList;
        arrayList.add("application/x-javascript");
        Qe.add("image/jpeg");
        Qe.add("image/tiff");
        Qe.add("text/css");
        Qe.add(SapiWebView.DATA_MIME_TYPE);
        Qe.add("image/gif");
        Qe.add("image/png");
        Qe.add("application/javascript");
        Qe.add(MimeTypes.VIDEO_MP4);
        Qe.add(MimeTypes.AUDIO_MPEG);
        Qe.add("application/json");
        Qe.add("image/webp");
        Qe.add("image/apng");
        Qe.add("image/svg+xml");
        Qe.add("application/octet-stream");
    }

    public static boolean aX(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? Qe.contains(str) : invokeL.booleanValue;
    }
}
