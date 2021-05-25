package d.a.n0.i2;

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
    public PersonFriendActivity f55730f;
    public boolean j;
    public int k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f55729e = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55731g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55733i = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ProgressBar> f55732h = new ArrayList<>();

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f55734a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55735b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55736c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f55737d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f55738e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f55739f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f55740g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f55741h;

        public b(d dVar) {
        }
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f55730f = null;
        this.j = true;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.f55730f = personFriendActivity;
        this.j = z;
        this.k = i2;
        this.l = onClickListener;
        this.m = onClickListener2;
    }

    public final void a(View view) {
        this.f55730f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f55730f.getLayoutMode().j(view);
    }

    public void b() {
        this.f55733i = false;
        ArrayList<UserData> arrayList = this.f55729e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f55733i = true;
    }

    public void c() {
        if (this.f55732h != null) {
            for (int i2 = 0; i2 < this.f55732h.size(); i2++) {
                try {
                    this.f55732h.get(i2).setVisibility(8);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            this.f55732h.clear();
        }
    }

    public void d(ArrayList<UserData> arrayList) {
        this.f55729e = arrayList;
    }

    public void e(boolean z) {
        this.f55731g = z;
    }

    public void f(boolean z) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f55733i) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f55729e;
        int size = arrayList != null ? arrayList.size() : 0;
        return this.f55731g ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<UserData> arrayList = this.f55729e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f55729e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        ArrayList<UserData> arrayList = this.f55729e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f55733i) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f55729e;
        return (arrayList == null || i2 >= arrayList.size()) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (this.f55729e == null) {
            return view;
        }
        if (view == null) {
            bVar = new b();
            if (getItemViewType(i2) == 0) {
                view2 = LayoutInflater.from(this.f55730f.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.photo);
                bVar.f55734a = headImageView;
                headImageView.setIsRound(false);
                bVar.f55734a.setAutoChangeStyle(true);
                bVar.f55738e = (LinearLayout) view2.findViewById(R.id.info);
                bVar.f55735b = (TextView) view2.findViewById(R.id.name);
                bVar.f55740g = (TextView) view2.findViewById(R.id.at_list_nodata);
                bVar.f55736c = (TextView) view2.findViewById(R.id.intro);
                bVar.f55737d = (ImageView) view2.findViewById(R.id.chat);
                bVar.f55741h = (ImageView) view2.findViewById(R.id.diver_buttom_px);
                bVar.f55737d.setOnClickListener(this.l);
            } else {
                view2 = LayoutInflater.from(this.f55730f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                bVar.f55735b = (TextView) view2.findViewById(R.id.pb_more_text);
                view2.setOnClickListener(this.m);
                ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.progress);
                bVar.f55739f = progressBar;
                this.f55732h.add(progressBar);
            }
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i2) == 0) {
            if (this.f55733i) {
                bVar.f55738e.setVisibility(8);
                bVar.f55737d.setVisibility(8);
                bVar.f55740g.setVisibility(8);
                bVar.f55741h.setVisibility(8);
            } else {
                if (!this.j && this.k == 0) {
                    bVar.f55737d.setVisibility(8);
                } else {
                    bVar.f55737d.setVisibility(0);
                }
                bVar.f55738e.setVisibility(0);
                bVar.f55738e.setTag(Integer.valueOf(i2));
                bVar.f55741h.setVisibility(0);
                bVar.f55740g.setVisibility(8);
                String portrait = this.f55729e.get(i2).getPortrait();
                bVar.f55734a.setImageDrawable(null);
                bVar.f55734a.V(portrait, 12, false);
                bVar.f55735b.setText(this.f55729e.get(i2).getName_show());
                bVar.f55736c.setText(this.f55729e.get(i2).getIntro());
                bVar.f55737d.setTag(Integer.valueOf(i2));
            }
        } else {
            bVar.f55735b.setText(this.f55730f.getPageContext().getString(R.string.loading));
            bVar.f55739f.setVisibility(0);
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
        if (this.f55733i) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
