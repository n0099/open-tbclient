package d.a.j0.h2;

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
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public PersonFriendActivity f54835f;
    public boolean j;
    public int k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f54834e = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54836g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54838i = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ProgressBar> f54837h = new ArrayList<>();

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f54839a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54840b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54841c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f54842d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f54843e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f54844f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f54845g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f54846h;

        public b(d dVar) {
        }
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f54835f = null;
        this.j = true;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.f54835f = personFriendActivity;
        this.j = z;
        this.k = i2;
        this.l = onClickListener;
        this.m = onClickListener2;
    }

    public final void a(View view) {
        this.f54835f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f54835f.getLayoutMode().j(view);
    }

    public void b() {
        this.f54838i = false;
        ArrayList<UserData> arrayList = this.f54834e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f54838i = true;
    }

    public void c() {
        if (this.f54837h != null) {
            for (int i2 = 0; i2 < this.f54837h.size(); i2++) {
                try {
                    this.f54837h.get(i2).setVisibility(8);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            this.f54837h.clear();
        }
    }

    public void d(ArrayList<UserData> arrayList) {
        this.f54834e = arrayList;
    }

    public void e(boolean z) {
        this.f54836g = z;
    }

    public void f(boolean z) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f54838i) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f54834e;
        int size = arrayList != null ? arrayList.size() : 0;
        return this.f54836g ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<UserData> arrayList = this.f54834e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f54834e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        ArrayList<UserData> arrayList = this.f54834e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f54838i) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f54834e;
        return (arrayList == null || i2 >= arrayList.size()) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (this.f54834e == null) {
            return view;
        }
        if (view == null) {
            bVar = new b();
            if (getItemViewType(i2) == 0) {
                view2 = LayoutInflater.from(this.f54835f.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.photo);
                bVar.f54839a = headImageView;
                headImageView.setIsRound(false);
                bVar.f54839a.setAutoChangeStyle(true);
                bVar.f54843e = (LinearLayout) view2.findViewById(R.id.info);
                bVar.f54840b = (TextView) view2.findViewById(R.id.name);
                bVar.f54845g = (TextView) view2.findViewById(R.id.at_list_nodata);
                bVar.f54841c = (TextView) view2.findViewById(R.id.intro);
                bVar.f54842d = (ImageView) view2.findViewById(R.id.chat);
                bVar.f54846h = (ImageView) view2.findViewById(R.id.diver_buttom_px);
                bVar.f54842d.setOnClickListener(this.l);
            } else {
                view2 = LayoutInflater.from(this.f54835f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                bVar.f54840b = (TextView) view2.findViewById(R.id.pb_more_text);
                view2.setOnClickListener(this.m);
                ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.progress);
                bVar.f54844f = progressBar;
                this.f54837h.add(progressBar);
            }
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i2) == 0) {
            if (this.f54838i) {
                bVar.f54843e.setVisibility(8);
                bVar.f54842d.setVisibility(8);
                bVar.f54845g.setVisibility(8);
                bVar.f54846h.setVisibility(8);
            } else {
                if (!this.j && this.k == 0) {
                    bVar.f54842d.setVisibility(8);
                } else {
                    bVar.f54842d.setVisibility(0);
                }
                bVar.f54843e.setVisibility(0);
                bVar.f54843e.setTag(Integer.valueOf(i2));
                bVar.f54846h.setVisibility(0);
                bVar.f54845g.setVisibility(8);
                String portrait = this.f54834e.get(i2).getPortrait();
                bVar.f54839a.setImageDrawable(null);
                bVar.f54839a.V(portrait, 12, false);
                bVar.f54840b.setText(this.f54834e.get(i2).getName_show());
                bVar.f54841c.setText(this.f54834e.get(i2).getIntro());
                bVar.f54842d.setTag(Integer.valueOf(i2));
            }
        } else {
            bVar.f54840b.setText(this.f54835f.getPageContext().getString(R.string.loading));
            bVar.f54844f.setVisibility(0);
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
        if (this.f54838i) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
