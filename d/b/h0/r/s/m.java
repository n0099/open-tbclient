package d.b.h0.r.s;

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
    public TbPageContext<?> f51036f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51037g = false;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f51035e = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f51038a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51039b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f51040c;

        public b(m mVar) {
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        this.f51036f = tbPageContext;
    }

    public final boolean a(int i) {
        ArrayList<n> arrayList = this.f51035e;
        return arrayList != null && i == arrayList.size() - 1;
    }

    public void b(boolean z) {
        this.f51037g = z;
    }

    public void c(ArrayList<n> arrayList) {
        this.f51035e = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f51035e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f51035e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        n nVar = this.f51035e.get(i);
        if (nVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f51036f.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
            bVar = new b();
            bVar.f51038a = (TextView) view.findViewById(R.id.text_tip);
            bVar.f51039b = (TextView) view.findViewById(R.id.text_desc);
            bVar.f51040c = (ImageView) view.findViewById(R.id.checked_icon);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f51038a.setText(nVar.c());
        if (StringUtils.isNull(nVar.a())) {
            bVar.f51039b.setVisibility(8);
        } else {
            bVar.f51039b.setText(nVar.a());
            bVar.f51039b.setVisibility(0);
        }
        if (nVar.d()) {
            bVar.f51040c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
            bVar.f51040c.setVisibility(0);
        } else if (this.f51037g) {
            WebPManager.setPureDrawable(bVar.f51040c, R.drawable.icon_pure_stroke_n, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
            bVar.f51040c.setVisibility(0);
        } else {
            bVar.f51040c.setVisibility(4);
        }
        if (a(i)) {
            SkinManager.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
        } else {
            SkinManager.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
        }
        view.setTag(bVar);
        this.f51036f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f51036f.getLayoutMode().j(view);
        return view;
    }
}
