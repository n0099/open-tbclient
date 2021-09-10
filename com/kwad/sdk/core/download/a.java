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
    public static final String f71611a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f71612b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f71613c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f71614d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f71615e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f71616f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f71617g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f71618h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f71619i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f71620j;
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
        f71611a = KsAdSDKImpl.get().getAppId() + "3.3.11";
        f71612b = f71611a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f71613c = f71611a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f71614d = f71611a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f71615e = f71611a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f71616f = f71611a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f71617g = f71611a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f71618h = f71611a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f71619i = f71611a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        f71620j = f71611a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f71611a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f71611a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f71611a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f71611a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
