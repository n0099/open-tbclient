package d.b.g0.m.a.d;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.LayoutInflaterCompat;
import d.b.g0.m.a.d.b;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Field f49566a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f49567b;

    /* loaded from: classes3.dex */
    public static class a extends b.a implements LayoutInflater.Factory2 {
        public a(e eVar) {
            super(eVar);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f49565e.onCreateView(view, str, context, attributeSet);
        }
    }

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f49567b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f49566a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(LayoutInflaterCompat.TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e2);
            }
            f49567b = true;
        }
        Field field = f49566a;
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
