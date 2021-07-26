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
    public static final String f34492a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f34493b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f34494c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f34495d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f34496e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f34497f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f34498g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f34499h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f34500i;
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
        f34492a = KsAdSDKImpl.get().getAppId() + "3.3.11";
        f34493b = f34492a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f34494c = f34492a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f34495d = f34492a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f34496e = f34492a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f34497f = f34492a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f34498g = f34492a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f34499h = f34492a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f34500i = f34492a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        j = f34492a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f34492a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f34492a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f34492a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f34492a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
