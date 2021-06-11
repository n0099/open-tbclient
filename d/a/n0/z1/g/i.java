package d.a.n0.z1.g;

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
    public static int f67447g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f67448e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f67449f = new ArrayList();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f67450a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f67451b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f67452c;

        /* renamed from: d  reason: collision with root package name */
        public int f67453d = 3;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f67454e;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f67450a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f67451b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f67452c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            if (i.f67447g != this.f67453d) {
                SkinManager.setViewTextColor(this.f67450a, R.color.CAM_X0105);
                this.f67454e = SkinManager.getDrawable(R.drawable.transmit_check_box);
            }
            this.f67453d = i.f67447g;
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.f67450a.setText(baInfo.forum_name);
                this.f67451b.setChecked(baInfo.isChecked);
                this.f67452c.U(baInfo.forum_Avatar, 10, false);
                this.f67451b.setButtonDrawable(this.f67454e);
            }
        }
    }

    public i(Context context) {
        this.f67448e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        this.f67449f.clear();
        this.f67449f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i2) {
        if (f67447g != i2) {
            notifyDataSetChanged();
        }
        f67447g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f67449f.size();
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
            view = LayoutInflater.from(this.f67448e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
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
            aVar.b(this.f67449f.get(i2));
        }
        return view;
    }
}
