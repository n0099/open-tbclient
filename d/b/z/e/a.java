package d.b.z.e;

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

    /* renamed from: e  reason: collision with root package name */
    public static final String f64879e = "nps" + File.separator + "manifest";

    /* renamed from: f  reason: collision with root package name */
    public static final a f64880f = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f64881a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Integer> f64882b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f64883c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f64884d = false;

    public static a a() {
        return f64880f;
    }

    public int b(String str) {
        f();
        if (this.f64883c.containsKey(str)) {
            return this.f64883c.get(str).intValue();
        }
        return -1;
    }

    public List<BundleInfo> c() {
        f();
        ArrayList arrayList = new ArrayList();
        for (String str : this.f64883c.keySet()) {
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(str);
            bundleInfo.setMinVersion(this.f64883c.get(str).intValue());
            arrayList.add(bundleInfo);
        }
        return arrayList;
    }

    public String d(String str) {
        f();
        return this.f64881a.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
        if (r0 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean e() {
        if (this.f64884d) {
            return true;
        }
        InputStream inputStream = null;
        try {
            AssetManager assets = ContextHolder.getApplicationContext().getAssets();
            inputStream = assets.open(f64879e + File.separator + "manifest.json");
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Xml.Encoding.UTF_8.toString()), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            g(new JSONArray(sb.toString()), this.f64883c, this.f64881a, this.f64882b);
        } catch (IOException unused) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    this.f64884d = true;
                    return true;
                }
            }
            this.f64884d = true;
            return true;
        } catch (JSONException unused3) {
            if (inputStream != null) {
                inputStream.close();
            }
            this.f64884d = true;
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

    public final synchronized boolean f() {
        if (this.f64884d) {
            return true;
        }
        e();
        return true;
    }

    public final void g(JSONArray jSONArray, Map<String, Integer> map, Map<String, String> map2, Map<Integer, Integer> map3) {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME);
                if (!TextUtils.isEmpty(optString)) {
                    map.put(optString, Integer.valueOf(optJSONObject.optInt("min_version")));
                    JSONArray optJSONArray = optJSONObject.optJSONArray("activity");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                String optString2 = optJSONObject2.optString("name");
                                if (!TextUtils.isEmpty(optString2)) {
                                    map2.put(optString2, optString);
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("service");
                    if (optJSONArray2 != null) {
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                            if (optJSONObject3 != null) {
                                String optString3 = optJSONObject3.optString("name");
                                if (!TextUtils.isEmpty(optString3)) {
                                    map2.put(optString3, optString);
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("provider");
                    if (optJSONArray3 != null) {
                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                            JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i4);
                            if (optJSONObject4 != null) {
                                String optString4 = optJSONObject4.optString("name");
                                if (!TextUtils.isEmpty(optString4)) {
                                    map2.put(optString4, optString);
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject.optJSONArray(SocialConstants.PARAM_RECEIVER);
                    if (optJSONArray4 != null) {
                        for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                            JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i5);
                            if (optJSONObject5 != null) {
                                String optString5 = optJSONObject5.optString("name");
                                if (!TextUtils.isEmpty(optString5)) {
                                    map2.put(optString5, optString);
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray5 = optJSONObject.optJSONArray(MultiDexExtractor.DEX_PREFIX);
                    if (optJSONArray5 != null) {
                        for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                            JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i6);
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
                        for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                            JSONObject optJSONObject7 = optJSONArray6.optJSONObject(i7);
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
