package org.json.simple.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList f2886a;
    private c b = new c(null);
    private d c = null;
    private int d = 0;

    private int a(LinkedList linkedList) {
        if (linkedList.size() == 0) {
            return -1;
        }
        return ((Integer) linkedList.getFirst()).intValue();
    }

    public void a() {
        this.c = null;
        this.d = 0;
        this.f2886a = null;
    }

    public void a(Reader reader) {
        this.b.a(reader);
        a();
    }

    public int b() {
        return this.b.a();
    }

    public Object b(Reader reader) {
        return a(reader, null);
    }

    public Object a(Reader reader, a aVar) {
        a(reader);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        do {
            try {
                c();
                switch (this.d) {
                    case -1:
                        throw new ParseException(b(), 1, this.c);
                    case 0:
                        switch (this.c.f2888a) {
                            case 0:
                                this.d = 1;
                                linkedList.addFirst(new Integer(this.d));
                                linkedList2.addFirst(this.c.b);
                                break;
                            case 1:
                                this.d = 2;
                                linkedList.addFirst(new Integer(this.d));
                                linkedList2.addFirst(a(aVar));
                                break;
                            case 2:
                            default:
                                this.d = -1;
                                break;
                            case 3:
                                this.d = 3;
                                linkedList.addFirst(new Integer(this.d));
                                linkedList2.addFirst(b(aVar));
                                break;
                        }
                    case 1:
                        if (this.c.f2888a == -1) {
                            return linkedList2.removeFirst();
                        }
                        throw new ParseException(b(), 1, this.c);
                    case 2:
                        switch (this.c.f2888a) {
                            case 0:
                                if (this.c.b instanceof String) {
                                    linkedList2.addFirst((String) this.c.b);
                                    this.d = 4;
                                    linkedList.addFirst(new Integer(this.d));
                                    break;
                                } else {
                                    this.d = -1;
                                    break;
                                }
                            case 1:
                            case 3:
                            case 4:
                            default:
                                this.d = -1;
                                break;
                            case 2:
                                if (linkedList2.size() > 1) {
                                    linkedList.removeFirst();
                                    linkedList2.removeFirst();
                                    this.d = a(linkedList);
                                    break;
                                } else {
                                    this.d = 1;
                                    break;
                                }
                            case 5:
                                break;
                        }
                    case 3:
                        switch (this.c.f2888a) {
                            case 0:
                                ((List) linkedList2.getFirst()).add(this.c.b);
                                break;
                            case 1:
                                Map a2 = a(aVar);
                                ((List) linkedList2.getFirst()).add(a2);
                                this.d = 2;
                                linkedList.addFirst(new Integer(this.d));
                                linkedList2.addFirst(a2);
                                break;
                            case 2:
                            default:
                                this.d = -1;
                                break;
                            case 3:
                                List b = b(aVar);
                                ((List) linkedList2.getFirst()).add(b);
                                this.d = 3;
                                linkedList.addFirst(new Integer(this.d));
                                linkedList2.addFirst(b);
                                break;
                            case 4:
                                if (linkedList2.size() > 1) {
                                    linkedList.removeFirst();
                                    linkedList2.removeFirst();
                                    this.d = a(linkedList);
                                    break;
                                } else {
                                    this.d = 1;
                                    break;
                                }
                            case 5:
                                break;
                        }
                    case 4:
                        switch (this.c.f2888a) {
                            case 0:
                                linkedList.removeFirst();
                                ((Map) linkedList2.getFirst()).put((String) linkedList2.removeFirst(), this.c.b);
                                this.d = a(linkedList);
                                break;
                            case 1:
                                linkedList.removeFirst();
                                Map map = (Map) linkedList2.getFirst();
                                Map a3 = a(aVar);
                                map.put((String) linkedList2.removeFirst(), a3);
                                this.d = 2;
                                linkedList.addFirst(new Integer(this.d));
                                linkedList2.addFirst(a3);
                                break;
                            case 2:
                            case 4:
                            case 5:
                            default:
                                this.d = -1;
                                break;
                            case 3:
                                linkedList.removeFirst();
                                Map map2 = (Map) linkedList2.getFirst();
                                List b2 = b(aVar);
                                map2.put((String) linkedList2.removeFirst(), b2);
                                this.d = 3;
                                linkedList.addFirst(new Integer(this.d));
                                linkedList2.addFirst(b2);
                                break;
                            case 6:
                                break;
                        }
                }
                if (this.d == -1) {
                    throw new ParseException(b(), 1, this.c);
                }
            } catch (IOException e) {
                throw e;
            }
        } while (this.c.f2888a != -1);
        throw new ParseException(b(), 1, this.c);
    }

    private void c() {
        this.c = this.b.c();
        if (this.c == null) {
            this.c = new d(-1, null);
        }
    }

    private Map a(a aVar) {
        if (aVar == null) {
            return new JSONObject();
        }
        Map a2 = aVar.a();
        if (a2 == null) {
            return new JSONObject();
        }
        return a2;
    }

    private List b(a aVar) {
        if (aVar == null) {
            return new JSONArray();
        }
        List b = aVar.b();
        if (b == null) {
            return new JSONArray();
        }
        return b;
    }
}
