package d.a.k0.h2;

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
    public PersonFriendActivity f55542f;
    public boolean j;
    public int k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f55541e = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55543g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55545i = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ProgressBar> f55544h = new ArrayList<>();

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f55546a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55547b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55548c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f55549d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f55550e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f55551f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f55552g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f55553h;

        public b(d dVar) {
        }
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f55542f = null;
        this.j = true;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.f55542f = personFriendActivity;
        this.j = z;
        this.k = i2;
        this.l = onClickListener;
        this.m = onClickListener2;
    }

    public final void a(View view) {
        this.f55542f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f55542f.getLayoutMode().j(view);
    }

    public void b() {
        this.f55545i = false;
        ArrayList<UserData> arrayList = this.f55541e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f55545i = true;
    }

    public void c() {
        if (this.f55544h != null) {
            for (int i2 = 0; i2 < this.f55544h.size(); i2++) {
                try {
                    this.f55544h.get(i2).setVisibility(8);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            this.f55544h.clear();
        }
    }

    public void d(ArrayList<UserData> arrayList) {
        this.f55541e = arrayList;
    }

    public void e(boolean z) {
        this.f55543g = z;
    }

    public void f(boolean z) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f55545i) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f55541e;
        int size = arrayList != null ? arrayList.size() : 0;
        return this.f55543g ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<UserData> arrayList = this.f55541e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f55541e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        ArrayList<UserData> arrayList = this.f55541e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f55545i) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f55541e;
        return (arrayList == null || i2 >= arrayList.size()) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (this.f55541e == null) {
            return view;
        }
        if (view == null) {
            bVar = new b();
            if (getItemViewType(i2) == 0) {
                view2 = LayoutInflater.from(this.f55542f.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.photo);
                bVar.f55546a = headImageView;
                headImageView.setIsRound(false);
                bVar.f55546a.setAutoChangeStyle(true);
                bVar.f55550e = (LinearLayout) view2.findViewById(R.id.info);
                bVar.f55547b = (TextView) view2.findViewById(R.id.name);
                bVar.f55552g = (TextView) view2.findViewById(R.id.at_list_nodata);
                bVar.f55548c = (TextView) view2.findViewById(R.id.intro);
                bVar.f55549d = (ImageView) view2.findViewById(R.id.chat);
                bVar.f55553h = (ImageView) view2.findViewById(R.id.diver_buttom_px);
                bVar.f55549d.setOnClickListener(this.l);
            } else {
                view2 = LayoutInflater.from(this.f55542f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                bVar.f55547b = (TextView) view2.findViewById(R.id.pb_more_text);
                view2.setOnClickListener(this.m);
                ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.progress);
                bVar.f55551f = progressBar;
                this.f55544h.add(progressBar);
            }
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i2) == 0) {
            if (this.f55545i) {
                bVar.f55550e.setVisibility(8);
                bVar.f55549d.setVisibility(8);
                bVar.f55552g.setVisibility(8);
                bVar.f55553h.setVisibility(8);
            } else {
                if (!this.j && this.k == 0) {
                    bVar.f55549d.setVisibility(8);
                } else {
                    bVar.f55549d.setVisibility(0);
                }
                bVar.f55550e.setVisibility(0);
                bVar.f55550e.setTag(Integer.valueOf(i2));
                bVar.f55553h.setVisibility(0);
                bVar.f55552g.setVisibility(8);
                String portrait = this.f55541e.get(i2).getPortrait();
                bVar.f55546a.setImageDrawable(null);
                bVar.f55546a.V(portrait, 12, false);
                bVar.f55547b.setText(this.f55541e.get(i2).getName_show());
                bVar.f55548c.setText(this.f55541e.get(i2).getIntro());
                bVar.f55549d.setTag(Integer.valueOf(i2));
            }
        } else {
            bVar.f55547b.setText(this.f55542f.getPageContext().getString(R.string.loading));
            bVar.f55551f.setVisibility(0);
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
        if (this.f55545i) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
