package org.apache.http.entity.mime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class Header implements Iterable<MinimalField> {
    public final List<MinimalField> fields = new LinkedList();
    public final Map<String, List<MinimalField>> fieldMap = new HashMap();

    public void addField(MinimalField minimalField) {
        if (minimalField == null) {
            return;
        }
        String lowerCase = minimalField.getName().toLowerCase(Locale.US);
        List<MinimalField> list = this.fieldMap.get(lowerCase);
        if (list == null) {
            list = new LinkedList<>();
            this.fieldMap.put(lowerCase, list);
        }
        list.add(minimalField);
        this.fields.add(minimalField);
    }

    public MinimalField getField(String str) {
        if (str == null) {
            return null;
        }
        List<MinimalField> list = this.fieldMap.get(str.toLowerCase(Locale.US));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<MinimalField> getFields() {
        return new ArrayList(this.fields);
    }

    @Override // java.lang.Iterable
    public Iterator<MinimalField> iterator() {
        return Collections.unmodifiableList(this.fields).iterator();
    }

    public int removeFields(String str) {
        if (str == null) {
            return 0;
        }
        List<MinimalField> remove = this.fieldMap.remove(str.toLowerCase(Locale.US));
        if (remove == null || remove.isEmpty()) {
            return 0;
        }
        this.fields.removeAll(remove);
        return remove.size();
    }

    public void setField(MinimalField minimalField) {
        if (minimalField == null) {
            return;
        }
        List<MinimalField> list = this.fieldMap.get(minimalField.getName().toLowerCase(Locale.US));
        if (list != null && !list.isEmpty()) {
            list.clear();
            list.add(minimalField);
            int i2 = 0;
            Iterator<MinimalField> it = this.fields.iterator();
            int i3 = -1;
            while (it.hasNext()) {
                if (it.next().getName().equalsIgnoreCase(minimalField.getName())) {
                    it.remove();
                    if (i3 == -1) {
                        i3 = i2;
                    }
                }
                i2++;
            }
            this.fields.add(i3, minimalField);
            return;
        }
        addField(minimalField);
    }

    public String toString() {
        return this.fields.toString();
    }

    public List<MinimalField> getFields(String str) {
        if (str == null) {
            return null;
        }
        List<MinimalField> list = this.fieldMap.get(str.toLowerCase(Locale.US));
        if (list != null && !list.isEmpty()) {
            return new ArrayList(list);
        }
        return Collections.emptyList();
    }
}
