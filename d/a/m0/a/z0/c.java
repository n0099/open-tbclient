package d.a.m0.a.z0;

import android.widget.EditText;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
import d.a.m0.a.c0.c.f.a;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49768a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static a.g f49769b;

    public static void a(a.g gVar) {
        f49769b = gVar;
    }

    public static void b(EditText editText, int i2) {
        e(editText, "blur", i2);
    }

    public static void c(EditText editText, int i2) {
        if (editText == null || f49769b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", WriteImageActivity.CHANGE_FLAG);
            jSONObject.put("cursorOffset", editText.getSelectionStart());
            jSONObject.put("keyCode", i2);
        } catch (JSONException e2) {
            if (f49768a) {
                e2.printStackTrace();
            }
        }
        f49769b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void d(EditText editText, int i2) {
        e(editText, "confirm", i2);
    }

    public static void e(EditText editText, String str, int i2) {
        if (editText == null || f49769b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", str);
            jSONObject.put("cursorOffset", editText.getText().length());
            jSONObject.put("keyboardHeight", n0.K(i2));
        } catch (JSONException e2) {
            if (f49768a) {
                e2.printStackTrace();
            }
        }
        f49769b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void f(EditText editText, int i2) {
        e(editText, AddFriendActivityConfig.TYPE_FOCUS, i2);
    }
}
