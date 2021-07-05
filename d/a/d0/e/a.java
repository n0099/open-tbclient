package d.a.d0.e;

import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Xml;
import androidx.multidex.MultiDexExtractor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f45253f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f45254g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f45255a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Integer> f45256b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f45257c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Integer> f45258d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45259e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1972324766, "Ld/a/d0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1972324766, "Ld/a/d0/e/a;");
                return;
            }
        }
        f45253f = "nps" + File.separator + "manifest";
        f45254g = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45255a = new HashMap();
        this.f45256b = new HashMap();
        this.f45257c = new HashMap();
        this.f45258d = new HashMap();
        this.f45259e = false;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f45254g : (a) invokeV.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Integer num = this.f45258d.get(str);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            g();
            if (this.f45257c.containsKey(str)) {
                return this.f45257c.get(str).intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public List<BundleInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g();
            ArrayList arrayList = new ArrayList();
            for (String str : this.f45257c.keySet()) {
                BundleInfo bundleInfo = new BundleInfo();
                bundleInfo.setPackageName(str);
                bundleInfo.setMinVersion(this.f45257c.get(str).intValue());
                arrayList.add(bundleInfo);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            g();
            return this.f45255a.get(str);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0067, code lost:
        if (r0 != null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
            return invokeV.booleanValue;
        }
        synchronized (this) {
            if (this.f45259e) {
                return true;
            }
            InputStream inputStream = null;
            try {
                AssetManager assets = ContextHolder.getApplicationContext().getAssets();
                inputStream = assets.open(f45253f + File.separator + "manifest.json");
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Xml.Encoding.UTF_8.toString()), 8192);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                h(new JSONArray(sb.toString()), this.f45257c, this.f45255a, this.f45256b, this.f45258d);
            } catch (IOException unused) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        this.f45259e = true;
                        return true;
                    }
                }
                this.f45259e = true;
                return true;
            } catch (JSONException unused3) {
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f45259e = true;
                return true;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }

    public final synchronized boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (this.f45259e) {
                    return true;
                }
                f();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void h(JSONArray jSONArray, Map<String, Integer> map, Map<String, String> map2, Map<Integer, Integer> map3, Map<String, Integer> map4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, jSONArray, map, map2, map3, map4) == null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME);
                    if (!TextUtils.isEmpty(optString)) {
                        map.put(optString, Integer.valueOf(optJSONObject.optInt("min_version")));
                        JSONArray optJSONArray = optJSONObject.optJSONArray("activity");
                        if (optJSONArray != null) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                                if (optJSONObject2 != null) {
                                    String optString2 = optJSONObject2.optString("name");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        map2.put(optString2, optString);
                                        map4.put(optString2, 1);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("service");
                        if (optJSONArray2 != null) {
                            for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                                if (optJSONObject3 != null) {
                                    String optString3 = optJSONObject3.optString("name");
                                    if (!TextUtils.isEmpty(optString3)) {
                                        map2.put(optString3, optString);
                                        map4.put(optString3, 2);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("provider");
                        if (optJSONArray3 != null) {
                            for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i5);
                                if (optJSONObject4 != null) {
                                    String optString4 = optJSONObject4.optString("name");
                                    if (!TextUtils.isEmpty(optString4)) {
                                        map2.put(optString4, optString);
                                        map4.put(optString4, 4);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray4 = optJSONObject.optJSONArray(SocialConstants.PARAM_RECEIVER);
                        if (optJSONArray4 != null) {
                            for (int i6 = 0; i6 < optJSONArray4.length(); i6++) {
                                JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i6);
                                if (optJSONObject5 != null) {
                                    String optString5 = optJSONObject5.optString("name");
                                    if (!TextUtils.isEmpty(optString5)) {
                                        map2.put(optString5, optString);
                                        map4.put(optString5, 3);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray5 = optJSONObject.optJSONArray(MultiDexExtractor.DEX_PREFIX);
                        if (optJSONArray5 != null) {
                            for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                                JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i7);
                                if (optJSONObject6 != null) {
                                    String optString6 = optJSONObject6.optString("name");
                                    if (!TextUtils.isEmpty(optString6)) {
                                        map2.put(optString6, optString);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray("ids");
                        if (optJSONArray6 != null) {
                            for (int i8 = 0; i8 < optJSONArray6.length(); i8++) {
                                JSONObject optJSONObject7 = optJSONArray6.optJSONObject(i8);
                                if (optJSONObject7 != null) {
                                    int optInt = optJSONObject7.optInt("bundle");
                                    int optInt2 = optJSONObject7.optInt("host");
                                    if (optInt > 0 && optInt2 > 0) {
                                        map3.put(Integer.valueOf(optInt), Integer.valueOf(optInt2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
