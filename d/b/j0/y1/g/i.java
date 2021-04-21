package d.b.j0.y1.g;

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
    public static int f64561g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f64562e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f64563f = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f64564a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f64565b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f64566c;

        /* renamed from: d  reason: collision with root package name */
        public int f64567d = 3;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f64568e;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f64564a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f64565b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f64566c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            if (i.f64561g != this.f64567d) {
                SkinManager.setViewTextColor(this.f64564a, R.color.CAM_X0105);
                this.f64568e = SkinManager.getDrawable(R.drawable.transmit_check_box);
            }
            this.f64567d = i.f64561g;
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.f64564a.setText(baInfo.forum_name);
                this.f64565b.setChecked(baInfo.isChecked);
                this.f64566c.W(baInfo.forum_Avatar, 10, false);
                this.f64565b.setButtonDrawable(this.f64568e);
            }
        }
    }

    public i(Context context) {
        this.f64562e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        this.f64563f.clear();
        this.f64563f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i) {
        if (f64561g != i) {
            notifyDataSetChanged();
        }
        f64561g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f64563f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar = null;
        if (view == null) {
            view = LayoutInflater.from(this.f64562e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
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
            aVar.b(this.f64563f.get(i));
        }
        return view;
    }
}
