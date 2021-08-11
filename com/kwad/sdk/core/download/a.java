package com.kwad.sdk.core.download;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f71231a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f71232b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f71233c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f71234d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f71235e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f71236f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f71237g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f71238h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f71239i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f71240j;
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
        f71231a = KsAdSDKImpl.get().getAppId() + "3.3.11";
        f71232b = f71231a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f71233c = f71231a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f71234d = f71231a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f71235e = f71231a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f71236f = f71231a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f71237g = f71231a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f71238h = f71231a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f71239i = f71231a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        f71240j = f71231a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f71231a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f71231a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f71231a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f71231a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
