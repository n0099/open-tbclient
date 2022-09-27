package com.heytap.openid.sdk;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.crypto.SecretKey;
@Keep
/* loaded from: classes7.dex */
public class m_g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    public static native String m_a(Context context, int i, String str);

    @Keep
    public static native SecretKey m_a(String str);

    @Keep
    public static native byte[] m_a(String str, String str2, String str3);

    @Keep
    public static native SecretKey m_b(String str);
}
