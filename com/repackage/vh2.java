package com.repackage;

import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.qv1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class vh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static qv1.g b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755231247, "Lcom/repackage/vh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755231247, "Lcom/repackage/vh2;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(qv1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, gVar) == null) {
            b = gVar;
        }
    }

    public static void b(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, editText, i) == null) {
            e(editText, ConstPath.KEY_BLUR, i);
        }
    }

    public static void c(rv1 rv1Var, EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, rv1Var, editText, i) == null) || editText == null || b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", "change");
            jSONObject.put("cursorOffset", editText.getSelectionStart());
            jSONObject.put("keyCode", i);
        } catch (JSONException e) {
            if (a) {
                e.printStackTrace();
            }
        }
        rv1Var.j(editText.getText().toString());
        rv1Var.l(editText.getSelectionStart(), editText.getSelectionEnd());
        b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void d(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, editText, i) == null) {
            e(editText, "confirm", i);
        }
    }

    public static void e(EditText editText, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65541, null, editText, str, i) == null) || editText == null || b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", editText.getText());
            jSONObject.put("eventName", str);
            jSONObject.put("cursorOffset", editText.getText().length());
            jSONObject.put("keyboardHeight", "" + yc3.O(i));
        } catch (JSONException e) {
            if (a) {
                e.printStackTrace();
            }
        }
        b.a(String.valueOf(editText.getTag()), jSONObject);
    }

    public static void f(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, editText, i) == null) {
            e(editText, AddFriendActivityConfig.TYPE_FOCUS, i);
        }
    }
}
