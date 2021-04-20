package d.b.i0.v3.r;

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
    public static int f63420g = 3;

    /* renamed from: e  reason: collision with root package name */
    public Context f63421e;

    /* renamed from: f  reason: collision with root package name */
    public List<TransmitForumData> f63422f = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63423a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f63424b;

        /* renamed from: c  reason: collision with root package name */
        public View f63425c;

        /* renamed from: d  reason: collision with root package name */
        public int f63426d = 3;

        public a(View view) {
            if (view == null) {
                return;
            }
            this.f63423a = (TextView) view.findViewById(R.id.transmit_forum_name);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f63424b = barImageView;
            barImageView.setShowOval(true);
            this.f63425c = view.findViewById(R.id.divider_line);
        }

        public void a() {
            if (b.f63420g != this.f63426d) {
                SkinManager.setViewTextColor(this.f63423a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f63425c, R.color.CAM_X0204);
            }
            this.f63426d = b.f63420g;
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.f63423a.setText(transmitForumData.forumName);
                this.f63424b.W(transmitForumData.avatar, 10, false);
            }
        }
    }

    public b(Context context) {
        this.f63421e = context;
    }

    public void b(List<TransmitForumData> list) {
        this.f63422f.clear();
        this.f63422f.addAll(list);
        notifyDataSetChanged();
    }

    public void c(int i) {
        if (f63420g != i) {
            notifyDataSetChanged();
        }
        f63420g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f63422f.size();
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
            view = LayoutInflater.from(this.f63421e).inflate(R.layout.layout_select_forum_item, (ViewGroup) null);
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
            aVar.b(this.f63422f.get(i));
        }
        return view;
    }
}
