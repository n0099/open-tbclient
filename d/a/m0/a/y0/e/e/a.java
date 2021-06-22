package d.a.m0.a.y0.e.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import d.a.m0.a.e;
import d.a.m0.a.f;
import d.a.m0.a.g;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f49586e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f49587f;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f49588a;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f49589a;

        public c() {
        }
    }

    public a(Context context, @NonNull String[] strArr) {
        this.f49586e = context;
        this.f49587f = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f49587f.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f49587f[i2];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: d.a.m0.a.y0.e.e.a$b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        View inflate;
        c cVar2;
        if (view == null) {
            if (i2 == 11) {
                inflate = View.inflate(this.f49586e, g.aiapps_keyboard_img_item, null);
                b bVar = new b();
                bVar.f49588a = (ImageView) inflate.findViewById(f.delete_key_img_view);
                cVar2 = bVar;
            } else {
                inflate = View.inflate(this.f49586e, g.aiapps_keyboard_text_item, null);
                c cVar3 = new c();
                cVar3.f49589a = (TextView) inflate.findViewById(f.key_text_view);
                cVar2 = cVar3;
                if (i2 == 9) {
                    if (TextUtils.isEmpty(this.f49587f[9])) {
                        inflate.setBackgroundColor(this.f49586e.getResources().getColor(d.a.m0.a.c.aiapps_keyboard_non_number_item_background_normal));
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
            ((c) cVar).f49589a.setText(this.f49587f[i2]);
        }
        return view;
    }
}
