package com.yy.hiidostatis.defs.obj;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.yy.hiidostatis.defs.obj.Elem;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class Info<T extends Elem> implements Serializable {
    public static final String DIVIDE_ELEM = "|";
    public static final long serialVersionUID = 1;
    public List<T> elems = new CopyOnWriteArrayList();

    public void clear() {
        this.elems.clear();
    }

    public int getElemsCount() {
        return this.elems.size();
    }

    public Iterator<T> iterator() {
        return this.elems.iterator();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.elems = (List) objectInputStream.readObject();
        } catch (Throwable th) {
            L.debug(this, "Failed to read object from stream for %s", th);
            this.elems = new CopyOnWriteArrayList();
        }
        if (this.elems == null) {
            L.brief("read elements is null, create an empty array list.", new Object[0]);
            this.elems = new ArrayList();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.elems);
    }

    public void add(Info<T> info) {
        Iterator<T> it = info.iterator();
        while (it.hasNext()) {
            addElem(it.next());
        }
    }

    public void addElem(T t) {
        if (t == null) {
            return;
        }
        this.elems.add(t);
    }

    public T getElem(int i) {
        return this.elems.get(i);
    }

    public void removeElem(T t) {
        if (t == null) {
            return;
        }
        this.elems.remove(t);
    }

    public String getResult() {
        if (Util.empty(this.elems)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (T t : this.elems) {
            sb.append(Util.replaceEncode(t.getStringRep(), "|"));
            sb.append("|");
        }
        String sb2 = sb.toString();
        if (sb2.length() <= 1) {
            return sb2;
        }
        return sb2.substring(0, sb2.length() - 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        for (T t : this.elems) {
            sb.append(t.toString());
            sb.append(" ");
        }
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        return sb.toString();
    }
}
