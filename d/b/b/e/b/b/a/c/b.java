package d.b.b.e.b.b.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public Cursor f41629a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentValues f41630b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f41631c;

    public b(Cursor cursor) {
        this.f41629a = cursor;
        this.f41630b = null;
        this.f41631c = new TreeSet();
        if (cursor != null) {
            int columnCount = cursor.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnName = cursor.getColumnName(i);
                if (columnName != null) {
                    this.f41631c.add(columnName);
                }
            }
        }
    }

    @Override // d.b.b.e.b.b.a.c.c
    public Set<String> a() {
        return this.f41631c;
    }

    @Override // d.b.b.e.b.b.a.c.c
    public void b(String str, Object obj) {
        if (str != null) {
            if (obj == null) {
                this.f41630b.putNull(str);
            } else if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
                if (obj.getClass() != Byte.TYPE && obj.getClass() != Byte.class) {
                    if (obj.getClass() == byte[].class) {
                        this.f41630b.put(str, (byte[]) obj);
                        return;
                    } else if (obj.getClass() != Double.TYPE && obj.getClass() != Double.class) {
                        if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                            if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
                                if (obj.getClass() != Long.TYPE && obj.getClass() != Long.class) {
                                    if (obj.getClass() != Short.TYPE && obj.getClass() != Short.class) {
                                        if (obj.getClass() == String.class) {
                                            this.f41630b.put(str, (String) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    this.f41630b.put(str, (Short) obj);
                                    return;
                                }
                                this.f41630b.put(str, (Long) obj);
                                return;
                            }
                            this.f41630b.put(str, (Integer) obj);
                            return;
                        }
                        this.f41630b.put(str, (Float) obj);
                        return;
                    } else {
                        this.f41630b.put(str, (Double) obj);
                        return;
                    }
                }
                this.f41630b.put(str, (Byte) obj);
            } else {
                this.f41630b.put(str, (Boolean) obj);
            }
        }
    }

    @Override // d.b.b.e.b.b.a.c.c
    public Object c(String str, Type type) {
        Object d2 = d(str);
        if (d2 != null) {
            d.b.b.e.b.b.a.e.c cVar = new d.b.b.e.b.b.a.e.c(type);
            d.b.b.e.b.b.a.d.h a2 = d.b.b.e.b.b.a.e.g.a(d2);
            return a2 != null ? a2.a(cVar) : d2;
        }
        return d2;
    }

    public Object d(String str) {
        int columnIndex = this.f41629a.getColumnIndex(str);
        Object obj = null;
        if (columnIndex <= 0 || columnIndex >= this.f41629a.getColumnCount()) {
            return null;
        }
        try {
            obj = Short.valueOf(this.f41629a.getShort(columnIndex));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (obj == null) {
            try {
                obj = Integer.valueOf(this.f41629a.getInt(columnIndex));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                obj = Long.valueOf(this.f41629a.getLong(columnIndex));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                obj = Float.valueOf(this.f41629a.getFloat(columnIndex));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                obj = Double.valueOf(this.f41629a.getDouble(columnIndex));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                obj = this.f41629a.getString(columnIndex);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        if (obj == null) {
            try {
                return this.f41629a.getBlob(columnIndex);
            } catch (Exception e8) {
                e8.printStackTrace();
                return obj;
            }
        }
        return obj;
    }

    public b(ContentValues contentValues) {
        this.f41630b = contentValues;
        this.f41631c = new TreeSet();
    }
}
