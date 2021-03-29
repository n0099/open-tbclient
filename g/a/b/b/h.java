package g.a.b.b;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public class h {

    /* renamed from: g  reason: collision with root package name */
    public static h f67565g;

    /* renamed from: h  reason: collision with root package name */
    public static h f67566h;
    public static h i;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67567a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67568b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67569c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67570d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67571e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f67572f;

    static {
        h hVar = new h();
        f67565g = hVar;
        hVar.f67567a = true;
        hVar.f67568b = false;
        hVar.f67569c = false;
        hVar.f67570d = false;
        hVar.f67571e = true;
        hVar.f67572f = 0;
        h hVar2 = new h();
        f67566h = hVar2;
        hVar2.f67567a = true;
        hVar2.f67568b = true;
        hVar2.f67569c = false;
        hVar2.f67570d = false;
        hVar2.f67571e = false;
        f67565g.f67572f = 1;
        h hVar3 = new h();
        i = hVar3;
        hVar3.f67567a = false;
        hVar3.f67568b = true;
        hVar3.f67569c = false;
        hVar3.f67570d = true;
        hVar3.f67571e = false;
        hVar3.f67572f = 2;
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.f67568b) {
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
        if (!this.f67569c || clsArr == null || clsArr.length == 0) {
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
        if (this.f67570d) {
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
        return h(cls, str, this.f67571e);
    }

    public String g(Class cls) {
        return h(cls, cls.getName(), this.f67567a);
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
