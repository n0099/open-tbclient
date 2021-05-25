package d.a.z.e;

import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Xml;
import androidx.multidex.MultiDexExtractor;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
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
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f64902f = "nps" + File.separator + "manifest";

    /* renamed from: g  reason: collision with root package name */
    public static final a f64903g = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f64904a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Integer> f64905b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f64906c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Integer> f64907d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f64908e = false;

    public static a b() {
        return f64903g;
    }

    public int a(String str) {
        Integer num = this.f64907d.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public int c(String str) {
        g();
        if (this.f64906c.containsKey(str)) {
            return this.f64906c.get(str).intValue();
        }
        return -1;
    }

    public List<BundleInfo> d() {
        g();
        ArrayList arrayList = new ArrayList();
        for (String str : this.f64906c.keySet()) {
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(str);
            bundleInfo.setMinVersion(this.f64906c.get(str).intValue());
            arrayList.add(bundleInfo);
        }
        return arrayList;
    }

    public String e(String str) {
        g();
        return this.f64904a.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        if (r0 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean f() {
        if (this.f64908e) {
            return true;
        }
        InputStream inputStream = null;
        try {
            AssetManager assets = ContextHolder.getApplicationContext().getAssets();
            inputStream = assets.open(f64902f + File.separator + "manifest.json");
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Xml.Encoding.UTF_8.toString()), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            h(new JSONArray(sb.toString()), this.f64906c, this.f64904a, this.f64905b, this.f64907d);
        } catch (IOException unused) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    this.f64908e = true;
                    return true;
                }
            }
            this.f64908e = true;
            return true;
        } catch (JSONException unused3) {
            if (inputStream != null) {
                inputStream.close();
            }
            this.f64908e = true;
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

    public final synchronized boolean g() {
        if (this.f64908e) {
            return true;
        }
        f();
        return true;
    }

    public final void h(JSONArray jSONArray, Map<String, Integer> map, Map<String, String> map2, Map<Integer, Integer> map3, Map<String, Integer> map4) {
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
