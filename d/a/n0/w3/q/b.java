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
    public static int f62910g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f62911e;

    /* renamed from: f  reason: collision with root package name */
    public List<TransmitForumData> f62912f = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62913a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f62914b;

        /* renamed from: c  reason: collision with root package name */
        public View f62915c;

        /* renamed from: d  reason: collision with root package name */
        public int f62916d = 3;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f62913a = (TextView) view.findViewById(R.id.transmit_forum_name);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f62914b = barImageView;
            barImageView.setShowOval(true);
            this.f62915c = view.findViewById(R.id.divider_line);
        }

        public void a() {
            if (b.f62910g != this.f62916d) {
                SkinManager.setViewTextColor(this.f62913a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f62915c, R.color.CAM_X0204);
            }
            this.f62916d = b.f62910g;
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.f62913a.setText(transmitForumData.forumName);
                this.f62914b.V(transmitForumData.avatar, 10, false);
            }
        }
    }

    public b(Context context) {
        this.f62911e = context;
    }

    public void b(List<TransmitForumData> list) {
        this.f62912f.clear();
        this.f62912f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i2) {
        if (f62910g != i2) {
            notifyDataSetChanged();
        }
        f62910g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f62912f.size();
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
            view = LayoutInflater.from(this.f62911e).inflate(R.layout.layout_select_forum_item, (ViewGroup) null);
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
            aVar.b(this.f62912f.get(i2));
        }
        return view;
    }
}
