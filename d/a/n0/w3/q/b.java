package d.a.n0.w3.q;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static int f66625g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f66626e;

    /* renamed from: f  reason: collision with root package name */
    public List<TransmitForumData> f66627f = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f66628a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f66629b;

        /* renamed from: c  reason: collision with root package name */
        public View f66630c;

        /* renamed from: d  reason: collision with root package name */
        public int f66631d = 3;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f66628a = (TextView) view.findViewById(R.id.transmit_forum_name);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f66629b = barImageView;
            barImageView.setShowOval(true);
            this.f66630c = view.findViewById(R.id.divider_line);
        }

        public void a() {
            if (b.f66625g != this.f66631d) {
                SkinManager.setViewTextColor(this.f66628a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f66630c, R.color.CAM_X0204);
            }
            this.f66631d = b.f66625g;
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.f66628a.setText(transmitForumData.forumName);
                this.f66629b.U(transmitForumData.avatar, 10, false);
            }
        }
    }

    public b(Context context) {
        this.f66626e = context;
    }

    public void b(List<TransmitForumData> list) {
        this.f66627f.clear();
        this.f66627f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i2) {
        if (f66625g != i2) {
            notifyDataSetChanged();
        }
        f66625g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f66627f.size();
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
            view = LayoutInflater.from(this.f66626e).inflate(R.layout.layout_select_forum_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(R.id.key_select_forum_holder, aVar);
        } else {
            Object tag = view.getTag(R.id.key_select_forum_holder);
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.a();
            aVar.b(this.f66627f.get(i2));
        }
        return view;
    }
}
