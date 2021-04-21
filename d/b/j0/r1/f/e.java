package d.b.j0.r1.f;

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
    public List<d> f61515e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f61516f;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f61517a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61518b;

        public a(e eVar, View view) {
            this.f61517a = (ImageView) view.findViewById(R.id.member_privilege_pic);
            this.f61518b = (TextView) view.findViewById(R.id.member_privilege_name);
        }
    }

    public e(Context context) {
        this.f61516f = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i) {
        List<d> list = this.f61515e;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    public final void b(d dVar, a aVar) {
        if (dVar == null) {
            return;
        }
        aVar.f61518b.setText(dVar.f61514b);
        SkinManager.setViewTextColor(aVar.f61518b, R.color.CAM_X0106);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(aVar.f61517a, dVar.f61513a, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void c(List<d> list) {
        this.f61515e = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d> list = this.f61515e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f61515e == null) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f61516f.inflate(R.layout.member_pay_privilege_list_item, (ViewGroup) null);
            view.setTag(new a(this, view));
        }
        b(getItem(i), (a) view.getTag());
        return view;
    }
}
