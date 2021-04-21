package d.b.c.e.b.b.a.c;

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
    public Element f42374a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f42375b = new HashSet();

    public h(Element element) {
        String nodeName;
        String nodeName2;
        this.f42374a = element;
        if (element != null) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = attributes.item(i);
                if (item != null && (nodeName2 = item.getNodeName()) != null) {
                    this.f42375b.add(nodeName2);
                }
            }
            NodeList childNodes = element.getChildNodes();
            int length2 = childNodes.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                Node item2 = childNodes.item(i2);
                if (item2 != null && (nodeName = item2.getNodeName()) != null) {
                    this.f42375b.add(nodeName);
                }
            }
        }
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Set<String> a() {
        return this.f42375b;
    }

    @Override // d.b.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        if (obj == null || str == null) {
            return;
        }
        if (obj instanceof Boolean) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Byte) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Character) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Short) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Integer) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Long) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Float) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof String) {
            this.f42374a.setAttribute(str, String.valueOf(obj));
        } else if (obj.getClass().isArray() || d.b.c.e.b.a.a.g(obj.getClass(), List.class) || d.b.c.e.b.a.a.g(obj.getClass(), Queue.class) || d.b.c.e.b.a.a.g(obj.getClass(), Set.class) || d.b.c.e.b.a.a.g(obj.getClass(), Map.class)) {
        } else {
            d.b.c.e.b.a.a.g(obj.getClass(), SparseArray.class);
        }
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        Object d2 = d(str);
        if (d2 != null) {
            d.b.c.e.b.b.a.e.c cVar = new d.b.c.e.b.b.a.e.c(type);
            d.b.c.e.b.b.a.d.h a2 = d.b.c.e.b.b.a.e.g.a(d2);
            return a2 != null ? a2.a(cVar) : d2;
        }
        return d2;
    }

    public Object d(String str) {
        String nodeName;
        String attribute = this.f42374a.getAttribute(str);
        if (TextUtils.isEmpty(attribute)) {
            NodeList childNodes = this.f42374a.getChildNodes();
            int length = childNodes.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item != null && (nodeName = item.getNodeName()) != null && nodeName.equals(str)) {
                    arrayList.add(item);
                }
            }
            return arrayList;
        }
        return attribute;
    }
}
