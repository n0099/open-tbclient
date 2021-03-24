package d.b.b.a;

import android.content.Context;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class j {
    public static f<?> a(Context context) {
        Object a2;
        if (context == null) {
            return null;
        }
        if (context instanceof f) {
            return (f) context;
        }
        if (context instanceof g) {
            return ((g) context).getPageContext();
        }
        Field b2 = d.b.b.e.p.b.b(context.getClass(), i.class);
        if (b2 == null || (a2 = d.b.b.e.p.b.a(context, b2)) == null || !(a2 instanceof i) || !(a2 instanceof g)) {
            return null;
        }
        return ((g) a2).getPageContext();
    }

    public static g<?> b(Context context) {
        Object a2;
        if (context == null) {
            return null;
        }
        if (context instanceof g) {
            return (g) context;
        }
        Field b2 = d.b.b.e.p.b.b(context.getClass(), i.class);
        if (b2 == null || (a2 = d.b.b.e.p.b.a(context, b2)) == null || !(a2 instanceof i) || !(a2 instanceof g)) {
            return null;
        }
        return (g) a2;
    }

    public static i c(Context context) {
        Object a2;
        if (context == null) {
            return null;
        }
        if (context instanceof i) {
            return (i) context;
        }
        if (context instanceof g) {
            Object orignalPage = ((g) context).getPageContext().getOrignalPage();
            if (orignalPage instanceof i) {
                return (i) orignalPage;
            }
        }
        Field b2 = d.b.b.e.p.b.b(context.getClass(), i.class);
        if (b2 == null || (a2 = d.b.b.e.p.b.a(context, b2)) == null || !(a2 instanceof i)) {
            return null;
        }
        return (i) a2;
    }
}
