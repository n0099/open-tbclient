package org.jsoup.select;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
/* loaded from: classes.dex */
public class Selector {
    private final Evaluator evaluator;
    private final Element root;

    private Selector(String str, Element element) {
        Validate.notNull(str);
        String trim = str.trim();
        Validate.notEmpty(trim);
        Validate.notNull(element);
        this.evaluator = QueryParser.parse(trim);
        this.root = element;
    }

    public static Elements select(String str, Element element) {
        return new Selector(str, element).select();
    }

    public static Elements select(String str, Iterable<Element> iterable) {
        Validate.notEmpty(str);
        Validate.notNull(iterable);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Element element : iterable) {
            linkedHashSet.addAll(select(str, element));
        }
        return new Elements(linkedHashSet);
    }

    private Elements select() {
        return Collector.collect(this.evaluator, this.root);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Elements filterOut(Collection<Element> collection, Collection<Element> collection2) {
        boolean z;
        Elements elements = new Elements();
        for (Element element : collection) {
            Iterator<Element> it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (element.equals(it.next())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                elements.add(element);
            }
        }
        return elements;
    }

    /* loaded from: classes.dex */
    public class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }
}
