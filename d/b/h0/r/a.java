package d.b.h0.r;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements LayoutInflater.Factory {

    /* renamed from: e  reason: collision with root package name */
    public c f50820e;

    public void a(c cVar) {
        this.f50820e = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f50820e == null) {
            this.f50820e = new c();
        }
        this.f50820e.i(str, context, attributeSet);
        return null;
    }
}
