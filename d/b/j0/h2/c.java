package d.b.j0.h2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonBarActivity;
import d.b.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public PersonBarActivity f56907e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.h2.b f56908f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumData> f56909g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56910h = false;
    public View.OnClickListener i = null;
    public boolean j = false;
    public boolean k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public String o;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f56911a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56912b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f56913c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f56914d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f56915e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f56916f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f56917g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f56918h;
        public TextView i;
        public Button j;
        public ImageView k;
        public ImageView l;
        public ImageView m;

        public b(c cVar) {
        }
    }

    public c(PersonBarActivity personBarActivity, d.b.j0.h2.b bVar, boolean z, boolean z2) {
        this.f56908f = null;
        this.k = true;
        this.l = false;
        this.m = true;
        this.f56907e = personBarActivity;
        this.f56908f = bVar;
        this.k = z;
        this.l = z2;
        this.m = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        this.f56907e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f56907e.getLayoutMode().j(view);
    }

    public void b() {
        this.j = false;
        ArrayList<ForumData> arrayList = this.f56909g;
        if (arrayList == null || arrayList.size() == 0) {
            this.j = true;
        }
    }

    public boolean c() {
        return this.f56910h;
    }

    public boolean d() {
        return this.j;
    }

    public void e(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void f(boolean z) {
        this.f56910h = z;
        notifyDataSetChanged();
    }

    public void g(ArrayList<ForumData> arrayList) {
        this.f56909g = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.j) {
            return 1;
        }
        ArrayList<ForumData> arrayList = this.f56909g;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<ForumData> arrayList = this.f56909g;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f56909g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        ForumData forumData;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.f56907e.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                bVar = new b();
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                bVar.f56911a = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.f56911a.setRadius(l.g(this.f56907e, R.dimen.tbds10));
                bVar.f56911a.setConrers(15);
                bVar.f56911a.setPlaceHolder(2);
                bVar.f56912b = (TextView) view.findViewById(R.id.name);
                bVar.f56913c = new StringBuffer(10);
                bVar.f56914d = (TextView) view.findViewById(R.id.degree);
                bVar.f56915e = (TextView) view.findViewById(R.id.degree_text);
                bVar.i = (TextView) view.findViewById(R.id.experience);
                bVar.f56917g = (TextView) view.findViewById(R.id.experience_title);
                bVar.j = (Button) view.findViewById(R.id.item_delete);
                bVar.f56916f = (ImageView) view.findViewById(R.id.degree_text_ta);
                bVar.f56918h = (TextView) view.findViewById(R.id.intro_ta);
                bVar.k = (ImageView) view.findViewById(R.id.item_talk);
                ImageView imageView = (ImageView) view.findViewById(R.id.diver_buttom_px);
                bVar.l = imageView;
                imageView.setVisibility(0);
                bVar.m = (ImageView) view.findViewById(R.id.item_selected);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (this.j) {
                bVar.f56914d.setVisibility(8);
                bVar.j.setVisibility(8);
                bVar.f56912b.setVisibility(8);
                bVar.f56911a.setVisibility(8);
                bVar.f56915e.setVisibility(8);
                bVar.i.setVisibility(8);
                bVar.f56917g.setVisibility(8);
                bVar.f56916f.setVisibility(8);
                bVar.f56918h.setVisibility(8);
                bVar.k.setVisibility(8);
                bVar.l.setVisibility(8);
            } else {
                bVar.f56912b.setVisibility(0);
                bVar.f56911a.setVisibility(0);
                if (this.k) {
                    bVar.f56914d.setVisibility(8);
                    bVar.f56915e.setVisibility(8);
                    bVar.i.setVisibility(0);
                    bVar.f56917g.setVisibility(0);
                    bVar.f56916f.setVisibility(0);
                    bVar.f56918h.setVisibility(8);
                    bVar.l.setVisibility(0);
                } else {
                    bVar.f56914d.setVisibility(8);
                    bVar.f56915e.setVisibility(8);
                    bVar.i.setVisibility(8);
                    bVar.f56917g.setVisibility(8);
                    bVar.f56916f.setVisibility(0);
                    bVar.f56918h.setVisibility(0);
                    bVar.l.setVisibility(0);
                }
            }
            if (this.f56909g != null && i >= 0 && i < this.f56909g.size() && (forumData = this.f56909g.get(i)) != null) {
                String image_url = forumData.getImage_url();
                bVar.f56911a.setTag(image_url);
                bVar.f56911a.setImageDrawable(null);
                bVar.f56911a.W(image_url, 10, false);
                bVar.f56913c.delete(0, bVar.f56913c.length());
                bVar.f56913c.append(forumData.getName());
                bVar.f56913c.append(this.f56907e.getPageContext().getString(R.string.forum));
                bVar.f56912b.setText(bVar.f56913c);
                if (this.k) {
                    SkinManager.setImageResource(bVar.f56916f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    bVar.i.setText(String.format(this.f56907e.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    bVar.j.setOnClickListener(this.i);
                    bVar.j.setTag(Integer.valueOf(i));
                    if (i < this.f56908f.k()) {
                        bVar.f56912b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.l && this.m) {
                            bVar.k.setVisibility(0);
                            bVar.k.setTag(Integer.valueOf(i));
                        }
                    } else {
                        bVar.f56912b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        bVar.k.setVisibility(8);
                    }
                    bVar.k.setOnClickListener(this.n);
                    bVar.m.setVisibility(8);
                    if (this.l && this.f56907e.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.o)) {
                        bVar.m.setVisibility(0);
                    }
                } else {
                    if ((this.f56907e.getCurrentPageType() == 0 && i < this.f56908f.k()) || (this.f56907e.getCurrentPageType() == 1 && i < this.f56908f.g())) {
                        bVar.f56912b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        bVar.f56912b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.f56907e.getCurrentPageType() == 1) {
                        bVar.f56916f.setVisibility(8);
                    }
                    bVar.k.setVisibility(8);
                    SkinManager.setImageResource(bVar.f56916f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    bVar.f56918h.setText(forumData.getSlogan());
                }
                if (this.f56910h) {
                    bVar.j.setVisibility(0);
                    bVar.k.setVisibility(8);
                } else {
                    bVar.j.setVisibility(8);
                    if (i < this.f56908f.k() && this.k && !this.l && this.m) {
                        bVar.k.setVisibility(0);
                    } else {
                        bVar.k.setVisibility(8);
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        a(view);
        return view;
    }

    public void h(String str) {
        this.o = str;
    }

    public void i(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.j) {
            return false;
        }
        return super.isEnabled(i);
    }
}
