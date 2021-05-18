package d.a.j0.r.s;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f50245f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50246g = false;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f50244e = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f50247a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50248b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f50249c;

        public b(m mVar) {
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        this.f50245f = tbPageContext;
    }

    public final boolean a(int i2) {
        ArrayList<n> arrayList = this.f50244e;
        return arrayList != null && i2 == arrayList.size() - 1;
    }

    public void b(boolean z) {
        this.f50246g = z;
    }

    public void c(ArrayList<n> arrayList) {
        this.f50244e = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f50244e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f50244e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        n nVar = this.f50244e.get(i2);
        if (nVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f50245f.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
            bVar = new b();
            bVar.f50247a = (TextView) view.findViewById(R.id.text_tip);
            bVar.f50248b = (TextView) view.findViewById(R.id.text_desc);
            bVar.f50249c = (ImageView) view.findViewById(R.id.checked_icon);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f50247a.setText(nVar.c());
        if (StringUtils.isNull(nVar.a())) {
            bVar.f50248b.setVisibility(8);
        } else {
            bVar.f50248b.setText(nVar.a());
            bVar.f50248b.setVisibility(0);
        }
        if (nVar.d()) {
            bVar.f50249c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
            bVar.f50249c.setVisibility(0);
        } else if (this.f50246g) {
            WebPManager.setPureDrawable(bVar.f50249c, R.drawable.icon_pure_stroke_n, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
            bVar.f50249c.setVisibility(0);
        } else {
            bVar.f50249c.setVisibility(4);
        }
        if (a(i2)) {
            SkinManager.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
        } else {
            SkinManager.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
        }
        view.setTag(bVar);
        this.f50245f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f50245f.getLayoutMode().j(view);
        return view;
    }
}
