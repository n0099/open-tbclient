package d.a.n0.r;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements LayoutInflater.Factory {

    /* renamed from: e  reason: collision with root package name */
    public c f53416e;

    public void a(c cVar) {
        this.f53416e = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f53416e == null) {
            this.f53416e = new c();
        }
        this.f53416e.i(str, context, attributeSet);
        return null;
    }
}
