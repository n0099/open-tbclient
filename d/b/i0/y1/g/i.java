package d.b.i0.y1.g;

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
    public static int f64140g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f64141e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f64142f = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f64143a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f64144b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f64145c;

        /* renamed from: d  reason: collision with root package name */
        public int f64146d = 3;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f64147e;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f64143a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f64144b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f64145c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            if (i.f64140g != this.f64146d) {
                SkinManager.setViewTextColor(this.f64143a, R.color.CAM_X0105);
                this.f64147e = SkinManager.getDrawable(R.drawable.transmit_check_box);
            }
            this.f64146d = i.f64140g;
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.f64143a.setText(baInfo.forum_name);
                this.f64144b.setChecked(baInfo.isChecked);
                this.f64145c.W(baInfo.forum_Avatar, 10, false);
                this.f64144b.setButtonDrawable(this.f64147e);
            }
        }
    }

    public i(Context context) {
        this.f64141e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        this.f64142f.clear();
        this.f64142f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i) {
        if (f64140g != i) {
            notifyDataSetChanged();
        }
        f64140g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f64142f.size();
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
            view = LayoutInflater.from(this.f64141e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
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
            aVar.b(this.f64142f.get(i));
        }
        return view;
    }
}
