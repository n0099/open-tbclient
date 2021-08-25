package com.dxmpay.wallet.utils.realtimeevent;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class RealTimeEventHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.f.b.g.b.a f69758e;

        public a(c.f.b.g.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69758e = aVar;
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                this.f69758e.destroyBean();
            }
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                this.f69758e.destroyBean();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements Comparator<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? str.compareTo(str2) : invokeLL.intValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public RealTimeEventHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return DomainConfig.getInstance().getAppHost() + "/chanpin_stat?" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            Collections.sort(list, new b(null));
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : list) {
                stringBuffer.append(str);
                stringBuffer.append("&");
            }
            stringBuffer.append("key=");
            stringBuffer.append("MhxzKhl");
            return Md5Utils.toMD5(stringBuffer.toString());
        }
        return (String) invokeL.objValue;
    }

    public static void eventStatBean(Context context, String str, String str2, Map<String, String> map, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, map, str3, str4}) == null) {
            c.f.b.g.b.a aVar = new c.f.b.g.b.a(context, a(getEventValues(context, str, str2, map, str3, str4)));
            aVar.setResponseCallback(new a(aVar));
            aVar.execBean();
        }
    }

    public static ArrayList<String> genEventValue(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, strArr)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                arrayList.add(getSinalParam(str, "sp_no"));
                arrayList.add(getSinalParam(str, "order_no"));
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (!TextUtils.isEmpty(strArr[i2])) {
                        arrayList.add(strArr[i2]);
                    } else {
                        arrayList.add("empty");
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static String getEventValues(Context context, String str, String str2, Map<String, String> map, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, str, str2, map, str3, str4})) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str2) && map == null) {
                return sb.toString();
            }
            try {
                sb.append("event=" + str);
                String sinalParam = getSinalParam(str2, "sp_no");
                sb.append("&sp_no=" + sinalParam);
                String sinalParam2 = getSinalParam(str2, "order_no");
                sb.append("&order_no=" + sinalParam2);
                sb.append("&pay=" + str3);
                String str5 = "";
                if (map.containsKey("key_remote_pkg_name")) {
                    String str6 = map.get("key_remote_pkg_name");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("&caller=");
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "";
                    }
                    sb2.append(str6);
                    sb.append(sb2.toString());
                }
                if (map.containsKey("key_remote_pkg_ver")) {
                    String str7 = map.get("key_remote_pkg_ver");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("&caller_ver=");
                    if (!TextUtils.isEmpty(str7)) {
                        str5 = str7;
                    }
                    sb3.append(str5);
                    sb.append(sb3.toString());
                }
                sb.append("&result=" + str4);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("&is_login=");
                sb4.append(WalletLoginHelper.getInstance().isLogin() ? "1" : "0");
                sb.append(sb4.toString());
                sb.append("&cuid_1=" + PhoneUtils.getCUID(context));
                sb.append("&time=" + System.currentTimeMillis());
                sb.append("&version=2");
                sb.append("&sign_method=1");
                String[] split = sb.toString().split("&");
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, split);
                sb.append("&sign=" + b(arrayList));
                return sb.toString();
            } catch (Exception unused) {
                return sb.toString();
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String getSinalParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                for (String str3 : str.split("&")) {
                    String[] split = str3.split("=");
                    if (split != null && !TextUtils.isEmpty(split[0]) && str2.equalsIgnoreCase(split[0]) && split.length > 1) {
                        return URLDecoder.decode(split[1]);
                    }
                }
                return "";
            } catch (Exception e2) {
                e2.toString();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
