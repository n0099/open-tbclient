package d.a.q0.a.w1;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.h;
import d.a.q0.a.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51453a;

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f51454b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f51455c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(130817493, "Ld/a/q0/a/w1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(130817493, "Ld/a/q0/a/w1/b;");
                return;
            }
        }
        f51453a = k.f49133a;
        f51454b = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"title", "image", ReplyEditorParams.MODULE_EMOJI, "video", "friends", "target"});
        f51455c = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"image", ReplyEditorParams.MODULE_EMOJI});
    }

    public static final PublishParams a(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i2;
        float f2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("moduleList");
                ArrayList arrayList = new ArrayList(f51455c);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    arrayList.clear();
                    int length = optJSONArray.length();
                    for (int i6 = 0; i6 < length; i6++) {
                        try {
                            String string = optJSONArray.getString(i6);
                            if (f51454b.contains(string)) {
                                arrayList.add(string);
                            }
                        } catch (JSONException e2) {
                            if (f51453a) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                if (arrayList.isEmpty() && f51453a) {
                    Log.d("PublishParams", "展示列表为空");
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("imageConf");
                if (optJSONObject != null) {
                    double d2 = 1.0f;
                    i2 = Math.min(9, optJSONObject.optInt("maxNum", 9));
                    f2 = (float) Math.min(d2, jSONObject.optDouble("ratio", d2));
                } else {
                    i2 = 9;
                    f2 = 1.0f;
                }
                Application context = d.a.q0.a.c1.a.b();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String b2 = b(context, jSONObject, "contentPlaceholder", h.swanapp_publisher_post_content);
                String e3 = e(b(context, jSONObject, "titlePlaceholder", h.swanapp_publisher_post_title), 20, null, 4, null);
                String e4 = e(b(context, jSONObject, "confirmText", h.swanapp_publisher_publish_text), 4, null, 4, null);
                String e5 = e(b(context, jSONObject, "cancelText", h.aiapps_cancel), 4, null, 4, null);
                String e6 = e(b(context, jSONObject, "navBarTitleText", h.swanapp_publisher_title), 8, null, 4, null);
                String c2 = c(jSONObject, "navBarTextStyle", "");
                if (!CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"black", "white"}).contains(c2)) {
                    c2 = "black";
                }
                int parseColor = Color.parseColor(c2);
                try {
                    i3 = Color.parseColor(c(jSONObject, "navBarBackgroundColor", "#FFFFFF"));
                } catch (Exception e7) {
                    if (f51453a) {
                        e7.printStackTrace();
                    }
                    i3 = -1;
                }
                int color = context.getResources().getColor(d.a.q0.a.c.swanapp_publish_btn_enable_color);
                try {
                    i4 = Color.parseColor(c(jSONObject, "confirmColor", "#3388FF"));
                } catch (Exception e8) {
                    if (f51453a) {
                        e8.printStackTrace();
                    }
                    i4 = color;
                }
                try {
                    i5 = Color.parseColor(c(jSONObject, "cancelColor", "#000000"));
                } catch (Exception e9) {
                    if (f51453a) {
                        e9.printStackTrace();
                    }
                    i5 = -16777216;
                }
                return new PublishParams(b2, e3, e6, parseColor, i3, e4, i4, e5, i5, jSONObject.optString("targetText", ""), jSONObject.optString("emojiPath", ""), jSONObject.optString("cb"), i2, f2, arrayList, null, null, 98304, null);
            }
            return null;
        }
        return (PublishParams) invokeL.objValue;
    }

    public static final String b(@NonNull Context context, @NonNull JSONObject obj, @NonNull String key, @StringRes int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, null, context, obj, key, i2)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(key, "key");
            String optString = obj.optString(key);
            Intrinsics.checkNotNullExpressionValue(optString, "obj.optString(key)");
            if (StringsKt__StringsJVMKt.isBlank(optString)) {
                String string = context.getString(i2);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(defaultStrRes)");
                return string;
            }
            return optString;
        }
        return (String) invokeLLLI.objValue;
    }

    public static final String c(@NonNull JSONObject obj, @NonNull String key, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, obj, key, str)) == null) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(str, "default");
            String optString = obj.optString(key);
            Intrinsics.checkNotNullExpressionValue(optString, "obj.optString(key)");
            return StringsKt__StringsJVMKt.isBlank(optString) ? str : optString;
        }
        return (String) invokeLLL.objValue;
    }

    public static final String d(String s, int i2, String substitue) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65540, null, s, i2, substitue)) == null) {
            Intrinsics.checkNotNullParameter(s, "s");
            Intrinsics.checkNotNullParameter(substitue, "substitue");
            if (s.length() <= i2) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            String substring = s.substring(0, i2 - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(substitue);
            return sb.toString();
        }
        return (String) invokeLIL.objValue;
    }

    public static /* synthetic */ String e(String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = StringHelper.STRING_MORE;
        }
        return d(str, i2, str2);
    }
}
