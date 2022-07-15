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
    public static final List<String> a;
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
        a = arrayList;
        arrayList.add("application/x-javascript");
        a.add("image/jpeg");
        a.add("image/tiff");
        a.add("text/css");
        a.add(SapiWebView.DATA_MIME_TYPE);
        a.add("image/gif");
        a.add("image/png");
        a.add("application/javascript");
        a.add(MimeTypes.VIDEO_MP4);
        a.add(MimeTypes.AUDIO_MPEG);
        a.add("application/json");
        a.add("image/webp");
        a.add("image/apng");
        a.add("image/svg+xml");
        a.add("application/octet-stream");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a.contains(str) : invokeL.booleanValue;
    }
}
