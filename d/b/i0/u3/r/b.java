package d.b.i0.u3.r;

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
    public static int f61682g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f61683e;

    /* renamed from: f  reason: collision with root package name */
    public List<TransmitForumData> f61684f = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61685a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f61686b;

        /* renamed from: c  reason: collision with root package name */
        public View f61687c;

        /* renamed from: d  reason: collision with root package name */
        public int f61688d = 3;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f61685a = (TextView) view.findViewById(R.id.transmit_forum_name);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f61686b = barImageView;
            barImageView.setShowOval(true);
            this.f61687c = view.findViewById(R.id.divider_line);
        }

        public void a() {
            if (b.f61682g != this.f61688d) {
                SkinManager.setViewTextColor(this.f61685a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f61687c, R.color.CAM_X0204);
            }
            this.f61688d = b.f61682g;
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.f61685a.setText(transmitForumData.forumName);
                this.f61686b.W(transmitForumData.avatar, 10, false);
            }
        }
    }

    public b(Context context) {
        this.f61683e = context;
    }

    public void b(List<TransmitForumData> list) {
        this.f61684f.clear();
        this.f61684f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i) {
        if (f61682g != i) {
            notifyDataSetChanged();
        }
        f61682g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f61684f.size();
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
            view = LayoutInflater.from(this.f61683e).inflate(R.layout.layout_select_forum_item, (ViewGroup) null);
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
            aVar.b(this.f61684f.get(i));
        }
        return view;
    }
}
