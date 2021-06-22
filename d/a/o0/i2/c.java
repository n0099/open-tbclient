package d.a.o0.i2;

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
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public PersonBarActivity f59529e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.i2.b f59530f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumData> f59531g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59532h = false;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f59533i = null;
    public boolean j = false;
    public boolean k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public String o;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f59534a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59535b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f59536c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59537d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59538e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f59539f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59540g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f59541h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f59542i;
        public Button j;
        public ImageView k;
        public ImageView l;
        public ImageView m;

        public b(c cVar) {
        }
    }

    public c(PersonBarActivity personBarActivity, d.a.o0.i2.b bVar, boolean z, boolean z2) {
        this.f59530f = null;
        this.k = true;
        this.l = false;
        this.m = true;
        this.f59529e = personBarActivity;
        this.f59530f = bVar;
        this.k = z;
        this.l = z2;
        this.m = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        this.f59529e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f59529e.getLayoutMode().j(view);
    }

    public void b() {
        this.j = false;
        ArrayList<ForumData> arrayList = this.f59531g;
        if (arrayList == null || arrayList.size() == 0) {
            this.j = true;
        }
    }

    public boolean c() {
        return this.f59532h;
    }

    public boolean d() {
        return this.j;
    }

    public void e(View.OnClickListener onClickListener) {
        this.f59533i = onClickListener;
    }

    public void f(boolean z) {
        this.f59532h = z;
        notifyDataSetChanged();
    }

    public void g(ArrayList<ForumData> arrayList) {
        this.f59531g = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.j) {
            return 1;
        }
        ArrayList<ForumData> arrayList = this.f59531g;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<ForumData> arrayList = this.f59531g;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f59531g.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        ForumData forumData;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.f59529e.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                bVar = new b();
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                bVar.f59534a = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.f59534a.setRadius(l.g(this.f59529e, R.dimen.tbds10));
                bVar.f59534a.setConrers(15);
                bVar.f59534a.setPlaceHolder(2);
                bVar.f59535b = (TextView) view.findViewById(R.id.name);
                bVar.f59536c = new StringBuffer(10);
                bVar.f59537d = (TextView) view.findViewById(R.id.degree);
                bVar.f59538e = (TextView) view.findViewById(R.id.degree_text);
                bVar.f59542i = (TextView) view.findViewById(R.id.experience);
                bVar.f59540g = (TextView) view.findViewById(R.id.experience_title);
                bVar.j = (Button) view.findViewById(R.id.item_delete);
                bVar.f59539f = (ImageView) view.findViewById(R.id.degree_text_ta);
                bVar.f59541h = (TextView) view.findViewById(R.id.intro_ta);
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
                bVar.f59537d.setVisibility(8);
                bVar.j.setVisibility(8);
                bVar.f59535b.setVisibility(8);
                bVar.f59534a.setVisibility(8);
                bVar.f59538e.setVisibility(8);
                bVar.f59542i.setVisibility(8);
                bVar.f59540g.setVisibility(8);
                bVar.f59539f.setVisibility(8);
                bVar.f59541h.setVisibility(8);
                bVar.k.setVisibility(8);
                bVar.l.setVisibility(8);
            } else {
                bVar.f59535b.setVisibility(0);
                bVar.f59534a.setVisibility(0);
                if (this.k) {
                    bVar.f59537d.setVisibility(8);
                    bVar.f59538e.setVisibility(8);
                    bVar.f59542i.setVisibility(0);
                    bVar.f59540g.setVisibility(0);
                    bVar.f59539f.setVisibility(0);
                    bVar.f59541h.setVisibility(8);
                    bVar.l.setVisibility(0);
                } else {
                    bVar.f59537d.setVisibility(8);
                    bVar.f59538e.setVisibility(8);
                    bVar.f59542i.setVisibility(8);
                    bVar.f59540g.setVisibility(8);
                    bVar.f59539f.setVisibility(0);
                    bVar.f59541h.setVisibility(0);
                    bVar.l.setVisibility(0);
                }
            }
            if (this.f59531g != null && i2 >= 0 && i2 < this.f59531g.size() && (forumData = this.f59531g.get(i2)) != null) {
                String image_url = forumData.getImage_url();
                bVar.f59534a.setTag(image_url);
                bVar.f59534a.setImageDrawable(null);
                bVar.f59534a.U(image_url, 10, false);
                bVar.f59536c.delete(0, bVar.f59536c.length());
                bVar.f59536c.append(forumData.getName());
                bVar.f59536c.append(this.f59529e.getPageContext().getString(R.string.forum));
                bVar.f59535b.setText(bVar.f59536c);
                if (this.k) {
                    SkinManager.setImageResource(bVar.f59539f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    bVar.f59542i.setText(String.format(this.f59529e.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    bVar.j.setOnClickListener(this.f59533i);
                    bVar.j.setTag(Integer.valueOf(i2));
                    if (i2 < this.f59530f.k()) {
                        bVar.f59535b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                        if (!this.l && this.m) {
                            bVar.k.setVisibility(0);
                            bVar.k.setTag(Integer.valueOf(i2));
                        }
                    } else {
                        bVar.f59535b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        bVar.k.setVisibility(8);
                    }
                    bVar.k.setOnClickListener(this.n);
                    bVar.m.setVisibility(8);
                    if (this.l && this.f59529e.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.o)) {
                        bVar.m.setVisibility(0);
                    }
                } else {
                    if ((this.f59529e.getCurrentPageType() == 0 && i2 < this.f59530f.k()) || (this.f59529e.getCurrentPageType() == 1 && i2 < this.f59530f.g())) {
                        bVar.f59535b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                    } else {
                        bVar.f59535b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (this.f59529e.getCurrentPageType() == 1) {
                        bVar.f59539f.setVisibility(8);
                    }
                    bVar.k.setVisibility(8);
                    SkinManager.setImageResource(bVar.f59539f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                    bVar.f59541h.setText(forumData.getSlogan());
                }
                if (this.f59532h) {
                    bVar.j.setVisibility(0);
                    bVar.k.setVisibility(8);
                } else {
                    bVar.j.setVisibility(8);
                    if (i2 < this.f59530f.k() && this.k && !this.l && this.m) {
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
    public boolean isEnabled(int i2) {
        if (this.j) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
