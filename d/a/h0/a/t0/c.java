package d.a.h0.a.t0;

import android.widget.EditText;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
import d.a.h0.a.a0.c.f.a;
import d.a.h0.a.i2.h0;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44334a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static a.g f44335b;

    public static void a(a.g gVar) {
        f44335b = gVar;
    }

    public static void b(EditText editText, int i2) {
        e(editText, "blur", i2);
    }

    public static void c(EditText editText, int i2) {
        if (editText == null || f44335b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", WriteImageActivity.CHANGE_FLAG);
            jSONObject.put("cursorOffset", editText.getSelectionStart());
            jSONObject.put("keyCode", i2);
        } catch (JSONException e2) {
            if (f44334a) {
                e2.printStackTrace();
            }
        }
        f44335b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void d(EditText editText, int i2) {
        e(editText, "confirm", i2);
    }

    public static void e(EditText editText, String str, int i2) {
        if (editText == null || f44335b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", str);
            jSONObject.put("cursorOffset", editText.getText().length());
            jSONObject.put("keyboardHeight", h0.H(i2));
        } catch (JSONException e2) {
            if (f44334a) {
                e2.printStackTrace();
            }
        }
        f44335b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void f(EditText editText, int i2) {
        e(editText, AddFriendActivityConfig.TYPE_FOCUS, i2);
    }
}
