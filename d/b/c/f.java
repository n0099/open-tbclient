package d.b.c;

import android.text.TextUtils;
import com.baidu.afd.ParseError;
import com.baidu.mobstat.Config;
import com.baidu.tieba.recapp.activity.AdDebugActivity;
import com.facebook.common.util.UriUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static e a(JSONObject jSONObject, String str) throws ParseError {
        if (jSONObject != null) {
            String optString = jSONObject.optString("locCode");
            if (!TextUtils.isEmpty(optString)) {
                String str2 = null;
                if (str == null || optString.startsWith(str)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                        if (optJSONObject != null) {
                            boolean z = optJSONObject.optInt("advisible", 1) == 0;
                            if (z && optJSONObject.has("ext_info")) {
                                str2 = optJSONObject.optString("ext_info", null);
                            }
                            if (str2 == null) {
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray("extra");
                                if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                                    int length = optJSONArray2.length();
                                    int i = 0;
                                    while (true) {
                                        if (i >= length) {
                                            break;
                                        }
                                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                                        if (optJSONObject2 != null) {
                                            String optString2 = optJSONObject2.optString(Config.APP_KEY);
                                            String optString3 = optJSONObject2.optString("v");
                                            if (!TextUtils.isEmpty(optString3) && TextUtils.equals("extraParam", optString2)) {
                                                str2 = optString3;
                                                break;
                                            }
                                        }
                                        i++;
                                    }
                                } else {
                                    throw new ParseError(1, "adInfo has no extraParams");
                                }
                            }
                            if (str2 != null) {
                                if (z) {
                                    return a.a(str2, str);
                                }
                                JSONArray optJSONArray3 = optJSONObject.optJSONArray("material");
                                if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                                    JSONObject optJSONObject3 = optJSONArray3.optJSONObject(0);
                                    if (optJSONObject3 != null) {
                                        try {
                                            JSONArray jSONArray = new JSONArray(optJSONObject3.optString("info"));
                                            if (jSONArray.length() != 0) {
                                                JSONObject optJSONObject4 = jSONArray.optJSONObject(0);
                                                if (optJSONObject4 != null) {
                                                    e eVar = new e();
                                                    eVar.f42492a = z;
                                                    eVar.f42494c = d.b.i0.i1.o.b.i(optJSONObject4.optJSONObject(AdDebugActivity.KEY_LEGO).toString());
                                                    eVar.f42493b = str2;
                                                    return eVar;
                                                }
                                                throw new ParseError(1, "info array has no first element");
                                            }
                                            throw new ParseError(1, "material has no info array");
                                        } catch (JSONException unused) {
                                            throw new ParseError(1, "material has no info array");
                                        }
                                    }
                                    throw new ParseError(1, "adInfo has no material info");
                                }
                                throw new ParseError(1, "adInfo has no material info");
                            }
                            throw new ParseError(1, "adInfo has no extraParam info");
                        }
                        throw new ParseError(1, "adInfo array has no element");
                    }
                    throw new ParseError(1, "first ad has no adInfo");
                }
                return null;
            }
            throw new ParseError(2, "missing locCode");
        }
        throw new ParseError(1, "ad has no element");
    }

    public static e b(JSONObject jSONObject, String str) throws ParseError {
        if (jSONObject != null) {
            if (jSONObject.optInt("errno", 0) > 0) {
                return new e();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    return a(optJSONArray.optJSONObject(0), str);
                }
                throw new ParseError(1, "res missing key ad");
            }
            throw new ParseError(1, "root missing key res");
        }
        throw new ParseError(1, "afd/entry retun null");
    }
}
