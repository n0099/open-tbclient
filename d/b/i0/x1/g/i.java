package d.b.i0.x1.g;

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
    public static int f62455g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f62456e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f62457f = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62458a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f62459b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f62460c;

        /* renamed from: d  reason: collision with root package name */
        public int f62461d = 3;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f62462e;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f62458a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f62459b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f62460c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            if (i.f62455g != this.f62461d) {
                SkinManager.setViewTextColor(this.f62458a, R.color.CAM_X0105);
                this.f62462e = SkinManager.getDrawable(R.drawable.transmit_check_box);
            }
            this.f62461d = i.f62455g;
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.f62458a.setText(baInfo.forum_name);
                this.f62459b.setChecked(baInfo.isChecked);
                this.f62460c.W(baInfo.forum_Avatar, 10, false);
                this.f62459b.setButtonDrawable(this.f62462e);
            }
        }
    }

    public i(Context context) {
        this.f62456e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        this.f62457f.clear();
        this.f62457f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i) {
        if (f62455g != i) {
            notifyDataSetChanged();
        }
        f62455g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f62457f.size();
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
            view = LayoutInflater.from(this.f62456e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
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
            aVar.b(this.f62457f.get(i));
        }
        return view;
    }
}
