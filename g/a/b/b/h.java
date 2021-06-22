package g.a.b.b;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.lang.reflect.Modifier;
/* loaded from: classes8.dex */
public class h {

    /* renamed from: g  reason: collision with root package name */
    public static h f71663g;

    /* renamed from: h  reason: collision with root package name */
    public static h f71664h;

    /* renamed from: i  reason: collision with root package name */
    public static h f71665i;

    /* renamed from: a  reason: collision with root package name */
    public boolean f71666a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71667b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71668c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71669d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71670e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f71671f;

    static {
        h hVar = new h();
        f71663g = hVar;
        hVar.f71666a = true;
        hVar.f71667b = false;
        hVar.f71668c = false;
        hVar.f71669d = false;
        hVar.f71670e = true;
        hVar.f71671f = 0;
        h hVar2 = new h();
        f71664h = hVar2;
        hVar2.f71666a = true;
        hVar2.f71667b = true;
        hVar2.f71668c = false;
        hVar2.f71669d = false;
        hVar2.f71670e = false;
        f71663g.f71671f = 1;
        h hVar3 = new h();
        f71665i = hVar3;
        hVar3.f71666a = false;
        hVar3.f71667b = true;
        hVar3.f71668c = false;
        hVar3.f71669d = true;
        hVar3.f71670e = false;
        hVar3.f71671f = 2;
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.f71667b) {
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
        if (!this.f71668c || clsArr == null || clsArr.length == 0) {
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
        if (this.f71669d) {
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
        return h(cls, str, this.f71670e);
    }

    public String g(Class cls) {
        return h(cls, cls.getName(), this.f71666a);
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
