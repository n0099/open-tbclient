package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
/* renamed from: com.kuaishou.weapon.p0.ʻˆ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0297 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f20;

    public C0297(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20 = context;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m147(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                String str2 = new String(C0446.m974("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2));
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                if (str2.length() >= 16) {
                    if (str2.length() > 16) {
                        substring = str2.substring(0, 16);
                    }
                    return new String(AbstractC0301.m163(C0307.m189(C0440.m938(str2.substring(0, 16), str2.substring(0, 16), C0446.m974(str.getBytes(), 2)), str2.substring(0, 16))));
                }
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                substring = sb.toString();
                str2 = substring;
                return new String(AbstractC0301.m163(C0307.m189(C0440.m938(str2.substring(0, 16), str2.substring(0, 16), C0446.m974(str.getBytes(), 2)), str2.substring(0, 16))));
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m148(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return m149(str, new String(C0446.m974("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    /* renamed from: ʻ  reason: contains not printable characters */
    public String m149(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                if (str2.length() < 16) {
                    int length = str2.length();
                    StringBuilder sb = new StringBuilder(str2);
                    for (int i = 0; i < 16 - length; i++) {
                        sb.append("0");
                    }
                    str2 = sb.toString();
                } else if (str2.length() > 16) {
                    str2 = str2.substring(0, 16);
                }
                byte[] m974 = C0446.m974(str.getBytes(), 2);
                return new String(AbstractC0301.m163(Engine.loadSuccess ? Engine.getInstance(this.f20).dr(Engine.getInstance(this.f20).dc(m974, str2.substring(0, 16).getBytes()), str2.getBytes()) : C0307.m189(C0440.m938(str2.substring(0, 16), str2.substring(0, 16), m974), str2.substring(0, 16))));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m150(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return m151(str, new String(C0446.m974("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m151(String str, String str2) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            byte[] m161 = AbstractC0301.m161(str.getBytes());
            if (Engine.loadSuccess) {
                bArr = Engine.getInstance(this.f20).ac(Engine.getInstance(this.f20).ar(m161, str2.getBytes()), str2.substring(0, 16).getBytes());
            } else {
                try {
                    bArr = C0440.m940(str2.substring(0, 16), str2.substring(0, 16), C0307.m191(m161, str2));
                } catch (Throwable unused) {
                    bArr = null;
                }
            }
            if (bArr != null && bArr.length > 0) {
                return C0446.m979(bArr, 2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m152(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            try {
                return m151(str, new String(C0446.m974(str2.getBytes(), 2)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
