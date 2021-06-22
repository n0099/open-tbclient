package d.a.o0.z1.g;

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
/* loaded from: classes5.dex */
public class i extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static int f67572g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f67573e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f67574f = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f67575a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f67576b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f67577c;

        /* renamed from: d  reason: collision with root package name */
        public int f67578d = 3;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f67579e;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f67575a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f67576b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f67577c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            if (i.f67572g != this.f67578d) {
                SkinManager.setViewTextColor(this.f67575a, R.color.CAM_X0105);
                this.f67579e = SkinManager.getDrawable(R.drawable.transmit_check_box);
            }
            this.f67578d = i.f67572g;
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.f67575a.setText(baInfo.forum_name);
                this.f67576b.setChecked(baInfo.isChecked);
                this.f67577c.U(baInfo.forum_Avatar, 10, false);
                this.f67576b.setButtonDrawable(this.f67579e);
            }
        }
    }

    public i(Context context) {
        this.f67573e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        this.f67574f.clear();
        this.f67574f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i2) {
        if (f67572g != i2) {
            notifyDataSetChanged();
        }
        f67572g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f67574f.size();
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
            view = LayoutInflater.from(this.f67573e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
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
            aVar.b(this.f67574f.get(i2));
        }
        return view;
    }
}
