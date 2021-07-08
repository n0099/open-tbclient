package com.kwad.sdk.core.download;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f34303a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f34304b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f34305c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f34306d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f34307e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f34308f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f34309g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f34310h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f34311i;
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
        f34303a = KsAdSDKImpl.get().getAppId() + "3.3.11";
        f34304b = f34303a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f34305c = f34303a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f34306d = f34303a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f34307e = f34303a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f34308f = f34303a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f34309g = f34303a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f34310h = f34303a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f34311i = f34303a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        j = f34303a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f34303a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f34303a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f34303a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f34303a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
