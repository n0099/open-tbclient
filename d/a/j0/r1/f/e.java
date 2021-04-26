package d.a.j0.r1.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d> f59665e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f59666f;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f59667a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59668b;

        public a(e eVar, View view) {
            this.f59667a = (ImageView) view.findViewById(R.id.member_privilege_pic);
            this.f59668b = (TextView) view.findViewById(R.id.member_privilege_name);
        }
    }

    public e(Context context) {
        this.f59666f = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i2) {
        List<d> list = this.f59665e;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    public final void b(d dVar, a aVar) {
        if (dVar == null) {
            return;
        }
        aVar.f59668b.setText(dVar.f59664b);
        SkinManager.setViewTextColor(aVar.f59668b, R.color.CAM_X0106);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(aVar.f59667a, dVar.f59663a, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void c(List<d> list) {
        this.f59665e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f59665e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (this.f59665e == null) {
            return 0L;
        }
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f59666f.inflate(R.layout.member_pay_privilege_list_item, (ViewGroup) null);
            view.setTag(new a(this, view));
        }
        b(getItem(i2), (a) view.getTag());
        return view;
    }
}
