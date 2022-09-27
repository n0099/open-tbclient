package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
@Keep
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    public static native String a(Context context);

    @Keep
    public static native boolean a(Context context, String str);

    @Keep
    public static native PackageInfo b(Context context, String str);
}
