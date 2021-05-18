package d.a.c.e.b.b.a.c;

import android.text.TextUtils;
import android.util.SparseArray;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/* loaded from: classes.dex */
public class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public Element f38812a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f38813b = new HashSet();

    public h(Element element) {
        String nodeName;
        String nodeName2;
        this.f38812a = element;
        if (element != null) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                Node item = attributes.item(i2);
                if (item != null && (nodeName2 = item.getNodeName()) != null) {
                    this.f38813b.add(nodeName2);
                }
            }
            NodeList childNodes = element.getChildNodes();
            int length2 = childNodes.getLength();
            for (int i3 = 0; i3 < length2; i3++) {
                Node item2 = childNodes.item(i3);
                if (item2 != null && (nodeName = item2.getNodeName()) != null) {
                    this.f38813b.add(nodeName);
                }
            }
        }
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Set<String> a() {
        return this.f38813b;
    }

    @Override // d.a.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        if (obj == null || str == null) {
            return;
        }
        if (obj instanceof Boolean) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Byte) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Character) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Short) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Integer) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Long) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Float) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof String) {
            this.f38812a.setAttribute(str, String.valueOf(obj));
        } else if (obj.getClass().isArray() || d.a.c.e.b.a.a.g(obj.getClass(), List.class) || d.a.c.e.b.a.a.g(obj.getClass(), Queue.class) || d.a.c.e.b.a.a.g(obj.getClass(), Set.class) || d.a.c.e.b.a.a.g(obj.getClass(), Map.class)) {
        } else {
            d.a.c.e.b.a.a.g(obj.getClass(), SparseArray.class);
        }
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        Object d2 = d(str);
        if (d2 != null) {
            d.a.c.e.b.b.a.e.c cVar = new d.a.c.e.b.b.a.e.c(type);
            d.a.c.e.b.b.a.d.h a2 = d.a.c.e.b.b.a.e.g.a(d2);
            return a2 != null ? a2.a(cVar) : d2;
        }
        return d2;
    }

    public Object d(String str) {
        String nodeName;
        String attribute = this.f38812a.getAttribute(str);
        if (TextUtils.isEmpty(attribute)) {
            NodeList childNodes = this.f38812a.getChildNodes();
            int length = childNodes.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                Node item = childNodes.item(i2);
                if (item != null && (nodeName = item.getNodeName()) != null && nodeName.equals(str)) {
                    arrayList.add(item);
                }
            }
            return arrayList;
        }
        return attribute;
    }
}
