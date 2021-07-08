package d.a.c.e.n;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Typography;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BasicNameValuePair> f41312a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f41313b;

    /* renamed from: c  reason: collision with root package name */
    public long f41314c;

    /* renamed from: d  reason: collision with root package name */
    public g f41315d;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41313b = new StringBuilder(100);
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.replace(" ", "_").replace(PreferencesUtil.LEFT_MOUNT, "(").replace(PreferencesUtil.RIGHT_MOUNT, SmallTailInfo.EMOTION_SUFFIX).replace("&", "|") : (String) invokeL.objValue;
    }

    public void a(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, obj, obj2) == null) || obj == null || obj2 == null) {
            return;
        }
        if (this.f41312a == null) {
            this.f41312a = new ArrayList<>();
        }
        this.f41312a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (this.f41313b.length() > 0) {
            this.f41313b.append(Typography.amp);
        }
        this.f41313b.append(str);
        this.f41313b.append("=");
        try {
            this.f41313b.append(URLEncoder.encode(h(str2), "utf-8"));
        } catch (Throwable th) {
            BdLog.e(th);
            this.f41313b.append(h(str2));
        }
    }

    public void c(Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) || objArr == null) {
            return;
        }
        for (int i2 = 0; i2 < objArr.length / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            if (i4 < objArr.length) {
                a(objArr[i3], objArr[i4]);
            }
        }
    }

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (this.f41315d == null) {
                this.f41315d = new g();
            }
            this.f41315d.f(cVar);
            ArrayList<BasicNameValuePair> arrayList = this.f41312a;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<BasicNameValuePair> it = this.f41312a.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if ("module".equals(next.getName())) {
                        this.f41315d.i(next.getValue());
                    } else if ("st".equals(next.getName())) {
                        this.f41315d.e(next.getValue());
                    } else if ("errNo".equals(next.getName())) {
                        this.f41315d.g(next.getValue());
                    } else if ("errMsg".equals(next.getName())) {
                        this.f41315d.h(next.getValue());
                    } else {
                        this.f41315d.b(next.getName(), next.getValue());
                    }
                }
            }
            StringBuilder sb = this.f41313b;
            if (sb != null) {
                this.f41315d.a(sb.toString());
            }
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? System.currentTimeMillis() - this.f41314c : invokeV.longValue;
    }

    public g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41315d : (g) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f41314c = System.currentTimeMillis();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder(200);
            if (this.f41313b.length() > 0) {
                sb.append((CharSequence) this.f41313b);
            }
            ArrayList<BasicNameValuePair> arrayList = this.f41312a;
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it = arrayList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                        if (sb.length() > 0) {
                            sb.append(Typography.amp);
                        }
                        sb.append(next.getName());
                        sb.append(com.alipay.sdk.encrypt.a.f1890h);
                        try {
                            sb.append(URLEncoder.encode(h(next.getValue()), "utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            BdLog.e(e2);
                            sb.append(h(next.getValue()));
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41313b = new StringBuilder(100);
    }
}
