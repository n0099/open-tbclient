package com.tachikoma.core.component.network.delegate;

import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.api.IRequestDelegateInner;
import com.tachikoma.core.component.network.ResponseCallBackInner;
import com.tachikoma.core.component.network.TKErrorInner;
import com.tachikoma.core.utility.UIThreadUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class RequestConnectionDelegate implements IRequestDelegateInner {
    public static /* synthetic */ Interceptable $ic = null;
    public static String METHOD_GET = "GET";
    public static String METHOD_POST = "POST";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> bodys;
    public Map<String, String> header;
    public String host;
    public Map<String, String> params;
    public String path;
    public String scheme;
    public int timeout;
    public Map<String, Object> userInfo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-984822102, "Lcom/tachikoma/core/component/network/delegate/RequestConnectionDelegate;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-984822102, "Lcom/tachikoma/core/component/network/delegate/RequestConnectionDelegate;");
        }
    }

    public RequestConnectionDelegate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public void configHttpURLConn(HttpURLConnection httpURLConnection, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, httpURLConnection, hashMap) == null) || hashMap == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            String obj = entry.getKey().toString();
            Object value = entry.getValue();
            if (obj.equals("Authorization")) {
                value = "Basic " + new String(Base64.getEncoder().encode("username:password".getBytes()));
            }
            httpURLConnection.setRequestProperty(obj, (String) value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String convertInputStreamToString(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, inputStream)) == null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private String param2String(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, hashMap)) == null) {
            String str = "";
            if (hashMap == null) {
                return "";
            }
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                String obj = entry.getKey().toString();
                Object value = entry.getValue();
                str = str + "&" + obj + "=" + value.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private void sendHttpGetRequest(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, ResponseCallBackInner responseCallBackInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{str, str2, Integer.valueOf(i), hashMap, hashMap2, responseCallBackInner}) == null) {
            new Thread(new Runnable(this, str + param2String(hashMap2), i, hashMap, responseCallBackInner) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RequestConnectionDelegate this$0;
                public final /* synthetic */ ResponseCallBackInner val$callback;
                public final /* synthetic */ HashMap val$header;
                public final /* synthetic */ int val$timeout;
                public final /* synthetic */ String val$urlString;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Integer.valueOf(i), hashMap, responseCallBackInner};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$urlString = r7;
                    this.val$timeout = i;
                    this.val$header = hashMap;
                    this.val$callback = responseCallBackInner;
                }

                /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
                @Override // java.lang.Runnable
                @RequiresApi(api = 26)
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Throwable th;
                    HttpURLConnection httpURLConnection;
                    IOException e;
                    MalformedURLException e2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HttpURLConnection httpURLConnection2 = null;
                        try {
                            try {
                                httpURLConnection = (HttpURLConnection) new URL(this.val$urlString).openConnection();
                            } catch (Throwable th2) {
                                th = th2;
                                if (0 != 0) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        } catch (MalformedURLException e3) {
                            httpURLConnection = null;
                            e2 = e3;
                        } catch (IOException e4) {
                            httpURLConnection = null;
                            e = e4;
                        } catch (Throwable th3) {
                            th = th3;
                            if (0 != 0) {
                            }
                            throw th;
                        }
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(this.val$timeout);
                            httpURLConnection.setReadTimeout(8000);
                            httpURLConnection.setRequestProperty("Content-Type", "application/json");
                            this.this$0.configHttpURLConn(httpURLConnection, this.val$header);
                            if (httpURLConnection.getResponseCode() != 200) {
                                httpURLConnection.getResponseCode();
                                if (this.val$callback != null) {
                                    UIThreadUtil.runOnUiThread(new Runnable(this) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.this$1.val$callback.onError(null);
                                            }
                                        }
                                    });
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                        return;
                                    }
                                    return;
                                }
                            }
                            InputStream inputStream = httpURLConnection.getInputStream();
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                            String convertInputStreamToString = this.this$0.convertInputStreamToString(bufferedInputStream);
                            bufferedInputStream.close();
                            inputStream.close();
                            UIThreadUtil.runOnUiThread(new Runnable(this, convertInputStreamToString) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.1.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ String val$reponse;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, convertInputStreamToString};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$reponse = convertInputStreamToString;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.val$callback == null) {
                                        return;
                                    }
                                    TKBaseResponseInner tKBaseResponseInner = new TKBaseResponseInner();
                                    tKBaseResponseInner.body = this.val$reponse;
                                    this.this$1.val$callback.onComplete(tKBaseResponseInner);
                                }
                            });
                            if (httpURLConnection == null) {
                                return;
                            }
                        } catch (MalformedURLException e5) {
                            e2 = e5;
                            UIThreadUtil.runOnUiThread(new Runnable(this, e2) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.1.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ MalformedURLException val$e;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, e2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$e = e2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.val$callback == null) {
                                        return;
                                    }
                                    TKErrorInner tKErrorInner = new TKErrorInner();
                                    tKErrorInner.name = "Exception";
                                    tKErrorInner.msg = this.val$e.toString();
                                    this.this$1.val$callback.onError(tKErrorInner);
                                }
                            });
                            if (httpURLConnection == null) {
                                return;
                            }
                            httpURLConnection.disconnect();
                        } catch (IOException e6) {
                            e = e6;
                            UIThreadUtil.runOnUiThread(new Runnable(this, e) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.1.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ IOException val$e;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, e};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$e = e;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.val$callback == null) {
                                        return;
                                    }
                                    TKErrorInner tKErrorInner = new TKErrorInner();
                                    tKErrorInner.name = "IOException";
                                    tKErrorInner.msg = this.val$e.toString();
                                    this.this$1.val$callback.onError(tKErrorInner);
                                }
                            });
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return;
                        }
                        httpURLConnection.disconnect();
                    }
                }
            }).start();
        }
    }

    private void sendHttpPostRequest(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, ResponseCallBackInner responseCallBackInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, str2, Integer.valueOf(i), hashMap, hashMap2, responseCallBackInner}) == null) {
            new Thread(new Runnable(this, str + param2String(hashMap2), i, hashMap, responseCallBackInner) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RequestConnectionDelegate this$0;
                public final /* synthetic */ ResponseCallBackInner val$callback;
                public final /* synthetic */ HashMap val$header;
                public final /* synthetic */ int val$timeout;
                public final /* synthetic */ String val$urlString;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, Integer.valueOf(i), hashMap, responseCallBackInner};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$urlString = r7;
                    this.val$timeout = i;
                    this.val$header = hashMap;
                    this.val$callback = responseCallBackInner;
                }

                /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
                @Override // java.lang.Runnable
                @RequiresApi(api = 26)
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Throwable th;
                    HttpURLConnection httpURLConnection;
                    IOException e;
                    MalformedURLException e2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HttpURLConnection httpURLConnection2 = null;
                        try {
                            try {
                                httpURLConnection = (HttpURLConnection) new URL(this.val$urlString).openConnection();
                                try {
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setConnectTimeout(this.val$timeout);
                                    httpURLConnection.setReadTimeout(8000);
                                    this.this$0.configHttpURLConn(httpURLConnection, this.val$header);
                                    httpURLConnection.setDoInput(true);
                                    httpURLConnection.setDoInput(true);
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                                    bufferedOutputStream.write("".getBytes());
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                    outputStream.close();
                                    if (httpURLConnection.getResponseCode() != 200) {
                                        httpURLConnection.getResponseCode();
                                        if (this.val$callback != null) {
                                            UIThreadUtil.runOnUiThread(new Runnable(this) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.2.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass2 this$1;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i2 = newInitContext.flag;
                                                        if ((i2 & 1) != 0) {
                                                            int i3 = i2 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$1 = this;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                        this.this$1.val$callback.onError(null);
                                                    }
                                                }
                                            });
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    InputStream inputStream = httpURLConnection.getInputStream();
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                                    String convertInputStreamToString = this.this$0.convertInputStreamToString(bufferedInputStream);
                                    bufferedInputStream.close();
                                    inputStream.close();
                                    UIThreadUtil.runOnUiThread(new Runnable(this, convertInputStreamToString) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.2.2
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass2 this$1;
                                        public final /* synthetic */ String val$reponse;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, convertInputStreamToString};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$reponse = convertInputStreamToString;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.val$callback == null) {
                                                return;
                                            }
                                            TKBaseResponseInner tKBaseResponseInner = new TKBaseResponseInner();
                                            tKBaseResponseInner.body = this.val$reponse;
                                            this.this$1.val$callback.onComplete(tKBaseResponseInner);
                                        }
                                    });
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                } catch (MalformedURLException e3) {
                                    e2 = e3;
                                    UIThreadUtil.runOnUiThread(new Runnable(this, e2) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.2.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass2 this$1;
                                        public final /* synthetic */ MalformedURLException val$e;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, e2};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$e = e2;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.val$callback == null) {
                                                return;
                                            }
                                            TKErrorInner tKErrorInner = new TKErrorInner();
                                            tKErrorInner.name = "MalformedURLException";
                                            tKErrorInner.msg = this.val$e.toString();
                                            this.this$1.val$callback.onError(tKErrorInner);
                                        }
                                    });
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                    httpURLConnection.disconnect();
                                } catch (IOException e4) {
                                    e = e4;
                                    UIThreadUtil.runOnUiThread(new Runnable(this, e) { // from class: com.tachikoma.core.component.network.delegate.RequestConnectionDelegate.2.4
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass2 this$1;
                                        public final /* synthetic */ IOException val$e;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, e};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$e = e;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.val$callback == null) {
                                                return;
                                            }
                                            TKErrorInner tKErrorInner = new TKErrorInner();
                                            tKErrorInner.name = "IOException";
                                            tKErrorInner.msg = this.val$e.toString();
                                            this.this$1.val$callback.onError(tKErrorInner);
                                        }
                                    });
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    return;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (0 != 0) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        } catch (MalformedURLException e5) {
                            httpURLConnection = null;
                            e2 = e5;
                        } catch (IOException e6) {
                            httpURLConnection = null;
                            e = e6;
                        } catch (Throwable th3) {
                            th = th3;
                            if (0 != 0) {
                            }
                            throw th;
                        }
                        httpURLConnection.disconnect();
                    }
                }
            }).start();
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void get(ResponseCallBackInner responseCallBackInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, responseCallBackInner) == null) {
            HashMap<String, Object> hashMap = this.header != null ? new HashMap<>(this.header) : new HashMap<>();
            HashMap<String, Object> hashMap2 = this.params != null ? new HashMap<>(this.params) : new HashMap<>();
            String str = this.path;
            send(str != null ? this.host.concat(str) : this.host, METHOD_GET, this.timeout, hashMap, hashMap2, responseCallBackInner);
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void post(ResponseCallBackInner responseCallBackInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallBackInner) == null) {
            HashMap<String, Object> hashMap = this.header != null ? new HashMap<>(this.header) : new HashMap<>();
            HashMap<String, Object> hashMap2 = this.params != null ? new HashMap<>(this.params) : new HashMap<>();
            String str = this.path;
            send(str != null ? this.host.concat(str) : this.host, METHOD_POST, this.timeout, hashMap, hashMap2, responseCallBackInner);
        }
    }

    public void send(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, ResponseCallBackInner responseCallBackInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), hashMap, hashMap2, responseCallBackInner}) == null) {
            if (METHOD_GET.equals(str2)) {
                sendHttpGetRequest(str, str2, i, hashMap, hashMap2, responseCallBackInner);
            } else if (METHOD_POST.equals(str2)) {
                sendHttpPostRequest(str, str2, i, hashMap, hashMap2, responseCallBackInner);
            }
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void setBody(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            this.bodys = map;
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void setHeader(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            this.header = map;
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void setHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.host = str;
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void setInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.timeout = i;
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            this.params = map;
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void setPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.path = str;
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.scheme = str;
        }
    }

    @Override // com.tachikoma.core.api.IRequestDelegateInner
    public void setUserInfo(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, map) == null) {
            this.userInfo = map;
        }
    }
}
