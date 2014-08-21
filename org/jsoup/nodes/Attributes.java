package org.jsoup.nodes;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
/* loaded from: classes.dex */
public class Attributes implements Cloneable, Iterable<Attribute> {
    protected static final String dataPrefix = "data-";
    private LinkedHashMap<String, Attribute> attributes = null;

    public String get(String str) {
        Attribute attribute;
        Validate.notEmpty(str);
        return (this.attributes == null || (attribute = this.attributes.get(str.toLowerCase())) == null) ? "" : attribute.getValue();
    }

    public void put(String str, String str2) {
        put(new Attribute(str, str2));
    }

    public void put(Attribute attribute) {
        Validate.notNull(attribute);
        if (this.attributes == null) {
            this.attributes = new LinkedHashMap<>(2);
        }
        this.attributes.put(attribute.getKey(), attribute);
    }

    public void remove(String str) {
        Validate.notEmpty(str);
        if (this.attributes != null) {
            this.attributes.remove(str.toLowerCase());
        }
    }

    public boolean hasKey(String str) {
        return this.attributes != null && this.attributes.containsKey(str.toLowerCase());
    }

    public int size() {
        if (this.attributes == null) {
            return 0;
        }
        return this.attributes.size();
    }

    public void addAll(Attributes attributes) {
        if (attributes.size() != 0) {
            if (this.attributes == null) {
                this.attributes = new LinkedHashMap<>(attributes.size());
            }
            this.attributes.putAll(attributes.attributes);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Attribute> iterator() {
        return asList().iterator();
    }

    public List<Attribute> asList() {
        if (this.attributes == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.attributes.size());
        for (Map.Entry<String, Attribute> entry : this.attributes.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Map<String, String> dataset() {
        return new Dataset();
    }

    public String html() {
        StringBuilder sb = new StringBuilder();
        html(sb, new Document("").outputSettings());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void html(StringBuilder sb, Document.OutputSettings outputSettings) {
        if (this.attributes != null) {
            for (Map.Entry<String, Attribute> entry : this.attributes.entrySet()) {
                sb.append(" ");
                entry.getValue().html(sb, outputSettings);
            }
        }
    }

    public String toString() {
        return html();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Attributes) {
            Attributes attributes = (Attributes) obj;
            if (this.attributes != null) {
                if (this.attributes.equals(attributes.attributes)) {
                    return true;
                }
            } else if (attributes.attributes == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        if (this.attributes != null) {
            return this.attributes.hashCode();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Attributes clone() {
        if (this.attributes == null) {
            return new Attributes();
        }
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.attributes = new LinkedHashMap<>(this.attributes.size());
            Iterator<Attribute> it = iterator();
            while (it.hasNext()) {
                Attribute next = it.next();
                attributes.attributes.put(next.getKey(), next.clone());
            }
            return attributes;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Dataset extends AbstractMap<String, String> {
        private Dataset() {
            if (Attributes.this.attributes == null) {
                Attributes.this.attributes = new LinkedHashMap(2);
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<String, String>> entrySet() {
            return new EntrySet();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        public String put(String str, String str2) {
            String str3;
            String dataKey = Attributes.dataKey(str);
            if (Attributes.this.hasKey(dataKey)) {
                str3 = ((Attribute) Attributes.this.attributes.get(dataKey)).getValue();
            } else {
                str3 = null;
            }
            Attributes.this.attributes.put(dataKey, new Attribute(dataKey, str2));
            return str3;
        }

        /* loaded from: classes.dex */
        class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            private EntrySet() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<String, String>> iterator() {
                return new DatasetIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i = 0;
                while (new DatasetIterator().hasNext()) {
                    i++;
                }
                return i;
            }
        }

        /* loaded from: classes.dex */
        class DatasetIterator implements Iterator<Map.Entry<String, String>> {
            private Attribute attr;
            private Iterator<Attribute> attrIter;

            private DatasetIterator() {
                this.attrIter = Attributes.this.attributes.values().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                while (this.attrIter.hasNext()) {
                    this.attr = this.attrIter.next();
                    if (this.attr.isDataAttribute()) {
                        return true;
                    }
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            public Map.Entry<String, String> next() {
                return new Attribute(this.attr.getKey().substring(Attributes.dataPrefix.length()), this.attr.getValue());
            }

            @Override // java.util.Iterator
            public void remove() {
                Attributes.this.attributes.remove(this.attr.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String dataKey(String str) {
        return dataPrefix + str;
    }
}
