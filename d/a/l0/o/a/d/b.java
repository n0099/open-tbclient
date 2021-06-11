package d.a.l0.o.a.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements LayoutInflater.Factory {

        /* renamed from: e  reason: collision with root package name */
        public final e f51987e;

        public a(e eVar) {
            this.f51987e = eVar;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f51987e.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + StringUtil.ARRAY_START + this.f51987e + "}";
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        layoutInflater.setFactory(eVar != null ? new a(eVar) : null);
    }
}
