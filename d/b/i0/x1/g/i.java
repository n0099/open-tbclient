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
/* loaded from: classes4.dex */
public class i extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static int f62454g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f62455e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f62456f = new ArrayList();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62457a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f62458b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f62459c;

        /* renamed from: d  reason: collision with root package name */
        public int f62460d = 3;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f62461e;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f62457a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f62458b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f62459c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            if (i.f62454g != this.f62460d) {
                SkinManager.setViewTextColor(this.f62457a, R.color.CAM_X0105);
                this.f62461e = SkinManager.getDrawable(R.drawable.transmit_check_box);
            }
            this.f62460d = i.f62454g;
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.f62457a.setText(baInfo.forum_name);
                this.f62458b.setChecked(baInfo.isChecked);
                this.f62459c.W(baInfo.forum_Avatar, 10, false);
                this.f62458b.setButtonDrawable(this.f62461e);
            }
        }
    }

    public i(Context context) {
        this.f62455e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        this.f62456f.clear();
        this.f62456f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i) {
        if (f62454g != i) {
            notifyDataSetChanged();
        }
        f62454g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f62456f.size();
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
            view = LayoutInflater.from(this.f62455e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
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
            aVar.b(this.f62456f.get(i));
        }
        return view;
    }
}
