package d.a.j0.r;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements LayoutInflater.Factory {

    /* renamed from: e  reason: collision with root package name */
    public c f49590e;

    public void a(c cVar) {
        this.f49590e = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f49590e == null) {
            this.f49590e = new c();
        }
        this.f49590e.i(str, context, attributeSet);
        return null;
    }
}
