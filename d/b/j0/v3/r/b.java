package d.b.j0.v3.r;

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
    public static int f63841g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f63842e;

    /* renamed from: f  reason: collision with root package name */
    public List<TransmitForumData> f63843f = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63844a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f63845b;

        /* renamed from: c  reason: collision with root package name */
        public View f63846c;

        /* renamed from: d  reason: collision with root package name */
        public int f63847d = 3;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f63844a = (TextView) view.findViewById(R.id.transmit_forum_name);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f63845b = barImageView;
            barImageView.setShowOval(true);
            this.f63846c = view.findViewById(R.id.divider_line);
        }

        public void a() {
            if (b.f63841g != this.f63847d) {
                SkinManager.setViewTextColor(this.f63844a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f63846c, R.color.CAM_X0204);
            }
            this.f63847d = b.f63841g;
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.f63844a.setText(transmitForumData.forumName);
                this.f63845b.W(transmitForumData.avatar, 10, false);
            }
        }
    }

    public b(Context context) {
        this.f63842e = context;
    }

    public void b(List<TransmitForumData> list) {
        this.f63843f.clear();
        this.f63843f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i) {
        if (f63841g != i) {
            notifyDataSetChanged();
        }
        f63841g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f63843f.size();
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
            view = LayoutInflater.from(this.f63842e).inflate(R.layout.layout_select_forum_item, (ViewGroup) null);
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
            aVar.b(this.f63843f.get(i));
        }
        return view;
    }
}
