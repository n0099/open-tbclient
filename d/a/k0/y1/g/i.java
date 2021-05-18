package d.a.k0.y1.g;

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
/* loaded from: classes4.dex */
public class i extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static int f63565g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f63566e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f63567f = new ArrayList();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63568a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f63569b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f63570c;

        /* renamed from: d  reason: collision with root package name */
        public int f63571d = 3;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f63572e;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f63568a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f63569b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f63570c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            if (i.f63565g != this.f63571d) {
                SkinManager.setViewTextColor(this.f63568a, R.color.CAM_X0105);
                this.f63572e = SkinManager.getDrawable(R.drawable.transmit_check_box);
            }
            this.f63571d = i.f63565g;
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.f63568a.setText(baInfo.forum_name);
                this.f63569b.setChecked(baInfo.isChecked);
                this.f63570c.V(baInfo.forum_Avatar, 10, false);
                this.f63569b.setButtonDrawable(this.f63572e);
            }
        }
    }

    public i(Context context) {
        this.f63566e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        this.f63567f.clear();
        this.f63567f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i2) {
        if (f63565g != i2) {
            notifyDataSetChanged();
        }
        f63565g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f63567f.size();
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
            view = LayoutInflater.from(this.f63566e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
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
            aVar.b(this.f63567f.get(i2));
        }
        return view;
    }
}
