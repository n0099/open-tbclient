package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
/* loaded from: classes.dex */
public class Elements implements Cloneable, List<Element> {
    private List<Element> contents;

    public Elements() {
        this.contents = new ArrayList();
    }

    public Elements(int i) {
        this.contents = new ArrayList(i);
    }

    public Elements(Collection<Element> collection) {
        this.contents = new ArrayList(collection);
    }

    public Elements(List<Element> list) {
        this.contents = list;
    }

    public Elements(Element... elementArr) {
        this((List<Element>) Arrays.asList(elementArr));
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Elements clone() {
        try {
            Elements elements = (Elements) super.clone();
            ArrayList arrayList = new ArrayList();
            elements.contents = arrayList;
            for (Element element : this.contents) {
                arrayList.add(element.clone());
            }
            return elements;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String attr(String str) {
        for (Element element : this.contents) {
            if (element.hasAttr(str)) {
                return element.attr(str);
            }
        }
        return "";
    }

    public boolean hasAttr(String str) {
        for (Element element : this.contents) {
            if (element.hasAttr(str)) {
                return true;
            }
        }
        return false;
    }

    public Elements attr(String str, String str2) {
        for (Element element : this.contents) {
            element.attr(str, str2);
        }
        return this;
    }

    public Elements removeAttr(String str) {
        for (Element element : this.contents) {
            element.removeAttr(str);
        }
        return this;
    }

    public Elements addClass(String str) {
        for (Element element : this.contents) {
            element.addClass(str);
        }
        return this;
    }

    public Elements removeClass(String str) {
        for (Element element : this.contents) {
            element.removeClass(str);
        }
        return this;
    }

    public Elements toggleClass(String str) {
        for (Element element : this.contents) {
            element.toggleClass(str);
        }
        return this;
    }

    public boolean hasClass(String str) {
        for (Element element : this.contents) {
            if (element.hasClass(str)) {
                return true;
            }
        }
        return false;
    }

    public String val() {
        return size() > 0 ? first().val() : "";
    }

    public Elements val(String str) {
        for (Element element : this.contents) {
            element.val(str);
        }
        return this;
    }

    public String text() {
        StringBuilder sb = new StringBuilder();
        for (Element element : this.contents) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(element.text());
        }
        return sb.toString();
    }

    public boolean hasText() {
        for (Element element : this.contents) {
            if (element.hasText()) {
                return true;
            }
        }
        return false;
    }

    public String html() {
        StringBuilder sb = new StringBuilder();
        for (Element element : this.contents) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append(element.html());
        }
        return sb.toString();
    }

    public String outerHtml() {
        StringBuilder sb = new StringBuilder();
        for (Element element : this.contents) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append(element.outerHtml());
        }
        return sb.toString();
    }

    public String toString() {
        return outerHtml();
    }

    public Elements tagName(String str) {
        for (Element element : this.contents) {
            element.tagName(str);
        }
        return this;
    }

    public Elements html(String str) {
        for (Element element : this.contents) {
            element.html(str);
        }
        return this;
    }

    public Elements prepend(String str) {
        for (Element element : this.contents) {
            element.prepend(str);
        }
        return this;
    }

    public Elements append(String str) {
        for (Element element : this.contents) {
            element.append(str);
        }
        return this;
    }

    public Elements before(String str) {
        for (Element element : this.contents) {
            element.before(str);
        }
        return this;
    }

    public Elements after(String str) {
        for (Element element : this.contents) {
            element.after(str);
        }
        return this;
    }

    public Elements wrap(String str) {
        Validate.notEmpty(str);
        for (Element element : this.contents) {
            element.wrap(str);
        }
        return this;
    }

    public Elements unwrap() {
        for (Element element : this.contents) {
            element.unwrap();
        }
        return this;
    }

    public Elements empty() {
        for (Element element : this.contents) {
            element.empty();
        }
        return this;
    }

    public Elements remove() {
        for (Element element : this.contents) {
            element.remove();
        }
        return this;
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Elements not(String str) {
        return Selector.filterOut(this, Selector.select(str, this));
    }

    public Elements eq(int i) {
        return this.contents.size() > i ? new Elements(get(i)) : new Elements();
    }

    public boolean is(String str) {
        return !select(str).isEmpty();
    }

    public Elements parents() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Element element : this.contents) {
            linkedHashSet.addAll(element.parents());
        }
        return new Elements(linkedHashSet);
    }

    public Element first() {
        if (this.contents.isEmpty()) {
            return null;
        }
        return this.contents.get(0);
    }

    public Element last() {
        if (this.contents.isEmpty()) {
            return null;
        }
        return this.contents.get(this.contents.size() - 1);
    }

    public Elements traverse(NodeVisitor nodeVisitor) {
        Validate.notNull(nodeVisitor);
        NodeTraversor nodeTraversor = new NodeTraversor(nodeVisitor);
        for (Element element : this.contents) {
            nodeTraversor.traverse(element);
        }
        return this;
    }

    public List<FormElement> forms() {
        ArrayList arrayList = new ArrayList();
        for (Element element : this.contents) {
            if (element instanceof FormElement) {
                arrayList.add((FormElement) element);
            }
        }
        return arrayList;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.contents.size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.contents.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.contents.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Element> iterator() {
        return this.contents.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.contents.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.contents.toArray(tArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List, java.util.Collection
    public boolean add(Element element) {
        return this.contents.add(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.contents.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.contents.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Element> collection) {
        return this.contents.addAll(collection);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends Element> collection) {
        return this.contents.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.contents.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.contents.retainAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.contents.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.contents.equals(obj);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.contents.hashCode();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    public Element get(int i) {
        return this.contents.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    public Element set(int i, Element element) {
        return this.contents.set(i, element);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    public void add(int i, Element element) {
        this.contents.add(i, element);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    public Element remove(int i) {
        return this.contents.remove(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.contents.indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.contents.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Element> listIterator() {
        return this.contents.listIterator();
    }

    @Override // java.util.List
    public ListIterator<Element> listIterator(int i) {
        return this.contents.listIterator(i);
    }

    @Override // java.util.List
    public List<Element> subList(int i, int i2) {
        return this.contents.subList(i, i2);
    }
}
