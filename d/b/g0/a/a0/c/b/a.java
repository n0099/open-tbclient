package d.b.g0.a.a0.c.b;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class a extends d.b.g0.a.a0.a.c.a<TextView, c> {
    public a(@Nullable Context context, @NonNull c cVar) {
        super(context, cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: c0 */
    public TextView v(@NonNull Context context) {
        return new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.c.a
    /* renamed from: d0 */
    public void Z(@NonNull TextView textView, @NonNull c cVar) {
        if (d.b.g0.a.a0.b.a.f43100h) {
            Log.d("Component-Button", "renderTextStyleLineSpace");
        }
        int i = cVar.B;
        if (i > 0) {
            textView.setLineSpacing((i - textView.getLineHeight()) + textView.getLineSpacingExtra(), 1.0f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.c.a
    /* renamed from: e0 */
    public void a0(@NonNull TextView textView, @NonNull c cVar) {
        b0(textView, cVar, 16);
    }
}
