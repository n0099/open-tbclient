package d.a.h0.g.i0;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes3.dex */
public class b {
    public static void a(d.a.h0.g.e.d.c cVar, boolean z, Object obj) {
        d.a.h0.g.e.d.a e2 = d.a.h0.g.e.d.a.e(cVar);
        if (z) {
            e2.d(obj);
        } else {
            e2.b(obj);
        }
    }

    public static String b(@NonNull String str, @NonNull JSTypeMismatchException jSTypeMismatchException) {
        return String.format("%s:fail parameter error: parameter.%s should be %s instead of %s", str, jSTypeMismatchException.name, d(jSTypeMismatchException.requiredType), d(jSTypeMismatchException.actualType));
    }

    public static String c(@NonNull String str, @NonNull String str2) {
        return String.format("%s: %s", str, str2);
    }

    public static String d(int i2) {
        switch (i2) {
            case 1:
                return "boolean";
            case 2:
            case 3:
            case 5:
                return IdCardActivity.KEY_NUMBER;
            case 4:
            case 9:
            case 10:
            default:
                return "object";
            case 6:
                return "array object";
            case 7:
                return "string";
            case 8:
                return "function object";
            case 11:
                return StringUtil.NULL_STRING;
            case 12:
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
        }
    }

    public static void e(d.a.h0.g.i.b bVar, JSTypeMismatchException jSTypeMismatchException) {
        bVar.throwJSException(JSExceptionType.TypeError, String.format("The \"%s\" argument must be %s. Received type %s", jSTypeMismatchException.name, d(jSTypeMismatchException.requiredType), d(jSTypeMismatchException.actualType)));
    }
}
