package d.a.j0.y1.g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static int f62841g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f62842e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f62843f = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62844a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f62845b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f62846c;

        /* renamed from: d  reason: collision with root package name */
        public int f62847d = 3;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f62848e;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f62844a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f62845b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f62846c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            if (i.f62841g != this.f62847d) {
                SkinManager.setViewTextColor(this.f62844a, R.color.CAM_X0105);
                this.f62848e = SkinManager.getDrawable(R.drawable.transmit_check_box);
            }
            this.f62847d = i.f62841g;
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.f62844a.setText(baInfo.forum_name);
                this.f62845b.setChecked(baInfo.isChecked);
                this.f62846c.V(baInfo.forum_Avatar, 10, false);
                this.f62845b.setButtonDrawable(this.f62848e);
            }
        }
    }

    public i(Context context) {
        this.f62842e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        this.f62843f.clear();
        this.f62843f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i2) {
        if (f62841g != i2) {
            notifyDataSetChanged();
        }
        f62841g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f62843f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar = null;
        if (view == null) {
            view = LayoutInflater.from(this.f62842e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            Object tag = view.getTag();
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.a();
            aVar.b(this.f62843f.get(i2));
        }
        return view;
    }
}
