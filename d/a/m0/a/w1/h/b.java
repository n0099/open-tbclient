package d.a.m0.a.w1.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import d.a.m0.a.k;
import d.a.m0.a.w1.j.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f49365d = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public static b f49366e;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f49367a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f49368b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f49369c = new ArrayList();

    public static b c() {
        if (f49366e == null) {
            synchronized (b.class) {
                if (f49366e == null) {
                    f49366e = new b();
                }
            }
        }
        return f49366e;
    }

    public Bitmap a(String str) {
        c cVar;
        HashMap<String, c> hashMap = this.f49368b;
        if (hashMap == null || (cVar = hashMap.get(str)) == null) {
            return null;
        }
        return cVar.a();
    }

    public List<String> b() {
        return this.f49369c;
    }

    public Bitmap d() {
        return this.f49367a;
    }

    public boolean e() {
        List<String> list = this.f49369c;
        return list != null && list.size() > 0;
    }

    public void f(String str) {
        if (f49365d) {
            Log.d("EmojiInfoManager", "get emoji info from " + str);
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String D = d.a.m0.t.d.D(new File(str + File.separator + "emoji.json"));
            if (TextUtils.isEmpty(D)) {
                if (f49365d) {
                    Log.d("EmojiInfoManager", "读取emoji配置文件失败");
                    return;
                }
                return;
            }
            try {
                JSONArray optJSONArray = new JSONObject(D).optJSONArray("packages");
                if (optJSONArray == null) {
                    return;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                if (optJSONObject == null) {
                    return;
                }
                String optString = optJSONObject.optString("package_icon");
                if (!TextUtils.isEmpty(optString)) {
                    this.f49367a = BitmapFactory.decodeFile(str + File.separator + optString);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("emoticons");
                this.f49369c.clear();
                this.f49368b.clear();
                if (optJSONArray2 != null) {
                    int length = optJSONArray2.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray2.get(i2);
                        String optString2 = jSONObject.optString("id");
                        String optString3 = jSONObject.optString("text");
                        String optString4 = jSONObject.optString("icon");
                        Bitmap decodeFile = BitmapFactory.decodeFile(str + File.separator + optString4);
                        if (!TextUtils.isEmpty(optString3) && decodeFile != null) {
                            this.f49369c.add(optString3);
                            this.f49368b.put(optString3, new c(optString2, optString3, decodeFile));
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (f49365d) {
            Log.d("EmojiInfoManager", "文件路径错误");
        }
    }

    public SpannableString g(Context context, CharSequence charSequence, TextView textView) {
        Object aVar;
        if (f49365d) {
            Log.d("EmojiInfoManager", "parseEmotion in UI thread, use cache");
        }
        SpannableString spannableString = new SpannableString(charSequence);
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            Bitmap a2 = c().a(group);
            if (a2 == null) {
                break;
            }
            int textSize = (int) ((textView.getTextSize() * 11.0f) / 10.0f);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a2, textSize, textSize, true);
            if (createScaledBitmap != null) {
                if (textView instanceof EditText) {
                    aVar = new f.b(context.getApplicationContext(), createScaledBitmap);
                } else {
                    aVar = new f.a(context.getApplicationContext(), createScaledBitmap);
                }
                spannableString.setSpan(aVar, start, group.length() + start, 33);
            }
        }
        return spannableString;
    }
}
