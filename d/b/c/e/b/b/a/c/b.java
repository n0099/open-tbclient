package d.b.c.e.b.b.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public Cursor f42126a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentValues f42127b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f42128c;

    public b(Cursor cursor) {
        this.f42126a = cursor;
        this.f42127b = null;
        this.f42128c = new TreeSet();
        if (cursor != null) {
            int columnCount = cursor.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnName = cursor.getColumnName(i);
                if (columnName != null) {
                    this.f42128c.add(columnName);
                }
            }
        }
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Set<String> a() {
        return this.f42128c;
    }

    @Override // d.b.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        if (str != null) {
            if (obj == null) {
                this.f42127b.putNull(str);
            } else if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
                if (obj.getClass() != Byte.TYPE && obj.getClass() != Byte.class) {
                    if (obj.getClass() == byte[].class) {
                        this.f42127b.put(str, (byte[]) obj);
                        return;
                    } else if (obj.getClass() != Double.TYPE && obj.getClass() != Double.class) {
                        if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                            if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
                                if (obj.getClass() != Long.TYPE && obj.getClass() != Long.class) {
                                    if (obj.getClass() != Short.TYPE && obj.getClass() != Short.class) {
                                        if (obj.getClass() == String.class) {
                                            this.f42127b.put(str, (String) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    this.f42127b.put(str, (Short) obj);
                                    return;
                                }
                                this.f42127b.put(str, (Long) obj);
                                return;
                            }
                            this.f42127b.put(str, (Integer) obj);
                            return;
                        }
                        this.f42127b.put(str, (Float) obj);
                        return;
                    } else {
                        this.f42127b.put(str, (Double) obj);
                        return;
                    }
                }
                this.f42127b.put(str, (Byte) obj);
            } else {
                this.f42127b.put(str, (Boolean) obj);
            }
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
        int columnIndex = this.f42126a.getColumnIndex(str);
        Object obj = null;
        if (columnIndex <= 0 || columnIndex >= this.f42126a.getColumnCount()) {
            return null;
        }
        try {
            obj = Short.valueOf(this.f42126a.getShort(columnIndex));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (obj == null) {
            try {
                obj = Integer.valueOf(this.f42126a.getInt(columnIndex));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                obj = Long.valueOf(this.f42126a.getLong(columnIndex));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                obj = Float.valueOf(this.f42126a.getFloat(columnIndex));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                obj = Double.valueOf(this.f42126a.getDouble(columnIndex));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                obj = this.f42126a.getString(columnIndex);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                return this.f42126a.getBlob(columnIndex);
            } catch (Exception e8) {
                e8.printStackTrace();
                return obj;
            }
        }
        return obj;
    }

    public b(ContentValues contentValues) {
        this.f42127b = contentValues;
        this.f42128c = new TreeSet();
    }
}
