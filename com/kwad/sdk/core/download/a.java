package com.kwad.sdk.core.download;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36012a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f36013b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f36014c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f36015d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f36016e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f36017f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f36018g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f36019h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f36020i;
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
        f36012a = KsAdSDKImpl.get().getAppId() + "3.3.9";
        f36013b = f36012a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f36014c = f36012a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f36015d = f36012a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f36016e = f36012a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f36017f = f36012a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f36018g = f36012a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f36019h = f36012a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f36020i = f36012a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        j = f36012a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f36012a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f36012a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f36012a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f36012a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
