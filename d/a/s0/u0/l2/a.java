package d.a.s0.u0.l2;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.u0.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1725a extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1725a() {
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
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            Throwable th;
            HttpURLConnection httpURLConnection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length == 0) {
                    return null;
                }
                try {
                    httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    try {
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(3000);
                            httpURLConnection.setReadTimeout(3000);
                            httpURLConnection.getResponseCode();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            d.a.c.e.m.a.e(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        d.a.c.e.m.a.e(httpURLConnection);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = null;
                    d.a.c.e.m.a.e(httpURLConnection);
                    throw th;
                }
                d.a.c.e.m.a.e(httpURLConnection);
                return null;
            }
            return (Integer) invokeL.objValue;
        }
    }

    public static void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c(list.get(1));
    }

    public static void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c(list.get(0));
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        new C1725a().execute(str + "&TIME=" + System.currentTimeMillis());
    }
}
