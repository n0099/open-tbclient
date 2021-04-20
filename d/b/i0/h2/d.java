package d.b.i0.h2;

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
/* loaded from: classes3.dex */
public class d extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public PersonFriendActivity f56499f;
    public boolean j;
    public int k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f56498e = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56500g = false;
    public boolean i = false;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ProgressBar> f56501h = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f56502a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56503b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56504c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f56505d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f56506e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f56507f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f56508g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f56509h;

        public b(d dVar) {
        }
    }

    public d(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f56499f = null;
        this.j = true;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.f56499f = personFriendActivity;
        this.j = z;
        this.k = i;
        this.l = onClickListener;
        this.m = onClickListener2;
    }

    public final void a(View view) {
        this.f56499f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f56499f.getLayoutMode().j(view);
    }

    public void b() {
        this.i = false;
        ArrayList<UserData> arrayList = this.f56498e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.i = true;
    }

    public void c() {
        if (this.f56501h != null) {
            for (int i = 0; i < this.f56501h.size(); i++) {
                try {
                    this.f56501h.get(i).setVisibility(8);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            this.f56501h.clear();
        }
    }

    public void d(ArrayList<UserData> arrayList) {
        this.f56498e = arrayList;
    }

    public void e(boolean z) {
        this.f56500g = z;
    }

    public void f(boolean z) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.i) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f56498e;
        int size = arrayList != null ? arrayList.size() : 0;
        return this.f56500g ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<UserData> arrayList = this.f56498e;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return this.f56498e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        ArrayList<UserData> arrayList = this.f56498e;
        if (arrayList == null || i >= arrayList.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.i) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f56498e;
        return (arrayList == null || i >= arrayList.size()) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (this.f56498e == null) {
            return view;
        }
        if (view == null) {
            bVar = new b();
            if (getItemViewType(i) == 0) {
                view2 = LayoutInflater.from(this.f56499f.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.photo);
                bVar.f56502a = headImageView;
                headImageView.setIsRound(false);
                bVar.f56502a.setAutoChangeStyle(true);
                bVar.f56506e = (LinearLayout) view2.findViewById(R.id.info);
                bVar.f56503b = (TextView) view2.findViewById(R.id.name);
                bVar.f56508g = (TextView) view2.findViewById(R.id.at_list_nodata);
                bVar.f56504c = (TextView) view2.findViewById(R.id.intro);
                bVar.f56505d = (ImageView) view2.findViewById(R.id.chat);
                bVar.f56509h = (ImageView) view2.findViewById(R.id.diver_buttom_px);
                bVar.f56505d.setOnClickListener(this.l);
            } else {
                view2 = LayoutInflater.from(this.f56499f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                bVar.f56503b = (TextView) view2.findViewById(R.id.pb_more_text);
                view2.setOnClickListener(this.m);
                ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.progress);
                bVar.f56507f = progressBar;
                this.f56501h.add(progressBar);
            }
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        if (getItemViewType(i) == 0) {
            if (this.i) {
                bVar.f56506e.setVisibility(8);
                bVar.f56505d.setVisibility(8);
                bVar.f56508g.setVisibility(8);
                bVar.f56509h.setVisibility(8);
            } else {
                if (!this.j && this.k == 0) {
                    bVar.f56505d.setVisibility(8);
                } else {
                    bVar.f56505d.setVisibility(0);
                }
                bVar.f56506e.setVisibility(0);
                bVar.f56506e.setTag(Integer.valueOf(i));
                bVar.f56509h.setVisibility(0);
                bVar.f56508g.setVisibility(8);
                String portrait = this.f56498e.get(i).getPortrait();
                bVar.f56502a.setImageDrawable(null);
                bVar.f56502a.W(portrait, 12, false);
                bVar.f56503b.setText(this.f56498e.get(i).getName_show());
                bVar.f56504c.setText(this.f56498e.get(i).getIntro());
                bVar.f56505d.setTag(Integer.valueOf(i));
            }
        } else {
            bVar.f56503b.setText(this.f56499f.getPageContext().getString(R.string.loading));
            bVar.f56507f.setVisibility(0);
        }
        a(view2);
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.i) {
            return false;
        }
        return super.isEnabled(i);
    }
}
