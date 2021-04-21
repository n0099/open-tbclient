package d.b.h0.a.t0;

import android.widget.EditText;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
import d.b.h0.a.a0.c.f.a;
import d.b.h0.a.i2.h0;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46946a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static a.g f46947b;

    public static void a(a.g gVar) {
        f46947b = gVar;
    }

    public static void b(EditText editText, int i) {
        e(editText, "blur", i);
    }

    public static void c(EditText editText, int i) {
        if (editText == null || f46947b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", WriteImageActivity.CHANGE_FLAG);
            jSONObject.put("cursorOffset", editText.getSelectionStart());
            jSONObject.put("keyCode", i);
        } catch (JSONException e2) {
            if (f46946a) {
                e2.printStackTrace();
            }
        }
        f46947b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void d(EditText editText, int i) {
        e(editText, "confirm", i);
    }

    public static void e(EditText editText, String str, int i) {
        if (editText == null || f46947b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", str);
            jSONObject.put("cursorOffset", editText.getText().length());
            jSONObject.put("keyboardHeight", h0.H(i));
        } catch (JSONException e2) {
            if (f46946a) {
                e2.printStackTrace();
            }
        }
        f46947b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void f(EditText editText, int i) {
        e(editText, AddFriendActivityConfig.TYPE_FOCUS, i);
    }
}
