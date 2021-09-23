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
    public static final String f71930a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f71931b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f71932c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f71933d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f71934e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f71935f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f71936g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f71937h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f71938i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f71939j;
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
        f71930a = KsAdSDKImpl.get().getAppId() + "3.3.11";
        f71931b = f71930a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f71932c = f71930a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f71933d = f71930a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f71934e = f71930a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f71935f = f71930a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f71936g = f71930a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f71937h = f71930a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f71938i = f71930a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        f71939j = f71930a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f71930a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f71930a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f71930a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f71930a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
