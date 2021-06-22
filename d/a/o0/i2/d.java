package d.a.o0.i2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonFriendActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public PersonFriendActivity f59544f;
    public boolean j;
    public int k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f59543e = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59545g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59547i = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ProgressBar> f59546h = new ArrayList<>();

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f59548a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59549b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59550c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f59551d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f59552e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f59553f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59554g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f59555h;

        public b(d dVar) {
        }
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f59544f = null;
        this.j = true;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.f59544f = personFriendActivity;
        this.j = z;
        this.k = i2;
        this.l = onClickListener;
        this.m = onClickListener2;
    }

    public final void a(View view) {
        this.f59544f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f59544f.getLayoutMode().j(view);
    }

    public void b() {
        this.f59547i = false;
        ArrayList<UserData> arrayList = this.f59543e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f59547i = true;
    }

    public void c() {
        if (this.f59546h != null) {
            for (int i2 = 0; i2 < this.f59546h.size(); i2++) {
                try {
                    this.f59546h.get(i2).setVisibility(8);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            this.f59546h.clear();
        }
    }

    public void d(ArrayList<UserData> arrayList) {
        this.f59543e = arrayList;
    }

    public void e(boolean z) {
        this.f59545g = z;
    }

    public void f(boolean z) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f59547i) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f59543e;
        int size = arrayList != null ? arrayList.size() : 0;
        return this.f59545g ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<UserData> arrayList = this.f59543e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f59543e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        ArrayList<UserData> arrayList = this.f59543e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f59547i) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f59543e;
        return (arrayList == null || i2 >= arrayList.size()) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (this.f59543e == null) {
            return view;
        }
        if (view == null) {
            bVar = new b();
            if (getItemViewType(i2) == 0) {
                view2 = LayoutInflater.from(this.f59544f.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.photo);
                bVar.f59548a = headImageView;
                headImageView.setIsRound(false);
                bVar.f59548a.setAutoChangeStyle(true);
                bVar.f59552e = (LinearLayout) view2.findViewById(R.id.info);
                bVar.f59549b = (TextView) view2.findViewById(R.id.name);
                bVar.f59554g = (TextView) view2.findViewById(R.id.at_list_nodata);
                bVar.f59550c = (TextView) view2.findViewById(R.id.intro);
                bVar.f59551d = (ImageView) view2.findViewById(R.id.chat);
                bVar.f59555h = (ImageView) view2.findViewById(R.id.diver_buttom_px);
                bVar.f59551d.setOnClickListener(this.l);
            } else {
                view2 = LayoutInflater.from(this.f59544f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                bVar.f59549b = (TextView) view2.findViewById(R.id.pb_more_text);
                view2.setOnClickListener(this.m);
                ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.progress);
                bVar.f59553f = progressBar;
                this.f59546h.add(progressBar);
            }
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i2) == 0) {
            if (this.f59547i) {
                bVar.f59552e.setVisibility(8);
                bVar.f59551d.setVisibility(8);
                bVar.f59554g.setVisibility(8);
                bVar.f59555h.setVisibility(8);
            } else {
                if (!this.j && this.k == 0) {
                    bVar.f59551d.setVisibility(8);
                } else {
                    bVar.f59551d.setVisibility(0);
                }
                bVar.f59552e.setVisibility(0);
                bVar.f59552e.setTag(Integer.valueOf(i2));
                bVar.f59555h.setVisibility(0);
                bVar.f59554g.setVisibility(8);
                String portrait = this.f59543e.get(i2).getPortrait();
                bVar.f59548a.setImageDrawable(null);
                bVar.f59548a.U(portrait, 12, false);
                bVar.f59549b.setText(this.f59543e.get(i2).getName_show());
                bVar.f59550c.setText(this.f59543e.get(i2).getIntro());
                bVar.f59551d.setTag(Integer.valueOf(i2));
            }
        } else {
            bVar.f59549b.setText(this.f59544f.getPageContext().getString(R.string.loading));
            bVar.f59553f.setVisibility(0);
        }
        a(view2);
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        if (this.f59547i) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
