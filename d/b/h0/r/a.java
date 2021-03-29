package d.b.h0.r;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements LayoutInflater.Factory {

    /* renamed from: e  reason: collision with root package name */
    public c f50413e;

    public void a(c cVar) {
        this.f50413e = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f50413e == null) {
            this.f50413e = new c();
        }
        this.f50413e.i(str, context, attributeSet);
        return null;
    }
}
