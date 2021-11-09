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
    public static final String f64434a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f64435b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f64436c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f64437d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f64438e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f64439f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f64440g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f64441h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f64442i;
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
        f64434a = KsAdSDKImpl.get().getAppId() + "3.3.11.4";
        f64435b = f64434a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f64436c = f64434a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f64437d = f64434a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f64438e = f64434a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f64439f = f64434a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f64440g = f64434a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f64441h = f64434a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f64442i = f64434a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        j = f64434a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f64434a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f64434a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f64434a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f64434a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
