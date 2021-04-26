package d.a.c.e.b.b.a.d;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u implements h {

    /* renamed from: a  reason: collision with root package name */
    public String f39586a;

    public u(String str) {
        this.f39586a = str;
    }

    @Override // d.a.c.e.b.b.a.d.h
    public Object a(d.a.c.e.b.b.a.e.c cVar) {
        Class<?> a2;
        try {
            a2 = cVar.a();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return null;
        }
        if (a2 != Byte.class && a2 != Byte.TYPE) {
            if (a2 != Short.class && a2 != Short.TYPE) {
                if (a2 != Integer.class && a2 != Integer.TYPE) {
                    if (a2 != Long.class && a2 != Long.TYPE) {
                        if (a2 != Float.class && a2 != Float.TYPE) {
                            if (a2 != Double.class && a2 != Double.TYPE) {
                                if (a2 != Character.class && a2 != Character.TYPE) {
                                    if (a2 != Boolean.class && a2 != Boolean.TYPE) {
                                        if (a2 == String.class) {
                                            return this.f39586a;
                                        }
                                        if (a2 == char[].class) {
                                            return this.f39586a.toCharArray();
                                        }
                                        if (a2 == byte[].class) {
                                            try {
                                                return d.a.c.e.p.c.e(this.f39586a, 0);
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                                return null;
                                            }
                                        } else if (d.a.c.e.b.a.a.g(a2, OrmObject.class)) {
                                            return OrmObject.objectWithJsonStr(this.f39586a, a2);
                                        } else {
                                            if (d.a.c.e.b.a.a.g(a2, List.class)) {
                                                try {
                                                    return new j(new JSONArray(this.f39586a)).a(cVar);
                                                } catch (JSONException e4) {
                                                    e4.printStackTrace();
                                                    return null;
                                                }
                                            } else if (a2.isArray()) {
                                                try {
                                                    return new j(new JSONArray(this.f39586a)).a(cVar);
                                                } catch (JSONException e5) {
                                                    e5.printStackTrace();
                                                    return null;
                                                }
                                            } else if (d.a.c.e.b.a.a.g(a2, Queue.class)) {
                                                try {
                                                    return new j(new JSONArray(this.f39586a)).a(cVar);
                                                } catch (JSONException e6) {
                                                    e6.printStackTrace();
                                                    return null;
                                                }
                                            } else if (d.a.c.e.b.a.a.g(a2, Set.class)) {
                                                try {
                                                    return new j(new JSONArray(this.f39586a)).a(cVar);
                                                } catch (JSONException e7) {
                                                    e7.printStackTrace();
                                                    return null;
                                                }
                                            } else if (d.a.c.e.b.a.a.g(a2, Map.class)) {
                                                try {
                                                    return new k(new JSONObject(this.f39586a)).a(cVar);
                                                } catch (JSONException e8) {
                                                    e8.printStackTrace();
                                                    return null;
                                                }
                                            } else if (d.a.c.e.b.a.a.g(a2, SparseArray.class)) {
                                                try {
                                                    return new k(new JSONObject(this.f39586a)).a(cVar);
                                                } catch (JSONException e9) {
                                                    e9.printStackTrace();
                                                    return null;
                                                }
                                            } else {
                                                return null;
                                            }
                                        }
                                        e2.printStackTrace();
                                        return null;
                                    }
                                    return Boolean.valueOf(Boolean.parseBoolean(this.f39586a));
                                }
                                return Character.valueOf(this.f39586a.charAt(0));
                            }
                            return Double.valueOf(Double.parseDouble(this.f39586a));
                        }
                        return Float.valueOf(Float.parseFloat(this.f39586a));
                    }
                    return Long.valueOf(Long.parseLong(this.f39586a));
                }
                return Integer.valueOf(Integer.parseInt(this.f39586a));
            }
            return Short.valueOf(Short.parseShort(this.f39586a));
        }
        return Byte.valueOf(Byte.parseByte(this.f39586a));
    }
}
