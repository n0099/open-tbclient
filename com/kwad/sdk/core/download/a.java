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
    public static final String f71431a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f71432b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f71433c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f71434d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f71435e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f71436f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f71437g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f71438h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f71439i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f71440j;
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
        f71431a = KsAdSDKImpl.get().getAppId() + "3.3.11";
        f71432b = f71431a + "ACTION_DOWNLOAD_ONDOWNLOAD";
        f71433c = f71431a + "ACTION_DOWNLOAD_ONPROGRESSUPDATE";
        f71434d = f71431a + "ACTION_DOWNLOAD_ONDOWNLOADFINISHED";
        f71435e = f71431a + "ACTION_DOWNLOAD_ONDOWNLOADFAILED";
        f71436f = f71431a + "ACTION_DOWNLOAD_ONDOWNLOADPAUSEED";
        f71437g = f71431a + "ACTION_DOWNLOAD_ONDOWNLOADRESUMEED";
        f71438h = f71431a + "ACTION_DOWNLOAD_ONDOWNLOADCANCELED";
        f71439i = f71431a + "ACTION_DOWNLOAD_ONSTARTINSTALLAPK";
        f71440j = f71431a + "ACTION_DOWNLOAD_ONINSTALLINGAPK";
        k = f71431a + "ACTION_DOWNLOAD_ONAPKINSTALLED";
        l = f71431a + "ACTION_DOWNLOAD_ONAPKINSTALLFAILED";
        m = f71431a + "ACTION_DOWNLOAD_ONLOWSTORAGE";
        n = f71431a + "ACTION_DOWNLOAD_TO_CANCEL";
    }
}
