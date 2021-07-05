package d.a.q0.a.z0;

import android.widget.EditText;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.c0.c.f.a;
import d.a.q0.a.k;
import d.a.q0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51914a;

    /* renamed from: b  reason: collision with root package name */
    public static a.g f51915b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(133558296, "Ld/a/q0/a/z0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(133558296, "Ld/a/q0/a/z0/c;");
                return;
            }
        }
        f51914a = k.f49133a;
    }

    public static void a(a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, gVar) == null) {
            f51915b = gVar;
        }
    }

    public static void b(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, editText, i2) == null) {
            e(editText, "blur", i2);
        }
    }

    public static void c(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, editText, i2) == null) || editText == null || f51915b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", WriteImageActivity.CHANGE_FLAG);
            jSONObject.put("cursorOffset", editText.getSelectionStart());
            jSONObject.put("keyCode", i2);
        } catch (JSONException e2) {
            if (f51914a) {
                e2.printStackTrace();
            }
        }
        f51915b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void d(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65540, null, editText, i2) == null) {
            e(editText, "confirm", i2);
        }
    }

    public static void e(EditText editText, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, editText, str, i2) == null) || editText == null || f51915b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", str);
            jSONObject.put("cursorOffset", editText.getText().length());
            jSONObject.put("keyboardHeight", n0.K(i2));
        } catch (JSONException e2) {
            if (f51914a) {
                e2.printStackTrace();
            }
        }
        f51915b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void f(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, editText, i2) == null) {
            e(editText, AddFriendActivityConfig.TYPE_FOCUS, i2);
        }
    }
}
