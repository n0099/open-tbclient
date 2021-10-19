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
    public static final String f71965a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f71966b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f71967c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f71968d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f71969e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f71970f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f71971g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f71972h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f71973i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f71974j;
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
        f71965a = KsAdSDKImpl.get().getAppId() + "3.3.11";
        f71966b = f71965a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f71967c = f71965a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f71968d = f71965a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f71969e = f71965a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f71970f = f71965a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f71971g = f71965a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f71972h = f71965a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f71973i = f71965a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        f71974j = f71965a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f71965a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f71965a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f71965a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f71965a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
