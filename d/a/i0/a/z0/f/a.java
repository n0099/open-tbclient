package d.a.i0.a.z0.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import d.a.i0.a.e;
import d.a.i0.a.f;
import d.a.i0.a.g;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f45814e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f45815f;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f45816a;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f45817a;

        public c() {
        }
    }

    public a(Context context, @NonNull String[] strArr) {
        this.f45814e = context;
        this.f45815f = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f45815f.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f45815f[i2];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: d.a.i0.a.z0.f.a$b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        View inflate;
        c cVar2;
        if (view == null) {
            if (i2 == 11) {
                inflate = View.inflate(this.f45814e, g.aiapps_keyboard_img_item, null);
                b bVar = new b();
                bVar.f45816a = (ImageView) inflate.findViewById(f.delete_key_img_view);
                cVar2 = bVar;
            } else {
                inflate = View.inflate(this.f45814e, g.aiapps_keyboard_text_item, null);
                c cVar3 = new c();
                cVar3.f45817a = (TextView) inflate.findViewById(f.key_text_view);
                cVar2 = cVar3;
                if (i2 == 9) {
                    if (TextUtils.isEmpty(this.f45815f[9])) {
                        inflate.setBackgroundColor(this.f45814e.getResources().getColor(d.a.i0.a.c.aiapps_keyboard_non_number_item_background_normal));
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
        if (i2 != 11 && (cVar instanceof c)) {
            ((c) cVar).f45817a.setText(this.f45815f[i2]);
        }
        return view;
    }
}
