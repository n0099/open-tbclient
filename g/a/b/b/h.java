package g.a.b.b;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public class h {

    /* renamed from: g  reason: collision with root package name */
    public static h f68718g;

    /* renamed from: h  reason: collision with root package name */
    public static h f68719h;
    public static h i;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68720a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68721b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68722c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68723d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68724e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f68725f;

    static {
        h hVar = new h();
        f68718g = hVar;
        hVar.f68720a = true;
        hVar.f68721b = false;
        hVar.f68722c = false;
        hVar.f68723d = false;
        hVar.f68724e = true;
        hVar.f68725f = 0;
        h hVar2 = new h();
        f68719h = hVar2;
        hVar2.f68720a = true;
        hVar2.f68721b = true;
        hVar2.f68722c = false;
        hVar2.f68723d = false;
        hVar2.f68724e = false;
        f68718g.f68725f = 1;
        h hVar3 = new h();
        i = hVar3;
        hVar3.f68720a = false;
        hVar3.f68721b = true;
        hVar3.f68722c = false;
        hVar3.f68723d = true;
        hVar3.f68724e = false;
        hVar3.f68725f = 2;
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.f68721b) {
            if (clsArr.length == 0) {
                stringBuffer.append("()");
                return;
            } else {
                stringBuffer.append("(..)");
                return;
            }
        }
        stringBuffer.append("(");
        c(stringBuffer, clsArr);
        stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (!this.f68722c || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        c(stringBuffer, clsArr);
    }

    public void c(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            stringBuffer.append(g(clsArr[i2]));
        }
    }

    public String d(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public String e(int i2) {
        if (this.f68723d) {
            String modifier = Modifier.toString(i2);
            if (modifier.length() == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(modifier);
            stringBuffer.append(" ");
            return stringBuffer.toString();
        }
        return "";
    }

    public String f(Class cls, String str) {
        return h(cls, str, this.f68724e);
    }

    public String g(Class cls) {
        return h(cls, cls.getName(), this.f68720a);
    }

    public String h(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            if (z) {
                return i(str).replace('$', IStringUtil.EXTENSION_SEPARATOR);
            }
            return str.replace('$', IStringUtil.EXTENSION_SEPARATOR);
        }
        Class<?> componentType = cls.getComponentType();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h(componentType, componentType.getName(), z));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    public String i(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }
}
