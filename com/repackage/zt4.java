package com.repackage;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            HttpURLConnection httpURLConnection;
            DataOutputStream dataOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                HttpURLConnection httpURLConnection2 = null;
                if (strArr != null) {
                    ?? length = strArr.length;
                    try {
                        if (length != 0) {
                            try {
                                httpURLConnection = (HttpURLConnection) new URL("https://appc.baidu.com/appsrv?action=appdistributionlog&native_api=1").openConnection();
                                try {
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setDoInput(true);
                                    httpURLConnection.setConnectTimeout(fb.d().c().b());
                                    httpURLConnection.setReadTimeout(fb.d().b().b());
                                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                                    httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                                    httpURLConnection.connect();
                                    try {
                                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                        try {
                                            dataOutputStream.write(strArr[0].getBytes("UTF-8"));
                                            dataOutputStream.flush();
                                            ig.d(dataOutputStream);
                                            httpURLConnection.getResponseCode();
                                        } catch (Throwable th) {
                                            th = th;
                                            ig.d(dataOutputStream);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        dataOutputStream = null;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    ig.e(httpURLConnection);
                                    return null;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                httpURLConnection = null;
                            } catch (Throwable th3) {
                                th = th3;
                                ig.e(httpURLConnection2);
                                throw th;
                            }
                            ig.e(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection2 = length;
                    }
                }
                return null;
            }
            return (Integer) invokeL.objValue;
        }
    }

    public static void a(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, downloadData, i) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            ItemDownloadExtraData itemDownloadExtraData = (ItemDownloadExtraData) downloadData.getExtra();
            if (ki.isEmpty(itemDownloadExtraData.shouzhuSource)) {
                itemDownloadExtraData.shouzhuSource = au4.f().g(itemDownloadExtraData.pkgName);
            }
            c(downloadData, i);
            b(itemDownloadExtraData.pkgName, itemDownloadExtraData.appName, itemDownloadExtraData.shouzhuScene, itemDownloadExtraData.shouzhuCategory, itemDownloadExtraData.shouzhuSource, i);
        }
    }

    public static void b(String str, String str2, int i, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pkgname", str);
                jSONObject.put("appname", str2);
                jSONObject.put("host", 4);
                jSONObject.put("scene", i);
                jSONObject.put("category", i2);
                jSONObject.put("event", i3);
                jSONObject.put("source", str3);
                new a().execute(jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    public static void c(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, downloadData, i) == null) {
            if (i != 100 && i != 200) {
                if (i != 300) {
                    if (i != 400) {
                        if (i != 500) {
                            if (i != 600) {
                                if (i == 700 || i == 800) {
                                    au4.f().e(downloadData);
                                    return;
                                } else if (i != 900) {
                                    return;
                                } else {
                                    au4.f().k(downloadData);
                                    return;
                                }
                            }
                        }
                    }
                    au4.f().j(downloadData);
                    return;
                }
                au4.f().d(downloadData);
                return;
            }
            au4.f();
        }
    }
}
