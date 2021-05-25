package d.a.l0.h.g0.f;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f47389a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f47390b;

    public d(String str, Object obj) {
        this.f47389a = str;
        this.f47390b = obj;
    }

    public static Object a(d.a.l0.a.l0.c cVar, String str, String str2, d dVar) {
        if (dVar.g()) {
            return dVar.d();
        }
        String a2 = a.a(str, str2, dVar.e());
        cVar.throwJSException(JSExceptionType.Error, a2);
        return a2;
    }

    public static d b(@NonNull String str) {
        return new d(str, null);
    }

    public static String f(int i2) {
        switch (i2) {
            case 1:
                return "boolean";
            case 2:
            case 3:
            case 5:
                return IdCardActivity.KEY_NUMBER;
            case 4:
            default:
                return "unknown";
            case 6:
                return "array";
            case 7:
                return "string";
            case 8:
                return "function";
            case 9:
                return "object";
            case 10:
                return "arraybuffer";
            case 11:
                return StringUtil.NULL_STRING;
            case 12:
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
        }
    }

    public static Object h() {
        return new JsObject();
    }

    public static d i(@Nullable Object obj) {
        return new d(null, obj);
    }

    public String c(String str, String str2) {
        if (g()) {
            return a.b(str);
        }
        return a.a(str, str2, e());
    }

    public Object d() {
        return this.f47390b;
    }

    public String e() {
        return this.f47389a;
    }

    public boolean g() {
        return this.f47389a == null;
    }
}
