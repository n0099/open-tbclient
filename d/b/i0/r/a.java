package d.b.i0.r;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements LayoutInflater.Factory {

    /* renamed from: e  reason: collision with root package name */
    public c f51156e;

    public void a(c cVar) {
        this.f51156e = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f51156e == null) {
            this.f51156e = new c();
        }
        this.f51156e.i(str, context, attributeSet);
        return null;
    }
}
