package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<BasicNameValuePair> a;
    public String b;
    public StringBuilder c;
    public long d;
    public zg e;

    public sg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = new StringBuilder(100);
        this.b = str;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.replace(" ", "_").replace(PreferencesUtil.LEFT_MOUNT, "(").replace(PreferencesUtil.RIGHT_MOUNT, SmallTailInfo.EMOTION_SUFFIX).replace("&", "|") : (String) invokeL.objValue;
    }

    public void a(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, obj, obj2) == null) || obj == null || obj2 == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (this.c.length() > 0) {
            this.c.append('&');
        }
        this.c.append(str);
        this.c.append("=");
        try {
            this.c.append(URLEncoder.encode(i(str2), IMAudioTransRequest.CHARSET));
        } catch (Throwable th) {
            BdLog.e(th);
            this.c.append(i(str2));
        }
    }

    public void c(Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) || objArr == null) {
            return;
        }
        for (int i = 0; i < objArr.length / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (i3 < objArr.length) {
                a(objArr[i2], objArr[i3]);
            }
        }
    }

    public void d(vg vgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vgVar) == null) {
            if (this.e == null) {
                this.e = new zg();
            }
            this.e.f(vgVar);
            ArrayList<BasicNameValuePair> arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<BasicNameValuePair> it = this.a.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if ("module".equals(next.getName())) {
                        this.e.i(next.getValue());
                    } else if ("st".equals(next.getName())) {
                        this.e.e(next.getValue());
                    } else if ("errNo".equals(next.getName())) {
                        this.e.g(next.getValue());
                    } else if (StatConstants.KEY_EXT_ERR_MSG.equals(next.getName())) {
                        this.e.h(next.getValue());
                    } else {
                        this.e.b(next.getName(), next.getValue());
                    }
                }
            }
            StringBuilder sb = this.c;
            if (sb != null) {
                this.e.a(sb.toString());
            }
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? System.currentTimeMillis() - this.d : invokeV.longValue;
    }

    public zg f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (zg) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d = System.currentTimeMillis();
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public JSONObject h() {
        InterceptResult invokeV;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.c.length() > 0 && (split = this.c.toString().split("&")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && (split2 = str.split("=")) != null && split2.length == 2) {
                        try {
                            jSONObject.put(split2[0], URLDecoder.decode(split2[1], IMAudioTransRequest.CHARSET));
                        } catch (UnsupportedEncodingException | JSONException e) {
                            BdLog.e(e);
                        }
                    }
                }
            }
            ArrayList<BasicNameValuePair> arrayList = this.a;
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it = arrayList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                        try {
                            jSONObject.put(next.getName(), URLEncoder.encode(i(next.getValue()), IMAudioTransRequest.CHARSET));
                        } catch (UnsupportedEncodingException | JSONException e2) {
                            BdLog.e(e2);
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder(200);
            if (this.c.length() > 0) {
                sb.append((CharSequence) this.c);
            }
            ArrayList<BasicNameValuePair> arrayList = this.a;
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it = arrayList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                        if (sb.length() > 0) {
                            sb.append('&');
                        }
                        sb.append(next.getName());
                        sb.append('=');
                        try {
                            sb.append(URLEncoder.encode(i(next.getValue()), IMAudioTransRequest.CHARSET));
                        } catch (UnsupportedEncodingException e) {
                            BdLog.e(e);
                            sb.append(i(next.getValue()));
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public sg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = new StringBuilder(100);
    }
}
