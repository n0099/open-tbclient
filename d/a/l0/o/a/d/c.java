package d.a.l0.o.a.d;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.LayoutInflaterCompat;
import d.a.l0.o.a.d.b;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Field f51988a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f51989b;

    /* loaded from: classes3.dex */
    public static class a extends b.a implements LayoutInflater.Factory2 {
        public a(e eVar) {
            super(eVar);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f51987e.onCreateView(view, str, context, attributeSet);
        }
    }

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f51989b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f51988a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(LayoutInflaterCompat.TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e2);
            }
            f51989b = true;
        }
        Field field = f51988a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.e(LayoutInflaterCompat.TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e3);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, e eVar) {
        a aVar = eVar != null ? new a(eVar) : null;
        layoutInflater.setFactory2(aVar);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            a(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            a(layoutInflater, aVar);
        }
    }
}
