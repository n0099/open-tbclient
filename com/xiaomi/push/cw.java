package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class cw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a extends cv {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.xiaomi.push.cv
        public String a(Context context, String str, List<bf> list) {
            InterceptResult invokeLLL;
            URL url;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, list)) == null) {
                if (list == null) {
                    url = new URL(str);
                } else {
                    Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                    for (bf bfVar : list) {
                        buildUpon.appendQueryParameter(bfVar.a(), bfVar.b());
                    }
                    url = new URL(buildUpon.toString());
                }
                return bg.a(context, url);
            }
            return (String) invokeLLL.objValue;
        }
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) ? (((i3 + LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK) / 1448) * 132) + 1080 + i2 + i3 : invokeII.intValue;
    }

    public static int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i2, i3, i4)) == null) ? (((i3 + 200) / 1448) * 132) + 1011 + i3 + i2 + i4 : invokeIII.intValue;
    }

    public static int a(cv cvVar, String str, List<bf> list, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, cvVar, str, list, str2)) == null) {
            if (cvVar.a() == 1) {
                return a(str.length(), a(str2));
            }
            if (cvVar.a() == 2) {
                return a(str.length(), a(list), a(str2));
            }
            return -1;
        }
        return invokeLLLL.intValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                return str.getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int a(List<bf> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            int i2 = 0;
            for (bf bfVar : list) {
                if (!TextUtils.isEmpty(bfVar.a())) {
                    i2 += bfVar.a().length();
                }
                if (!TextUtils.isEmpty(bfVar.b())) {
                    i2 += bfVar.b().length();
                }
            }
            return i2 * 2;
        }
        return invokeL.intValue;
    }

    public static String a(Context context, String str, List<bf> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, list)) == null) ? a(context, str, list, new a(), true) : (String) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae A[Catch: MalformedURLException -> 0x00c7, TRY_ENTER, TryCatch #3 {MalformedURLException -> 0x00c7, blocks: (B:6:0x0013, B:8:0x001a, B:10:0x0024, B:13:0x002b, B:15:0x0031, B:16:0x0034, B:17:0x0039, B:19:0x003f, B:21:0x0048, B:23:0x0050, B:51:0x00ae, B:52:0x00c0), top: B:68:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, List<bf> list, cv cvVar, boolean z) {
        InterceptResult invokeCommon;
        co coVar;
        IOException iOException;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, list, cvVar, Boolean.valueOf(z)})) == null) {
            if (bg.b(context)) {
                try {
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (z) {
                        co m232a = cs.a().m232a(str);
                        if (m232a != null) {
                            arrayList = m232a.a(str);
                        }
                        coVar = m232a;
                    } else {
                        coVar = null;
                    }
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                    Iterator<String> it = arrayList.iterator();
                    String str4 = null;
                    while (it.hasNext()) {
                        String next = it.next();
                        ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                        } catch (IOException e2) {
                            iOException = e2;
                            str2 = str4;
                        }
                        if (!cvVar.m241a(context, next, (List<bf>) arrayList2)) {
                            return str4;
                        }
                        String a2 = cvVar.a(context, next, (List<bf>) arrayList2);
                        try {
                        } catch (IOException e3) {
                            e = e3;
                            str3 = a2;
                        }
                        if (!TextUtils.isEmpty(a2)) {
                            if (coVar != null) {
                                try {
                                    coVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cvVar, next, arrayList2, a2));
                                } catch (IOException e4) {
                                    iOException = e4;
                                    str2 = a2;
                                    if (coVar != null) {
                                        coVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cvVar, next, arrayList2, str2), iOException);
                                    }
                                    iOException.printStackTrace();
                                    str4 = str2;
                                }
                            }
                            return a2;
                        }
                        if (coVar != null) {
                            str3 = a2;
                            try {
                                coVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cvVar, next, arrayList2, a2), null);
                            } catch (IOException e5) {
                                e = e5;
                                String str5 = str3;
                                iOException = e;
                                str2 = str5;
                                if (coVar != null) {
                                }
                                iOException.printStackTrace();
                                str4 = str2;
                            }
                        } else {
                            str3 = a2;
                        }
                        str4 = str3;
                    }
                    return str4;
                } catch (MalformedURLException e6) {
                    e6.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }
}
