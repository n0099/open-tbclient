package com.kwad.sdk.core.download;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f64435a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f64436b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f64437c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f64438d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f64439e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f64440f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f64441g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f64442h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f64443i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(303278412, "Lcom/kwad/sdk/core/download/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(303278412, "Lcom/kwad/sdk/core/download/a;");
                return;
            }
        }
        f64435a = KsAdSDKImpl.get().getAppId() + "3.3.11.4";
        f64436b = f64435a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f64437c = f64435a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f64438d = f64435a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f64439e = f64435a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f64440f = f64435a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f64441g = f64435a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f64442h = f64435a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f64443i = f64435a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        j = f64435a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f64435a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f64435a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f64435a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f64435a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
