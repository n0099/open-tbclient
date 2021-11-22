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
    public static final String f65347a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f65348b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f65349c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f65350d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f65351e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f65352f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f65353g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f65354h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f65355i;
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
        f65347a = KsAdSDKImpl.get().getAppId() + "3.3.11.4";
        f65348b = f65347a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f65349c = f65347a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f65350d = f65347a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f65351e = f65347a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f65352f = f65347a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f65353g = f65347a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f65354h = f65347a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f65355i = f65347a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        j = f65347a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f65347a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f65347a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f65347a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f65347a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
