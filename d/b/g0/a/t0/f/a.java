package d.b.g0.a.t0.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import d.b.g0.a.e;
import d.b.g0.a.f;
import d.b.g0.a.g;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f46228e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f46229f;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f46230a;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f46231a;

        public c() {
        }
    }

    public a(Context context, @NonNull String[] strArr) {
        this.f46228e = context;
        this.f46229f = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f46229f.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f46229f[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: d.b.g0.a.t0.f.a$b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        View inflate;
        c cVar2;
        if (view == null) {
            if (i == 11) {
                inflate = View.inflate(this.f46228e, g.aiapps_keyboard_img_item, null);
                b bVar = new b();
                bVar.f46230a = (ImageView) inflate.findViewById(f.delete_key_img_view);
                cVar2 = bVar;
            } else {
                inflate = View.inflate(this.f46228e, g.aiapps_keyboard_text_item, null);
                c cVar3 = new c();
                cVar3.f46231a = (TextView) inflate.findViewById(f.key_text_view);
                cVar2 = cVar3;
                if (i == 9) {
                    if (TextUtils.isEmpty(this.f46229f[9])) {
                        inflate.setBackgroundColor(this.f46228e.getResources().getColor(d.b.g0.a.c.aiapps_keyboard_non_number_item_background_normal));
                        cVar2 = cVar3;
                    } else {
                        inflate.setBackgroundResource(e.aiapps_keyboard_non_number_item_selector);
                        cVar2 = cVar3;
                    }
                }
            }
            view = inflate;
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = view.getTag();
        }
        if (i != 11 && (cVar instanceof c)) {
            ((c) cVar).f46231a.setText(this.f46229f[i]);
        }
        return view;
    }
}
